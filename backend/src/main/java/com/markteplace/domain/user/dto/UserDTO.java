package com.markteplace.domain.user.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.deck.Deck;
import com.markteplace.domain.deck.dto.DeckDTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractEntityDTO {
    private String username;
    private int coins;
    private List<DeckDTO> decks;

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
        List<Deck> deck = new ArrayList<>();
        for (DeckDTO deckDTO:decks) {
             deck.add((Deck) new Deck()
                     .setName(deckDTO.getName()).setCards(deckDTO.getCardsInDeck()).setId(deckDTO.getId()));
        }
        return deck;
    }

    public UserDTO setDecks(List<Deck> decks) {
        List<DeckDTO> deckDTOS = new ArrayList<>();
        for (Deck deck:decks) {
            deckDTOS.add((DeckDTO) new DeckDTO()
                    .setName(deck.getName()).setCardsInDeck(deck.getCards()).setId(deck.getId()));
        }
        this.decks = deckDTOS;
        return this;
    }
}
