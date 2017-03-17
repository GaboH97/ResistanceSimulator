package models.entity;

/**
 *
 * @author Gabriel Huertas
 */
public class Resistance {

    private float tolerancePercentage;
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
     *
     * 
     * 
     * @param colorCodes
     */
    public void calculateValues(BandColor[] bandColors) {
        if (bandAmount == 4) {
            setTheoricalValue(((getColorValue(bandColors[0]) * 10) + getColorValue(bandColors[1])) * getColorMultiplicator(bandColors[2]));
            setTolerancePercentage(getTolerancePercentage(bandColors[3]));
        } else {
            setTheoricalValue(((getColorValue(bandColors[0]) * 100) + (getColorValue(bandColors[1]) * 10) + (getColorValue(bandColors[2]))) * getColorMultiplicator(bandColors[3]));
            setTolerancePercentage(getTolerancePercentage(bandColors[3]));
            if (bandAmount == 6) {
                setPpm(getPPMValue(bandColors[5]));
            }
        }
        setMaxValue(theoricalValue+(theoricalValue*tolerancePercentage));
        setMaxValue(theoricalValue-(theoricalValue*tolerancePercentage));
        
    }

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

    public float getTolerancePercentage(BandColor bandColor) {
        float tolerance = 0;
        switch (bandColor) {
            case GOLDEN:
                tolerance = 0.05f;
                break;
            case SILVER:
                tolerance = 0.1f;
                break;
            case RED:
                tolerance = 0.2f;
                break;
            case BROWN:
                tolerance = 0.01f;
                break;
            default:
        }
        return tolerancePercentage;
    }

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
            case PURPLE:
                multiplicator = 0.1;
                break;
            case GRAY:
                multiplicator = 0.01;
                break;
            default:
                break;
        }
        return multiplicator;
    }

    public byte getColorValue(BandColor bandColor) {
        byte colorValue;
        switch (bandColor) {
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
            default:
                colorValue = 0;
        }
        return colorValue;
    }
    
    //====================Getters and Setters======================

    public void setTolerancePercentage(float tolerancePercentage) {
        this.tolerancePercentage = tolerancePercentage;
    }

    public byte getBandAmount() {
        return bandAmount;
    }

    public void setBandAmount(byte bandAmount) {
        this.bandAmount = bandAmount;
    }

    public byte getPpm() {
        return ppm;
    }

    public void setPpm(byte ppm) {
        this.ppm = ppm;
    }

    public double getTheoricalValue() {
        return this.theoricalValue;
    }

    public void setBandsAmount(byte bandsAmount) {
        this.bandAmount = bandsAmount;
    }
    
    public float getTolerancePercentage() {
        return tolerancePercentage;
    }
    
    public void setTheoricalValue(double theoricalValue){
        this.theoricalValue = theoricalValue;
    }
    
    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public Object getResistanceValues(){
        return new Object[]{theoricalValue,minValue,maxValue,tolerancePercentage,ppm};
    }
}
