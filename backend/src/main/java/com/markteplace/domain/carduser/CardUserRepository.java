package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CardUserRepository extends AbstractEntityRepository<CardUser> {
    CardUser findByUserAndCard(User user, Card card);
}
