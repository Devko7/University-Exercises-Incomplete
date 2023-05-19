package ss.hotel.password;

public class BasicChecker implements Checker {
    public boolean acceptable(String text) {
        return text.length() >= 6 && !text.contains(" ");
    }

    public String generatePassword() {
        return "abcdefghijkl";
    }
}
