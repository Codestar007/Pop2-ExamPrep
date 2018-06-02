import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedOfSoundTest {
    @Test(expected = NullPointerException.class)
    public void get_distance_travelled_in_seconds_null_medium() {
        SpeedOfSound.getDistanceTraveledInSeconds(null, 333);
    }

    @Test
    public void get_distance_travelled_in_seconds_air() {
        double val = SpeedOfSound.getDistanceTraveledInSeconds("air", 1100);
        Assert.assertEquals(1, val, 0);
    }

    @Test
    public void get_distance_travelled_in_seconds_water() {
        double val = SpeedOfSound.getDistanceTraveledInSeconds("water", 4900);
        Assert.assertEquals(1, val, 0);
    }

    @Test
    public void get_distance_travelled_in_seconds_steel() {
        double val = SpeedOfSound.getDistanceTraveledInSeconds("steel", 16400);
        Assert.assertEquals(1, val, 0);
    }


    @Test
    public void get_distance_travelled_in_seconds_nothing() {
        double val = SpeedOfSound.getDistanceTraveledInSeconds("", 16400);
        Assert.assertEquals(0, val, 0);
    }
}