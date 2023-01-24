package com.markteplace.domain.user;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.deck.Deck;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(unique = true, name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "coins")
    private int coins;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Deck> decks;

    public User(String username, String password, int coins, List<Deck> decks) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.decks = decks;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getCoins() {
        return coins;
    }

    public User setCoins(int coins) {
        this.coins = coins;
        return this;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public User setDecks(List<Deck> decks) {
        this.decks = decks;
        return this;
    }
}
