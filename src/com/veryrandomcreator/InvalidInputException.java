/*
 * Copyright (c) 2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message, Throwable e) {
        super(message, e);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
