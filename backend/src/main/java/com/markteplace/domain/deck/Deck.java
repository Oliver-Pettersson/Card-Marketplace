package com.markteplace.domain.deck;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.carduser.CardUser;

import javax.persistence.*;

@Entity
@Table(name = "deck")
public class Deck extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    public Deck(String name) {
        this.name = name;
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
}
