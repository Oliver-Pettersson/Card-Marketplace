package com.markteplace.domain.user.dto;

import com.markteplace.core.generic.AbstractEntityDTO;

public class UserDTO extends AbstractEntityDTO {
    private String username;
    private String coins;

    public UserDTO(String username, String coins) {
        this.username = username;
        this.coins = coins;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }
}
