package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.error.InvalidStringException;
import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.user.User;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardMarketOfferServiceImpl extends AbstractEntityServiceImpl<CardMarketOffer> implements  CardMarketOfferService {
    private CardUserService cardUserService;

    public CardMarketOfferServiceImpl(AbstractEntityRepository<CardMarketOffer> repository, Logger logger, CardUserService cardUserService) {
        super(repository, logger);
        this.cardUserService = cardUserService;
    }

    @Override
    public CardMarketOffer create(CardMarketOffer entity) {
        if(cardUserService.findByValue(entity.getCard()) == null)
            throw new InvalidStringException("User does not own card");

        entity.setCardTransaction(null);
        entity.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        entity.setTransactionTimestamp(LocalDateTime.now());

        return super.create(entity);
    }
}
