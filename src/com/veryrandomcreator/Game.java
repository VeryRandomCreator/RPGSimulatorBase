/*
 * Copyright (c) 2022-2022.
 * Created by VeryRandomCreator
 * Made for the purpose of being a base api for basic command-line RPG simulators
 */

package com.veryrandomcreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {
    Scanner scanner = new Scanner(System.in);
    public List<PlayerBase> players = new ArrayList<>();

    public abstract boolean shouldRequestNumberInput();

    public abstract String numberInputRequest();

    public abstract boolean shouldUseDivider();

    public abstract String divider();

    public abstract Prompt initPrompt();

    public long getAvailableId() {
        Random random = new Random();
        long randLong = random.nextLong();
        if (players != null && !players.isEmpty()) {
            boolean flag = false;
            while (!flag) {
                boolean hasFoundMatchingId = false;
                for (int i = 0; i < players.size(); i++) {
                    if (randLong == players.get(i).getId()) {
                        hasFoundMatchingId = true;
                    }
                }
                if (!hasFoundMatchingId) {
                    flag = true;
                } else {
                    randLong = random.nextLong();
                }
            }
            return randLong;
        }
        return randLong;
    }

    public void sendMessage(Object output) {
        System.out.println(output);
    }

    public String getInput() {
        String input = scanner.next();
        return input;
    }

    public void onInit() throws InvalidInputException {
        initPrompt().inputAndRunSelection();
    }
}
