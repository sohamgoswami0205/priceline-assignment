package com.priceline.chutes.exceptions;

/* Here,
    1. Created custom exception to handle the scenarios whenever this exception is thrown
 */

public class InvalidLadderOperation extends RuntimeException {
    public InvalidLadderOperation() {
        super("For Ladder, the ending point should be greater than starting point");
    }
}
