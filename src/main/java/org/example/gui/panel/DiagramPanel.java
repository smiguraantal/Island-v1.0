package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Divider;
import org.example.gui.IconLabel;
import org.example.gui.internalframe.DiagramInternalFrame;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import java.awt.Dimension;
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

/**
 * A diagramot és a skálázáshoz szükséges nyilakat tartalamzó panel
 */
public class DiagramPanel extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    protected DataModule dataModule = DataModule.getDataModule();

    /**
     * Diagram belső ablak
     */
    private DiagramInternalFrame diagramInternalFrame;

    /**
     * A diagram
     */
    gui.panel.Diagram diagram = new gui.panel.Diagram(dataModule.getNumberOfGrasses(),
            dataModule.getNumberOfGrasshoppers(),
            dataModule.getNumberOfLizards());

    /**
     * Felfelé nyíl
     */
    IconLabel lbUp =
            new IconLabel(new ImageIcon(ICON_UP),
                    null);

    /**
     * Lefelé nyíl
     */
    IconLabel lbDown =
            new IconLabel(new ImageIcon(ICON_DOWN),
                    null);

    JScrollPane jScrollPane1 = new JScrollPane();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel3 = new JPanel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JPanel jPanel1 = new JPanel();
    Border border1;
    Border border2;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public DiagramPanel(DiagramInternalFrame diagramInternalFrame) {
        this.diagramInternalFrame = diagramInternalFrame;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megharátozza a panel méretét, amely a diagram és a függőleges görgetők
     * méretéből számolódik
     */
    void jbInit() throws Exception {
        lbUp.setPreferredSize(new Dimension(20, 20));
        lbDown.setPreferredSize(new Dimension(20, 20));

        int scrollWidth = new JScrollBar(JScrollBar.VERTICAL).getPreferredSize().width;
        int diagramWidth = CHART_BASE_X_NULL + 4 * DIAGRAM_GAP + 3 * DIAGRAM_COLUMN_WIDTH;

        border1 = BorderFactory.createEtchedBorder();
        border2 = BorderFactory.createEtchedBorder();
        jScrollPane1.setPreferredSize(new Dimension(diagramWidth + scrollWidth, 450));
        this.setLayout(gridBagLayout1);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPanel3.setLayout(gridBagLayout2);
        lbUp.addMouseListener(new DiagramPanel_lbUp_mouseAdapter(this));
        lbDown.addMouseListener(new DiagramPanel_lbDown_mouseAdapter(this));
        this.add(jScrollPane1, new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel3, new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(lbUp, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 0, 5), 0, 0));
        jPanel3.add(lbDown, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        this.add(jPanel1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jScrollPane1.getViewport().add(diagram, null);
        jScrollPane1.getVerticalScrollBar().setValue(Integer.MAX_VALUE);
    }

    //----------------------------------------------------------------------

    /**
     * Frissíti a diagramot
     */
    public void refreshDiagram() {
        diagram.init();
        diagram.repaint();
        jScrollPane1.getVerticalScrollBar().setValue(Integer.MAX_VALUE);
    }

    //----------------------------------------------------------------------

    /**
     * Továbbküldi az időciklus lejártáról kapott üzenetet
     */
    public void progressOfTime() {
        diagram.progressOfTime();
    }

    //----------------------------------------------------------------------

    /**
     * A fel nyíl-ra kattintás
     */
    void lbUp_mousePressed(MouseEvent e) {
        double moreDividing =
                new Divider(dataModule.getScaleY()).moreDividing();
        if (moreDividing > dataModule.getScaleY()) {
            dataModule.setScaleY(moreDividing);
            diagramInternalFrame.refreshScales();
        }
    }

    //----------------------------------------------------------------------

    /**
     * A le nyíl-ra kattintás
     */
    void lbDown_mousePressed(MouseEvent e) {
        double lessDividing =
                new Divider(dataModule.getScaleY()).lessDividing();
        if (lessDividing < dataModule.getScaleY()) {
            dataModule.setScaleY(lessDividing);
            diagramInternalFrame.refreshScales();
        }
    }
}

//############################################################################

class DiagramPanel_lbDown_mouseAdapter extends java.awt.event.MouseAdapter {
    DiagramPanel adaptee;

    DiagramPanel_lbDown_mouseAdapter(DiagramPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbDown_mousePressed(e);
    }
}

class DiagramPanel_lbUp_mouseAdapter extends java.awt.event.MouseAdapter {
    DiagramPanel adaptee;

    DiagramPanel_lbUp_mouseAdapter(DiagramPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbUp_mousePressed(e);
    }
}














