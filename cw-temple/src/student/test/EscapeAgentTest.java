package student.test;

import game.EscapeState;
import game.GameState;
import game.Node;
import org.junit.Before;
import org.junit.Test;
import student.EscapeAgent;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.*;

public class EscapeAgentTest {
    private EscapeAgent myAgent;
    private EscapeState state = new EscapeState() {};

    @Before
    public void setUp() throws Exception {
        EscapeAgent myAgent = new EscapeAgent(state); // Testing agent creation
    }

    @Test
    public void getCostToGold() {
        assert myAgent.getCostToGold() == null;
    }

    @Test
    public void getCostToExit() {
        assert myAgent.getCostToExit() == null;
    }

    @Test
    public void getGoldNode() {
        assert myAgent.getGoldNode() == null;
    }

}