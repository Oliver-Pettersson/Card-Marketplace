package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import com.markteplace.domain.user.User;

import java.util.Collection;

public interface CardService extends AbstractEntityService<Card> {
    Collection<Card> getCardCollectionFromCurrentUser(User user);
}
