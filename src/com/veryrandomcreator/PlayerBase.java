/*
 * Copyright (c) 2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

public abstract class PlayerBase {
    private final long id;

    public PlayerBase(Game game) {
        this.id = game.getAvailableId();
    }

    public long getId() {
        return id;
    }
}
