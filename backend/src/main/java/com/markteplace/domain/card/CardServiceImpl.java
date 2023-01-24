package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.user.User;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl extends AbstractEntityServiceImpl<Card> implements CardService {
    private CardUserService cardUserService;
    public CardServiceImpl(AbstractEntityRepository<Card> repository, Logger logger, CardUserService cardUserService) {
        super(repository, logger);
        this.cardUserService =  cardUserService;
    }

    @Override
    public Collection<Card> getCardCollectionFromCurrentUser(User user) {
        return cardUserService.findAllCardUserByUser(user).stream().map(CardUser::getCard)
                .collect(Collectors.toList());
    }
}
