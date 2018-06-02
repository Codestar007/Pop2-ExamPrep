import org.junit.Before;
import  org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    Point p = new Point(3, 4);

    @Test
    public void testGetX() {
        assertEquals(3.0, p.getX(), 0.00000001);
    }

    @Test
    public void testGetY() {
        assertEquals(4.0, p.getY(), 0.00000001);
    }

    @Test
    public void testTranslate() {
        Point transResult = p.translate(1,3);
        String result = "(" + transResult.getX() + ", " + transResult.getY() + ")";
        assertTrue("Actual transResult is: " + result,result.equals("(4.0, 7.0)"));
    }

    @Test
    public void testScale() {
        Point scaleResult = p.scale(0.5);
        String result = "(" + scaleResult.getX() + ", " + scaleResult.getY() + ")";
        assertTrue("Actual scaleResult is: " + result, result.equals("(1.5, 2.0)"));
    }
}