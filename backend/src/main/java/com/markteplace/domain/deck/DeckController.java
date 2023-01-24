package com.markteplace.domain.deck;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.deck.dto.DeckDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deck")
public class DeckController extends AbstractEntityController<Deck, DeckDTO> {
    public DeckController(AbstractEntityService<Deck> service, DTOMapper<Deck, DeckDTO> mapper) {
        super(service, mapper);
    }

    /**
     * Since it should not be possible to update decks this method is "disabled"
     *
     * @return always null
     */
    @Override
    @PutMapping("/not-available")
    public ResponseEntity<DeckDTO> updateById(@PathVariable String ignore, @RequestBody DeckDTO dto) throws UsernameAlreadyExistsException {
        return null;
    }
}
