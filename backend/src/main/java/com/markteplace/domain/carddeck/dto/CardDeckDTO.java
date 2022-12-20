package com.markteplace.domain.carddeck.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.cardmarketoffer.CardMarketOffer;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.deck.Deck;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CardDeckDTO extends AbstractEntityDTO {
    private CardUser card;
    private Deck deck;

    public CardDeckDTO(CardUser card, Deck deck) {
        this.card = card;
        this.deck = deck;
    }

    public CardDeckDTO() {
    }

    public CardUser getCard() {
        return card;
    }

    public CardDeckDTO setCard(CardUser card) {
        this.card = card;
        return this;
    }

    public Deck getDeck() {
        return deck;
    }

    public CardDeckDTO setDeck(Deck deck) {
        this.deck = deck;
        return this;
    }
}
