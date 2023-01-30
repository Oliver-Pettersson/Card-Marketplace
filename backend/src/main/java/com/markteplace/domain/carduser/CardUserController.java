package com.markteplace.domain.carduser;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtransaction.dto.CardTransactionDTO;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markteplace.domain.carduser.dto.CardCollectionFromUserDTO;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import com.markteplace.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/card-user")
public class CardUserController extends AbstractEntityController<CardUser, CardUserDTO> {
    public CardUserController(AbstractEntityService<CardUser> service, DTOMapper<CardUser, CardUserDTO> mapper) {
        super(service, mapper);
    }


    /**
     * Since it should not be possible to create new card users this method is "disabled"
     *
     * @return always null
     */
    @Override
    @GetMapping("/not-available")
    public ResponseEntity<CardUserDTO> create(@RequestBody CardUserDTO dto) {
        return null;
    }

    /**
     * Since it should not be possible to update card users this method is "disabled"
     *
     * @return always null
     */
    @Override
    @PutMapping("/not-available")
    public ResponseEntity<CardUserDTO> updateById(@PathVariable String ignore, @RequestBody CardUserDTO dto) throws UsernameAlreadyExistsException {
        return null;
    }

    /**
     * Since it should not be possible to delete card users this method is "disabled"
     *
     * @return always null
     */
    @Override
    @DeleteMapping("/not-available")
    public ResponseEntity<Void> deleteById(@PathVariable String ignore) {
        return null;
    }
    @GetMapping("/pack")
    public ResponseEntity<Collection<CardUserDTO>> findAll() throws UsernameAlreadyExistsException {
        Collection<CardUser> dms = ((CardUserService) service).boosterPack();

        return new ResponseEntity<>(mapper.toDTOs(dms), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Collection<CardCollectionFromUserDTO>> findById() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<CardCollectionFromUserDTO> dm = ((CardUserService) service).getCurrentUserCollection(user);

        return new ResponseEntity<>(dm, HttpStatus.OK);
    }
}
