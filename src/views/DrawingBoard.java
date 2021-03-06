package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import models.entity.BandColor;

/**
 *
 * @author Huertas G., Quintero. J
 * @version 1.0
 */
public class DrawingBoard extends JPanel {

    private int boardWidth;
    private int boardHeight;
    private static final int ARC_ANGLE = 270;
    private int bodyWidth;
    private int bandWidth;
    private int bodyHeight;
    private Point centerPoint;
    private int bandGap;
    private BandColor[] bandColors;
    private int diameter;
    
    public DrawingBoard(JPanel parentContainer) {

        setPreferredSize(parentContainer.getPreferredSize());
        setSize(parentContainer.getSize());
        setBackground(Color.WHITE);

        boardWidth = getWidth();
        boardHeight = getHeight();
        bodyWidth = boardWidth / 3;
        bodyHeight = boardHeight / 5;
        bandWidth = bodyWidth / 8;
        diameter = (int) (bodyHeight * 1.5);
        centerPoint = new Point(boardWidth / 2, boardHeight / 2);
        bandColors = null;
        bandGap = 0;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawResistance(g);
        if (bandColors != null) {
            drawResistance(g, bandColors.length);
        }
    }

    public void drawResistance(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        //Drawing Resistance Body
        g.setColor(new Color(236, 209, 76));

        g.fillRect(centerPoint.x - (bodyWidth / 2), centerPoint.y - (bodyHeight / 2), bodyWidth, bodyHeight);
        g.fillArc(centerPoint.x - (bodyWidth / 2) - ((int) (diameter / 2)), centerPoint.y - ((int) (diameter / 2)), diameter, diameter, 45, ARC_ANGLE);
        g.fillArc(centerPoint.x + (bodyWidth / 2) - ((int) (diameter / 2)), centerPoint.y - ((int) (diameter / 2)), diameter, diameter, 135, -ARC_ANGLE);
        g.setColor(Color.BLACK);
        int thickness = bodyHeight / 12;

        //Draw cupper wires
        g.fillRect(centerPoint.x - bodyWidth - ((int) (diameter / 2)), centerPoint.y - (thickness / 2), bodyWidth / 2, thickness);
        g.fillRect(centerPoint.x + (bodyWidth / 2) + ((int) (diameter / 2)), centerPoint.y - (thickness / 2), bodyWidth / 2, thickness);

    }

    /**
     * Calculates the gap between every pair of bands according to the
     * Resistance's bands amount.
     *
     * @return
     */
    public int calculateGap(int bandAmount) {
        int auxBodyWidth = bodyWidth - diameter;
        return (bandAmount == 6) ? (auxBodyWidth - (4 * bandWidth)) / 4 : (auxBodyWidth - (3 * bandWidth)) / 3;
    }

    public void drawResistance(BandColor bandColor[]) {
        this.bandColors = bandColor;
        setBandGap(calculateGap(bandColors.length));
        repaint();
    }

    public void setBandGap(int bandGap) {
        this.bandGap = bandGap;
    }

    public void drawResistance(Graphics g, int bandAmount) {
        if (bandAmount == 4) {
            for (int i = 0; i < bandAmount - 1; i++) {
                g.setColor(getColorOfBand(bandColors[i]));
                g.fillRect(centerPoint.x - (bodyWidth / 2) + (diameter / 2) + (i * (bandGap + bandWidth)), centerPoint.y - (bodyHeight / 2), bandWidth, bodyHeight);
            }
            g.setColor(getColorOfBand(bandColors[3]));
            g.fillRect(centerPoint.x + (int) (bodyWidth / 2) - (int) (bandWidth / 2), centerPoint.y - (diameter / 2), bandWidth, diameter);
        } else {
            g.setColor(getColorOfBand(bandColors[0]));
            g.fillRect(centerPoint.x - (int) (bodyWidth / 2) - (int) (diameter / 2) + (int) bandWidth, centerPoint.y - (diameter / 2), bandWidth, diameter);
            for (int i = 1; i < bandAmount - 1; i++) {
                g.setColor(getColorOfBand(bandColors[i]));
                g.fillRect(centerPoint.x - (bodyWidth / 2) + (diameter / 2) + ((i - 1) * (bandGap + bandWidth)), centerPoint.y - (bodyHeight / 2), bandWidth, bodyHeight);
            }
            if (bandAmount == 5) {
                g.setColor(getColorOfBand(bandColors[4]));
                g.fillRect(centerPoint.x + (int) (bodyWidth / 2) - (int) (bandWidth / 2), centerPoint.y - (diameter / 2), bandWidth, diameter);
            } else {
                g.setColor(getColorOfBand(bandColors[5]));
                g.fillRect(centerPoint.x + (int) (bodyWidth / 2) - (int) (bandWidth / 2), centerPoint.y - (diameter / 2), bandWidth, diameter);
            }
        }
    }

    public Color getColorOfBand(BandColor bandColor) {
        Color color = null;
        switch (bandColor) {
            case BLACK:
                color = Color.BLACK;
                break;
            case BROWN:
                color = new Color(128, 0, 0);
                break;
            case RED:
                color = new Color(242, 8, 8);
                break;
            case ORANGE:
                color = new Color(255, 162, 0);
                break;
            case YELLOW:
                color = Color.YELLOW;
                break;
            case GREEN:
                color = new Color(48, 228, 35);
                break;
            case BLUE:
                color = new Color(35, 55, 228);
                break;
            case PURPLE:
                color = new Color(157, 35, 228);
                break;
            case GRAY:
                color = Color.GRAY;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
            case GOLDEN:
                color = new Color(212, 175, 55);
                break;
            case SILVER:
                color = new Color(192, 192, 192);
                break;
            default:
                break;
        }
        return color;
    }

}
