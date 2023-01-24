package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.error.InvalidStringException;
import com.markteplace.core.error.NotFoundException;
import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.card.CardService;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.cardtransaction.CardTransactionService;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.user.User;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class CardTradeOfferServiceImpl extends AbstractEntityServiceImpl<CardTradeOffer> implements CardTradeOfferService {
    private CardUserService cardUserService;
    private CardService cardService;
    private CardTransactionService cardTransactionService;

    public CardTradeOfferServiceImpl(AbstractEntityRepository<CardTradeOffer> repository, Logger logger,
                                     CardUserService cardUserService, CardService cardService,
                                     CardTransactionService cardTransactionService) {
        super(repository, logger);
        this.cardUserService = cardUserService;
        this.cardService = cardService;
        this.cardTransactionService = cardTransactionService;
    }

    @Override
    public CardTradeOffer create(CardTradeOffer entity) {
        if (cardService.findByValue(entity.getOfferCardUser().getCard()) == null ||
                cardService.findByValue(entity.getAccepterCardUser().getCard()) == null)
            throw new InvalidStringException("User does not own card");

        entity.setCardTransaction(null);
        entity.setAccepterCardUser(null);
        entity.setOfferTimestamp(LocalDateTime.now());
        entity.setOfferUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return super.create(entity);
    }

    @Override
    public Collection<CardTradeOffer> getOpenTradeOffers() {
        return ((CardTradeOfferRepository) repository).findAllByCardTransactionIsNull();
    }

    @Override
    public CardTradeOffer acceptOffer(String offerId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CardTradeOffer cardTradeOffer = findById(offerId);

        if (cardTradeOffer.getCardTransaction() != null) throw new NotFoundException("transaction is already finished");

        CardUser cardFromOfferCreator = cardUserService.findCardUserByUserAndCard(cardTradeOffer.getOfferUser().getId().toString(), cardTradeOffer.getOfferCardUser().getId().toString());
        if (cardFromOfferCreator == null)
            throw new NotFoundException("User does not have the card");

        CardUser cardFromCurrentUser = cardUserService.findCardUserByUserAndCard(user.getId().toString(), cardTradeOffer.getAccepterCardUser().getId().toString());
        if (cardFromCurrentUser == null)
            throw new NotFoundException("User does not have the card");

        cardTradeOffer.setCardTransaction(cardTransactionService.save(new CardTransaction(user, LocalDateTime.now())));

        try {
            cardUserService.updateById(cardFromCurrentUser.getId().toString(), cardFromCurrentUser.setUser(cardFromOfferCreator.getUser()));
            cardUserService.updateById(cardFromOfferCreator.getId().toString(), cardFromOfferCreator.setUser(user));
            updateById(cardTradeOffer.getId().toString(), cardTradeOffer);
        } catch (Exception ignored) {
        }

        return cardTradeOffer;
    }
}
