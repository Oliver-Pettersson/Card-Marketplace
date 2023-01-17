package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityService;

import java.util.Collection;

public interface CardUserService extends AbstractEntityService<CardUser> {
     Collection<CardUser> boosterPack();
     CardUser findCardFromUser(String userId, String cardId);
}
