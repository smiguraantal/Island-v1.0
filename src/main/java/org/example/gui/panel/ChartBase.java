package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A grafikon és a diagram alapja */
public class ChartBase extends JPanel implements Constants {

    /** Adatmodul */
    protected DataModule dataModule = DataModule.getDataModule();

    /**
     * A háttér szélessége és magassága.
     */
    protected int totalWidth;
    protected int totalHeight;

    /**
     * A koordináta rendszer x és y pontja a képernyőn(origo).
     */
    protected int xNull = CHART_BASE_X_NULL;
    protected int yNull;

    /** A szigeten méretétől függő legnagyobb populáció, ettől függ a grafikon
     * és a diagam magassága */
    protected int max;

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public ChartBase() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
    }

    //----------------------------------------------------------------------

    /** Kiszámolja a grafikon, illetve diagram maximális magasságát */
    protected void calculateYMax() {
        int width = dataModule.getIslandWidth();
        int height = dataModule.getIslandHeight();

        int grasses = width * height * dataModule.getMaxNumberOfGrassesOnTerritory();
        int grasshoppers = width * height * dataModule.getMaxNumberOfGrasshoppersOnTerritory();
        int lizards = width * height * dataModule.getMaxNumberOfLizardsOnTerritory();

        max = Math.max(grasses, grasshoppers);
        max = Math.max(max, lizards);

        if ((int) (max * dataModule.getScaleY()) > totalHeight - 50) {
            totalHeight = (int) (max * dataModule.getScaleY()) + 50;
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a háttér magasságát.
     */
    public int getTotalHeight() {
        return totalHeight;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a háttér szélességét.
     */
    public int getTotalWidth() {
        return totalWidth;
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzolja az x és az y tengelyt.
     */
    protected void axes(Graphics g, Color c) {
        g.setColor(c);
        g.drawLine(0, yNull, totalWidth, yNull);
        g.drawLine(xNull, 0, xNull, totalHeight);
    }

    //----------------------------------------------------------------------

    /** Megrajzol egy vízszintes vonalat */
    protected void drawHorizontalLine(Graphics g, Color c, int i) {
        g.setColor(c);
        g.drawLine(0, (int) (yNull - dataModule.getScaleY() * i), totalWidth, (int) (yNull - dataModule.getScaleY() * i));
    }

    //----------------------------------------------------------------------

    /** Megrajzol egy vízszintes szaggatott vonalat */
    protected void drawHorizontalDashedLine(Graphics g, Color c, int i) {
        float dash1[] = {5.0f}; //vonalak hossza
        BasicStroke dashed = new BasicStroke(1.0f, // vonal vastagság
                BasicStroke.CAP_BUTT, //élek találkozása
                BasicStroke.JOIN_MITER, //vonalvég típusa
                5.0f, //közök hossza ????
                dash1, // szagatott vonalak hossza
                0.0f);
        g.setColor(c);
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = (BasicStroke) g2.getStroke();
        g2.setStroke(dashed);
        g2.drawLine(0, (int) (yNull - dataModule.getScaleY() * i), totalWidth, (int) (yNull - dataModule.getScaleY() * i));
        g2.setStroke(stroke);
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzolja a vízszintes segédvonalakat.
     */
    protected void horizontalLines(Graphics g) {
        for (int i = 25; i <= (int) (totalHeight / dataModule.getScaleY()); i += 25) {
            if (i % 2000 == 0 && dataModule.getScaleY() == 0.025)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 1000 == 0 && dataModule.getScaleY() == 0.05)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 500 == 0 && dataModule.getScaleY() == 0.1)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 500 == 0 && dataModule.getScaleY() == 0.2)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 250 == 0 && dataModule.getScaleY() == 0.4)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 100 == 0 && dataModule.getScaleY() == 0.8)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 50 == 0 && dataModule.getScaleY() == 1.6)
                drawHorizontalDashedLine(g, Color.yellow, i);
            else if (i % 25 == 0 && dataModule.getScaleY() == 3.2)
                drawHorizontalDashedLine(g, Color.yellow, i);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megszámozza az y tengelyt.
     */
    protected void scaleYAxis(Graphics g, Color c) {
        FontMetrics fm = g.getFontMetrics();
        g.setColor(c);
        for (int i = 25; i <= (int) (totalHeight / dataModule.getScaleY()); i += 25) {
            if (i % 2000 == 0 && dataModule.getScaleY() == 0.025)
                drawNumber(g, fm, i);
            else if (i % 1000 == 0 && dataModule.getScaleY() == 0.05)
                drawNumber(g, fm, i);
            else if (i % 500 == 0 && dataModule.getScaleY() == 0.1)
                drawNumber(g, fm, i);
            else if (i % 500 == 0 && dataModule.getScaleY() == 0.2)
                drawNumber(g, fm, i);
            else if (i % 250 == 0 && dataModule.getScaleY() == 0.4)
                drawNumber(g, fm, i);
            else if (i % 100 == 0 && dataModule.getScaleY() == 0.8)
                drawNumber(g, fm, i);
            else if (i % 50 == 0 && dataModule.getScaleY() == 1.6)
                drawNumber(g, fm, i);
            else if (i % 25 == 0 && dataModule.getScaleY() == 3.2)
                drawNumber(g, fm, i);
        }
    }

    //----------------------------------------------------------------------

    /** Kiír egy számot az y tengelyre */
    protected void drawNumber(Graphics g, FontMetrics fm, int i) {
        String s = "" + i;
        int x = xNull - (fm.stringWidth(s));
        g.drawString(s, x, (int) (yNull - dataModule.getScaleY() * i));
    }
}




