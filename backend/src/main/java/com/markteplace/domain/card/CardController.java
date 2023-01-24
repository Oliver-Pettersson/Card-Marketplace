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
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.carduser.dto.CardCollectionFromUserDTO;
import com.markteplace.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    @GetMapping("/")
    public ResponseEntity<Collection<CardDTO>> findById() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<Card> dm = ((CardService) service).getCardCollectionFromCurrentUser(user);

        return new ResponseEntity<>(mapper.toDTOs(dm), HttpStatus.OK);
    }
}
