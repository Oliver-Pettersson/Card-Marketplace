package com.markteplace.domain.deck.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.deck.Deck;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeckMapper extends DTOMapper<Deck, DeckDTO> {
}
