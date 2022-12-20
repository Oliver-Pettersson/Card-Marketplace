package com.markteplace.domain.user.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.deck.Deck;

import java.util.List;

public class UserDTO extends AbstractEntityDTO {
    private String username;
    private int coins;
    private List<Deck> decks;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getCoins() {
        return coins;
    }

    public UserDTO setCoins(int coins) {
        this.coins = coins;
        return this;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public UserDTO setDecks(List<Deck> decks) {
        this.decks = decks;
        return this;
    }
}
