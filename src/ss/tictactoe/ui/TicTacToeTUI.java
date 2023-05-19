package ss.tictactoe.ui;


import ss.tictactoe.ai.NaiveStrategy;
import ss.tictactoe.ai.SmartStrategy;
import ss.tictactoe.model.*;

import java.util.Scanner;

public class TicTacToeTUI {
    Scanner input = new Scanner(System.in);

    public void run() {

        System.out.println("What is the name of player 1 (mark X)? Type [-S] for big brain AI, [-N] for small brain AI.");
        String name1 = input.nextLine();
        AbstractPlayer player1;
        switch (name1) {
            case "-N":
                player1 = new ComputerPlayer(Mark.XX, new NaiveStrategy());
                System.out.println("Player1 is an AI with naive strategy.");
                break;
            case "-S":
                player1 = new ComputerPlayer(Mark.XX, new SmartStrategy());
                System.out.println("Player1 is an AI with smart strategy.");
                break;
            default:
                player1 = new HumanPlayer(name1);
                System.out.println("Player1 is a human player with name " + name1);
        }
        System.out.println("What is the name of player 2 (mark O)? Type [-S] for big brain AI, [-N] for small brain AI.");
        String name2 = input.nextLine();
        AbstractPlayer player2;
        switch (name2) {
            case "-N":
                player2 = new ComputerPlayer(Mark.OO, new NaiveStrategy());
                System.out.println("Player2 is an AI with naive strategy.");
                break;
            case "-S":
                player2 = new ComputerPlayer(Mark.OO, new SmartStrategy());
                System.out.println("Player2 is an AI with smart strategy.");
                break;
            default:
                player2 = new HumanPlayer(name2);
                System.out.println("Player2 is a human player with name " + name2);
        }


        System.out.println("LETS GO");

        TicTacToeGame tttGame = new TicTacToeGame(player1, player2);

        while (!tttGame.isGameover()) {
            System.out.println(tttGame);
            if (tttGame.getTurn().equals(player1)) {
                tttGame.doMove(player1.determineMove(tttGame));
            } else if (tttGame.getTurn().equals(player2)) {
                tttGame.doMove(player2.determineMove(tttGame));
            }
            tttGame.switchTurn();
        }
        System.out.println(tttGame.toString2());
        if (tttGame.getWinner() != null) {
            System.out.println("WINNER WINNER CHICKEN DINNER " + tttGame.getWinner().toString());
        } else {
            System.out.println("Both of you are losers");
        }
        System.out.println("Type [Y] if you want to play again, else exit the program.");
        String playAgain = input.nextLine();

        if (playAgain.equals("Y")) {
            TicTacToeTUI tui = new TicTacToeTUI();
            tui.run();
        }
    }

    public static void main(String[] args) {
        TicTacToeTUI TUI = new TicTacToeTUI();
        TUI.run();
    }
}
