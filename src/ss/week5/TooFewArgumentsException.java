package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException {

    private String msg;

    public TooFewArgumentsException() {
        this.msg = "error: too few command line arguments";
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
