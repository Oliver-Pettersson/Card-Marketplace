package com.markteplace.domain.cardtradeoffer.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.user.User;

import java.time.LocalDateTime;

public class CardTradeOfferDTO extends AbstractEntityDTO {
    private User offerUser;
    private CardUser offerCardUser;
    private CardUser accepterCardUser;
    private LocalDateTime offerTimestamp;
    private CardTransaction cardTransaction;

    public CardTradeOfferDTO(User offerUser, CardUser offerCardUser, CardUser accepterCardUser, LocalDateTime offerTimestamp, CardTransaction cardTransaction) {
        this.offerUser = offerUser;
        this.offerCardUser = offerCardUser;
        this.accepterCardUser = accepterCardUser;
        this.offerTimestamp = offerTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardTradeOfferDTO() {
    }

    public User getOfferUser() {
        return offerUser;
    }

    public CardTradeOfferDTO setOfferUser(User offerUser) {
        this.offerUser = offerUser;
        return this;
    }

    public CardUser getOfferCardUser() {
        return offerCardUser;
    }

    public CardTradeOfferDTO setOfferCardUser(CardUser offerCardUser) {
        this.offerCardUser = offerCardUser;
        return this;
    }

    public CardUser getAccepterCardUser() {
        return accepterCardUser;
    }

    public CardTradeOfferDTO setAccepterCardUser(CardUser accepterCardUser) {
        this.accepterCardUser = accepterCardUser;
        return this;
    }

    public LocalDateTime getOfferTimestamp() {
        return offerTimestamp;
    }

    public CardTradeOfferDTO setOfferTimestamp(LocalDateTime offerTimestamp) {
        this.offerTimestamp = offerTimestamp;
        return this;
    }

    public CardTransaction getCardTransaction() {
        return cardTransaction;
    }

    public CardTradeOfferDTO setCardTransaction(CardTransaction cardTransaction) {
        this.cardTransaction = cardTransaction;
        return this;
    }
}
