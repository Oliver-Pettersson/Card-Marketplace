package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.slf4j.Logger;

public class CardMarketOfferServiceImpl extends AbstractEntityServiceImpl<CardMarketOffer> implements CardMarketOfferService {
    public CardMarketOfferServiceImpl(AbstractEntityRepository<CardMarketOffer> repository, Logger logger) {
        super(repository, logger);
    }
}
