import java.util.InputMismatchException;

public class FreezingAndBoilingPoints {

    private double temperature;

    public FreezingAndBoilingPoints(double t) {
        temperature = t; //  set the value of temperature
        }

    public enum Elements {
        ETHYLALCOHOL(-173, 172),
        WATER(32, 212),
        OXYGEN(-362, -306);

        private final double freezePt; //Freezing point
        private final double boilPt;   //Boiling point

        Elements(double freezePt, double boilPt) {
            this.freezePt = freezePt;
            this.boilPt = boilPt;
        }

        // The enum Constructor
        private double freezePt() {
            return freezePt;
        }

        // The enum Constructor
        private double boilPt() {
            return boilPt;
        }
    }
    // Method to find out if the input is a freezing point
    boolean isFreezing(Double temp, Elements elm) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else if(elm.equals(Elements.ETHYLALCOHOL))
            return temp <= Elements.ETHYLALCOHOL.freezePt;
        else if(elm.equals(Elements.WATER))
            return temp <= Elements.WATER.freezePt;
        else if(elm.equals(Elements.OXYGEN))
            return temp <= Elements.OXYGEN.freezePt;
        else
            return false;
    }

    // Method to find out if the input is a boiling point
    boolean isBoiling(Double temp, Elements elm) {
        // TODO

        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else if(elm.equals(Elements.ETHYLALCOHOL))
            return temp >= Elements.ETHYLALCOHOL.boilPt;
        else if(elm.equals(Elements.WATER))
            return temp >= Elements.WATER.boilPt;
        else if(elm.equals(Elements.OXYGEN))
            return temp >= Elements.OXYGEN.boilPt;
        else
            return false;
    }

}


