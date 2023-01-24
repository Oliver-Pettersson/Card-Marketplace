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
<<<<<<< HEAD
    private List<CardUser> cards;

    public Deck(String name, List<CardUser> cards) {
        this.name = name;
        this.cards = cards;
=======
    private List<Card> cardsInDeck;

    public Deck(String name, List<Card> cardsInDeck) {
        this.name = name;
        this.cardsInDeck = cardsInDeck;
>>>>>>> dev
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

<<<<<<< HEAD
    public List<CardUser> getCards() {
        return cards;
    }

    public void setCards(List<CardUser> cards) {
        this.cards = cards;
=======
    public List<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public Deck setCardsInDeck(List<Card> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
        return this;
>>>>>>> dev
    }
}
