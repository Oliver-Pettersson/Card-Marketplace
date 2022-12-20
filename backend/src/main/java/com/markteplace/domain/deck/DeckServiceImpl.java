package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl extends AbstractEntityServiceImpl<Deck> implements DeckService  {

    public DeckServiceImpl(AbstractEntityRepository<Deck> repository, Logger logger) {
        super(repository, logger);
    }
}
