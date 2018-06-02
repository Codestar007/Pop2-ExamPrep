public class AnimalImpl implements AnimalInterface {
    private String name;
    private String type;
    private String sound;
    private String subType; // Aquatic, Flying, Terrestrial

    public String getName() {
        return name;
    }

    public AnimalImpl(String name, String type, String sound, String subType) {
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.subType = subType;
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " Making sound: " + this.sound);
    }

    @Override
    public void call() {
        if(this.subType.equals("Aquatic")){
            System.out.println(this.getName() + " Will not come..");
        }else if(this.subType.equals("Flying")) {
            System.out.println(this.getName() + " now flying, will come later when tired..");
        }else{
            System.out.println(this.getName() + " coming..");
            }
    }

    @Override
    public void reproduce() {
        // TODO
    }

}
