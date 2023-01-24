package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.dto.CardDTO;
import com.markteplace.domain.cardtradeoffer.dto.CardTradeOfferDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
