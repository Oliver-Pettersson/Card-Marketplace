package com.markteplace.domain.cardtradeoffer.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.user.User;
import com.markteplace.domain.user.dto.UserDTO;

import java.time.LocalDateTime;

public class CardTradeOfferDTO extends AbstractEntityDTO {
    private String offerUser;
    private Card offerCardUser;
    private Card accepterCardUser;
    private LocalDateTime offerTimestamp;
    private CardTransaction cardTransaction;

    public CardTradeOfferDTO(String offerUser, Card offerCardUser, Card accepterCardUser, LocalDateTime offerTimestamp, CardTransaction cardTransaction) {
        this.offerUser = offerUser;
        this.offerCardUser = offerCardUser;
        this.accepterCardUser = accepterCardUser;
        this.offerTimestamp = offerTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardTradeOfferDTO(User offerUser, Card offerCardUser, Card accepterCardUser, LocalDateTime offerTimestamp, CardTransaction cardTransaction) {
        this.offerUser = offerUser.getUsername();
        this.offerCardUser = offerCardUser;
        this.accepterCardUser = accepterCardUser;
        this.offerTimestamp = offerTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardTradeOfferDTO() {
    }

    public User getOfferUser() {
        return new User().setUsername(offerUser);
    }

    public CardTradeOfferDTO setOfferUser(String offerUser) {
        this.offerUser = offerUser;
        return this;
    }

    public CardTradeOfferDTO setOfferUser(User offerUser) {
        this.offerUser = offerUser.getUsername();
        return this;
    }

    public Card getOfferCardUser() {
        return offerCardUser;
    }

    public CardTradeOfferDTO setOfferCardUser(Card offerCardUser) {
        this.offerCardUser = offerCardUser;
        return this;
    }

    public Card getAccepterCardUser() {
        return accepterCardUser;
    }

    public CardTradeOfferDTO setAccepterCardUser(Card accepterCardUser) {
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
