/*
 * Copyright (c) 2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

import java.util.HashMap;

public abstract class Prompt {
    private HashMap<Integer, PromptAction> promptActions;
    private Game game;

    public abstract HashMap<Integer, PromptAction> getPromptActions();

    public abstract boolean shouldHaveBackButton();

    public abstract String getPromptLabel();

    public Prompt(Game game) {
        this.game = game;
        this.promptActions = getPromptActions();
    }

    public void printNumberInputRequest() {
        if (game.shouldRequestNumberInput()) {
            game.sendMessage(game.numberInputRequest());
        }
    }

    public void printPromptDivider() {
        if (game.shouldUseDivider()) {
            game.sendMessage(game.divider());
        }
    }

    public void printPromptLabel() {
        game.sendMessage(getPromptLabel());
    }

    public void printPromptActions() {
        StringBuilder content = new StringBuilder("");
        for (int i = 0; i < getPromptActions().size(); i++) {
            content.append(i + 1).append(" - ").append(this.promptActions.get(i + 1).getPromptLabel()).append("\n");
        }
        game.sendMessage(content.toString());
    }

    public void inputAndRunSelection() throws InvalidInputException {
        if (shouldHaveBackButton()) {
            while (true) {
                printPromptDivider();
                printPromptLabel();
                printPromptActions();
                printNumberInputRequest();
                String strInput = game.getInput();
                int input = Integer.MIN_VALUE;
                try {
                    input = Integer.parseInt(strInput);
                    if (input < 1 || input > (promptActions.size())) {
                        throw new InvalidInputException("Invalid Input (Must be within 1 and " + (promptActions.size()) + ")");
                    }
                    if (promptActions.get(input) instanceof BackPromptAction) {
                        return;
                    }
                    promptActions.get(input).runAction(game);
                } catch (NumberFormatException e) {
                    throw new InvalidInputException("Invalid Input (Must be an integer)!", e);
                }
            }
        } else {
            printPromptDivider();
            printPromptLabel();
            printPromptActions();
            printNumberInputRequest();
            String strInput = game.getInput();
            int input = Integer.MIN_VALUE;
            try {
                input = Integer.parseInt(strInput);
                if (input < 1 || input > (promptActions.size() + 1)) {
                    throw new InvalidInputException("Invalid Input (Must be within 1 and " + (promptActions.size() + 1) + ")");
                }
                promptActions.get(input).runAction(game);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Invalid Input (Must be an integer)!", e);
            }
        }
    }
}
