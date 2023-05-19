package ss.week2;

import ss.week2.ThreeWayLamp;

import java.util.Scanner;

public class ThreeWayLampTUI {

    public ThreeWayLamp lamp;

    public ThreeWayLampTUI() {
        this.lamp = new ThreeWayLamp();
    }

    private void run() {

        String help = "If you type OFF the state of the lamp will be turned to OFF. \n If you type LOW the state of the lamp will be turned to LOW. \n If you type MEDIUM the state of the lamp will be turned to MEDIUM. \n If you type HIGH the state of the lamp will be turned to HIGH. \n If you type NEXT the next state of the lamp will be set. \n If you type STATE the current state of the lamp will be shown. \n If you type EXIT you will quit the program.";

        boolean exit = false;

        while (exit == false) {

            Scanner input = new Scanner(System.in);
            String command = input.nextLine();

            switch (command) {
                case "OFF":
                    lamp.setSetting(ThreeWayLamp.LampSetting.OFF);
                    break;
                case "LOW":
                    lamp.setSetting(ThreeWayLamp.LampSetting.LOW);
                    break;
                case "MEDIUM":
                    lamp.setSetting(ThreeWayLamp.LampSetting.MEDIUM);
                    break;
                case "HIGH":
                    lamp.setSetting(ThreeWayLamp.LampSetting.HIGH);
                    break;
                case "STATE":
                    System.out.println(lamp.getSetting());
                    break;
                case "NEXT":
                    lamp.Switch();
                    break;
                case "HELP":
                    System.out.println(help);
                    break;
                case "EXIT":
                    exit = true;
                    break;
                default:
                    System.out.println("Error: Invalid input.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        ThreeWayLampTUI kur = new ThreeWayLampTUI();
        kur.run();
    }
}
