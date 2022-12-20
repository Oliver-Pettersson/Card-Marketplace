package com.markteplace.domain.cardmarketoffer.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMarketOfferMapper extends DTOMapper<CardMarketOffer, CardMarketOfferDTO> {
}
