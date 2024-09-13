package org.example.gui;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.internalframe.AboutInternalFrame;
import org.example.gui.internalframe.DiagramInternalFrame;
import org.example.gui.internalframe.GraphInternalFrame;
import org.example.gui.internalframe.InformationInternalFrame;
import org.example.gui.internalframe.IslandInternalFrame;
import org.example.gui.internalframe.SettingsInternalFrame;
import org.example.gui.internalframe.UseInternalFrame;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Főablak */
public class MainFrame extends JFrame implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A belső ablakokhoz... */
    private JDesktopPane desktop = new JDesktopPane();

    /** Időzítő */
    private Timer timer;

    /** Belső ablakok */
    private IslandInternalFrame islandInternalFrame;
    private DiagramInternalFrame diagramInternalFrame;
    private GraphInternalFrame graphInternalFrame;
    private SettingsInternalFrame settingsInternalFrame;
    private InformationInternalFrame informationInternalFrame;
    private UseInternalFrame useInternalFrame =
            new UseInternalFrame(this, "Használat");
    private AboutInternalFrame aboutInternalFrame =
            new AboutInternalFrame(this, "Névjegy");

    /** Ikonok */
    IconLabel lbRestart =
            new IconLabel(new ImageIcon(ICON_RESTART),
                    null);
    IconLabel lbMap =
            new IconLabel(new ImageIcon(ICON_MAP),
                    null);
    IconLabel lbDiagram =
            new IconLabel(new ImageIcon(ICON_DIAGRAM),
                    null);
    IconLabel lbGraph =
            new IconLabel(new ImageIcon(ICON_GRAPH),
                    null);
    IconLabel lbTime =
            new IconLabel(new ImageIcon(ICON_TIME_2),
                    null);
    IconLabel lbSettings =
            new IconLabel(new ImageIcon(ICON_SETTINGS),
                    null);
    IconLabel lbGrass =
            new IconLabel(new ImageIcon(ICON_GRASS_1),
                    new ImageIcon(ICON_GRASS_2));
    IconLabel lbGrasshopper =
            new IconLabel(new ImageIcon(ICON_GRASSHOPPER_1),
                    new ImageIcon(ICON_GRASSHOPPER_2));
    IconLabel lbLizard =
            new IconLabel(new ImageIcon(ICON_LIZARD_1),
                    new ImageIcon(ICON_LIZARD_2));
    IconLabel lbInformations =
            new IconLabel(new ImageIcon(ICON_INFORMATIONS),
                    null);
    IconLabel lbUse =
            new IconLabel(new ImageIcon(ICON_USE),
                    null);
    IconLabel lbAbout =
            new IconLabel(new ImageIcon(ICON_ABOUT),
                    null);
    IconLabel lbVioletColored =
            new IconLabel(new ImageIcon(ICON_VIOLET_COLORED_1),
                    new ImageIcon(ICON_VIOLET_COLORED_2));
    IconLabel lbLightBlue =
            new IconLabel(new ImageIcon(ICON_LIGHT_BLUE_1),
                    new ImageIcon(ICON_LIGHT_BLUE_2));
    IconLabel lbSeaBlue =
            new IconLabel(new ImageIcon(ICON_SEA_BLUE_1),
                    new ImageIcon(ICON_SEA_BLUE_2));
    IconLabel lbGray =
            new IconLabel(new ImageIcon(ICON_GRAY_1),
                    new ImageIcon(ICON_GRAY_2));
    IconLabel lbDesert =
            new IconLabel(new ImageIcon(ICON_DESERT_1),
                    new ImageIcon(ICON_DESERT_2));

    JPanel contentPane;

    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu mHelp = new JMenu();
    JMenuItem miUse = new JMenuItem();
    JMenuItem miAbout = new JMenuItem();

    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel iconPanel = new JPanel();
    JPanel jPanel1 = new JPanel();
    Border border1;
    TitledBorder titledBorder1;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JSeparator jSeparator1 = new JSeparator();
    JSeparator jSeparator2 = new JSeparator();
    JSeparator jSeparator3 = new JSeparator();
    JSeparator jSeparator4 = new JSeparator();

    JPanel jPanel2 = new JPanel();

    Border iconBorder;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        settingsInternalFrame =
                new SettingsInternalFrame(this, "Beállítások");

        iconBorder = BorderFactory.createEtchedBorder();

        border1 = BorderFactory.createLineBorder(SystemColor.info, 1);
        titledBorder1 = new TitledBorder(border1, " Betelepítés");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        contentPane = (JPanel) this.getContentPane();
        this.setTitle("Sziget");
        this.addComponentListener(new MainFrame_this_componentAdapter(this));
        mHelp.setText("Súgó");
        miUse.setText("Használat");
        miAbout.setText("Névjegy");
        contentPane.setLayout(borderLayout2);
        iconPanel.setLayout(gridBagLayout1);

        lbMap.setToolTipText("Térkép");
        lbDiagram.setToolTipText("Diagram");
        lbGraph.setToolTipText("Grafikon");
        lbTime.setToolTipText("Idő elindítása / megállítása");
        lbSettings.setToolTipText("Beállítások");
        lbRestart.setToolTipText("Szimuláció indítása");


        jSeparator1.setOrientation(JSeparator.VERTICAL);
        jSeparator2.setOrientation(JSeparator.VERTICAL);
        jSeparator3.setOrientation(JSeparator.VERTICAL);
        jSeparator4.setOrientation(JSeparator.VERTICAL);


        lbRestart.addMouseListener(new MainFrame_lbRestart_mouseAdapter(this));
        lbGrasshopper.addMouseListener(new MainFrame_lbGrasshopper_mouseAdapter(this));
        lbGrass.addMouseListener(new MainFrame_lbGrass_mouseAdapter(this));
        lbLizard.addMouseListener(new MainFrame_lbLizard_mouseAdapter(this));
        lbGrass.setToolTipText("Fű");
        lbGrasshopper.setToolTipText("Szöcske");
        lbLizard.setToolTipText("Gyík");
        lbInformations.setToolTipText("Adatlap");

        lbUse.setToolTipText("Használat");
        lbUse.addMouseListener(new MainFrame_lbUse_mouseAdapter(this));
        lbAbout.setToolTipText("Névjegy");

        lbAbout.addMouseListener(new MainFrame_lbAbout_mouseAdapter(this));
        lbInformations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbInformations_mousePressed(e);
            }
        });
        mHelp.add(miUse);
        mHelp.add(miAbout);
        //jMenuBar1.add(mHelp);
        contentPane.add(iconPanel, BorderLayout.NORTH);
        contentPane.add(desktop, BorderLayout.CENTER);
        this.setJMenuBar(jMenuBar1);

        iconPanel.add(lbRestart,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbTime,
                new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbSettings,
                new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(jSeparator1,
                new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.VERTICAL,
                        new Insets(3, 5, 3, 5), 0, 0));
        iconPanel.add(lbMap,
                new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.WEST,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbDiagram,
                new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.WEST,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbGraph,
                new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbInformations,
                new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(jSeparator2,
                new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.VERTICAL,
                        new Insets(3, 5, 3, 5), 0, 0));
        iconPanel.add(lbGrass,
                new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbGrasshopper,
                new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbLizard,
                new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(jSeparator3,
                new GridBagConstraints(12, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.VERTICAL,
                        new Insets(3, 5, 3, 5), 0, 0));
        iconPanel.add(lbVioletColored,
                new GridBagConstraints(13, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbLightBlue,
                new GridBagConstraints(14, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbSeaBlue,
                new GridBagConstraints(15, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbGray,
                new GridBagConstraints(16, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbDesert,
                new GridBagConstraints(17, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(jSeparator4,
                new GridBagConstraints(18, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.VERTICAL,
                        new Insets(3, 5, 3, 5), 0, 0));
        iconPanel.add(lbUse,
                new GridBagConstraints(19, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(lbAbout,
                new GridBagConstraints(20, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        iconPanel.add(jPanel2,
                new GridBagConstraints(21, 0, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));

        desktop.add(settingsInternalFrame);
        settingsInternalFrame.setVisible(true);
        desktop.add(useInternalFrame);
        desktop.add(aboutInternalFrame);

        lbMap.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbMap_mousePressed(e);
            }
        });
        lbDiagram.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbDiagram_mousePressed(e);
            }
        });
        lbGraph.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbGraph_mousePressed(e);
            }
        });
        lbTime.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbTime_mousePressed(e);
            }
        });
        lbSettings.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbSettings_mousePressed(e);
            }
        });
        lbInformations.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbInformations_mousePressed(e);
            }
        });
        lbVioletColored.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbVioletColored_mousePressed(e);
            }
        });
        lbLightBlue.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbLightBlue_mousePressed(e);
            }
        });
        lbSeaBlue.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbSeaBlue_mousePressed(e);
            }
        });
        lbGray.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbGray_mousePressed(e);
            }
        });
        lbDesert.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbDesert_mousePressed(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });


        lbGrass.setIcon(lbGrass.getImageIcon_2());

        if (dataModule.getColorTheme().equals(VIOLET_COLORED)) {
            lbVioletColored.setIcon(lbVioletColored.getImageIcon_2());
        }
        if (dataModule.getColorTheme().equals(LIGHT_BLUE)) {
            lbLightBlue.setIcon(lbLightBlue.getImageIcon_2());
        }
        if (dataModule.getColorTheme().equals(SEA_BLUE)) {
            lbSeaBlue.setIcon(lbSeaBlue.getImageIcon_2());
        }
        if (dataModule.getColorTheme().equals(GRAY)) {
            lbGray.setIcon(lbGray.getImageIcon_2());
        }
        if (dataModule.getColorTheme().equals(DESERT)) {
            lbDesert.setIcon(lbDesert.getImageIcon_2());
        }
    }

    //----------------------------------------------------------------------

    /** Ha a kapott színséma eltér az aktuális színsémától, akkor az
     * alkalmazás összes komponense új megjelenítést kap. */
    private void changeColorTheme(ColorTheme colorTheme) {
        ColorTheme actualColorTheme = dataModule.getColorTheme();
        if (!actualColorTheme.equals(colorTheme)) {
            ModifiedDefaultMetalTheme modifiedDefaultMetalTheme =
                    new ModifiedDefaultMetalTheme(colorTheme, METAL_GRAY);

            MetalLookAndFeel modifiedMetalLookAndFeel = new MetalLookAndFeel();
            modifiedMetalLookAndFeel.setCurrentTheme(modifiedDefaultMetalTheme);

            try {
                UIManager.setLookAndFeel(modifiedMetalLookAndFeel);
                SwingUtilities.updateComponentTreeUI(getRootPane());
                useInternalFrame.refreshTree();
                dataModule.setColorTheme(colorTheme);
                getRootPane().revalidate();
                getRootPane().repaint();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------

    /** Új játék kezdete. A régi adatok nullázódnak, a belső ablakok újak
     * lesznek */
    public void newGame() {
        stopTimer();
        removeInternalFrames();
        dataModule.setTime(0);
        dataModule.setNumberOfGrasses(0);
        dataModule.setNumberOfGrasshoppers(0);
        dataModule.setNumberOfLizards(0);
        desktop.repaint();
        addInternalFrames();
        initTimer();
    }

    //----------------------------------------------------------------------

    /** Létrehozza az időmérőt */
    private void initTimer() {
        int timeUnit = (int) (dataModule.getTimeUnit() * 1000);
        timer = new Timer(timeUnit, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModule.increaseTime();
                progressOfTime();
                //Runtime.getRuntime().gc();
            }
        });
        if (dataModule.getTimeStart() == AUTOMATIC_TIME_START)
            timer.start();
        timeIcon();

    }

    //----------------------------------------------------------------------

    /** Meállítja az időmérőt */
    private void stopTimer() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    //----------------------------------------------------------------------

    /** Értesíti a belső ablakokat, hogy frissítsék tartalmukat */
    private void progressOfTime() {
        islandInternalFrame.progressOfTime();
        diagramInternalFrame.progressOfTime();
        graphInternalFrame.progressOfTime();
        informationInternalFrame.progressOfTime();
    }

    //----------------------------------------------------------------------

    /** Eltávolítja a belső ablakokat */
    private void removeInternalFrames() {
        if (islandInternalFrame != null)
            desktop.remove(islandInternalFrame);
        if (diagramInternalFrame != null)
            desktop.remove(diagramInternalFrame);
        if (graphInternalFrame != null)
            desktop.remove(graphInternalFrame);
        if (informationInternalFrame != null)
            desktop.remove(informationInternalFrame);

        islandInternalFrame = null;
        diagramInternalFrame = null;
        graphInternalFrame = null;
        informationInternalFrame = null;

        useInternalFrame.setVisible(false);
        aboutInternalFrame.setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Hozzáadja a belső ablakokat */
    private void addInternalFrames() {
        desktop.add(islandInternalFrame = new IslandInternalFrame("Térkép"));
        desktop.add(diagramInternalFrame = new DiagramInternalFrame(this, "Diagram"));
        desktop.add(graphInternalFrame = new GraphInternalFrame(this, "Grafikon"));
        desktop.add(informationInternalFrame = new InformationInternalFrame(this, "Adatlap"));
        lbMap_mousePressed(null);
        ComponentLocation.center(islandInternalFrame,
                islandInternalFrame.getParent());
        ComponentLocation.center(diagramInternalFrame,
                diagramInternalFrame.getParent());
        ComponentLocation.center(graphInternalFrame,
                graphInternalFrame.getParent());
        ComponentLocation.center(informationInternalFrame,
                informationInternalFrame.getParent());
    }

    //----------------------------------------------------------------------

    /** Frissíti a diagram és a grafikon tartalmát */
    public void refreshScales() {
        diagramInternalFrame.refreshDiagram();
        graphInternalFrame.refreshGraph();
    }

    //----------------------------------------------------------------------

    /** Meghatározza az idő ikon kinézetét */
    private void timeIcon() {
        lbTime.setIcon(timer.isRunning() ? new ImageIcon(ICON_TIME_2) :
                new ImageIcon(ICON_TIME_1));
    }

    //----------------------------------------------------------------------

    /** Kilépés */
    private void exit() {
        if (MessageManager.showConfirmDialog(this, "Biztosan kilép?"))
            System.exit(0);
    }

    //----------------------------------------------------------------------

    /** Térkép gomb megnyomása */
    void lbMap_mousePressed(MouseEvent e) {
        if (islandInternalFrame == null)
            return;
        if (!islandInternalFrame.isVisible())
            islandInternalFrame.setVisible(true);
        islandInternalFrame.moveToFront();
        try {
            islandInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Diagram gomb megnyomása */
    void lbDiagram_mousePressed(MouseEvent e) {
        if (diagramInternalFrame == null)
            return;
        if (!diagramInternalFrame.isVisible())
            diagramInternalFrame.setVisible(true);
        diagramInternalFrame.moveToFront();
        try {
            diagramInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Grafikon gomb megnyomása */
    void lbGraph_mousePressed(MouseEvent e) {
        if (graphInternalFrame == null)
            return;
        if (!graphInternalFrame.isVisible())
            graphInternalFrame.setVisible(true);
        graphInternalFrame.moveToFront();
        try {
            graphInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Beállítások gomb megnyomása */
    void lbSettings_mousePressed(MouseEvent e) {
        if (!settingsInternalFrame.isVisible())
            settingsInternalFrame.setVisible(true);
        settingsInternalFrame.moveToFront();
        try {
            settingsInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Idő gomb megnyomása */
    void lbTime_mousePressed(MouseEvent e) {
        if (timer == null)
            return;
        if (timer.isRunning()) {
            timer.stop();
            lbTime.setIcon(new ImageIcon(ICON_TIME_1));
        } else {
            timer.start();
            lbTime.setIcon(new ImageIcon(ICON_TIME_2));
        }
    }

    //----------------------------------------------------------------------

    /** Újraindítás gomb megnyomása */
    void lbRestart_mousePressed(MouseEvent e) {
        settingsInternalFrame.saveSettings();
        newGame();
        settingsInternalFrame.setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Fű betelepítés kiválasztása */
    void lbGrass_mousePressed(MouseEvent e) {
        dataModule.setSettling(GRASS_SETTLING);
        lbGrass.setIcon(lbGrass.getImageIcon_2());
        lbGrasshopper.resetIcon();
        lbLizard.resetIcon();
    }

    //----------------------------------------------------------------------

    /** Szöcske betelepítés kiválasztása */
    void lbGrasshopper_mousePressed(MouseEvent e) {
        dataModule.setSettling(GRASSHOPPER_SETTLING);
        lbGrasshopper.setIcon(lbGrasshopper.getImageIcon_2());
        lbGrass.resetIcon();
        lbLizard.resetIcon();
    }

    //----------------------------------------------------------------------

    /** Gyík betelepítés kiválasztása */
    void lbLizard_mousePressed(MouseEvent e) {
        dataModule.setSettling(LIZARD_SETTLING);
        lbLizard.setIcon(lbLizard.getImageIcon_2());
        lbGrass.resetIcon();
        lbDesert.resetIcon();
        lbGrasshopper.resetIcon();
    }

    //----------------------------------------------------------------------

    /** Lila színséma kiválasztása */
    void lbVioletColored_mousePressed(MouseEvent e) {
        lbVioletColored.setIcon(lbVioletColored.getImageIcon_2());
        lbLightBlue.resetIcon();
        lbSeaBlue.resetIcon();
        lbGray.resetIcon();
        lbDesert.resetIcon();
        changeColorTheme(VIOLET_COLORED);
    }

    //----------------------------------------------------------------------

    /** Világoskék színséma kiválasztása */
    void lbLightBlue_mousePressed(MouseEvent e) {
        lbLightBlue.setIcon(lbLightBlue.getImageIcon_2());
        lbVioletColored.resetIcon();
        lbSeaBlue.resetIcon();
        lbGray.resetIcon();
        lbDesert.resetIcon();
        changeColorTheme(LIGHT_BLUE);
    }

    //----------------------------------------------------------------------

    /** Zöld színséma kiválasztása */
    void lbSeaBlue_mousePressed(MouseEvent e) {
        lbSeaBlue.setIcon(lbSeaBlue.getImageIcon_2());
        lbVioletColored.resetIcon();
        lbLightBlue.resetIcon();
        lbGray.resetIcon();
        lbDesert.resetIcon();
        changeColorTheme(SEA_BLUE);
    }

    //----------------------------------------------------------------------

    /** Szürke színséma kiválasztása */
    void lbGray_mousePressed(MouseEvent e) {
        lbGray.setIcon(lbGray.getImageIcon_2());
        lbVioletColored.resetIcon();
        lbSeaBlue.resetIcon();
        lbLightBlue.resetIcon();
        lbDesert.resetIcon();
        changeColorTheme(GRAY);
    }

    //----------------------------------------------------------------------

    /** Barna színséma kiválasztása */
    void lbDesert_mousePressed(MouseEvent e) {
        lbDesert.setIcon(lbDesert.getImageIcon_2());
        lbVioletColored.resetIcon();
        lbSeaBlue.resetIcon();
        lbLightBlue.resetIcon();
        lbGray.resetIcon();
        changeColorTheme(DESERT);
    }

    //----------------------------------------------------------------------

    /** Adatlap gombjának megnyomása */
    void lbInformations_mousePressed(MouseEvent e) {
        if (informationInternalFrame == null)
            return;
        if (!informationInternalFrame.isVisible())
            informationInternalFrame.setVisible(true);
        informationInternalFrame.moveToFront();
        try {
            informationInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Használat gomb megnyomása */
    void lbUse_mousePressed(MouseEvent e) {
        if (!useInternalFrame.isVisible())
            useInternalFrame.showInternalFrame();
        useInternalFrame.moveToFront();
        try {
            useInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Névjegy gomb megnyomása */
    void lbAbout_mousePressed(MouseEvent e) {
        if (!aboutInternalFrame.isVisible())
            aboutInternalFrame.showInternalFrame();
        aboutInternalFrame.moveToFront();
        try {
            aboutInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    //----------------------------------------------------------------------

    /** Induláskor a belső ablakok elhelyezése */
    void this_componentShown(ComponentEvent e) {
        ComponentLocation.center(settingsInternalFrame,
                settingsInternalFrame.getParent());
        ComponentLocation.center(useInternalFrame,
                useInternalFrame.getParent());
        ComponentLocation.center(aboutInternalFrame,
                aboutInternalFrame.getParent());
    }
}

//############################################################################

class MainFrame_lbRestart_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbRestart_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbRestart_mousePressed(e);
    }
}

class MainFrame_lbGrasshopper_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbGrasshopper_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbGrasshopper_mousePressed(e);
    }
}

class MainFrame_lbGrass_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbGrass_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbGrass_mousePressed(e);
    }
}

class MainFrame_lbLizard_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbLizard_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbLizard_mousePressed(e);
    }
}

class MainFrame_lbUse_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbUse_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbUse_mousePressed(e);
    }
}

class MainFrame_lbAbout_mouseAdapter extends java.awt.event.MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbAbout_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbAbout_mousePressed(e);
    }
}

class MainFrame_this_componentAdapter extends java.awt.event.ComponentAdapter {
    MainFrame adaptee;

    MainFrame_this_componentAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void componentShown(ComponentEvent e) {
        adaptee.this_componentShown(e);
    }
}






