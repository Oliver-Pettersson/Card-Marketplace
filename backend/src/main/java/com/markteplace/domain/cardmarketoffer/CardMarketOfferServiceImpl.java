package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CardMarketOfferServiceImpl extends AbstractEntityServiceImpl<CardMarketOffer> implements  CardMarketOfferService {
    public CardMarketOfferServiceImpl(AbstractEntityRepository<CardMarketOffer> repository, Logger logger) {
        super(repository, logger);
    }
}
