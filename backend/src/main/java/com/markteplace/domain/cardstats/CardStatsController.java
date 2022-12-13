package com.markteplace.domain.cardstats;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardstats.dto.CardStatsDTO;

public class CardStatsController extends AbstractEntityController<CardStats, CardStatsDTO> {
    public CardStatsController(AbstractEntityService<CardStats> service, DTOMapper<CardStats, CardStatsDTO> mapper) {
        super(service, mapper);
    }
}
