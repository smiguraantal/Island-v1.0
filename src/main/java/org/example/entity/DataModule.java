package org.example.entity;

import org.example.gui.ColorTheme;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Több osztály számára is fontos adatokat tartalmazó osztály */
public class DataModule implements Constants {

    /** Adatmodul */
    private static DataModule dataModule;

    /** Az eltelt idő */
    private int time;

    /** Fűvek száma */
    private int numberOfGrasses;

    /** Szöcskék száma */
    private int numberOfGrasshoppers;

    /** Gyíkok száma */
    private int numberOfLizards;

    /** Betelepítés */
    private int settling;

    /** A sziget adatai */
    private int islandWidth;
    private int islandHeight;
    private double timeUnit;

    /** Az élőlények maximális száma a szigeten */
    private int maxNumberOfGrassesOnTerritory;
    private int maxNumberOfGrasshoppersOnTerritory;
    private int maxNumberOfLizardsOnTerritory;

    /** Betelepítési százalékok */
    private int grassSettling;
    private int grasshopperSettling;
    private int lizardSettling;

    /** A fű jellemzői */
    private int grassMaxAge;
    private int grassBeginOfMultiplication;
    private int grassEndOfMultiplication;
    private int grassNumberOfDescendant;

    /** A szöcske jellemzői */
    private int grasshopperMaxAge;
    private int grasshopperBeginOfMultiplication;
    private int grasshopperEndOfMultiplication;
    private int grasshopperNumberOfDescendant;
    private int grasshopperMaxHunger;

    /** A gyík jellemzői */
    private int lizardMaxAge;
    private int lizardBeginOfMultiplication;
    private int lizardEndOfMultiplication;
    private int lizardNumberOfDescendant;
    private int lizardMaxHunger;

    /** Táplálékkeresés */
    private int foodSearching;

    /** Idő indítása */
    private int timeStart;

    /** Az y tengely skálázásának mértéke */
    private double scaleY;

    /** Megjelenés */
    private int lookAndFeel;

    /** Színséma */
    private ColorTheme colorTheme;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public DataModule() {
        Settings settings = readSettings();

        this.islandWidth = settings.getIslandWidth();
        this.islandHeight = settings.getIslandHeight();
        this.timeUnit = settings.getTimeUnit();

        this.maxNumberOfGrassesOnTerritory = settings.getMaxNumberOfGrassesOnTerritory();
        this.maxNumberOfGrasshoppersOnTerritory = settings.getMaxNumberOfGrasshoppersOnTerritory();
        this.maxNumberOfLizardsOnTerritory = settings.getMaxNumberOfLizardsOnTerritory();

        this.grassSettling = settings.getGrassSettling();
        this.grasshopperSettling = settings.getGrasshopperSettling();
        this.lizardSettling = settings.getLizardSettling();

        this.grassMaxAge = settings.getGrassMaxAge();
        this.grassBeginOfMultiplication = settings.getGrassBeginOfMultiplication();
        this.grassEndOfMultiplication = settings.getGrassEndOfMultiplication();
        this.grassNumberOfDescendant = settings.getGrassNumberOfDescendant();

        this.grasshopperMaxAge = settings.getGrasshopperMaxAge();
        this.grasshopperBeginOfMultiplication = settings.getGrasshopperBeginOfMultiplication();
        this.grasshopperEndOfMultiplication = settings.getGrasshopperEndOfMultiplication();
        this.grasshopperNumberOfDescendant = settings.getGrasshopperNumberOfDescendant();
        this.grasshopperMaxHunger = settings.getGrasshopperMaxHunger();

        this.lizardMaxAge = settings.getLizardMaxAge();
        this.lizardBeginOfMultiplication = settings.getLizardBeginOfMultiplication();
        this.lizardEndOfMultiplication = settings.getLizardEndOfMultiplication();
        this.lizardNumberOfDescendant = settings.getLizardNumberOfDescendant();
        this.lizardMaxHunger = settings.getLizardMaxHunger();

        this.foodSearching = settings.getFoodSearching();
        this.timeStart = settings.getTimeStart();

        this.scaleY = settings.getScaleY();

        this.lookAndFeel = settings.getLookAndFeel();

        this.colorTheme = settings.getColorTheme();
    }

    //----------------------------------------------------------------------

    /** Visszaadja az adatmodult */
    public static DataModule getDataModule() {
        if (dataModule == null)
            dataModule = new DataModule();
        return dataModule;
    }

    //----------------------------------------------------------------------

    /** növeli az eltelt időt */
    public void increaseTime() {
        ++time;
    }

    //----------------------------------------------------------------------

    /** növeli a füvek számát */
    public void increaseGrasses() {
        ++numberOfGrasses;
    }

    //----------------------------------------------------------------------

    /** növeli a szöcskék számát */
    public void increaseGrasshoppers() {
        ++numberOfGrasshoppers;
    }

    //----------------------------------------------------------------------

    /** Növeli a gyíkok számát */
    public void increaseLizards() {
        ++numberOfLizards;
    }

    //----------------------------------------------------------------------

    /** Csökkenti a füvek számát */
    public void decreaseGrasses() {
        --numberOfGrasses;
    }

    //----------------------------------------------------------------------

    /** Csökkenti a szöcskék számát */
    public void decreaseGrasshoppers() {
        --numberOfGrasshoppers;
    }

    //----------------------------------------------------------------------

    /** Csökkenti a gyíkok számát */
    public void decreaseLizards() {
        --numberOfLizards;
    }

    //----------------------------------------------------------------------

    /** Kiírja a megadott beállításokat */
    public void writeSettings(Object object) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("settings.dat"));
            os.writeObject(object);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //----------------------------------------------------------------------

    /** Beolvassa a beállításokat */
    public Settings readSettings() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("settings.dat"));
            Settings settings = (Settings) os.readObject();
            os.close();
            return settings;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Settings();
    }

    //----------------------------------------------------------------------

    /** Az osztályadatok alapján visszaad egy objektumot, mely a beállításokat
     * tartalmazza. */
    private Settings getSettings() {
        return new Settings(islandWidth,
                islandHeight,
                timeUnit,

                maxNumberOfGrassesOnTerritory,
                maxNumberOfGrasshoppersOnTerritory,
                maxNumberOfLizardsOnTerritory,

                grassSettling,
                grasshopperSettling,
                lizardSettling,

                grassMaxAge,
                grassBeginOfMultiplication,
                grassEndOfMultiplication,
                grassNumberOfDescendant,

                grasshopperMaxAge,
                grasshopperBeginOfMultiplication,
                grasshopperEndOfMultiplication,
                grasshopperNumberOfDescendant,
                grasshopperMaxHunger,

                lizardMaxAge,
                lizardBeginOfMultiplication,
                lizardEndOfMultiplication,
                lizardNumberOfDescendant,
                lizardMaxHunger,

                foodSearching,
                timeStart,

                scaleY,

                lookAndFeel,

                colorTheme);
    }

    //---------------------- Beállító metódusok mentéssel ----------------

    public void setTimeUnit(double timeUnit) {
        this.timeUnit = timeUnit;
        writeSettings(getSettings());
    }

    public void setGrassBeginOfMultiplication(int grassBeginOfMultiplication) {
        this.grassBeginOfMultiplication = grassBeginOfMultiplication;
        writeSettings(getSettings());
    }

    public void setGrassEndOfMultiplication(int grassEndOfMultiplication) {
        this.grassEndOfMultiplication = grassEndOfMultiplication;
        writeSettings(getSettings());
    }

    public void setGrasshopperBeginOfMultiplication(int grasshopperBeginOfMultiplication) {
        this.grasshopperBeginOfMultiplication = grasshopperBeginOfMultiplication;
        writeSettings(getSettings());
    }

    public void setGrasshopperEndOfMultiplication(int grasshopperEndOfMultiplication) {
        this.grasshopperEndOfMultiplication = grasshopperEndOfMultiplication;
        writeSettings(getSettings());
    }

    public void setGrasshopperMaxAge(int grasshopperMaxAge) {
        this.grasshopperMaxAge = grasshopperMaxAge;
        writeSettings(getSettings());
    }

    public void setGrasshopperMaxHunger(int grasshopperMaxHunger) {
        this.grasshopperMaxHunger = grasshopperMaxHunger;
        writeSettings(getSettings());
    }

    public void setGrasshopperNumberOfDescendant(int grasshopperNumberOfDescendant) {
        this.grasshopperNumberOfDescendant = grasshopperNumberOfDescendant;
        writeSettings(getSettings());
    }

    public void setGrassMaxAge(int grassMaxAge) {
        this.grassMaxAge = grassMaxAge;
        writeSettings(getSettings());
    }

    public void setGrassNumberOfDescendant(int grassNumberOfDescendant) {
        this.grassNumberOfDescendant = grassNumberOfDescendant;
        writeSettings(getSettings());
    }

    public void setIslandHeight(int islandHeight) {
        this.islandHeight = islandHeight;
        writeSettings(getSettings());
    }

    public void setIslandWidth(int islandWidth) {
        this.islandWidth = islandWidth;
        writeSettings(getSettings());
    }

    public void setLizardBeginOfMultiplication(int lizardBeginOfMultiplication) {
        this.lizardBeginOfMultiplication = lizardBeginOfMultiplication;
        writeSettings(getSettings());
    }

    public void setLizardEndOfMultiplication(int lizardEndOfMultiplication) {
        this.lizardEndOfMultiplication = lizardEndOfMultiplication;
        writeSettings(getSettings());
    }

    public void setLizardMaxAge(int lizardMaxAge) {
        this.lizardMaxAge = lizardMaxAge;
        writeSettings(getSettings());
    }

    public void setLizardMaxHunger(int lizardMaxHunger) {
        this.lizardMaxHunger = lizardMaxHunger;
        writeSettings(getSettings());
    }

    public void setLizardNumberOfDescendant(int lizardNumberOfDescendant) {
        this.lizardNumberOfDescendant = lizardNumberOfDescendant;
        writeSettings(getSettings());
    }

    public void setMaxNumberOfGrassesOnTerritory(int maxNumberOfGrassesOnTerritory) {
        this.maxNumberOfGrassesOnTerritory = maxNumberOfGrassesOnTerritory;
        writeSettings(getSettings());
    }

    public void setMaxNumberOfGrasshoppersOnTerritory(int maxNumberOfGrasshoppersOnTerritory) {
        this.maxNumberOfGrasshoppersOnTerritory = maxNumberOfGrasshoppersOnTerritory;
        writeSettings(getSettings());
    }

    public void setMaxNumberOfLizardsOnTerritory(int maxNumberOfLizardsOnTerritory) {
        this.maxNumberOfLizardsOnTerritory = maxNumberOfLizardsOnTerritory;
        writeSettings(getSettings());
    }

    public void setGrasshopperSettling(int grasshopperSettling) {
        this.grasshopperSettling = grasshopperSettling;
        writeSettings(getSettings());
    }

    public void setGrassSettling(int grassSettling) {
        this.grassSettling = grassSettling;
        writeSettings(getSettings());
    }

    public void setLizardSettling(int lizardSettling) {
        this.lizardSettling = lizardSettling;
        writeSettings(getSettings());
    }

    public void setFoodSearching(int foodSearching) {
        this.foodSearching = foodSearching;
        writeSettings(getSettings());
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
        writeSettings(getSettings());
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
        writeSettings(getSettings());
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
        writeSettings(getSettings());
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
        writeSettings(getSettings());
    }

    //----------------------------------------------------------------------

    public int getNumberOfGrasses() {
        return numberOfGrasses;
    }

    public int getNumberOfGrasshoppers() {
        return numberOfGrasshoppers;
    }

    public int getNumberOfLizards() {
        return numberOfLizards;
    }

    public void setNumberOfGrasses(int numberOfGrasses) {
        this.numberOfGrasses = numberOfGrasses;
    }

    public void setNumberOfGrasshoppers(int numberOfGrasshoppers) {
        this.numberOfGrasshoppers = numberOfGrasshoppers;
    }

    public void setNumberOfLizards(int numberOfLizards) {
        this.numberOfLizards = numberOfLizards;
    }

    public double getTimeUnit() {
        return timeUnit;
    }

    public int getGrassBeginOfMultiplication() {
        return grassBeginOfMultiplication;
    }

    public int getGrassEndOfMultiplication() {
        return grassEndOfMultiplication;
    }

    public int getGrasshopperBeginOfMultiplication() {
        return grasshopperBeginOfMultiplication;
    }

    public int getGrasshopperEndOfMultiplication() {
        return grasshopperEndOfMultiplication;
    }

    public int getGrasshopperMaxAge() {
        return grasshopperMaxAge;
    }

    public int getGrasshopperMaxHunger() {
        return grasshopperMaxHunger;
    }

    public int getGrasshopperNumberOfDescendant() {
        return grasshopperNumberOfDescendant;
    }

    public int getGrassMaxAge() {
        return grassMaxAge;
    }

    public int getGrassNumberOfDescendant() {
        return grassNumberOfDescendant;
    }

    public int getIslandHeight() {
        return islandHeight;
    }

    public int getIslandWidth() {
        return islandWidth;
    }

    public int getLizardBeginOfMultiplication() {
        return lizardBeginOfMultiplication;
    }

    public int getLizardEndOfMultiplication() {
        return lizardEndOfMultiplication;
    }

    public int getLizardMaxAge() {
        return lizardMaxAge;
    }

    public int getLizardMaxHunger() {
        return lizardMaxHunger;
    }

    public int getLizardNumberOfDescendant() {
        return lizardNumberOfDescendant;
    }

    public int getMaxNumberOfGrassesOnTerritory() {
        return maxNumberOfGrassesOnTerritory;
    }

    public int getMaxNumberOfGrasshoppersOnTerritory() {
        return maxNumberOfGrasshoppersOnTerritory;
    }

    public int getMaxNumberOfLizardsOnTerritory() {
        return maxNumberOfLizardsOnTerritory;
    }

    public int getSettling() {
        return settling;
    }

    public void setSettling(int settling) {
        this.settling = settling;
    }

    public int getGrasshopperSettling() {
        return grasshopperSettling;
    }

    public int getGrassSettling() {
        return grassSettling;
    }

    public int getLizardSettling() {
        return lizardSettling;
    }

    public int getFoodSearching() {
        return foodSearching;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public double getScaleY() {
        return scaleY;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }
}