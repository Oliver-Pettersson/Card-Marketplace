package com.markteplace.domain.cardtransaction;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtransaction.dto.CardTransactionDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-transaction")
public class CardTransactionController extends AbstractEntityController<CardTransaction, CardTransactionDTO> {
    public CardTransactionController(AbstractEntityService<CardTransaction> service, DTOMapper<CardTransaction, CardTransactionDTO> mapper) {
        super(service, mapper);
    }
}
