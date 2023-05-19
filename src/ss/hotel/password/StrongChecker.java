package ss.hotel.password;

public class StrongChecker extends BasicChecker implements Checker {

    public boolean acceptable(String text){
        Character first = text.charAt(0);
        Character last = text.charAt(text.length() - 1);
        return super.acceptable(text) && last.isDigit(last) && !first.isDigit(first);
    }

    public String generatePassword() {
        return "abcdefghijkl";
    }
}
