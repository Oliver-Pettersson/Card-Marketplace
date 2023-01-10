package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.error.InvalidStringException;
import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.user.User;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardTradeOfferServiceImpl extends AbstractEntityServiceImpl<CardTradeOffer> implements CardTradeOfferService {
    private CardUserService cardUserService;

    public CardTradeOfferServiceImpl(AbstractEntityRepository<CardTradeOffer> repository, Logger logger, CardUserService cardUserService) {
        super(repository, logger);
        this.cardUserService = cardUserService;
    }

    @Override
    public CardTradeOffer create(CardTradeOffer entity) {
        if(cardUserService.findByValue(entity.getOfferCardUser()) == null ||
                cardUserService.findByValue(entity.getAccepterCardUser())== null)
            throw new InvalidStringException("User does not own card");

        entity.setCardTransaction(null);
        entity.setOfferTimestamp(LocalDateTime.now());
        entity.setOfferUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return super.create(entity);
    }
}
