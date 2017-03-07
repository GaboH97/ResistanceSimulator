package models.entity;

/**
 *
 * @author Gabriel Huertas
 */
public class Resistance {

    private float tolerancePercentage;
    private byte bandAmount;
    private double value;
    private int ppm;

    public Resistance() {
        tolerancePercentage = 0;
        bandAmount = 0;
        value = 0;
        ppm = 0;
    }

    /**
     *
     * @param colorCodes
     * @return The value of the resistance
     */
    public double calculateValue(BandColor[] bandColors) {
        if (bandAmount == 4) {
            value = ((getColorValue(bandColors[0]) * 10) + getColorValue(bandColors[1])) * getColorMultiplicator(bandColors[2]);
            tolerancePercentage = getTolerancePercentage(bandColors[3]);
        } else {
            value = ((getColorValue(bandColors[0]) * 100) + (getColorValue(bandColors[1]) * 10) + (getColorValue(bandColors[2]))) * getColorMultiplicator(bandColors[3]);
            tolerancePercentage = getTolerancePercentage(bandColors[3]);
            if (bandAmount == 6) {
                ppm = getPPMValue(bandColors[5]);
            }
        }
        return value;
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
                tolerance =  0.2f;
                break;
            case BROWN:
                tolerance =  0.01f;
                break;
            default:
        }
        return tolerancePercentage;
    }

    public float getTolerancePercentage() {
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

    public void setTolerancePercentage(byte tolerancePercentage) {
        this.tolerancePercentage = tolerancePercentage;
    }

    public byte getBandAmount() {
        return bandAmount;
    }

    public void setBandAmount(byte bandAmount) {
        this.bandAmount = bandAmount;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public double getValue() {
        return this.value;
    }

    public void setBandsAmount(byte bandsAmount) {
        this.bandAmount = bandsAmount;
    }
}
