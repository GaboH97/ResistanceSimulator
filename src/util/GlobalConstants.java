package util;

import java.awt.Color;
import java.util.Arrays;
import models.entity.BandColor;

/**
 *
 * @author Huertas G., Quintero. J
 * @version 1.0
 */
public class GlobalConstants {

    public static final BandColor[] FIRST_BAND_COLORS = Arrays.copyOfRange(BandColor.values(), 0, BandColor.values().length);
    public static final BandColor[] FOUR_BAND_MULTIPLICATOR = new BandColor[]{BandColor.BLACK, BandColor.BROWN, BandColor.RED, BandColor.ORANGE, BandColor.YELLOW, BandColor.GREEN, BandColor.BLUE, BandColor.GOLDEN, BandColor.SILVER};
    public static final BandColor[] FIVE_OR_SIX_BAND_MULTIPLICATOR = new BandColor[]{BandColor.BLACK, BandColor.BROWN, BandColor.RED, BandColor.ORANGE, BandColor.YELLOW, BandColor.GOLDEN, BandColor.SILVER};
    public static final BandColor[] PPM_BANDCOLOR = new BandColor[]{BandColor.BROWN, BandColor.RED, BandColor.YELLOW, BandColor.ORANGE, BandColor.BLUE, BandColor.PURPLE, BandColor.WHITE};
    public static final BandColor[] TOLERANCE_BANDCOLOR = new BandColor[]{BandColor.BROWN, BandColor.RED, BandColor.GOLDEN, BandColor.SILVER};
}
