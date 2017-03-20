package models.entity;

/**
 *
 * @author Gabriel Huertas
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
     *
     *
     *
     * @param colorCodes
     */
    public void calculateValues(BandColor[] bandColors) {
        resetValues();
        System.out.println(bandColors[0].toString() + bandColors[1].toString() + bandColors[2].toString() + bandColors[3].toString());

        System.out.println("Penetro aquí aaaaaaaaaaaaaaaaaa" + bandColors[2]);

        if (bandAmount == 4) {
            System.out.println("Penetro aquí aaaaaaaaaaaaaaaaaa");
            setTheoricalValue(((getColorValue(bandColors[0]) * 10) + getColorValue(bandColors[1])) * getColorMultiplicator(bandColors[2]));
            setTolerancePercentage(getTolerancePercentage(bandColors[3]));
        } else {
            setTheoricalValue(((getColorValue(bandColors[0]) * 100) + (getColorValue(bandColors[1]) * 10) + (getColorValue(bandColors[2]))) * getColorMultiplicator(bandColors[3]));
            setTolerancePercentage(getTolerancePercentage(bandColors[3]));
            if (bandAmount == 6) {
                setPpm(getPPMValue(bandColors[5]));
            }
        }
        setMaxValue(theoricalValue + (theoricalValue * tolerancePercentage));
        setMinValue(theoricalValue - (theoricalValue * tolerancePercentage));

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

    public double getColorMultiplicator(BandColor bandColor) {
        System.out.println("The fucking band is " + bandColor.toString());
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
        System.out.println("The fucking multiplicator is " + multiplicator);
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
    public void setTolerancePercentage(double tolerancePercentage) {
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

    public double getTolerancePercentage() {
        return tolerancePercentage;
    }

    public void setTheoricalValue(double theoricalValue) {
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

    public Object[] getResistanceValues() {
        return new Object[]{theoricalValue, minValue, maxValue, tolerancePercentage, ppm};
    }

    public void resetValues() {
        theoricalValue = 0;
        minValue = 0;
        maxValue = 0;
        tolerancePercentage = 0;
        ppm = 0;
    }
}
