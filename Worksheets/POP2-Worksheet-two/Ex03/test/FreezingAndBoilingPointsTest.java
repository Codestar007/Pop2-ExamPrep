import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.assertTrue;

public class FreezingAndBoilingPointsTest {
    private FreezingAndBoilingPoints freezeAndBoiling;

    @Test(expected = NullPointerException.class)
    public void test_isEthylAlchoolFreezing_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.ETHYLALCOHOL))
            assertTrue(freezeAndBoiling.isFreezing(null, elm));
    }

    @Test
    public void test_isEthylAlchoolFreezing() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) -174);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.ETHYLALCOHOL))
            assertTrue(freezeAndBoiling.isFreezing((double) -174, elm));
    }

    @Test(expected = NullPointerException.class)
    public void test_isEthylAlchoolBoiling_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.ETHYLALCOHOL))
            assertTrue(freezeAndBoiling.isBoiling(null, elm));
    }

    @Test
    public void test_isEthylAlchoolBoiling() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) 172);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.ETHYLALCOHOL))
            assertTrue(freezeAndBoiling.isBoiling((double) 172, elm));
    }

    @Test(expected = NullPointerException.class)
    public void test_isOxygenFreezing_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.OXYGEN))
            assertTrue(freezeAndBoiling.isFreezing(null, elm));
    }

    @Test
    public void test_isOxygenFreezing() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) -400);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.OXYGEN))
            assertTrue(freezeAndBoiling.isFreezing((double) -400, elm));
    }

    @Test
    public void test_isOxygenBoiling() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) -362);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.OXYGEN))
            assertTrue(freezeAndBoiling.isFreezing((double) -362, elm));
    }

    @Test(expected = NullPointerException.class)
    public void test_isOxygenBoiling_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.OXYGEN))
            assertTrue(freezeAndBoiling.isFreezing(null, elm));
    }

    @Test(expected = NullPointerException.class)
    public void test_isWaterFreezing_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.WATER))
            assertTrue(freezeAndBoiling.isFreezing(null, elm));
    }

    @Test
    public void test_isWaterFreezing() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) 10);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.WATER))
            assertTrue(freezeAndBoiling.isFreezing((double) 10, elm));
    }

    @Test(expected = NullPointerException.class)
    public void test_isWaterBoiling_Throw() {
        freezeAndBoiling = new FreezingAndBoilingPoints(0.00);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.WATER))
            assertTrue(freezeAndBoiling.isBoiling(null, elm));
    }

    @Test
    public void test_isWaterBoiling() {
        freezeAndBoiling = new FreezingAndBoilingPoints((double) 213);
        for (FreezingAndBoilingPoints.Elements elm : FreezingAndBoilingPoints.Elements.values())
            if(elm.equals(FreezingAndBoilingPoints.Elements.WATER))
            assertTrue(freezeAndBoiling.isBoiling((double) 213, elm));
    }
}