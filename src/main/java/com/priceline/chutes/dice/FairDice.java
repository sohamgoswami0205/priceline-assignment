package com.priceline.chutes.dice;

import java.util.Random;

/* Here,
    1. An implementation of the roll feature to return a random integer between and including 1 and 6
 */

public class FairDice implements Dice{
    private final int max;
    private final Random random = new Random();

    public FairDice(int max) {
        this.max = max;
    }

    public int roll() {
        return random.nextInt(max) + 1;
    }
}
