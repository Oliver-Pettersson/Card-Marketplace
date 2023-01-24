package com.markteplace.domain.cardtransaction;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.dto.CardDTO;
import com.markteplace.domain.cardtransaction.dto.CardTransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-transaction")
public class CardTransactionController extends AbstractEntityController<CardTransaction, CardTransactionDTO> {
    public CardTransactionController(AbstractEntityService<CardTransaction> service, DTOMapper<CardTransaction, CardTransactionDTO> mapper) {
        super(service, mapper);
    }

    /**
     * Since it should not be possible to create new card transactions this method is "disabled"
     *
     * @return always null
     */
    @Override
    @GetMapping("/not-available")
    public ResponseEntity<CardTransactionDTO> create(@RequestBody CardTransactionDTO dto) {
        return null;
    }

    /**
     * Since it should not be possible to update card transactions this method is "disabled"
     *
     * @return always null
     */
    @Override
    @PutMapping("/not-available")
    public ResponseEntity<CardTransactionDTO> updateById(@PathVariable String ignore, @RequestBody CardTransactionDTO dto) throws UsernameAlreadyExistsException {
        return null;
    }

    /**
     * Since it should not be possible to delete card transactions this method is "disabled"
     *
     * @return always null
     */
    @Override
    @DeleteMapping("/not-available")
    public ResponseEntity<Void> deleteById(@PathVariable String ignore) {
        return null;
    }
}
