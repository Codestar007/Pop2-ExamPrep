/**
 * SmartPhone that extends MobilePhone and adds methods for browseWeb(String) and
 * findPosition(), the latter returning a (fictitious) GPS-found position.
 */
public class SmartPhone extends MobilePhone {
    public void browseWeb(String webURL){
        System.out.println("Browsing url: " + webURL);
    }
    public String findPosition(){
        //TODO
        String gpsPosition = "GPS-found position: 345.076";
        return gpsPosition;
    }

    /**
     * If the string parameter starts with \00",
     * the method outputs \Calling <number> through the internet to save money";
     * otherwise, does the same as the original method (hint: use super).
     * @param number number to call
     */
    @Override
    public void call(String number){
        if (number.startsWith("00")){
            System.out.println("Calling " + number
                    + " through the internet to save money");
        }
        else{
            System.out.println("Calling " + number);
        }
    }
}
