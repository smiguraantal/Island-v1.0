package org.example.gui;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Az alapértelmezett Metal-os téma módosított osztály */
public class ModifiedDefaultMetalTheme extends DefaultMetalTheme {

    /** Elsődleges színek */
    private static ColorUIResource primary1;
    private static ColorUIResource primary2;
    private static ColorUIResource primary3;

    /** Másodlagos színek */
    private static ColorUIResource secondary1;
    private static ColorUIResource secondary2;
    private static ColorUIResource secondary3;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public ModifiedDefaultMetalTheme(ColorTheme primary, ColorTheme secondary) {
        setPrimariyColors(primary);
        setSecondaryColors(secondary);
    }

    //----------------------------------------------------------------------

    /** Beállítja az elsődleges színeket */
    protected static void setPrimariyColors(ColorTheme colorTheme) {
        primary1 = colorTheme.color_1;
        primary2 = colorTheme.color_2;
        primary3 = colorTheme.color_3;
    }

    //----------------------------------------------------------------------

    /** Beállítja a másodlagos színeket */
    protected static void setSecondaryColors(ColorTheme colorTheme) {
        secondary1 = colorTheme.color_1;
        secondary2 = colorTheme.color_2;
        secondary3 = colorTheme.color_3;
    }

    //----------------------------------------------------------------------

    protected ColorUIResource getPrimary1() {
        return primary1;
    }

    protected ColorUIResource getPrimary2() {
        return primary2;
    }

    protected ColorUIResource getPrimary3() {
        return primary3;
    }

    protected ColorUIResource getSecondary1() {
        return secondary1;
    }

    protected ColorUIResource getSecondary2() {
        return secondary2;
    }

    protected ColorUIResource getSecondary3() {
        return secondary3;
    }
}



