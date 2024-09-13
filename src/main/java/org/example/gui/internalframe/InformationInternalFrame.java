package org.example.gui.internalframe;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

/** Az adatlaphoz használt belső ablak */
public class InformationInternalFrame extends JInternalFrame implements Constants {

    /** Adatmodul */
    DataModule dataModule = DataModule.getDataModule();

    /** Főablak */
    MainFrame mainFrame;

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    Border border1;
    TitledBorder titledBorder1;
    Border border2;
    Border border3;
    TitledBorder titledBorder2;
    Border border4;
    Border border5;
    TitledBorder titledBorder3;
    Border border6;
    JLabel jLabel1 = new JLabel();
    JLabel lbTime = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel lbGrass = new JLabel();
    JLabel lbGrasshopper = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel lbWidth = new JLabel();
    JLabel lbHeight = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel lbLizard = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel lbTerritories = new JLabel();
    JLabel jLabel15 = new JLabel();
    JLabel lbTimeUnit = new JLabel();
    GridBagLayout gridBagLayout4 = new GridBagLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public InformationInternalFrame(MainFrame mainFrame, String title) {
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
        border1 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder1 = new TitledBorder(border1, " Idő ");
        border2 = BorderFactory.createCompoundBorder(titledBorder1, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border3 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder2 = new TitledBorder(border3, " Élőlények ");
        border4 = BorderFactory.createCompoundBorder(titledBorder2, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border5 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder3 = new TitledBorder(border5, " Sziget ");
        border6 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Sziget "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(gridBagLayout4);
        jPanel2.setLayout(gridBagLayout1);
        jPanel3.setLayout(gridBagLayout2);
        jPanel4.setLayout(gridBagLayout3);
        jPanel2.setBorder(border2);
        jPanel3.setBorder(border4);
        jPanel4.setBorder(border6);
        jLabel1.setText("Eddig eltelt idő:");
        lbTime.setText("jLabel2");
        jLabel3.setText("Fű:");
        jLabel4.setText("Szöcske:");
        lbGrass.setPreferredSize(new Dimension(60, 16));
        lbGrass.setHorizontalAlignment(SwingConstants.RIGHT);
        lbGrass.setText("jLabel5");
        lbGrasshopper.setHorizontalAlignment(SwingConstants.RIGHT);
        lbGrasshopper.setText("jLabel6");
        jLabel7.setText("Magasság:");
        jLabel8.setText("Szélesség:");
        lbWidth.setPreferredSize(new Dimension(60, 16));
        lbWidth.setHorizontalAlignment(SwingConstants.RIGHT);
        lbWidth.setText("jLabel9");
        lbHeight.setHorizontalAlignment(SwingConstants.RIGHT);
        lbHeight.setText("jLabel10");
        jLabel11.setText("Gyík:");
        lbLizard.setHorizontalAlignment(SwingConstants.RIGHT);
        lbLizard.setText("jLabel12");
        jLabel13.setText("Terület:");
        lbTerritories.setText("jLabel14");
        jLabel15.setRequestFocusEnabled(true);
        jLabel15.setText("Időegység:");
        lbTimeUnit.setText("jLabel16");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new InformationInternalFrame_this_internalFrameAdapter(this));
        jPanel1.add(jPanel2, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        jPanel2.add(jLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(jLabel15, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(lbTimeUnit, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(lbTime, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(jPanel3, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        jPanel3.add(jLabel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(jLabel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(lbGrass, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(lbGrasshopper, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(jLabel11, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(lbLizard, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(jPanel4, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5, 5, 0, 0), 0, 0));
        jPanel4.add(jLabel7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(jLabel8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(lbWidth, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(lbHeight, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(jLabel13, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(lbTerritories, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        this.getContentPane().add(jPanel1, BorderLayout.SOUTH);

        setLabels();

        pack();
    }

    //----------------------------------------------------------------------

    /** Frissíti a mezőket az adatmodulban tárolt értékek alapján */
    public void progressOfTime() {
        setLabels();
    }

    //----------------------------------------------------------------------

    /** Mezők frissítése */
    public void setLabels() {
        lbWidth.setText("" + dataModule.getIslandWidth());
        lbHeight.setText("" + dataModule.getIslandHeight());
        lbTerritories.setText("" + dataModule.getIslandWidth() * dataModule.getIslandHeight());

        lbGrass.setText("" + dataModule.getNumberOfGrasses());
        lbGrasshopper.setText("" + dataModule.getNumberOfGrasshoppers());
        lbLizard.setText("" + dataModule.getNumberOfLizards());

        lbTimeUnit.setText("" + dataModule.getTimeUnit());
        lbTime.setText("" + dataModule.getTime());
    }

    //----------------------------------------------------------------------

    /** Ablakbezárás */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}

//############################################################################

class InformationInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    InformationInternalFrame adaptee;

    InformationInternalFrame_this_internalFrameAdapter(InformationInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}










