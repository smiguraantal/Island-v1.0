package org.example.gui.internalframe;

import org.example.gui.panel.IslandPanel;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A szigetet tartamazó belső ablak */
public class IslandInternalFrame extends JInternalFrame {

    /** A szigetet tartó panel */
    IslandPanel islandPanel = new IslandPanel();

    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public IslandInternalFrame(String title) {
        super(title, false, true, false, false);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        jPanel1.setLayout(gridBagLayout1);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new IslandInternalFrame_this_internalFrameAdapter(this));
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(islandPanel,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        pack();
    }

    //----------------------------------------------------------------------

    /** Továbbküldi az értesítést */
    public void progressOfTime() {
        islandPanel.progressOfTime();
    }

    //----------------------------------------------------------------------

    /** Ablakbezárás */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}

//############################################################################

class IslandInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    IslandInternalFrame adaptee;

    IslandInternalFrame_this_internalFrameAdapter(IslandInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}