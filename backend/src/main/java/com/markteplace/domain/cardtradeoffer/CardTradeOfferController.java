package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtradeoffer.dto.CardTradeOfferDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-trade-offer")
public class CardTradeOfferController extends AbstractEntityController<CardTradeOffer, CardTradeOfferDTO> {
    public CardTradeOfferController(AbstractEntityService<CardTradeOffer> service, DTOMapper<CardTradeOffer, CardTradeOfferDTO> mapper) {
        super(service, mapper);
    }
}
