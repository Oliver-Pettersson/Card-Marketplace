package com.markteplace.domain.card.dto;

import com.markteplace.core.generic.AbstractEntityDTO;
import com.markteplace.domain.cardstats.CardStats;

import java.time.LocalDateTime;

public class CardDTO extends AbstractEntityDTO {
    private String name;
    private String image;
    private LocalDateTime creation_timestamp;
    private CardStats cardStats;

    public CardDTO(String name, String image, LocalDateTime creation_timestamp, CardStats cardStats) {
        this.name = name;
        this.image = image;
        this.creation_timestamp = creation_timestamp;
        this.cardStats = cardStats;
    }

    public CardDTO() {
    }

    public String getName() {
        return name;
    }

    public CardDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public CardDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public LocalDateTime getCreation_timestamp() {
        return creation_timestamp;
    }

    public CardDTO setCreation_timestamp(LocalDateTime creation_timestamp) {
        this.creation_timestamp = creation_timestamp;
        return this;
    }

    public CardStats getCardStats() {
        return cardStats;
    }

    public CardDTO setCardStats(CardStats cardStats) {
        this.cardStats = cardStats;
        return this;
    }
}
