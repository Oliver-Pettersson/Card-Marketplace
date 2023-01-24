package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntityController;
import com.markteplace.core.generic.AbstractEntityService;
import com.markteplace.core.generic.DTOMapper;
import com.markteplace.domain.carduser.dto.CardCollectionFromUserDTO;
import com.markteplace.domain.carduser.dto.CardUserDTO;
import com.markteplace.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/card-user")
public class CardUserController extends AbstractEntityController<CardUser, CardUserDTO> {
    public CardUserController(AbstractEntityService<CardUser> service, DTOMapper<CardUser, CardUserDTO> mapper) {
        super(service, mapper);
    }

    @PostMapping("/pack")
    public ResponseEntity<Collection<CardUserDTO>> findAll() {
        Collection<CardUser> dms = ((CardUserService) service).boosterPack();

        return new ResponseEntity<>(mapper.toDTOs(dms), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Collection<CardCollectionFromUserDTO>> findById() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<CardCollectionFromUserDTO> dm = ((CardUserService) service).getCurrentUserCollection(user);

        return new ResponseEntity<>(dm, HttpStatus.OK);
    }
}
