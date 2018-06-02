package student;

import game.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The main class in student package where the solution to the Temple of Gloom
 * problem is written.
 *
 * @author Kizito Jegede
 * @version 1.0
 *
 */
public class Explorer {

    /**
     * Explore the cavern, trying to find the orb in as few steps as possible.
     * Once the explorer finds the orb, the explorer must return from the function
     * in order to pick it up. If the explorer continues to move after finding
     * the orb rather than returning, it will not count.
     * If the explorer return from this function while not standing on top of the orb,
     * it will count as a failure.
     * <p>
     * There is no limit to how many steps the explorer can take, but a score
     *  bonus multiplier will be received for finding the orb in fewer steps.
     * <p>
     * At every step, the explorer only know its current tile's ID and the ID of all
     * open neighbor tiles, as well as the distance to the orb at each of these tiles
     * (ignoring walls and obstacles).
     * <p>
     * To get information about the current state, use functions
     * getCurrentLocation(),
     * getNeighbours(), and
     * getDistanceToTarget()
     * in ExplorationState.
     * The explorer is standing on the orb when getDistanceToTarget() is zero (0).
     * <p>
     * Use function moveTo(long id) in ExplorationState to move to a neighboring
     * tile by its ID. Doing this will change state to reflect your new position.
     * <p>
     * The implemented solution is a depth-first search that will always find the orb,
     * along with a method `getExploreUnvisitedChildNode` that improves the chance of
     * receiving a large bonus multiplier.
     *
     * @param state the information available at the current state
     */
    public void explore(ExplorationState state) {
        final HashSet visitedTiles = new HashSet<>(); // Hold list of visited tiles
        final Stack<Long> stack = new Stack<>();      // Holds Node ID
        long startNode = state.getCurrentLocation();
        long node;

        stack.push(startNode);
        visitedTiles.add(startNode);                 // Add node to visited list
        while (!stack.isEmpty()) {
            if (state.getDistanceToTarget() == 0) {
                return;                              // Check if Explorer has found Orb and return if so.
            }else{
                final Object child = getExploreUnvisitedChildNode(state, visitedTiles);
                if (child == null) {
                    stack.pop();
                    node = stack.peek();
                } else {
                    visitedTiles.add(child);        // Add node to visited list
                    stack.push((long)child);
                    node = stack.peek();
                }
            } state.moveTo(node);                   // move to this node if not start node
        }
        //Clear visited list
        visitedTiles.clear();

    } // End pof explore

    /**
     * Gets and an unvisited child node of the current node in explore phase.
     * @param state the information available at the current state
     * @param visitedTiles list of visited tiles
     * @return unvisited child node ID object nearest to Orb, otherwise, null
     */
    public Object getExploreUnvisitedChildNode(ExplorationState state, HashSet visitedTiles){
        int prevDist = Integer.MAX_VALUE;
        Long prevID = null;
        Long nearestToOrb = null;

        if(state.getNeighbours().size() == 0){
            return null;
        }else{
            // Finds the unvisited neighbour nearest to Orb
            for (NodeStatus neighbour : state.getNeighbours()) {
                if(!(visitedTiles.contains(neighbour.getId()))
                        && neighbour.getDistanceToTarget() <= prevDist){
                    prevDist = neighbour.getDistanceToTarget();

                    if (prevID == null)prevID = neighbour.getId();
                    if (prevID < neighbour.getId()){
                        nearestToOrb = neighbour.getId();
                    }else{
                        nearestToOrb = prevID;
                        prevID = neighbour.getId();
                    }
                }
            }
            return nearestToOrb;
        }
    } // End of getExploreUnvisitedChildNode


    /**
     * Implements escape from the cavern before the ceiling collapses.
     * <p>The explore  must return from this function while standing at the exit.
     * Failing to do so before time runs out or returning from the wrong location
     * will be considered a failed run.</p>
     * <p>
     * Initial focus is to collect much gold as possible whilst tracking
     * remaining/available time to ensure the explore safely reaches exit.
     * This is achieved through an EscapeAgent objectOnce safe time margin threshold is
     * reached, the agent calls its instance method `headForExit` to escape from the cavern.
     *
     * @param state the information available at the current state
     */
    public void escape(EscapeState state) {
        // Create instance of Agent to begin gold prospect
        EscapeAgent myAgent = new EscapeAgent(state); // Testing agent creation
        pickAvailableGold(state);

        // while there is gold to pick  and time
        while (myAgent.getGoldNode() != null && state.getTimeRemaining()
                - (myAgent.getCostToGold() + myAgent.getCostToExit()) > 0){
            myAgent.goGetTheGold(state);        //  Go and pick up the gold pile
            myAgent = new EscapeAgent(state);   //  Get new agent for the new tile just moved to
        }
        myAgent.headForExit(state); //  No more time for gold prospect, so head for exit

    } // End of escape


    /**
     * Checks if gold is available and if so, picks up the gold.
     * @param state the information available at the current state
     */
    public void pickAvailableGold(EscapeState state){
        if(state.getCurrentNode().getTile().getGold() > 0){
            state.pickUpGold();
        }
    } //End of pickAvailableGold

    /**
     * List of all vertices with available gold.
     * @param state the information available at the current state
     * @return List of vertices with available gold
     */
    public Collection<Node> allAvailGold(EscapeState state){
        return state.getVertices()
                .stream()
                .filter(node -> node.getTile()
                        .getGold() > 0).collect(Collectors.toList());
    } // End of allAvailGold


    /**
     * Builds up a prioritised list of available gold from the current location.
     * @param state the information available at the current state
     * @param RETURN Constant for calculating return cost of a traversal :
     *               2 if a return to starting node is required, else 1.
     * @return Prioritised list of available gold from current node
     */
    public  List<MyGoldData> mapAndGetAvailGold(EscapeState state, int RETURN){
        List<MyGoldData> goldList = new ArrayList<>();
        Collection<Node> nodeHasGold = allAvailGold(state);
        // Populate the gold map list with data.
        for(Node n : nodeHasGold){
            findPathToGold(state.getCurrentNode(), n, goldList, timeLeftForGoldSearch(state, RETURN), RETURN,"FLOOR", 10);
        }
        // sort the list in ascending order based on costbenefit
        Collections.sort(goldList, new Comparator<MyGoldData>() {
            @Override
            public int compare(MyGoldData o1, MyGoldData o2) {
                if(o1.getCostBenefit() < o2.getCostBenefit()){
                    return -1;
                }else{
                    if(o1.getCostBenefit() > o2.getCostBenefit()){
                    return 1;
                    }
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        return goldList;

    } // End of mapAndGetAvailGold


    /**
     * Given a start and end node with unpicked gold, build a priority list
     *  and finds path to the gold.
     * @param start Node to start search from
     * @param end Node with targeted gold pile
     * @param goldList list to be updated with result
     * @param costFilter the time current remaining for safe search for Gold
     * @param RETURN Constant for calculating return cost of a traversal :
     *               2 if return to start node is required, else 1.
     * @param type type of tile to include
     * @param priorityFilter the top limit on priority to be included in list
     */
    public void findPathToGold(Node start, Node end, List goldList, Integer costFilter,
                               int RETURN, String type, Integer priorityFilter){
        final Stack<Node> backTracking = new Stack<>();     //  tracks moves to enable back tracking
        final HashSet<Node> visitedSet = new HashSet<>();   // Hold list of pathToGold tiles
        final List<Node> pathToGold = new ArrayList<>();    //  Holds list of path to gold pile
        Integer pathCost = 0;                               // Total cost of a path to gold pile.
        Double cb;                                          // priority: steps/ per gold
        pathToGold.add(start);
        visitedSet.add(start);
        backTracking.push(start);                           // Add Start node to stack
        Node starting = start;
        String excludedTile = "None";

        if(type.equals("FLOOR")) {excludedTile = "ENTRANCE";}
        while(!backTracking.isEmpty()){
            if(starting.getId() == end.getId()){
                shortenPathList(pathToGold); // Sanitize
                pathCost = recalculateCost (pathToGold);
                if((double)end.getTile().getGold() == 0){
                    cb = (double)pathCost * RETURN;
                }else{
                    cb = pathCost * RETURN /(double)end.getTile().getGold();
                }

                // Adds items to gold list based on filter
                if(goldListFilter(pathCost, cb, pathToGold, costFilter, RETURN, priorityFilter, excludedTile)) {
                    goldList.add(new MyGoldData(cb, pathCost * RETURN,
                        end, end.getTile().getGold(), pathToGold));
               }
                return;
            }else{
                // Find next nearest edge and cost
                final Node child = getNxtChildNode(starting, visitedSet, type);
                if(child == null){
                    backTracking.pop(); // Remove node without child from stack
                    pathToGold.remove(pathToGold.size()-1); // Remove popped node from pathToGold
                    pathCost = pathCost + backTracking.peek().getEdge(starting).length;
                    starting = backTracking.peek();
                }else{
                    pathCost = pathCost + child.getEdge(starting).length;
                    pathToGold.add(child);
                    visitedSet.add(child);
                    backTracking.push(child);// Add Start node to stack
                    starting = backTracking.peek();
                }
            }
        }
    } // End of findPathToGold


    /**
     * Creates a boolean filter that is used in determining if a path
     * is to be added to the gold pile list.
     * @param pathCost Total cost of a path to gold pile.
     * @param cb priority: steps/ per gold
     * @param pathToGold List of path to gold pile
     * @param costFilter the value of timeLeftForGoldSearch(state)
     * @param RETURN Constant for calculating return cost of a traversal :
     *               2 if return to start node is required, else 1.
     * @param priorityFilter the top limit on priority to be included in list
     * @param excludedTile type of tiles to exclude from list
     * @return True if criteria is met otherwise, false.
     */
    public boolean goldListFilter(Integer pathCost, Double cb, List<Node> pathToGold,
                                  Integer costFilter, int RETURN, Integer priorityFilter,
                                  String excludedTile){

        if (excludedTile == "ENTRANCE"){
        return
                ((pathCost * RETURN) < costFilter) // return cost
                && (cb < priorityFilter)
                && (pathToGold.stream().filter(n -> n.getTile()
                .getType().toString()
                .equals(excludedTile)).toArray().length == 0) // Exclude entrance tiles
                && traverssablePath(pathToGold);
        }else{
            return
                    ((pathCost * RETURN) < costFilter) // return cost
                            && (cb < priorityFilter)
                            && traverssablePath(pathToGold);
        }
    }


    /**
     * Uses sanitizes a giving list, removing redundant edges.
     * This has the effect of shortening a path to a gold node and the associated cost
     * @param originalList List to be shortened
     */
    public void shortenPathList(List<Node> originalList){
        int a = 0;
        int biggestGap = 0;

        for(int i = 0; i < originalList.size(); i++){
            for(int j = originalList.size() - 1; j >= 0; j--){
                Node ndA = originalList.get(i);
                Node ndB = originalList.get(j);

                // Rows are equal but columns are out by 1
                boolean equalRowsPlusColumnDiff1 = (
                        ndA.getTile().getRow() == ndB.getTile().getRow()
                                && Math.abs(ndA.getTile().getColumn() - ndB.getTile().getColumn()) == 1);
                // Columns are equal but rows are out by 1
                boolean equalColumnPlusRowDiff1 = (
                        ndA.getTile().getColumn() == ndB.getTile().getColumn()
                                && Math.abs(ndA.getTile().getRow() - ndB.getTile().getRow()) == 1);

                if((equalRowsPlusColumnDiff1 || equalColumnPlusRowDiff1)
                        && j != (i - 1)
                        && (j - i) != 1){

                    if(biggestGap < Math.abs(j - i) - 1){
                        biggestGap = Math.abs(j - i) - 1;
                        a = Math.max(i, j);
                    }

                }
            }

        }
        if(biggestGap > 0){
            for(int x = 1; x <= biggestGap; x++){
                // Delete from the rear
                originalList.remove(a-x);
            }
            // Recursive call
            shortenPathList(originalList);
        }
    }


    /**
     * Recalculates the path cost after sanitizing path list or at any point required.
     * @param pathList List of path to recalculate cost for
     * @return the new path cost
     */
    public Integer recalculateCost (List<Node> pathList){
        Integer cost = 0;
        for(int i = 0; i < pathList.size() - 1; i++){
            // running total of edge cost (length)
            cost += pathList.get(i).getEdge(pathList.get(i + 1)).length;
        }
        return cost;
    }


    /**
     * Finds the cost and path for moving between two given nodes.
     * @param currentNode Starting node
     * @param exitNode  end node
     * @param RETURN Constant for calculating return cost of a traversal :
     *               2 if return to start node is required, else 1.
     * @return List including cost and path of traversing between both nodes (sum of length of edges)
     */
    public List<MyGoldData> costOrPathToExit(Node currentNode, Node exitNode,
                                             Integer RETURN){
        List<MyGoldData> goldList = new ArrayList<>();
        // Populate the gold map list with data.
        findPathToGold(currentNode, exitNode, goldList, Integer.MAX_VALUE, RETURN,
                "All", Integer.MAX_VALUE);
        // sort the list in ascending order based on costbenefit
        Collections.sort(goldList, new Comparator<MyGoldData>() {
            @Override
            public int compare(MyGoldData o1, MyGoldData o2) {
                if(o1.getCostBenefit() < o2.getCostBenefit()){
                    return -1;
                }else{
                    if(o1.getCostBenefit() > o2.getCostBenefit()){
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        return goldList;

    } // End of costOrPathToExit


    /**
     * Calculates time available for safely moving to pick up gold and still exit cavern.
     * @param state the information available at the current state
     * @param RETURN Constant for calculating return cost of a traversal :
     *               2 if return to start node is required, else 1.
     * @return time remaining for safe gold search and pick up
     */
    public Integer timeLeftForGoldSearch(EscapeState state, Integer RETURN){
        return state.getTimeRemaining()
                - costOrPathToExit(state.getCurrentNode(), state.getExit(),
                RETURN).get(0).getCost();
    }


    /**
     * Gets and an unvisited child node of the current node for use in methods:
     * `findPathToGold`, `costOrPathToExit`.
     * @param visited list of visited nodes
     * @param start current node whose child node is to be found
     * @param tileType type of Tile to include in neighbour search: "FLOOR" or "All"
     * @return unvisited node, otherwise, null
     */
    public Node getNxtChildNode(Node start, HashSet visited, String tileType){
        List<Long> nodeIds = new ArrayList<>(); // Holds node ids of all child nodes
        List<Node> neighbours = childNodesFilter(start, visited, tileType);

        if(neighbours.size() == 0){
            return null;
        }else{
            for (Node n : neighbours) {
                nodeIds.add(n.getId());
            }
            Collections.sort(nodeIds);
            return neighbours.stream()
                    .filter(n -> n.getId() == nodeIds.get(0))
                    .findFirst().get();
        }
    }


    /**
     * Helper method, creates and returns list of neighbour nodes based on a given criteria.
     * Created mainly to keep code tidy.
     * @param visited list of visited nodes
     * @param start current node whose child node is to be found
     * @param tileType type of Tile to include in neighbour search: "FLOOR" or "All"
     * @return Filtered list of neighbour/child nodes
     */
    public List<Node> childNodesFilter(Node start, HashSet visited, String tileType){
        List<Node> result;

        if (tileType.equals("FLOOR")){
            result = (start.getNeighbours()
                    .stream().filter(nd -> nd.getTile().getType().toString().equals("FLOOR")
                            && !visited.contains(nd)
                            && ((nd.getTile().getRow() == start.getTile().getRow()
                            && Math.abs(nd.getTile().getColumn() - start.getTile().getColumn()) <= 1)
                            ||(nd.getTile().getColumn() == start.getTile().getColumn()
                            && Math.abs(nd.getTile().getRow() - start.getTile().getRow()) <= 1)))
                    .collect(Collectors.toList()));
        }else{
            result = (start.getNeighbours()
                    .stream().filter(nd -> !visited.contains(nd)
                            && ((nd.getTile().getRow() == start.getTile().getRow()
                            && Math.abs(nd.getTile().getColumn() - start.getTile().getColumn()) <= 1)
                            ||(nd.getTile().getColumn() == start.getTile().getColumn()
                            && Math.abs(nd.getTile().getRow() - start.getTile().getRow()) <= 1)))
                    .collect(Collectors.toList()));
        }
        return result;
    }


    /**
     * Given a list ot nodes leading to gold, checks if it is traverssable or not.
     * @param pathToGold the sequential list of Nodes leading to gold pile
     * @return true if bath is traverssable, otherwise false
     */
    public boolean traverssablePath(List<Node> pathToGold){
        // Check un-traverssable paths
        for(int i = 0; i < pathToGold.size() - 1; i++){
            Node ndA = pathToGold.get(i);
            Node ndB = pathToGold.get(i+1);

            // Rows are equal but columns are out by 1
            boolean equalRowsPlusColumn1 = (
                    ndA.getTile().getRow() == ndB.getTile().getRow()
                    && Math.abs(ndA.getTile().getColumn() - ndB.getTile().getColumn()) == 1);
            // Columns are equal but rows are out by 1
            boolean equalColumnPlusRow1 = (
                    ndA.getTile().getColumn() == ndB.getTile().getColumn()
                    && Math.abs(ndA.getTile().getRow() - ndB.getTile().getRow()) == 1);

            if(!(equalRowsPlusColumn1 || equalColumnPlusRow1)){
                return false;
            }
        }
        return true;
    } // End of traverssablePath

}