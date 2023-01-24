package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.domain.card.CardService;
import com.markteplace.domain.user.UserService;
import org.slf4j.Logger;

public class CardUserServiceImplBuilder {
    private AbstractEntityRepository<CardUser> repository;
    private Logger logger;
    private CardService cardService;
    private UserService userService;

    public CardUserServiceImplBuilder setRepository(AbstractEntityRepository<CardUser> repository) {
        this.repository = repository;
        return this;
    }

    public CardUserServiceImplBuilder setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public CardUserServiceImplBuilder setCardService(CardService cardService) {
        this.cardService = cardService;
        return this;
    }

    public CardUserServiceImplBuilder setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    public CardUserServiceImpl createCardUserServiceImpl() {
        return new CardUserServiceImpl(repository, logger, cardService, userService);
    }
}