package com.markteplace.domain.cardtransaction.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.cardtransaction.CardTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardTransactionMapper extends DTOMapper<CardTransaction,CardTransactionDTO> {
}
