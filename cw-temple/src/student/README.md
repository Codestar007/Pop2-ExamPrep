**ASSIGNMENT DETAILS**
======================

**Student Name**:  Kizito Jegede

**Course**: MSc CS - PoP 2

**GitHub Project Name**: cw-temple

**Coursework Three**: (Please refer to 'Javadocs' documentation for full details)

**Program Title**: Philip Hammond and the Temple of Gloom

**PROJECT OVERVIEW**
====================

The main objective of the project is to write a program that help the explorer
and professor of archeology Philip Hammond explore an unknown cavern under
the Temple of Gloom and claim the Orb of Lots, which is located in the
cavern, and escape before the entrance collapses. There will be great rewards
for those who help Philip fill his pockets with gold on the way out.

    
**There are two major phases to this assignment:**

1.  **The exploration phase:**

Given an `ExplorationState state` object providing
the status of the tile on which you are standing and those immediately around you,
and with the layout of the cavern is unknown, traverse the cave (in as few steps
as possible) in search of the Orb and  when found, recover it and return.

ExplorationState state object includes the following methods:

* `long getCurrentLocation()`: return a unique identifier for the tile the explorer is cur-
rently on.
* `int getDistanceToTarget()`: return the distance from the explorers current location
to the Orb.
* `Collection<NodeStatus> getNeighbours()`: return a collection of NodeStatus objects
 containing information about the tiles to which the explorer can move from their
 current location.
* `void moveTo(long id)`: move the explorer to the tile with ID id. This fails if that tile
is not adjacent to the current location.
    
       
2.  **The escape phase:**

This phase starts after the explore phase, and you are given
given an `EscapeState state` object.

The primary goal of this phase is to ensuring the explorer makes it to the entrance
of the cavern before it collapses while collecting as much gold as possible on the way.

The EscapeState object includes the following methods:
* `Node getCurrentNode()`: return the Node corresponding to the explorers location.
* `Node getExit()`: return the Node corresponding to the exit to the cavern (the destina-
tion).
* `Collection<Node> getVertices()`: return a collection of all traversable nodes in the
graph. ````
* `int getTimeRemaining()`: return the number of steps the explorer has left before the
ceiling collapses.
* `void moveTo(Node n)`: move the explorer to node n. this will fail if the given node is
not adjacent to the explorers current location. Calling this function will decrement
the time remaining.
* `void pickUpGold()`: collect all gold on the current tile. This will fail if there
is no gold on the current tile or it has already been collected.
Class Node (and the corresponding class Edge) has methods that are likely to be useful.
        
Each of these phases involves writing a separate method in Java: **explore** and **escape**.

**SCORING CRITERIA:**
=====================

The score component is based on two additional factors:
1. The amount of gold picked up during the escape phase, and
2. The score from the exploration phase.

Your score will simply be the amount of gold picked up times the score
from the exploration phase.

**SOLUTION APPROACH:**
======================

_**Explore Phase:**_
The approach here was to use a depth first search (DFS) algorithim to
locate the orb but implement the method `getExploreUnvisitedChildNode`
for optimising the next node selection so as to stay on the shortest path.
This results in the explorere always reaching the orb, and often efficiently.
    
**_Escape Phase:_**
The approach here was to begin by creating an `EscapeAgent` class for creating an object
to hold information on the current tile about next cheapest available gold and the
cost/path to the gold. The object also, hold information on the path/cost to exit from
the target gold node (if there is one, otherwise the current node). For as long as
there is available gold and the gold can be retreived on time for exit, the agent will
go and pickup the gold. Once there is no more gold or gold reachable on time, the agent
stops prospecting for gold and heads for the exit. On the way out, the agent picks up
available gold on current tile.



**Limitations/problems with this submission.**

1.  In the explore phase, the challenge was finding the orb without
    access to the layout of the whole cavern. This made the dfs approch
    on its own inefficient and requiring additional coding to produce
    optimal search path. However, the result is stll sometimes sub-optimal,
    and yields a low bonus multiplier.

2.  In the escape phase, it was challenging to balance the trade off
    between gauranteed escape from the cave on time and the amount of gold
    calllected. This is mainly due to the variation in edge weights. While the
    explorer always escapes, the code does not always return the optimal
    amount of available gold. Perhaps a more advanced algoritihm for finding
    the shortest path beween two point will siginficantly improve the results.

**UNIT TESTING:**
=================
1.  **MyGoldData Class:** Null object was used to simulate Node elements in testing
    `MyGoldData` class as it was not possible to not Node object due to access
    restrictions.
2.  **Explorer Class:** Unable to write tests as NodeStatus object cannot be accessed
    from outside package. In place of the standard Junit test, extensive
    manual testing was done.
3.  **EscapeAgent Class:** Was unable to test as the class depends on EscapeState state
    which is access restricted. In place of the standard Junit test, extensive
    manual testing was done.
        
**FILES/CLASSES:**
==================
list of the files/classes created/modified:


**package student\\**

    Modified: Explorer.java:

1. Added code to `explore` and `escape` methods
2. Added new methods:

   * `allAvailGold`                     - List of all vertices with available gold.

   * `childNodesFilter`                 - Helper method, creates and returns list of Neighbour
                     nodes based on criteria.

   * `costOrPathToExit`                 - Finds the cost and path for moving between 2 nodes
                     (e.g. start and end nodes).


   * `findPathToGold`                   - Given a start and end node with unpicked gold, build a
                                      priority list.

   * `getExploreUnvisitedChildNode` 	- Gets and an unvisited child node of the current node in explore phase.

   * `getNxtChildNode` 	                - Gets and an unvisited child node of the current node for
                                      use in methods: `findPathToGold` and `costOrPathToExit`.

   * `goldListFilter` 	                - Creates a boolean filter that is is used in determining
                                      if a path.

   * `mapAndGetAvailGold` 	            - Build up a prioritised list of available gold from current
                                      location.

   * `pickAvailableGold` 	            - Checks if gold is available and if so, picks up the gold.

   * `recalculateCost` 	                - Recalculates path cost after sanitizing path list or at
                                      any point required.

   * `shortenPathList` 	                - Uses Recursion for sanitising a giving list, removing
                                      redundant edges.

   * `timeLeftForGoldSearch` 	        - Calculates time available for safely moving to pick up
                                      gold and still exit cavern.

   * `traverssablePath` 	            - Given a list ot nodes leading to gold, checks if it is
                                      traverssable or not.

<pre><code>Created:</code></pre>

1. Class MyGoldData  -  Custom List Class for holding 5 data types in a 2D array.
2. Class EscapeAgent -  For holding information to assist with picking up the most
                        profitable gold piles and exiting the cavern.
                        Methods include: Getters and setters, headforExit and goGetTheGold.
3. READEME.md
4. Javadocs
5. test (unit tests)
    