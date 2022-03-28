/*
 * Copyright (c) 2022-2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

public class BackPromptAction implements PromptAction {
    @Override
    public void runAction(Object... parameters) {
        return;
    }

    @Override
    public String getPromptLabel() {
        return "Back";
    }
}
