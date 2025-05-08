package com.priceline.chutes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Board {

    List<BoardSquare> squares;

    Board() {
        /* Here,
            1. getOrDefault gives a fallback to fetch value from a Map
            2. Optional in original code was unnecessary
            3. Adding i in BoardSquare constructor
         */
        squares = java.util.stream.IntStream.rangeClosed(Constants.START_POINT, Constants.END_POINT)
                .mapToObj(i -> specialSquares.getOrDefault(i,new BoardSquare(i)))
                .collect(Collectors.toList());
    }

    BoardSquare getSquareAtPosition(int i){
        return squares.get(i-1);
    }

    /* Here,
        1. Added "start" in the BoardSquare constructor for using it under a BoardItemFactory
     */
    private final Map<Integer, BoardSquare> specialSquares = Map.ofEntries(
            entry(1, new BoardSquare(1,false, true, 37)),
            entry(4, new BoardSquare(4,false, true, 10)),
            entry(9, new BoardSquare(9,false, true, 22)),
            entry(16, new BoardSquare(16,true, false, 10)),
            entry(21, new BoardSquare(21,false, true, 21)),
            entry(28, new BoardSquare(28,false, true, 56)),
            entry(36, new BoardSquare(36,false, true, 8)),
            entry(47, new BoardSquare(47,true, false, 21)),
            entry(49, new BoardSquare(49,true, false, 38)),
            entry(51, new BoardSquare(51,false, true, 16)),
            entry(56, new BoardSquare(56,true, false, 3)),
            entry(62, new BoardSquare(62,true, false, 43)),
            entry(64, new BoardSquare(64,true, false, 4)),
            entry(71, new BoardSquare(71,false, true, 20)),
            entry(80, new BoardSquare(80,false, true, 20)),
            entry(87, new BoardSquare(87,true, false, 63)),
            entry (93, new BoardSquare(93,true, false, 20)),
            entry(95, new BoardSquare(95,true, false, 20)),
            entry(98, new BoardSquare(98,true, false, 20))
    );
}
