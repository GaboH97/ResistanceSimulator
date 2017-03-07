package models.entity;

/**
 *
 * @author Gabriel Huertas
 */
public class Resistance {

    private byte tolerancePercentage;
    private double multiplicator;
    private byte bandAmount;
    private double value;
    private int ppm;

    public Resistance() {
        tolerancePercentage = 0;
        bandAmount = 0;
        value = 0;
        ppm = 0;
        multiplicator = 0;
    }

    /**
     *
     * @param colorCodes
     * @return The value of the resistance
     */
    public double calculateValue(String colorCodes) {
        switch (bandAmount) {
            case 4:
                //value = ((firstBand*10)+secondBand)*multiplicator;
                break;
            case 5:
                ////value = ((firstBand*100)+secondBand*10)*multiplicator;
                break;
            case 6:
                //value = (((firstBand*1000)+secondBand*100)+thirdBand*10)*multiplicator;
                break;
        }
        return value;
    }

    public byte getTolerancePercentage() {
        return tolerancePercentage;
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
