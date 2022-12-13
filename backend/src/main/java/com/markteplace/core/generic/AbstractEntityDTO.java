package com.markteplace.core.generic;

import java.util.UUID;

public abstract class AbstractEntityDTO {
    protected UUID id;

    public UUID getId() {
        return id;
    }

    public AbstractEntityDTO setId(UUID id) {
        this.id = id;
        return this;
    }
}
