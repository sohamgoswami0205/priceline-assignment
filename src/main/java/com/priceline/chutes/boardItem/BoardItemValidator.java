package com.priceline.chutes.boardItem;

import com.priceline.chutes.Constants;
import com.priceline.chutes.exceptions.InvalidPositionException;

/* Here,
    1. Validate the start and end points of board items
    2. TODO: Can be scaled to validate other different moves to make the game more interesting
 */

public class BoardItemValidator {

    public static void validateBoardItemStartAndEnd(int start, int end) {
        if(start < Constants.START_POINT || start > Constants.END_POINT) {
            throw new InvalidPositionException("Start point for the Board Item is invalid");
        }
        if(end < Constants.START_POINT || end > Constants.END_POINT) {
            throw new InvalidPositionException("End point for the Board Item is invalid");
        }
    }
}
