package ss.tictactoe.model;

import ss.tictactoe.ai.Strategy;

public class ComputerPlayer extends AbstractPlayer {

    private Mark mark;
    private Strategy strategy;



    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + " - " + mark.toString());
        this.mark = mark;
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Move determineMove(Game game) {
        return strategy.determineMove(game);
    }
}
