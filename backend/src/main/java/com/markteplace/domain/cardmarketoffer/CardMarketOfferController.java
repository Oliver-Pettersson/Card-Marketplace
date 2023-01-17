package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardmarketoffer.dto.CardMarketOfferDTO;
import com.markteplace.domain.cardtradeoffer.CardTradeOffer;
import com.markteplace.domain.cardtradeoffer.CardTradeOfferService;
import com.markteplace.domain.cardtradeoffer.dto.CardTradeOfferDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/card-market-offer")
public class CardMarketOfferController extends AbstractEntityController<CardMarketOffer, CardMarketOfferDTO> {
    public CardMarketOfferController(AbstractEntityService<CardMarketOffer> service, DTOMapper<CardMarketOffer, CardMarketOfferDTO> mapper) {
        super(service, mapper);
    }

    @GetMapping("/open-offers")
    public ResponseEntity<Collection<CardMarketOfferDTO>> openOffers() {
        Collection<CardMarketOffer> dms = ((CardMarketOfferService) service).getOpenTradeOffers();

        return new ResponseEntity<>(mapper.toDTOs(dms), HttpStatus.OK);
    }

    @PostMapping("/accept/{id}")
    public ResponseEntity<CardMarketOfferDTO> acceptOffer(String offerId) {
        CardMarketOffer dms = ((CardMarketOfferService) service).acceptOffer(offerId);

        return new ResponseEntity<>(mapper.toDTO(dms), HttpStatus.OK);
    }
}
