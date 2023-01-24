package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntityService;

import java.util.Collection;

public interface CardMarketOfferService extends AbstractEntityService<CardMarketOffer> {
    Collection<CardMarketOffer> getOpenTradeOffers();
    CardMarketOffer acceptOffer(String offerId);
}
