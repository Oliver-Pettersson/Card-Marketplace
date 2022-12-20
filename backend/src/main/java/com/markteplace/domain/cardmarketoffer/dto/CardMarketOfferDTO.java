package com.markteplace.domain.cardmarketoffer.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.user.User;

import java.time.LocalDateTime;

public class CardMarketOfferDTO extends AbstractEntityDTO {
    private int price;
    private CardUser card;
    private User user;
    private LocalDateTime transactionTimestamp;
    private CardTransaction cardTransaction;

    public CardMarketOfferDTO(int price, CardUser card, User user, LocalDateTime transactionTimestamp, CardTransaction cardTransaction) {
        this.price = price;
        this.card = card;
        this.user = user;
        this.transactionTimestamp = transactionTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardMarketOfferDTO() {
    }

    public int getPrice() {
        return price;
    }

    public CardMarketOfferDTO setPrice(int price) {
        this.price = price;
        return this;
    }

    public CardUser getCard() {
        return card;
    }

    public CardMarketOfferDTO setCard(CardUser card) {
        this.card = card;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CardMarketOfferDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public CardMarketOfferDTO setTransactionTimestamp(LocalDateTime transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
        return this;
    }

    public CardTransaction getCardTransaction() {
        return cardTransaction;
    }

    public CardMarketOfferDTO setCardTransaction(CardTransaction cardTransaction) {
        this.cardTransaction = cardTransaction;
        return this;
    }
}
