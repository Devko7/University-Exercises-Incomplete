package ss.week2;

public class ThreeWayLamp {

    /**
     * Possible settings of a ThreeWayLamp
     */

    //@ pure
    public enum LampSetting {
        OFF, LOW, MEDIUM, HIGH
    }

    private LampSetting setting;

    /**
     * Creates a lamp that is set to setting: OFF
     */

    //@ ensures setting == LampSetting.OFF;
    public ThreeWayLamp() {
        setting = LampSetting.OFF;
    }

    /**
     * returns the current setting of the lamp
     * @return setting
     */

    //@ ensures \result == LampSetting.OFF || \result == LampSetting.LOW || \result == LampSetting.MEDIUM || \result == LampSetting.HIGH;
    public LampSetting getSetting() {
        return setting;
    }

    /**
     * gives new state of the lamp
     * @param setting
     */

    //@ ensures getSetting() == setting;
    public void setSetting(LampSetting setting) {
        this.setting = setting;
    }

    /*@ ensures \old(getSetting()) == LampSetting.OFF ==> getSetting() == LampSetting.LOW;
    @ ensures \old(getSetting()) == LampSetting.LOW ==> getSetting() == LampSetting.MEDIUM;
    @ ensures \old(getSetting()) == LampSetting.MEDIUM ==> getSetting() == LampSetting.HIGH;
    @ ensures \old(getSetting()) == LampSetting.HIGH ==> getSetting() == LampSetting.OFF;
    @ ensures \result == setting;
    @*/
    public LampSetting Switch() {
        if (getSetting() == LampSetting.OFF){
            this.setting = LampSetting.LOW;
        }
        else if (getSetting() == LampSetting.LOW) {
            this.setting = LampSetting.MEDIUM;
        }
        else if (getSetting() == LampSetting.MEDIUM) {
            this.setting = LampSetting.HIGH;
        }
        else if (getSetting() == LampSetting.HIGH) {
            this.setting = LampSetting.OFF;
        }
        return setting;
    }
}
