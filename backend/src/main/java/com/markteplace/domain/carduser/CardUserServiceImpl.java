package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;

public class CardUserServiceImpl extends AbstractEntityServiceImpl<CardUser> implements CardUserService{
    public CardUserServiceImpl(AbstractEntityRepository<CardUser> repository, Logger logger) {
        super(repository, logger);
    }
}
