package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

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
    private List<CardUser> cards;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Deck(String name, List<CardUser> cards) {
        this.name = name;
        this.cards = cards;
        this.user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    public List<CardUser> getCards() {
        return cards;
    }

    public Deck setCards(List<CardUser> cards) {
        this.cards = cards;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
