package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CardDeckServiceImpl extends AbstractEntityServiceImpl<CardDeck> implements CardDeckService {
    public CardDeckServiceImpl(AbstractEntityRepository<CardDeck> repository, Logger logger) {
        super(repository, logger);
    }
}
