package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/card-user")
public class CardUserController extends AbstractEntityController<CardUser, CardUserDTO> {
    public CardUserController(AbstractEntityService<CardUser> service, DTOMapper<CardUser, CardUserDTO> mapper) {
        super(service, mapper);
    }

    @GetMapping("/pack")
    public ResponseEntity<Collection<CardUserDTO>> findAll() {
        Collection<CardUser> dms = ((CardUserService) service).boosterPack();

        return new ResponseEntity<>(mapper.toDTOs(dms), HttpStatus.OK);
    }
}
