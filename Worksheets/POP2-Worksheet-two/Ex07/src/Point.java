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
final public class Point {
    final private double xCord;
    final private double yCord;

    /**
     * Constructs class instance and set it to a specific point
     *
     * @param x1 value for the x coordinate
     * @param y1 value for the y coordinate
     */
    public Point(double x1, double y1){
        this.xCord = x1;
        this.yCord = y1;
    }

    /**
     * a no-arg constructor to set class instance to the origin
     */
    public Point(){
        this.xCord = 0;
        this.yCord = 0;
    }

    /**
     * Starting point of the program.
     * Escapes from static <code>mains()</code>method by calling static <code>run()</code>method
     * @param args
     */
    public static void main(String[] args) {
        new Point().run();
        }

    /**
     * The real code starts here.
     */
    public void run(){
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println("Point returned to main method: (" + p.xCord + ", " + p.yCord +")");
    }

    /**
     * Returns the X coordinate of the point
     */
    public double getX(){ return xCord;}

    /**
     * Returns the Y coordinate of the point
     */
    public double getY(){return yCord;}

    /**
     * Moves the point by a given amount in x-direction and y-direction
     * @param xDir Amount by which X coordinate is moved
     * @param yDir Amount by which Y coordinate is moved
     * @return new points with the results
     */
    public Point translate(double xDir, double yDir){
        Point pTrans = new Point(xDir + getX(), yDir + getY());
        System.out.println("After tranlate: (" + pTrans.xCord + ", " + pTrans.yCord +")");
        return pTrans;
    }

    /**
     * Scales both coordinates by a given factor
     * @param scalefactor applied to both X and Y coordinates
     * @return new points with the results
     */
    public Point scale(double scalefactor){
        Point pScale = new Point(getX() * scalefactor, getY()* scalefactor);
        System.out.println("After scaling: (" + pScale.xCord + ", " + pScale.yCord +")");
        return pScale;
    }

} // end class Point



