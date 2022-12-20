package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CardTradeOfferServiceImpl extends AbstractEntityServiceImpl<CardTradeOffer> implements CardTradeOfferService {
    public CardTradeOfferServiceImpl(AbstractEntityRepository<CardTradeOffer> repository, Logger logger) {
        super(repository, logger);
    }
}
