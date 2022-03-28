/*
 * Copyright (c) 2022-2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

public interface PromptAction {
    void runAction(Object... parameters);

    String getPromptLabel();
}
