package com.markteplace.domain.carduser.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.user.User;

public class CardUserDTO extends AbstractEntityDTO {
    private Card card;
    private String user;

    public CardUserDTO(Card card, User user) {
        this.card = card;
        this.user = user.getUsername();
    }

    public CardUserDTO(Card card, String user) {
        this.card = card;
        this.user = user;
    }

    public CardUserDTO() {
    }

    public Card getCard() {
        return card;
    }

    public CardUserDTO setCard(Card card) {
        this.card = card;
        return this;
    }

    public User getUser() {
        return new User().setUsername(user);
    }

    public CardUserDTO setUser(User user) {
        this.user = user.getUsername();
        return this;
    }

    public CardUserDTO setUser(String user) {
        this.user = user;
        return this;
    }
}
