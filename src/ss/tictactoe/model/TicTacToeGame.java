package ss.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements Game {

    private Board board;
    private Player player1X;
    private Player player2O;
    private boolean player1HasTurn;

    public TicTacToeGame(Player player1X, Player player2O) {
        this.player1X = player1X;
        this.player2O = player2O;
        board = new Board();
        player1HasTurn = true;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public boolean isGameover() {
        return board.gameOver();
    } //DONE

    @Override
    public Player getTurn() {
        if (player1HasTurn) {
            return player1X;
        } else {
            return player2O;
        }
    } //DONE

    public Player getOtherTurn() {
        if (player1HasTurn) {
            return player2O;
        } else {
            return player1X;
        }
    }

    public void switchTurn() {
        if (getTurn() == player1X) {
            player1HasTurn = false;
        } else {
            player1HasTurn = true;
        }
    }

    @Override
    public Player getWinner() {
        if (board.isWinner(Mark.XX)) {
            return player1X;
        } else if (board.isWinner(Mark.OO)) {
            return player2O;
        } else {
            return null;
        }
    } //DONE

    @Override
    public List<Move> getValidMoves() {
        ArrayList<Move> validMoves = new ArrayList<>();
        for (int i = 0; i < Board.DIM * Board.DIM; i++) {
            if (getTurn() == player1X && board.isField(i) && board.isEmptyField(i)) {
                TicTacToeMove tttMove = new TicTacToeMove(Mark.XX, i);
                validMoves.add(tttMove);
            } else if (getTurn() == player2O && board.isField(i) && board.isEmptyField(i)) {
                TicTacToeMove tttMove = new TicTacToeMove(Mark.OO, i);
                validMoves.add(tttMove);
            }
        }
        return validMoves;
    } //DONE -- UNUSED?


    @Override
    public boolean isValidMove(Move move) {
        TicTacToeMove tttMove = (TicTacToeMove) move;
        if (getTurn() == player1X) {
            return tttMove.getMark() == Mark.XX &&
                    !board.gameOver() &&
                    board.isField(tttMove.getIndex()) &&
                    board.isEmptyField(tttMove.getIndex());
        } else if (getTurn() == player2O) {
            return tttMove.getMark() == Mark.OO &&
                    !board.gameOver() &&
                    board.isField(tttMove.getIndex()) &&
                    board.isEmptyField(tttMove.getIndex());
        }
        return false;
    } //DONE

    @Override
    public void doMove(Move move) {
        TicTacToeMove tttMove = (TicTacToeMove) move;
        board.setField(tttMove.getIndex(), tttMove.getMark());
    } //DONE

    public String toString() {

        if (getTurn() == player1X) {
            return board.toString() + "\nTurn is at " + player1X.toString() + " - Mark X.";
        } else {
            return board.toString() + "\nTurn is at " + player2O.toString() + " - Mark O.";
        }
    } //DONE

    public String toString2() {
        return board.toString();
    } //DONE

    public Mark getPlayerMark(Player player) {
        if (player.equals(player1X)) {
            return Mark.XX;
        } else if (player.equals(player2O)) {
            return Mark.OO;
        } else {
            return null;
        }
    } //DONE

    public TicTacToeGame deepCopy() {
        TicTacToeGame copiedtttGame = new TicTacToeGame(player1X, player2O);
        copiedtttGame.board = this.board.deepCopy();
        copiedtttGame.player1HasTurn = this.player1HasTurn;
        return copiedtttGame;
    }
}