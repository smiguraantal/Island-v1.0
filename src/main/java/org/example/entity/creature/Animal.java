package org.example.entity.creature;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

import org.example.gui.Territory;

/** Absztrakt állat osztály */
public abstract class Animal extends Creature {

    /** Az állat éhségének foka */
    protected int hunger;

    /** Az éhenhaláshoz szükséges éhségérzet */
    protected int maxHunger;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Animal(Territory territory, boolean newBorn) {
        super(territory, newBorn);
    }

    //----------------------------------------------------------------------

    /** Az állat a kapott területen lesz nyílvántartva, a régi területéről
     * pedig törlődik */
    protected void changeTerritory(Territory neighbourTerritory) {
        neighbourTerritory.addCreature(this);
        territory.removeCreature(this);
        this.territory = neighbourTerritory;
    }

    //----------------------------------------------------------------------

    /** Mozgás a kapott területre */
    protected void move() {
        if (dataModule.getFoodSearching() == RANDOM_FOOD_SEARCHING)
            randomMove();
        else
            consciousMove();
    }

    //----------------------------------------------------------------------

    /** Véletlenszerű mozgás */
    protected abstract void randomMove();

    //----------------------------------------------------------------------

    /** Tudatos mozgás */
    protected abstract void consciousMove();

    //----------------------------------------------------------------------

    /** Visszaadja, hogy sikerült-e találni és enni valamilyen táplálékot a
     * szigeten */
    protected abstract boolean successfulEating();

    //----------------------------------------------------------------------

    /** Táplálkozás */
    protected void eating() {
        hunger = successfulEating() ? 0 : hunger + 1;
    }

    //----------------------------------------------------------------------

    /** Az idő múlása */
    public void progressOfTime() {
        super.progressOfTime();
        eating();
        if (age == maxAge || hunger == maxHunger) { // ha elérte a maximális életkort vagy már nem bírja élelem nélkül
            death();
            return;
        }
        if (hunger != 0) // ha sikerült valamit ennie
            move();
        if (age >= beginOfMultiplication && age <= endOfMultiplication) // ha ivarérett
            multiplication();
        examined = true;
    }
}







