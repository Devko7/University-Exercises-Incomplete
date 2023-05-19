package ss.hotel.bill;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BillTest {
    private Bill bill;
    private BillPrinter billPrinter;

    public class Item {

        private String text;
        private double price;

        public Item(String text, double price) {
            this.text = text;
            this.price = price;
        }

        public String toString() {
            return text;
        }

        public double getPrice() {
            return price;
        }

    }

    @BeforeEach
    public void setUp() {
        billPrinter = new StringBillPrinter();
        bill = new Bill(billPrinter);
    }

    @Test
    public void testBeginState() {
        assertEquals(0.0, bill.getSum());
        assertFalse(billPrinter.toString().contains("Total"));
    }

    @Test
    public void testNewItem() {
        Item item = new Item("chicken", 12.3);
        assertEquals(12.3, item.getPrice(), 0.001);
        assertTrue(item.toString().contains("chicken"));
    }
}
