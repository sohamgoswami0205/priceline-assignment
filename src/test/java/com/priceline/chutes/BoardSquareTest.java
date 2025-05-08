package com.priceline.chutes;

import com.priceline.chutes.exceptions.InvalidChuteOperation;
import com.priceline.chutes.exceptions.InvalidLadderOperation;
import com.priceline.chutes.exceptions.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void aChuteShouldSkipSquaresReversed(){
        BoardSquare square = new BoardSquare(5,true, false, 2);
        assertTrue(square.getEndPosition() < square.getStartPos());
    }

    @Test
    public void invalidPositionCausedByChuteShouldThrowException() {
        Exception exception = assertThrows(InvalidPositionException.class, () -> {
            // Invalid as player reaches 5 and chute is asking player to move back 10 squares which will take player out of player board
            new BoardSquare(5, true, false, 10);
        });

        String expectedMessage = "End point for the Board Item is invalid";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void invalidChuteShouldThrowException() {
        Exception exception = assertThrows(InvalidChuteOperation.class, () -> {
            new BoardSquare(5, true, false, -1);
        });

        String expectedMessage = "For Chute, the ending point should be lesser than starting point";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void aLadderShouldAdvanceSquares() {
        BoardSquare square = new BoardSquare(3, false, true, 4);
        assertTrue(square.getEndPosition() > square.getStartPos(), "Ladder should move player up");
    }

    @Test
    public void invalidPositionCausedByLadderShouldThrowException() {
        Exception exception = assertThrows(InvalidPositionException.class, () -> {
            new BoardSquare(5, false, true, 10);
        });

        String expectedMessage = "Start point for the Board Item is invalid";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void invalidLadderShouldThrowException() {
        Exception exception = assertThrows(InvalidLadderOperation.class, () -> {
            new BoardSquare(5, false, true, 22);
        });

        String expectedMessage = "For Ladder, the ending point should be greater than starting point";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void aNeutralSquareShouldNotChangePosition() {
        BoardSquare square = new BoardSquare(8);
        assertTrue(square.getEndPosition() == square.getStartPos(), "Neutral square should not change position");
    }

    @Test
    public void aBoardSquareShouldReturnCorrectStartPosition() {
        BoardSquare square = new BoardSquare(12, false, true, 3);
        assertTrue(square.getStartPos() == 12, "Start position should match the initialized value");
    }

}
