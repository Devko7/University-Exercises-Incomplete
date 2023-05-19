package ss.hotel;
import ss.hotel.bill.Bill.Item;
import ss.hotel.password.Password;

public class PricedSafe extends Safe implements Item {

    private Password password;
    private double price;

    /**
     * Creates a PricedSafe
     * @param price
     */
    public PricedSafe(double price) {
        this.price = price;
        this.password = new Password();
    }

    /**
     * Returns the price of the safe
     * @return the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Activates the safe if the correct password is filled in
     * @param newPass
     */
    //@ requires password != null;
    public void activate(String newPass) {
        assert password != null;
        if (password.testWord(newPass)) {
            super.activate();
        }
    }

    /**
     * Overrides activate if a password is not inputted
     */
    @Override
    public void activate() {
        System.out.println("Error invalid password.");
    }

    /**
     * Deactivates the safe and closes it
     */
    public void deactivate() {
        super.close();
        super.deactivate();
    }

    /**
     * Opens the safe if the given password is correct and the safe is activated
     * @param newPass
     */
    //@ requires password != null;
    public void open(String newPass) {
        assert password != null;
        if (password.testWord(newPass) && super.isActive()) {
            super.open();
        }
    }

    /**
     * Overrides open if a password is not given
     */
    @Override
    public void open() {
        System.out.println("Error invalid password.");
    }

    /**
     * Closes the safe
     */
    public void close() {
        super.close();
    }

    /**
     * Returns the password of the safe
     * @return password
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Returns the string of the price of the safe
     * @return string of the price
     */
    public String toString() {
        return "The price of the safe is " + this.price + ".";
    }

    public static void main(String[] args) {
        PricedSafe newSafe = new PricedSafe(12.0);
        newSafe.activate();
        newSafe.open();
    }
}
