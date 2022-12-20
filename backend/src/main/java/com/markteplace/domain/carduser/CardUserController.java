package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-user")
public class CardUserController extends AbstractEntityController<CardUser, CardUserDTO> {
    public CardUserController(AbstractEntityService<CardUser> service, DTOMapper<CardUser, CardUserDTO> mapper) {
        super(service, mapper);
    }
}
