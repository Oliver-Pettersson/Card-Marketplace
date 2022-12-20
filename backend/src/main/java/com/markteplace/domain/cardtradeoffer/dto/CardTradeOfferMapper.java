package com.markteplace.domain.cardtradeoffer.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtradeoffer.CardTradeOffer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardTradeOfferMapper extends DTOMapper<CardTradeOffer, CardTradeOfferDTO> {
}
