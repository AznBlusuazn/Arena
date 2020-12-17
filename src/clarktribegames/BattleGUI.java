package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javazoom.jl.decoder.JavaLayerException;

//<editor-fold defaultstate="collapsed" desc="Credits"> 
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class BattleGUI extends javax.swing.JFrame {

    public BattleGUI() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        prepBattle(BattleEngine.saveName,BattleEngine.saveToons,BattleEngine
            .saveMax,Arrays.asList(BattleEngine.team0),Arrays.asList(
            BattleEngine.team1));
    }

    //<editor-fold defaultstate="collapsed" desc="JSwing Code"> 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        team1Hidden = new javax.swing.JLabel();
        team0Hidden = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        team1ItemsButton = new javax.swing.JButton();
        team1AblButton = new javax.swing.JButton();
        team1EffButton = new javax.swing.JButton();
        team0ItemsButton = new javax.swing.JButton();
        team0AblButton = new javax.swing.JButton();
        team0EffButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        battletitleLabel = new javax.swing.JLabel();
        saveLabel = new javax.swing.JLabel();
        limitLabel = new javax.swing.JLabel();
        titleLogo = new javax.swing.JLabel();
        team1Pane = new javax.swing.JScrollPane();
        team1List = new javax.swing.JList<>();
        team1Toon = new javax.swing.JLabel();
        team0Pane = new javax.swing.JScrollPane();
        team0List = new javax.swing.JList<>();
        team0Toon = new javax.swing.JLabel();
        team1Label = new javax.swing.JLabel();
        team0Label = new javax.swing.JLabel();
        team0TPane = new javax.swing.JScrollPane();
        team0Table = new javax.swing.JTable();
        team1TPane = new javax.swing.JScrollPane();
        team1Table = new javax.swing.JTable();
        inputText = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextArea();
        team1Info = new javax.swing.JLabel();
        team0Info = new javax.swing.JLabel();
        team1DetailsButton = new javax.swing.JButton();
        team0DetailsButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setMaximumSize(new java.awt.Dimension(1220, 800));
        setMinimumSize(new java.awt.Dimension(1220, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1220, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        team1Hidden.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1Hidden.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        team1Hidden.setText("Team1 Hidden Info: AlignxGenderxAgexSizexExp");
        getContentPane().add(team1Hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 775, 400, 20));

        team0Hidden.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0Hidden.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        team0Hidden.setText("Team0 Hidden Info: AlignxGenderxAgexSizexExp");
        getContentPane().add(team0Hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 775, 400, 20));

        bottomPanel.setFocusable(false);
        bottomPanel.setMaximumSize(new java.awt.Dimension(1200, 60));
        bottomPanel.setMinimumSize(new java.awt.Dimension(1200, 60));
        bottomPanel.setPreferredSize(new java.awt.Dimension(1200, 60));
        getContentPane().add(bottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1200, 60));

        team1ItemsButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1ItemsButton.setText("Items");
        team1ItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team1ItemsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team1ItemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, -1, 20));

        team1AblButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1AblButton.setText("Abilities");
        team1AblButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team1AblButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team1AblButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 425, -1, 20));

        team1EffButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1EffButton.setText("Effects");
        team1EffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team1EffButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team1EffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 425, 75, 20));

        team0ItemsButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0ItemsButton.setText("Items");
        team0ItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team0ItemsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team0ItemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 425, -1, 20));

        team0AblButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0AblButton.setText("Abilities");
        team0AblButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team0AblButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team0AblButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 425, -1, 20));

        team0EffButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0EffButton.setText("Effects");
        team0EffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team0EffButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team0EffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 425, 75, 20));

        rightPanel.setFocusable(false);
        rightPanel.setMaximumSize(new java.awt.Dimension(10, 800));
        rightPanel.setMinimumSize(new java.awt.Dimension(10, 800));
        rightPanel.setPreferredSize(new java.awt.Dimension(10, 800));
        getContentPane().add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 30, 800));

        battletitleLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        battletitleLabel.setText("Battle Mode");
        battletitleLabel.setFocusable(false);
        getContentPane().add(battletitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 600, -1));

        saveLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saveLabel.setText("Current Limitless Save Game:");
        saveLabel.setFocusable(false);
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 11, 230, 21));

        limitLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        limitLabel.setText("[" + Converters.capFirstLetter(BattleEngine.saveToons.substring(3,BattleEngine.saveToons.length()).replaceAll("Toons","")) +
            "] • [Database: " + Converters.capFirstLetter(BattleEngine.saveName) + "]");
        limitLabel.setFocusable(false);
        limitLabel.setMaximumSize(new java.awt.Dimension(1200, 800));
        limitLabel.setMinimumSize(new java.awt.Dimension(1200, 800));
        limitLabel.setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().add(limitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 11, 340, 21));

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N
        getContentPane().add(titleLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 43, 780, 190));

        team1List.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        team1List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Team 1 Toon List" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        team1List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team1Pane.setViewportView(team1List);

        getContentPane().add(team1Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 100));

        team1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Toon.setText("[Team 1 Image Here]");
        team1Toon.setFocusable(false);
        getContentPane().add(team1Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 200));

        team0List.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        team0List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Team 0 Toon List" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        team0List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team0List.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        team0Pane.setViewportView(team0List);

        getContentPane().add(team0Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 200, 100));

        team0Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team0Toon.setText("[Team 0 Image Here]");
        team0Toon.setFocusable(false);
        getContentPane().add(team0Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 200, 200));

        team1Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        team1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Label.setText("<Team 1 Active Character>");
        getContentPane().add(team1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 20));

        team0Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        team0Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team0Label.setText("<Team 0 Active Character>");
        getContentPane().add(team0Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 350, 200, 20));

        team0TPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        team0TPane.setColumnHeaderView(null);
        team0TPane.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N

        team0Table.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        team0Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Status", null},
                {"Health Pts", null},
                {"Mystic Pts", null},
                {"Ability Pts", null},
                {"Attack Pwr", null},
                {"Strength", null},
                {"Defense", null},
                {"Stamina", null},
                {"Speed", null},
                {"Evade", null},
                {"Dexterity", null},
                {"Mystic Pwr", null},
                {"Mystic Def", null},
                {"MysticEva", null},
                {"Willpower", null},
                {"Luck", null},
                {"Charisma", null},
                {"Intelligence", null}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        team0Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        team0Table.setRowSelectionAllowed(false);
        team0Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team0Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team0Table.setTableHeader(null);
        team0TPane.setViewportView(team0Table);
        if (team0Table.getColumnModel().getColumnCount() > 0) {
            team0Table.getColumnModel().getColumn(0).setResizable(false);
            team0Table.getColumnModel().getColumn(0).setPreferredWidth(95);
            team0Table.getColumnModel().getColumn(1).setResizable(false);
            team0Table.getColumnModel().getColumn(1).setPreferredWidth(105);
        }

        getContentPane().add(team0TPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 200, 300));

        team1TPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        team1TPane.setColumnHeaderView(null);
        team1TPane.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N

        team1Table.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        team1Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Status", null},
                {"Health Pts", null},
                {"Mystic Pts", null},
                {"Ability Pts", null},
                {"Attack Pwr", null},
                {"Strength", null},
                {"Defense", null},
                {"Stamina", null},
                {"Speed", null},
                {"Evade", null},
                {"Dexterity", null},
                {"Mystic Pwr", null},
                {"Mystic Def", null},
                {"MysticEva", null},
                {"Willpower", null},
                {"Luck", null},
                {"Charisma", null},
                {"Intelligence", null}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        team1Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        team1Table.setRowSelectionAllowed(false);
        team1Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team1Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team1Table.setTableHeader(null);
        team1TPane.setViewportView(team1Table);
        if (team1Table.getColumnModel().getColumnCount() > 0) {
            team1Table.getColumnModel().getColumn(0).setResizable(false);
            team1Table.getColumnModel().getColumn(0).setPreferredWidth(95);
            team1Table.getColumnModel().getColumn(1).setResizable(false);
            team1Table.getColumnModel().getColumn(1).setPreferredWidth(105);
        }

        getContentPane().add(team1TPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 300));

        inputText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        inputText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(inputText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 720, 670, 20));

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 80, 20));

        mainText.setEditable(false);
        mainText.setColumns(1);
        mainText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mainText.setLineWrap(true);
        mainText.setRows(33);
        jScrollPane1.setViewportView(mainText);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 760, 460));

        team1Info.setFont(new java.awt.Font("Lucida Sans", 1, 11)); // NOI18N
        team1Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Info.setText("Race Name Class Name (Level)");
        getContentPane().add(team1Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 200, 20));

        team0Info.setFont(new java.awt.Font("Lucida Sans", 1, 11)); // NOI18N
        team0Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team0Info.setText("Race Name Class Name (Level)");
        getContentPane().add(team0Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 375, 200, 20));

        team1DetailsButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1DetailsButton.setText("Character Details");
        team1DetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team1DetailsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(team1DetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 20));

        team0DetailsButton1.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0DetailsButton1.setText("Character Details");
        team0DetailsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team0DetailsButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(team0DetailsButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 200, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            exitButton();
        } catch (IOException ex) {
            try {
                logFile("severe","NG Exit Error.\nIOEx: " + ex.toString());
                exitProcess();
            } catch (IOException ex1) {
                ex1.printStackTrace();
                try {
                    exitProcess();
                } catch (IOException | JavaLayerException ex2) {
                    ex2.printStackTrace();
                }
            } catch (JavaLayerException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                exitProcess();
            } catch (IOException | JavaLayerException ex1) {
                ex1.printStackTrace();
            }
        }   
    }//GEN-LAST:event_formWindowClosing

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try {
            confirmButton();
        } catch (BadLocationException ex) {
            //
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void team1DetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1DetailsButtonActionPerformed
         try {
             detailsButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team1),team1List,team1Hidden);
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1DetailsButtonActionPerformed

    private void team0DetailsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0DetailsButton1ActionPerformed
         try {
             detailsButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team0),team0List,team0Hidden);
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0DetailsButton1ActionPerformed

    private void team1ItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1ItemsButtonActionPerformed
        try {
            itemsButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team1),team1List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1ItemsButtonActionPerformed

    private void team1AblButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1AblButtonActionPerformed
        try {
            ablButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team1),team1List,team1Hidden);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1AblButtonActionPerformed

    private void team1EffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1EffButtonActionPerformed
        try {
            effButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team1),team1List,team1Hidden);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1EffButtonActionPerformed

    private void team0ItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0ItemsButtonActionPerformed
        try {
            itemsButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays
                .asList(BattleEngine.team0),team0List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0ItemsButtonActionPerformed

    private void team0AblButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0AblButtonActionPerformed
        try {
            ablButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays.asList
                (BattleEngine.team0),team0List,team0Hidden);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0AblButtonActionPerformed

    private void team0EffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0EffButtonActionPerformed
        try {
            effButton(BattleEngine.saveName,BattleEngine.saveToons,Arrays.asList
                (BattleEngine.team0),team0List,team0Hidden);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0EffButtonActionPerformed
    //</editor-fold> 

    private static void prepBattle(String save,String toons,String max,
        List<String> team0,List<String> team1) throws SQLException {
        popteamLists(save,toons,team0,team0Pane,team0List);
        popteamLists(save,toons,team1,team1Pane,team1List);
        popAvatars(save,toons,team0Toon,team0List);
        popAvatars(save,toons,team1Toon,team1List);
        popHiddeninfo(save,toons,(GetData.dbQuery(save,"*",toons,"toonID",team0.
            get(team0List.getSelectedIndex()),false).get(0)), team0Hidden);
        popHiddeninfo(save,toons,(GetData.dbQuery(save,"*",toons,"toonID",team1.
            get(team1List.getSelectedIndex()),false).get(0)), team1Hidden);
        popTooninfo(save,toons,team0,team0Label,team0Info,team0List,team0Table, 
            team0Hidden);
        popTooninfo(save,toons,team1,team1Label,team1Info,team1List,team1Table, 
            team1Hidden);
    }

    private static void popteamLists(String save,String toons,List<String> team,
        JScrollPane jpane, JList jlist) throws SQLException { 
        DefaultListModel dml = new DefaultListModel();
        int totalteam = team.size();

        if(totalteam > 1) {
            jpane.setEnabled(true);
            for(int player = 0; player < totalteam; player++) {
                GetStats.getitemsfromIDtoJList(save,team,dml,jlist,toons,
                    "toonID","toonName");
            }
        } else {
            GetStats.getitemsfromIDtoJList(save,team,dml,jlist,toons,"toonID",
                "toonName");
            jlist.setSelectedIndex(0);
            jpane.setVisible(false);
        }
    }
    
    private static void popAvatars(String save,String toons,JLabel avatar, JList
        jlist) throws SQLException {
        Avatars.setAvatar(avatar,GetData.dbQuery(save,"*",toons,"toonName",jlist
            .getSelectedValue().toString(),false).get(1),save);
    }
    
    private static void popTooninfo(String save,String toons,List<String> team,
        JLabel namebox,JLabel infobox, JList jlist,JTable table,JLabel hidden) 
        throws SQLException {
        namebox.setText(GetData.dbQuery(save,"*",toons,"toonName",jlist
            .getSelectedValue().toString(),false).get(1));
        String[] toonstats = (GetData.dbQuery(save,"*",toons,"toonID",team.get(
            jlist.getSelectedIndex()),false).get(20)).split("x");
        String[] hiddenstats = hidden.getText().split("x");
        infobox.setForeground((Converters.figureoutColor(GetStats.getalignColor(
            Integer.parseInt((hiddenstats[0]))))));
        //race name class name level
        infobox.setText((GetData.dbQuery(save,"*","dbRace","raceID",(GetData.
            dbQuery(save,"*",toons,"toonID",team.get(jlist.getSelectedIndex()),
            false).get(2)), false)).get(1) + " " + (GetData.dbQuery(save,"*",
            "dbClass","classID",(GetData.dbQuery(save,"*",toons,"toonID",team
            .get(jlist.getSelectedIndex()),false).get(3)), false)).get(1) + " ("
            + (Calculator.getLevel("curlv", hiddenstats[4])) + ")");
        DefaultTableModel dml = (DefaultTableModel)table.getModel();
        dml.setValueAt("Normal", 0, 1);
        for(int item = 1; item < dml.getRowCount(); item++) {
            dml.setValueAt(toonstats[item - 1], item, 1);
        }
    }
    
    private static void popHiddeninfo(String save,String toons,String toonid,
        JLabel hiddenbox) throws SQLException {
        // (0) Align (1) Gender (2) Age (3) Size (4) Exp
        hiddenbox.setText(GetData.dbQuery(save,"*",toons,"toonID",toonid,false)
            .get(4) + "x" + GetData.dbQuery(save,"*",toons,"toonID",toonid,false
            ).get(6) + "x" + GetData.dbQuery(save,"*",toons,"toonID",toonid,
            false).get(7) + "x" + GetData.dbQuery(save,"*",toons,"toonID",toonid
            ,false).get(22) + "x" + GetData.dbQuery(save,"*",toons,"toonID",
            toonid,false).get(21));
    }

    private static void detailsButton(String save,String toons,List<String> team,
        JList jlist, JLabel hidden) throws SQLException {
        String[] hiddenstats = hidden.getText().split("x");
        String message = (GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(1))+"\n\n"+
            "Age: " + 
            Calculator.getAge(Integer.parseInt(hiddenstats[2]),((GetData.dbQuery
            (save,"*","dbRace","raceID",(GetData.dbQuery(save,"*",toons,"toonID"
            ,team.get(jlist.getSelectedIndex()),false).get(2)), false)).get(0)))
            + "\nAlignment: " +
            ((GetData.dbQuery(save,"*","dbAlign","alignID",(Calculator.getAlign
            (Integer.parseInt(hiddenstats[0]))),false)).get(1))
            + "\nGender: " +    
            ((GetData.dbQuery(save,"*","dbGender","genderID",hiddenstats[1], false)).get(1))
            + "\nSize: " +    
            ((GetData.dbQuery(save,"*","dbSize","sizeID",hiddenstats[3], false)).get(1))
            + "\nRace: " +    
            ((GetData.dbQuery(save,"*","dbRace","raceID",(GetData.dbQuery(save,
            "*",toons,"toonID",team.get(jlist.getSelectedIndex()),false).get(2))
            , false)).get(1))
            + "\nClass: " +
            ((GetData.dbQuery(save,"*","dbClass","classID",(GetData.dbQuery(save,
            "*",toons,"toonID",team.get(jlist.getSelectedIndex()),false).get(3))
            , false)).get(1))
            + "\nLevel: " + Calculator.getLevel("curlv", hiddenstats[4])
            + "\nExperience: " + hiddenstats[4]
            + "\nCurrent Status: " + "Normal"
            //status to be fixed at a later time 
            + "\n\nStatus is not accurate at this time." 
            + "\n\nNOTE: More functionality will be added here.";
        Popups.infoPopup("[" + (GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(1)) + "]", 
            message);
    }    

    
    private static void itemsButton(String save,String toons,List<String> team,
        JList jlist) throws SQLException {
        String[] heldlist = collectStats((((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(13))
            .replaceAll("nullx","")).replaceAll("null","").split("x")),save,
            "dbItems","itemID",1);
        String[] wearlist = collectStats((((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(14))
            .replaceAll("nullx","")).replaceAll("null","").split("x")),save,
            "dbItems","itemID",1);
        String[] charmslist = collectStats((((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(15))
            .replaceAll("nullx","")).replaceAll("null","").split("x")),save,
            "dbItems","itemID",1);
        String[] invlist = collectStats((((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(16))
            .replaceAll("nullx","")).replaceAll("null","").split("x")),save,
            "dbItems","itemID",1);
        String finallist = "";
        if(heldlist.length >= 1) {
            finallist += "[Equipment Held]\n\n";
            for(int x=0; x < heldlist.length; x++) {
                finallist += heldlist[x] + "\n";
            }
            finallist += "\n";
        }
        if(wearlist.length >= 1) {
            finallist += "[Wearables Equipped]\n\n";
            for(int x=0; x < wearlist.length; x++) {
                finallist += wearlist[x] + "\n";
            }
            finallist += "\n";
        }
        if(charmslist.length >= 1) {
            finallist += "[Charms Equipped]\n\n";
            for(int x=0; x < charmslist.length; x++) {
                finallist += charmslist[x] + "\n";
            }
            finallist += "\n";
        }
        if(invlist.length >= 1) {
            finallist += "[Inventory Carried]\n\n";
            for(int x=0; x < invlist.length; x++) {
                finallist += invlist[x] + "\n";
            } 
            finallist += "\n";
        }
        if(finallist.replaceAll("[^a-zA-Z0-9]", "").length() <= 0) {
            finallist = "[Inventory is Empty]";
        }
        Popups.infoPopup((GetData.dbQuery(save,"*",toons,"toonID",team.get(jlist
            .getSelectedIndex()),false).get(1)) + " Inventory", finallist + "\n"
            +"NOTE:  There will be a future\noption to change inventory here.");
    }

    private static String [] collectStats(String[] raw,String save,String table,
        String col,int field) throws SQLException {
        List<Object> rawlist = Arrays.stream(raw).collect(Collectors.toList());
        List<Object> newlist = new ArrayList<>();
        if(!rawlist.get(0).equals("null") && !rawlist.get(0).equals("")) {
            for(int item = 0; item < rawlist.size(); item++) {
                newlist.add(getStat(save,table,col,rawlist.get(item).toString(),
                    field));
            }
        } else {
            return new String[0];
        }
        return newlist.toArray(new String[newlist.size()]);
    }
    
    private static String getStat(String save,String table,String col,String 
        id,int field) throws SQLException {
        return GetData.dbQuery(save,"*",table,col,id,false).get(field);
    }
    
    private static void ablButton(String save,String toons,List<String> team,
        JList jlist, JLabel hidden) throws SQLException {
        String[] hiddenstats = hidden.getText().split("x");
        //toon,align,gender,items,race,class,size
        String abltemp = (((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(11))
            .replaceAll("nullx","")).replaceAll("null","")) + "x" + (((GetData.
            dbQuery(save,"*","dbAlign","alignID",Calculator.alignvaltoID(save, 
            Integer.parseInt(hiddenstats[0])),false).get(7)).replaceAll("nullx",
            "")).replaceAll("null",""))+"x"+((GetData.dbQuery(save,"*",
            "dbGender","genderID",hiddenstats[1],false).get(7)).replaceAll(
            "nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery(save,"*",
            "dbRace","raceID",(GetData.dbQuery(save,"*",toons,"toonID",team.get
            (jlist.getSelectedIndex()),false).get(2)),false).get(8)).replaceAll(
            "nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery(save,"*",
            "dbClass","classID",(GetData.dbQuery(save,"*",toons,"toonID",team
            .get(jlist.getSelectedIndex()),false).get(3)),false).get(5))
            .replaceAll("nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery
            (save,"*","dbSize","sizeID",hiddenstats[3],false).get(5)).replaceAll
            ("nullx","")).replaceAll("null","")+"x";
            String[] itemlist=(((GetData.dbQuery(save,"*",toons,"toonID",team.
                get(jlist.getSelectedIndex()),false).get(13))+"x"+(GetData.
                dbQuery(save,"*",toons,"toonID",team.get(jlist.getSelectedIndex(
                )),false).get(14))+"x"+(GetData.dbQuery(save,"*",toons,"toonID",
                team.get(jlist.getSelectedIndex()),false).get(15))).split("x"));
            List<String> itemabls = Arrays.stream(itemlist).collect(Collectors
                .toList());
            itemabls.removeAll(Collections.singleton("null"));
            for (int x = 0; x < itemabls.size(); x++) {
                abltemp += (GetData.dbQuery(save,"*","dbItems","itemID",itemabls
                    .get(x),false).get(11)).replaceAll("null", "") + "x";
            }
            String ablfinalist= abltemp.charAt(0)+"";
            char [] cA =abltemp.toCharArray();
            for(int i =0; i+1<cA.length; ++i) {
                if(!Character.isDigit(abltemp.charAt(i)) || !Character.isLetter(
                    'x')) {
                    if((abltemp.charAt(i) != abltemp.charAt(i+1))) {
                        ablfinalist += abltemp.charAt(i+1); 
                    }
                } else {
                    ablfinalist +=abltemp.charAt(i+1);
                }
            }
            if(ablfinalist.startsWith("x")) {
                ablfinalist = ablfinalist.substring(1,ablfinalist.length());
            }
            if(ablfinalist.endsWith("x")) {
                ablfinalist = ablfinalist.substring(0,ablfinalist.length() - 1);
            }
             String[] abllist = collectStats((ablfinalist.split("x")),save,
                "dbAbl","ablID",1);
             String[] abldesclist = collectStats((ablfinalist.split("x")),save,
                "dbAbl","ablID",2);
        String message="";
        if(abllist.length >= 1) {
            message += "[Ablilities List]\n\n";
            for(int x=0; x < abllist.length; x++) {
                message += abllist[x] + ": " + abldesclist[x] + "\n";
            }
            message += "\n";
        }
        if(message.replaceAll("[^a-zA-Z0-9]", "").length() <= 0) {
            message = "<No Abilities>\n";
        }
        Popups.infoPopup((GetData.dbQuery(save,"*",toons,"toonID",team.get(jlist
            .getSelectedIndex()),false).get(1)) + " Abilities List", message +
            "\n" +"NOTE:  There will be a future option to navigate\nfurther in"
            + "to abilities here.");
    }    

    private static void effButton(String save,String toons,List<String> team,
        JList jlist, JLabel hidden) throws SQLException {
        String[] hiddenstats = hidden.getText().split("x");
        //toon,align,gender,items,race,class,size
        String efftemp = (((GetData.dbQuery(save,"*",toons,
            "toonID",team.get(jlist.getSelectedIndex()),false).get(12))
            .replaceAll("nullx","")).replaceAll("null","")) + "x" + (((GetData.
            dbQuery(save,"*","dbAlign","alignID",Calculator.alignvaltoID(save, 
            Integer.parseInt(hiddenstats[0])),false).get(7)).replaceAll("nullx",
            "")).replaceAll("null",""))+"x"+((GetData.dbQuery(save,"*",
            "dbGender","genderID",hiddenstats[1],false).get(6)).replaceAll(
            "nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery(save,"*",
            "dbRace","raceID",(GetData.dbQuery(save,"*",toons,"toonID",team.get
            (jlist.getSelectedIndex()),false).get(2)),false).get(9)).replaceAll(
            "nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery(save,"*",
            "dbClass","classID",(GetData.dbQuery(save,"*",toons,"toonID",team
            .get(jlist.getSelectedIndex()),false).get(3)),false).get(6))
            .replaceAll("nullx","")).replaceAll("null","")+"x"+((GetData.dbQuery
            (save,"*","dbSize","sizeID",hiddenstats[3],false).get(6)).replaceAll
            ("nullx","")).replaceAll("null","")+"x";
            String[] itemlist=(((GetData.dbQuery(save,"*",toons,"toonID",team.
                get(jlist.getSelectedIndex()),false).get(13))+"x"+(GetData.
                dbQuery(save,"*",toons,"toonID",team.get(jlist.getSelectedIndex(
                )),false).get(14))+"x"+(GetData.dbQuery(save,"*",toons,"toonID",
                team.get(jlist.getSelectedIndex()),false).get(15))).split("x"));
            List<String> itemeffs = Arrays.stream(itemlist).collect(Collectors
                .toList());
            itemeffs.removeAll(Collections.singleton("null"));
            for (int x = 0; x < itemeffs.size(); x++) {
                efftemp += (GetData.dbQuery(save,"*","dbItems","itemID",itemeffs
                    .get(x),false).get(12)).replaceAll("null", "") + "x";
            }
            String efffinalist= efftemp.charAt(0)+"";
            char [] cA =efftemp.toCharArray();
            for(int i =0; i+1<cA.length; ++i) {
                if(!Character.isDigit(efftemp.charAt(i)) || !Character.isLetter(
                    'x')) {
                    if((efftemp.charAt(i) != efftemp.charAt(i+1))) {
                        efffinalist += efftemp.charAt(i+1); 
                    }
                } else {
                    efffinalist +=efftemp.charAt(i+1);
                }
            }
            if(efffinalist.startsWith("x")) {
                efffinalist = efffinalist.substring(1,efffinalist.length());
            }
            if(efffinalist.endsWith("x")) {
                efffinalist = efffinalist.substring(0,efffinalist.length() - 1);
            }
             String[] efflist = collectStats((efffinalist.split("x")),save,
                "dbEffects","effID",1);
             String[] effdesclist = collectStats((efffinalist.split("x")),save,
                "dbEffects","effID",2);
        String message="";
        if(efflist.length >= 1) {
            message += "[Effects List]\n\n";
            for(int x=0; x < efflist.length; x++) {
                message += efflist[x] + ": " + effdesclist[x] + "\n";
            }
            message += "\n";
        }
        if(message.replaceAll("[^a-zA-Z0-9]", "").length() <= 0) {
            message = "<No Effects>\n";
        }
        Popups.infoPopup((GetData.dbQuery(save,"*",toons,"toonID",team.get(jlist
            .getSelectedIndex()),false).get(1)) + " Effects List", message +
            "\n" +"NOTE:  There will be a future option to navigate\nfurther in"
            + "to effects here.");
    }    

    private void confirmButton() throws BadLocationException {
        String userInput = inputText.getText();
        new TypeEffect(mainText,userInput + "\n",10).start();
        //more function here

    }
    
    private void exitButton() throws IOException, Exception {
        String text = "Do you want to go back to the Main Menu or Exit the Game"
                + "?";
        String[] options = new String[] {"Back To Menu","Exit The Game"};
        int menuchoice;
        boolean exitchoice = yesorNo("Are you sure you want to exit?","Exit the"
                + " Game?");
        if(exitchoice == true) {
            menuchoice = popupResponse(options, "Exit the Game?", text);
            switch(menuchoice) {
            case 0:
                try {
                    menuOption();
                } catch (IOException ex) {
                    logFile("severe","New Exit Button Error.\nIOEx: " + ex.
                            toString());
                    exitProcess();
                }
                break;
            default:
                MainControls.clearTemp();
                exitProcess();
                break;
            }
        }
    }
    
    private boolean yesorNo(String message, String popup) {
        int answer = JOptionPane.showConfirmDialog(null,message,popup,
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(answer == JOptionPane.NO_OPTION) {
                return false;
            } else {
                return true;
            }
    }
    
    private int popupResponse(String[] options, String title, String message) {
        int response = JOptionPane.showOptionDialog(null, message, title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.
                PLAIN_MESSAGE,null, options, options[0]);
        return response;
    }
    
    private void menuOption() throws IOException, Exception {
        try {
            System.gc();
            this.dispose();
            new MainMenuGUI().setVisible(true);
        } catch(IOException ex) {
            logFile("severe","MenuOption Error.\nIOEx: " + ex.toString());
        }
    }

    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    private void exitProcess() throws IOException, JavaLayerException {
        cleanUp();
        System.exit(0);
    }
    
  

    //<editor-fold defaultstate="collapsed" desc="Main Start Method"> 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BattleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BattleGUI().setVisible(true);
                } catch (SQLException ex) {
                    //
                }
            }
        });
    }
    //</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Footer">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel battletitleLabel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField inputText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JTextArea mainText;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JButton team0AblButton;
    private javax.swing.JButton team0DetailsButton1;
    private javax.swing.JButton team0EffButton;
    private static javax.swing.JLabel team0Hidden;
    private static javax.swing.JLabel team0Info;
    private javax.swing.JButton team0ItemsButton;
    private static javax.swing.JLabel team0Label;
    private static javax.swing.JList<String> team0List;
    private static javax.swing.JScrollPane team0Pane;
    private javax.swing.JScrollPane team0TPane;
    private static javax.swing.JTable team0Table;
    private static javax.swing.JLabel team0Toon;
    private javax.swing.JButton team1AblButton;
    private javax.swing.JButton team1DetailsButton;
    private javax.swing.JButton team1EffButton;
    private static javax.swing.JLabel team1Hidden;
    private static javax.swing.JLabel team1Info;
    private javax.swing.JButton team1ItemsButton;
    private static javax.swing.JLabel team1Label;
    private static javax.swing.JList<String> team1List;
    private static javax.swing.JScrollPane team1Pane;
    private javax.swing.JScrollPane team1TPane;
    private static javax.swing.JTable team1Table;
    private static javax.swing.JLabel team1Toon;
    private javax.swing.JLabel titleLogo;
    // End of variables declaration//GEN-END:variables
//</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String log) throws IOException {
        try {
            new LogWriter().writeLog(type,log);
        } catch(IOException ioex) {
            logFile("severe","logFile Method error:  Cannot fine log file (infi"
                    + "nite loop)!\nException:  " + ioex);
        }
    }
//</editor-fold>  
}
