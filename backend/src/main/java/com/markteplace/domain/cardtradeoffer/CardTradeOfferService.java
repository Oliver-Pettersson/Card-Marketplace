package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.domain.carduser.CardUser;

import java.util.Collection;

public interface CardTradeOfferService extends AbstractEntityService<CardTradeOffer> {
    Collection<CardTradeOffer> getOpenTradeOffers();
}
