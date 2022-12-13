package com.markteplace.domain.cardstats;

import com.markteplace.core.generic.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_status")
public class CardStats extends AbstractEntity {
    @Column(name = "health", nullable = false)
    private int health;
    @Column(name = "energy", nullable = false)
    private int energy;
    @Column(name = "attack", nullable = false)
    private int attack;

    public CardStats(int health, int energy, int attack) {
        this.health = health;
        this.energy = energy;
        this.attack = attack;
    }

    public CardStats() {
    }

    public int getHealth() {
        return health;
    }

    public CardStats setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getEnergy() {
        return energy;
    }

    public CardStats setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public CardStats setAttack(int attack) {
        this.attack = attack;
        return this;
    }
}
