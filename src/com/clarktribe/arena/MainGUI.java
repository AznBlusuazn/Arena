// <editor-fold defaultstate="collapsed" desc="Header Items">
package com.clarktribe.arena;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * @version ALPHA 0.0.2 / 2020.11.18.0019
 * 
 */
//</editor-fold>

public class MainGUI extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="initialized variables">
    
    //Player 1 Vars
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
    String p1Status = "<font color=green>Healthy</font>";
    String p1TextString = "";
    
    //Player 2 Vars
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
    String p2Status = "<font color=green>Healthy</font>";
    String p2TextString = "";
    
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
    
    //Player 2 Gender Vars
    int gender2Index = 0;
    String gender2Name = "";
    String gender2Desc = "";
    String gender2Bio = "";
    
    // </editor-fold>
    
    public MainGUI() throws InterruptedException, SQLException, IOException, URISyntaxException {
        initComponents();
        dbCheck();
        setLocationRelativeTo(null);
        welcomePlayer();
        popSelect();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1Toon = new javax.swing.JLabel();
        p1Info1 = new javax.swing.JLabel();
        p1Info2 = new javax.swing.JLabel();
        p1Info3 = new javax.swing.JLabel();
        p1Info4 = new javax.swing.JLabel();
        p1Select = new javax.swing.JComboBox<>();
        p1Pane = new javax.swing.JScrollPane();
        p1Text = new javax.swing.JTextPane();
        battlePane = new javax.swing.JScrollPane();
        battleText = new javax.swing.JTextArea();
        p2Toon = new javax.swing.JLabel();
        p2Info1 = new javax.swing.JLabel();
        p2Info2 = new javax.swing.JLabel();
        p2Info3 = new javax.swing.JLabel();
        p2Select = new javax.swing.JComboBox<>();
        test1Button = new javax.swing.JButton();
        test2Button = new javax.swing.JButton();
        p1ToonName = new javax.swing.JLabel();
        p2ToonName = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        enterButton = new javax.swing.JButton();
        p2Pane = new javax.swing.JScrollPane();
        p2Text = new javax.swing.JTextPane();
        p2Info4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arena Game [Alpha]");
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setName("mainGUI"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Toon.setText("[Player 1 Image Here]");
        p1Toon.setFocusable(false);
        getContentPane().add(p1Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 200));

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

        getContentPane().add(p1Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 342, 200, 360));

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

        p2Select.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        p2Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 2" }));
        p2Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2SelectActionPerformed(evt);
            }
        });
        getContentPane().add(p2Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 200, -1));

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

        p1ToonName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p1ToonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1ToonName.setText("Player 1");
        getContentPane().add(p1ToonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 18));

        p2ToonName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p2ToonName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2ToonName.setText("Player 2");
        getContentPane().add(p2ToonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 240, 200, 20));

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

        p2Text.setEditable(false);
        p2Text.setContentType("text/html"); // NOI18N
        p2Text.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p2Text.setFocusable(false);
        p2Pane.setViewportView(p2Text);

        getContentPane().add(p2Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 342, 200, 360));

        p2Info4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(p2Info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 200, 20));

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
                "Welcome to the Arena Game.  This is an alpha version of the ga"
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
            String matchcol, String matchstr, boolean isitSingle) throws 
            SQLException {
        String list = "";
        if (!isitSingle) {
            System.out.println("IT IS NOTTRUE");
                list = (new RunQuery().getSpecificRecord(search, table, column,
                        matchcol, matchstr))
                .replaceAll("\\[", "").replaceAll("\\]","");
            } else {
            System.out.println("IT IS TRUE");
        list = (new RunQuery().getSingleList(search, table, column))
                .replaceAll("\\[", "").replaceAll("\\]","");
        }
        String[] stringList = list.split(",");
        List<String> convertedList = Arrays.asList(stringList);
        return convertedList;
    }
    //</editor-fold>
    
    private void popSelect() throws SQLException {
        toonList = dbQuery("*","dbToons","toonName","","", true);
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
        List<String> listP1Stats = dbQuery("*","dbToons","toonName","toonName",
                toonname, false);
        String[] p1Field = ((listP1Stats.toString()).substring(1,(listP1Stats.
                toString()).length())).split(",");
        p1Index = Integer.parseInt(removeSpace(p1Field[0]));
        p1Name = removeSpace(p1Field[1]);
        p1Race = removeSpace(p1Field[2]);
        p1Class = removeSpace(p1Field[3]);
        p1Align = removeSpace(p1Field[4]);
        //0
        p1HP = Integer.parseInt(removeSpace(p1Field[6]));   // 1
        p1MP = Integer.parseInt(removeSpace(p1Field[7]));   // 2
        p1AP = Integer.parseInt(removeSpace(p1Field[8]));   // 3
        p1Att = Integer.parseInt(removeSpace(p1Field[9]));  // 4
        p1Str = Integer.parseInt(removeSpace(p1Field[10])); // 5
        p1Def = Integer.parseInt(removeSpace(p1Field[11])); // 6
        p1Sta = Integer.parseInt(removeSpace(p1Field[12])); // 7
        p1Spd = Integer.parseInt(removeSpace(p1Field[13])); // 8
        p1Eva = Integer.parseInt(removeSpace(p1Field[14])); // 9
        p1Dex = Integer.parseInt(removeSpace(p1Field[15])); //10
        p1Mys = Integer.parseInt(removeSpace(p1Field[16])); //11
        p1Wil = Integer.parseInt(removeSpace(p1Field[17])); //12
        p1Lck = Integer.parseInt(removeSpace(p1Field[18])); //13
        p1Chm = Integer.parseInt(removeSpace(p1Field[19])); //14
        p1Int = Integer.parseInt(removeSpace(p1Field[20])); //15
        p1Fat = Integer.parseInt(removeSpace(p1Field[21])); //16
        p1Sol = Integer.parseInt(removeSpace(p1Field[22])); //17
        p1Dcy = Integer.parseInt(removeSpace(p1Field[23])); //18
        p1WtM = Integer.parseInt(removeSpace(p1Field[24])); //19
        p1Sze = Integer.parseInt(removeSpace(p1Field[25])); //20
        p1Gen = Integer.parseInt(removeSpace(p1Field[26])); //21
        p1Age = Integer.parseInt(removeSpace(p1Field[27])); //22
        p1Lv = Integer.parseInt(removeSpace(p1Field[28]));  //23
        p1Exp = Integer.parseInt(removeSpace(p1Field[29])); //24
        p1Rep = Integer.parseInt(removeSpace(p1Field[30])); //25
        p1Bio = removeSpace(p1Field[31]);
        p1Image = removeSpace(p1Field[32]).replace("]","");       
        p1Select.setSelectedIndex(p1Index - 1);
        p1ToonName.setText(p1Name + " (Lv. " + p1Lv + ")");
        getR1(p1Race);
        getC1(p1Class);
        getAlign1(p1Align);
        getG1(p1Gen);
        p1Info1.setText("(Age Modifier " + p1Age + ")");
        p1Info2.setText(r1Name + " " + c1Name);
        p1Info3.setText(align1Name + " (Rep: " + p1Rep + ")");
        p1Info4.setText("Size" + p1Sze +  " " + gender1Name);
        p1TextString = ("<center>Status: &nbsp;" + p1Status + "<br><br>Exp: &nb"
                + "sp;" + p1Exp + "/" + p1Exp + "<br><br>HP: &nbsp;" + p1HP + ""
                + "/" + p1HP  + "<br>AP: &nbsp;" + p1AP + "/" + p1AP + "<br>MP:"
                + " &nbsp;" + p1MP + "/" + p1MP + "<br><br>Attack: &nbsp;" + 
                p1Att + "<br>Strength: &nbsp;" + p1Str + "<br>Defense" + ": &nb"
                + "sp;" + p1Def + "<br>Stamina: &nbsp;"+ p1Sta + "<br>Speed: &n"
                + "bsp;"+ p1Spd +"<br>Evade: &nbsp;" + p1Eva + "<br>Dexterity: "
                + "&nbsp;" + p1Dex + "<br>Mystic: &nbsp;" + p1Mys + "<br>Willpo"
                + "wer: &nbsp;" + p1Wil + "<br>Luck: &nbsp;" + p1Lck + "<br>Cha"
                + "rm: &nbsp;" + p1Chm + "<br>Intellect: &nbsp;" + p1Int + "<br>Fatigue: &nbsp;" + p1Fat + "<br>Soul/Decay (hide): &nbsp;" + p1Dcy + "/" + p1Sol
                + "<center><br><br>" + p1Bio);
        p1Text.setText(p1TextString);
        new ToonImage().setImage(p1Toon,p1Image);
    }
    
    public void setP2(String toonname) throws SQLException {
        List<String> listP2Stats = dbQuery("*","dbToons","toonName","toonName",
                toonname, false);
        String[] p2Field = ((listP2Stats.toString()).substring(1,(listP2Stats.
                toString()).length())).split(",");
        p2Index = Integer.parseInt(removeSpace(p2Field[0]));
        p2Name = removeSpace(p2Field[1]);
        p2Race = removeSpace(p2Field[2]);
        p2Class = removeSpace(p2Field[3]);
        p2Align = removeSpace(p2Field[4]);
        //0
        p2HP = Integer.parseInt(removeSpace(p2Field[6]));   // 1
        p2MP = Integer.parseInt(removeSpace(p2Field[7]));   // 2
        p2AP = Integer.parseInt(removeSpace(p2Field[8]));   // 3
        p2Att = Integer.parseInt(removeSpace(p2Field[9]));  // 4
        p2Str = Integer.parseInt(removeSpace(p2Field[10])); // 5
        p2Def = Integer.parseInt(removeSpace(p2Field[11])); // 6
        p2Sta = Integer.parseInt(removeSpace(p2Field[12])); // 7
        p2Spd = Integer.parseInt(removeSpace(p2Field[13])); // 8
        p2Eva = Integer.parseInt(removeSpace(p2Field[14])); // 9
        p2Dex = Integer.parseInt(removeSpace(p2Field[15])); //10
        p2Mys = Integer.parseInt(removeSpace(p2Field[16])); //11
        p2Wil = Integer.parseInt(removeSpace(p2Field[17])); //12
        p2Lck = Integer.parseInt(removeSpace(p2Field[18])); //13
        p2Chm = Integer.parseInt(removeSpace(p2Field[19])); //14
        p2Int = Integer.parseInt(removeSpace(p2Field[20])); //15
        p2Fat = Integer.parseInt(removeSpace(p2Field[21])); //16
        p2Sol = Integer.parseInt(removeSpace(p2Field[22])); //17
        p2Dcy = Integer.parseInt(removeSpace(p2Field[23])); //18
        p2WtM = Integer.parseInt(removeSpace(p2Field[24])); //19
        p2Sze = Integer.parseInt(removeSpace(p2Field[25])); //20
        p2Gen = Integer.parseInt(removeSpace(p2Field[26])); //21
        p2Age = Integer.parseInt(removeSpace(p2Field[27])); //22
        p2Lv = Integer.parseInt(removeSpace(p2Field[28]));  //23
        p2Exp = Integer.parseInt(removeSpace(p2Field[29])); //24
        p2Rep = Integer.parseInt(removeSpace(p2Field[30])); //25
        p2Bio = removeSpace(p2Field[31]);
        p2Image = removeSpace(p2Field[32]).replace("]","");        
        p2Select.setSelectedIndex(p2Index - 1);
        p2ToonName.setText(p2Name + " (Lv. " + p2Lv + ")");
        getR2(p2Race);
        getC2(p2Class);
        getAlign2(p2Align);
        getG2(p2Gen);
        p2Info1.setText(" (Age Modifier " + p2Age + ") ");
        p2Info2.setText(r2Name + " " + c2Name);
        p2Info3.setText(align2Name + " (Rep: " + p2Rep + ")");
        p2Info4.setText("Size" + p2Sze +  " " + gender2Name);
                p2TextString = ("<center>Status: &nbsp;" + p2Status + "<br><br>Exp: &nb"
                + "sp;" + p2Exp + "/" + p2Exp + "<br><br>HP: &nbsp;" + p2HP + ""
                + "/" + p2HP  + "<br>AP: &nbsp;" + p2AP + "/" + p2AP + "<br>MP:"
                + " &nbsp;" + p2MP + "/" + p2MP + "<br><br>Attack: &nbsp;" + 
                p2Att + "<br>Strength: &nbsp;" + p2Str + "<br>Defense" + ": &nb"
                + "sp;" + p2Def + "<br>Stamina: &nbsp;"+ p2Sta + "<br>Speed: &n"
                + "bsp;"+ p2Spd +"<br>Evade: &nbsp;" + p2Eva + "<br>Dexterity: "
                + "&nbsp;" + p2Dex + "<br>Mystic: &nbsp;" + p2Mys + "<br>Willpo"
                + "wer: &nbsp;" + p2Wil + "<br>Luck: &nbsp;" + p2Lck + "<br>Cha"
                 + "rm: &nbsp;" + p2Chm + "<br>Intellect: &nbsp;" + p2Int + "<br>Fatigue: &nbsp;" + p2Fat +  "<br>Size " + p2Sze +  " " + gender2Name + "<br>Soul/Decay (hide): &nbsp;" + p2Dcy + "/" + p2Sol
                + "<center><br><br>" + p2Bio);
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
        List<String> r1Stats = dbQuery("*","dbRace","raceName","raceID ",
                raceid, false);
        String[] r1Field = ((r1Stats.toString()).substring(1,(r1Stats.
                toString()).length())).split(",");
        r1Index = Integer.parseInt(removeSpace(r1Field[0]));
        r1Name = removeSpace(r1Field[1]);
        r1Desc = removeSpace(r1Field[2]);
        //0
        r1HPx = Integer.parseInt(removeSpace(r1Field[4]));
        r1MPx = Integer.parseInt(removeSpace(r1Field[5]));
        r1APx = Integer.parseInt(removeSpace(r1Field[6]));
        r1Attx = Integer.parseInt(removeSpace(r1Field[7]));
        r1Strx = Integer.parseInt(removeSpace(r1Field[8]));
        r1Defx = Integer.parseInt(removeSpace(r1Field[9]));
        r1Stax = Integer.parseInt(removeSpace(r1Field[10]));
        r1Spdx = Integer.parseInt(removeSpace(r1Field[11]));
        r1Evax = Integer.parseInt(removeSpace(r1Field[12]));
        r1Dexx = Integer.parseInt(removeSpace(r1Field[13]));
        r1Mysx = Integer.parseInt(removeSpace(r1Field[14]));
        r1Wilx = Integer.parseInt(removeSpace(r1Field[15]));
        r1Lckx = Integer.parseInt(removeSpace(r1Field[16]));
        r1Chmx = Integer.parseInt(removeSpace(r1Field[17]));
        r1Intx = Integer.parseInt(removeSpace(r1Field[18]));
        r1Fatx = Integer.parseInt(removeSpace(r1Field[19]));
        r1Solx = Integer.parseInt(removeSpace(r1Field[20]));
        r1Dcyx = Integer.parseInt(removeSpace(r1Field[21]));
        r1WtMx = Integer.parseInt(removeSpace(r1Field[22]));
        r1Szex = Integer.parseInt(removeSpace(r1Field[23]));
        r1Genx = Integer.parseInt(removeSpace(r1Field[24]));
        r1Agecap = Integer.parseInt(removeSpace(r1Field[25]));
        r1Lvcap = Integer.parseInt(removeSpace(r1Field[26]));
        r1Expx = Integer.parseInt(removeSpace(r1Field[27]));
        r1Repx = Integer.parseInt(removeSpace(r1Field[28]));
        r1Bio = removeSpace(r1Field[29]).replace("]","");
    }
    
    public void getR2(String raceid) throws SQLException {
        List<String> r2Stats = dbQuery("*","dbRace","raceName","raceID ",
                raceid, false);
        String[] r2Field = ((r2Stats.toString()).substring(1,(r2Stats.
                toString()).length())).split(",");
        r2Index = Integer.parseInt(removeSpace(r2Field[0]));
        r2Name = removeSpace(r2Field[1]);
        r2Desc = removeSpace(r2Field[2]);
        //0
        r2HPx = Integer.parseInt(removeSpace(r2Field[4]));
        r2MPx = Integer.parseInt(removeSpace(r2Field[5]));
        r2APx = Integer.parseInt(removeSpace(r2Field[6]));
        r2Attx = Integer.parseInt(removeSpace(r2Field[7]));
        r2Strx = Integer.parseInt(removeSpace(r2Field[8]));
        r2Defx = Integer.parseInt(removeSpace(r2Field[9]));
        r2Stax = Integer.parseInt(removeSpace(r2Field[10]));
        r2Spdx = Integer.parseInt(removeSpace(r2Field[11]));
        r2Evax = Integer.parseInt(removeSpace(r2Field[12]));
        r2Dexx = Integer.parseInt(removeSpace(r2Field[13]));
        r2Mysx = Integer.parseInt(removeSpace(r2Field[14]));
        r2Wilx = Integer.parseInt(removeSpace(r2Field[15]));
        r2Lckx = Integer.parseInt(removeSpace(r2Field[16]));
        r2Chmx = Integer.parseInt(removeSpace(r2Field[17]));
        r2Intx = Integer.parseInt(removeSpace(r2Field[18]));
        r2Fatx = Integer.parseInt(removeSpace(r2Field[19]));
        r2Solx = Integer.parseInt(removeSpace(r2Field[20]));
        r2Dcyx = Integer.parseInt(removeSpace(r2Field[21]));
        r2WtMx = Integer.parseInt(removeSpace(r2Field[22]));
        r2Szex = Integer.parseInt(removeSpace(r2Field[23]));
        r2Genx = Integer.parseInt(removeSpace(r2Field[24]));
        r2Agecap = Integer.parseInt(removeSpace(r2Field[25]));
        r2Lvcap = Integer.parseInt(removeSpace(r2Field[26]));
        r2Expx = Integer.parseInt(removeSpace(r2Field[27]));
        r2Repx = Integer.parseInt(removeSpace(r2Field[28]));
        r2Bio = removeSpace(r2Field[29]).replace("]","");
    }

    public void getC1(String classid) throws SQLException {
        List<String> c1Stats = dbQuery("*","dbClass","className","classID ",
                classid, false);
        String[] c1Field = ((c1Stats.toString()).substring(1,(c1Stats.
                toString()).length())).split(",");
        c1Index = Integer.parseInt(removeSpace(c1Field[0]));
        c1Name = removeSpace(c1Field[1]);
        c1Desc = removeSpace(c1Field[2]);
        //0
        c1HPx = Integer.parseInt(removeSpace(c1Field[4]));
        c1MPx = Integer.parseInt(removeSpace(c1Field[5]));
        c1APx = Integer.parseInt(removeSpace(c1Field[6]));
        c1Attx = Integer.parseInt(removeSpace(c1Field[7]));
        c1Strx = Integer.parseInt(removeSpace(c1Field[8]));
        c1Defx = Integer.parseInt(removeSpace(c1Field[9]));
        c1Stax = Integer.parseInt(removeSpace(c1Field[10]));
        c1Spdx = Integer.parseInt(removeSpace(c1Field[11]));
        c1Evax = Integer.parseInt(removeSpace(c1Field[12]));
        c1Dexx = Integer.parseInt(removeSpace(c1Field[13]));
        c1Mysx = Integer.parseInt(removeSpace(c1Field[14]));
        c1Wilx = Integer.parseInt(removeSpace(c1Field[15]));
        c1Lckx = Integer.parseInt(removeSpace(c1Field[16]));
        c1Chmx = Integer.parseInt(removeSpace(c1Field[17]));
        c1Intx = Integer.parseInt(removeSpace(c1Field[18]));
        c1Fatx = Integer.parseInt(removeSpace(c1Field[19]));
        c1Solx = Integer.parseInt(removeSpace(c1Field[20]));
        c1Dcyx = Integer.parseInt(removeSpace(c1Field[21]));
        c1WtMx = Integer.parseInt(removeSpace(c1Field[22]));
        c1Szex = Integer.parseInt(removeSpace(c1Field[23]));
        c1Genx = Integer.parseInt(removeSpace(c1Field[24]));
        c1Agecap = Integer.parseInt(removeSpace(c1Field[25]));
        c1Lvcap = Integer.parseInt(removeSpace(c1Field[26]));
        c1Expx = Integer.parseInt(removeSpace(c1Field[27]));
        c1Repx = Integer.parseInt(removeSpace(c1Field[28]));
        c1Bio = removeSpace(c1Field[29]).replace("]","");
    }
    
    public void getC2(String classid) throws SQLException {
        List<String> c2Stats = dbQuery("*","dbClass","className","classID ",
                classid, false);
        String[] c2Field = ((c2Stats.toString()).substring(1,(c2Stats.
                toString()).length())).split(",");
        c2Index = Integer.parseInt(removeSpace(c2Field[0]));
        c2Name = removeSpace(c2Field[1]);
        c2Desc = removeSpace(c2Field[2]);
         //0
        c2HPx = Integer.parseInt(removeSpace(c2Field[4]));
        c2MPx = Integer.parseInt(removeSpace(c2Field[5]));
        c2APx = Integer.parseInt(removeSpace(c2Field[6]));
        c2Attx = Integer.parseInt(removeSpace(c2Field[7]));
        c2Strx = Integer.parseInt(removeSpace(c2Field[8]));
        c2Defx = Integer.parseInt(removeSpace(c2Field[9]));
        c2Stax = Integer.parseInt(removeSpace(c2Field[10]));
        c2Spdx = Integer.parseInt(removeSpace(c2Field[11]));
        c2Evax = Integer.parseInt(removeSpace(c2Field[12]));
        c2Dexx = Integer.parseInt(removeSpace(c2Field[13]));
        c2Mysx = Integer.parseInt(removeSpace(c2Field[14]));
        c2Wilx = Integer.parseInt(removeSpace(c2Field[15]));
        c2Lckx = Integer.parseInt(removeSpace(c2Field[16]));
        c2Chmx = Integer.parseInt(removeSpace(c2Field[17]));
        c2Intx = Integer.parseInt(removeSpace(c2Field[18]));
        c2Fatx = Integer.parseInt(removeSpace(c2Field[19]));
        c2Solx = Integer.parseInt(removeSpace(c2Field[20]));
        c2Dcyx = Integer.parseInt(removeSpace(c2Field[21]));
        c2WtMx = Integer.parseInt(removeSpace(c2Field[22]));
        c2Szex = Integer.parseInt(removeSpace(c2Field[23]));
        c2Genx = Integer.parseInt(removeSpace(c2Field[24]));
        c2Agecap = Integer.parseInt(removeSpace(c2Field[25]));
        c2Lvcap = Integer.parseInt(removeSpace(c2Field[26]));
        c2Expx = Integer.parseInt(removeSpace(c2Field[27]));
        c2Repx = Integer.parseInt(removeSpace(c2Field[28]));
        c2Bio = removeSpace(c2Field[29]).replace("]","");
    }

    public void getAlign1(String alignid) throws SQLException {
        List<String> align1Stats = dbQuery("*","dbAlign","alignName","alignID ",
                alignid, false);
        String[] align1Field = ((align1Stats.toString()).substring(1,(align1Stats.
                toString()).length())).split(",");
        align1Index = Integer.parseInt(removeSpace(align1Field[0]));
        align1Name = removeSpace(align1Field[1]);
        align1Desc = removeSpace(align1Field[2]);
        align1Score = Integer.parseInt(removeSpace(align1Field[3]));
        align1Bio = removeSpace(align1Field[27]).replace("]","");
        System.out.println("Align1 Test: " + align1Name + " " + align1Score);
    }
    
    public void getAlign2(String alignid) throws SQLException {
        List<String> align2Stats = dbQuery("*","dbAlign","alignName","alignID ",
                alignid, false);
        String[] align2Field = ((align2Stats.toString()).substring(1,(align2Stats.
                toString()).length())).split(",");
        align2Index = Integer.parseInt(removeSpace(align2Field[0]));
        align2Name = removeSpace(align2Field[1]);
        align2Desc = removeSpace(align2Field[2]);
        align2Score = Integer.parseInt(removeSpace(align2Field[3]));
        align2Bio = removeSpace(align2Field[27]).replace("]","");
        System.out.println("Align2 Test: " + align2Name + " " + align2Score);
    }
    
        public void getG1(int genderid) throws SQLException {
        List<String> gender1Stats = dbQuery("*","dbGender","genderName","genderID ",
                (String.valueOf(genderid)), false);
        String[] gender1Field = ((gender1Stats.toString()).substring(1,(gender1Stats.
                toString()).length())).split(",");
        gender1Index = Integer.parseInt(removeSpace(gender1Field[0]));
        gender1Name = removeSpace(gender1Field[1]);
        gender1Desc = removeSpace(gender1Field[2]);
        gender1Bio = removeSpace(gender1Field[29]).replace("]","");
        System.out.println("gender1 Test: " + gender1Name);
    }
    
        public void getG2(int genderid) throws SQLException {
        List<String> gender2Stats = dbQuery("*","dbGender","genderName","genderID ",
                String.valueOf(genderid) , false);
        String[] gender2Field = ((gender2Stats.toString()).substring(1,(gender2Stats.
                toString()).length())).split(",");
        gender2Index = Integer.parseInt(removeSpace(gender2Field[0]));
        gender2Name = removeSpace(gender2Field[1]);
        gender2Desc = removeSpace(gender2Field[2]);
        gender2Bio = removeSpace(gender2Field[29]).replace("]","");
        System.out.println("gender2 Test: " + gender2Name);
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

    //<editor-fold defaultstate="collapsed" desc="Swing Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane battlePane;
    private javax.swing.JTextArea battleText;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel p1Info1;
    private javax.swing.JLabel p1Info2;
    private javax.swing.JLabel p1Info3;
    private javax.swing.JLabel p1Info4;
    private javax.swing.JScrollPane p1Pane;
    private javax.swing.JComboBox<String> p1Select;
    private javax.swing.JTextPane p1Text;
    private javax.swing.JLabel p1Toon;
    private javax.swing.JLabel p1ToonName;
    private javax.swing.JLabel p2Info1;
    private javax.swing.JLabel p2Info2;
    private javax.swing.JLabel p2Info3;
    private javax.swing.JLabel p2Info4;
    private javax.swing.JScrollPane p2Pane;
    private javax.swing.JComboBox<String> p2Select;
    private javax.swing.JTextPane p2Text;
    private javax.swing.JLabel p2Toon;
    private javax.swing.JLabel p2ToonName;
    private javax.swing.JButton test1Button;
    private javax.swing.JButton test2Button;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
}
