package org.example.gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Egy ikont tartó gomb */
public class IconLabel extends JLabel {

    /** Az gomb képei */
    ImageIcon imageIcon_1;
    ImageIcon imageIcon_2;

    Border iconBorder;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public IconLabel(ImageIcon imageIcon_1, ImageIcon imageIcon_2) {
        this.imageIcon_1 = imageIcon_1;
        this.imageIcon_2 = imageIcon_2;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        iconBorder = BorderFactory.createEtchedBorder();
        this.setPreferredSize(new Dimension(28, 28));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new IconLabel_this_mouseAdapter(this));
        this.setIcon(imageIcon_1);
    }

    //----------------------------------------------------------------------

    /** Lecseréli az egyik ikont a másikra */
    public void changeIcon() {
        setIcon(getIcon().equals(imageIcon_1) ? imageIcon_2 : imageIcon_1);
    }

    //----------------------------------------------------------------------

    /** Az elsőként megadott ikont állítja be */
    public void resetIcon() {
        setIcon(imageIcon_1);
    }

    //----------------------------------------------------------------------

    /** Érzékenység az egérmozgásra */
    void this_mouseEntered(MouseEvent e) {
        setBorder(iconBorder);
    }

    //----------------------------------------------------------------------

    /** Érzékenység az egérmozgásra */
    void this_mouseExited(MouseEvent e) {
        setBorder(null);
    }

    //----------------------------------------------------------------------

    public ImageIcon getImageIcon_1() {
        return imageIcon_1;
    }

    public ImageIcon getImageIcon_2() {
        return imageIcon_2;
    }


}

class IconLabel_this_mouseAdapter extends java.awt.event.MouseAdapter {
    IconLabel adaptee;

    IconLabel_this_mouseAdapter(IconLabel adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseEntered(MouseEvent e) {
        adaptee.this_mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        adaptee.this_mouseExited(e);
    }
}







