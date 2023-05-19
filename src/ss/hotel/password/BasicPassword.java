package ss.hotel.password;

public class BasicPassword implements Checker{

    public static final String INITIAL = "abcdefghijkl";
    public String current;

    /**
     * Constructs a Password with the initial word provided in INITIAL.
     */
    public BasicPassword() {
        current = INITIAL;
    }

    @Override
    public String generatePassword() {
        return "abcdefghijkl";
    }

    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     * @param suggestion Word that should be tested
     * @return true If suggestion is acceptable
     */
    @Override
    public boolean acceptable(String suggestion) {
        return suggestion.length() >= 6 && !suggestion.contains(" ");
    }

    /**
     * Changes this password.
     * @param oldpass The current password
     * @param newpass The new password
     * @return true If oldPass is equal to the current password and newPass is an acceptable password.
     */
    public boolean setWord(String oldpass, String newpass){
        if (oldpass.equals(current) && acceptable(newpass)) {
            current = newpass;
            return true;
        }
        return false;
    }

    /**
     * Tests if a given word is equal to the current password.
     * @param test Word that should be tested
     * @return true If test is equal to the current password
     */
    public boolean testWord(String test) {
        return test.equals(current);
    }

}
