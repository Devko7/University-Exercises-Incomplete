package ss.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.BillPrinter;

public class PricedHotel extends Hotel {

    public static final double ROOM_PRICE = 100;
    public static final double SAFE_PRICE = 10;

    public PricedHotel(String HotelName) {
        super(HotelName);
        room1 = new PricedRoom(101, ROOM_PRICE, SAFE_PRICE);
    }

    public Bill getBill(String guest, int nights, BillPrinter billPrinter) {

        Room guest_room = getRoom(guest);
        Safe guest_safe = guest_room.getSafe();

        assert guest_room != null;

        if (guest_room instanceof PricedRoom) {

            Bill bill = new Bill(billPrinter);

            for (int i = 0; nights > i; i++) {

                bill.addItem((PricedRoom) guest_room);
                ((PricedRoom) guest_room).getPrice();

            }

            if (guest_safe instanceof PricedSafe && guest_safe.isActive()) {
                bill.addItem((PricedSafe) guest_safe);
            }
            bill.close();
            return bill;
        }
        return null;
    }
}
