package models.entity;

/**
 *
 * @author Huertas G., Quintero. J
 * @version 1.0
 */
public class Resistance {

    private double tolerancePercentage;
    private byte bandAmount;
    private double theoricalValue;
    private double minValue;
    private double maxValue;
    private byte ppm;

    public Resistance() {
        tolerancePercentage = 0;
        bandAmount = 0;
        theoricalValue = 0;
        ppm = 0;
    }

    /**
     * This method calculates: Theorical value, minium possible value, maxium
     * possible value, tolerance percentage and PPM (If required) given a vector
     * of bandColors
     *
     * @param colorCodes
     */
    public void calculateValues(BandColor[] bandColors) {
        /*Reset all values to zero, avoids overwriting values*/
        resetValues();
        /*Set bands amount value*/
        setBandsAmount((byte) bandColors.length);
        /**
         * Once the band amount field is set, values from the band color array
         * are calculated given band amount and
         *
         * 4-band resistance band color pattern {1st significative figure, 2nd
         * significative figure, multiplicator, tolerance percentage}
         *
         * 5-band resistance band color pattern {1st significative figure, 2nd
         * significative figure,3rd significative figure, multiplicator,
         * tolerance percentage}
         *
         * 6-band resistance band color pattern {1st significative figure, 2nd
         * significative figure,3rd significative figure, multiplicator,
         * tolerance percentage,PPM}
         *
         */
        if (bandAmount == 4) {
            setTheoricalValue(((getColorValue(bandColors[0]) * 10)
                    + getColorValue(bandColors[1]))
                    * getColorMultiplicator(bandColors[2]));
            setTolerancePercentage(getTolerancePercentage(bandColors[3]));
        } else {
            setTheoricalValue(((getColorValue(bandColors[0]) * 100)
                    + (getColorValue(bandColors[1]) * 10)
                    + (getColorValue(bandColors[2])))
                    * getColorMultiplicator(bandColors[3]));
            setTolerancePercentage(getTolerancePercentage(bandColors[4]));
            if (bandAmount == 6) {
                setPpm(getPPMValue(bandColors[5]));
            }
        }

        /**
         * Calculates both maximum and minimum values according to the theorical
         * value and tolerance percentage;
         */
        setMaxValue(theoricalValue + (theoricalValue * tolerancePercentage));
        setMinValue(theoricalValue - (theoricalValue * tolerancePercentage));

    }
    
    /**
     * 
     * @param bandColor
     * @return the PPM value given the bandColor parameter
     */
    public byte getPPMValue(BandColor bandColor) {
        byte ppmValue = 0;
        switch (bandColor) {
            case PURPLE:
                ppmValue = 5;
                break;
            case BLUE:
                ppmValue = 10;
                break;
            case ORANGE:
                ppmValue = 15;
                break;
            case YELLOW:
                ppmValue = 25;
                break;
            case RED:
                ppmValue = 50;
                break;
            case BROWN:
                ppmValue = 100;
                break;
        }
        return ppmValue;
    }
    
    /**
     * 
     * @param bandColor
     * @return The tolerance percentage given the bandColor param 
     */
    public double getTolerancePercentage(BandColor bandColor) {
        switch (bandColor) {
            case GOLDEN:
                tolerancePercentage = 0.05;
                break;
            case SILVER:
                tolerancePercentage = 0.1;
                break;
            case RED:
                tolerancePercentage = 0.2;
                break;
            case BROWN:
                tolerancePercentage = 0.01;
                break;
            default:
        }
        return tolerancePercentage;
    }
    
    /**
     * 
     * @param bandColor
     * @return The multiplicator value given the bandColor param
     */
    public double getColorMultiplicator(BandColor bandColor) {
        double multiplicator = 0;
        switch (bandColor) {
            case BLACK:
                multiplicator = 1;
                break;
            case BROWN:
                multiplicator = 10;
                break;
            case RED:
                multiplicator = 100;
                break;
            case ORANGE:
                multiplicator = 1000;
                break;
            case YELLOW:
                multiplicator = 10000;
                break;
            case GREEN:
                multiplicator = 100000;
                break;
            case BLUE:
                multiplicator = 1000000;
                break;
            case GOLDEN:
                multiplicator = 0.1;
                break;
            case SILVER:
                multiplicator = 0.01;
                break;
            default:
                break;
        }
        return multiplicator;
    }
    
    /**
     * 
     * @param bandColor
     * @return the value of the significate figure given the bandColor param
     */
    public byte getColorValue(BandColor bandColor) {
        byte colorValue = 0;
        switch (bandColor) {
            case BLACK:
                colorValue = 0;
                break;
            case BROWN:
                colorValue = 1;
                break;
            case RED:
                colorValue = 2;
                break;
            case ORANGE:
                colorValue = 3;
                break;
            case YELLOW:
                colorValue = 4;
                break;
            case GREEN:
                colorValue = 5;
                break;
            case BLUE:
                colorValue = 6;
                break;
            case PURPLE:
                colorValue = 7;
                break;
            case GRAY:
                colorValue = 8;
                break;
            case WHITE:
                colorValue = 9;
                break;
        }
        return colorValue;
    }

    //====================Getters and Setters======================
    public void setTolerancePercentage(double tolerancePercentage) {
        this.tolerancePercentage = tolerancePercentage;
    }
    
    /**
     * 
     * @return The value of the bandAmount field of this class 
     */
    public byte getBandAmount() {
        return bandAmount;
    }
    
    /**
     * 
     * @return The value of the ppm field of this class 
     */
    public byte getPpm() {
        return ppm;
    }

    public void setPpm(byte ppm) {
        this.ppm = ppm;
    }
    
     /**
     * 
     * @return The value of the theoricalValue field of this class 
     */
    public double getTheoricalValue() {
        return this.theoricalValue;
    }

    public void setBandsAmount(byte bandsAmount) {
        this.bandAmount = bandsAmount;
    }
    
     /**
     * 
     * @return The value of the tolerancePercentage field of this class 
     */
    public double getTolerancePercentage() {
        return tolerancePercentage;
    }

    public void setTheoricalValue(double theoricalValue) {
        this.theoricalValue = theoricalValue;
    }
    
     /**
     * 
     * @return The value of the minValue field of this class 
     */
    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }
    
     /**
     * 
     * @return The value of the maxValue field of this class 
     */
    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
    
    /**
     * 
     * @return An object array containing the values of the attributes
     *         of the resistance
     */
    public Object[] getResistanceValues() {
        return new Object[]{theoricalValue, minValue, maxValue, tolerancePercentage, ppm};
    }
    
    /**
     * Resets all the values of the fields to zero
     */
    public void resetValues() {
        theoricalValue = 0;
        minValue = 0;
        maxValue = 0;
        tolerancePercentage = 0;
        ppm = 0;
    }
}
