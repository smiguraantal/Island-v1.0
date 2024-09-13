package org.example.gui.internalframe;

import org.example.gui.MainFrame;
import org.example.gui.panel.DiagramPanel;

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

/** A diagram megjelenítéséhez használt belső ablak */
public class DiagramInternalFrame extends JInternalFrame {

    /** Főablak */
    MainFrame mainFrame;

    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    DiagramPanel diagramPanel = new DiagramPanel(this);

    /** Konstruktor */
    public DiagramInternalFrame(MainFrame mainFrame, String title) {
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
        this.addInternalFrameListener(new DiagramInternalFrame_this_internalFrameAdapter(this));
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(diagramPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        pack();
    }

    //----------------------------------------------------------------------

    /** Továbbküldi az időciklus leteltéről kapott üzenetet */
    public void progressOfTime() {
        diagramPanel.progressOfTime();
    }

    //----------------------------------------------------------------------

    /** Megkéri a főablakot, hogy frissítse a skálázásokat */
    public void refreshScales() {
        mainFrame.refreshScales();
    }

    //----------------------------------------------------------------------

    /** Frissíti a diagramot */
    public void refreshDiagram() {
        diagramPanel.refreshDiagram();
    }

    //----------------------------------------------------------------------

    /** Ablakbecsukás */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}

//############################################################################

class DiagramInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    DiagramInternalFrame adaptee;

    DiagramInternalFrame_this_internalFrameAdapter(DiagramInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}









