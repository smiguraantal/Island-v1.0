package org.example;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.ModifiedDefaultMetalTheme;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/**
 * Az alkalmazást indító osztály
 */
public class Island implements Constants {

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Island() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

//----------------------------------------------------------------------

    /**
     * Main, beállítja a kinézetet
     */
    public static void main(String[] args) {

        ModifiedDefaultMetalTheme modifiedDefaultMetalTheme =
                new ModifiedDefaultMetalTheme(DataModule.getDataModule().getColorTheme(),
                        METAL_GRAY);

        MetalLookAndFeel modifiedMetalLookAndFeel = new MetalLookAndFeel();
        modifiedMetalLookAndFeel.setCurrentTheme(modifiedDefaultMetalTheme);
        UIManager.put("InternalFrame.closeButtonToolTip", "Bezárás");
        try {
            UIManager.setLookAndFeel(modifiedMetalLookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Island();
    }
}













