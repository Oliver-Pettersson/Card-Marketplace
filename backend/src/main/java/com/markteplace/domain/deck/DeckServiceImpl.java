package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.deck.dto.CreateDeckDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DeckServiceImpl extends AbstractEntityServiceImpl<Deck> implements DeckService {
    @Autowired
    private CardUserService cardUserService;

    public DeckServiceImpl(AbstractEntityRepository<Deck> repository, Logger logger) {
        super(repository, logger);
    }

    public Deck create(CreateDeckDTO entity) {
        return create(new Deck(entity.getName(), entity
                .getCards()
                .stream()
                .map(id -> cardUserService.findById(id)).toList()));
    }
}
