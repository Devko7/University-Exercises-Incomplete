package ss.hotel;

import ss.hotel.bill.Bill.Item;

public class PricedRoom extends Room implements Item {

    private double price;

    /**
     * Creates a priced room with a priced safe
     * @param number
     * @param price
     * @param SafePrice
     */
    public PricedRoom(int number, double price, double SafePrice) {
        super(number, new PricedSafe(SafePrice));
        this.price = price;
    }

    /**
     * Returns the price of the room
     * @return the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Gives the string of the room number and the price per night
     * @return the string of the room number and the price per night
     */
    public String toString() {
        return "Room: " + super.getNumber() + " price per night: " + this.price;
    }

}
