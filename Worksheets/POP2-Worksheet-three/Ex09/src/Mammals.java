public class Mammals extends AnimalImpl {
    /**
     * ConstructorExamples.Constructor
     */
    public Mammals(String name, String type, String sound, String subType) {
        super(name, type, sound, subType);
    }

    @Override
    public void reproduce() {
        super.reproduce();
        giveBirth();
    }

    public void giveBirth(){
         System.out.println("Giving Birth to: " + this.getName() + " Jr.");
    }
}
