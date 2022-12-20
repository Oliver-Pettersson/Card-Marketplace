package com.markteplace.domain.cardstats;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardstats.dto.CardStatsDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-stats")
public class CardStatsController extends AbstractEntityController<CardStats, CardStatsDTO> {
    public CardStatsController(AbstractEntityService<CardStats> service, DTOMapper<CardStats, CardStatsDTO> mapper) {
        super(service, mapper);
    }
}
