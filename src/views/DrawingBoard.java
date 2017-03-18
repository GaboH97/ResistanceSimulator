package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;
import models.entity.BandColor;
import models.entity.Resistance;

/**
 *
 * @author Gabriel Huertas
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

    public DrawingBoard(JPanel parentContainer) {

        setPreferredSize(parentContainer.getPreferredSize());
        setSize(parentContainer.getSize());
        setBackground(Color.WHITE);

        boardWidth = getWidth();
        boardHeight = getHeight();
        bodyWidth = boardWidth / 3;
        bodyHeight = boardHeight / 5;
        centerPoint = new Point(boardWidth / 2, boardHeight / 2);
        bandGap = 0;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawResistance(g);
        if (bandColors != null) {
            
        }
    }

    public void drawResistance(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        //Drawing Resistance Body
        g.setColor(new Color(236, 209, 76));
        int diameter = (int) (bodyHeight * 1.5);
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
        return (bandAmount == 6) ? (bodyWidth - (4 * bandWidth)) / 4 : (bodyWidth - (3 * bandWidth)) / 3;
    }
    
    public void drawResistance(BandColor bandColor[]){
        this.bandColors=bandColor;
        repaint();
    }

}
