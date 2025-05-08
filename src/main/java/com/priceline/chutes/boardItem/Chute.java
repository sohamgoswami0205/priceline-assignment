package com.priceline.chutes.boardItem;

import com.priceline.chutes.exceptions.InvalidChuteOperation;

/* Here,
    1. Created a new Chute class to handle the creation and business logic of a chute inside the Chute itself
 */

public class Chute extends BoardItem {
    public Chute(int start, int stepsToSkip) {
        super(start,start - stepsToSkip);
        if(end >= start) {
            throw new InvalidChuteOperation();
        }
        this.boardItemType = BoardItemType.CHUTE;
    }
}
