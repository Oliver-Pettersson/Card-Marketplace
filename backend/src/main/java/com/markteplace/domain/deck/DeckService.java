package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.domain.deck.dto.CreateDeckDTO;

public interface DeckService extends AbstractEntityService<Deck> {
    Deck create(CreateDeckDTO entity);
}
