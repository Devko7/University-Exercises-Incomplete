package ss.hotel;

import java.util.Scanner;

public class HotelTUI {
    private Hotel hotel;
    static final String IN = "in";
    static final String OUT = "out";
    static final String ROOM = "room";
    static final String ACTIVATE = "activate";
    static final String PRINT = "print";
    static final String HELP = "help";
    static final String EXIT = "exit";

    public HotelTUI (String hotelName) {
        this.hotel = new Hotel (hotelName);
    }

    public void doIn (String name) {
        this.hotel.checkIn(name);
    }

    public void doOut (String name) {
        this.hotel.checkOut(name);
    }

    public void doActivate (String name) {
        this.hotel.getRoom(name).getSafe().activate();
    }

    public void run() {

        String menu = "Welcome to the Hotel management system of the \"Hotel Twente\"\n" +
                "Commands:\n" +
                "in name ................. check in guest with name\n" +
                "out name ................ check out guest with name\n" +
                "room name ............... request room of guest with name\n" +
                "activate name ........... activate safe of guest with name\n" +
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
            String param = null;

            if (split.length > 1) {
                param = split[1];
            }

            switch (command) {
                case IN:
                    if (param == null) {
                        System.out.println("Error");
                    }
                    else if (this.hotel.getFreeRoom() != null) {
                        this.doIn(param);
                        System.out.println("Guest successfully checked in.");
                    }
                    else {
                        System.out.println("Error");
                    }
                    break;
                case OUT:
                    if (param == null) {
                        System.out.println("Error");
                    }
                    else if (this.hotel.getRoom(param) == null) {
                        System.out.println("Error");
                    }
                    else {
                        this.doOut(param);
                        System.out.println("Guest successfully checked out.");
                    }
                    break;
                case ROOM:
                    if (param == null) {
                        System.out.println("Error");
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
                    if (param == null) {
                        System.out.println("Error");
                    }
                    else if (this.hotel.getRoom(param) == null) {
                        System.out.println("Error");
                    }
                    else {
                        this.doActivate(param);
                        System.out.println("Safe successfully activated.");
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
        HotelTUI kur = new HotelTUI("Hotel Twente");
        kur.run();
    }
}