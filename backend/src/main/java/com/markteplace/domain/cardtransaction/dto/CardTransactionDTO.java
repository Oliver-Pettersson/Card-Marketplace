package com.markteplace.domain.cardtransaction.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.user.User;

import java.time.LocalDateTime;

public class CardTransactionDTO extends AbstractEntityDTO {
    private String newUser;
    private LocalDateTime transactionTimestamp;

    public CardTransactionDTO(User newUser, LocalDateTime transactionTimestamp) {
        this.newUser = newUser.getUsername();
        this.transactionTimestamp = transactionTimestamp;
    }

    public CardTransactionDTO(String newUser, LocalDateTime transactionTimestamp) {
        this.newUser = newUser;
        this.transactionTimestamp = transactionTimestamp;
    }

    public CardTransactionDTO() {
    }

    public User getNewUser() {
        return new User().setUsername(newUser);
    }

    public CardTransactionDTO setNewUser(String newUser) {
        this.newUser = newUser;
        return this;
    }

    public CardTransactionDTO setNewUser(User newUser) {
        this.newUser = newUser.getUsername();
        return this;
    }

    public LocalDateTime getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public CardTransactionDTO setTransactionTimestamp(LocalDateTime transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
        return this;
    }
}
