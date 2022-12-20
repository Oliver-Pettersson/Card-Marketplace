package com.markteplace.domain.deck.dto;

import com.markteplace.core.generic.AbstractEntityDTO;

public class DeckDTO extends AbstractEntityDTO {
    private String name;

    public DeckDTO(String name) {
        this.name = name;
    }

    public DeckDTO() {
    }

    public String getName() {
        return name;
    }

    public DeckDTO setName(String name) {
        this.name = name;
        return this;
    }
}
