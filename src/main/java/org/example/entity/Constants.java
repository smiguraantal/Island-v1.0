package org.example.entity;

import org.example.gui.ColorTheme;

import javax.swing.plaf.ColorUIResource;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Konstans adatok */
public interface Constants {

    // betelepítés
    public static final int GRASS_SETTLING = 0;
    public static final int GRASSHOPPER_SETTLING = 1;
    public static final int LIZARD_SETTLING = 2;

    // időegység
    public static final double TIME_UNIT = 0.25;
    // sziget szélessége
    public static final int ISLAND_WIDTH = 52;
    // sziget magassága
    public static final int ISLAND_HEIGHT = 32;
    // egy terület szélessége
    public static final int UNIT = 14;

    // maximális élőlények száma egy területen
    public static final int MAX_NUMBER_OF_GRASSES_ON_TERRITORY = 5;
    public static final int MAX_NUMBER_OF_GRASSHOPPERS_ON_TERRITORY = 3;
    public static final int MAX_NUMBER_OF_LIZARDS_ON_TERRITORY = 2;

    // betelepítési százalékok
    public static final int GRASS_SETTLING_PERCENT = 100;
    public static final int GRASSHOPPER_SETTLING_PERCENT = 15;
    public static final int LIZARD_SETTLING_PERCENT = 5;

    // fű jellemzői
    public static final int GRASS_MAX_AGE = 10;
    public static final int GRASS_BEGIN_OF_MULTIPLICATION = 4;
    public static final int GRASS_END_OF_MULTIPLICATION = 7;
    public static final int GRASS_NUMBER_OF_DESCENDANT = 2;

    // szöcske jellemzői
    public static final int GRASSHOPPER_MAX_AGE = 8;
    public static final int GRASSHOPPER_BEGIN_OF_MULTIPLICATION = 4;
    public static final int GRASSHOPPER_END_OF_MULTIPLICATION = 6;
    public static final int GRASSHOPPER_NUMBER_OF_DESCENDANT = 2;
    public static final int GRASSHOPPER_MAX_HUNGER = 3;
    // gyík jellemzői
    public static final int LIZARD_MAX_AGE = 10;
    public static final int LIZARD_BEGIN_OF_MULTIPLICATION = 7;
    public static final int LIZARD_END_OF_MULTIPLICATION = 9;
    public static final int LIZARD_NUMBER_OF_DESCENDANT = 1;
    public static final int LIZARD_MAX_HUNGER = 4;

    // táplálékkeresés
    public static final int RANDOM_FOOD_SEARCHING = 0;
    public static final int CONSCIOUS_FOOD_SEARCHING = 1;

    // idő indítás
    public static final int AUTOMATIC_TIME_START = 0;
    public static final int MANUAL_TIME_START = 1;

    // az x tengely koordinátája
    public static final int CHART_BASE_X_NULL = 40;

    // a diagram oszlop és köz szélessége
    public static final int DIAGRAM_COLUMN_WIDTH = 75;
    public static final int DIAGRAM_GAP = 25;

    // az y tengely skálázásának aránya
    public static final double SCALE_Y = 1.0;

    /** A kinézet lehetséges értékei */
    public static final int WINDOWS_LOOK_AND_FEEL = 100;
    public static final int METAL_LOOK_AND_FEEL = 101;
    public static final int MOTIF_LOOK_AND_FEEL = 102;

    /** Zöld */
    public static final ColorTheme SEA_BLUE = new ColorTheme(
            new ColorUIResource(44, 78, 71),
            new ColorUIResource(75, 141, 132),
            new ColorUIResource(136, 192, 184));

    /** Lila */
    public static final ColorTheme VIOLET_COLORED = new ColorTheme(
            new ColorUIResource(102, 102, 153),
            new ColorUIResource(153, 153, 204),
            new ColorUIResource(204, 204, 255));

    /** Világoskék */
    public static final ColorTheme LIGHT_BLUE = new ColorTheme(
            new ColorUIResource(60, 60, 60),
            new ColorUIResource(166, 189, 223),
            new ColorUIResource(193, 214, 230));

    /** Szürke */
    public static final ColorTheme GRAY = new ColorTheme(
            new ColorUIResource(79, 101, 125),
            new ColorUIResource(131, 153, 177),
            new ColorUIResource(193, 204, 217));

    /** Barna */
    public static final ColorTheme DESERT = new ColorTheme(
            new ColorUIResource(120, 96, 88),
            new ColorUIResource(168, 152, 144),
            new ColorUIResource(216, 208, 200));

    /** Windows-os szürke */
    public static final ColorTheme WINDOWS_GRAY = new ColorTheme(
            new ColorUIResource(113, 111, 100),
            new ColorUIResource(172, 168, 153),
            new ColorUIResource(236, 233, 216));

    /** Metal-os szürke */
    public static final ColorTheme METAL_GRAY = new ColorTheme(
            new ColorUIResource(102, 102, 102),
            new ColorUIResource(153, 153, 153),
            new ColorUIResource(204, 204, 204));

    /** Borland-os szürke */
    public static final ColorTheme BORLAND_GRAY = new ColorTheme(
            new ColorUIResource(102, 102, 102),
            new ColorUIResource(172, 172, 172),
            new ColorUIResource(212, 208, 200));

    // ikonok elérési útjai
    public static final String ICON_RESTART = "images/restart.png";
    public static final String ICON_TIME_1 = "images/time_1.png";
    public static final String ICON_TIME_2 = "images/time_2.png";
    public static final String ICON_SETTINGS = "images/settings.png";
    public static final String ICON_MAP = "images/map.png";
    public static final String ICON_DIAGRAM = "images/diagram.png";
    public static final String ICON_GRAPH = "images/graph.png";
    public static final String ICON_INFORMATIONS = "images/informations.png";
    public static final String ICON_GRASS_1 = "images/grass_1.png";
    public static final String ICON_GRASS_2 = "images/grass_2.png";
    public static final String ICON_GRASSHOPPER_1 = "images/grasshopper_1.png";
    public static final String ICON_GRASSHOPPER_2 = "images/grasshopper_2.png";
    public static final String ICON_LIZARD_1 = "images/lizard_1.png";
    public static final String ICON_LIZARD_2 = "images/lizard_2.png";
    public static final String ICON_USE = "images/use.png";
    public static final String ICON_ABOUT = "images/about.png";
    public static final String ICON_UP = "images/up.png";
    public static final String ICON_DOWN = "images/down.png";
    public static final String ICON_SEA_BLUE_1 = "images/seablue_1.png";
    public static final String ICON_SEA_BLUE_2 = "images/seablue_2.png";
    public static final String ICON_LIGHT_BLUE_1 = "images/lightblue_1.png";
    public static final String ICON_LIGHT_BLUE_2 = "images/lightblue_2.png";
    public static final String ICON_VIOLET_COLORED_1 = "images/violetcolored_1.png";
    public static final String ICON_VIOLET_COLORED_2 = "images/violetcolored_2.png";
    public static final String ICON_GRAY_1 = "images/gray_1.png";
    public static final String ICON_GRAY_2 = "images/gray_2.png";
    public static final String ICON_DESERT_1 = "images/desert_1.png";
    public static final String ICON_DESERT_2 = "images/desert_2.png";

    //----------------------------------------------------------------------
    // HATÁRÉRTÉKEK

    /** A sziget szélessége */
    public static final int ISLAND_WIDTH_LOWER_BOUND = 10;
    public static final int ISLAND_WIDTH_UPPER_BOUND = 52;

    /** A sziget magassága */
    public static final int ISLAND_HEIGHT_LOWER_BOUND = 1;
    public static final int ISLAND_HEIGHT_UPPER_BOUND = 32;

    /** Az időegység */
    public static final double TIME_UNIT_LOWER_BOUND = 0.25;
    public static final double TIME_UNIT_UPPER_BOUND = 5.0;

    /** Egy területen lévő faj maximális száma */
    public static final int CREATURES_ON_TERRITORY_LOWER_BOUND = 1;
    public static final int CREATURES_ON_TERRITORY_UPPER_BOUND = 10;

    /** Egy élőlény maximális életkora */
    public static final int MAX_AGE_LOWER_BOUND = 1;
    public static final int MAX_AGE_UPPER_BOUND = 100;

    /** Egy élőlény szaporodásának kezdete */
    public static final int BEGIN_OF_MULTIPLICATION_LOWER_BOUND = 1;
    public static final int BEGIN_OF_MULTIPLICATION_UPPER_BOUND = 99;

    /** Egy élőlény szaporodásának vége */
    public static final int END_OF_MULTIPLICATION_LOWER_BOUND = 1;
    public static final int END_OF_MULTIPLICATION_UPPER_BOUND = 99;

    /** Egy élőlény utódainak száma */
    public static final int NUMBER_OF_DESCENDANT_LOWER_BOUND = 0;
    public static final int NUMBER_OF_DESCENDANT_UPPER_BOUND = 10;

    /** Éhhalál küszöb */
    public static final int MAX_HUNGER_LOWER_BOUND = 1;
    public static final int MAX_HUNGER_UPPER_BOUND = 100;

    /** Fű színe */
    public static final int GRASS_COLOR_LOWER_BOUND = 100;
    public static final int GRASS_COLOR_UPPER_BOUND = 150;

    /** Szöcske színe */
    public static final int GRASSHOPPER_COLOR_LOWER_BOUND = 128;
    public static final int GRASSHOPPER_COLOR_UPPER_BOUND = 255;

    /** Gyík színe */
    public static final int LIZARD_COLOR_LOWER_BOUND = 128;
    public static final int LIZARD_COLOR_UPPER_BOUND = 255;

    /** y tengely skálázása */
    public static final double SCALE_Y_LOWER_BOUND = 0.025;
    public static final double SCALE_Y_UPPER_BOUND = 3.2;


}












