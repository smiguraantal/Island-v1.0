package org.example.gui;

import org.example.entity.Constants;

import javax.swing.plaf.ColorUIResource;
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

/** Egy színsémához tartozó három színt tartalamzó osztály */
public class ColorTheme implements Serializable, Constants {

    /** A három szín */
    public ColorUIResource color_1;
    public ColorUIResource color_2;
    public ColorUIResource color_3;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public ColorTheme(ColorUIResource color_1,
                      ColorUIResource color_2,
                      ColorUIResource color_3) {
        this.color_1 = color_1;
        this.color_2 = color_2;
        this.color_3 = color_3;
    }

    //----------------------------------------------------------------------

    /** A színséma akkor ugyanaz, ha mindegyik szín megegyezik */
    public boolean equals(Object object) {
        return
                color_1.equals(((ColorTheme) object).color_1) &&
                        color_2.equals(((ColorTheme) object).color_2) &&
                        color_3.equals(((ColorTheme) object).color_3);
    }
}









