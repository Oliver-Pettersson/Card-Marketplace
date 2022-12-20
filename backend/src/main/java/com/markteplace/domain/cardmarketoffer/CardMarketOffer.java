package com.markteplace.domain.cardmarketoffer;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.cardtradeoffer.CardTradeOffer;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_market_offer")
public class CardMarketOffer extends AbstractEntity {
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "card_user_id", nullable = false)
    private CardUser card;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "transaction_timestamp", nullable = false)
    private LocalDateTime transactionTimestamp;

    @ManyToOne
    @JoinColumn(name = "card_transaction_id")
    private CardTransaction cardTransaction;

    public CardMarketOffer(int price, CardUser card, User user, LocalDateTime transactionTimestamp, CardTransaction cardTransaction) {
        this.price = price;
        this.card = card;
        this.user = user;
        this.transactionTimestamp = transactionTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardMarketOffer() {
    }

    public int getPrice() {
        return price;
    }

    public CardMarketOffer setPrice(int price) {
        this.price = price;
        return this;
    }

    public CardUser getCard() {
        return card;
    }

    public CardMarketOffer setCard(CardUser card) {
        this.card = card;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CardMarketOffer setUser(User user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public CardMarketOffer setTransactionTimestamp(LocalDateTime transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
        return this;
    }

    public CardTransaction getCardTransaction() {
        return cardTransaction;
    }

    public CardMarketOffer setCardTransaction(CardTransaction cardTransaction) {
        this.cardTransaction = cardTransaction;
        return this;
    }
}
