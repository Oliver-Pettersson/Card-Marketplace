package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends AbstractEntityServiceImpl<Card> implements CardService {
    public CardServiceImpl(AbstractEntityRepository<Card> repository, Logger logger) {
        super(repository, logger);
    }
}
