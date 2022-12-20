package com.markteplace.domain.cardstats.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardstats.CardStats;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardStatsMapper extends DTOMapper<CardStats,CardStatsDTO> {
}
