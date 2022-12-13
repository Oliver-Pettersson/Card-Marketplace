package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carddeck.dto.CardMarketOfferDTO;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;

public class CardMarketOfferController extends AbstractEntityController<CardMarketOffer, CardMarketOfferDTO> {
    public CardMarketOfferController(AbstractEntityService<CardMarketOffer> service, DTOMapper<CardMarketOffer, CardMarketOfferDTO> mapper) {
        super(service, mapper);
    }
}
