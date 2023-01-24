package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.domain.cardtradeoffer.CardTradeOffer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardMarketOfferRepository extends AbstractEntityRepository<CardMarketOffer> {
    List<CardMarketOffer> findAllByCardTransactionIsNull();
}
