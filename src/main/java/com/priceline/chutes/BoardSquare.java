package com.priceline.chutes;

import com.priceline.chutes.boardItem.BoardItem;
import com.priceline.chutes.boardItem.BoardItemFactory;

public class BoardSquare {
    private final BoardItem boardItem;
    private final int startPos;

    BoardSquare(int start){
        this(start,false, false, 0);
    }
    BoardSquare(int start,boolean isChute, boolean isLadder, int numberSquaresToSkip){
        /* Here,
            1. Created a board item factory to create board items by giving only inputs and not worrying about logic handling creation
         */
        boardItem = BoardItemFactory.getBoardItem(start,isChute,isLadder,numberSquaresToSkip);
        startPos = start;
    }

    /* Here,
        1. The position that matters for the player's movement is the "end" position based on if they land on blank square
            or climb up on a ladder or roll down from a chute. Thus, getEndPosition will tell where player ends after their turn.
        2. The start position is required to place the board item on the board
            i.e. where the ladder starts from or where the chute starts from or if they are on a blank square
     */
    public int getEndPosition() {
        if(boardItem == null) return startPos;
        return boardItem.getEnd();
    }

    public int getStartPos() {
        return startPos;
    }
}
