import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Creates a SmartPhone and use all its methods,
 * including those inherited from its ancestor classes.
 */

public class PhoneLauncher {
    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
    public void launch() {
        String[] num = {"0207 999 1000", "00207 999 1001",
                "0207 999 1002", "0207 999 1003",
                "0207 999 1004", "00207 999 1005",
                "0207 999 1006", "0207 999 1007",
                "00207 999 1008", "0207 999 1009"};
        SmartPhone newMyMobPhone = new SmartPhone("Samsung S9", new ArrayList());
        for (int i = 0; i < 10;i++) {
            newMyMobPhone.call(num[i]);
            newMyMobPhone.setNumberCalled(num[i]);
        }
        newMyMobPhone.ringAlarm("Morning breeze");
        newMyMobPhone.playGame("Half life");
        newMyMobPhone.printLastNumbers();
        System.out.println(newMyMobPhone.findPosition());
        System.out.println("Phone brand: "+ newMyMobPhone.getBrand());

    }
}