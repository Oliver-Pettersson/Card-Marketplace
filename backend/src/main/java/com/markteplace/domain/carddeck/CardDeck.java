package com.markteplace.domain.carddeck;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.deck.Deck;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card_deck")
public class CardDeck extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "card_user_id", nullable = false)
    private CardUser card;

    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    public CardDeck(CardUser card, Deck deck) {
        this.card = card;
        this.deck = deck;
    }

    public CardDeck() {
    }

    public CardUser getCard() {
        return card;
    }

    public CardDeck setCard(CardUser card) {
        this.card = card;
        return this;
    }

    public Deck getDeck() {
        return deck;
    }

    public CardDeck setDeck(Deck deck) {
        this.deck = deck;
        return this;
    }
}
