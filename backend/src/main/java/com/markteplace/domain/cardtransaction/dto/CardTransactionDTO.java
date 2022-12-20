package com.markteplace.domain.cardtransaction.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.user.User;

import java.time.LocalDateTime;

public class CardTransactionDTO extends AbstractEntityDTO {
    private User newUser;
    private LocalDateTime transactionTimestamp;

    public CardTransactionDTO(User newUser, LocalDateTime transactionTimestamp) {
        this.newUser = newUser;
        this.transactionTimestamp = transactionTimestamp;
    }

    public CardTransactionDTO() {
    }

    public User getNewUser() {
        return newUser;
    }

    public CardTransactionDTO setNewUser(User newUser) {
        this.newUser = newUser;
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
