package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.dto.CardDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-market-offer")
public class CardController extends AbstractEntityController<Card, CardDTO> {
    public CardController(AbstractEntityService<Card> service, DTOMapper<Card, CardDTO> mapper) {
        super(service, mapper);
    }
}
