// <editor-fold defaultstate="collapsed" desc="Header Items">
package clarktribegames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * @version IN DEVELOPMENT
 * 
 */
//</editor-fold>

public class MainGUI extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="initialized variables">
    
    //Player 1 Vars
    int p1OGIndex = 0;
    String p1OGName = "";
    String p1OGRace = "";
    String p1OGClass = "";
    String p1OGAlign = "";
    //0
    int p1OGHP = 0;
    int p1OGAP = 0;
    int p1OGMP = 0;
    int p1OGAtt = 0;
    int p1OGStr = 0;
    int p1OGDef = 0;
    int p1OGSta = 0;
    int p1OGSpd = 0;
    int p1OGEva = 0;
    int p1OGDex = 0;
    int p1OGMys = 0;
    int p1OGMDf = 0;
    int p1OGMEv = 0;
    int p1OGWil = 0;
    int p1OGLck = 0;
    int p1OGChm = 0;
    int p1OGInt = 0;
    int p1OGFat = 0;
    int p1OGSol = 0;
    int p1OGDcy = 0;
    int p1OGWtM = 0;
    int p1OGSze = 0;
    int p1OGGen = 0;
    int p1OGAge = 0;
    int p1OGLv = 0;
    int p1OGExp = 0;
    int p1OGRep = 0;
    String p1OGBio = "";
    String p1OGImage = "";
    String p1OGStatus = "";
    String p1OGTextString = "";
    String p1OGfullBio = "";    
    
    int p1Index = 0;
    String p1Name = "";
    String p1Race = "";
    String p1Class = "";
    String p1Align = "";
    //0
    int p1HP = 0;
    int p1AP = 0;
    int p1MP = 0;
    int p1Att = 0;
    int p1Str = 0;
    int p1Def = 0;
    int p1Sta = 0;
    int p1Spd = 0;
    int p1Eva = 0;
    int p1Dex = 0;
    int p1Mys = 0;
    int p1MDf = 0;
    int p1MEv = 0;
    int p1Wil = 0;
    int p1Lck = 0;
    int p1Chm = 0;
    int p1Int = 0;
    int p1Fat = 0;
    int p1Sol = 0;
    int p1Dcy = 0;
    int p1WtM = 0;
    int p1Sze = 0;
    int p1Gen = 0;
    int p1Age = 0;
    int p1Lv = 0;
    int p1Exp = 0;
    int p1Rep = 0;
    String p1Bio = "";
    String p1Image = "";
    String p1Status = "";
    String p1TextString = "";
    String p1fullBio = "";
    
    //Player 2 Vars
    
    int p2OGIndex = 0;
    String p2OGName = "";
    String p2OGRace = "";
    String p2OGClass = "";
    String p2OGAlign = "";
    //0
    int p2OGHP = 0;
    int p2OGAP = 0;
    int p2OGMP = 0;
    int p2OGAtt = 0;
    int p2OGStr = 0;
    int p2OGDef = 0;
    int p2OGSta = 0;
    int p2OGSpd = 0;
    int p2OGEva = 0;
    int p2OGDex = 0;
    int p2OGMys = 0;
    int p2OGMDf = 0;
    int p2OGMEv = 0;
    int p2OGWil = 0;
    int p2OGLck = 0;
    int p2OGChm = 0;
    int p2OGInt = 0;
    int p2OGFat = 0;
    int p2OGSol = 0;
    int p2OGDcy = 0;
    int p2OGWtM = 0;
    int p2OGSze = 0;
    int p2OGGen = 0;
    int p2OGAge = 0;
    int p2OGLv = 0;
    int p2OGExp = 0;
    int p2OGRep = 0;
    String p2OGBio = "";
    String p2OGImage = "";
    String p2OGStatus = "";
    String p2OGTextString = "";
    String p2OGfullBio = "";
    
    int p2Index = 0;
    String p2Name = "";
    String p2Race = "";
    String p2Class = "";
    String p2Align = "";
    //0
    int p2HP = 0;
    int p2AP = 0;
    int p2MP = 0;
    int p2Att = 0;
    int p2Str = 0;
    int p2Def = 0;
    int p2Sta = 0;
    int p2Spd = 0;
    int p2Eva = 0;
    int p2Dex = 0;
    int p2Mys = 0;
    int p2MDf = 0;
    int p2MEv = 0;
    int p2Wil = 0;
    int p2Lck = 0;
    int p2Chm = 0;
    int p2Int = 0;
    int p2Fat = 0;
    int p2Sol = 0;
    int p2Dcy = 0;
    int p2WtM = 0;
    int p2Sze = 0;
    int p2Gen = 0;
    int p2Age = 0;
    int p2Lv = 0;
    int p2Exp = 0;
    int p2Rep = 0;
    String p2Bio = "";
    String p2Image = "";
    String p2Status = "";
    String p2TextString = "";
    String p2fullBio = "";
    
    //ToonList Vars
    List<String> toonList = null;
    DefaultComboBoxModel dml1 = new DefaultComboBoxModel();
    DefaultComboBoxModel dml2 = new DefaultComboBoxModel();
    
    //Player 1 Race Vars
    int r1Index = 0;
    String r1Name = "";
    String r1Desc = "";
    //0
    int r1HPx = 0;
    int r1APx = 0;
    int r1MPx = 0;
    int r1Attx = 0;
    int r1Strx = 0;
    int r1Defx = 0;
    int r1Stax = 0;
    int r1Spdx = 0;
    int r1Evax = 0;
    int r1Dexx = 0;
    int r1Mysx = 0;
    int r1Wilx = 0;
    int r1Lckx = 0;
    int r1Chmx = 0;
    int r1Intx = 0;
    int r1Fatx = 0;
    int r1Solx = 0;
    int r1Dcyx = 0;
    int r1WtMx = 0;
    int r1Szex = 0;
    int r1Genx = 0;
    int r1Agecap = 0;
    int r1Lvcap = 0;
    int r1Expx = 0;
    int r1Repx = 0;
    String r1Bio = "";
    
    //Player 2 Race Vars
    int r2Index = 0;
    String r2Name = "";
    String r2Desc = "";
    //0
    int r2HPx = 0;
    int r2APx = 0;
    int r2MPx = 0;
    int r2Attx = 0;
    int r2Strx = 0;
    int r2Defx = 0;
    int r2Stax = 0;
    int r2Spdx = 0;
    int r2Evax = 0;
    int r2Dexx = 0;
    int r2Mysx = 0;
    int r2Wilx = 0;
    int r2Lckx = 0;
    int r2Chmx = 0;
    int r2Intx = 0;
    int r2Fatx = 0;
    int r2Solx = 0;
    int r2Dcyx = 0;
    int r2WtMx = 0;
    int r2Szex = 0;
    int r2Genx = 0;
    int r2Agecap = 0;
    int r2Lvcap = 0;
    int r2Expx = 0;
    int r2Repx = 0;
    String r2Bio = "";
    
    //Player 1 Class Vars
    int c1Index = 0;
    String c1Name = "";
    String c1Desc = "";
    int c1HPx = 0;
    int c1APx = 0;
    int c1MPx = 0;
    int c1Attx = 0;
    int c1Strx = 0;
    int c1Defx = 0;
    int c1Stax = 0;
    int c1Spdx = 0;
    int c1Evax = 0;
    int c1Dexx = 0;
    int c1Mysx = 0;
    int c1Wilx = 0;
    int c1Lckx = 0;
    int c1Chmx = 0;
    int c1Intx = 0;
    int c1Fatx = 0;
    int c1Solx = 0;
    int c1Dcyx = 0;
    int c1WtMx = 0;
    int c1Szex = 0;
    int c1Genx = 0;
    int c1Agecap = 0;
    int c1Lvcap = 0;
    int c1Expx = 0;
    int c1Repx = 0;
    String c1Bio = "";
    
    //Player 2 Class Vars
    int c2Index = 0;
    String c2Name = "";
    String c2Desc = "";
    int c2HPx = 0;
    int c2APx = 0;
    int c2MPx = 0;
    int c2Attx = 0;
    int c2Strx = 0;
    int c2Defx = 0;
    int c2Stax = 0;
    int c2Spdx = 0;
    int c2Evax = 0;
    int c2Dexx = 0;
    int c2Mysx = 0;
    int c2Wilx = 0;
    int c2Lckx = 0;
    int c2Chmx = 0;
    int c2Intx = 0;
    int c2Fatx = 0;
    int c2Solx = 0;
    int c2Dcyx = 0;
    int c2WtMx = 0;
    int c2Szex = 0;
    int c2Genx = 0;
    int c2Agecap = 0;
    int c2Lvcap = 0;
    int c2Expx = 0;
    int c2Repx = 0;
    String c2Bio = "";
    
    //Player 1 Alignment Vars
    int align1Index = 0;
    String align1Name = "";
    String align1Desc = "";
    int align1Score = 0;
    String align1Bio = "";
    
    //Player 2 Alignment Vars
    int align2Index = 0;
    String align2Name = "";
    String align2Desc = "";
    int align2Score = 0;
    String align2Bio = "";
    
    //Player 1 Gender Vars
    int gender1Index = 0;
    String gender1Name = "";
    String gender1Desc = "";
    String gender1Bio = "";
    String gender1Pro = "";
    
    //Player 2 Gender Vars
    int gender2Index = 0;
    String gender2Name = "";
    String gender2Desc = "";
    String gender2Bio = "";
    String gender2Pro = "";
    
    //Player 1 Toon Ability Vars
    int tAbl1Index = 0;
    int tAbl1001 = 0;
    int tAbl1002 = 0;
    int tAbl1003 = 0;
    int tAbl1004 = 0;
    int tAbl1005 = 0;
    int tAbl1006 = 0;
    int tAbl1007 = 0;
    int tAbl1008 = 0;
    int tAbl1009 = 0;
    int tAbl1010 = 0;
    int tAbl1011 = 0;
    int tAbl1012 = 0;
    int tAbl1013 = 0;
    int tAbl1014 = 0;
    int tAbl1015 = 0;
    int tAbl1016 = 0;
    int tAbl1017 = 0;
    int tAbl1018 = 0;
    int tAbl1019 = 0;
    int tAbl1020 = 0;
    int tAbl1021 = 0;
    int tAbl1022 = 0;
    int tAbl1023 = 0;
    int tAbl1024 = 0;
    int tAbl1025 = 0;
    int tAbl1026 = 0;
    int tAbl1027 = 0;
    int tAbl1028 = 0;
    int tAbl1029 = 0;
    int tAbl1030 = 0;
    
    //Player 2 Toon Ability Vars
    int tAbl2Index = 0;
    int tAbl2001 = 0;
    int tAbl2002 = 0;
    int tAbl2003 = 0;
    int tAbl2004 = 0;
    int tAbl2005 = 0;
    int tAbl2006 = 0;
    int tAbl2007 = 0;
    int tAbl2008 = 0;
    int tAbl2009 = 0;
    int tAbl2010 = 0;
    int tAbl2011 = 0;
    int tAbl2012 = 0;
    int tAbl2013 = 0;
    int tAbl2014 = 0;
    int tAbl2015 = 0;
    int tAbl2016 = 0;
    int tAbl2017 = 0;
    int tAbl2018 = 0;
    int tAbl2019 = 0;
    int tAbl2020 = 0;
    int tAbl2021 = 0;
    int tAbl2022 = 0;
    int tAbl2023 = 0;
    int tAbl2024 = 0;
    int tAbl2025 = 0;
    int tAbl2026 = 0;
    int tAbl2027 = 0;
    int tAbl2028 = 0;
    int tAbl2029 = 0;
    int tAbl2030 = 0;
    
    //Player 1 Toon Effect Vars
    int tEff1Index = 0;
    String tEff1Code = "";
    
    //Player 2 Toon Effect Vars
    int tEff2Index = 0;
    String tEff2Code = "";
    
    //Player 1 Race Effect Vars
    int rEff1Index = 0;
    String rEff1Code = "";
    
     //Player 2 Race Effect Vars
    int rEff2Index = 0;
    String rEff2Code = "";
    
    //Player 1 Class Effect Vars
    int cEff1Index = 0;
    String cEff1Code = "";
    
     //Player 2 Race Effect Vars
    int cEff2Index = 0;
    String cEff2Code = "";
    
    
    //Status List Vars
    List<String> statusList = null;
    String comb1Code = "";
    String status1Info = "";
    String[] status1Field = null;
    String status1Name = "";
    String status1Color = "";
    String status1Desc = "";
    String status1Bio = "";
    String comb2Code = "";
    String status2Info = "";
    String[] status2Field = null;
    String status2Name = "";
    String status2Color = "";
    String status2Desc = "";
    String status2Bio = "";

    // </editor-fold>
    
    public MainGUI() throws InterruptedException, SQLException, IOException, URISyntaxException {
        initComponents();
        dbCheck();
        setLocationRelativeTo(null);
        welcomePlayer();
        popSelect();
//        new Randomizer().getRandom(100000);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1Toon = new javax.swing.JLabel();
        p1ToonName = new javax.swing.JLabel();
        p1Info1 = new javax.swing.JLabel();
        p1Info2 = new javax.swing.JLabel();
        p1Info3 = new javax.swing.JLabel();
        p1Info4 = new javax.swing.JLabel();
        p1Info5 = new javax.swing.JLabel();
        p1Select = new javax.swing.JComboBox<>();
        p1Pane = new javax.swing.JScrollPane();
        p1Text = new javax.swing.JTextPane();
        p1Pane2 = new javax.swing.JScrollPane();
        p1Text2 = new javax.swing.JTextPane();
        battlePane = new javax.swing.JScrollPane();
        battleText = new javax.swing.JTextArea();
        p2Toon = new javax.swing.JLabel();
        p2ToonName = new javax.swing.JLabel();
        p2Info1 = new javax.swing.JLabel();
        p2Info2 = new javax.swing.JLabel();
        p2Info3 = new javax.swing.JLabel();
        p2Info4 = new javax.swing.JLabel();
        p2Info5 = new javax.swing.JLabel();
        p2Select = new javax.swing.JComboBox<>();
        p2Pane = new javax.swing.JScrollPane();
        p2Text = new javax.swing.JTextPane();
        p2Pane2 = new javax.swing.JScrollPane();
        p2Text2 = new javax.swing.JTextPane();
        test1Button = new javax.swing.JButton();
        test2Button = new javax.swing.JButton();
        userInput = new javax.swing.JTextField();
        enterButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuOptions = new javax.swing.JMenu();
        menuDonate = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIMITLESS [Alpha]");
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setName("mainGUI"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Toon.setText("[Player 1 Image Here]");
        p1Toon.setFocusable(false);
        getContentPane().add(p1Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 200));

        p1ToonName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p1ToonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1ToonName.setText("Player 1");
        getContentPane().add(p1ToonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 18));

        p1Info1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p1Info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Info1.setFocusable(false);
        getContentPane().add(p1Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, 20));

        p1Info2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p1Info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Info2.setFocusable(false);
        getContentPane().add(p1Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 20));

        p1Info3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p1Info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Info3.setFocusable(false);
        getContentPane().add(p1Info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 200, 20));

        p1Info4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p1Info4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(p1Info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 200, 20));

        p1Info5.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p1Info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(p1Info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 200, 20));

        p1Select.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        p1Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 1" }));
        p1Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1SelectActionPerformed(evt);
            }
        });
        getContentPane().add(p1Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 200, -1));

        p1Text.setEditable(false);
        p1Text.setContentType("text/html"); // NOI18N
        p1Text.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p1Text.setFocusable(false);
        p1Pane.setViewportView(p1Text);

        getContentPane().add(p1Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 362, 200, 280));

        p1Text2.setEditable(false);
        p1Text2.setContentType("text/html"); // NOI18N
        p1Text2.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p1Text2.setFocusable(false);
        p1Pane2.setViewportView(p1Text2);

        getContentPane().add(p1Pane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 200, 110));

        battleText.setEditable(false);
        battleText.setColumns(20);
        battleText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        battleText.setLineWrap(true);
        battleText.setRows(5);
        battleText.setWrapStyleWord(true);
        battleText.setFocusable(false);
        battlePane.setViewportView(battleText);

        getContentPane().add(battlePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 274, 800, 430));

        p2Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Toon.setText("[Player 2 Image Here]");
        p2Toon.setFocusable(false);
        getContentPane().add(p2Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 200, 200));

        p2ToonName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p2ToonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2ToonName.setText("Player 2");
        getContentPane().add(p2ToonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 240, 200, 20));

        p2Info1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Info1.setFocusable(false);
        getContentPane().add(p2Info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 260, 200, 20));

        p2Info2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Info2.setFocusable(false);
        getContentPane().add(p2Info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, 200, 20));

        p2Info3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Info3.setFocusable(false);
        getContentPane().add(p2Info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 300, 200, 20));

        p2Info4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(p2Info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 200, 20));

        p2Info5.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p2Info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(p2Info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 200, 20));

        p2Select.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        p2Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 2" }));
        p2Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2SelectActionPerformed(evt);
            }
        });
        getContentPane().add(p2Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 200, -1));

        p2Text.setEditable(false);
        p2Text.setContentType("text/html"); // NOI18N
        p2Text.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p2Text.setFocusable(false);
        p2Pane.setViewportView(p2Text);

        getContentPane().add(p2Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 362, 200, 280));

        p2Text2.setEditable(false);
        p2Text2.setContentType("text/html"); // NOI18N
        p2Text2.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p2Text2.setFocusable(false);
        p2Pane2.setViewportView(p2Text2);

        getContentPane().add(p2Pane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 640, 200, 110));

        test1Button.setText("test1");
        test1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(test1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        test2Button.setText("test2");
        test2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(test2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        userInput.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });
        getContentPane().add(userInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 720, 720, -1));

        enterButton.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        enterButton.setText("Enter");
        getContentPane().add(enterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 720, 70, -1));

        menuOptions.setText("Options");

        menuDonate.setText("Donate");
        menuDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDonateActionPerformed(evt);
            }
        });
        menuOptions.add(menuDonate);

        menuAbout.setText("About");
        menuAbout.setEnabled(false);
        menuOptions.add(menuAbout);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuOptions.add(menuExit);

        menuBar.add(menuOptions);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Swing Item Actions">
    private void test1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test1ButtonActionPerformed
        try {
            changeP(1);
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
        lockSelect(p1Select);
        test1Button.setVisible(false);
    }//GEN-LAST:event_test1ButtonActionPerformed

    private void test2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test2ButtonActionPerformed
        try {
            changeP(2);
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
        lockSelect(p2Select);
        test2Button.setVisible(false);
    }//GEN-LAST:event_test2ButtonActionPerformed

    private void p1SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1SelectActionPerformed
        try {
            changeP(1);
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_p1SelectActionPerformed

    private void p2SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2SelectActionPerformed
        try {
            changeP(2);
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_p2SelectActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void menuDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDonateActionPerformed
        openWeb("https://www.paypal.me/AznBlusuazn");
    }//GEN-LAST:event_menuDonateActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.gc();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

//</editor-fold>    
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (InterruptedException | SQLException | IOException | 
                        URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void welcomePlayer() {
        String text = 
                "Welcome to LIMITLESS.  This is an alpha version of the ga"
                + "me, thus don't expect a whole lot.  It's a work in progress."
                + "  This is just filler text for something greater, much, much"
                + " later.\n\nEnjoy. - Geoff";
        new TypeEffect(battleText,text).start();
    }
    
    //<editor-fold defaultstate="collapsed" desc="db Methods">
    private void dbCheck() throws IOException {
        //String ogPath = "/db/default.dat";
        String ogPath = "db/data.accdb";
        String dbPath = "data.accdb";
        new FileCheck().dbCheck(ogPath,dbPath);
    }
            
    private List<String> dbQuery(String search,String table,String column, 
            String matchstr, boolean isitSingle) throws 
            SQLException {
        String list = "";
        if (!isitSingle) {
//            System.out.println("IT IS NOTTRUE");
                list = (new RunQuery().getSpecificRecord(search, table, column,
                        matchstr))
                .replaceAll("\\[", "").replaceAll("\\]","");
            } else {
//            System.out.println("IT IS TRUE");
        list = (new RunQuery().getSingleList(search, table, column))
                .replaceAll("\\[", "").replaceAll("\\]","");
        }
        String[] stringList = list.split(",");
        List<String> convertedList = Arrays.asList(stringList);
        return convertedList;
    }
    //</editor-fold>
    
    private void popSelect() throws SQLException {
        toonList = dbQuery("*","dbToonGame","toonName","", true);
        fillSelect(p1Select,(toonList),dml1);
        fillSelect(p2Select,(toonList),dml2);
    }
    
    private void fillSelect(JComboBox<String> player, List<String> list, 
            DefaultComboBoxModel dml) {
        Font font = player.getFont();
        DefaultListCellRenderer lrCenter;
        lrCenter = new DefaultListCellRenderer();
        lrCenter.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        lrCenter.setFont(font.deriveFont(Font.BOLD));
        for(int i = 0; i < list.size(); i++) {
            dml.addElement((list.get(i)));
        }
        player.setModel(dml);
        player.setRenderer(lrCenter);
    }

    //<editor-fold defaultstate="collapsed" desc="Set Players Code">
    public void setP1(String toonname) throws SQLException, BadLocationException {
        List<String> listP1OGStats = dbQuery("*","dbToons",
                "toonOGName",toonname, false);
        String[] p1OGField = ((listP1OGStats.toString()).substring(1,(listP1OGStats.
                toString()).length())).split(",");
        List<String> listP1Stats = dbQuery("*","dbToonGame","toonName",
                toonname, false);
        String[] p1Field = ((listP1Stats.toString()).substring(1,(listP1Stats.
                toString()).length())).split(",");
        p1OGIndex = Integer.parseInt(removeSpace(p1OGField[0]));
        p1OGName = removeSpace(p1OGField[1]);
        p1OGRace = removeSpace(p1OGField[2]);
        p1OGClass = removeSpace(p1OGField[3]);
        p1OGAlign = removeSpace(p1OGField[4]);
        //0
        p1OGHP = processInt(p1OGField[6]);   
        p1OGMP = processInt(p1OGField[7]);   
        p1OGAP = processInt(p1OGField[8]);   
        p1OGAtt = processInt(p1OGField[9]);  
        p1OGStr = processInt(p1OGField[10]); 
        p1OGDef = processInt(p1OGField[11]); 
        p1OGSta = processInt(p1OGField[12]); 
        p1OGSpd = processInt(p1OGField[13]); 
        p1OGEva = processInt(p1OGField[14]); 
        p1OGDex = processInt(p1OGField[15]); 
        p1OGMys = processInt(p1OGField[16]); 
        p1OGMDf = processInt(p1OGField[17]); 
        p1OGMEv = processInt(p1OGField[18]); 
        p1OGWil = processInt(p1OGField[19]); 
        p1OGLck = processInt(p1OGField[20]); 
        p1OGChm = processInt(p1OGField[21]); 
        p1OGInt = processInt(p1OGField[22]); 
        p1OGFat = processInt(p1OGField[23]); 
        p1OGSol = processInt(p1OGField[24]); 
        p1OGDcy = processInt(p1OGField[25]); 
        p1OGWtM = processInt(p1OGField[26]); 
        p1OGSze = processInt(p1OGField[27]); 
        p1OGGen = processInt(p1OGField[28]); 
        p1OGAge = processInt(p1OGField[29]); 
        p1OGLv = processInt(p1OGField[30]);  
        p1OGExp = processInt(p1OGField[31]); 
        p1OGRep = processInt(p1OGField[32]); 
        p1OGBio = removeSpace(p1OGField[33]);
        p1OGImage = removeSpace(p1OGField[34]).replace("]","");  
        
        p1Index = Integer.parseInt(removeSpace(p1Field[0]));
        p1Name = removeSpace(p1Field[1]);
        p1Race = removeSpace(p1Field[2]);
        p1Class = removeSpace(p1Field[3]);
        p1Align = removeSpace(p1Field[4]);
        //0
        p1HP = processInt(p1Field[6]);   
        p1MP = processInt(p1Field[7]);   
        p1AP = processInt(p1Field[8]);   
        p1Att = processInt(p1Field[9]);  
        p1Str = processInt(p1Field[10]); 
        p1Def = processInt(p1Field[11]); 
        p1Sta = processInt(p1Field[12]); 
        p1Spd = processInt(p1Field[13]); 
        p1Eva = processInt(p1Field[14]); 
        p1Dex = processInt(p1Field[15]); 
        p1Mys = processInt(p1Field[16]); 
        p1MDf = processInt(p1Field[17]); 
        p1MEv = processInt(p1Field[18]); 
        p1Wil = processInt(p1Field[19]); 
        p1Lck = processInt(p1Field[20]); 
        p1Chm = processInt(p1Field[21]); 
        p1Int = processInt(p1Field[22]); 
        p1Fat = processInt(p1Field[23]); 
        p1Sol = processInt(p1Field[24]); 
        p1Dcy = processInt(p1Field[25]); 
        p1WtM = processInt(p1Field[26]); 
        p1Sze = processInt(p1Field[27]); 
        p1Gen = processInt(p1Field[28]); 
        p1Age = processInt(p1Field[29]); 
        p1Lv = processInt(p1Field[30]);  
        p1Exp = processInt(p1Field[31]); 
        p1Rep = processInt(p1Field[32]); 
        p1Bio = removeSpace(p1Field[33]);
        p1Image = removeSpace(p1Field[34]).replace("]","");       
        p1Select.setSelectedIndex(p1Index - 1);
        p1ToonName.setText(p1Name + " (Lv. " + p1Lv + ")");
        getR1(p1Race);
        getC1(p1Class);
        getAlign1(p1Align);
        getG1(p1Gen);
        getTAbl1(p1Index);
        getTEff1(p1Index);
        getREff1(r1Index);
        getCEff1(c1Index);
        comb1Code = s2i2sSorted(tEff1Code + "-" + rEff1Code + "-" + cEff1Code);
        getStatus1(comb1Code);
//        System.out.println("Status Toon 1 Code: " + status1Name + " " + status1Color + " " + status1Desc + " " + status1Bio);
        p1Status = ("<html><b><font color=" + status1Color + ">"+ status1Name + "</font></b></html>");
        p1Info1.setText("(Age Modifier " + p1Age + ")");
        p1Info2.setText(r1Name + " " + c1Name);
        p1Info3.setText(align1Name + " (Rep: " + p1Rep + ")");
        p1Info4.setText("Size" + p1Sze +  " " + gender1Name);
        p1Info5.setText(p1Status);
        p1TextString = ("<center>Exp: &nbsp;" + p1Exp + "/" + ("MAX EXP"
                + " VALUE") + "<br><br>HP: &nbsp;" + p1HP + "/" + p1OGHP  + "<b"
                + "r>AP: &nbsp;" + p1AP + "/" + p1OGAP + "<br>MP: &nbsp;" + p1MP
                + "/" + p1OGMP + "<br><br>Attack: &nbsp;" + p1Att + "/" + 
                p1OGAtt + "<br>Strength: &nbsp;" + p1Str + "/" + p1OGStr + "<br"
                + ">Defense" + ": &nbsp;" + p1Def + "/" + p1OGDef + "<br>Stamin"
                + "a: &nbsp;"+ p1Sta + "/" + p1OGSta + "<br>Speed: &nbsp;" + 
                p1Spd + "/" + p1OGSpd +"<br>Evade: &nbsp;" + p1Eva + "/" + 
                p1OGEva + "<br>Dexterity: " + "&nbsp;" + p1Dex + "/" + p1OGDex +
                "<br>Mystic: &nbsp;" + p1Mys + ":" + p1MDf + ":" + p1MEv + "/" + p1OGMys + ":" + p1OGMDf + ":" + p1OGMEv + "<br>Willpower: "
                + "&nbsp;" + p1Wil + "/" + p1OGWil + "<br>Luck: &nbsp;" + p1Lck 
                + "/" + p1OGLck + "<br>Charm: &nbsp;" + p1Chm + "/" + p1OGChm + 
                "<br>Intellect: &nbsp;" + p1Int + "/" + p1OGInt + "<br>Fatigue:"
                + " &nbsp;" + p1Fat + "/" + p1OGFat + "<br>S&D (hidden): &"
                + "nbsp;" + p1Dcy + "/" + p1Sol + "</center>");
        p1Text.setText(p1TextString);
        p1fullBio = bioBuilder(p1Name, align1Bio, r1Bio, gender1Bio, c1Bio, 
                gender1Pro, status1Bio, p1Bio);
        p1Text2.setText(p1fullBio);
        new ToonImage().setImage(p1Toon,p1Image);
    }

    public void setP2(String toonname) throws SQLException {
        List<String> listP1OGStats = dbQuery("*","dbToons",
                "toonOGName",toonname, false);
        String[] p2OGField = ((listP1OGStats.toString()).substring(1,
                (listP1OGStats.toString()).length())).split(",");
        List<String> listP2Stats = dbQuery("*","dbToonGame",
                "toonName",toonname, false);
        String[] p2Field = ((listP2Stats.toString()).substring(1,(listP2Stats.
                toString()).length())).split(",");
        p2OGIndex = Integer.parseInt(removeSpace(p2OGField[0]));
        p2OGName = removeSpace(p2OGField[1]);
        p2OGRace = removeSpace(p2OGField[2]);
        p2OGClass = removeSpace(p2OGField[3]);
        p2OGAlign = removeSpace(p2OGField[4]);
        //0
        p2OGHP = processInt(p2OGField[6]);   
        p2OGMP = processInt(p2OGField[7]);   
        p2OGAP = processInt(p2OGField[8]);   
        p2OGAtt = processInt(p2OGField[9]);  
        p2OGStr = processInt(p2OGField[10]); 
        p2OGDef = processInt(p2OGField[11]); 
        p2OGSta = processInt(p2OGField[12]); 
        p2OGSpd = processInt(p2OGField[13]); 
        p2OGEva = processInt(p2OGField[14]); 
        p2OGDex = processInt(p2OGField[15]); 
        p2OGMys = processInt(p2OGField[16]); 
        p2OGMDf = processInt(p2OGField[17]); 
        p2OGMEv = processInt(p2OGField[18]); 
        p2OGWil = processInt(p2OGField[19]); 
        p2OGLck = processInt(p2OGField[20]); 
        p2OGChm = processInt(p2OGField[21]); 
        p2OGInt = processInt(p2OGField[22]); 
        p2OGFat = processInt(p2OGField[23]); 
        p2OGSol = processInt(p2OGField[24]); 
        p2OGDcy = processInt(p2OGField[25]); 
        p2OGWtM = processInt(p2OGField[26]); 
        p2OGSze = processInt(p2OGField[27]); 
        p2OGGen = processInt(p2OGField[28]); 
        p2OGAge = processInt(p2OGField[29]); 
        p2OGLv = processInt(p2OGField[30]);  
        p2OGExp = processInt(p2OGField[31]); 
        p2OGRep = processInt(p2OGField[32]); 
        p2OGBio = removeSpace(p2OGField[33]);
        p2OGImage = removeSpace(p2OGField[34]).replace("]","");  
        
        p2Index = Integer.parseInt(removeSpace(p2Field[0]));
        p2Name = removeSpace(p2Field[1]);
        p2Race = removeSpace(p2Field[2]);
        p2Class = removeSpace(p2Field[3]);
        p2Align = removeSpace(p2Field[4]);
        //0
        p2HP = processInt(p2Field[6]);   
        p2MP = processInt(p2Field[7]);   
        p2AP = processInt(p2Field[8]);   
        p2Att = processInt(p2Field[9]);  
        p2Str = processInt(p2Field[10]); 
        p2Def = processInt(p2Field[11]); 
        p2Sta = processInt(p2Field[12]); 
        p2Spd = processInt(p2Field[13]); 
        p2Eva = processInt(p2Field[14]); 
        p2Dex = processInt(p2Field[15]); 
        p2Mys = processInt(p2Field[16]); 
        p2MDf = processInt(p2Field[17]); 
        p2MEv = processInt(p2Field[18]); 
        p2Wil = processInt(p2Field[19]); 
        p2Lck = processInt(p2Field[20]); 
        p2Chm = processInt(p2Field[21]); 
        p2Int = processInt(p2Field[22]); 
        p2Fat = processInt(p2Field[23]); 
        p2Sol = processInt(p2Field[24]); 
        p2Dcy = processInt(p2Field[25]); 
        p2WtM = processInt(p2Field[26]); 
        p2Sze = processInt(p2Field[27]); 
        p2Gen = processInt(p2Field[28]); 
        p2Age = processInt(p2Field[29]); 
        p2Lv = processInt(p2Field[30]);  
        p2Exp = processInt(p2Field[31]); 
        p2Rep = processInt(p2Field[32]); 
        p2Bio = removeSpace(p2Field[33]);
        p2Image = removeSpace(p2Field[34]).replace("]","");        
        p2Select.setSelectedIndex(p2Index - 1);
        p2ToonName.setText(p2Name + " (Lv. " + p2Lv + ")");
        getR2(p2Race);
        getC2(p2Class);
        getAlign2(p2Align);
        getG2(p2Gen);
        getTAbl2(p2Index);
        getTEff2(p2Index);
        getREff2(r2Index);        
        getCEff2(c2Index);
        comb2Code = s2i2sSorted(tEff2Code + "-" + rEff2Code + "-" + cEff2Code);
        getStatus2(comb2Code);
//        System.out.println("Status Toon 2 Code: " + status2Name + " " + status2Color + " " + status2Desc + " " + status2Bio);
        p2Status = ("<html><b><font color=" + status2Color + ">"+ status2Name + "</font></b></html>");
        p2Info1.setText(" (Age Modifier " + p2Age + ") ");
        p2Info2.setText(r2Name + " " + c2Name);
        p2Info3.setText(align2Name + " (Rep: " + p2Rep + ")");
        p2Info4.setText("Size" + p2Sze +  " " + gender2Name);
        p2Info5.setText(p2Status);
        p2TextString = ("<center>Exp: &nbsp;" + p2Exp + "/" + ("MAX EXP"
                + " VALUE") + "<br><br>HP: &nbsp;" + p2HP + "/" + p2OGHP  + "<b"
                + "r>AP: &nbsp;" + p2AP + "/" + p2OGAP + "<br>MP: &nbsp;" + p2MP
                + "/" + p2OGMP + "<br><br>Attack: &nbsp;" + p2Att + "/" + 
                p2OGAtt + "<br>Strength: &nbsp;" + p2Str + "/" + p2OGStr + "<br"
                + ">Defense" + ": &nbsp;" + p2Def + "/" + p2OGDef + "<br>Stamin"
                + "a: &nbsp;"+ p2Sta + "/" + p2OGSta + "<br>Speed: &nbsp;" + 
                p2Spd + "/" + p2OGSpd +"<br>Evade: &nbsp;" + p2Eva + "/" + 
                p2OGEva + "<br>Dexterity: " + "&nbsp;" + p2Dex + "/" + p2OGDex +
                "<br>Mystic: &nbsp;" + p2Mys + ":" + p2MDf + ":" + p2MEv + "/" + p2OGMys + ":" + p2OGMDf + ":" + p2OGMEv + "<br>Willpower: "
                + "&nbsp;" + p2Wil + "/" + p2OGWil + "<br>Luck: &nbsp;" + p2Lck 
                + "/" + p2OGLck + "<br>Charm: &nbsp;" + p2Chm + "/" + p2OGChm + 
                "<br>Intellect: &nbsp;" + p2Int + "/" + p2OGInt + "<br>Fatigue:"
                + " &nbsp;" + p2Fat + "/" + p2OGFat + "<br>S&D (hidden): &"
                + "nbsp;" + p2Dcy + "/" + p2Sol + "</center>");
        p2fullBio = bioBuilder(p2Name, align2Bio, r2Bio, gender2Bio, c2Bio, 
                gender2Pro, status2Bio, p2Bio);
        p2Text2.setText(p2fullBio);
        p2Text.setText(p2TextString);
        new ToonImage().setImage(p2Toon,p2Image);
    }
    
    private void changeP(int p) throws SQLException, BadLocationException {
        if(p == 1)
            setP1((String) p1Select.getSelectedItem());
        if(p == 2)
            setP2((String) p2Select.getSelectedItem());
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get Race/Class/Align Code">    
    public void getR1(String raceid) throws SQLException {
        List<String> r1Stats = dbQuery("*","dbRace","raceID",
                raceid, false);
        String[] r1Field = ((r1Stats.toString()).substring(1,(r1Stats.
                toString()).length())).split(",");
        r1Index = Integer.parseInt(removeSpace(r1Field[0]));
        r1Name = removeSpace(r1Field[1]);
        r1Desc = removeSpace(r1Field[2]);
        //0
        r1HPx = processInt(r1Field[4]);
        r1MPx = processInt(r1Field[5]);
        r1APx = processInt(r1Field[6]);
        r1Attx = processInt(r1Field[7]);
        r1Strx = processInt(r1Field[8]);
        r1Defx = processInt(r1Field[9]);
        r1Stax = processInt(r1Field[10]);
        r1Spdx = processInt(r1Field[11]);
        r1Evax = processInt(r1Field[12]);
        r1Dexx = processInt(r1Field[13]);
        r1Mysx = processInt(r1Field[14]);
        r1Wilx = processInt(r1Field[15]);
        r1Lckx = processInt(r1Field[16]);
        r1Chmx = processInt(r1Field[17]);
        r1Intx = processInt(r1Field[18]);
        r1Fatx = processInt(r1Field[19]);
        r1Solx = processInt(r1Field[20]);
        r1Dcyx = processInt(r1Field[21]);
        r1WtMx = processInt(r1Field[22]);
        r1Szex = processInt(r1Field[23]);
        r1Genx = processInt(r1Field[24]);
        r1Agecap = processInt(r1Field[25]);
        r1Lvcap = processInt(r1Field[26]);
        r1Expx = processInt(r1Field[27]);
        r1Repx = processInt(r1Field[28]);
        r1Bio = removeSpace(r1Field[29]).replace("]","");
    }
    
    public void getR2(String raceid) throws SQLException {
        List<String> r2Stats = dbQuery("*","dbRace","raceID",
                raceid, false);
        String[] r2Field = ((r2Stats.toString()).substring(1,(r2Stats.
                toString()).length())).split(",");
        r2Index = Integer.parseInt(removeSpace(r2Field[0]));
        r2Name = removeSpace(r2Field[1]);
        r2Desc = removeSpace(r2Field[2]);
        //0
        r2HPx = processInt(r2Field[4]);
        r2MPx = processInt(r2Field[5]);
        r2APx = processInt(r2Field[6]);
        r2Attx = processInt(r2Field[7]);
        r2Strx = processInt(r2Field[8]);
        r2Defx = processInt(r2Field[9]);
        r2Stax = processInt(r2Field[10]);
        r2Spdx = processInt(r2Field[11]);
        r2Evax = processInt(r2Field[12]);
        r2Dexx = processInt(r2Field[13]);
        r2Mysx = processInt(r2Field[14]);
        r2Wilx = processInt(r2Field[15]);
        r2Lckx = processInt(r2Field[16]);
        r2Chmx = processInt(r2Field[17]);
        r2Intx = processInt(r2Field[18]);
        r2Fatx = processInt(r2Field[19]);
        r2Solx = processInt(r2Field[20]);
        r2Dcyx = processInt(r2Field[21]);
        r2WtMx = processInt(r2Field[22]);
        r2Szex = processInt(r2Field[23]);
        r2Genx = processInt(r2Field[24]);
        r2Agecap = processInt(r2Field[25]);
        r2Lvcap = processInt(r2Field[26]);
        r2Expx = processInt(r2Field[27]);
        r2Repx = processInt(r2Field[28]);
        r2Bio = removeSpace(r2Field[29]).replace("]","");
    }

    public void getC1(String classid) throws SQLException {
        List<String> c1Stats = dbQuery("*","dbClass","classID ",
                classid, false);
        String[] c1Field = ((c1Stats.toString()).substring(1,(c1Stats.
                toString()).length())).split(",");
        c1Index = Integer.parseInt(removeSpace(c1Field[0]));
        c1Name = removeSpace(c1Field[1]);
        c1Desc = removeSpace(c1Field[2]);
        //0
        c1HPx = processInt(c1Field[4]);
        c1MPx = processInt(c1Field[5]);
        c1APx = processInt(c1Field[6]);
        c1Attx = processInt(c1Field[7]);
        c1Strx = processInt(c1Field[8]);
        c1Defx = processInt(c1Field[9]);
        c1Stax = processInt(c1Field[10]);
        c1Spdx = processInt(c1Field[11]);
        c1Evax = processInt(c1Field[12]);
        c1Dexx = processInt(c1Field[13]);
        c1Mysx = processInt(c1Field[14]);
        c1Wilx = processInt(c1Field[15]);
        c1Lckx = processInt(c1Field[16]);
        c1Chmx = processInt(c1Field[17]);
        c1Intx = processInt(c1Field[18]);
        c1Fatx = processInt(c1Field[19]);
        c1Solx = processInt(c1Field[20]);
        c1Dcyx = processInt(c1Field[21]);
        c1WtMx = processInt(c1Field[22]);
        c1Szex = processInt(c1Field[23]);
        c1Genx = processInt(c1Field[24]);
        c1Agecap = processInt(c1Field[25]);
        c1Lvcap = processInt(c1Field[26]);
        c1Expx = processInt(c1Field[27]);
        c1Repx = processInt(c1Field[28]);
        c1Bio = removeSpace(c1Field[29]).replace("]","");
    }
    
    public void getC2(String classid) throws SQLException {
        List<String> c2Stats = dbQuery("*","dbClass","classID ",
                classid, false);
        String[] c2Field = ((c2Stats.toString()).substring(1,(c2Stats.
                toString()).length())).split(",");
        c2Index = Integer.parseInt(removeSpace(c2Field[0]));
        c2Name = removeSpace(c2Field[1]);
        c2Desc = removeSpace(c2Field[2]);
         //0
        c2HPx = processInt(c2Field[4]);
        c2MPx = processInt(c2Field[5]);
        c2APx = processInt(c2Field[6]);
        c2Attx = processInt(c2Field[7]);
        c2Strx = processInt(c2Field[8]);
        c2Defx = processInt(c2Field[9]);
        c2Stax = processInt(c2Field[10]);
        c2Spdx = processInt(c2Field[11]);
        c2Evax = processInt(c2Field[12]);
        c2Dexx = processInt(c2Field[13]);
        c2Mysx = processInt(c2Field[14]);
        c2Wilx = processInt(c2Field[15]);
        c2Lckx = processInt(c2Field[16]);
        c2Chmx = processInt(c2Field[17]);
        c2Intx = processInt(c2Field[18]);
        c2Fatx = processInt(c2Field[19]);
        c2Solx = processInt(c2Field[20]);
        c2Dcyx = processInt(c2Field[21]);
        c2WtMx = processInt(c2Field[22]);
        c2Szex = processInt(c2Field[23]);
        c2Genx = processInt(c2Field[24]);
        c2Agecap = processInt(c2Field[25]);
        c2Lvcap = processInt(c2Field[26]);
        c2Expx = processInt(c2Field[27]);
        c2Repx = processInt(c2Field[28]);
        c2Bio = removeSpace(c2Field[29]).replace("]","");
    }

    public void getAlign1(String alignid) throws SQLException {
        List<String> align1Stats = dbQuery("*","dbAlign","alignID",
                alignid, false);
        String[] align1Field = ((align1Stats.toString()).substring(1,(align1Stats.
                toString()).length())).split(",");
        align1Index = Integer.parseInt(removeSpace(align1Field[0]));
        align1Name = removeSpace(align1Field[1]);
        align1Desc = removeSpace(align1Field[2]);
        align1Score = processInt(removeSpace(align1Field[3]));
        align1Bio = removeSpace(align1Field[29]).replace("]","");
    }
    
    public void getAlign2(String alignid) throws SQLException {
        List<String> align2Stats = dbQuery("*","dbAlign","alignID",
                alignid, false);
        String[] align2Field = ((align2Stats.toString()).substring(1,(align2Stats.
                toString()).length())).split(",");
        align2Index = Integer.parseInt(removeSpace(align2Field[0]));
        align2Name = removeSpace(align2Field[1]);
        align2Desc = removeSpace(align2Field[2]);
        align2Score = processInt(removeSpace(align2Field[3]));
        align2Bio = removeSpace(align2Field[29]).replace("]","");
    }
    
    public void getG1(int genderid) throws SQLException {
        List<String> gender1Stats = dbQuery("*","dbGender","genderID ",
                (String.valueOf(genderid)), false);
        String[] gender1Field = ((gender1Stats.toString()).substring(1,(gender1Stats.
                toString()).length())).split(",");
        gender1Index = Integer.parseInt(removeSpace(gender1Field[0]));
        gender1Name = removeSpace(gender1Field[1]);
        gender1Desc = removeSpace(gender1Field[2]);
        gender1Bio = removeSpace(gender1Field[29]);
        gender1Pro = removeSpace(gender1Field[30]).replace("]","");
    }
    
    public void getG2(int genderid) throws SQLException {
        List<String> gender2Stats = dbQuery("*","dbGender","genderID ",
                String.valueOf(genderid) , false);
        String[] gender2Field = ((gender2Stats.toString()).substring(1,(gender2Stats.
                toString()).length())).split(",");
        gender2Index = Integer.parseInt(removeSpace(gender2Field[0]));
        gender2Name = removeSpace(gender2Field[1]);
        gender2Desc = removeSpace(gender2Field[2]);
        gender2Bio = removeSpace(gender2Field[29]);
        gender2Pro = removeSpace(gender2Field[30]).replace("]","");
    }
    
    public void getTAbl1(int toonid) throws SQLException {
        List<String> tAbl1Stats = dbQuery("*","dbToonAbl","toonID",
                String.valueOf(toonid), false);
        String[] tAbl1Field = ((tAbl1Stats.toString()).substring(1,(tAbl1Stats.
                toString()).length())).split(",");
        tAbl1Index = Integer.parseInt(removeSpace(tAbl1Field[0]));
        tAbl1001 = processInt(tAbl1Field[1]);
        tAbl1002 = processInt(tAbl1Field[2]);
        tAbl1003 = processInt(tAbl1Field[3]);
        tAbl1004 = processInt(tAbl1Field[4]);
        tAbl1005 = processInt(tAbl1Field[5]);
        tAbl1006 = processInt(tAbl1Field[6]);
        tAbl1007 = processInt(tAbl1Field[7]);
        tAbl1008 = processInt(tAbl1Field[8]);
        tAbl1009 = processInt(tAbl1Field[9]);
        tAbl1010 = processInt(tAbl1Field[10]);
        tAbl1011 = processInt(tAbl1Field[11]);
        tAbl1012 = processInt(tAbl1Field[12]);
        tAbl1013 = processInt(tAbl1Field[13]);
        tAbl1014 = processInt(tAbl1Field[14]);
        tAbl1015 = processInt(tAbl1Field[15]);
        tAbl1016 = processInt(tAbl1Field[16]);
        tAbl1017 = processInt(tAbl1Field[17]);
        tAbl1018 = processInt(tAbl1Field[18]);
        tAbl1019 = processInt(tAbl1Field[19]);
        tAbl1020 = processInt(tAbl1Field[20]);
        tAbl1021 = processInt(tAbl1Field[21]);
        tAbl1022 = processInt(tAbl1Field[22]);
        tAbl1023 = processInt(tAbl1Field[23]);
        tAbl1024 = processInt(tAbl1Field[24]);
        tAbl1025 = processInt(tAbl1Field[25]);
        tAbl1026 = processInt(tAbl1Field[26]);
        tAbl1027 = processInt(tAbl1Field[27]);
        tAbl1028 = processInt(tAbl1Field[28]);
        tAbl1029 = processInt(tAbl1Field[29]);
        tAbl1030 = processInt(tAbl1Field[30]);
    }    
    
    public void getTAbl2(int toonid) throws SQLException {
        List<String> tAbl2Stats = dbQuery("*","dbToonAbl","toonID",
                String.valueOf(toonid), false);
        String[] tAbl2Field = ((tAbl2Stats.toString()).substring(1,(tAbl2Stats.
                toString()).length())).split(",");
        tAbl2Index = Integer.parseInt(removeSpace(tAbl2Field[0]));
        tAbl2001 = processInt(tAbl2Field[1]);
        tAbl2002 = processInt(tAbl2Field[2]);
        tAbl2003 = processInt(tAbl2Field[3]);
        tAbl2004 = processInt(tAbl2Field[4]);
        tAbl2005 = processInt(tAbl2Field[5]);
        tAbl2006 = processInt(tAbl2Field[6]);
        tAbl2007 = processInt(tAbl2Field[7]);
        tAbl2008 = processInt(tAbl2Field[8]);
        tAbl2009 = processInt(tAbl2Field[9]);
        tAbl2010 = processInt(tAbl2Field[10]);
        tAbl2011 = processInt(tAbl2Field[11]);
        tAbl2012 = processInt(tAbl2Field[12]);
        tAbl2013 = processInt(tAbl2Field[13]);
        tAbl2014 = processInt(tAbl2Field[14]);
        tAbl2015 = processInt(tAbl2Field[15]);
        tAbl2016 = processInt(tAbl2Field[16]);
        tAbl2017 = processInt(tAbl2Field[17]);
        tAbl2018 = processInt(tAbl2Field[18]);
        tAbl2019 = processInt(tAbl2Field[19]);
        tAbl2020 = processInt(tAbl2Field[20]);
        tAbl2021 = processInt(tAbl2Field[21]);
        tAbl2022 = processInt(tAbl2Field[22]);
        tAbl2023 = processInt(tAbl2Field[23]);
        tAbl2024 = processInt(tAbl2Field[24]);
        tAbl2025 = processInt(tAbl2Field[25]);
        tAbl2026 = processInt(tAbl2Field[26]);
        tAbl2027 = processInt(tAbl2Field[27]);
        tAbl2028 = processInt(tAbl2Field[28]);
        tAbl2029 = processInt(tAbl2Field[29]);
        tAbl2030 = processInt(tAbl2Field[30]);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Get Effect Code">    

    
    public void getTEff1(int toonid) throws SQLException {
        List<String> tEff1Stats = dbQuery("*","dbToonEffects","toonID",
                String.valueOf(toonid), false);
        String[] tEff1Field = ((tEff1Stats.toString()).substring(1,(tEff1Stats.
                toString()).length())).split(",");
        tEff1Index = Integer.parseInt(removeSpace(tEff1Field[0]));
        tEff1Code = getEffCode(tEff1Field);
    }    
    
    public void getTEff2(int toonid) throws SQLException {
        List<String> tEff2Stats = dbQuery("*","dbToonEffects","toonID",
                String.valueOf(toonid), false);
        String[] tEff2Field = ((tEff2Stats.toString()).substring(1,(tEff2Stats.
                toString()).length())).split(",");
        tEff2Index = Integer.parseInt(removeSpace(tEff2Field[0]));
        tEff2Code = getEffCode(tEff2Field);
    }

    public void getREff1(int raceid) throws SQLException {
        List<String> rEff1Stats = dbQuery("*","dbRaceEffects","raceID",
                String.valueOf(raceid), false);
        String[] rEff1Field = ((rEff1Stats.toString()).substring(1,(rEff1Stats.
                toString()).length())).split(",");
        rEff1Index = Integer.parseInt(removeSpace(rEff1Field[0]));
        rEff1Code = getEffCode(rEff1Field);
    }    
    
    public void getREff2(int raceid) throws SQLException {
        List<String> rEff2Stats = dbQuery("*","dbRaceEffects","raceID",
                String.valueOf(raceid), false);
        String[] rEff2Field = ((rEff2Stats.toString()).substring(1,(rEff2Stats.
                toString()).length())).split(",");
        rEff2Index = Integer.parseInt(removeSpace(rEff2Field[0]));
        rEff2Code = getEffCode(rEff2Field);
    }
  
    public void getCEff1(int classid) throws SQLException {
        List<String> cEff1Stats = dbQuery("*","dbClassEffects","classID",
                String.valueOf(classid), false);
        String[] cEff1Field = ((cEff1Stats.toString()).substring(1,(cEff1Stats.
                toString()).length())).split(",");
        cEff1Index = Integer.parseInt(removeSpace(cEff1Field[0]));
        cEff1Code = getEffCode(cEff1Field);
    }    
    
    public void getCEff2(int classid) throws SQLException {
        List<String> cEff2Stats = dbQuery("*","dbClassEffects","classID",
                String.valueOf(classid), false);
        String[] cEff2Field = ((cEff2Stats.toString()).substring(1,(cEff2Stats.
                toString()).length())).split(",");
        cEff2Index = Integer.parseInt(removeSpace(cEff2Field[0]));
        cEff2Code = getEffCode(cEff2Field);
    }
    
    private String getEffCode(String [] array) {
        String code = "";
        for(int i = 1; i < (array.length - 1); i++) {
             code += (processInt(array[i])) + "-";
        }
        String preCode = code.substring(0, code.length() - 1);
        String finalCode = preCode.replaceAll("-0", "");
        return finalCode;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get Status Code">        
    public void getStatus1(String effectcode) throws SQLException {
        System.out.println("Effect Code 1 is: " + effectcode);
        status1Info = getStatusInfo(effectcode);
        status1Field = (status1Info.split(","));
        status1Name = removeSpace(status1Field[0]);
        status1Color = removeSpace(status1Field[1]);
        status1Desc = removeSpace(status1Field[2]);
        status1Bio = removeSpace(status1Field[3]);
//        System.out.println(status1Name + " " + status1Color + " " + status1Desc + " " + status1Bio);
    } 
    
    public void getStatus2(String effectcode) throws SQLException {
        System.out.println("Effect Code 2 is: " + effectcode);
        status2Info = getStatusInfo(effectcode);
        status2Field = (status2Info.split(","));
        status2Name = removeSpace(status2Field[0]);
        status2Color = removeSpace(status2Field[1]);
        status2Desc = removeSpace(status2Field[2]);
        status2Bio = removeSpace(status2Field[3]);
//        System.out.println(status2Name + " " + status2Color + " " + status2Desc + " " + status2Bio);
    }

    private String getStatusInfo(String effectcode) throws SQLException {
        List<String> tempStatusArray = new ArrayList<>();
        int totalLines = (((dbQuery("*","dbStatus","statusID","",true)).
                toString()).split(",")).length;
        for (int i = 0; i < (totalLines); i++) {
            List<String> tempStats = dbQuery("*","dbStatus","statusID",String.valueOf(i+1), false);
            String[] tempField = ((tempStats.toString()).substring(1,(tempStats.
                toString()).length())).split(",");
            int tempID = processInt(tempField[0]);
            String tempRate = removeSpace(tempField[5]);
            String tempCode = getStatusCode(tempField);
            int tempCheck = effectcode.indexOf(tempCode);
            if(tempCheck == 0) {
                int tempLength = tempStatusArray.size();
                tempStatusArray.add(tempLength,(tempID + "," + tempRate));
            }   
        }
        String[] tempStatusArray2 = ((tempStatusArray.toString()).substring(1,
                (tempStatusArray.toString()).length()-1)).split(",");
//        int tempNewLeng = (tempStatusArray2.length-1) * 2;
        int tempNewLeng = tempStatusArray2.length;
        List<Integer> tempFinalArray = new ArrayList<>();
        int max = 0;
        int lineno = 0;
        for (int j = 0; j < tempNewLeng; j++) {
            if(j%2 == 0) {
                tempFinalArray.add(processInt(tempStatusArray2[j+1]));
            }
            for(int k = 0; k < tempFinalArray.size() ; k++) {
                if(tempFinalArray.get(k) > max) {
                    max = tempFinalArray.get(k);
                    lineno = k;
                }
            }
        }
        List<String> finalStats = dbQuery("*","dbStatus","statusID",
                    String.valueOf(tempStatusArray2[lineno]), false);
            String[] finalField = ((finalStats.toString()).substring(1,
                    (finalStats.toString()).length())).split(",");
            String finalName = removeSpace(finalField[1]);
            String finalColor = removeSpace(finalField[2]);
            String finalDesc = removeSpace(finalField[3]);
            String finalBio = removeSpace(finalField[4]);
        String finalStatus = (finalName + "," + finalColor + "," + finalDesc + 
                "," + finalBio);
        return finalStatus;
    }

    private String getStatusCode(String [] array) {
        String code = "";
        for(int i = 6; i < (array.length - 1); i++) {
             code += (processInt(array[i])) + "-";
        }
        String preCode = code.substring(0, code.length() - 1);
        String finalCode = preCode.replaceAll("-0", "");
        return finalCode;
    }
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="hideDDArrow (inactive)"> 
//    private void hideDDArrow(JComboBox<String> box) {
//        box.setUI(new BasicComboBoxUI() { 
//        protected JButton createArrowButton() {
//            return new JButton() {
//                public int getWidth() {
//                    return 0;
//                    }
//                @Override
//                public synchronized void addMouseListener(MouseListener l) {
//                }
//            };
//        }
//        });
//        
//    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Drop Effects"> 
    private void dropOn(JComboBox<String> box) {
        box.setEnabled(true);
        box.setBackground(new Color(214,217,223));
        box.setFont((box.getFont().deriveFont(Font.PLAIN)));
    }
    
    private void dropOff(JComboBox<String> box) {
        box.setVisible(false);
        
    
    }

    private void lockSelect(JComboBox<String> dropdown) {
        dropOff(dropdown);
    }
    //</editor-fold>
    
    private String removeSpace(String s) {
        char c = s.charAt(0);
        if(c == ' ') {
            s = s.substring(1);
        }
        return s;
    }
    
    private int processInt(String s) {
        if (s == null || s.isEmpty() || removeSpace(s) == null || 
                (removeSpace(s).equalsIgnoreCase("null"))) {
            return 0;
        } else {
            return (Integer.parseInt(removeSpace(s)));
        }
    }
    
    private String s2i2sSorted(String string) {
        String[] readyConvert = (string).split("-");
        int[] intArray = new int[readyConvert.length];
        for(int i = 0; i < readyConvert.length; i++) {
            intArray[i] = Integer.parseInt(readyConvert[i]);
        }
        List<Integer> sortedList = new ArrayList<Integer>(intArray.length);
        for(int j : intArray) {
            sortedList.add(j);
        }
        Collections.reverse(sortedList);
        String[] finalList = ((sortedList.toString()).substring(1,
                    (sortedList.toString()).length() - 1)).split("-");
        String prepString = Arrays.toString(finalList);
        String semiString = prepString.replaceAll(", ","-");
        String finalString = (semiString.substring(1,((semiString.length()) 
                - 1))).replaceAll("0-", "");
        return finalString;
    }
    
    private String capIt(String lowerstring) {
        return (lowerstring.substring(0, 1).toUpperCase() + 
                lowerstring.substring(1));
    }
    
    private String bioBuilder(String name, String align, String race, String
            gender, String classname, String pronoun, String status, String bio)
    {
        String newbio = (name + " is " + gender + " " + align + " " + race + " "
                + " " + classname + ". " + capIt(pronoun) + " " + status + ". " 
                + bio);
        return newbio;
    }
    
    private void openWeb(String website) {
        String command = "rundll32 url.dll,FileProtocolHandler " + website;
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
           

    //<editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane battlePane;
    private javax.swing.JTextArea battleText;
    private javax.swing.JButton enterButton;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuDonate;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JLabel p1Info1;
    private javax.swing.JLabel p1Info2;
    private javax.swing.JLabel p1Info3;
    private javax.swing.JLabel p1Info4;
    private javax.swing.JLabel p1Info5;
    private javax.swing.JScrollPane p1Pane;
    private javax.swing.JScrollPane p1Pane2;
    private javax.swing.JComboBox<String> p1Select;
    private javax.swing.JTextPane p1Text;
    private javax.swing.JTextPane p1Text2;
    private javax.swing.JLabel p1Toon;
    private javax.swing.JLabel p1ToonName;
    private javax.swing.JLabel p2Info1;
    private javax.swing.JLabel p2Info2;
    private javax.swing.JLabel p2Info3;
    private javax.swing.JLabel p2Info4;
    private javax.swing.JLabel p2Info5;
    private javax.swing.JScrollPane p2Pane;
    private javax.swing.JScrollPane p2Pane2;
    private javax.swing.JComboBox<String> p2Select;
    private javax.swing.JTextPane p2Text;
    private javax.swing.JTextPane p2Text2;
    private javax.swing.JLabel p2Toon;
    private javax.swing.JLabel p2ToonName;
    private javax.swing.JButton test1Button;
    private javax.swing.JButton test2Button;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
}
