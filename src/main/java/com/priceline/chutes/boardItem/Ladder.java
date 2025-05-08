package com.priceline.chutes.boardItem;

import com.priceline.chutes.exceptions.InvalidLadderOperation;

/* Here,
    1. Created a new Ladder class to handle the creation and business logic of a ladder inside the Ladder itself
 */

public class Ladder extends BoardItem {
    public Ladder(int start, int skipSteps) {
        super(start,start + skipSteps);
        if(end <= start) {
            throw new InvalidLadderOperation();
        }
        this.boardItemType = BoardItemType.LADDER;
    }
}
