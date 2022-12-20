package com.markteplace.domain.cardstats.dto;

import com.markteplace.core.generic.AbstractEntityDTO;

public class CardStatsDTO extends AbstractEntityDTO {
    private int health;
    private int energy;
    private int attack;

    public CardStatsDTO(int health, int energy, int attack) {
        this.health = health;
        this.energy = energy;
        this.attack = attack;
    }

    public CardStatsDTO() {
    }

    public int getHealth() {
        return health;
    }

    public CardStatsDTO setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getEnergy() {
        return energy;
    }

    public CardStatsDTO setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public CardStatsDTO setAttack(int attack) {
        this.attack = attack;
        return this;
    }
}
