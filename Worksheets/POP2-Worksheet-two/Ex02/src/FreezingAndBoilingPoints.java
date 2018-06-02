public class FreezingAndBoilingPoints {

    private static final double WATER_FREEZE_PT = 32;
    private static final double WATER_BOIL_PT = 212;
    private static final double ETHYL_ALCOHOL_FREEZE_PT = -173;
    private static final double ETHYL_ALCOHOL_BOIL_PT  = 172;
    private static final double OXYGEN_FREEZE_PT = -362;
    private static final double OXYGEN_BOIL_PT  = -306;

    private double temperature;

    public FreezingAndBoilingPoints(double t) {
        // TODO
        temperature = t; //  set the value of temperature
    }

    public double getTemperature() {
        // TODO
        return temperature;
    }

    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Ethyl is freezing
     */
    public boolean isEthylAlchoolFreezing() {
        // TODO
        return getTemperature() <= ETHYL_ALCOHOL_FREEZE_PT;
    }
    public void  setTemperature(double newTemp) {
        temperature = newTemp; //  set new value of temperature
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Ethyl is boiling
     */
    public boolean isEthylAlchoolBoiling() {
        // TODO
        return getTemperature() >= ETHYL_ALCOHOL_BOIL_PT ;
    }

    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Oxygen is freezing
     */
    public boolean isOxygenFreezing() {
        // TODO
        return getTemperature() <= OXYGEN_FREEZE_PT ;
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Oxygen is boiling
     */
    public boolean isOxygenBoiling() {
        // TODO
        return getTemperature() >= OXYGEN_BOIL_PT ;
    }

    /**
     * Method should check if the temperature is freezing
     *
     * @return true if Water is freezing
     */
    public boolean isWaterFreezing() {
        // TODO
        return getTemperature() <= WATER_FREEZE_PT;
    }

    /**
     * Method should check if the temperature is boiling
     *
     * @return true if Water is boiling
     */
    public boolean isWaterBoiling() {
        // TODO
        return getTemperature() >= WATER_BOIL_PT;
    }
}