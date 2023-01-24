package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.domain.carduser.dto.CardCollectionFromUserDTO;
import com.markteplace.domain.user.User;

import java.util.Collection;

public interface CardUserService extends AbstractEntityService<CardUser> {
     Collection<CardUser> boosterPack();
     CardUser findCardUserByUserAndCard(String userId, String cardId);
     Collection<CardCollectionFromUserDTO> getCurrentUserCollection(User user);
     Collection<CardUser> findAllCardUserByUser(User user);
}
