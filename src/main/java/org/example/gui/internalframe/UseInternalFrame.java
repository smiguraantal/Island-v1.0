package org.example.gui.internalframe;

import org.example.gui.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Használat dialógus */
public class UseInternalFrame extends JInternalFrame {

    // A témakörök faszerkezetben való megjelenítéséhez használt objektumok
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Sziget");
    private DefaultTreeModel treeModel = new DefaultTreeModel(root);
    ;
    private JTree tree = new JTree(treeModel);
    private DefaultMutableTreeNode nodeOverview =
            new DefaultMutableTreeNode("Áttekintés");
    private DefaultMutableTreeNode nodeLiving =
            new DefaultMutableTreeNode("Élet a szigeten");
    private DefaultMutableTreeNode nodeSim =
            new DefaultMutableTreeNode("Szimuláció");
    private DefaultMutableTreeNode nodeAnomaly =
            new DefaultMutableTreeNode("Anomáliák");

    /** Főablak */
    MainFrame mainFrame;

    JPanel panel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    JButton btClose = new JButton();
    JPanel jPanel3 = new JPanel();
    JSplitPane splitPane = new JSplitPane();
    BorderLayout borderLayout2 = new BorderLayout();
    JScrollPane scrollTree = new JScrollPane();
    JScrollPane scrollEditor = new JScrollPane();
    JEditorPane editorPane = new JEditorPane();
    Border border1;
    Border border2;
    Border border3;
    Border border4;
    Border border5;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public UseInternalFrame(MainFrame mainFrame, String title) {
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

    /** Felépíti a felületet */
    private void jbInit() throws Exception {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            public void internalFrameClosing(InternalFrameEvent e) {
                this_internalFrameClosing(e);
            }
        });
        jPanel1.removeAll();
        border1 = BorderFactory.createEmptyBorder(5, 0, 0, 0);
        border2 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        border5 = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        panel1.setLayout(gridBagLayout1);
        jPanel1.setLayout(borderLayout1);
        btClose.setText("Bezárás");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btClose_actionPerformed(e);
            }
        });
        jPanel3.setLayout(borderLayout2);
        scrollEditor.setPreferredSize(new Dimension(350, 300));
        scrollTree.setPreferredSize(new Dimension(170, 300));
        jPanel2.setBorder(border1);
        jPanel3.setBorder(border2);
        splitPane.setDividerSize(5);
        splitPane.setOneTouchExpandable(false);
        editorPane.setForeground(Color.black);
        editorPane.setBorder(border5);
        editorPane.setCaretPosition(0);
        editorPane.setMargin(new Insets(3, 3, 3, 3));
        getContentPane().add(panel1);
        panel1.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(jPanel2, BorderLayout.SOUTH);
        jPanel2.add(btClose, null);
        jPanel1.add(jPanel3, BorderLayout.CENTER);
        jPanel3.add(splitPane, BorderLayout.CENTER);
        splitPane.add(scrollTree, JSplitPane.LEFT);
        splitPane.add(scrollEditor, JSplitPane.RIGHT);
        scrollTree.getViewport().add(tree, null);
        scrollEditor.getViewport().add(editorPane, null);

        tree.setCellRenderer(new DefaultTreeCellRenderer());
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.putClientProperty("JTree.lineStyle", "Angled");

        treeModel.insertNodeInto(nodeOverview, root, root.getChildCount());
        treeModel.insertNodeInto(nodeLiving, root, root.getChildCount());
        treeModel.insertNodeInto(nodeSim, root, root.getChildCount());
        treeModel.insertNodeInto(nodeAnomaly, root, root.getChildCount());

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                initEditorPane((DefaultMutableTreeNode) tree.getLastSelectedPathComponent());
            }
        });

//    initEditorPane(nodeOverview);
        tree.setToggleClickCount(1);
        treeModel.reload();
        tree.setSelectionRows(new int[]{1});
        editorPane.setEditable(false);

        pack();
    }

    //----------------------------------------------------------------------

    /** Az editor panelhez hozzárendel egy fájlt */
    public void initEditorPane(DefaultMutableTreeNode selectedNode) {
        if (selectedNode == root)
            return;

        String path = createPath(selectedNode);

        try {
            URL url = new URL(path);
            try {
                editorPane.setPage(url);
            } catch (IOException ex1) {
            }
        } catch (MalformedURLException ex) {
            System.out.println("Nem elérhető url: " + path);
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /** A témakör kiválasztottságától függően adja vissza egy html fájl elérési
     * útját */
    private String createPath(DefaultMutableTreeNode selectedNode) {
        String file = null;
        if (selectedNode == nodeOverview)
            file = "Overview.html";
        if (selectedNode == nodeLiving)
            file = "Living.html";
        if (selectedNode == nodeSim)
            file = "Sim.html";
        if (selectedNode == nodeAnomaly)
            file = "Anomaly.html";

        return "file:" +
                System.getProperty("user.dir") +
                System.getProperty("file.separator") +
                "doc" +
                System.getProperty("file.separator") +
                file;
    }

    //----------------------------------------------------------------------

    /** Frissíti a fa kinézetét */
    public void refreshTree() {
        tree.setCellRenderer(new DefaultTreeCellRenderer());
        pack();
    }

    //----------------------------------------------------------------------

    /** Megjeleníti a dialógust */
    public void showInternalFrame() {
        tree.setCellRenderer(new DefaultTreeCellRenderer());
        btClose.requestFocus();
        setVisible(true);
    }

    //----------------------------------------------------------------------

    /** Elrejti a dialógust */
    void btClose_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    //----------------------------------------------------------------------

    /** Ablak bezárása */
    void this_internalFrameClosing(InternalFrameEvent e) {
        setVisible(false);
    }
}










