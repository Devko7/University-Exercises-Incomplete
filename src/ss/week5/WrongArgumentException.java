package ss.week5;

public class WrongArgumentException extends Exception {

    private String msg;
    public WrongArgumentException() {
        this.msg = "wrong argument error.";
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
