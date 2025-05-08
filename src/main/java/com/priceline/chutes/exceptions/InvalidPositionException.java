package com.priceline.chutes.exceptions;

/* Here,
    1. Created custom exception to handle the scenarios whenever this exception is thrown
 */

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
