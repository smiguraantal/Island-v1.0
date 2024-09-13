package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Divider;
import org.example.gui.IconLabel;
import org.example.gui.internalframe.GraphInternalFrame;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

/** A grafikont és a skálázáshoz szükséges nyilakat tartalamzó panel */
public class GraphPanel extends JPanel implements Constants {

    /** Adatmodul */
    protected DataModule dataModule = DataModule.getDataModule();

    /** Grafikon belső ablak */
    private GraphInternalFrame graphInternalFrame;

    /** Felfelé nyíl */
    IconLabel lbUp =
            new IconLabel(new ImageIcon("images/up.png"),
                    null);

    /** Lefelé nyíl */
    IconLabel lbDown =
            new IconLabel(new ImageIcon("images/down.png"),
                    null);

    /** Grafikon */
    Graph graph = new Graph();

    JScrollPane jScrollPane1 = new JScrollPane();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();

    GridBagLayout gridBagLayout3 = new GridBagLayout();
    Border border1;
    Border border2;
    Border border3;
    Border border4;
    FlowLayout flowLayout1 = new FlowLayout();

    //----------------------------------------------------------------------

    /** Konsturktor */
    public GraphPanel(GraphInternalFrame graphInternalFrame) {
        this.graphInternalFrame = graphInternalFrame;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        border1 = BorderFactory.createEtchedBorder();
        border2 = BorderFactory.createEtchedBorder();
        jScrollPane1.setPreferredSize(new Dimension(600, 450));
        this.setLayout(gridBagLayout1);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPanel1.setLayout(flowLayout1);
        jPanel2.setLayout(gridBagLayout3);
        lbUp.setPreferredSize(new Dimension(20, 20));
        lbDown.setPreferredSize(new Dimension(20, 20));
        lbUp.addMouseListener(new GraphPanel_lbUp_mouseAdapter(this));
        lbDown.addMouseListener(new GraphPanel_lbDown_mouseAdapter(this));
        this.add(jScrollPane1, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jScrollPane1.getViewport().add(graph, null);
        this.add(jPanel1, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(lbDown, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        jPanel2.add(lbUp, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 0, 5), 0, 0));
        jScrollPane1.getVerticalScrollBar().setValue(Integer.MAX_VALUE);
    }

    //----------------------------------------------------------------------

    /** Frissíti a grafikont */
    public void refreshGraph() {
        graph.init();
        graph.repaint();
        jScrollPane1.getVerticalScrollBar().setValue(Integer.MAX_VALUE);
    }

    //----------------------------------------------------------------------

    /** Továbbküldi az időciklus lejártáról kapott üzenetet */
    public void progressOfTime() {
        graph.progressOfTime();
    }

    //----------------------------------------------------------------------

    /** A fel nyíl-ra kattintás */
    void lbUp_mousePressed(MouseEvent e) {
        double moreDividing =
                new Divider(dataModule.getScaleY()).moreDividing();
        if (moreDividing > dataModule.getScaleY()) {
            dataModule.setScaleY(moreDividing);
            graphInternalFrame.refreshScales();
        }
    }

    //----------------------------------------------------------------------

    /** A le nyíl-ra kattintás */
    void lbDown_mousePressed(MouseEvent e) {
        double lessDividing =
                new Divider(dataModule.getScaleY()).lessDividing();
        if (lessDividing < dataModule.getScaleY()) {
            dataModule.setScaleY(lessDividing);
            graphInternalFrame.refreshScales();
        }
    }
}

//############################################################################

class GraphPanel_lbUp_mouseAdapter extends java.awt.event.MouseAdapter {
    GraphPanel adaptee;

    GraphPanel_lbUp_mouseAdapter(GraphPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbUp_mousePressed(e);
    }
}

class GraphPanel_lbDown_mouseAdapter extends java.awt.event.MouseAdapter {
    GraphPanel adaptee;

    GraphPanel_lbDown_mouseAdapter(GraphPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbDown_mousePressed(e);
    }
}







