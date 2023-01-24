package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.generic.AbstractEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTradeOfferRepository extends AbstractEntityRepository<CardTradeOffer> {
    List<CardTradeOffer> findAllByCardTransactionIsNull();
}
