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
}
