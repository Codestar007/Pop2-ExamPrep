package student;

import game.Node;

import java.util.List;

/**
 * Custom List Class for holding five (5) types of data in a 2D array.
 *
 * @author Kizito Jegede
 * @version 1.0
 *
 */
public class MyGoldData {
    private Double costBenefit; // Cost benefit ratio of getting this gold pile
    private Integer cost; // Path cost
    private Node node; // Target Gold node
    private List<Node> pathToGoldOrExit; // Path to gold node or to Exit the cavern
    private Integer goldAvailable; // Amount of Gold

    /**
     * ConstructorExamples.Constructor.
     * @param costBenefit Cost benefit ratio of getting this gold pile
     * @param cost Path cost
     * @param node Target Gold node
     * @param goldAvailable Amount of Gold available at target node
     * @param pathToGoldOrExit List of sequential vertices to gold node or Exit
     */
    public MyGoldData(Double costBenefit, Integer cost, Node node, Integer goldAvailable, List<Node> pathToGoldOrExit) {
        this.costBenefit = costBenefit;
        this.cost = cost;
        this.node = node;
        this.goldAvailable = goldAvailable;
        this.pathToGoldOrExit = pathToGoldOrExit;
    }

    /**
     * Gets the cost benefit field value
     * @return cost vs benefit value
     */
    public Double getCostBenefit() {
        return costBenefit;
    }

    /**
     * Gets the cost field value
     * @return cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Gets the node field value
     * @return node
     */
    public Node getNode() {
        return node;
    }

    /**
     * Gets the path to available gold
     * @return path list
     */
    public List<Node> getPathToGoldOrExit() {
        return pathToGoldOrExit;
    }

    /**
     * Gets the value of available gold
     * @return available gold
     */
    public Integer getGoldAvailable() {
        return goldAvailable;
    }
}
