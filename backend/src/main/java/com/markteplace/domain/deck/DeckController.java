package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.deck.dto.CreateDeckDTO;
import com.markteplace.domain.deck.dto.DeckDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deck")
public class DeckController extends AbstractEntityController<Deck, DeckDTO> {
    private DeckService deckService;
    public DeckController(DeckService service, DTOMapper<Deck, DeckDTO> mapper) {
        super(service, mapper);
        this.deckService = service;
    }

    @PostMapping("/")
    public ResponseEntity<DeckDTO> create(CreateDeckDTO dto) {
        deckService.create(dto);
        return ResponseEntity.ok(null);
    }
}
