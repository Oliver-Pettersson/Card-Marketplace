package com.markteplace.domain.deck.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.carduser.CardUser;

import java.util.List;

public class DeckDTO extends AbstractEntityDTO {
    private String name;

    private List<CardUser> cardsInDeck;

    public DeckDTO(String name, List<CardUser> cardsInDeck) {
        this.name = name;
        this.cardsInDeck = cardsInDeck;
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

    public List<CardUser> getCardsInDeck() {
        return cardsInDeck;
    }

    public DeckDTO setCardsInDeck(List<CardUser> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
        return this;
    }
}
