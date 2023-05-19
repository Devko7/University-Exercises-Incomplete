package ss.tictactoe.ai;

import ss.tictactoe.model.*;


public class NaiveStrategy implements Strategy {

    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public Move determineMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;
        TicTacToeMove tttMove = new TicTacToeMove(tttGame.getPlayerMark(tttGame.getTurn()), (int) (Math.random() * (Board.DIM * Board.DIM + 1)));
        while (!game.isValidMove(tttMove)) {
            tttMove = new TicTacToeMove(tttGame.getPlayerMark(tttGame.getTurn()), (int) (Math.random() * (Board.DIM * Board.DIM + 1)));
        }

        return tttMove;
    }
}
