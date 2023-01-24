package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.dto.CardDTO;
import com.markteplace.domain.cardtradeoffer.dto.CardTradeOfferDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.carduser.CardUserService;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/card-trade-offer")
public class CardTradeOfferController extends AbstractEntityController<CardTradeOffer, CardTradeOfferDTO> {
    public CardTradeOfferController(AbstractEntityService<CardTradeOffer> service, DTOMapper<CardTradeOffer, CardTradeOfferDTO> mapper) {
        super(service, mapper);
    }

    /**
     * Since it should not be possible to update card trade offers this method is "disabled"
     *
     * @return always null
     */
    @Override
    @PutMapping("/not-available")
    public ResponseEntity<CardTradeOfferDTO> updateById(@PathVariable String ignore, @RequestBody CardTradeOfferDTO dto) throws UsernameAlreadyExistsException {
        return null;
    }
    @GetMapping("/open-offers")
    public ResponseEntity<Collection<CardTradeOfferDTO>> openOffers() {
        Collection<CardTradeOffer> dms = ((CardTradeOfferService) service).getOpenTradeOffers();

        return new ResponseEntity<>(mapper.toDTOs(dms), HttpStatus.OK);
    }

    @PostMapping("/accept/{id}")
    public ResponseEntity<CardTradeOfferDTO> acceptOffer(String offerId) {
        CardTradeOffer dms = ((CardTradeOfferService) service).acceptOffer(offerId);

        return new ResponseEntity<>(mapper.toDTO(dms), HttpStatus.OK);
    }
}
