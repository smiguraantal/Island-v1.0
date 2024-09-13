package org.example.entity.creature;

import org.example.entity.Constants;
import org.example.gui.Territory;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
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

/** Gyík osztály */
public class Lizard extends Animal implements Constants {

    /** Konstruktor */
    public Lizard(Territory territory, boolean newBorn) {
        super(territory, newBorn);
    }

    //----------------------------------------------------------------------

    /** Beállítja a gyíkra jellemző adatokat */
    protected void initCreature() {
        maxAge = dataModule.getLizardMaxAge();
        beginOfMultiplication = dataModule.getLizardBeginOfMultiplication();
        endOfMultiplication = dataModule.getLizardEndOfMultiplication();
        numberOfDescendant = dataModule.getLizardNumberOfDescendant();
        maxHunger = dataModule.getLizardMaxHunger();
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy sikerült-e találni és enni szöcskét a szigeten */
    protected boolean successfulEating() {
        Collections.shuffle(territory.getCreatures());
        for (int i = 0; i < territory.getCreatures().size(); i++) {
            Creature creature = (Creature) territory.getCreatures().get(i);
            if (!creature.isExamined()) { // ha az adott ciklusban még nem volt vizsgálva
                if (creature instanceof Grasshopper) { // a gyík csak szöcskét eszik
                    creature.death();
                    return true;
                }
            }
        }
        return false;
    }

    //----------------------------------------------------------------------

    /** Szaporodás */
    protected void multiplication() {
        for (int i = 0; i < dataModule.getLizardNumberOfDescendant(); i++) {
            territory.addCreature(new Lizard(territory, true));
        }
    }

    //----------------------------------------------------------------------


    /** Véletlenszerű mozgás valamelyik irányba (ha még van befogadókessége
     * valamelyik szomszédos területnek). */
    protected void randomMove() {
        Vector neighbourTerritories = territory.getNeighbourTerritories();
        Collections.shuffle(neighbourTerritories);
        for (int i = 0; i < neighbourTerritories.size(); i++) {
            Territory neighbourTerritory = (Territory) neighbourTerritories.get(i);
            if (neighbourTerritory.getNumberOfLizards() <
                    MAX_NUMBER_OF_LIZARDS_ON_TERRITORY)
                changeTerritory(neighbourTerritory);
            return;
        }
    }

    //----------------------------------------------------------------------

    /** Tudatos mozgás. Egy gyík abba az irányba megy, ahol a legtöbb szöcskét
     * és a legkevesebb fajtársát találja. Ha nincs ilyen, akkor helyben marad */
    protected void consciousMove() {
        TreeSet territories = new TreeSet(new Comparator() {
            public int compare(Object object_1, Object object_2) {
                Territory territory_1 = (Territory) object_1;
                Territory territory_2 = (Territory) object_2;
                int difference_1 = territory_1.getNumberOfGrasshoppers() - territory_1.getNumberOfLizards();
                int difference_2 = territory_2.getNumberOfGrasshoppers() - territory_2.getNumberOfLizards();
                return difference_1 - difference_2;
            }
        });
        Vector v = new Vector(territory.getNeighbourTerritories()); // szomszédok
        v.add(territory); // saját területe is hozzáadódik

        Collections.shuffle(v); // keverés
        territories.addAll(v); // hozzáadás

        for (int i = territories.size() - 1; i >= 0; i--) {
            Territory territory = (Territory) territories.last();
            if (territory.equals(this)) // ha a saját területe az ideális, akkor nem kell mozgatni a gyíkot
                return;
            if (territory.getNumberOfLizards() < MAX_NUMBER_OF_LIZARDS_ON_TERRITORY) { // ha van hely gyík számára
                changeTerritory(territory);
                return;
            }
            territories.remove(territory); // ha nem volt megfelelő, akkor törlődik
        }
    }
}








