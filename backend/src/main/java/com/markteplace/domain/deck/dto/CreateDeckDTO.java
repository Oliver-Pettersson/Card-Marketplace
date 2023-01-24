package com.markteplace.domain.deck.dto;

import java.util.List;

public class CreateDeckDTO {
    private String name;
    private List<String> cards;

    public CreateDeckDTO() {
    }

    public CreateDeckDTO(String name, List<String> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }
}
