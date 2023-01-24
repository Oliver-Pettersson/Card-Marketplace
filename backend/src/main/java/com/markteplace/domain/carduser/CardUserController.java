package com.markteplace.domain.carduser;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtransaction.dto.CardTransactionDTO;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
