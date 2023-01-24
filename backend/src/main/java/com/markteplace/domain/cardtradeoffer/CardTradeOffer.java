package com.markteplace.domain.cardtradeoffer;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.cardtransaction.CardTransaction;
import com.markteplace.domain.carduser.CardUser;
import com.markteplace.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_trade_offer")
public class CardTradeOffer extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "offer_user_id", nullable = false)
    private User offerUser;

    @ManyToOne
    @JoinColumn(name = "offer_card_user_id", nullable = false)
    private CardUser offerCardUser;

    @ManyToOne
    @JoinColumn(name = "accepter_card_user_id", nullable = false)
    private CardUser accepterCardUser;

    @Column(name = "offer_timestamp", nullable = false)
    private LocalDateTime offerTimestamp;

    @ManyToOne
    @JoinColumn(name = "card_transaction_id")
    private CardTransaction cardTransaction;

    public CardTradeOffer(User offerUser, CardUser offerCardUser, CardUser accepterCardUser, LocalDateTime offerTimestamp, CardTransaction cardTransaction) {
        this.offerUser = offerUser;
        this.offerCardUser = offerCardUser;
        this.accepterCardUser = accepterCardUser;
        this.offerTimestamp = offerTimestamp;
        this.cardTransaction = cardTransaction;
    }

    public CardTradeOffer() {
    }

    public User getOfferUser() {
        return offerUser;
    }

    public CardTradeOffer setOfferUser(User offerUser) {
        this.offerUser = offerUser;
        return this;
    }

    public CardUser getOfferCardUser() {
        return offerCardUser;
    }

    public CardTradeOffer setOfferCardUser(CardUser offerCardUser) {
        this.offerCardUser = offerCardUser;
        return this;
    }

    public CardUser getAccepterCardUser() {
        return accepterCardUser;
    }

    public CardTradeOffer setAccepterCardUser(CardUser accepterCardUser) {
        this.accepterCardUser = accepterCardUser;
        return this;
    }

    public LocalDateTime getOfferTimestamp() {
        return offerTimestamp;
    }

    public CardTradeOffer setOfferTimestamp(LocalDateTime offerTimestamp) {
        this.offerTimestamp = offerTimestamp;
        return this;
    }

    public CardTransaction getCardTransaction() {
        return cardTransaction;
    }

    public CardTradeOffer setCardTransaction(CardTransaction cardTransaction) {
        this.cardTransaction = cardTransaction;
        return this;
    }
}
