package ss.tictactoe.ui;

import ss.tictactoe.model.*;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name) {
        super(name);
    }


    /**
     * Determines the next move, if the game still has available moves.
     * @param game the current game
     * @return the player's choice
     */
    //@ requires !game.isGameover();
    //@ ensures game.isValidMove(\result);
    @Override
    public Move determineMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;
        Scanner input = new Scanner(System.in);


        TicTacToeMove tttMove;
        while (true) {
            System.out.println("Where do you wish to place your mark?");
            int moveIndex = input.nextInt();
            tttMove = new TicTacToeMove(tttGame.getPlayerMark(tttGame.getTurn()), moveIndex);

            if (!game.isValidMove(tttMove)) {
                System.out.println("INVALID INPUT");
            }
            if (game.isValidMove(tttMove)) {
                return tttMove;
            }
        }
    }
}
