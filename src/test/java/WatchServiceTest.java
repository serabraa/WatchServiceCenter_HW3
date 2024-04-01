import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class WatchServiceTest {
    @Test
    void testReplaceBattery() {
        assertTrue(WatchService.replaceBattery("Quartz"));
        assertFalse(WatchService.replaceBattery("Quar"));
        assertFalse(WatchService.replaceBattery("Mechanical"));
        assertFalse(WatchService.replaceBattery("wrong thing"));

    }

    @Test
    void testSwitchStrap() {
        assertTrue(WatchService.switchStrap(28.0f, 27.5f));
        assertTrue(WatchService.switchStrap(28.0f, 28.0f));
        assertTrue(WatchService.switchStrap(28.0f, 27.7f));
        assertTrue(WatchService.switchStrap(28.0f, 27.99f));
        assertFalse(WatchService.switchStrap(27.0f, 27.5f));
        assertFalse(WatchService.switchStrap(27.0f, 27.1f));
        assertFalse(WatchService.switchStrap(27.0f, 27.01f));
        assertFalse(WatchService.switchStrap(27.0f, 100.0f));

    }

    @Test
    void testWatchAccuracyCheck() {
        assertEquals(1, WatchService.watchAccuracyCheck(0));
        assertEquals(1, WatchService.watchAccuracyCheck(-4.0f));
        assertEquals(1, WatchService.watchAccuracyCheck(-3.99f));
        assertEquals(1, WatchService.watchAccuracyCheck(5.99f));
        assertEquals(1, WatchService.watchAccuracyCheck(6.00f));
        assertEquals(1, WatchService.watchAccuracyCheck(2.5f));
        assertEquals(1, WatchService.watchAccuracyCheck(-2.3f));
        assertEquals(2, WatchService.watchAccuracyCheck(15.0f));
        assertEquals(2, WatchService.watchAccuracyCheck(14.4f));
        assertEquals(2, WatchService.watchAccuracyCheck(14.999f));
        assertEquals(2, WatchService.watchAccuracyCheck(-14.999f));
        assertEquals(2, WatchService.watchAccuracyCheck(-15.0f));
        assertEquals(2, WatchService.watchAccuracyCheck(12.0f));
        assertEquals(2, WatchService.watchAccuracyCheck(-12.0f));
        assertEquals(-1, WatchService.watchAccuracyCheck(90f));
        assertEquals(-1, WatchService.watchAccuracyCheck(10000f));
        assertEquals(-1, WatchService.watchAccuracyCheck(-10000f));
        assertEquals(-1, WatchService.watchAccuracyCheck(-15.01f));
        assertEquals(-1, WatchService.watchAccuracyCheck(15.01f));
    }

    @Test
    void testWatchMagnetismCheck() {
        assertEquals(0, WatchService.watchMagnetismCheck(100.0f));
        assertEquals(0, WatchService.watchMagnetismCheck(99.9f));
        assertEquals(0, WatchService.watchMagnetismCheck(87.51f));
        assertEquals(0, WatchService.watchMagnetismCheck(87.5f));
        assertEquals(1, WatchService.watchMagnetismCheck(87.49f));
        assertEquals(1, WatchService.watchMagnetismCheck(87.499f));
        assertEquals(1, WatchService.watchMagnetismCheck(80.0f));
        assertEquals(1, WatchService.watchMagnetismCheck(13.3f));
        assertEquals(-1, WatchService.watchMagnetismCheck(-100.01f));
        assertEquals(-1, WatchService.watchMagnetismCheck(-112320.0f));
        assertEquals(-1, WatchService.watchMagnetismCheck(10000.0f));
        assertEquals(-1, WatchService.watchMagnetismCheck(100.01f));
        assertEquals(-1, WatchService.watchMagnetismCheck(-0.01f));
    }

}
