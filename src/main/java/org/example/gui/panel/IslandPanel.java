package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.creature.Grass;
import org.example.entity.creature.Grasshopper;
import org.example.entity.creature.Lizard;
import org.example.gui.Territory;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
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

/** A sziget területeit összefogó panel */
public class IslandPanel extends JPanel implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A szigeten elhelyezkedő területek. */
    private Territory[][] territories;

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public IslandPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        this.setLayout(borderLayout1);

        setPreferredSize(new Dimension(dataModule.getIslandWidth() * UNIT,
                dataModule.getIslandHeight() * UNIT));
        this.addMouseListener(new IslandPanel_this_mouseAdapter(this));
        initTerritories();
        initNeighbours();
        settling();
    }

    //----------------------------------------------------------------------

    /** Létrehozza a szigeten lévő területeket */
    private void initTerritories() {
        territories =
                new Territory[dataModule.getIslandHeight()][dataModule.getIslandWidth()];
        for (int row = 0; row < dataModule.getIslandHeight(); row++) {
            for (int column = 0; column < dataModule.getIslandWidth(); column++) {
                territories[row][column] = new Territory();
            }
        }
    }

    //----------------------------------------------------------------------

    /** Minden egyes területnek meghatározza a szomszédait */
    private void initNeighbours() {
        for (int row = 0; row < dataModule.getIslandHeight(); row++) {
            for (int column = 0; column < dataModule.getIslandWidth(); column++) {
                addNeighbours(row, column);
            }
        }
    }

    //----------------------------------------------------------------------

    /** A kapott sor és oszlopindexű területnek meghatározza a négy vagy annál
     * kevesebb szomszédját */
    private void addNeighbours(int row, int column) {
        if (within(row - 1, column)) // felső szomszéd
            territories[row][column].addNeighbour(territories[row - 1][column]);
        if (within(row, column - 1)) // bal szomszéd
            territories[row][column].addNeighbour(territories[row][column - 1]);
        if (within(row, column + 1)) // jobb szomszéd
            territories[row][column].addNeighbour(territories[row][column + 1]);
        if (within(row + 1, column)) // alsó szomszéd
            territories[row][column].addNeighbour(territories[row + 1][column]);
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy az indexek belül vannak-e a szigeten. */
    private boolean within(int row, int column) {
        return row >= 0 &&
                column >= 0 &&
                row < dataModule.getIslandHeight() &&
                column < dataModule.getIslandWidth();
    }

    //----------------------------------------------------------------------

    /** Betelepíti a szigetre a három fajt */
    private void settling() {
        grassSettling(createTerritoriesVector());
        grasshopperSettling(createTerritoriesVector());
        lizardSettling(createTerritoriesVector());
    }

    //----------------------------------------------------------------------

    /** Beleteszi egy vektorba a területeket */
    private Vector createTerritoriesVector() {
        Vector vector = new Vector();
        for (int row = 0; row < dataModule.getIslandHeight(); row++)
            for (int column = 0; column < dataModule.getIslandWidth(); column++)
                vector.add(territories[row][column]);
        return vector;
    }

    //----------------------------------------------------------------------

    /** Betelepíti a füveket */
    private void grassSettling(Vector vector) {
        int grasses = numberOfCreature(dataModule.getGrassSettling(),
                dataModule.getMaxNumberOfGrassesOnTerritory());
        for (int i = 0; i < grasses; i++) {
            Territory territory = (Territory) vector.get(random(vector.size()));
            territory.addCreature(new Grass(territory, false));
            if (territory.getNumberOfGrasses() == dataModule.getMaxNumberOfGrassesOnTerritory()) // ha már nem tud több füvet fogadni
                vector.remove(territory);
        }
    }

    //----------------------------------------------------------------------

    /** Betelepíti a szöcskéket */
    private void grasshopperSettling(Vector vector) {
        int grasshoppers = numberOfCreature(dataModule.getGrasshopperSettling(),
                dataModule.getMaxNumberOfGrasshoppersOnTerritory());
        for (int i = 0; i < grasshoppers; i++) {
            Territory territory = (Territory) vector.get(random(vector.size()));
            territory.addCreature(new Grasshopper(territory, false));
            if (territory.getNumberOfGrasshoppers() == dataModule.getMaxNumberOfGrasshoppersOnTerritory()) // ha már nem tud több szöcskét fogadni
                vector.remove(territory);
        }
    }

    //----------------------------------------------------------------------

    /** Betelepíti a gyíkokat */
    private void lizardSettling(Vector vector) {
        int lizards = numberOfCreature(dataModule.getLizardSettling(),
                dataModule.getMaxNumberOfLizardsOnTerritory());
        for (int i = 0; i < lizards; i++) {
            Territory territory = (Territory) vector.get(random(vector.size()));
            territory.addCreature(new Lizard(territory, false));
            if (territory.getNumberOfLizards() == dataModule.getMaxNumberOfLizardsOnTerritory()) // ha már nem tud több gyíkot fogadni
                vector.remove(territory);
        }
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy hány egyedet kell betelepíteni a szigetre a
     * beállított betelepítési szálakék alapján */
    private int numberOfCreature(int creatureSettlingPercent,
                                 int creatureOnTerritory) {
        return dataModule.getIslandWidth() * dataModule.getIslandHeight() *
                creatureOnTerritory * creatureSettlingPercent / 100;
    }

    //----------------------------------------------------------------------

    /** Visszaad egy véletlenszámot nulla és max között */
    private int random(int max) {
        return (int) (Math.random() * max);
    }

    //----------------------------------------------------------------------

    /** Értesíti az élőlényeket, hogy letelet egy időperiódus és tegyék a
     * dolgukat */
    public void progressOfTime() {
        for (int row = 0; row < dataModule.getIslandHeight(); row++) {
            for (int column = 0; column < dataModule.getIslandWidth(); column++) {
                territories[row][column].progressOfTime();
            }
        }
        for (int row = 0; row < dataModule.getIslandHeight(); row++) {
            for (int column = 0; column < dataModule.getIslandWidth(); column++) {
                territories[row][column].endOfPeriod();
            }
        }
        repaint();
    }

    //----------------------------------------------------------------------

    /** Kiszámolja hogy milyen színe lesz a területen lévő fűnek */
    private Color grassColor(int grasses) {
        int green = 0;
        if (grasses == 1) // a füvek száma 1
            green = GRASS_COLOR_UPPER_BOUND;
        else { // a füvek száma 2 vagy több
            int destance = GRASS_COLOR_UPPER_BOUND - GRASS_COLOR_LOWER_BOUND;
            double decrement =
                    destance / (dataModule.getMaxNumberOfGrassesOnTerritory() * 1.0 - 1);
            green = (int) (GRASS_COLOR_UPPER_BOUND - (grasses - 1) * decrement);
        }
        return new Color(0, green, 0);
    }

    //----------------------------------------------------------------------

    /** Kiszámolja hogy milyen színe lesz a területen lévő szöcskéknek */
    private Color grasshopperColor(int grasshoppers) {
        int red = 0;
        if (grasshoppers == 1) // a szöcskék száma 1
            red = GRASSHOPPER_COLOR_UPPER_BOUND;
        else { // a szöcskék száma 2 vagy több
            int destance = GRASSHOPPER_COLOR_UPPER_BOUND - GRASSHOPPER_COLOR_LOWER_BOUND;
            double decrement =
                    destance / (dataModule.getMaxNumberOfGrasshoppersOnTerritory() * 1.0 - 1);
            red = (int) (GRASSHOPPER_COLOR_UPPER_BOUND - (grasshoppers - 1) * decrement);
        }
        return new Color(red, 0, 0);
    }

    //----------------------------------------------------------------------

    /** Kiszámolja hogy milyen színe lesz a területen lévő gyíkoknak */
    private Color lizardColor(int lizards) {
        int blue = 0;
        if (lizards == 1) // a gyíkok száma 1
            blue = LIZARD_COLOR_UPPER_BOUND;
        else { // a gyíkok száma 2 vagy több
            int destance = LIZARD_COLOR_UPPER_BOUND - LIZARD_COLOR_LOWER_BOUND;
            double decrement =
                    destance / (dataModule.getMaxNumberOfLizardsOnTerritory() * 1.0 - 1);
            blue = (int) (LIZARD_COLOR_UPPER_BOUND - (lizards - 1) * decrement);
        }
        return new Color(0, 0, blue);
    }

    //----------------------------------------------------------------------

    /** Kirajzolja a területen lévő élőlényeket */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < dataModule.getIslandHeight(); row++) {
            for (int column = 0; column < dataModule.getIslandWidth(); column++) {
                g.translate(column * UNIT, row * UNIT);
                if (territories[row][column].getNumberOfGrasses() > 0) {
                    g.setColor(grassColor(territories[row][column].getNumberOfGrasses()));
                    g.fillRect(0, 0, UNIT, UNIT);
                }
                if (territories[row][column].getNumberOfGrasshoppers() > 0) {
                    g.setColor(grasshopperColor(territories[row][column].getNumberOfGrasshoppers()));
                    g.fillRect(2, 2, UNIT - 4, UNIT - 4);
                }
                if (territories[row][column].getNumberOfLizards() > 0) {
                    g.setColor(lizardColor(territories[row][column].getNumberOfLizards()));
                    g.fillRect(4, 4, UNIT - 8, UNIT - 8);
                }
                g.translate(column * -UNIT, row * -UNIT);
            }
        }
    }

    //----------------------------------------------------------------------

    /** Betelepít egy előre kiválasztott fajt a kattintás helyén lévő területre */
    void this_mousePressed(MouseEvent e) {
        int row = e.getY() / UNIT;
        int column = e.getX() / UNIT;
        if (dataModule.getSettling() == GRASS_SETTLING)
            territories[row][column].addCreature(
                    new Grass(territories[row][column], false));
        if (dataModule.getSettling() == GRASSHOPPER_SETTLING)
            territories[row][column].addCreature(
                    new Grasshopper(territories[row][column], false));
        if (dataModule.getSettling() == LIZARD_SETTLING)
            territories[row][column].addCreature(
                    new Lizard(territories[row][column], false));
        repaint();
    }
}

//############################################################################

class IslandPanel_this_mouseAdapter extends java.awt.event.MouseAdapter {
    IslandPanel adaptee;

    IslandPanel_this_mouseAdapter(IslandPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }
}













