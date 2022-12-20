package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CardDeckRepository extends AbstractEntityRepository<CardDeck> {
}
