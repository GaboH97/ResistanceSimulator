/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import models.entity.BandColor;

/**
 *
 * @author Gabriel Huertas
 */
public class GlobalConstants {

    public static final Color BLACK = Color.BLACK;
    public static final Color BROWN = new Color(128, 0, 0);
    public static final Color RED = Color.RED;
    public static final Color ORANGE = Color.ORANGE;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color GREEN = Color.GREEN;
    public static final Color BLUE = Color.BLUE;
    public static final Color PURPLE = new Color(128, 0, 128);
    public static final Color GRAY = Color.GRAY;
    public static final Color WHITE = Color.WHITE;
    public static final Color GOLD = new Color(212, 175, 55);
    public static final Color SILVER = new Color(192, 192, 192);
    public static final BandColor[] FOUR_BAND_MULTIPLICATOR = new BandColor[]{BandColor.BLACK, BandColor.BROWN, BandColor.RED, BandColor.ORANGE, BandColor.YELLOW, BandColor.GREEN, BandColor.BLUE, BandColor.GOLDEN, BandColor.SILVER};
    public static final BandColor[] FIVE_OR_SIX_BAND_MULTIPLICATOR = new BandColor[]{BandColor.BLACK, BandColor.BROWN, BandColor.RED, BandColor.ORANGE, BandColor.YELLOW, BandColor.GOLDEN, BandColor.SILVER};
    public static final BandColor[] PPM_BANDCOLOR = new BandColor[]{BandColor.BROWN, BandColor.RED, BandColor.YELLOW, BandColor.ORANGE, BandColor.BLUE, BandColor.PURPLE, BandColor.WHITE};
    public static final BandColor[] TOLERANCE_BANDCOLOR = new BandColor[]{BandColor.BROWN, BandColor.RED, BandColor.GOLDEN, BandColor.SILVER};
}
