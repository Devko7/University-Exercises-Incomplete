package ss.tictactoe.model;

public class TicTacToeMove implements Move {
    private Mark mark;
    private int index;

    public TicTacToeMove(Mark mark, int index) {
        this.mark = mark;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Mark getMark() {
        return mark;
    }
}
