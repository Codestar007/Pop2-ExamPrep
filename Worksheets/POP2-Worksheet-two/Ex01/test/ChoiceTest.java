import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChoiceTest {
    private List<Integer> baseList;
    @Before
    public void setup() {
        baseList = new ArrayList<>();
        for (int x=0; x < 49; x++) {
            baseList.add(x);
        }
    }

    public static boolean isSorted(List<Integer>  retList){
        for(int i = 1; i < retList.size(); i++){
            if(retList.get(i-1) > retList.get(i)){
                return false;
            }
        }
        return true;
    }

    //Check that returned list is sorted in ascending order
    @Test
    public void selectSixNumbersListSort() {
        boolean isItSorted = isSorted(new Choice().selectSixNumbers(baseList));
        Assert.assertTrue(isItSorted);
    }

    //Check that returned list size is correct
    @Test
    public void selectSixNumbers() {
        int sz = (new Choice().selectSixNumbers(baseList)).size();
        Assert.assertTrue(sz == 6);
    }

    //Check that number returned is within Limit/Range
    @Test
    public void selectNumber() {
        Integer theNum = new Choice().selectNumber(47, baseList);
        boolean theResult = (theNum > 0) && (theNum <= 47);
        Assert.assertTrue(theResult);
    }
}