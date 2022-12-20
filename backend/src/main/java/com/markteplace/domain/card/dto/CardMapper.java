package com.markteplace.domain.card.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.card.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper extends DTOMapper<Card, CardDTO> {
}
