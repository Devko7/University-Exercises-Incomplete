package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException {

    private String msg;
    private double arg1;
    private double arg2;
    public ArgumentLengthsDifferException(double arg3, double arg4) {
        this.arg1 = arg3;
        this.arg2 = arg4;
        assert arg3 != arg4;
        this.msg = "error: length of command line arguments differ (" + arg3 + ", " + arg4 + ")";
    }

    @Override
    public String getMessage() {
        return msg;
    }

}
