package com.markteplace.domain.deck.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.carduser.CardUser;

import java.util.List;

public class DeckDTO extends AbstractEntityDTO {
    private String name;

    private List<CardUser> cards;

    public DeckDTO(String name, List<CardUser> cards) {
        this.name = name;
        this.cards = cards;
    }

    public DeckDTO() {
    }

    public List<CardUser> getCards() {
        return cards;
    }

    public void setCards(List<CardUser> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public DeckDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<CardUser> getCardsInDeck() {
        return this.cards;
    }

    public DeckDTO setCardsInDeck(List<CardUser> cards) {
        this.cards = cards;
        return this;
    }
}
