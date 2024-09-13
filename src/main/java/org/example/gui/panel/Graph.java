package org.example.gui.panel;

import javax.swing.UIManager;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;


/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A grafikont megjelenítő panel */
public class Graph extends ChartBase {

    /**
     * Az élőlények számai az egyes időpillanatokban.
     */
    private Vector grasses = new Vector();
    private Vector grasshoppers = new Vector();
    private Vector lizards = new Vector();

    /**
     * A kirajzolandó görbéhez tartozó koordináták.
     */
    private int[] yGrass;
    private int[] yGrasshopper;
    private int[] yLizard;
    private int[] xCreature;

    /** A függőleges vonalak eltolása */
    private int translate = 50;

    /** A kiírandó számokhoz használt adat */
    int label;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Graph() {
        init();
        add();
    }

    //----------------------------------------------------------------------

    /** Pontok meghatározása */
    public void init() {
        totalWidth = 600;
        totalHeight = 460;
        calculateYMax();
        yNull = totalHeight - 20;

        setPreferredSize(new Dimension(totalWidth, totalHeight));
        setSize(new Dimension(totalWidth, totalHeight));
        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * A kapott értékeket(élőlények számát) eltárolja. Minden időpillanathoz
     * három érték tartozik.
     */
    public void add() {
        if (grasses.size() == 250) {
            grasses.remove(0);
            grasshoppers.remove(0);
            lizards.remove(0);
        }
        grasses.add(new Integer(dataModule.getNumberOfGrasses()));
        grasshoppers.add(new Integer(dataModule.getNumberOfGrasshoppers()));
        lizards.add(new Integer(dataModule.getNumberOfLizards()));
        repaint();
    }

    //----------------------------------------------------------------------

    /** Meghatározza a függőleges vonalak eltolását */
    private void translate() {
        if (grasses.size() == 250) {
            translate -= 2;
            if (translate == 0) {
                translate = 50;
                label += 25;
            }
        }
    }

    //----------------------------------------------------------------------

    /** Egy időciklus elteltekor elmenti az újabb adatokat és megrajzlja a
     * grafikont */
    public void progressOfTime() {
        translate();
        add();
    }

    //----------------------------------------------------------------------

    /**
     * új tömböket hoz létre és feltölti azokat az x, y koordinátákkal;
     */
    private void calculatePoints() {
        yGrass = new int[grasses.size()];
        yGrasshopper = new int[grasshoppers.size()];
        yLizard = new int[lizards.size()];
        xCreature = new int[grasses.size()];

        for (int i = 0; i < grasses.size(); i++) {
            yGrass[i] = (int) (yNull - dataModule.getScaleY() * value(grasses, i));
            yGrasshopper[i] = (int) (yNull - dataModule.getScaleY() * value(grasshoppers, i));
            yLizard[i] = (int) (yNull - dataModule.getScaleY() * value(lizards, i));
            xCreature[i] = (int) (xNull + i * 2);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja egy Integer elemeket tartalmazó vektor i-edik értékét.
     */
    private int value(Vector v, int i) {
        return ((Integer) v.get(i)).intValue();
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzolja a függőleges segédvonalakat.
     */
    protected void verticalLines(Graphics g, Color c) {
        g.setColor(c);
        for (int i = xNull + translate; i < totalWidth; i += 50)
            g.drawLine(i, 0, i, totalHeight);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzoltatja a három polyline-t.
     */
    private void drawing(Graphics g) {
        curveDrawing(g, xCreature, yGrass, new Color(0, 128, 0));
        curveDrawing(g, xCreature, yGrasshopper, Color.red);
        curveDrawing(g, xCreature, yLizard, Color.blue);
    }

    //----------------------------------------------------------------------

    /**
     * Kirajzol egy polyline-t a kapott paramétetek alapján.
     */
    private void curveDrawing(Graphics g, int[] x, int[] y, Color c) {
        BasicStroke wideStroke = new BasicStroke(2.0f,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(wideStroke);
        g2.setColor(c);
        g2.drawPolyline(x, y, x.length);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a grafikont.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor((Color) UIManager.get("Panel.background"));
        g.fillRect(0, 0, totalWidth, totalHeight);

        axes(g, Color.black);
        horizontalLines(g);
        verticalLines(g, Color.white);
        scaleYAxis(g, Color.black);
        labelXAxis(g, Color.black);
        coverCorner(g);

        calculatePoints();
        drawing(g);
    }

    //----------------------------------------------------------------------

    /** Elrejti a bal alsó sarokba vándorló számokat az y tengelytől balra
     * és az x tengelytől felele */
    private void coverCorner(Graphics g) {
        g.setColor((Color) UIManager.get("Panel.background"));
        g.fillRect(0, yNull + 1, CHART_BASE_X_NULL, xNull);
    }

    //----------------------------------------------------------------------

    /**
     * Megszámozza az x tengelyt(az értékeket a vonalak közepén helyezi el).
     */
    private void labelXAxis(Graphics g, Color c) {
        FontMetrics fm = g.getFontMetrics();
        g.setColor(c);
        for (int i = 0; i <= 15; i++) {
            int number = i * 25 + label;
            if (number == 0)
                continue;
            String s = "" + number;
            int x = xNull + i * 50 + translate - 50 - (fm.stringWidth(s) / 2);
            g.drawString(s, x, totalHeight - 5);
        }
    }
}












