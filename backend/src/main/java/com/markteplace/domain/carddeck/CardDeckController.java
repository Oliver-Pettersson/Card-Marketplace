package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carddeck.dto.CardDeckDTO;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-market-offer")
public class CardDeckController extends AbstractEntityController<CardDeck, CardDeckDTO> {
    public CardDeckController(AbstractEntityService<CardDeck> service, DTOMapper<CardDeck, CardDeckDTO> mapper) {
        super(service, mapper);
    }
}
