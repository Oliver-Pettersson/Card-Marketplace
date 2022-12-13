package com.markteplace.domain.user.dto;

import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends DTOMapper<User, UserDTO> {
    User fromSignUpDTO(UserSignUpDTO dto);
}
