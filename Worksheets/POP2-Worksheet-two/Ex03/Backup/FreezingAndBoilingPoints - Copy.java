import java.util.InputMismatchException;


public class enum Elements {
    ETHYLALCOHOL (-173, 172),
    WATER (32, 212),
    OXYGEN (-362, -306);

    private final double freezePt; //Freezing point
    private final double boilPt;   //Boilinging point
    Elements(double freezePt, double boilPt){
        this.freezePt = freezePt;
        this.boilPt = boilPt;
    }
    private double freezePt(){return freezePt; } // The enum ConstructorExamples.Constructor
    private double boilPt(){return boilPt; } // The enum ConstructorExamples.Constructor

    boolean isFreezing(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
            return temp <= freezePt;
    }
    boolean isBoiling(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
            return temp >= boilPt ;
    }
}

public class FreezingAndBoilingPoints {

    private static final double WATER_FREEZE_PT = 32;
    private static final double WATER_BOIL_PT = 212;
    private static final double ETHYL_ALCOHOL_FREEZE_PT = -173;
    private static final double ETHYL_ALCOHOL_BOIL_PT  = 172;
    private static final double OXYGEN_FREEZE_PT = -362;
    private static final double OXYGEN_BOIL_PT  = -306;

    private Double temperature;



    public FreezingAndBoilingPoints(Double t) {
        // TODO
        temperature = t; //  set the value of temperature
    }

    public Double getTemperature() {
        // TODO
        return temperature;
    }

    public void  setTemperature(Double newTemp) {
        temperature = newTemp; //  set new value of temperature
    }
    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Ethyl is freezing
     */
    public boolean isEthylAlchoolFreezing(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp <= ETHYL_ALCOHOL_FREEZE_PT;
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Ethyl is boiling
     */
    public boolean isEthylAlchoolBoiling(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp >= ETHYL_ALCOHOL_BOIL_PT ;
    }

    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Oxygen is freezing
     */
    public boolean isOxygenFreezing(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp <= OXYGEN_FREEZE_PT ;
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Oxygen is boiling
     */
    public boolean isOxygenBoiling(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp >= OXYGEN_BOIL_PT ;
    }

    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Water is freezing
     */
    public boolean isWaterFreezing(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp <= WATER_FREEZE_PT;
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Water is boiling
     */
    public boolean isWaterBoiling(Double temp) {
        // TODO
        if (temp.isNaN()) // Check if temperature is  of type 'double'!
            throw new InputMismatchException("Temperature must be of type 'double'");
        else
        return temp >= WATER_BOIL_PT;
    }
}