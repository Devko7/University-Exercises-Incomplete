package ss.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;

    @BeforeEach
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
        safe = new Safe();
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }

    @Test
    public void testSafe() {
        assertEquals(false, safe.isActive());
        assertEquals(false, safe.isOpen());
    }

}
