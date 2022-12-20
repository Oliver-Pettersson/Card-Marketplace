package com.markteplace.domain.cardtransaction;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_transaction")
public class CardTransaction extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "new_user_id", nullable = false)
    private User newUser;

    @Column(name = "transaction_timestamp", nullable = false)
    private LocalDateTime transactionTimestamp;

    public CardTransaction(User newUser, LocalDateTime transactionTimestamp) {
        this.newUser = newUser;
        this.transactionTimestamp = transactionTimestamp;
    }

    public CardTransaction() {
    }

    public User getNewUser() {
        return newUser;
    }

    public CardTransaction setNewUser(User newUser) {
        this.newUser = newUser;
        return this;
    }

    public LocalDateTime getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public CardTransaction setTransactionTimestamp(LocalDateTime transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
        return this;
    }
}
