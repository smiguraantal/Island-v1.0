package gui.panel;

import org.example.gui.panel.ChartBase;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/**
 * A diagramot megrajzoló panel
 */
public class Diagram extends ChartBase {

    /**
     * Az élőlények számai az egyes időpillanatokban.
     */
    private int grasses;
    private int grasshoppers;
    private int lizards;

    /**
     * Az egyes élőlényekhez számához tartozó x értékek.
     */
    private int xGrass;
    private int xGrasshopper;
    private int xLizard;

    /**
     * Az egyes élőlényekhez számához tartozó y értékek.
     */
    private int yGrass;
    private int yGrasshopper;
    private int yLizard;

    /**
     * Az oszlop szélessége
     */
    private int columnWidth = DIAGRAM_COLUMN_WIDTH;

    /**
     * Az oszlopok közötti hézag
     */
    private int gap = DIAGRAM_GAP;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Diagram(int grasses, int grasshoppers, int lizards) {
        this.grasses = grasses;
        this.grasshoppers = grasshoppers;
        this.lizards = lizards;
        init();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a szükséges pontok koordinátáit
     */
    public void init() {
        totalWidth = xNull + 4 * DIAGRAM_GAP + 3 * DIAGRAM_COLUMN_WIDTH;
        totalHeight = 460;
        calculateYMax();
        yNull = totalHeight - 20;
        xGrass = xNull + gap;
        xGrasshopper = xNull + 2 * gap + columnWidth;
        xLizard = xNull + 3 * gap + 2 * columnWidth;

        setPreferredSize(new Dimension(totalWidth, totalHeight));
        setSize(new Dimension(totalWidth, totalHeight));

        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * Frissíti a diagramot
     */
    public void progressOfTime() {
        this.grasses = dataModule.getNumberOfGrasses();
        this.grasshoppers = dataModule.getNumberOfGrasshoppers();
        this.lizards = dataModule.getNumberOfLizards();
        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * Kiszámolja az y értékeket(az oszlopok tetejét).
     */
    private void calculatePoints() {
        yGrass = (int) (yNull - dataModule.getScaleY() * grasses); //// !!!!
        yGrasshopper = (int) (yNull - dataModule.getScaleY() * grasshoppers);
        yLizard = (int) (yNull - dataModule.getScaleY() * lizards);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja az oszlopdiagramot.
     */
    protected void paintComponent(Graphics g) {
        g.setColor((Color) UIManager.get("Panel.background"));
        g.fillRect(0, 0, totalWidth, totalHeight);

        axes(g, Color.black);
        horizontalLines(g);
        labelXAxis(g, Color.black);
        scaleYAxis(g, Color.black);

        calculatePoints();
        drawing(g);
    }

    //----------------------------------------------------------------------

    /**
     * Kiírja az x tengely alá az oszlopokhoz tartozó élőlények nevét.
     */
    private void labelXAxis(Graphics g, Color c) {
        g.setColor(c);
        g.drawString("Fű", xGrass - (stringWidth("Fű") - columnWidth) / 2, totalHeight - 5);
        g.drawString("Szöcske", xGrasshopper - (stringWidth("Szöcske") - columnWidth) / 2, totalHeight - 5);
        g.drawString("Gyík", xLizard - (stringWidth("Gyík") - columnWidth) / 2, totalHeight - 5);
    }

    //----------------------------------------------------------------------

    /**
     * Vissszaadja a kapott string szélességét.
     */
    private int stringWidth(String s) {
        FontMetrics fm = getGraphics().getFontMetrics();
        return fm.stringWidth(s);
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzoltatja az oszlopokat.
     */
    private void drawing(Graphics g) {
        columnDrawing(g, new Color(0, GRASS_COLOR_UPPER_BOUND, 0),
                new Color(0, GRASS_COLOR_LOWER_BOUND, 0),
                xGrass, yGrass, xGrass + columnWidth, yNull);
        columnDrawing(g, new Color(GRASSHOPPER_COLOR_UPPER_BOUND, 0, 0),
                new Color(GRASSHOPPER_COLOR_LOWER_BOUND, 0, 0),
                xGrasshopper, yGrasshopper, xGrasshopper + columnWidth, yNull);
        columnDrawing(g, new Color(0, 0, LIZARD_COLOR_UPPER_BOUND),
                new Color(0, 0, LIZARD_COLOR_LOWER_BOUND),
                xLizard, yLizard, xLizard + columnWidth, yNull);
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzol egy oszlopot a kapott adatok alapján színátmenettel.
     */
    private void columnDrawing(Graphics g, Color color_1, Color color_2, int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new GradientPaint((float) x1,
                (float) y1,
                color_1,
                (float) x2,
                (float) y2,
                color_2));
        g2.fill(new Rectangle2D.Double(x1,
                y1,
                x2 - x1,
                y2 - y1));
    }


}





