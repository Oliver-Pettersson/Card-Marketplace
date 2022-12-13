package com.markteplace.domain.card;

import com.markteplace.core.generic.AbstractEntity;
import com.markteplace.domain.cardstats.CardStats;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card")
public class Card extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "creation_timestamp", nullable = false)
    private LocalDateTime creation_timestamp;

    @ManyToOne
    @JoinColumn(name = "card_status_id", nullable = false)
    private CardStats cardStats;

    public Card(String name, String image, LocalDateTime creation_timestamp, CardStats cardStats) {
        this.name = name;
        this.image = image;
        this.creation_timestamp = creation_timestamp;
        this.cardStats = cardStats;
    }

    public Card() {
    }

    public String getName() {
        return name;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Card setImage(String image) {
        this.image = image;
        return this;
    }

    public LocalDateTime getCreation_timestamp() {
        return creation_timestamp;
    }

    public Card setCreation_timestamp(LocalDateTime creation_timestamp) {
        this.creation_timestamp = creation_timestamp;
        return this;
    }

    public CardStats getCardStats() {
        return cardStats;
    }

    public Card setCardStats(CardStats cardStats) {
        this.cardStats = cardStats;
        return this;
    }
}
