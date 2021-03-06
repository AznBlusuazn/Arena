package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
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

    public BattleGUI() throws SQLException, InterruptedException {
        initComponents();
        setLocationRelativeTo(null);
        prepBattle(MemoryBank.savToons,Arrays.asList(BattleEngine.team0),Arrays.
            asList(BattleEngine.team1));
        BattleEngine.battleStart(MemoryBank.savToons
        );
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
        saveLabel.setEnabled(false);
        saveLabel.setFocusable(false);
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 11, 230, 21));

        limitLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        limitLabel.setText(" "
            //"[" + Converters.capFirstLetter(BattleEngine.saveToons.substring(3,BattleEngine.saveToons.length()).replaceAll("Toons","")) +
            //            "] • [Database: " + Converters.capFirstLetter(BattleEngine.saveName).replaceAll("." + MainControls.saveExt,"") + "]"
        );
        limitLabel.setEnabled(false);
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
        } catch (BadLocationException | SQLException | InterruptedException ex) {
            //
        } catch (Exception ex) {
            //
        }
       
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void team1DetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1DetailsButtonActionPerformed
         try {
             detailsButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team1)
                ,team1List);
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1DetailsButtonActionPerformed

    private void team0DetailsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0DetailsButton1ActionPerformed
         try {
             detailsButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team0)
                ,team0List);
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0DetailsButton1ActionPerformed

    private void team1ItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1ItemsButtonActionPerformed
        try {
            itemsButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team1),
                team1List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1ItemsButtonActionPerformed

    private void team1AblButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1AblButtonActionPerformed
        try {
            ablButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team1),
                team1List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1AblButtonActionPerformed

    private void team1EffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team1EffButtonActionPerformed
        try {
            effButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team1),
                team1List);            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team1EffButtonActionPerformed

    private void team0ItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0ItemsButtonActionPerformed
        try {
            itemsButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team0),
                team0List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0ItemsButtonActionPerformed

    private void team0AblButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0AblButtonActionPerformed
        try {
            ablButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team0),
                team0List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0AblButtonActionPerformed

    private void team0EffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team0EffButtonActionPerformed
        try {
            effButton(MemoryBank.savToons,Arrays.asList(BattleEngine.team0),
                    team0List);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_team0EffButtonActionPerformed
    //</editor-fold> 

    private static void prepBattle(List<String>toons,
        List<String> team0,List<String> team1) throws SQLException {
        popteamLists(toons,team0,team0Pane,team0List);
        popteamLists(toons,team1,team1Pane,team1List);
        popAvatars(team0Toon,team0List);
        popAvatars(team1Toon,team1List);
        popTooninfo(toons,team0,team0Label,team0Info,team0List,team0Table);
        popTooninfo(toons,team1,team1Label,team1Info,team1List,team1Table);
    }

    private static void popteamLists(List<String>toons,
        List<String> team,JScrollPane jpane, JList jlist) throws SQLException { 
        DefaultListModel dml = new DefaultListModel();
        int totalteam = team.size();
        if(totalteam > 1) {
            jpane.setEnabled(true);
            for(int player = 0; player < totalteam; player++) {
                GetStats.getitemsfromIDtoJList(team,dml,jlist,toons,0,1);
            }
        } else {
            GetStats.getitemsfromIDtoJList(team,dml,jlist,toons,0,1);            
            jlist.setSelectedIndex(0);
            jpane.setVisible(false);
        }
    }
    
    private static void popAvatars(JLabel avatar, JList jlist) {
        Avatars.setAvatar(avatar,jlist.getSelectedValue().toString(),null);
    }
    
    private static void popTooninfo(List<String> toons,List<String> 
        team,JLabel namebox,JLabel infobox, JList jlist,JTable table) throws 
        SQLException { 
        String[] tooninfo=Converters.expListtoArray(toons.get(Integer.parseInt(
            team.get(jlist.getSelectedIndex()))));
        namebox.setText(tooninfo[1]);
        List<String> combined = new ArrayList<>();
        combined.addAll(Arrays.asList((tooninfo[23]).split("x")));
        infobox.setForeground((Converters.figureoutColor(GetStats.getalignColor(
            Integer.parseInt(tooninfo[4])))));
        infobox.setText(tooninfo[28]+" "+tooninfo[29]+" ("+tooninfo[8]+")");
        DefaultTableModel dml = (DefaultTableModel)table.getModel();
        dml.setValueAt("Normal", 0, 1);
        for(int item = 1; item < dml.getRowCount(); item++) {
            dml.setValueAt(combined.get(item + 7), item, 1);
        }
    }

    private static void detailsButton(List<String> toons,
        List<String> team,JList jlist) throws SQLException {
        String[] tooninfo=Converters.expListtoArray(toons.get(Integer.parseInt(
            team.get(jlist.getSelectedIndex()))));
        String message = tooninfo[1]+"\n\n"+
            "Age: " + tooninfo[26] + "\n" +
            "Alignment: " + tooninfo[24] + "\n" +
            "Gender: " + tooninfo[25] + "\n" +
            "Size: " + tooninfo[27] + "\n" +
            "Race: " + tooninfo[28] + "\n" +
            "Class: " + tooninfo[29] + "\n" +
            "Level: " + tooninfo[8] + "\n" +
            "Experience: " + tooninfo[20] + "\n" +
            "Current Status: " + "Normal" + "\n" +
            //status to be fixed at a later time 
            "Status is not accurate at this time." 
            + "\n\nNOTE: More functionality will be added here.";
        Popups.infoPopup("[" + tooninfo[1] + "]", 
            message);
    }    

    private static void itemsButton(List<String> toons,List<String> team,
        JList jlist) throws SQLException {
        String[] tooninfo=Converters.expListtoArray(toons.get(Integer.parseInt(
                team.get(jlist.getSelectedIndex()))));
        String[] heldlist=collectStats(((tooninfo[13].replaceAll("nullx","")
            ).replaceAll("null","").split("x")),MemoryBank.dbItems,0,1);
        String[] wearlist=collectStats(((tooninfo[14].replaceAll("nullx","")
            ).replaceAll("null","").split("x")),MemoryBank.dbItems,0,1);
        String[] charmslist=collectStats(((tooninfo[15].replaceAll("nullx",
            "")).replaceAll("null","").split("x")),MemoryBank.dbItems,0,1);
        String[] invlist=collectStats(((tooninfo[16].replaceAll("nullx",""))
            .replaceAll("null","").split("x")),MemoryBank.dbItems,0,1);
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
        Popups.infoPopup(tooninfo[1] + " Inventory", finallist + "\n"
            +"NOTE:  There will be a future\noption to change inventory here.");
    }

    private static String [] collectStats(String[] raw,List<String> table,
        int matchcol,int fetchcol) throws SQLException {
        List<Object> rawlist = Arrays.stream(raw).collect(Collectors.toList());
        List<Object> newlist = new ArrayList<>();
        if(!(ChecksBalances.isNullOrEmpty(rawlist.get(0).toString()))) {
            for(int item = 0; item < rawlist.size(); item++) {
                newlist.add(getStat(table,rawlist.get(item).toString(),matchcol,
                    fetchcol));
            }
        } else {
            return new String[0];
        }
        return newlist.toArray(new String[newlist.size()]);
    }
    
    private static String getStat(List<String> table,String id,int matchcol,int 
        fetchcol) throws SQLException {
        return Converters.fetchfromTable(table,id,matchcol,fetchcol);
    }
    
    private static void ablButton(List<String> toons,List<String> team,
        JList jlist) throws SQLException {
        String[] tooninfo=Converters.expListtoArray(MemoryBank.dbToons.get(
            Integer.parseInt(team.get(jlist.getSelectedIndex()))));
        //toon,align,gender,items,race,class,size
        String toonAbl=tooninfo[11];
        String alignAbl=Converters.fetchfromTable(MemoryBank.dbAlign,Calculator.
            alignvaltoID(Integer.parseInt(tooninfo[4])),0,7);
        String gendAbl=Converters.fetchfromTable(MemoryBank.dbGender,tooninfo[6]
            ,0,7);
        String raceAbl=Converters.fetchfromTable(MemoryBank.dbRace,tooninfo[2],0
            ,8);
        String classAbl=Converters.fetchfromTable(MemoryBank.dbClass,tooninfo[3]
            ,0,5);
        String sizeAbl=Converters.fetchfromTable(MemoryBank.dbSize,tooninfo[21],
            0,5);
        String tempAbl=toonAbl+"x"+alignAbl+"x"+gendAbl+"x"+raceAbl+"x"+classAbl
            +"x"+sizeAbl+"x";
        String abltemp=tempAbl.replaceAll("xnull","").replaceAll("null","");
        String[] itemlist=((tooninfo[13]+"x"+tooninfo[14]+"x"+tooninfo[15]).
            split("x"));
        List<String> itemabls = Arrays.stream(itemlist).collect(Collectors
            .toList());
        itemabls.removeAll(Collections.singleton("null"));
        for (int x = 0; x < itemabls.size(); x++) {
            abltemp += Converters.fetchfromTable(MemoryBank.dbItems,itemabls.get
                (x),0,11).replaceAll("null", "") + "x";
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
         String[] abllist = collectStats((ablfinalist.split("x")),MemoryBank.
            dbAbl,0,1);
         String[] abldesclist = collectStats((ablfinalist.split("x")),MemoryBank
            .dbAbl,0,2);
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
        Popups.infoPopup(Converters.fetchfromTable(toons,team.get(jlist.
            getSelectedIndex()),0,1)+" Abilities List",message+"\n"+
            "NOTE:  There will be a future option to navigate\nfurther into "
            + "abilities here.");
    }    

    private static void effButton(List<String> toons,List<String> team,
        JList jlist) throws SQLException {
        String[] tooninfo=Converters.expListtoArray(MemoryBank.dbToons.get(
            Integer.parseInt(team.get(jlist.getSelectedIndex()))));
        String toonEff=tooninfo[11];
        String alignEff=Converters.fetchfromTable(MemoryBank.dbAlign,Calculator.
            alignvaltoID(Integer.parseInt(tooninfo[4])),0,8);
        String gendEff=Converters.fetchfromTable(MemoryBank.dbGender,tooninfo[7]
            ,0,7);
        String raceEff=Converters.fetchfromTable(MemoryBank.dbRace,tooninfo[2],0
            ,9);
        String classEff=Converters.fetchfromTable(MemoryBank.dbClass,tooninfo[3]
            ,0,6);
        String sizeEff=Converters.fetchfromTable(MemoryBank.dbSize,tooninfo[21],
            0,6);
        String tempEff = toonEff+"x"+alignEff+"x"+gendEff+"x"+raceEff+"x"+
            classEff+"x"+sizeEff+"x";
        String efftemp = tempEff.replaceAll("xnull","").replaceAll("null","");
        String[] itemlist=((tooninfo[13]+"x"+tooninfo[14]+"x"+tooninfo[15]).
            split("x"));
        
        List<String> itemeffs = Arrays.stream(itemlist).collect(Collectors
            .toList());
        itemeffs.removeAll(Collections.singleton("null"));
        for (int x = 0; x < itemeffs.size(); x++) {
            efftemp += Converters.fetchfromTable(MemoryBank.dbItems,itemeffs.get
                (x),0,12).replaceAll("null", "") + "x";
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
         String[] efflist = collectStats((efffinalist.split("x")),MemoryBank.
            dbEffects,0,1);
         String[] effdesclist = collectStats((efffinalist.split("x")),MemoryBank
            .dbEffects,0,2);
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
        Popups.infoPopup(Converters.fetchfromTable(toons,team.get(jlist.
            getSelectedIndex()),0,1)+" Effects List",message+"\n"+
            "NOTE:  There will be a future option to navigate\nfurther into "
            + "effects here.");
    }          

    private static void confirmButton() throws BadLocationException, 
        SQLException, InterruptedException, Exception {
        //String userInput = inputText.getText();
        //new TypeEffect(mainText,userInput + "\n",10,true,inputText,confirmButton).start();
        BattleEngine.nextTurn(MemoryBank.savToons);
        //more function here

    }
    
    public static void writeBattle(String string) {

        new TypeEffect(mainText,string + "\n",10,true,inputText,confirmButton).
            start();

    }
    
    public static void pressConfirm() throws BadLocationException, SQLException,
        InterruptedException, Exception {
        confirmButton();
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
            MPlayer.stopMedia();
            System.gc();
            this.dispose();
            //Return to menu here
            Limitless.menuPanel.setVisible(true);

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
    
    public static JTable getTable(int table) {
        if(table == 1) {
            return team1Table;
        } else {
            return team0Table;
        }
    }
    
    public static JLabel getHidden(int label) {
        if(label == 1) {
            return team1Hidden;
        } else {
            return team0Hidden;
        }
    }
  

    //<editor-fold defaultstate="collapsed" desc="Main Start Method"> 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.
                UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
            IllegalAccessException | javax.swing.UnsupportedLookAndFeelException
            ex) {
            ex.printStackTrace();
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BattleGUI().setVisible(true);
                } catch (SQLException | InterruptedException ex) {
                    //
                }
                //
                
            }
        });
    }
    //</editor-fold> 
    
//<editor-fold defaultstate="collapsed" desc="Footer">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel battletitleLabel;
    private javax.swing.JPanel bottomPanel;
    private static javax.swing.JButton confirmButton;
    private static javax.swing.JTextField inputText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel limitLabel;
    private static javax.swing.JTextArea mainText;
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
