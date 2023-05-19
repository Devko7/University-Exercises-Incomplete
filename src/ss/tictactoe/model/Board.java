package ss.tictactoe.model;

import java.util.Arrays;

/**
 * Board for the Tic Tac Toe game.
 */
public class Board {
    /*@ public invariant fields.length == DIM*DIM;
        public invariant (\forall int i; (i >= 0 && i < DIM*DIM);
        fields[i] == Mark.EMPTY || fields[i] == Mark.XX || fields[i] == Mark.OO);
    @*/

    /**
     * Dimension of the board, i.e., if set to 3, the board has 3 rows and 3 columns.
     */
    public static final int DIM = 3;
    private static final String DELIM = "     ";
    private static final String[] NUMBERING = {
        " 0 | 1 | 2 ",
        "---+---+---",
        " 3 | 4 | 5 ",
        "---+---+---",
        " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     */
    private final Mark[] fields;

    // -- Constructors -----------------------------------------------
    /**
     * Creates an empty board.
     */
    //@ ensures (\forall int i; (i >= 0 && i < DIM*DIM); fields[i] == Mark.EMPTY);
    public Board() {
        this.fields = new Mark[DIM * DIM];
        reset();
    } //DONE

    /**
     * Creates a deep copy of this field.
     */
    /*@ ensures \result != this;
     ensures (\forall int i; (i >= 0 && i < DIM*DIM); \result.fields[i] == this.fields[i]);
     @*/
    public Board deepCopy() {
        Board copiedBoard = new Board();
        System.arraycopy(this.fields, 0, copiedBoard.fields, 0, DIM * DIM);
        return copiedBoard;
    } //DONE

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    /*@ requires row >= 0 && row < DIM;
    requires col >= 0 && row < DIM;
     @*/
    public int index(int row, int col) {
        if (row == 0) {
            return col;
        } else {
            return row * DIM + col;
        }
    } //DONE

    /**
     * Returns true if index is a valid index of a field on the board.
     * @return true if 0 <= index < DIM*DIM
     */
    //@ ensures index >= 0 && index < DIM*DIM ==> \result == true;
    public boolean isField(int index) {
        return index >= 0 && index < DIM * DIM;
    } //DONE

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    //@ ensures row >= 0 && row < DIM && col >= 0 && col < DIM ==> \result == true;
    public boolean isField(int row, int col) {
        return row >= 0 && row < DIM && col >= 0 && col < DIM;
    } //DONE

    /**
     * Returns the content of the field i.
     * @param i the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    /*@ requires isField(i);
    ensures \result == Mark.EMPTY || \result == Mark.OO || \result == Mark.XX;
     @*/
    public Mark getField(int i) {
        return fields[i];
    } //DONE

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     * @param row the row of the field
     * @param col the column of the field
     * @return the mark on the field
     */
    /*@ requires isField(row, col);
    ensures \result == Mark.EMPTY || \result == Mark.OO || \result == Mark.XX;
     @*/
    public Mark getField(int row, int col) {
        int index = DIM * row + col;
        return fields[index];
    } //DONE

    /**
     * Returns true if the field is empty.
     * @param i the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    /*@ requires isField(i);
    ensures getField(i) == Mark.EMPTY ==> \result == true;
     @*/
    public boolean isEmptyField(int i) {
        return getField(i) == Mark.EMPTY;
    } //DONE

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     * @param row the row of the field
     * @param col the column of the field
     * @return true if the field is empty
     */
    /*@ requires isField(row, col);
    ensures getField(row, col) == Mark.EMPTY ==> \result == true;
     @*/
    public boolean isEmptyField(int row, int col) {
        return getField(row, col) == Mark.EMPTY;
    } //DONE

    /**
     * Tests if the whole board is full.
     * @return true if all fields are occupied
     */
    //@ ensures (\forall int i; (i >= 0 && i < DIM*DIM); fields[i] == Mark.XX || fields[i] == Mark.OO);
    public boolean isFull() {
        return !Arrays.asList(fields).contains(Mark.EMPTY);
    } //DONE

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     * @return true if the game is over
     */
    //@ ensures isFull() || hasWinner() ==> \result == true;
    public boolean gameOver() {
        return isFull() || hasWinner();
    } //DONE

    /**
     * Checks whether there is a row which is full and only contains the same mark.
     * @param mark the Mark of interest
     * @return true if there is a row controlled by mark
     */
    public boolean hasRow(Mark mark) {
        int testRow = 0;
        for (int i = 0; i < DIM; i++) {

            for (int j = 0; j < DIM; j++) {
                if (!getField(i, j).equals(Mark.EMPTY) && getField(i, j).equals(mark)) {
                    testRow++;
                }
            }

            if (testRow == DIM) {
                return true;
            } else {
                testRow = 0;
            }
        }
        return false;
    } //DONE

    /**
     * Checks whether there is a column which is full and only contains the same mark.
     * @param mark the Mark of interest
     * @return true if there is a column controlled by mark
     */
    public boolean hasColumn(Mark mark) {
        int testColumn = 0;
        for (int i = 0; i < DIM; i++) {

            for (int j = 0; j < DIM; j++) {
                if (!getField(j, i).equals(Mark.EMPTY) && getField(j, i).equals(mark)) {
                    testColumn++;
                }
            }

            if (testColumn == DIM) {
                return true;
            } else {
                testColumn = 0;
            }
        }
        return false;
    } //DONE

    /**
     * Checks whether there is a diagonal which is full and only contains the same mark.
     * @param mark the Mark of interest
     * @return true if there is a diagonal controlled by mark
     */
    public boolean hasDiagonal(Mark mark) {
        int testDiagonalUp = 0;
        int testDiagonalDown = 0;

        for (int i = 0, j = DIM - 1; i < DIM && j >= 0; i++, j--) {

            if (!getField(j, i).equals(Mark.EMPTY) && getField(j, i) == mark) {
                testDiagonalUp++;
            }

            if (testDiagonalUp == DIM) {
                return true;
            }
        }

        for (int i = 0; i < DIM; i++) {

            if (!getField(i, i).equals(Mark.EMPTY) && getField(i, i) == mark) {
                testDiagonalDown++;
            }
            if (testDiagonalDown == DIM) {
                return true;
            }
        }
        return false;
    } //DONE


    /**
     * Checks if the mark has won. A mark wins if it controls at
     * least one row, column or diagonal.
     * @param mark the mark of interest
     * @return true if the mark has won
     */
    /*@ requires mark == Mark.XX || mark == Mark.OO;
    ensures hasRow(mark) || hasColumn(mark) || hasDiagonal(mark) ==> \result == true;
     @*/
    public boolean isWinner(Mark mark) {
        if (mark != Mark.EMPTY) {
            return hasRow(mark) || hasColumn(mark) || hasDiagonal(mark);
        } else {
            return false;
        }
    } //DONE

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     * @return true if the student has a winner.
     */
    //@ ensures isWinner(Mark.XX) || isWinner(Mark.OO) ==> \result == true;
    public boolean hasWinner() {
        return isWinner(Mark.XX) || isWinner(Mark.OO);
    } //DONE

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row += " " + getField(i, j).toString().substring(0, 1).replace("E", " ") + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    } //DONE

    /**
     * Empties all fields of this board (i.e., let them refer to the value EMPTY).
     */
    //@ ensures (\forall int i; (i >= 0 && i < DIM*DIM); fields[i] == Mark.EMPTY);
    public void reset() {
        for (int i = 0; i < DIM * DIM; i++) {
            setField(i, Mark.EMPTY);
        }
    } //DONE

    /**
     * Sets the content of field i to the mark m.
     * @param i the field number (see NUMBERING)
     * @param m the mark to be placed
     */
    /*@ requires isField(i);
    ensures getField(i) == m;
     @*/
    public void setField(int i, Mark m) {
        fields[i] = m;
    } //DONE

    /**
     * Sets the content of the field represented by
     * the (row,col) pair to the mark m.
     * @param row the field's row
     * @param col the field's column
     * @param m the mark to be placed
     */
    /*@ requires isField(row, col);
    ensures getField(row, col) == m;
     @*/
    public void setField(int row, int col, Mark m) {
        int index = DIM * row + col;
        fields[index] = m;
    } //DONE
}