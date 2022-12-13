package com.markteplace.domain.cardstats;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;

public class CardStatsServiceImpl extends AbstractEntityServiceImpl<CardStats> implements CardStatsService {
    public CardStatsServiceImpl(AbstractEntityRepository<CardStats> repository, Logger logger) {
        super(repository, logger);
    }
}
