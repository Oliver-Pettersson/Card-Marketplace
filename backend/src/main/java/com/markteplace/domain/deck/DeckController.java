package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.deck.dto.DeckDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deck")
public class DeckController extends AbstractEntityController<Deck, DeckDTO> {

    public DeckController(AbstractEntityService<Deck> service, DTOMapper<Deck, DeckDTO> mapper) {
        super(service, mapper);
    }
}
