package ss.hotel.password;

public class Password {
    public static final String INITIAL = "abcdefghijkl";

    public String current;
    public Checker checker;

    public Password(Checker checker){
        this.checker = checker;
        this.current = INITIAL;
    }
    public Password() {
        this(new BasicChecker());
    }

    public String getInitPass() {
        return INITIAL;
    }

    public Checker getChecker() {
        return checker;
    }

    public String generatePassword() {
        return checker.generatePassword();
    }

    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     * @param suggestion Word that should be tested
     * @return true If suggestion is acceptable
     */

    public boolean acceptable(String suggestion){
        return checker.acceptable(suggestion);
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
    public boolean testWord(String test){
        return test.equals(current);
    }
}
