package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.util.Vector;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A beállításokhoz tartozó komponenseket tartalmazó panel */
public class SettingsPanel extends JPanel implements Constants {

    /** Adatmodul */
    DataModule dataModule = DataModule.getDataModule();

    /** Választó mezők */
    JComboBox cbTime =
            new JComboBox(timeUnits());
    JComboBox cbWidth =
            new JComboBox(numbers(ISLAND_WIDTH_LOWER_BOUND,
                    ISLAND_WIDTH_UPPER_BOUND));
    JComboBox cbHeight =
            new JComboBox(numbers(ISLAND_HEIGHT_LOWER_BOUND,
                    ISLAND_HEIGHT_UPPER_BOUND));

    JComboBox cbGrassesOnTerritory =
            new JComboBox(numbers(CREATURES_ON_TERRITORY_LOWER_BOUND,
                    CREATURES_ON_TERRITORY_UPPER_BOUND));
    JComboBox cbGrasshoppersOnTerritory =
            new JComboBox(numbers(CREATURES_ON_TERRITORY_LOWER_BOUND,
                    CREATURES_ON_TERRITORY_UPPER_BOUND));
    JComboBox cbLizardsOnTerritory =
            new JComboBox(numbers(CREATURES_ON_TERRITORY_LOWER_BOUND,
                    CREATURES_ON_TERRITORY_UPPER_BOUND));

    JComboBox cbGrassSettling = new JComboBox(numbers(0, 100));
    JComboBox cbGrasshopperSettling = new JComboBox(numbers(0, 100));
    JComboBox cbLizardSettling = new JComboBox(numbers(0, 100));

    // fű
    JComboBox cbGrassMaxAge =
            new JComboBox(numbers(MAX_AGE_LOWER_BOUND,
                    MAX_AGE_UPPER_BOUND));
    JComboBox cbGrassBeginOfMultiplication =
            new JComboBox(numbers(BEGIN_OF_MULTIPLICATION_LOWER_BOUND,
                    BEGIN_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbGrassEndOfMultiplication =
            new JComboBox(numbers(END_OF_MULTIPLICATION_LOWER_BOUND,
                    END_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbGrassNumberOfDescendant =
            new JComboBox(numbers(NUMBER_OF_DESCENDANT_LOWER_BOUND,
                    NUMBER_OF_DESCENDANT_UPPER_BOUND));

    // szöcske
    JComboBox cbGrasshopperMaxAge =
            new JComboBox(numbers(MAX_AGE_LOWER_BOUND,
                    MAX_AGE_UPPER_BOUND));
    JComboBox cbGrasshopperBeginOfMultiplication =
            new JComboBox(numbers(BEGIN_OF_MULTIPLICATION_LOWER_BOUND,
                    BEGIN_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbGrasshopperEndOfMultiplication =
            new JComboBox(numbers(END_OF_MULTIPLICATION_LOWER_BOUND,
                    END_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbGrasshopperNumberOfDescendant =
            new JComboBox(numbers(NUMBER_OF_DESCENDANT_LOWER_BOUND,
                    NUMBER_OF_DESCENDANT_UPPER_BOUND));
    JComboBox cbGrasshopperMaxHunger =
            new JComboBox(numbers(MAX_HUNGER_LOWER_BOUND,
                    MAX_HUNGER_UPPER_BOUND));

    // gyík
    JComboBox cbLizardMaxAge =
            new JComboBox(numbers(MAX_AGE_LOWER_BOUND,
                    MAX_AGE_UPPER_BOUND));
    JComboBox cbLizardBeginOfMultiplication =
            new JComboBox(numbers(BEGIN_OF_MULTIPLICATION_LOWER_BOUND,
                    BEGIN_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbLizardEndOfMultiplication =
            new JComboBox(numbers(END_OF_MULTIPLICATION_LOWER_BOUND,
                    END_OF_MULTIPLICATION_UPPER_BOUND));
    JComboBox cbLizardNumberOfDescendant =
            new JComboBox(numbers(NUMBER_OF_DESCENDANT_LOWER_BOUND,
                    NUMBER_OF_DESCENDANT_UPPER_BOUND));
    JComboBox cbLizardMaxHunger =
            new JComboBox(numbers(MAX_HUNGER_LOWER_BOUND,
                    MAX_HUNGER_UPPER_BOUND));

    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();

    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel3 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JLabel jLabel3 = new JLabel();
    TitledBorder titledBorder1;
    JPanel jPanel4 = new JPanel();
    GridBagLayout gridBagLayout4 = new GridBagLayout();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    Border border2;
    TitledBorder titledBorder2;
    JLabel jLabel7 = new JLabel();
    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    Border border3;
    TitledBorder titledBorder3;
    JLabel jLabel13 = new JLabel();
    JPanel jPanel2 = new JPanel();
    GridBagLayout gridBagLayout5 = new GridBagLayout();
    JLabel jLabel14 = new JLabel();
    JLabel jLabel15 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JLabel jLabel17 = new JLabel();
    JLabel jLabel18 = new JLabel();
    Border border4;
    TitledBorder titledBorder4;
    JPanel jPanel5 = new JPanel();
    Border border5;
    TitledBorder titledBorder5;
    GridBagLayout gridBagLayout6 = new GridBagLayout();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel19 = new JLabel();
    JLabel jLabel20 = new JLabel();
    Border border6;
    Border border7;
    Border border8;
    Border border9;
    Border border10;
    JPanel jPanel6 = new JPanel();
    GridBagLayout gridBagLayout7 = new GridBagLayout();
    JLabel jLabel21 = new JLabel();
    JLabel jLabel22 = new JLabel();
    JLabel jLabel23 = new JLabel();
    Border border11;
    TitledBorder titledBorder6;
    Border border12;
    JPanel jPanel7 = new JPanel();
    Border border13;
    TitledBorder titledBorder7;
    JRadioButton rbAutomaticTimeStart = new JRadioButton();
    GridBagLayout gridBagLayout8 = new GridBagLayout();
    JRadioButton rbManualTimeStart = new JRadioButton();
    Border border14;
    JPanel jPanel8 = new JPanel();
    GridBagLayout gridBagLayout9 = new GridBagLayout();
    Border border15;
    TitledBorder titledBorder8;
    Border border16;
    JRadioButton rbRandomFoodSearching = new JRadioButton();
    JRadioButton rbConsciousFoodSearching = new JRadioButton();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public SettingsPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        rbRandomFoodSearching.setSelected(true);
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Sziget ");
        border2 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Fű ");
        border3 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Szöcske ");
        border4 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Gyík ");
        border5 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), " Territórium ");
        border6 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Sziget "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border7 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Territórium "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border8 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Fű "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border9 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Szöcske "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border10 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Gyík "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border11 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder6 = new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Betelepítés ");
        border12 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Betelepítés (%) "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border13 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder7 = new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), " Idő ");
        border14 = BorderFactory.createCompoundBorder(titledBorder7, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border15 = BorderFactory.createLineBorder(Color.white, 1);
        titledBorder8 = new TitledBorder(border15, " Táplálékkeresés");
        border16 = BorderFactory.createCompoundBorder(titledBorder8, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setLayout(gridBagLayout1);
        jLabel1.setText("Időegység (mp):");
        jLabel2.setText("Magasság:");
        jPanel3.setLayout(gridBagLayout3);
        jLabel3.setText("Szélesség:");
        jPanel3.setBorder(border6);
        jPanel4.setLayout(gridBagLayout4);
        jLabel4.setText("Maximális életkor:");
        jLabel5.setText("Szaporodás kezdete:");
        jLabel6.setText("Szaporodás vége:");
        jPanel4.setBorder(border8);
        jLabel7.setText("Utódok száma:");
        jPanel1.setLayout(gridBagLayout2);
        jLabel9.setText("Maximális életkor:");
        jLabel10.setText("Szaporodás kezdete:");
        jLabel11.setText("Szaporodás vége:");
        jLabel12.setText("Utódok száma:");
        jPanel1.setBorder(border9);
        jLabel13.setText("Éhhalál küszöb:");
        jPanel2.setLayout(gridBagLayout5);
        jLabel14.setText("Szaporodás vége:");
        jLabel15.setText("Utódok száma:");
        jLabel16.setText("Szaporodás kezdete:");
        jLabel17.setText("Maximális életkor:");
        jLabel18.setText("Éhhalál küszöb:");
        jPanel2.setBorder(border10);
        jPanel5.setBorder(border7);
        jPanel5.setLayout(gridBagLayout6);
        jLabel8.setText("Füvek maximális száma:");
        jLabel19.setText("Szöcskék maximális száma:");
        jLabel20.setText("Gyíkok maximális száma:");
        cbHeight.setPreferredSize(new Dimension(55, 25));
        cbHeight.setMaximumRowCount(10);
        cbWidth.setPreferredSize(new Dimension(55, 25));
        cbWidth.setMaximumRowCount(10);
        cbTime.setPreferredSize(new Dimension(55, 25));
        cbTime.setMaximumRowCount(10);
        cbGrassMaxAge.setPreferredSize(new Dimension(55, 25));
        cbGrassMaxAge.setMaximumRowCount(10);
        cbGrassBeginOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbGrassBeginOfMultiplication.setMaximumRowCount(10);
        cbGrassEndOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbGrassEndOfMultiplication.setMaximumRowCount(10);
        cbGrassNumberOfDescendant.setPreferredSize(new Dimension(55, 25));
        cbGrassNumberOfDescendant.setMaximumRowCount(10);
        cbGrassesOnTerritory.setPreferredSize(new Dimension(55, 25));
        cbGrassesOnTerritory.setMaximumRowCount(10);
        cbGrasshoppersOnTerritory.setPreferredSize(new Dimension(55, 25));
        cbGrasshoppersOnTerritory.setMaximumRowCount(10);
        cbLizardsOnTerritory.setPreferredSize(new Dimension(55, 25));
        cbLizardsOnTerritory.setMaximumRowCount(10);
        cbGrasshopperMaxAge.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperMaxAge.setMaximumRowCount(10);
        cbGrasshopperBeginOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperBeginOfMultiplication.setMaximumRowCount(10);
        cbGrasshopperEndOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperEndOfMultiplication.setMaximumRowCount(10);
        cbGrasshopperNumberOfDescendant.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperNumberOfDescendant.setMaximumRowCount(10);
        cbGrasshopperMaxHunger.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperMaxHunger.setMaximumRowCount(10);
        cbLizardMaxAge.setPreferredSize(new Dimension(55, 25));
        cbLizardMaxAge.setMaximumRowCount(10);
        cbLizardBeginOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbLizardBeginOfMultiplication.setMaximumRowCount(10);
        cbLizardEndOfMultiplication.setPreferredSize(new Dimension(55, 25));
        cbLizardEndOfMultiplication.setMaximumRowCount(10);
        cbLizardNumberOfDescendant.setPreferredSize(new Dimension(55, 25));
        cbLizardNumberOfDescendant.setMaximumRowCount(10);
        cbLizardMaxHunger.setPreferredSize(new Dimension(55, 25));
        cbLizardMaxHunger.setMaximumRowCount(10);
        jPanel6.setLayout(gridBagLayout7);
        jLabel21.setText("Szöcske:");
        jLabel22.setText("Gyík:");
        jLabel23.setText("Fű:");
        jPanel6.setBorder(border12);
        cbGrassSettling.setPreferredSize(new Dimension(55, 25));
        cbGrassSettling.setMaximumRowCount(10);
        cbGrasshopperSettling.setPreferredSize(new Dimension(55, 25));
        cbGrasshopperSettling.setMaximumRowCount(10);
        cbLizardSettling.setPreferredSize(new Dimension(55, 25));
        cbLizardSettling.setMaximumRowCount(10);
        jPanel7.setBorder(border14);
        jPanel7.setLayout(gridBagLayout8);
        rbAutomaticTimeStart.setText("Automatikusan indul");
        rbManualTimeStart.setText("Én indítom");
        jPanel8.setLayout(gridBagLayout9);
        jPanel8.setBorder(border16);
        rbRandomFoodSearching.setText("Véletlenszerű");
        rbConsciousFoodSearching.setText("Tudatos");
        this.add(jPanel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
        jPanel3.add(jLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(cbTime, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(jLabel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(jLabel3, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel3.add(cbHeight, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel3.add(cbWidth, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        this.add(jPanel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
        jPanel4.add(jLabel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel4.add(jLabel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel4.add(cbGrassMaxAge, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(cbGrassBeginOfMultiplication, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(jLabel5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel4.add(cbGrassEndOfMultiplication, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel4.add(jLabel7, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel4.add(cbGrassNumberOfDescendant, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
        jPanel1.add(jLabel12, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(jLabel9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(jLabel10, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(cbGrasshopperMaxAge, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(cbGrasshopperBeginOfMultiplication, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(cbGrasshopperEndOfMultiplication, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(jLabel11, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(cbGrasshopperNumberOfDescendant, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel1.add(jLabel13, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(cbGrasshopperMaxHunger, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(jLabel18, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(jLabel17, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(jLabel16, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel2.add(cbLizardMaxAge, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(cbLizardBeginOfMultiplication, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(cbLizardEndOfMultiplication, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(cbLizardNumberOfDescendant, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel2.add(jLabel15, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(jLabel14, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(cbLizardMaxHunger, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel8, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
        jPanel8.add(rbRandomFoodSearching, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel8.add(rbConsciousFoodSearching, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel7, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 0), 0, 0));
        this.add(jPanel6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        jPanel6.add(jLabel21, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel6.add(jLabel22, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel6.add(jLabel23, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel6.add(cbGrasshopperSettling, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel6.add(cbGrassSettling, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel6.add(cbLizardSettling, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel5, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 0), 0, 0));
        jPanel5.add(jLabel19, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel5.add(cbGrasshoppersOnTerritory, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel5.add(cbGrassesOnTerritory, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 0, 0));
        jPanel5.add(jLabel20, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel5.add(cbLizardsOnTerritory, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel5.add(jLabel8, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 5, 5), 0, 0));
        jPanel7.add(rbManualTimeStart, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel7.add(rbAutomaticTimeStart, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        buttonGroup1.add(rbRandomFoodSearching);
        buttonGroup1.add(rbConsciousFoodSearching);

        buttonGroup2.add(rbAutomaticTimeStart);
        buttonGroup2.add(rbManualTimeStart);

        setComboBoxes();
    }

    //----------------------------------------------------------------------

    /** Visszaadja a számok sorozatát min-től max-ig */
    private Vector numbers(int min, int max) {
        Vector numbers = new Vector();
        for (int i = min; i <= max; i++) {
            numbers.add(new Integer(i));
        }
        return numbers;
    }

    //----------------------------------------------------------------------

    /** Visszaadja az időegység értékeit */
    private Vector timeUnits() {
        Vector timeUnits = new Vector();
        double timeUnit = TIME_UNIT_LOWER_BOUND;
        do {
            timeUnits.add(new Double(timeUnit));
            timeUnit += 0.25;
        }
        while (timeUnit <= TIME_UNIT_UPPER_BOUND);
        return timeUnits;
    }

    //----------------------------------------------------------------------

    /** Beállítja a komponenseket az adatmodulban tárolt adatok alapján */
    public void setComboBoxes() {
        cbTime.setSelectedItem(new Double(dataModule.getTimeUnit()));
        cbWidth.setSelectedItem(new Integer(dataModule.getIslandWidth()));
        cbHeight.setSelectedItem(new Integer(dataModule.getIslandHeight()));

        cbGrassesOnTerritory.setSelectedItem(
                new Integer(dataModule.getMaxNumberOfGrassesOnTerritory()));
        cbGrasshoppersOnTerritory.setSelectedItem(
                new Integer(dataModule.getMaxNumberOfGrasshoppersOnTerritory()));
        cbLizardsOnTerritory.setSelectedItem(
                new Integer(dataModule.getMaxNumberOfLizardsOnTerritory()));

        // betelepítés
        cbGrassSettling.setSelectedItem(
                new Integer(dataModule.getGrassSettling()));
        cbGrasshopperSettling.setSelectedItem(
                new Integer(dataModule.getGrasshopperSettling()));
        cbLizardSettling.setSelectedItem(
                new Integer(dataModule.getLizardSettling()));

        cbGrassMaxAge.setSelectedItem(
                new Integer(dataModule.getGrassMaxAge()));
        cbGrassBeginOfMultiplication.setSelectedItem(
                new Integer(dataModule.getGrassBeginOfMultiplication()));
        cbGrassEndOfMultiplication.setSelectedItem(
                new Integer(dataModule.getGrassEndOfMultiplication()));
        cbGrassNumberOfDescendant.setSelectedItem(
                new Integer(dataModule.getGrassNumberOfDescendant()));

        cbGrasshopperMaxAge.setSelectedItem(
                new Integer(dataModule.getGrasshopperMaxAge()));
        cbGrasshopperBeginOfMultiplication.setSelectedItem(
                new Integer(dataModule.getGrasshopperBeginOfMultiplication()));
        cbGrasshopperEndOfMultiplication.setSelectedItem(
                new Integer(dataModule.getGrasshopperEndOfMultiplication()));
        cbGrasshopperNumberOfDescendant.setSelectedItem(
                new Integer(dataModule.getGrasshopperNumberOfDescendant()));
        cbGrasshopperMaxHunger.setSelectedItem(
                new Integer(dataModule.getGrasshopperMaxHunger()));

        cbLizardMaxAge.setSelectedItem(
                new Integer(dataModule.getLizardMaxAge()));
        cbLizardBeginOfMultiplication.setSelectedItem(
                new Integer(dataModule.getLizardBeginOfMultiplication()));
        cbLizardEndOfMultiplication.setSelectedItem(
                new Integer(dataModule.getLizardEndOfMultiplication()));
        cbLizardNumberOfDescendant.setSelectedItem(
                new Integer(dataModule.getLizardNumberOfDescendant()));
        cbLizardMaxHunger.setSelectedItem(
                new Integer(dataModule.getLizardMaxHunger()));

        rbRandomFoodSearching.setSelected(
                dataModule.getFoodSearching() == RANDOM_FOOD_SEARCHING);
        rbConsciousFoodSearching.setSelected(
                dataModule.getFoodSearching() == CONSCIOUS_FOOD_SEARCHING);

        rbAutomaticTimeStart.setSelected(
                dataModule.getTimeStart() == AUTOMATIC_TIME_START);
        rbManualTimeStart.setSelected(
                dataModule.getTimeStart() == MANUAL_TIME_START);
    }

    //----------------------------------------------------------------------

    /** Menti a beállított adatokat */
    public void saveSettings() {
        dataModule.setTimeUnit((
                (Double) cbTime.getSelectedItem()).doubleValue());
        dataModule.setIslandWidth((
                (Integer) cbWidth.getSelectedItem()).intValue());
        dataModule.setIslandHeight((
                (Integer) cbHeight.getSelectedItem()).intValue());

        dataModule.setMaxNumberOfGrassesOnTerritory((
                (Integer) cbGrassesOnTerritory.getSelectedItem()).intValue());
        dataModule.setMaxNumberOfGrasshoppersOnTerritory((
                (Integer) cbGrasshoppersOnTerritory.getSelectedItem()).intValue());
        dataModule.setMaxNumberOfLizardsOnTerritory((
                (Integer) cbLizardsOnTerritory.getSelectedItem()).intValue());

        dataModule.setGrassSettling((
                (Integer) cbGrassSettling.getSelectedItem()).intValue());
        dataModule.setGrasshopperSettling((
                (Integer) cbGrasshopperSettling.getSelectedItem()).intValue());
        dataModule.setLizardSettling((
                (Integer) cbLizardSettling.getSelectedItem()).intValue());

        dataModule.setGrassMaxAge((
                (Integer) cbGrassMaxAge.getSelectedItem()).intValue());
        dataModule.setGrassBeginOfMultiplication((
                (Integer) cbGrassBeginOfMultiplication.getSelectedItem()).intValue());
        dataModule.setGrassEndOfMultiplication((
                (Integer) cbGrassEndOfMultiplication.getSelectedItem()).intValue());
        dataModule.setGrassNumberOfDescendant((
                (Integer) cbGrassNumberOfDescendant.getSelectedItem()).intValue());

        dataModule.setGrasshopperMaxAge((
                (Integer) cbGrasshopperMaxAge.getSelectedItem()).intValue());
        dataModule.setGrasshopperBeginOfMultiplication((
                (Integer) cbGrasshopperBeginOfMultiplication.getSelectedItem()).intValue());
        dataModule.setGrasshopperEndOfMultiplication((
                (Integer) cbGrasshopperEndOfMultiplication.getSelectedItem()).intValue());
        dataModule.setGrasshopperNumberOfDescendant((
                (Integer) cbGrasshopperNumberOfDescendant.getSelectedItem()).intValue());
        dataModule.setGrasshopperMaxHunger((
                (Integer) cbGrasshopperMaxHunger.getSelectedItem()).intValue());

        dataModule.setLizardMaxAge((
                (Integer) cbLizardMaxAge.getSelectedItem()).intValue());
        dataModule.setLizardBeginOfMultiplication((
                (Integer) cbLizardBeginOfMultiplication.getSelectedItem()).intValue());
        dataModule.setLizardEndOfMultiplication((
                (Integer) cbLizardEndOfMultiplication.getSelectedItem()).intValue());
        dataModule.setLizardNumberOfDescendant((
                (Integer) cbLizardNumberOfDescendant.getSelectedItem()).intValue());
        dataModule.setLizardMaxHunger((
                (Integer) cbLizardMaxHunger.getSelectedItem()).intValue());

        if (rbRandomFoodSearching.isSelected())
            dataModule.setFoodSearching(RANDOM_FOOD_SEARCHING);
        if (rbConsciousFoodSearching.isSelected())
            dataModule.setFoodSearching(CONSCIOUS_FOOD_SEARCHING);

        if (rbAutomaticTimeStart.isSelected())
            dataModule.setTimeStart(AUTOMATIC_TIME_START);
        if (rbManualTimeStart.isSelected())
            dataModule.setTimeStart(MANUAL_TIME_START);
    }
}









