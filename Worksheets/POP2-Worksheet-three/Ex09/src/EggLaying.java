public class EggLaying extends AnimalImpl {
    /**
     * ConstructorExamples.Constructor
     */
    public EggLaying(String name, String type, String sound, String subType) {
        super(name, type, sound, subType);
    }

    @Override
    public void reproduce() {
        super.reproduce();
        layEggs();
    }

    public void layEggs(){
        System.out.println("Laying egg to be called: " + this.getName() + " Jr.");
    }
}
