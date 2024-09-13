package org.example.entity;

import org.example.gui.ColorTheme;

import java.io.Serializable;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A mentéshez használt, a beállításokat tartalamzó osztály */
public class Settings implements Serializable, Constants {

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
    public Settings(int islandWidth,
                    int islandHeight,
                    double timeUnit,

                    int maxNumberOfGrassesOnTerritory,
                    int maxNumberOfGrasshoppersOnTerritory,
                    int maxNumberOfLizardsOnTerritory,

                    int grassSettling,
                    int grasshopperSettling,
                    int lizardSettling,

                    int grassMaxAge,
                    int grassBeginOfMultiplication,
                    int grassEndOfMultiplication,
                    int grassNumberOfDescendant,

                    int grasshopperMaxAge,
                    int grasshopperBeginOfMultiplication,
                    int grasshopperEndOfMultiplication,
                    int grasshopperNumberOfDescendant,
                    int grasshopperMaxHunger,

                    int lizardMaxAge,
                    int lizardBeginOfMultiplication,
                    int lizardEndOfMultiplication,
                    int lizardNumberOfDescendant,
                    int lizardMaxHunger,

                    int foodSearching,
                    int timeStart,

                    double scaleY,
                    int lookAndFeel,
                    ColorTheme colorTheme) {

        this.islandWidth = islandWidth;
        this.islandHeight = islandHeight;
        this.timeUnit = timeUnit;

        this.maxNumberOfGrassesOnTerritory = maxNumberOfGrassesOnTerritory;
        this.maxNumberOfGrasshoppersOnTerritory = maxNumberOfGrasshoppersOnTerritory;
        this.maxNumberOfLizardsOnTerritory = maxNumberOfLizardsOnTerritory;

        this.grassSettling = grassSettling;
        this.grasshopperSettling = grasshopperSettling;
        this.lizardSettling = lizardSettling;

        this.grassMaxAge = grassMaxAge;
        this.grassBeginOfMultiplication = grassBeginOfMultiplication;
        this.grassEndOfMultiplication = grassEndOfMultiplication;
        this.grassNumberOfDescendant = grassNumberOfDescendant;

        this.grasshopperMaxAge = grasshopperMaxAge;
        this.grasshopperBeginOfMultiplication = grasshopperBeginOfMultiplication;
        this.grasshopperEndOfMultiplication = grasshopperEndOfMultiplication;
        this.grasshopperNumberOfDescendant = grasshopperNumberOfDescendant;
        this.grasshopperMaxHunger = grasshopperMaxHunger;

        this.lizardMaxAge = lizardMaxAge;
        this.lizardBeginOfMultiplication = lizardBeginOfMultiplication;
        this.lizardEndOfMultiplication = lizardEndOfMultiplication;
        this.lizardNumberOfDescendant = lizardNumberOfDescendant;
        this.lizardMaxHunger = lizardMaxHunger;

        this.foodSearching = foodSearching;
        this.timeStart = timeStart;

        this.scaleY = scaleY;

        this.lookAndFeel = lookAndFeel;

        this.colorTheme = colorTheme;
    }

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Settings() {
        this(ISLAND_WIDTH,
                ISLAND_HEIGHT,
                TIME_UNIT,

                MAX_NUMBER_OF_GRASSES_ON_TERRITORY,
                MAX_NUMBER_OF_GRASSHOPPERS_ON_TERRITORY,
                MAX_NUMBER_OF_LIZARDS_ON_TERRITORY,

                GRASS_SETTLING_PERCENT,
                GRASSHOPPER_SETTLING_PERCENT,
                LIZARD_SETTLING_PERCENT,

                GRASS_MAX_AGE,
                GRASS_BEGIN_OF_MULTIPLICATION,
                GRASS_END_OF_MULTIPLICATION,
                GRASS_NUMBER_OF_DESCENDANT,

                GRASSHOPPER_MAX_AGE,
                GRASSHOPPER_BEGIN_OF_MULTIPLICATION,
                GRASSHOPPER_END_OF_MULTIPLICATION,
                GRASSHOPPER_NUMBER_OF_DESCENDANT,
                GRASSHOPPER_MAX_HUNGER,

                LIZARD_MAX_AGE,
                LIZARD_BEGIN_OF_MULTIPLICATION,
                LIZARD_END_OF_MULTIPLICATION,
                LIZARD_NUMBER_OF_DESCENDANT,
                LIZARD_MAX_HUNGER,

                CONSCIOUS_FOOD_SEARCHING,
                AUTOMATIC_TIME_START,

                SCALE_Y_LOWER_BOUND,

                METAL_LOOK_AND_FEEL,

                VIOLET_COLORED);
    }

    //----------------------------------------------------------------------

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

    public int getMaxNumberOfGrassesOnTerritory() {
        return maxNumberOfGrassesOnTerritory;
    }

    public int getMaxNumberOfGrasshoppersOnTerritory() {
        return maxNumberOfGrasshoppersOnTerritory;
    }

    public int getMaxNumberOfLizardsOnTerritory() {
        return maxNumberOfLizardsOnTerritory;
    }

    public double getTimeUnit() {
        return timeUnit;
    }

    public void setGrassBeginOfMultiplication(int grassBeginOfMultiplication) {
        this.grassBeginOfMultiplication = grassBeginOfMultiplication;
    }

    public void setGrassEndOfMultiplication(int grassEndOfMultiplication) {
        this.grassEndOfMultiplication = grassEndOfMultiplication;
    }

    public void setGrasshopperBeginOfMultiplication(int grasshopperBeginOfMultiplication) {
        this.grasshopperBeginOfMultiplication = grasshopperBeginOfMultiplication;
    }

    public void setGrasshopperEndOfMultiplication(int grasshopperEndOfMultiplication) {
        this.grasshopperEndOfMultiplication = grasshopperEndOfMultiplication;
    }

    public void setGrasshopperMaxAge(int grasshopperMaxAge) {
        this.grasshopperMaxAge = grasshopperMaxAge;
    }

    public void setGrasshopperMaxHunger(int grasshopperMaxHunger) {
        this.grasshopperMaxHunger = grasshopperMaxHunger;
    }

    public void setGrasshopperNumberOfDescendant(int grasshopperNumberOfDescendant) {
        this.grasshopperNumberOfDescendant = grasshopperNumberOfDescendant;
    }

    public void setGrassMaxAge(int grassMaxAge) {
        this.grassMaxAge = grassMaxAge;
    }

    public void setGrassNumberOfDescendant(int grassNumberOfDescendant) {
        this.grassNumberOfDescendant = grassNumberOfDescendant;
    }

    public void setIslandHeight(int islandHeight) {
        this.islandHeight = islandHeight;
    }

    public void setIslandWidth(int islandWidth) {
        this.islandWidth = islandWidth;
    }

    public void setLizardBeginOfMultiplication(int lizardBeginOfMultiplication) {
        this.lizardBeginOfMultiplication = lizardBeginOfMultiplication;
    }

    public void setLizardEndOfMultiplication(int lizardEndOfMultiplication) {
        this.lizardEndOfMultiplication = lizardEndOfMultiplication;
    }

    public void setLizardMaxAge(int lizardMaxAge) {
        this.lizardMaxAge = lizardMaxAge;
    }

    public void setLizardMaxHunger(int lizardMaxHunger) {
        this.lizardMaxHunger = lizardMaxHunger;
    }

    public void setLizardNumberOfDescendant(int lizardNumberOfDescendant) {
        this.lizardNumberOfDescendant = lizardNumberOfDescendant;
    }

    public void setMaxNumberOfGrassesOnTerritory(int maxNumberOfGrassesOnTerritory) {
        this.maxNumberOfGrassesOnTerritory = maxNumberOfGrassesOnTerritory;
    }

    public void setMaxNumberOfGrasshoppersOnTerritory(int maxNumberOfGrasshoppersOnTerritory) {
        this.maxNumberOfGrasshoppersOnTerritory = maxNumberOfGrasshoppersOnTerritory;
    }

    public void setMaxNumberOfLizardsOnTerritory(int maxNumberOfLizardsOnTerritory) {
        this.maxNumberOfLizardsOnTerritory = maxNumberOfLizardsOnTerritory;
    }

    public void setTimeUnit(double timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getLizardNumberOfDescendant() {
        return lizardNumberOfDescendant;
    }

    public int getGrasshopperSettling() {
        return grasshopperSettling;
    }

    public int getGrassSettling() {
        return grassSettling;
    }

    public void setGrasshopperSettling(int grasshopperSettling) {
        this.grasshopperSettling = grasshopperSettling;
    }

    public void setGrassSettling(int grassSettling) {
        this.grassSettling = grassSettling;
    }

    public int getLizardSettling() {
        return lizardSettling;
    }

    public void setLizardSettling(int lizardSettling) {
        this.lizardSettling = lizardSettling;
    }

    public int getFoodSearching() {
        return foodSearching;
    }

    public void setFoodSearching(int foodSearching) {
        this.foodSearching = foodSearching;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public double getScaleY() {
        return scaleY;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

}








