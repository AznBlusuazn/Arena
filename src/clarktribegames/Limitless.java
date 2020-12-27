package clarktribegames;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

// <editor-fold defaultstate="collapsed" desc="Credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * @version IN DEVELOPMENT
 * 
 */
//</editor-fold>

public class Limitless extends javax.swing.JFrame {

    public Limitless() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        menuPanel.setVisible(false);
        showMenu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLogo = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JLabel();
        loadButton = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        optsButton = new javax.swing.JLabel();
        aboutButton = new javax.swing.JLabel();
        donateButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        loadPanel = new javax.swing.JPanel();
        optsTitle1 = new javax.swing.JLabel();
        lgyesButton = new javax.swing.JLabel();
        lgdelButton = new javax.swing.JLabel();
        lgnoButton = new javax.swing.JLabel();
        lgPane = new javax.swing.JScrollPane();
        lgList = new javax.swing.JList<>();
        lgToon = new javax.swing.JLabel();
        lgToonName = new javax.swing.JLabel();
        lgToonRank = new javax.swing.JLabel();
        lgToonStats = new javax.swing.JLabel();
        lgToonLevel = new javax.swing.JLabel();
        newPanel = new javax.swing.JPanel();
        ngtlToon = new javax.swing.JLabel();
        ngmToon = new javax.swing.JLabel();
        ngtrToon = new javax.swing.JLabel();
        ngyesButton = new javax.swing.JLabel();
        ngnoButton = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        mToon = new javax.swing.JLabel();
        tlToon = new javax.swing.JLabel();
        trToon = new javax.swing.JLabel();
        blToon = new javax.swing.JLabel();
        brToon = new javax.swing.JLabel();
        optsPanel = new javax.swing.JPanel();
        optsTitle = new javax.swing.JLabel();
        darkOpt = new javax.swing.JCheckBox();
        alOpt = new javax.swing.JLabel();
        mOpt = new javax.swing.JCheckBox();
        cmOpt = new javax.swing.JCheckBox();
        mcmOpt = new javax.swing.JLabel();
        imOpt = new javax.swing.JComboBox<>();
        bmOpt = new javax.swing.JComboBox<>();
        vmOpt = new javax.swing.JComboBox<>();
        dmOpt = new javax.swing.JComboBox<>();
        sOpt = new javax.swing.JCheckBox();
        sdbOpt = new javax.swing.JCheckBox();
        dbOpt = new javax.swing.JComboBox<>();
        aboutPanel = new javax.swing.JPanel();
        aboutTitle = new javax.swing.JLabel();
        abouttextPane = new javax.swing.JScrollPane();
        abouttextArea = new javax.swing.JTextArea();
        social1 = new javax.swing.JLabel();
        social2 = new javax.swing.JLabel();
        social3 = new javax.swing.JLabel();
        social4 = new javax.swing.JLabel();
        donatePanel = new javax.swing.JPanel();
        donateTitle = new javax.swing.JLabel();
        donatetextPane = new javax.swing.JScrollPane();
        donatetextArea = new javax.swing.JTextArea();
        social5 = new javax.swing.JLabel();
        social6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("limitless"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N
        getContentPane().add(titleLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

        menuPanel.setBackground(MainControls.backColor);
        menuPanel.setForeground(MainControls.textColor);
        menuPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        menuPanel.setMaximumSize(new java.awt.Dimension(1200, 800));
        menuPanel.setMinimumSize(new java.awt.Dimension(1200, 800));
        menuPanel.setName(""); // NOI18N
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        startButton.setForeground(MainControls.textColor);
        startButton.setText("  Start New Game");
        startButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startButtonMouseReleased(evt);
            }
        });
        menuPanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 200, 25));

        loadButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        loadButton.setForeground(MainControls.textColor);
        loadButton.setText("  Continue Saved Game");
        loadButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loadButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loadButtonMouseReleased(evt);
            }
        });
        menuPanel.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 325, 200, 25));

        editButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        editButton.setForeground(MainControls.textColor);
        editButton.setText("  Limitless Editor");
        editButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButton.setEnabled(false);
        editButton.setFocusable(false);
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editButtonMouseReleased(evt);
            }
        });
        menuPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 200, 25));

        optsButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        optsButton.setForeground(MainControls.textColor);
        optsButton.setText("  Options Menu");
        optsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        optsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                optsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                optsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                optsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                optsButtonMouseReleased(evt);
            }
        });
        menuPanel.add(optsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 475, 200, 25));

        aboutButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        aboutButton.setForeground(MainControls.textColor);
        aboutButton.setText("  About Limitless");
        aboutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aboutButtonMouseReleased(evt);
            }
        });
        menuPanel.add(aboutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 200, 25));

        donateButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        donateButton.setForeground(MainControls.textColor);
        donateButton.setText("  Donate To The Cause");
        donateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        donateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donateButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                donateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                donateButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                donateButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                donateButtonMouseReleased(evt);
            }
        });
        menuPanel.add(donateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 625, 200, 25));

        exitButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        exitButton.setForeground(MainControls.textColor);
        exitButton.setText("  Exit The Game");
        exitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtonMouseReleased(evt);
            }
        });
        menuPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 700, 200, 25));

        loadPanel.setBackground(MainControls.backColor);
        loadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        loadPanel.setForeground(MainControls.textColor);
        loadPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        loadPanel.setMaximumSize(new java.awt.Dimension(450, 475));
        loadPanel.setMinimumSize(new java.awt.Dimension(450, 475));
        loadPanel.setPreferredSize(new java.awt.Dimension(450, 475));
        loadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optsTitle1.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        optsTitle1.setForeground(MainControls.textColor);
        optsTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optsTitle1.setText("Load Saved Game");
        optsTitle1.setFocusable(false);
        loadPanel.add(optsTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 40));

        lgyesButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lgyesButton.setForeground(MainControls.textColor);
        lgyesButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgyesButton.setText("Load Game");
        lgyesButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lgyesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgyesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lgyesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lgyesButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lgyesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lgyesButtonMouseReleased(evt);
            }
        });
        loadPanel.add(lgyesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 425, 150, 25));

        lgdelButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lgdelButton.setForeground(MainControls.textColor);
        lgdelButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgdelButton.setText("Delete Game");
        lgdelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lgdelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgdelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lgdelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lgdelButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lgdelButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lgdelButtonMouseReleased(evt);
            }
        });
        loadPanel.add(lgdelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 425, 150, 25));

        lgnoButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lgnoButton.setForeground(MainControls.textColor);
        lgnoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgnoButton.setText("Nevermind");
        lgnoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lgnoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgnoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lgnoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lgnoButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lgnoButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lgnoButtonMouseReleased(evt);
            }
        });
        loadPanel.add(lgnoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 425, 150, 25));

        lgPane.setHorizontalScrollBar(null);

        lgList.setBackground(MainControls.backColor);
        lgList.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        lgList.setForeground(MainControls.textColor);
        lgList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "<No Saves Available>" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lgList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lgList.setEnabled(false);
        lgList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lgListValueChanged(evt);
            }
        });
        lgPane.setViewportView(lgList);

        loadPanel.add(lgPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 150, 325));

        lgToon.setForeground(MainControls.textColor);
        lgToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgToon.setFocusable(false);
        loadPanel.add(lgToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 75, 200, 200));

        lgToonName.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lgToonName.setForeground(MainControls.textColor);
        lgToonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgToonName.setFocusable(false);
        loadPanel.add(lgToonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 250, 25));

        lgToonRank.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lgToonRank.setForeground(MainControls.textColor);
        lgToonRank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgToonRank.setFocusable(false);
        loadPanel.add(lgToonRank, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 325, 250, 25));

        lgToonStats.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lgToonStats.setForeground(MainControls.textColor);
        lgToonStats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgToonStats.setFocusable(false);
        loadPanel.add(lgToonStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 250, 25));

        lgToonLevel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        lgToonLevel.setForeground(MainControls.textColor);
        lgToonLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lgToonLevel.setFocusable(false);
        loadPanel.add(lgToonLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 375, 250, 25));

        menuPanel.add(loadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        newPanel.setBackground(MainControls.backColor);
        newPanel.setForeground(MainControls.textColor);
        newPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        newPanel.setMaximumSize(new java.awt.Dimension(450, 475));
        newPanel.setMinimumSize(new java.awt.Dimension(450, 475));
        newPanel.setPreferredSize(new java.awt.Dimension(450, 475));
        newPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newPanelMouseEntered(evt);
            }
        });
        newPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ngtlToon.setForeground(MainControls.textColor);
        ngtlToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ngtlToon.setFocusable(false);
        newPanel.add(ngtlToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 200));

        ngmToon.setForeground(MainControls.textColor);
        ngmToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ngmToon.setFocusable(false);
        newPanel.add(ngmToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 200, 200));

        ngtrToon.setForeground(MainControls.textColor);
        ngtrToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ngtrToon.setFocusable(false);
        newPanel.add(ngtrToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 200, 200));

        ngyesButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        ngyesButton.setForeground(MainControls.textColor);
        ngyesButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ngyesButton.setText("Start New Game");
        ngyesButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ngyesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ngyesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ngyesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ngyesButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ngyesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ngyesButtonMouseReleased(evt);
            }
        });
        newPanel.add(ngyesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 325, 200, 25));

        ngnoButton.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        ngnoButton.setForeground(MainControls.textColor);
        ngnoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ngnoButton.setText("Nevermind");
        ngnoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ngnoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ngnoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ngnoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ngnoButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ngnoButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ngnoButtonMouseReleased(evt);
            }
        });
        newPanel.add(ngnoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 325, 200, 25));

        menuPanel.add(newPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        titlePanel.setBackground(MainControls.backColor);
        titlePanel.setForeground(MainControls.textColor);
        titlePanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        titlePanel.setMaximumSize(new java.awt.Dimension(450, 475));
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mToon.setForeground(MainControls.textColor);
        mToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mToon.setFocusable(false);
        titlePanel.add(mToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 138, 200, 200));

        tlToon.setForeground(MainControls.textColor);
        tlToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlToon.setFocusable(false);
        titlePanel.add(tlToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 200));

        trToon.setForeground(MainControls.textColor);
        trToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trToon.setFocusable(false);
        titlePanel.add(trToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 200, 200));

        blToon.setForeground(MainControls.textColor);
        blToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blToon.setFocusable(false);
        titlePanel.add(blToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 200, 200));

        brToon.setForeground(MainControls.textColor);
        brToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brToon.setFocusable(false);
        titlePanel.add(brToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 275, 200, 200));

        menuPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        optsPanel.setBackground(MainControls.backColor);
        optsPanel.setForeground(MainControls.textColor);
        optsPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        optsPanel.setMaximumSize(new java.awt.Dimension(450, 475));
        optsPanel.setMinimumSize(new java.awt.Dimension(450, 475));
        optsPanel.setPreferredSize(new java.awt.Dimension(450, 475));
        optsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optsTitle.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        optsTitle.setForeground(MainControls.textColor);
        optsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optsTitle.setText("Limitless Options");
        optsTitle.setFocusable(false);
        optsPanel.add(optsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 40));

        darkOpt.setBackground(MainControls.backColor);
        darkOpt.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        darkOpt.setForeground(MainControls.textColor);
        darkOpt.setText("Dark Mode");
        darkOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                darkOptItemStateChanged(evt);
            }
        });
        optsPanel.add(darkOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 150, 25));

        alOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        alOpt.setForeground(MainControls.textColor);
        alOpt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alOpt.setText("Manage Avatar Library");
        alOpt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        alOpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alOptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                alOptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                alOptMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                alOptMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                alOptMouseReleased(evt);
            }
        });
        optsPanel.add(alOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 25));

        mOpt.setBackground(MainControls.backColor);
        mOpt.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mOpt.setForeground(MainControls.textColor);
        mOpt.setText("Music On");
        mOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mOptItemStateChanged(evt);
            }
        });
        optsPanel.add(mOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 150, 25));

        cmOpt.setBackground(MainControls.backColor);
        cmOpt.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        cmOpt.setForeground(MainControls.textColor);
        cmOpt.setText("Use Custom Music");
        cmOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmOptItemStateChanged(evt);
            }
        });
        optsPanel.add(cmOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 150, 25));

        mcmOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        mcmOpt.setForeground(MainControls.textColor);
        mcmOpt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mcmOpt.setText("Manage Custom Music");
        mcmOpt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mcmOpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mcmOptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mcmOptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mcmOptMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mcmOptMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mcmOptMouseReleased(evt);
            }
        });
        optsPanel.add(mcmOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 225, 150, 25));

        imOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        imOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Default Intro Music>" }));
        imOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                imOptItemStateChanged(evt);
            }
        });
        optsPanel.add(imOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, 25));

        bmOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        bmOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Default Battle Music>" }));
        bmOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bmOptItemStateChanged(evt);
            }
        });
        optsPanel.add(bmOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 275, 150, 25));

        vmOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        vmOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Default Victory Music>" }));
        vmOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vmOptItemStateChanged(evt);
            }
        });
        optsPanel.add(vmOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 150, 25));

        dmOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        dmOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Default Defeat Music>" }));
        dmOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dmOptItemStateChanged(evt);
            }
        });
        optsPanel.add(dmOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 325, 150, 25));

        sOpt.setBackground(MainControls.backColor);
        sOpt.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sOpt.setForeground(MainControls.textColor);
        sOpt.setText("Sound On");
        sOpt.setEnabled(false);
        sOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sOptItemStateChanged(evt);
            }
        });
        optsPanel.add(sOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 150, 25));

        sdbOpt.setBackground(MainControls.backColor);
        sdbOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        sdbOpt.setForeground(MainControls.textColor);
        sdbOpt.setText("Always Use Same DB");
        sdbOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sdbOptItemStateChanged(evt);
            }
        });
        optsPanel.add(sdbOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 375, 150, 25));

        dbOpt.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        dbOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Default Database>" }));
        optsPanel.add(dbOpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 150, 25));

        menuPanel.add(optsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        aboutPanel.setBackground(MainControls.backColor);
        aboutPanel.setForeground(MainControls.textColor);
        aboutPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aboutPanel.setMaximumSize(new java.awt.Dimension(450, 475));
        aboutPanel.setMinimumSize(new java.awt.Dimension(450, 475));
        aboutPanel.setPreferredSize(new java.awt.Dimension(450, 475));
        aboutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aboutTitle.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        aboutTitle.setForeground(MainControls.textColor);
        aboutTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutTitle.setText("About Limitless");
        aboutTitle.setFocusable(false);
        aboutPanel.add(aboutTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 40));

        abouttextPane.setBackground(MainControls.backColor);
        abouttextPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        abouttextPane.setForeground(MainControls.textColor);
        abouttextPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        abouttextPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        abouttextPane.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        abouttextArea.setBackground(MainControls.backColor);
        abouttextArea.setColumns(20);
        abouttextArea.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        abouttextArea.setForeground(MainControls.textColor);
        abouttextArea.setLineWrap(true);
        abouttextArea.setRows(5);
        abouttextArea.setWrapStyleWord(true);
        abouttextPane.setViewportView(abouttextArea);

        aboutPanel.add(abouttextPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 290));

        social1.setForeground(MainControls.textColor);
        social1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/fb.png"))); // NOI18N
        social1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social1.setFocusable(false);
        social1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social1MouseReleased(evt);
            }
        });
        aboutPanel.add(social1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, 100));

        social2.setForeground(MainControls.textColor);
        social2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/dc.png"))); // NOI18N
        social2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social2.setFocusable(false);
        social2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social2MouseReleased(evt);
            }
        });
        aboutPanel.add(social2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 100, 100));

        social3.setForeground(MainControls.textColor);
        social3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/yt.png"))); // NOI18N
        social3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social3.setFocusable(false);
        social3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social3MouseReleased(evt);
            }
        });
        aboutPanel.add(social3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 100, 100));

        social4.setForeground(MainControls.textColor);
        social4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/bs.png"))); // NOI18N
        social4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social4.setFocusable(false);
        social4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social4MouseReleased(evt);
            }
        });
        aboutPanel.add(social4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 100, 100));

        menuPanel.add(aboutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        donatePanel.setBackground(MainControls.backColor);
        donatePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        donatePanel.setForeground(MainControls.textColor);
        donatePanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        donatePanel.setMaximumSize(new java.awt.Dimension(450, 475));
        donatePanel.setMinimumSize(new java.awt.Dimension(450, 475));
        donatePanel.setPreferredSize(new java.awt.Dimension(450, 475));
        donatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        donateTitle.setFont(new java.awt.Font("Lucida Console", 1, 32)); // NOI18N
        donateTitle.setForeground(MainControls.textColor);
        donateTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        donateTitle.setText("Donate To The Cause");
        donateTitle.setFocusable(false);
        donatePanel.add(donateTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 450, 40));

        donatetextPane.setBackground(MainControls.backColor);
        donatetextPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        donatetextPane.setForeground(MainControls.textColor);
        donatetextPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        donatetextPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        donatetextPane.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        donatetextArea.setBackground(MainControls.backColor);
        donatetextArea.setColumns(20);
        donatetextArea.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        donatetextArea.setForeground(MainControls.textColor);
        donatetextArea.setLineWrap(true);
        donatetextArea.setRows(5);
        donatetextArea.setWrapStyleWord(true);
        donatetextPane.setViewportView(donatetextArea);

        donatePanel.add(donatetextPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 290));

        social5.setForeground(MainControls.textColor);
        social5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/pt.png"))); // NOI18N
        social5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social5.setFocusable(false);
        social5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social5MouseReleased(evt);
            }
        });
        donatePanel.add(social5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 100, 100));

        social6.setForeground(MainControls.textColor);
        social6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        social6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/pp.png"))); // NOI18N
        social6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        social6.setFocusable(false);
        social6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                social6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                social6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                social6MouseReleased(evt);
            }
        });
        donatePanel.add(social6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 100, 100));

        menuPanel.add(donatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 450, 475));

        getContentPane().add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Main Menu Buttons">   
    private void startButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseEntered
        buttonOver(startButton);
    }//GEN-LAST:event_startButtonMouseEntered

    private void startButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseExited
        buttonOff(startButton);
    }//GEN-LAST:event_startButtonMouseExited

    private void loadButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseEntered
        buttonOver(loadButton);
    }//GEN-LAST:event_loadButtonMouseEntered

    private void loadButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseExited
        buttonOff(loadButton);
    }//GEN-LAST:event_loadButtonMouseExited

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
        buttonOver(editButton);
    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
        buttonOff(editButton);
    }//GEN-LAST:event_editButtonMouseExited

    private void optsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMouseEntered
        buttonOver(optsButton);
    }//GEN-LAST:event_optsButtonMouseEntered

    private void optsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMouseExited
        buttonOff(optsButton);
    }//GEN-LAST:event_optsButtonMouseExited

    private void aboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseEntered
        buttonOver(aboutButton);
    }//GEN-LAST:event_aboutButtonMouseEntered

    private void aboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseExited
        buttonOff(aboutButton);
    }//GEN-LAST:event_aboutButtonMouseExited

    private void donateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMouseEntered
        buttonOver(donateButton);
    }//GEN-LAST:event_donateButtonMouseEntered

    private void donateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMouseExited
        buttonOff(donateButton);
    }//GEN-LAST:event_donateButtonMouseExited

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        buttonOver(exitButton);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        buttonOff(exitButton);
    }//GEN-LAST:event_exitButtonMouseExited

    private void startButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMousePressed
        buttonPressed(startButton);
    }//GEN-LAST:event_startButtonMousePressed

    private void startButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseReleased
        buttonReleased(startButton);
    }//GEN-LAST:event_startButtonMouseReleased

    private void loadButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMousePressed
        buttonPressed(loadButton);
    }//GEN-LAST:event_loadButtonMousePressed

    private void loadButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseReleased
        buttonReleased(loadButton);
    }//GEN-LAST:event_loadButtonMouseReleased

    private void editButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMousePressed
        buttonPressed(editButton);
    }//GEN-LAST:event_editButtonMousePressed

    private void editButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseReleased
        buttonReleased(editButton);
    }//GEN-LAST:event_editButtonMouseReleased

    private void optsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMousePressed
        buttonPressed(optsButton);
    }//GEN-LAST:event_optsButtonMousePressed

    private void optsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMouseReleased
        buttonReleased(optsButton);
    }//GEN-LAST:event_optsButtonMouseReleased

    private void aboutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMousePressed
        buttonPressed(aboutButton);
    }//GEN-LAST:event_aboutButtonMousePressed

    private void aboutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseReleased
        buttonReleased(aboutButton);
    }//GEN-LAST:event_aboutButtonMouseReleased

    private void donateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMousePressed
        buttonPressed(donateButton);
    }//GEN-LAST:event_donateButtonMousePressed

    private void donateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMouseReleased
        buttonReleased(donateButton);
    }//GEN-LAST:event_donateButtonMouseReleased

    private void exitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMousePressed
        buttonPressed(exitButton);
    }//GEN-LAST:event_exitButtonMousePressed

    private void exitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseReleased
        buttonReleased(exitButton);
    }//GEN-LAST:event_exitButtonMouseReleased

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        try {
            startButton();
        } catch (IOException ex) {
            try {
                LogWriter.logFile("severe","Start Button Error.  Exception: " +
                        ex);
            } catch (IOException ex1) {
                //
            }
        }
    }//GEN-LAST:event_startButtonMouseClicked

    private void loadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseClicked
        if(loadButton.isEnabled()) {
            loadButton();
        }
    }//GEN-LAST:event_loadButtonMouseClicked

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        editButton();
    }//GEN-LAST:event_editButtonMouseClicked

    private void optsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMouseClicked
        try {
            optsButton();
        } catch (Exception ex) {
            //
        }
    }//GEN-LAST:event_optsButtonMouseClicked

    private void aboutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseClicked
        if(aboutButton.isEnabled()) {
            try {
                aboutButton();
            } catch (IOException ex) {
                try {
                    LogWriter.logFile("severe","About Button Error.  Exception: " +
                        ex);
                } catch (IOException ex1) {
                    //
                }
            }
        }
    }//GEN-LAST:event_aboutButtonMouseClicked

    private void donateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMouseClicked
        if(donateButton.isEnabled()) {
            try {
                donateButton();
            } catch (IOException ex) {
                try {
                    LogWriter.logFile("severe","Donate Button Error.  Exception: " +
                        ex);
                } catch (IOException ex1) {
                    //
                }
            }
        }
    }//GEN-LAST:event_donateButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        try {
            exitButton();
        } catch (IOException ex) {
            try {
                LogWriter.logFile("severe","Exit Button Error.  Exception: " + 
                    ex);
            } catch (IOException ex1) {
                //
            }
        }
    }//GEN-LAST:event_exitButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            MainControls.exitGame();
        } catch (IOException ex) {
            //
        } catch (InterruptedException ex) {
            try {
                LogWriter.logFile("severe","Main Windows Close Error.  "
                    + "Exception: " + ex);
            } catch (IOException ex1) {
                //
            }
        }
    }//GEN-LAST:event_formWindowClosing
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="NG Menu Buttons">       
    private void ngyesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngyesButtonMouseClicked
        buttonActive(ngyesButton);
        MainControls.startNewGame();
    }//GEN-LAST:event_ngyesButtonMouseClicked

    private void ngyesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngyesButtonMouseEntered
        buttonOver(ngyesButton);
    }//GEN-LAST:event_ngyesButtonMouseEntered

    private void ngyesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngyesButtonMouseExited
        buttonOff(ngyesButton);
    }//GEN-LAST:event_ngyesButtonMouseExited

    private void ngyesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngyesButtonMousePressed
        buttonPressed(ngyesButton);
    }//GEN-LAST:event_ngyesButtonMousePressed

    private void ngyesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngyesButtonMouseReleased
        buttonReleased(ngyesButton);
    }//GEN-LAST:event_ngyesButtonMouseReleased

    private void ngnoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngnoButtonMouseClicked
        try {
            showMenu();
        } catch (IOException ex) {
            try {
                LogWriter.logFile("severe","NG No Button Error.  Exception: " + 
                    ex);
            } catch (IOException ex1) {
                //
            }
        }
    }//GEN-LAST:event_ngnoButtonMouseClicked

    private void ngnoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngnoButtonMouseEntered
        buttonOver(ngnoButton);
    }//GEN-LAST:event_ngnoButtonMouseEntered

    private void ngnoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngnoButtonMouseExited
        buttonOff(ngnoButton);
    }//GEN-LAST:event_ngnoButtonMouseExited

    private void ngnoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngnoButtonMousePressed
        buttonPressed(ngnoButton);
    }//GEN-LAST:event_ngnoButtonMousePressed

    private void ngnoButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ngnoButtonMouseReleased
        buttonReleased(ngnoButton);
    }//GEN-LAST:event_ngnoButtonMouseReleased

    private void newPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPanelMouseEntered
        resetButtons();
        buttonActive(startButton);
    }//GEN-LAST:event_newPanelMouseEntered
    //</editor-fold>

    private void mcmOptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mcmOptMouseClicked
        buttonActive(mcmOpt);
        mcmButton(evt);
    }//GEN-LAST:event_mcmOptMouseClicked

    private void mcmOptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mcmOptMouseEntered
        buttonOver(mcmOpt);
    }//GEN-LAST:event_mcmOptMouseEntered

    private void mcmOptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mcmOptMouseExited
        buttonOff(mcmOpt);
    }//GEN-LAST:event_mcmOptMouseExited

    private void mcmOptMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mcmOptMousePressed
        buttonPressed(mcmOpt);
    }//GEN-LAST:event_mcmOptMousePressed

    private void mcmOptMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mcmOptMouseReleased
        buttonReleased(mcmOpt);
    }//GEN-LAST:event_mcmOptMouseReleased

    private void alOptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alOptMouseClicked
        buttonActive(alOpt);
        alButton(evt);
    }//GEN-LAST:event_alOptMouseClicked

    private void alOptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alOptMouseEntered
        buttonOver(alOpt);
    }//GEN-LAST:event_alOptMouseEntered

    private void alOptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alOptMouseExited
        buttonOff(alOpt);
    }//GEN-LAST:event_alOptMouseExited

    private void alOptMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alOptMousePressed
        buttonPressed(alOpt);
        alButton(evt);
    }//GEN-LAST:event_alOptMousePressed

    private void alOptMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alOptMouseReleased
        buttonReleased(alOpt);
    }//GEN-LAST:event_alOptMouseReleased

    private void darkOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_darkOptItemStateChanged
        OptionsMenu.setDarkMode(evt);
    }//GEN-LAST:event_darkOptItemStateChanged

    private void mOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mOptItemStateChanged
        OptionsMenu.setMusicMode(evt);
    }//GEN-LAST:event_mOptItemStateChanged

    private void cmOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmOptItemStateChanged
        OptionsMenu.setCustomMusic(evt);
    }//GEN-LAST:event_cmOptItemStateChanged

    private void imOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_imOptItemStateChanged
        try {
            if(imOpt.getSelectedIndex() == 0) {
                MainControls.custIntro = "";
            } else {
                MainControls.custIntro = imOpt.getSelectedItem().toString().
                    replaceAll("\\[Intro\\] ", "");
            }
            MainControls.updateSettings();
            mOpt.setSelected(false);
            Thread.sleep(1);
            mOpt.setSelected(true);
            
        } catch (Exception ex) {
            //
        }
    }//GEN-LAST:event_imOptItemStateChanged

    private void bmOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bmOptItemStateChanged
        try {
            if(bmOpt.getSelectedIndex() == 0) {
                MainControls.custBattle = "";
            } else {
                MainControls.custBattle = bmOpt.getSelectedItem().toString().
                    replaceAll("\\[Battle\\] ", "");
            }
            MainControls.updateSettings();
        } catch (Exception ex) {
            //
        }
    }//GEN-LAST:event_bmOptItemStateChanged

    private void vmOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vmOptItemStateChanged
        try {
            if(vmOpt.getSelectedIndex() == 0) {
                MainControls.custWin = "";
            } else {
                MainControls.custWin = vmOpt.getSelectedItem().toString().
                    replaceAll("\\[Victory\\] ", "");
            }
            MainControls.updateSettings();
        } catch (Exception ex) {
            //
        }
    }//GEN-LAST:event_vmOptItemStateChanged

    private void dmOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dmOptItemStateChanged
        try {
            if(dmOpt.getSelectedIndex() == 0) {
                MainControls.custLose = "";
            } else {
                MainControls.custLose = dmOpt.getSelectedItem().toString().
                    replaceAll("\\[Defeat\\] ", "");
            }
            MainControls.updateSettings();
        } catch (Exception ex) {
            //
        }
    }//GEN-LAST:event_dmOptItemStateChanged

    private void sOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sOptItemStateChanged
        OptionsMenu.setSoundMode(evt);
    }//GEN-LAST:event_sOptItemStateChanged

    private void sdbOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sdbOptItemStateChanged
        OptionsMenu.setDBMode(evt);
    }//GEN-LAST:event_sdbOptItemStateChanged

    private void social1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social1MouseClicked
        buttonActive(social1);
        try {
            GoToWeb.openWeb("https://www.facebook.com/clarktribe.games");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social1MouseClicked

    private void social1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social1MousePressed
        buttonPressed(social1);
    }//GEN-LAST:event_social1MousePressed

    private void social1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social1MouseReleased
        buttonReleased(social1);
    }//GEN-LAST:event_social1MouseReleased

    private void social2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social2MouseClicked
        buttonActive(social2);
        try {
            GoToWeb.openWeb("https://discord.gg/6kW4der");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social2MouseClicked

    private void social2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social2MousePressed
        buttonPressed(social2);
    }//GEN-LAST:event_social2MousePressed

    private void social2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social2MouseReleased
        buttonReleased(social2);
    }//GEN-LAST:event_social2MouseReleased

    private void social3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social3MouseClicked
        buttonActive(social3);
        try {
            GoToWeb.openWeb("https://www.youtube.com/channel/"
                + "UCjcPw3ApuFduiETIdmAhFAQ");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social3MouseClicked

    private void social3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social3MousePressed
        buttonPressed(social3);
    }//GEN-LAST:event_social3MousePressed

    private void social3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social3MouseReleased
        buttonReleased(social3);
    }//GEN-LAST:event_social3MouseReleased

    private void social4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social4MouseClicked
        buttonActive(social4);
        try {
            GoToWeb.openWeb("https://www.bensound.com/");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social4MouseClicked

    private void social4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social4MousePressed
        buttonPressed(social4);
        try {
            GoToWeb.openWeb("https://www.patreon.com/clarktribegames");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social4MousePressed

    private void social4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social4MouseReleased
        buttonReleased(social4);
    }//GEN-LAST:event_social4MouseReleased

    private void social5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social5MouseClicked
        buttonActive(social5);
    }//GEN-LAST:event_social5MouseClicked

    private void social5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social5MousePressed
        buttonPressed(social5);
        try {
            GoToWeb.openWeb("https://www.patreon.com/clarktribegames");
        } catch (IOException ex) {
            //
        }
    }//GEN-LAST:event_social5MousePressed

    private void social5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social5MouseReleased
        buttonReleased(social5);
    }//GEN-LAST:event_social5MouseReleased

    private void social6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social6MouseClicked
        buttonActive(social6);
        try {
            GoToWeb.openWeb("https://www.paypal.me/aznblusuazn");
        } catch (IOException ex) {
            //
        }        
    }//GEN-LAST:event_social6MouseClicked

    private void social6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social6MousePressed
        buttonPressed(social6);
    }//GEN-LAST:event_social6MousePressed

    private void social6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_social6MouseReleased
        buttonReleased(social6);
    }//GEN-LAST:event_social6MouseReleased

    private void lgyesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgyesButtonMouseClicked
        if(lgyesButton.isEnabled()) {
            loadSavedGame();
        }
    }//GEN-LAST:event_lgyesButtonMouseClicked

    private void lgyesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgyesButtonMouseEntered
        buttonOver(lgyesButton);
    }//GEN-LAST:event_lgyesButtonMouseEntered

    private void lgyesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgyesButtonMouseExited
        buttonOff(lgyesButton);
    }//GEN-LAST:event_lgyesButtonMouseExited

    private void lgyesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgyesButtonMousePressed
        buttonPressed(lgyesButton);
    }//GEN-LAST:event_lgyesButtonMousePressed

    private void lgyesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgyesButtonMouseReleased
        buttonReleased(lgyesButton);
    }//GEN-LAST:event_lgyesButtonMouseReleased

    private void lgnoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnoButtonMouseClicked
        if(lgnoButton.isEnabled()) {
            try {
                showMenu();
            } catch (IOException ex) {
                try {
                    LogWriter.logFile("severe","LG No Button Error.  Exception:"
                        + " " + ex);
                } catch (IOException ex1) {
                    //
                }
            }
        }
    }//GEN-LAST:event_lgnoButtonMouseClicked

    private void lgnoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnoButtonMouseEntered
        buttonOver(lgnoButton);
    }//GEN-LAST:event_lgnoButtonMouseEntered

    private void lgnoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnoButtonMouseExited
        buttonOff(lgnoButton);
    }//GEN-LAST:event_lgnoButtonMouseExited

    private void lgnoButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnoButtonMousePressed
        buttonPressed(lgnoButton);
    }//GEN-LAST:event_lgnoButtonMousePressed

    private void lgnoButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnoButtonMouseReleased
        buttonReleased(lgnoButton);
    }//GEN-LAST:event_lgnoButtonMouseReleased

    private void lgdelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgdelButtonMouseClicked
        if(lgdelButton.isEnabled()) {
            delSavedGame();
        }
    }//GEN-LAST:event_lgdelButtonMouseClicked

    private void lgdelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgdelButtonMouseEntered
        buttonOver(lgdelButton);
    }//GEN-LAST:event_lgdelButtonMouseEntered

    private void lgdelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgdelButtonMouseExited
        buttonOff(lgdelButton);
    }//GEN-LAST:event_lgdelButtonMouseExited

    private void lgdelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgdelButtonMousePressed
        buttonPressed(lgdelButton);
    }//GEN-LAST:event_lgdelButtonMousePressed

    private void lgdelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgdelButtonMouseReleased
        buttonReleased(lgdelButton);
    }//GEN-LAST:event_lgdelButtonMouseReleased

    private void lgListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lgListValueChanged
        if(lgList.isEnabled()) {
            try {
                GetData.getSavedGameToon(lgList,lgToon,lgToonName,lgToonRank,
                    lgToonStats,lgToonLevel);
            } catch (IOException | SQLException ex) {
                //
            }
        } else {
            lgToon.setIcon(null);
            lgToonName.setText("");
            lgToonRank.setText("");
            lgToonStats.setText("");
            lgToonLevel.setText("");
        }
    }//GEN-LAST:event_lgListValueChanged

    // <editor-fold defaultstate="collapsed" desc="Universal">       
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager
                .getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
            IllegalAccessException | UnsupportedLookAndFeelException ex) {
            //
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Limitless().setVisible(true);
                } catch (IOException ex) {
                    try {
                        LogWriter.logFile("severe","Initial Open Error.  "
                            + "Exception: " + ex);
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                }
            }
        });
    }

    private static void setTitleAvatars() throws IOException {
        try {
            ArrayList<Path> avatarList = (ArrayList<Path>) Avatars
                .startmenuAvatars();
            int listsize = avatarList.size();
            if(listsize > 0) {
                setAvatarBox(avatarList,mToon,0);
            }
            if(listsize > 1) {
                setAvatarBox(avatarList,tlToon,1);
            }
            if(listsize > 2) {
                setAvatarBox(avatarList,brToon,2);
            }
            if(listsize > 3) {
                setAvatarBox(avatarList,blToon,3);
            }
            if(listsize > 4) {
                setAvatarBox(avatarList,trToon,4);
            }
        } catch (IOException ex) {
            LogWriter.logFile("severe","Set Avatars Error.  Exception: " + ex);
        }
    }

    private static void setNGAvatars() throws IOException {
        try {
            ArrayList<Path> avatarList = (ArrayList<Path>) Avatars
                .startmenuAvatars();
            int listsize = avatarList.size();
            ngmToon.setVisible(false);
            ngtlToon.setVisible(false);
            ngtrToon.setVisible(false);
            if(listsize > 0) {
                setAvatarBox(avatarList,ngmToon,0);
                ngtlToon.setVisible(false);
                ngtrToon.setVisible(false);
            }
            if(listsize > 1) {
                ngmToon.setVisible(false);
                setAvatarBox(avatarList,ngtlToon,0);
                setAvatarBox(avatarList,ngtrToon,1);
            }
        } catch (IOException ex) {
            LogWriter.logFile("severe","Set Avatars Error.  Exception: " + ex);
        }
    }
    
    private static void setAvatarBox(ArrayList<Path> list,JLabel box,int num) {
        Avatars.setAvatar(box,(list.get(num).toString()).replaceAll(MainControls
            .imageDir.substring(0,MainControls.imageDir.length()-1) + "\\\\","")
            .replaceAll(".png",""), list.get(num).toString());
        box.setBorder(BorderFactory.createLineBorder(MainControls.textColor));
    }
   
    private static void buttonOver(JLabel button) {
        button.setForeground(Color.RED);
    }
    
    private static void buttonOff(JLabel button) {
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)
            );
        button.setForeground(MainControls.textColor);
    }
    
    private static void buttonPressed(JLabel button) {
        if(button.isEnabled()) {
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED
                ));
            button.setForeground(Color.BLUE);
        }
    }
    
    private static void buttonReleased(JLabel button) {
        if(button.isEnabled()) {
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)
                );
            button.setForeground(MainControls.textColor);
        }
    }
    
    private static void buttonActive(JLabel button) {
        if(button.isEnabled()) {
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            button.setForeground(Color.BLUE);
        }
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main Menu">       
    private static void resetButtons() {
        buttonReleased(startButton);
        buttonReleased(loadButton);
        buttonReleased(editButton);
        buttonReleased(optsButton);
        buttonReleased(aboutButton);
        buttonReleased(donateButton);
        buttonReleased(exitButton);
    }
    
    private static void startButton() throws IOException {
        showNewGame();
    }
    
    private static void loadButton() {
        showLoadGame();
        MainControls.saveGameMenu();
    }
    
    private static void editButton() {
        
    }
    
    private static void optsButton() throws InterruptedException, Exception {
        showOptions();
    }
    
    private static void aboutButton() throws IOException {
        showAbout();
        MainControls.currentlyTyping = false;
        aboutText();        
    }
    
    private static void donateButton() throws IOException {
        showDonate();
        MainControls.currentlyTyping = false;
        donateText();
    }
    
    private static void exitButton() throws IOException {
        try {
            MainControls.exitGame();
        } catch (IOException | InterruptedException ex) {
            LogWriter.logFile("severe","Exit Button Error.  Exception: " + ex);
        }
    }
    
    private static void savegameCheck() {
        if(!(ChecksBalances.checknoofSubdirs(MainControls.savesDir))) {
            loadButton.setText("  No Saved Games");
            loadButton.setEnabled(false);
        } else {
            loadButton.setText("  Continue Saved Game");
            loadButton.setEnabled(true);
        }
    }
    
    public static void showMenu() throws IOException {
        menuPanel.setVisible(true);
        titlePanel.setVisible(true);
        newPanel.setVisible(false);
        loadPanel.setVisible(false);
        optsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        donatePanel.setVisible(false);
        resetButtons();
        MainControls.savesDir = MainControls.defaultsavesDir;
        MainControls.turnonMusic(MainControls.checkforcustMusic("intro"),"intro"
            );
        try {
            setTitleAvatars();
        } catch (IOException ex) {
            LogWriter.logFile("severe", "Show Menu Error. Ex: " + ex);
        }
        savegameCheck();
    }
    
    private static void showNewGame() throws IOException {
        menuPanel.setVisible(true);
        titlePanel.setVisible(false);
        newPanel.setVisible(true);
        loadPanel.setVisible(false);
        optsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        donatePanel.setVisible(false);
        try {
            setNGAvatars();
        } catch (IOException ex) {
            LogWriter.logFile("severe", "Show NG Error. Ex: " + ex);
        }
        savegameCheck();
    }
    
    private static void showLoadGame() {
        menuPanel.setVisible(true);
        titlePanel.setVisible(false);
        newPanel.setVisible(false);
        loadPanel.setVisible(true);
        optsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        donatePanel.setVisible(false);
    }
    
    private static void showOptions() {
        menuPanel.setVisible(true);
        titlePanel.setVisible(false);
        newPanel.setVisible(false);
        loadPanel.setVisible(false);
        optsPanel.setVisible(true);
        aboutPanel.setVisible(false);
        donatePanel.setVisible(false);
        optionsState();
    }

    private static void showAbout() {
        menuPanel.setVisible(true);
        titlePanel.setVisible(false);
        newPanel.setVisible(false);
        loadPanel.setVisible(false);
        optsPanel.setVisible(false);
        aboutPanel.setVisible(true);
        donatePanel.setVisible(false);
    }    

    private static void showDonate() {
        menuPanel.setVisible(true);
        titlePanel.setVisible(false);
        newPanel.setVisible(false);
        loadPanel.setVisible(false);
        optsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        donatePanel.setVisible(true);
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Load Menu">
    private static void loadSavedGame() {
        MainControls.loadSavedGame();
    }
    
    private static void delSavedGame() {
        MainControls.delSavedGame();
        showLoadGame();
        MainControls.saveGameMenu();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Options Menu">
    private static void optionsState() {
        optionsCheckBox(MainControls.darkOn, darkOpt);
        optionsCheckBox(MainControls.musicOn, mOpt);
        optionsCheckBox(MainControls.custommusicOn, cmOpt);
        optionsButton(MainControls.custommusicOn, mcmOpt);
        optionsComboBox(MainControls.custommusicOn, imOpt);
        optionsComboBox(MainControls.custommusicOn, bmOpt);
        optionsComboBox(MainControls.custommusicOn, vmOpt);
        optionsComboBox(MainControls.custommusicOn, dmOpt);
        optionsCheckBox(MainControls.soundOn, sOpt);
        optionsCheckBox(MainControls.samedbOn, sdbOpt);
        optionsComboBox(MainControls.samedbOn, dbOpt);
        if(cmOpt.isEnabled()) {
            OptionsMenu.checkCustomMusicFirst();
        }
    }
    
    private static void alButton(MouseEvent e) {
        OptionsMenu.avatarLibrary(e);
    }

    private static void mcmButton(MouseEvent e) {
        if(mcmOpt.isEnabled()) {
            OptionsMenu.customMusicLibrary(e);
        }
    }
    
    private static void optionsCheckBox(boolean status, JCheckBox checkbox) {
        checkbox.setSelected(status);
    }

    private static void optionsComboBox(boolean status, JComboBox combobox) {
        combobox.setEnabled(status);
    }

    private static void optionsButton(boolean status, JLabel button) {
        button.setEnabled(status);
    }    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="About Menu">
    private static void aboutText() {
        if(!MainControls.currentlyTyping) {
            abouttextArea.setText("");
        String message = "This application was created by ClarkTribe Games.\n\n"
                + "It was the development of basically a one man team with "
                + "advice, suggestions, and feedback from friends and "
                + "colleagues.\n\nThis game is dedicated to the kids of the "
                + "creator.\n\nPlease consider supporting the cause with a "
                + "donation via the Donate To The Cause button.\n\n"
                + "The music was provided by BenSound.com. Please visit their "
                + "site for awesome tracks!\n\n"
                + "Thank you for your continued support!\n\n"
                + "- Geoff Clark @ ClarkTribeGames";
        SwingWorker<Void,Void> worker=new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() {
                MainControls.currentlyTyping=true;
                aboutButton.setEnabled(false);
                new TypeEffect(abouttextArea,message,3,false,null,null).start();
                MainControls.currentlyTyping=false;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    //
                }
                aboutButton.setEnabled(true);
                return null;
            }
            
        };
            worker.execute();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Donate Menu">
    private static void donateText() {
        if(!MainControls.currentlyTyping) {
            donatetextArea.setText("");
        String msg = "Welcome to Limitless!\n\nThis title is still\n"
                + "in development.  Please be patient.\n\n"
                + "You can become a Patreon or Donate if you want to \n"
                + "help support the cause.\n\n"
                + "Thanks! ~ Geoff Clark @ ClarkTribeGames";
        SwingWorker<Void,Void> worker=new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() {
                MainControls.currentlyTyping=true;
                donateButton.setEnabled(false);
                new TypeEffect(donatetextArea,msg,3,false,null,null).start();
                MainControls.currentlyTyping=false;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    //
                }
                donateButton.setEnabled(true);
                return null;
            }
            
        };
            worker.execute();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Exit Menu">

    //</editor-fold>    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel aboutButton;
    private static javax.swing.JPanel aboutPanel;
    private javax.swing.JLabel aboutTitle;
    private static javax.swing.JTextArea abouttextArea;
    private static javax.swing.JScrollPane abouttextPane;
    static javax.swing.JLabel alOpt;
    private static javax.swing.JLabel blToon;
    static javax.swing.JComboBox<String> bmOpt;
    private static javax.swing.JLabel brToon;
    static javax.swing.JCheckBox cmOpt;
    static javax.swing.JCheckBox darkOpt;
    static javax.swing.JComboBox<String> dbOpt;
    static javax.swing.JComboBox<String> dmOpt;
    private static javax.swing.JLabel donateButton;
    private static javax.swing.JPanel donatePanel;
    private javax.swing.JLabel donateTitle;
    private static javax.swing.JTextArea donatetextArea;
    private static javax.swing.JScrollPane donatetextPane;
    private static javax.swing.JLabel editButton;
    private static javax.swing.JLabel exitButton;
    static javax.swing.JComboBox<String> imOpt;
    public static javax.swing.JList<String> lgList;
    private javax.swing.JScrollPane lgPane;
    static javax.swing.JLabel lgToon;
    static javax.swing.JLabel lgToonLevel;
    static javax.swing.JLabel lgToonName;
    static javax.swing.JLabel lgToonRank;
    static javax.swing.JLabel lgToonStats;
    static javax.swing.JLabel lgdelButton;
    static javax.swing.JLabel lgnoButton;
    static javax.swing.JLabel lgyesButton;
    private static javax.swing.JLabel loadButton;
    private static javax.swing.JPanel loadPanel;
    static javax.swing.JCheckBox mOpt;
    private static javax.swing.JLabel mToon;
    static javax.swing.JLabel mcmOpt;
    private static javax.swing.JPanel menuPanel;
    private static javax.swing.JPanel newPanel;
    private static javax.swing.JLabel ngmToon;
    private static javax.swing.JLabel ngnoButton;
    private static javax.swing.JLabel ngtlToon;
    private static javax.swing.JLabel ngtrToon;
    private static javax.swing.JLabel ngyesButton;
    private static javax.swing.JLabel optsButton;
    private static javax.swing.JPanel optsPanel;
    private javax.swing.JLabel optsTitle;
    static javax.swing.JLabel optsTitle1;
    static javax.swing.JCheckBox sOpt;
    static javax.swing.JCheckBox sdbOpt;
    private static javax.swing.JLabel social1;
    private static javax.swing.JLabel social2;
    private static javax.swing.JLabel social3;
    private static javax.swing.JLabel social4;
    private static javax.swing.JLabel social5;
    private static javax.swing.JLabel social6;
    private static javax.swing.JLabel startButton;
    private javax.swing.JLabel titleLogo;
    private static javax.swing.JPanel titlePanel;
    private static javax.swing.JLabel tlToon;
    private static javax.swing.JLabel trToon;
    static javax.swing.JComboBox<String> vmOpt;
    // End of variables declaration//GEN-END:variables
}
