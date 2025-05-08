package com.priceline.chutes.exceptions;

/* Here,
    1. Created custom exception to handle the scenarios whenever this exception is thrown
 */

public class InvalidChuteOperation extends RuntimeException {
    public InvalidChuteOperation() {
        super("For Chute, the ending point should be lesser than starting point");
    }
}
