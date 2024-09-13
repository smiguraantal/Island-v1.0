package org.example.gui;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.creature.Creature;
import org.example.entity.creature.Grass;
import org.example.entity.creature.Grasshopper;
import org.example.entity.creature.Lizard;

import java.awt.BorderLayout;
import java.util.Collections;
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

/** A sziget egy rácspontja */
public class Territory implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** Fűvek száma */
    private int numberOfGrasses;

    /** Szöcskék száma */
    private int numberOfGrasshoppers;

    /** Gyíkok száma */
    private int numberOfLizards;

    /** Élőlények */
    private Vector creatures = new Vector();

    /** Szomszédos területek */
    private Vector neighbourTerritories = new Vector();

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /** Hozzáadja a kapott élőlényt az élőlényekhez */
    public void addCreature(Creature creature) {
        if (creature instanceof Grass)
            addGrass(creature);
        if (creature instanceof Grasshopper)
            addGrasshopper(creature);
        if (creature instanceof Lizard)
            addLizard(creature);
    }

    //----------------------------------------------------------------------

    /** Hozzáad az élőlényekhez egy füvet */
    private void addGrass(Creature creature) {
        if (numberOfGrasses < dataModule.getMaxNumberOfGrassesOnTerritory()) {
            creatures.add(creature);
            ++numberOfGrasses;
            dataModule.increaseGrasses();
        }
    }

    //----------------------------------------------------------------------

    /** Hozzáad az élőlényekhez egy szöcskét */
    private void addGrasshopper(Creature creature) {
        if (numberOfGrasshoppers < dataModule.getMaxNumberOfGrasshoppersOnTerritory()) {
            creatures.add(creature);
            ++numberOfGrasshoppers;
            dataModule.increaseGrasshoppers();
        }
    }

    //----------------------------------------------------------------------

    /** Hozzáad az élőlényekhez egy gyíkot */
    private void addLizard(Creature creature) {
        if (numberOfLizards < dataModule.getMaxNumberOfLizardsOnTerritory()) {
            creatures.add(creature);
            ++numberOfLizards;
            dataModule.increaseLizards();
        }
    }

    //----------------------------------------------------------------------

    /** Hozzáadja a kapott területet a szomszédos területekhez */
    public void addNeighbour(Territory territory) {
        neighbourTerritories.add(territory);
    }

    //----------------------------------------------------------------------

    /** Eltávolítja a kapott élőlényt a területről */
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
        if (creature instanceof Grass) {
            --numberOfGrasses;
            dataModule.decreaseGrasses();
        }
        if (creature instanceof Grasshopper) {
            --numberOfGrasshoppers;
            dataModule.decreaseGrasshoppers();
        }
        if (creature instanceof Lizard) {
            --numberOfLizards;
            dataModule.decreaseLizards();
        }
    }

    //----------------------------------------------------------------------

    /** Visszaad egy véletlenszerűen kiválasztott szomszédos területet */
    public Territory randomNeighbourTerritory() {
        return (Territory) neighbourTerritories.get(
                (int) (Math.random() * neighbourTerritories.size()));
    }

    //----------------------------------------------------------------------

    /** Jelzi, az élőlényeknek, hogy eltelt egy időperiódus */
    public void progressOfTime() {
        Collections.shuffle(creatures);
        for (int i = 0; i < creatures.size(); i++) {
            Creature creature = (Creature) creatures.get(i);
            if (!creature.isExamined())
                creature.progressOfTime();
        }
    }

    //----------------------------------------------------------------------

    /** A periódus végén mindenki újra vizsgálható lesz */
    public void endOfPeriod() {
        for (int i = 0; i < creatures.size(); i++) {
            Creature creature = (Creature) creatures.get(i);
            creature.setExamined(false);
        }
    }

    //----------------------------------------------------------------------

    public Vector getCreatures() {
        return creatures;
    }

    public Vector getNeighbourTerritories() {
        return neighbourTerritories;
    }

    public int getNumberOfGrasses() {
        return numberOfGrasses;
    }

    public int getNumberOfGrasshoppers() {
        return numberOfGrasshoppers;
    }

    public int getNumberOfLizards() {
        return numberOfLizards;
    }

}








