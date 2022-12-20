package com.markteplace.domain.carddeck.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carddeck.CardDeck;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardDeckMapper extends DTOMapper<CardDeck,CardDeckDTO> {
}
