package student.test;

import game.Node;
import org.junit.Before;
import org.junit.Test;
import student.MyGoldData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyGoldDataTest {
    List<MyGoldData> goldList = new ArrayList<>();
    List<Node> pathToGoldOrExit = new ArrayList<>();
    int RETURN = 1;
    Double cb;
    Integer pathCost;
    Node end = null; // Null as can not add Node object due to access restrictions
    int goldAmount = 47;


    @Before
    public void setUp() throws Exception {
        pathCost  = 367;
        cb = ((double) pathCost * RETURN) / goldAmount;
        pathToGoldOrExit = new ArrayList<>();

        for(int i=1; i < 6;i++){
            pathToGoldOrExit.add(null); // Null as can not add Node object due to access restrictions
            //pathToGoldOrExit.add(new Node(1));
        }

        goldList = new ArrayList<>();
        goldList.add(new MyGoldData(cb, pathCost * RETURN,
                end, goldAmount, pathToGoldOrExit));
    }

    @Test
    public void getCostBenefit() {
        assert goldList.get(0).getCostBenefit() == 7.808510638297872;
    }

    @Test
    public void getCost() {
        assert goldList.get(0).getCost() == 367;
    }

    @Test
    public void getNode() {
        assert  goldList.get(0).getNode() == null;
    }

    @Test
    public void getGoldAvailable() {
        assert goldList.get(0).getGoldAvailable() == 47;
    }

    @Test
    public void getPathToGoldOrExit() {
        assert goldList.get(0).getPathToGoldOrExit().get(3) == null;
        assert goldList.get(0).getPathToGoldOrExit().size() == 5;
    }
}