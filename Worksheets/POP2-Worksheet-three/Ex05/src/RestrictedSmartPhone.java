import java.util.List;

public class RestrictedSmartPhone extends SmartPhone {
    public RestrictedSmartPhone(String brand, List<String> numberCalled) {
        super(brand, numberCalled);
    }

    @Override
    private void playGame(String gameName){
        System.out.println("Playing restricted game: " + gameName);
    }
}
