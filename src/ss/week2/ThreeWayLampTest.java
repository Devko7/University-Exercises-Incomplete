package ss.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week2.ThreeWayLamp;

public class ThreeWayLampTest {

    private ThreeWayLamp mode;

    @BeforeEach
    public void setUp() {
        mode = new ThreeWayLamp();
    }

    @Test
    public void testSetting(){
        mode.getSetting();
        assertEquals(ThreeWayLamp.LampSetting.OFF, mode.getSetting());
    }

    @Test
    public void testSwitch(){
        mode.Switch();
        assertEquals(ThreeWayLamp.LampSetting.LOW, mode.getSetting());
        mode.Switch();
        assertEquals(ThreeWayLamp.LampSetting.MEDIUM, mode.getSetting());
        mode.Switch();
        assertEquals(ThreeWayLamp.LampSetting.HIGH, mode.getSetting());
        mode.Switch();
        assertEquals(ThreeWayLamp.LampSetting.OFF, mode.getSetting());
    }

}
