package ss.hotel;

import ss.hotel.bill.BillPrinter;
import ss.hotel.bill.StringBillPrinter;
import ss.hotel.bill.SysoutBillPrinter;
import ss.hotel.password.Password;

import java.util.Scanner;

public class PricedHotelTUI {

    private BillPrinter billPrinter;
    private PricedHotel hotel;
    static final String IN = "in";
    static final String OUT = "out";
    static final String ROOM = "room";
    static final String ACTIVATE = "activate";
    static final String PRINT = "print";
    static final String HELP = "help";
    static final String EXIT = "exit";
    static final String BILL = "bill";

    public PricedHotelTUI (String hotelName) {
        this.hotel = new PricedHotel(hotelName);
    }

    public void doIn (String name) {
        this.hotel.checkIn(name);
    }

    public void doOut (String name) {
        this.hotel.checkOut(name);
    }

    public void doActivate (String name) {
        assert this.hotel.getRoom(name).getSafe() instanceof Safe;
        this.hotel.getRoom(name).getSafe().activate();
    }

    public void doPricedActivate (String name, String pass) {
        assert this.hotel.getRoom(name).getSafe() instanceof PricedSafe;
        ((PricedSafe) this.hotel.getRoom(name).getSafe()).activate(pass);
    }

    public void doBill (String name, int nights, BillPrinter billPrinter) {
        this.billPrinter = billPrinter;
        this.hotel.getBill(name, nights, billPrinter);
    }

    public void run() {

        String menu = "Welcome to the Hotel management system of the \"Hotel Twente\"\n" +
                "Commands:\n" +
                "in name ................. check in guest with name\n" +
                "out name ................ check out guest with name\n" +
                "room name ............... request room of guest with name\n" +
                "activate name password........... activate safe, password required for PricedSafe\n" +
                "bill name nights......... print bill for guest (name) and number of nights\n" +
                "help .................... help (this menu)\n" +
                "print ................... print state\n" +
                "exit .................... exit";
        System.out.println(menu);

        Boolean exit = false;

        while (exit != true) {

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            String[] split = line.split("\\s+");
            String command = split[0];
            String param = "";
            String param2 = "";

            if (split.length == 2) {
                param = split[1];
            }
            else if (split.length > 2) {
                param = split[1];
                param2 = split[2];
            }

            switch (command) {
                case BILL:
                    if (param.equals("") && param2.equals("")) {
                        System.out.println("Error no input");
                    }
                    else if (this.hotel.getRoom(param) != null && this.hotel.getRoom(param) instanceof PricedRoom) {
                        BillPrinter billPrinter = new SysoutBillPrinter();
                        this.doBill(param, Integer.parseInt(param2), billPrinter);
                    }
                    else {
                        System.out.println("Error guest cannot be billed.");
                    }
                    break;
                case IN:
                    if (param == null) {
                        System.out.println("Error no input");
                    }
                    else if (this.hotel.getFreeRoom() != null) {
                        this.doIn(param);
                        System.out.println("Guest " + param + " successfully checked in " + this.hotel.getRoom(param));
                    }
                    else {
                        System.out.println("Error");
                    }
                    break;
                case OUT:
                    if (param == null) {
                        System.out.println("Error no input");
                    }
                    else if (this.hotel.getRoom(param) == null) {
                        System.out.println("This guest has no assigned room.");
                    }
                    else {
                        this.doOut(param);
                        System.out.println("Guest " + param + " successfully checked out.");
                    }
                    break;
                case ROOM:
                    if (param == null) {
                        System.out.println("Error no input");
                    }
                    else {

                        if (this.hotel.getRoom(param) == null) {
                            System.out.println("Error");
                        }
                        else {
                            System.out.println(this.hotel.getRoom(param));
                        }
                    }
                    break;
                case ACTIVATE:
                    if (param.equals("")) {
                        System.out.println("Error no input");
                    }
                    else if (this.hotel.getRoom(param) == null) {
                        System.out.println("Error guest is not assigned to any room.");
                    }
                    else if (this.hotel.getRoom(param) != null && this.hotel.getRoom(param) instanceof PricedRoom) {

                        String CORRECT_PASSWORD = ((PricedSafe) this.hotel.getRoom(param).getSafe()).getPassword().getInitPass();

                        if (this.hotel.getRoom(param).getSafe() instanceof PricedSafe && param2.equals(CORRECT_PASSWORD)) {
                            assert param2 != null;
                            this.doPricedActivate(param, param2);
                            System.out.println("Priced Safe successfully activated.");
                        }
                        else if (this.hotel.getRoom(param).getSafe() instanceof PricedSafe && !param2.equals(CORRECT_PASSWORD)) {
                            System.out.println("Incorrect password.");
                        }
                        else if (this.hotel.getRoom(param).getSafe() instanceof PricedSafe && param2.equals("")) {
                            System.out.println("Wrong params at activation (password required)\n");
                        }
                    }
                    else if (this.hotel.getRoom(param) != null && this.hotel.getRoom(param) instanceof Room) {
                        if (this.hotel.getRoom(param).getSafe() instanceof Safe && param2.equals("")) {
                            this.doActivate(param);
                            System.out.println("Safe successfully activated.");
                        }
                        else {
                            System.out.println("Room does not have a priced safe (no password required)");
                        }
                    }
                    break;
                case PRINT:
                    System.out.println(this.hotel.toString());
                    break;
                case HELP:
                    System.out.println(menu);
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Error, undefined command.");
                    System.out.println(menu);
                    break;
            }

        }

    }

    public static void main(String[] args) {
        PricedHotelTUI kur = new PricedHotelTUI("Hotel Twente");
        kur.run();
    }
}
