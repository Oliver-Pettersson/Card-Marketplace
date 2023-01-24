package com.markteplace.domain.carduser.dto;

public class CardCollectionFromUserDTO {
    String image;
    String name;
    int attack;
    int health;
    int energy;
    int count;

    public CardCollectionFromUserDTO() {
    }

    public CardCollectionFromUserDTO(String image, String name, int attack, int health, int energy, int count) {
        this.image = image;
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.energy = energy;
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public CardCollectionFromUserDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public CardCollectionFromUserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public CardCollectionFromUserDTO setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public CardCollectionFromUserDTO setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getEnergy() {
        return energy;
    }

    public CardCollectionFromUserDTO setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public int getCount() {
        return count;
    }

    public CardCollectionFromUserDTO setCount(int count) {
        this.count = count;
        return this;
    }
}
