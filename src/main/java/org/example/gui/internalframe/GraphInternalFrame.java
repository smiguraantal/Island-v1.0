package org.example.gui.internalframe;

import org.example.gui.MainFrame;
import org.example.gui.panel.GraphPanel;

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

/** A grafikont tartó belső ablak */
public class GraphInternalFrame extends JInternalFrame {

    /** Főablak */
    MainFrame mainFrame;

    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    GraphPanel graphPanel = new GraphPanel(this);

    //----------------------------------------------------------------------

    /** Konstruktor */
    public GraphInternalFrame(MainFrame mainFrame, String title) {
        super(title, false, true, false, false);
        this.mainFrame = mainFrame;
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
        this.addInternalFrameListener(new GraphInternalFrame_this_internalFrameAdapter(this));
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(graphPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        pack();
    }

    //----------------------------------------------------------------------

    /** Továbbküldi az időciklus leteltéről kapott üzenetet */
    public void progressOfTime() {
        graphPanel.progressOfTime();
    }

    //----------------------------------------------------------------------

    /** Megkéri a főablakot, hogy frissítse a skálázásokat */
    public void refreshScales() {
        mainFrame.refreshScales();
    }

    //----------------------------------------------------------------------

    /** Frissíti a grafikont */
    public void refreshGraph() {
        graphPanel.refreshGraph();
    }

    //----------------------------------------------------------------------

    /** Ablakbecsukás */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}

//############################################################################

class GraphInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    GraphInternalFrame adaptee;

    GraphInternalFrame_this_internalFrameAdapter(GraphInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}











