package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.carduser.CardUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deck")
public class Deck extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "card_deck",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "card_user_id"))
    private List<Card> cardsInDeck;

    public Deck(String name, List<Card> cardsInDeck) {
        this.name = name;
        this.cardsInDeck = cardsInDeck;
    }

    public Deck() {
    }

    public String getName() {
        return name;
    }

    public Deck setName(String name) {
        this.name = name;
        return this;
    }

    public List<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public Deck setCardsInDeck(List<Card> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
        return this;
    }
}
