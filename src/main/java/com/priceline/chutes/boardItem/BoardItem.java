package com.priceline.chutes.boardItem;

import com.priceline.chutes.Constants;

/* Here,
    1. Created the BoardItem class to manage common responsibilities of each board item
 */

public abstract class BoardItem {
    protected int start;
    protected int end;
    protected BoardItemType boardItemType;

    public BoardItem(int start, int end) {
        BoardItemValidator.validateBoardItemStartAndEnd(start,end);
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    protected void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    protected void setEnd(int end) {
        this.end = end;
    }

    public BoardItemType getBoardItemType() {
        return boardItemType;
    }

    protected void setBoardItemType(BoardItemType boardItemType) {
        this.boardItemType = boardItemType;
    }
}
