package ss.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.hotel.bill.Bill;

import static org.junit.jupiter.api.Assertions.*;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
        		"GetPrice should return the price of the safe.");
    }

    @Test
    public void testGetPrice() {
        assertNotNull(safe.getPrice());
    }

    @Test
    public String toString() {
        assertTrue(safe.toString().contains("The price of the safe is " + safe.getPrice() + "."));
        return safe.toString();
    }

    @Test
    public void testDeactivatedCorrect() {
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testDeactivatedWrong() {
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testActivatedCorrect() {
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testActivatedWrong() {
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testActivateCorrectAndIncorrect() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertTrue(safe.isOpen());
    }

    @Test
    public void testActivatedCorrectAndClose() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testLastOne() {
        safe.close();
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
}
