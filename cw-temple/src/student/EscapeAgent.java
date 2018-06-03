package student;


import game.EscapeState;
import game.Node;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creates agent on move to each tile, gather/hold information to assist with
 * picking up the most profitable gold piles and exiting the cavern.
 *
 * @author Kizito Jegede
 * @version 1.0
 *
 */
public class EscapeAgent {
    final int RETURN = 1; // Constant for calculating return cost of a traversal
    // General fields
    private Long name; // Current node id

    // Gold fields
    private Integer costToGold; // Gold path cost
    private List<Node> pathToGold; // Path to cheapest gold (edge length/amount of gold)
    private Node goldNode; // Target Gold node

    // Exit field
    private List<Node> pathToExit; // Path to to Exit the cavern
    private Integer costToExit; // Exit path cost

    // For use in accessing Explorer class
    private Explorer explorer = new Explorer();

    /**
     * ConstructorExamples.Constructor
     * @param state the information available at the current state
     */
    public EscapeAgent(EscapeState state) {
        List<Node> exitPath;
        //  Get list of available gold from current node
        List<MyGoldData> goldList = explorer.mapAndGetAvailGold(state, RETURN);
        //  Get list of path to exit from targeted gold node otherwise from current node
        if (!(goldList.size() > 0) ){
            exitPath = explorer.costOrPathToExit(state.getCurrentNode(),
                    state.getExit(), RETURN).get(0).getPathToGoldOrExit();
        }else{
            exitPath = explorer.costOrPathToExit(goldList.get(0).getNode(),
                    state.getExit(), RETURN).get(0).getPathToGoldOrExit();}


        // Set agent's field values
        setName(state);
        setGoldNode(goldList);
        setPathToGold(goldList);
        setCostToGold(goldList);
        setPathToExit(exitPath);
        setCostToExit(exitPath);

    } // End of constructor EscapeAgent


    /**
     * Sets agent name
     * @param state the information available at the current state
     */
    private void setName(EscapeState state) {
        this.name = state.getCurrentNode().getId();

    } //  End of setName


    /**
     * Sets target gold pile node value
     * @param goldList MyGoldData list of target gold piles
     */
    private void setGoldNode(List<MyGoldData> goldList) {
        if (goldList.size() > 0){
            this.goldNode = goldList.get(0).getNode();
        }else{
            this.goldNode = null;
        }

    } //  End of setGoldNode


    /**
     * Sets path to the gold pile
     * @param goldList MyGoldData list of target gold piles
     */
    private void setPathToGold(List<MyGoldData> goldList) {
        if (goldList.size() > 0){
            this.pathToGold = goldList.get(0).getPathToGoldOrExit();
        }else{
            this.pathToGold = null;
        }
    } //  End of setPathToGold


    /**
     * Sets cost of the path to the gold pile
     * @param goldList MyGoldData list of target gold piles
     */
    private void setCostToGold(List<MyGoldData> goldList) {
        if (goldList.size() > 0){
            this.costToGold = goldList.get(0).getCost();
        }else{
            this.costToGold = Integer.MAX_VALUE; // If there is no gold make it expensive
        }
    } //  End of setCostToGold


    /**
     * Sets path to exit
     * @param exitPath list of sequential nodes leading to exit
     */
    private void setPathToExit(List<Node> exitPath) {
        // Run only if more than one node (current node) is present
        if (exitPath.size() > 1){
            this.pathToExit = exitPath;
        }

    } //  End of setPathToExit


    /**
     * Sets the cost of the path to exit
     * @param exitPath list of sequential nodes leading to exit
     */
    private void setCostToExit(List<Node> exitPath) {
        // Run only if more than one node (current node) is present
        if (exitPath.size() > 1){
            this.costToExit = explorer.recalculateCost(exitPath);
        }else{
            this.costToExit = Integer.MAX_VALUE; // If there is no gold make it expensive
        }

    } //  End of setCostToExit


    /**
     * Gets the cost to gold.
     * @return cost to gold
     */
    public Integer getCostToGold() {
        return costToGold;
    }

    /**
     * Gets the cost to exit.
     * @return cost to exit
     */
    public Integer getCostToExit() {
        return costToExit;
    }

    /**
     * Gets the target gold node.
     * @return Gold node if any, else null
     */
    public Node getGoldNode() {
        return goldNode;
    }


    /**
     * Moves sequential through a list of nodes to pickup the gold pile.
     * @param state the information available at the current state
     */
    public void goGetTheGold(EscapeState state){
        // Run only if more than one node (current node) is present
        if(pathToGold.size() > 1){
            for(int i = 1; i < pathToGold.size(); i++){
                if(!pathToGold.get(i).equals(state.getCurrentNode())){
                    state.moveTo(pathToGold.get(i));
                    explorer.pickAvailableGold(state);
                }
            }
        }
    } //  End of goGetTheGold


    /**
     * Moves sequential through a list of nodes to exit the cavern.
     * @param state the information available at the current state
     */
    public void headForExit(EscapeState state){
        // Refresh exit path
        List<Node> exitPath = explorer.costOrPathToExit(state.getCurrentNode(),
                state.getExit(), RETURN).get(0).getPathToGoldOrExit();
        setPathToExit(exitPath); // re-set exit path
        setCostToExit(exitPath); // re-set exit cost

        // Run only if more than one node (current node) is present
        if(pathToExit.size() > 1){
            for(int i = 1; i < pathToExit.size(); i++){
                if(!pathToExit.get(i).equals(state.getCurrentNode())){
                    state.moveTo(pathToExit.get(i));
                    explorer.pickAvailableGold(state);
                    if (state.getCurrentNode().equals(state.getExit())) {
                        return;
                    }
                }
            }
        }
    } //  End of headForExit


}  //  End of Class EscapeAgent
