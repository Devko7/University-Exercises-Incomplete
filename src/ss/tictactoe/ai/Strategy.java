package ss.tictactoe.ai;

import ss.tictactoe.model.Game;
import ss.tictactoe.model.Move;

public interface Strategy {

    /**
     * returns the name of the strategy.
     * @return the name of the strategy
     */
    public String getName();

    /**
     * returns a next legal move, given the current state of the game.
     * @param game the game to be checked
     * @return a legal move, field is free and index is within bounds of the board.
     */
    public Move determineMove(Game game);
}
