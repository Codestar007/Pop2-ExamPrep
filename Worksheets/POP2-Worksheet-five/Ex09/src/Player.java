public class Player {
    /* * This is the only method worth looking. The rest is boilerplate. */
    public void aim(Ball theBall) {
        try {
            throw theBall;
        } catch (Ball incomingBall) {
        if (gotBored()) {
            System.out.println(getName() + ": I got bored. Let’s play something else. ");
        } else { System.out.println(getName() + ": good throw, " + target.getName());
        target.aim(incomingBall);
        }
        }
    }
    /* * All code below is basically boilerplate and it
    is * shown only for completeness so the code is compilable.
    */
    private Player target;
    private String name;
    public Player(String name, Player target) {
        this.name = name;
        this.setTarget(target);
    }
    public void setTarget(Player target) {
        this.target = target;
    }
    public String getName() {
        return name;
    }
    public boolean gotBored() {
        return (Math.random() < 0.001);
    }
    public static void main(String...args) {
        Player parent = new Player("Dad", null);
        Player child = new Player("Kid", parent);
        parent.setTarget(child); parent.aim(new Ball());
    }
}
class Ball extends Throwable {}

