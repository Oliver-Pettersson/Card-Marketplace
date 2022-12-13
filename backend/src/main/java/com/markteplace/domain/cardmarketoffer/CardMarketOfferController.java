package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardmarketoffer.dto.CardMarketOfferDTO;

public class CardMarketOfferController extends AbstractEntityController<CardMarketOffer, CardMarketOfferDTO> {
    public CardMarketOfferController(AbstractEntityService<CardMarketOffer> service, DTOMapper<CardMarketOffer, CardMarketOfferDTO> mapper) {
        super(service, mapper);
    }
}
