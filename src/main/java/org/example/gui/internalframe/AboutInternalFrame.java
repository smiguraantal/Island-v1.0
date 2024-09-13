package org.example.gui.internalframe;

import com.borland.jbcl.layout.VerticalFlowLayout;
import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import org.example.gui.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

/** Névjegy belső ablak */
public class AboutInternalFrame extends JInternalFrame {

    /** A megjelenő szöveg betűtípusa */
    private Font font = new Font("Times New Roman", Font.PLAIN, 15);

    /** Főablak */
    private MainFrame mainFrame;

    /** A kiírandó információk */
    private String gameName = "Sziget";
    private String version = "Verziószám: 1.0";
    private String copyright = "Copyright © Smigura Antal";
    private String date = "Budapest, 2004";

    Border border1;
    Border border2;
    Border border3;
    Border border4;
    Border border5;
    Border border6;
    Border border7;
    Border border8;
    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    JPanel jPanel8 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JPanel jPanel10 = new JPanel();
    JLabel jLabel3 = new JLabel();
    JPanel jPanel11 = new JPanel();
    JLabel jLabel4 = new JLabel();
    XYLayout xYLayout1 = new XYLayout();
    JPanel jPanel12 = new JPanel();
    Border border9;
    JPanel jPanel13 = new JPanel();
    Border border10;
    JPanel jPanel14 = new JPanel();
    Border border11;
    JPanel jPanel15 = new JPanel();
    Border border12;
    JPanel jPanel16 = new JPanel();
    Border border13;
    JPanel jPanel17 = new JPanel();
    Border border14;
    XYLayout xYLayout2 = new XYLayout();
    JSeparator jSeparator1 = new JSeparator();
    Border border15;
    JSeparator jSeparator2 = new JSeparator();
    Border border16;
    JSeparator jSeparator3 = new JSeparator();
    Border border17;
    JPanel jPanel18 = new JPanel();
    Border border18;
    JPanel jPanel19 = new JPanel();
    Border border19;
    JPanel jPanel20 = new JPanel();
    Border border20;
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JButton btClose = new JButton();
    JPanel jPanel21 = new JPanel();
    JLabel jLabel5 = new JLabel();
    Border border21;
    Border border22;
    Border border23;
    Border border24;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public AboutInternalFrame(MainFrame mainFrame, String title) {
        super(title, false, true, false, false);
        this.mainFrame = mainFrame;
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        border21 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(5, 15, 5, 15));
        border22 = BorderFactory.createEmptyBorder(5, 0, 5, 0);
        border23 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        border24 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(5, 15, 5, 15));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        this.addInternalFrameListener(new AboutInternalFrame_this_internalFrameAdapter(this));
        border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border2 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border3 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border4 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border5 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border6 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border7 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border8 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border9 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border10 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border11 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border12 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border13 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border14 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border15 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border16 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border17 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border18 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border19 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        border20 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        jPanel1.setLayout(gridBagLayout1);
        jPanel2.setLayout(borderLayout1);
        jPanel4.setLayout(borderLayout2);
        jPanel7.setLayout(verticalFlowLayout1);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 20));
        jLabel1.setForeground(Color.darkGray);
        jLabel1.setBorder(border22);
        jLabel1.setDoubleBuffered(false);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel4.setBorder(border23);
        jLabel5.setFont(font);

        jLabel1.setText(gameName);
        jLabel5.setText(version);
        jLabel3.setText(copyright);
        jLabel4.setText(date);

        jPanel5.setLayout(xYLayout1);
        jPanel5.setPreferredSize(new Dimension(200, 25));
        jPanel12.setBorder(border9);
        jPanel12.setPreferredSize(new Dimension(3, 25));
        jPanel13.setBorder(border10);
        jPanel13.setPreferredSize(new Dimension(3, 22));
        jPanel14.setBorder(border11);
        jPanel14.setPreferredSize(new Dimension(3, 19));
        jPanel15.setBorder(border12);
        jPanel15.setPreferredSize(new Dimension(200, 3));
        jPanel16.setBorder(border13);
        jPanel16.setPreferredSize(new Dimension(150, 3));
        jPanel17.setBorder(border14);
        jPanel17.setPreferredSize(new Dimension(100, 3));
        jPanel6.setLayout(xYLayout2);
        jPanel6.setPreferredSize(new Dimension(200, 25));
        jSeparator1.setBorder(border15);
        jSeparator1.setOpaque(false);
        jSeparator1.setPreferredSize(new Dimension(200, 3));
        jSeparator2.setBorder(border16);
        jSeparator2.setPreferredSize(new Dimension(150, 3));
        jSeparator3.setBorder(border17);
        jSeparator3.setPreferredSize(new Dimension(100, 3));
        jPanel18.setBorder(border18);
        jPanel18.setPreferredSize(new Dimension(3, 25));
        jPanel19.setBorder(border19);
        jPanel19.setPreferredSize(new Dimension(3, 22));
        jPanel20.setBorder(border20);
        jPanel20.setPreferredSize(new Dimension(3, 19));
        jPanel3.setLayout(gridBagLayout2);
        btClose.setAlignmentY((float) 0.5);
        btClose.setText("Bezárás");
        btClose.addActionListener(new About_btClose_actionAdapter(this));
        jPanel21.setForeground(Color.darkGray);
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(jPanel2, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 0, 5), 0, 0));
        jPanel2.add(jPanel3, BorderLayout.SOUTH);
        jPanel3.add(btClose, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(15, 0, 5, 0), 0, 0));
        jPanel2.add(jPanel4, BorderLayout.CENTER);
        jPanel4.add(jPanel5, BorderLayout.NORTH);

        jPanel5.add(jPanel15, new XYConstraints(0, 3, -1, -1));
        jPanel5.add(jPanel16, new XYConstraints(0, 8, -1, -1));
        jPanel5.add(jPanel17, new XYConstraints(0, 13, -1, -1));
        jPanel5.add(jPanel12, new XYConstraints(3, 0, -1, -1));
        jPanel5.add(jPanel13, new XYConstraints(8, 0, -1, -1));
        jPanel5.add(jPanel14, new XYConstraints(13, 0, -1, -1));

        jPanel4.add(jPanel6, BorderLayout.SOUTH);
        jPanel6.add(jSeparator1, new XYConstraints(0, 19, -1, -1));
        jPanel6.add(jSeparator2, new XYConstraints(50, 14, -1, -1));
        jPanel6.add(jSeparator3, new XYConstraints(100, 9, -1, -1));
        jPanel6.add(jPanel18, new XYConstraints(194, 0, -1, -1));
        jPanel6.add(jPanel19, new XYConstraints(189, 3, -1, -1));
        jPanel6.add(jPanel20, new XYConstraints(184, 6, -1, -1));
        jPanel4.add(jPanel7, BorderLayout.CENTER);
        jPanel7.add(jPanel8, null);
        jPanel8.add(jLabel1, null);
        jPanel7.add(jPanel21, null);
        jPanel21.add(jLabel5, null);
        jPanel7.add(jPanel10, null);
        jPanel10.add(jLabel3, null);
        jPanel7.add(jPanel11, null);
        jPanel11.add(jLabel4, null);
    }

    //----------------------------------------------------------------------

    /** Megjeleníti a dialógust. */
    public void showInternalFrame() {
        pack();
        btClose.requestFocus();
        setVisible(true);
    }

    //----------------------------------------------------------------------

    /** Elrejti a dialógust. */
    void btClose_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Ablak bezárása */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}

//############################################################################

class About_btClose_actionAdapter implements java.awt.event.ActionListener {
    AboutInternalFrame adaptee;

    About_btClose_actionAdapter(AboutInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btClose_actionPerformed(e);
    }
}

class AboutInternalFrame_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
    AboutInternalFrame adaptee;

    AboutInternalFrame_this_internalFrameAdapter(AboutInternalFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        adaptee.this_internalFrameClosing(e);
    }
}










