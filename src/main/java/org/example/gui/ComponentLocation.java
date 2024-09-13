package org.example.gui;

import java.awt.Component;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Az internalframe belső ablakait elhelyező osztály */
public class ComponentLocation {

    /** Konstruktor letiltva */
    private ComponentLocation() {
    }

    //----------------------------------------------------------------------

    /** A paraméterben kapott ablakot az őse közepére helyezi. */
    public static void center(Component component, Component parent) {
        component.setLocation((parent.getWidth() - component.getWidth()) / 2,
                (parent.getHeight() - component.getHeight()) / 2);
    }

}






