package com.priceline.chutes.boardItem;

/* Here,
    1. Created a Factory to produce difference board items based on input values
 */

public class BoardItemFactory {

    public static BoardItem getBoardItem(int start, boolean isChute, boolean isLadder, int skipSteps) {
        if(isChute && isLadder) {
            throw new IllegalArgumentException("Board Item cannot be both chute and a ladder");
        }
        if(!isChute && !isLadder) {
            return null;
        }
        if(isChute) {
            return new Chute(start,skipSteps);
        }
        return new Ladder(start,skipSteps);
    }
}
