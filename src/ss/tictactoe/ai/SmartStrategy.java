package ss.tictactoe.ai;

import ss.tictactoe.model.*;

public class SmartStrategy implements Strategy {

    @Override
    public String getName() {
        return "Smart";
    }

    private Move findWinningMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;
        for (Move testWinningMove : tttGame.getValidMoves()) {
            TicTacToeGame tttGameDeepCopy = tttGame.deepCopy();
            tttGameDeepCopy.doMove(testWinningMove);
            if (tttGameDeepCopy.getBoard().hasWinner()) {
                return testWinningMove;
            }
        }
        return null;
    }


    private Move denyMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;                                           //turn starts at AI

        TicTacToeGame tttGameDeepCopy = tttGame.deepCopy();
        tttGameDeepCopy.switchTurn();                                                           //turn is at other

    if (findWinningMove(tttGameDeepCopy) != null) {
            TicTacToeMove tttMoveToDeny = (TicTacToeMove) findWinningMove(tttGameDeepCopy);
            int index = tttMoveToDeny.getIndex();
            tttGameDeepCopy.switchTurn();                                                       //turn is at AI
            return new TicTacToeMove(tttGameDeepCopy.getPlayerMark(tttGameDeepCopy.getTurn()), index);
        }
        return randomMove(game);
    }

    private Move randomMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;
        TicTacToeMove tttMove = new TicTacToeMove(tttGame.getPlayerMark(tttGame.getTurn()), (int) (Math.random() * (Board.DIM * Board.DIM + 1)));
        while (!game.isValidMove(tttMove)) {
            tttMove = new TicTacToeMove(tttGame.getPlayerMark(tttGame.getTurn()), (int) (Math.random() * (Board.DIM * Board.DIM + 1)));
        }

        return tttMove;
    }


    /**
     * If there is a move that guarantees a direct win, this move is returned.
     * If there is a move after which the opponent has a winning move, then this move is not allowed.
     * If no move is allowed after this, then return a random move.
     * If none of the cases above applies, a random allowed is returned
     * @param game the game to be checked
     * @return smart move is possible, otherwise random move
     */


    @Override
    public Move determineMove(Game game) {
        TicTacToeGame tttGame = (TicTacToeGame) game;

        //winning move if possible
        if (findWinningMove(tttGame) != null) {
            return findWinningMove(tttGame);

        } else {
            return denyMove(game);
        }
    }
}