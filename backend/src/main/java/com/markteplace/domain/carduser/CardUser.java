package com.markteplace.domain.carduser;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card_user")
public class CardUser extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public CardUser(Card card, User user) {
        this.card = card;
        this.user = user;
    }

    public CardUser() {
    }

    public Card getCard() {
        return card;
    }

    public CardUser setCard(Card card) {
        this.card = card;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CardUser setUser(User user) {
        this.user = user;
        return this;
    }
}
