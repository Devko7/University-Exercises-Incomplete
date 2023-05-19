package ss.hotel;

public class Hotel {
    private String name;
    protected Room room1 = new Room(101);
    protected Room room2 = new Room(102);
    private Guest guest1;
    private Guest guest2;

    public Hotel(String hotel) {
        this.name = hotel;
    }

    /*@ ensures name != null;
    @ ensures room1 != null;
    @ ensures room2 != null;
    */
    public Room checkIn (String name) {
        if (room1.getGuest() == null) {
            guest1 = new Guest(name);
            guest1.checkin(room1);
            return room1;
        } else if (room2.getGuest() == null) {
            guest2 = new Guest(name);
            guest2.checkin(room2);
            return room2;
        }
        return null;
    }

    /*@ requires checkIn(name) != null;
    @ ensures name != null;
    @ ensures room1 != null;
    @ ensures room2 != null;
    */
    public void checkOut(String name) {
        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
            guest1.checkout();
            room1.getSafe().deactivate();
            room1.setGuest(null);
        }
        if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
            guest2.checkout();
            room2.getSafe().deactivate();
            room2.setGuest(null);
        }
    }

    /*@ requires checkIn(name) == null;
    @ ensures room1 != null;
    @ ensures room2 != null;
    */
    public Room getFreeRoom() {
        if (room1.getGuest() == null) {
            return room1;
        }

        if (room2.getGuest() == null) {
            return room2;
        }
        return null;
    }

    /*@ requires checkIn(name) != null;
    @ ensures name != null;
    @ ensures room1 != null;
    @ ensures room2 != null;
    */
    public Room getRoom(String name) {
        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
            return room1;
        }
        else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
            return room2;
        }
        return null;
    }

    public String toString() {
        if (room1.getGuest() != null && room2.getGuest() != null) {
            return "Room: " + room1.getNumber() + " - Guest: " + guest1.getName() + " - Activated safe: " + room1.getSafe().isActive() +  " - Opened safe: " + room1.getSafe().isOpen() + "\n" +
                    "Room: " + room2.getNumber() + " - Guest: " + guest2.getName() + " - Activated safe: " + room2.getSafe().isActive() +  " - Opened safe: " + room2.getSafe().isOpen();
        }
        else if (room1.getGuest() != null && room2.getGuest() == null) {
            return "Room: " + room1.getNumber() + " - Guest: " + guest1.getName() + " - Activated safe: " + room1.getSafe().isActive() +  " - Opened safe: " + room1.getSafe().isOpen() + "\n" +
                    "Room: " + room2.getNumber() + " - Unoccupied " + " - Activated safe: " + room2.getSafe().isActive() +  " - Opened safe: " + room2.getSafe().isOpen();
        }
        else if (room1.getGuest() == null && room2.getGuest() != null) {
            return "Room: " + room1.getNumber() + " - Unoccupied" + " - Activated safe: " + room1.getSafe().isActive() +  " - Opened safe: " + room1.getSafe().isOpen() + "\n" +
                    "Room: " + room2.getNumber() + " - Guest: " + guest2.getName() + " - Activated safe: " + room2.getSafe().isActive() +  " - Opened safe: " + room2.getSafe().isOpen();
        }
        else  {
            return "Room: " + room1.getNumber() + " - Unoccupied" + " - Activated safe: " + room1.getSafe().isActive() +  " - Opened safe: " + room1.getSafe().isOpen() + "\n" +
                    "Room: " + room2.getNumber() + " - Unoccupied " + " - Activated safe: " + room2.getSafe().isActive() +  " - Opened safe: " + room2.getSafe().isOpen();
        }
    }
}
