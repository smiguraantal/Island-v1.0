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

/** Szöcske osztály */
public class Grasshopper extends Animal implements Constants {

    /** Konstruktor */
    public Grasshopper(Territory territory, boolean newBorn) {
        super(territory, newBorn);
    }

    //----------------------------------------------------------------------

    /** Beállítja a szöcskére jellemző adatokat */
    protected void initCreature() {
        maxAge = dataModule.getGrasshopperMaxAge();
        beginOfMultiplication = dataModule.getGrasshopperBeginOfMultiplication();
        endOfMultiplication = dataModule.getGrasshopperEndOfMultiplication();
        numberOfDescendant = dataModule.getGrasshopperNumberOfDescendant();
        maxHunger = dataModule.getGrasshopperMaxHunger();
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy sikerült-e találni és enni füvet a szigeten */
    protected boolean successfulEating() {
        Collections.shuffle(territory.getCreatures());
        for (int i = 0; i < territory.getCreatures().size(); i++) {
            Creature creature = (Creature) territory.getCreatures().get(i);
            if (!creature.isExamined()) { // ha az adott ciklusban még nem volt vizsgálva
                if (creature instanceof Grass) { // a szöcske csak füvet eszik
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
        for (int i = 0; i < dataModule.getGrasshopperNumberOfDescendant(); i++) {
            territory.addCreature(new Grasshopper(territory, true));
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
            if (neighbourTerritory.getNumberOfGrasshoppers() <
                    MAX_NUMBER_OF_GRASSHOPPERS_ON_TERRITORY)
                changeTerritory(neighbourTerritory);
            return;
        }
    }

    //----------------------------------------------------------------------

    /** Tudatos mozgás. Egy szöcske abba az irányba megy, ahol a legtöbb füvet
     * és a legkevesebb fajtársát találja. Ha nincs ilyen, akkor helyben marad */
    protected void consciousMove() {
        TreeSet territories = new TreeSet(new Comparator() {
            // rendezettség: minél több fű, minél kevesebb szöcske
            public int compare(Object object_1, Object object_2) {
                Territory territory_1 = (Territory) object_1;
                Territory territory_2 = (Territory) object_2;
                int difference_1 = territory_1.getNumberOfGrasses() - territory_1.getNumberOfGrasshoppers();
                int difference_2 = territory_2.getNumberOfGrasses() - territory_2.getNumberOfGrasshoppers();
                return difference_1 - difference_2;
            }
        });
        Vector v = new Vector(territory.getNeighbourTerritories()); // szomszédok
        v.add(territory); // saját területe is hozzáadódik

        Collections.shuffle(v); // keverés
        territories.addAll(v); // hozzáadás

        for (int i = territories.size() - 1; i >= 0; i--) {
            Territory territory = (Territory) territories.last();
            if (territory.equals(this)) // ha a saját területe az ideális, akkor nem kell mozgatni a szöcskét
                return;
            if (territory.getNumberOfGrasshoppers() < MAX_NUMBER_OF_GRASSHOPPERS_ON_TERRITORY) { // ha van hely szöcske számára
                changeTerritory(territory);
                return;
            }
            territories.remove(territory); // ha nem volt megfelelő, akkor törlődik
        }
    }
}







