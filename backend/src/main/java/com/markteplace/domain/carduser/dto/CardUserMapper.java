package com.markteplace.domain.carduser.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carduser.CardUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardUserMapper extends DTOMapper<CardUser, CardUserDTO> {
}
