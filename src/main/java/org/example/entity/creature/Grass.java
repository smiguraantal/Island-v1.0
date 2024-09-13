package org.example.entity.creature;

import org.example.entity.Constants;
import org.example.gui.Territory;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A fű osztálya */
public class Grass extends Creature implements Constants {

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Grass(Territory territory, boolean newBorn) {
        super(territory, newBorn);
    }

    //----------------------------------------------------------------------

    /** Beállítja a fűre jellemző adatokat */
    protected void initCreature() {
        maxAge = dataModule.getGrassMaxAge();
        beginOfMultiplication = dataModule.getGrassBeginOfMultiplication();
        endOfMultiplication = dataModule.getGrassEndOfMultiplication();
        numberOfDescendant = dataModule.getGrassNumberOfDescendant();
    }

    //----------------------------------------------------------------------

    /** Szaporodás */
    protected void multiplication() {
        for (int i = 0; i < dataModule.getGrassNumberOfDescendant(); i++) {
            Territory neighbourTerritory = territory.randomNeighbourTerritory();
            neighbourTerritory.addCreature(new Grass(neighbourTerritory, true));
        }
    }

    //----------------------------------------------------------------------

    /** Az idő múlása */
    public void progressOfTime() {
        super.progressOfTime();
        if (age == maxAge) // ha elérte a maximális életkort
            death();
        else if (age >= beginOfMultiplication && age <= endOfMultiplication) // ha ivarérett
            multiplication();
        examined = true;
    }
}










