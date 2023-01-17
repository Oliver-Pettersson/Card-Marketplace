package com.markteplace.domain.card;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.dto.CardDTO;
import com.markteplace.domain.user.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController extends AbstractEntityController<Card, CardDTO> {
    public CardController(AbstractEntityService<Card> service, DTOMapper<Card, CardDTO> mapper) {
        super(service, mapper);
    }

    /**
     * Since it should not be possible to create new cards this method is "disabled"
     *
     * @return always null
     */
    @Override
    @GetMapping("/not-available")
    public ResponseEntity<CardDTO> create(@RequestBody CardDTO dto) {
        return null;
    }

    /**
     * Since it should not be possible to update cards this method is "disabled"
     *
     * @return always null
     */
    @Override
    @PutMapping("/not-available")
    public ResponseEntity<CardDTO> updateById(@PathVariable String ignore, @RequestBody CardDTO dto) throws UsernameAlreadyExistsException {
        return null;
    }

    /**
     * Since it should not be possible to delete cards this method is "disabled"
     *
     * @return always null
     */
    @Override
    @DeleteMapping("/not-available")
    public ResponseEntity<Void> deleteById(@PathVariable String ignore) {
        return null;
    }
}