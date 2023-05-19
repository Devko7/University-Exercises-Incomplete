package ss.hotel;

public class Guest {

    private Room room;
    private String name;

    /**
     * Creates a Guest with the given name and without Room.
     * @param name
     */
    //@ ensures getName() == name;
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the guest.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the Room that is rented by this Guest.
     * @return Room rented by this Guest; null if this Guest does not rent a room
     */
    public Room getRoom() {

        if (this.room == null) {
            return null;
        }
        else {
            return this.room;
        }
    }

    /**
     * Rents a Room to this Guest.
     * This is only possible if this Guest does not already have a Room,
     * and the Room to be assigned is not already rented.
     * Also adapts the Guest reference of the Room.
     * @param room
     * @return true if checkin succeeded; false if this Guest already had a Room, or the Room already had a Guest.
     */
    //@ requires room != null;
    public boolean checkin(Room room) {

        if (room.getGuest() == null || this.room != null) {
            room.setGuest(this);
            this.room = room;
            return true;
        }
        return false;
    }

    /**
     * Sets the Room of this Guest to null. Also resets the Guest-reference of the (current) Room.
     * @return true if this action succeeded; false if Guest does not have a Room when this method is called.
     */
    public boolean checkout() {

        if (this.room != null) {
            room.setGuest(null);
            this.room = null;
            return true;
        }
            return false;
    }

    public String toString() {
        return "Guest: " + this.name;
    }

}
