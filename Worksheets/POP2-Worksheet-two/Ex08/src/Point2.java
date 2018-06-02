import java.util.ArrayList;
import java.util.List;

/**
 * @author Kizito Jegede
 * @version 1.0
 * Implements an immutable class Point that describes a point in a plane.
 * usage of the class:
 * Point p = new Point(3, 4).translate(1, 3).scale(0.5);
 * should set p to a point with coordinates (2, 3.5).
 */

// Points class
public class Point2 {
    private double xCord;
    private double yCord;

    /**
     * Constructs class instance and set it to a specific point
     *
     * @param x1 value for the x coordinate
     * @param y1 value for the y coordinate
     */
    public Point2(double x1, double y1){
        this.xCord = x1;
        this.yCord = y1;
    }

    /**
     * a no-arg constructor to set class instance to the origin
     */
    public Point2(){
        this.xCord = 0;
        this.yCord = 0;
    }

    /**
     * Starting point of the program.
     * Escapes from static <code>mains()</code>method by calling static <code>run()</code>method
     * @param args
     */
    public static void main(String[] args) {
        new Point2().run();
    }

    /**
     * The real code starts here.
     */
    public void run(){
        // TODO
        Point2 p = new Point2(3, 4);
        p.translate(1, 3);
        p.scale(0.5);

        System.out.print("(" + p.xCord + ", " + p.yCord +")");
    }

    /**
     * Returns the X coordinate of the point
     */
    public double getX(){
        return xCord;
    }

    /**
     * Returns the Y coordinate of the point
     */
    public double getY(){
        return yCord;
    }

    /**
     * Moves the point by a given amount in x-direction and y-direction
     * @param xDir Amount by which X coordinate is moved
     * @param yDir Amount by which Y coordinate is moved
     */
    public void translate(double xDir, double yDir){
        // TODO
        xCord = (xDir + getX());
        yCord = (yDir + getY());
    }

    /**
     * Scales both coordinates by a given factor
     * @param scalefactor applied to both X and Y coordinates
     */
    public void scale(double scalefactor){
        // TODO
        xCord *= scalefactor;
        yCord *= scalefactor;
    }

} // end class Point




