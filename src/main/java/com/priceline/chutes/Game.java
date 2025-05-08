package com.priceline.chutes;

import com.priceline.chutes.dice.Dice;
import com.priceline.chutes.dice.FairDice;
import com.priceline.chutes.exceptions.InvalidChuteOperation;
import com.priceline.chutes.exceptions.InvalidLadderOperation;
import com.priceline.chutes.exceptions.InvalidPositionException;

import java.util.Arrays;
import java.util.List;

public class Game {
    /* Here,
        1. Creating a new "dice" object that is used to make the next step of each player
        2. Managing the player list in a better way than the original code by providing a list upfront
     */
    private final Dice dice;
    List<String> playerNames = Arrays.asList("dijkstra","turing","hopper","torvalds");

    public Game(Dice dice) {
        this.dice = dice;
    }

    public Player playGame(){
        List<Player> players = playerNames.stream().map(Player::new).toList();
        Board board = new Board();

        while(true){
            for (Player currentPlayer : players) {
                int spinResult = dice.roll();
                // Adding logger for better visibility on which player got what on current turn
                System.out.println(currentPlayer.getName() + " rolled " + spinResult);
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > Constants.END_POINT){
                    // This allows current user to stay at current position and pass the turn to next player
                    // This was a bug in earlier version as due to "break" only first player was able to take turn until they win
                    continue;
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition = nextSquare.getEndPosition();
                if (nextPosition < Constants.END_POINT) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == Constants.END_POINT) {
                    return currentPlayer; //The winner!
                }
            }
            /* Here,
                1. Added logging for knowing after 1 round of turns, which player is at which position
                2. TODO: Improve logging by using Logger.log and adding dependencies
             */
            System.out.println("############### Turn Over ############### ");
            for(Player player:players) {
                System.out.println(player.getName() + " is currently at " + player.getPosition());
            }
            System.out.println("######################################### ");
        }
    }


    public static void main(String[] args) {
        // TODO: Improving exception handling
        try {
            try {
                Dice dice = new FairDice(Constants.DICE_MAX_VALUE);
                Player winner = new Game(dice).playGame();
                System.out.println("\n\n**********************************");
                System.out.println("The winner is: " + winner.getName());
                System.out.println("**********************************");
            }
            catch (InvalidChuteOperation | InvalidLadderOperation | InvalidPositionException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
