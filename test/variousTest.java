import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by kjeged01 on 01/06/2018.
 */
public class variousTest {
    @Test
    public void getInfoTest() throws Exception {
        various me = new various();
        Integer myAge = 50;
        String myName = "Kizi";
        String expected = "My name is Kizi and I am 50 years old!";
        assert expected.equalsIgnoreCase(me.getInfo(50, "Kizi"));
        assertFalse(expected.equalsIgnoreCase(me.getInfo(50, "Fred")));
    }

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void main() throws Exception {

    }

}