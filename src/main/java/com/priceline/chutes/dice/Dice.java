package com.priceline.chutes.dice;

/* Here,
    1. Created a Dice interface to allow rolling functionality
    This allows flexibility to implement different types of dice (e.g., Fair, Loaded (to make game more interesting)).
 */

public interface Dice {
    int roll();
}
