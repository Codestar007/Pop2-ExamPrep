import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import static org.junit.Assert.*;

public class PrimeDivisorListTest {
    // myList = {1,2,2,5};
    Integer[] myList2 = new Integer[]{2,3,3,7};

    @Before
    public void setUp() throws Exception {
        // TODO
        // PrimeDivisorList pd = new PrimeDivisorList();
    }

    @Test(expected=IllegalArgumentException.class)
    public void addThrowTest() throws Exception {
        PrimeDivisorList pd = new PrimeDivisorList();
        int result = pd.add(4);
        assertTrue(result == 4);
    }

    @Test
    public void isNotPrimeTest() {
        PrimeDivisorList pd = new PrimeDivisorList();
        assertTrue(pd.isNotPrime(3) == false);
        assertTrue(pd.isNotPrime(4));
    }

    @Test
    public void toStringTest1() {
        PrimeDivisorList pd = new PrimeDivisorList();
        PrimeDivisorList.MyArrayList PdList;
        pd.PdList.add(2);
        pd.PdList.add(3);
        pd.PdList.add(3);
        pd.PdList.add(7);
        Assert.assertEquals("126", pd.PdList.toString());
    }

    @Test
    public void toStringTest2() {
        PrimeDivisorList pd = new PrimeDivisorList();
        PrimeDivisorList.MyArrayList PdList;
        pd.PdList.add(1);
        pd.PdList.add(2);
        pd.PdList.add(2);
        pd.PdList.add(5);
        Assert.assertEquals("20", pd.PdList.toString());
    }
}