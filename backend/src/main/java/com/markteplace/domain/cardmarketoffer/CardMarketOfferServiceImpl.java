package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.error.InvalidStringException;
import com.markteplace.core.error.NotFoundException;
import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.cardtransaction.CardTransactionService;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.user.User;
import com.markteplace.domain.user.UserService;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class CardMarketOfferServiceImpl extends AbstractEntityServiceImpl<CardMarketOffer> implements CardMarketOfferService {
    private CardUserService cardUserService;
    private UserService userService;
    private CardTransactionService cardTransactionService;

    public CardMarketOfferServiceImpl(AbstractEntityRepository<CardMarketOffer> repository, Logger logger,
                                      CardUserService cardUserService, UserService userService,
                                      CardTransactionService cardTransactionService) {
        super(repository, logger);
        this.cardUserService = cardUserService;
        this.userService = userService;
        this.cardTransactionService = cardTransactionService;
    }

    @Override
    public CardMarketOffer create(CardMarketOffer entity) {
        if (cardUserService.findByValue(entity.getCard()) == null)
            throw new InvalidStringException("User does not own card");

        entity.setCardTransaction(null);
        entity.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        entity.setTransactionTimestamp(LocalDateTime.now());

        return super.create(entity);
    }

    @Override
    public Collection<CardMarketOffer> getOpenTradeOffers() {
        return ((CardMarketOfferRepository) repository).findAllByCardTransactionIsNull();
    }

    @Override
    public CardMarketOffer acceptOffer(String offerId) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CardMarketOffer cardMarketOffer = findById(offerId);

        if (cardMarketOffer.getCardTransaction() != null) throw new NotFoundException("transaction is already finished");
        if (currentUser.getCoins() < cardMarketOffer.getPrice()) throw new NotFoundException("not enough cash");

        CardUser card = cardUserService.findCardUserByUserAndCard(cardMarketOffer.getUser().getId().toString(),
                cardMarketOffer.getCard().getId().toString());
        if (card == null) throw new NotFoundException("User does not have the card");

        try {
            cardMarketOffer.setCardTransaction(cardTransactionService.save(new CardTransaction(currentUser, LocalDateTime.now())));

            userService.updateById(card.getUser().getId().toString(),
                    card.getUser().setCoins(card.getUser().getCoins() + cardMarketOffer.getPrice()));
            cardUserService.updateById(card.getId().toString(), card.setUser(currentUser));
            userService.updateById(currentUser.getId().toString(),
                    currentUser.setCoins(currentUser.getCoins() - cardMarketOffer.getPrice()));
            updateById(cardMarketOffer.getId().toString(), cardMarketOffer);
        } catch (Exception ignored) {
        }

        return cardMarketOffer;
    }
}
