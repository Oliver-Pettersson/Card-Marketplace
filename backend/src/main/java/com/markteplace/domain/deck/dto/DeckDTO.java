package com.markteplace.domain.deck.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.card.Card;

import java.util.List;

public class DeckDTO extends AbstractEntityDTO {
    private String name;

    private List<Card> cardsInDeck;

    public DeckDTO(String name, List<Card> cardsInDeck) {
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

    public List<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public DeckDTO setCardsInDeck(List<Card> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
        return this;
    }
}
