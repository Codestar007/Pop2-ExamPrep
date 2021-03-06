import java.util.ArrayList;
import java.util.List;

public class MobilePhone extends OldPhone{

	List<String> numberCalled = new ArrayList<String>(10);

	public List<String> getNumberCalled() {
		return numberCalled;
	}

	public void setNumberCalled(String numberCalled) {
		this.numberCalled.add(numberCalled);
	}

	public void ringAlarm(String tune){
		System.out.println("Alarm ringing: " + tune);
	}

	public void playGame(String gameName){
		System.out.println("Playing game: " + gameName);
	}

	public void printLastNumbers(){
		System.out.println("Last numbers: " + this.getNumberCalled());
	}

}