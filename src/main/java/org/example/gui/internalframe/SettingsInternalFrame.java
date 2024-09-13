package org.example.gui.internalframe;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.panel.SettingsPanel;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A szigetet tartó belső ablak */
public class SettingsInternalFrame extends JInternalFrame implements Constants {

    /** Adatmodul */
    DataModule dataModule = DataModule.getDataModule();

    /** A sziget panelja */
    SettingsPanel settingsPanel = new SettingsPanel();

    /** Főablak */
    MainFrame mainFrame;

    JPanel jPanel1 = new JPanel();
    JSeparator jSeparator1 = new JSeparator();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton btStart = new JButton();
    JButton btCancel = new JButton();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public SettingsInternalFrame(MainFrame mainFrame, String title) {
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
        jPanel1.setLayout(flowLayout1);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new SettingsInternalFrame_this_internalFrameAdapter(this));
        btStart.setText("Indítás");
        btStart.addActionListener(new SettingsInternalFrame_btStart_actionAdapter(this));
        btCancel.setText("Mégse");
        btCancel.addActionListener(new SettingsInternalFrame_btCancel_actionAdapter(this));
        this.getContentPane().add(settingsPanel, BorderLayout.NORTH);
        this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btStart, null);
        jPanel1.add(btCancel, null);
        this.getContentPane().add(jSeparator1, BorderLayout.CENTER);
        pack();
    }

    //----------------------------------------------------------------------

    /** Menti a változtatásokat */
    public void saveSettings() {
        settingsPanel.saveSettings();
    }

    //----------------------------------------------------------------------

    /** Ablak bezárása */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Mégse gomb megnyomása */
    void btCancel_actionPerformed(ActionEvent e) {
        settingsPanel.setComboBoxes();
        setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Indítás gomb megnyomása */
    void btStart_actionPerformed(ActionEvent e) {
        settingsPanel.saveSettings();
        mainFrame.newGame();
        setVisible(false);
    }

}

//############################################################################

class SettingsInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    SettingsInternalFrame adaptee;

    SettingsInternalFrame_this_internalFrameAdapter(SettingsInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}

class SettingsInternalFrame_btStart_actionAdapter implements java.awt.event.ActionListener {
    SettingsInternalFrame adaptee;

    SettingsInternalFrame_btStart_actionAdapter(SettingsInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btStart_actionPerformed(e);
    }
}

class SettingsInternalFrame_btCancel_actionAdapter implements java.awt.event.ActionListener {
    SettingsInternalFrame adaptee;

    SettingsInternalFrame_btCancel_actionAdapter(SettingsInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}





