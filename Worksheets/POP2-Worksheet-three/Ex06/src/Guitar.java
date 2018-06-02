public class Guitar implements MusicalInterface, WoodenInterface {

    MusicalInstrument myMI;
    WoodenObject myWO;

    public Guitar() {
        myMI = new MusicalInstrument();
        myWO = new WoodenObject();
    }

    @Override
    public void play() {
        System.out.println("Playing from Guitar implementation");
    }

    @Override
    public void burn() {
        System.out.println("Burning from Guitar implementation");
    }

    public static void main(String[] args){
        Guitar myGuitar = new Guitar();
        myGuitar.play();
        myGuitar.burn();
    }

}
