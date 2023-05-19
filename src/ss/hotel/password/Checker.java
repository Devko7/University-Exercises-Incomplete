package ss.hotel.password;

public interface Checker {

    boolean acceptable(String text);
    String generatePassword();
}
