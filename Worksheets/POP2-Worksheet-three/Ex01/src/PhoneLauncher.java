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
        SmartPhone newMyMobPhone = new SmartPhone();
        for (int i = 0; i < 10;i++) {
            String num = "0207 999 100" + i;
            newMyMobPhone.call(num);
            newMyMobPhone.setNumberCalled(num);
        }
        newMyMobPhone.ringAlarm("Morning breeze");
        newMyMobPhone.playGame("Half life");
        newMyMobPhone.printLastNumbers();
        System.out.println(newMyMobPhone.findPosition());

    }
}