package org.example.entity.creature;

import org.example.entity.Constants;
import org.example.entity.DataModule;
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

/** Absztrakt élőlény osztály */
public abstract class Creature implements Constants {

    /** Adatmodul */
    protected DataModule dataModule = DataModule.getDataModule();

    /** A terület, amelyen az élőlény éppen tartózkodik */
    protected Territory territory;

    /** Az élőlény életkora */
    protected int age;

    /** Az élőlény maximális életkora */
    protected int maxAge;

    /** A szaporodás kezdete */
    protected int beginOfMultiplication;

    /** A szaporodás vége */
    protected int endOfMultiplication;

    /** Utódok száma */
    protected int numberOfDescendant;

    /** egy ciklus elteltével már volt-e vizsgálva az élőlény */
    protected boolean examined;

    //----------------------------------------------------------------------

    /** Konstruktor */
    protected Creature(Territory territory, boolean newBorn) {
        this.territory = territory;
        initCreature();
        if (newBorn)
            examined = true;
        else
            age = randomAge();
    }

    //----------------------------------------------------------------------

    /** Beállítja az élőlényre jellemző értékeket */
    protected abstract void initCreature();

    //----------------------------------------------------------------------

    /** Öregedés */
    protected void ageing() {
        ++age;
    }

    //----------------------------------------------------------------------

    /** Szaporodás */
    protected abstract void multiplication();

    //----------------------------------------------------------------------

    /** Halál */
    protected void death() {
        territory.removeCreature(this);
    }

    //----------------------------------------------------------------------

    /** Az idő múlása */
    public void progressOfTime() {
        ageing();
    }

    //----------------------------------------------------------------------

    /** Véletlen életkor meghatározása */
    protected int randomAge() {
        return (int) (Math.random() * maxAge);
    }

    //----------------------------------------------------------------------

    public boolean isExamined() {
        return examined;
    }

    public void setExamined(boolean examined) {
        this.examined = examined;
    }

    public int getAge() {
        return age;
    }
}











