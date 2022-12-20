package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends AbstractEntityRepository<Card> {
}
