package clarktribegames;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public BattleGUI() {
        initComponents();
        setLocationRelativeTo(null);
        prepBattle(BattleEngine.saveName, BattleEngine.saveToons, BattleEngine.saveMax, Arrays.asList(BattleEngine.team0), Arrays.asList(BattleEngine.team1));
    }

    //<editor-fold defaultstate="collapsed" desc="JSwing Code"> 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomPanel = new javax.swing.JPanel();
        team1ItemsButton = new javax.swing.JButton();
        team1AblButton = new javax.swing.JButton();
        team1EffButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setMaximumSize(new java.awt.Dimension(1220, 800));
        setMinimumSize(new java.awt.Dimension(1220, 800));
        setPreferredSize(new java.awt.Dimension(1220, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1220, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bottomPanel.setFocusable(false);
        bottomPanel.setMaximumSize(new java.awt.Dimension(1200, 60));
        bottomPanel.setMinimumSize(new java.awt.Dimension(1200, 60));
        bottomPanel.setPreferredSize(new java.awt.Dimension(1200, 60));
        getContentPane().add(bottomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1200, 60));

        team1ItemsButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1ItemsButton.setText("Items");
        getContentPane().add(team1ItemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, -1, 20));

        team1AblButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1AblButton.setText("Abilities");
        getContentPane().add(team1AblButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 425, -1, 20));

        team1EffButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team1EffButton.setText("Effects");
        getContentPane().add(team1EffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 425, 75, 20));

        jButton4.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        jButton4.setText("Items");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 425, -1, 20));

        team0AblButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0AblButton.setText("Abilities");
        getContentPane().add(team0AblButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 425, -1, 20));

        team0EffButton.setFont(new java.awt.Font("Lucida Sans", 0, 10)); // NOI18N
        team0EffButton.setText("Effects");
        getContentPane().add(team0EffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 425, 75, 20));

        rightPanel.setFocusable(false);
        rightPanel.setMaximumSize(new java.awt.Dimension(10, 800));
        rightPanel.setMinimumSize(new java.awt.Dimension(10, 800));
        rightPanel.setPreferredSize(new java.awt.Dimension(10, 800));
        getContentPane().add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 30, 800));

        battletitleLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        battletitleLabel.setText("Battle Between [" + BattleEngine.team0[0] + " vs. " + BattleEngine.team1[0] + "]");
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

        getContentPane().add(team1Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 100));

        team1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team1Toon.setText("[Team 1 Image Here]");
        team1Toon.setFocusable(false);
        getContentPane().add(team1Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 200));

        team0List.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        team0List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Team 0 Toon List" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        team0List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        team0List.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        team0Pane.setViewportView(team0List);

        getContentPane().add(team0Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 200, 100));

        team0Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        team0Toon.setText("[Team 0 Image Here]");
        team0Toon.setFocusable(false);
        getContentPane().add(team0Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 200, 200));

        team1Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        team1Label.setText("<Team 1 Active Character>");
        getContentPane().add(team1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 20));

        team0Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        team0Label.setText("<Team 0 Active Character>");
        getContentPane().add(team0Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 200, 20));

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

        mainText.setColumns(20);
        mainText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mainText.setLineWrap(true);
        mainText.setRows(5);
        jScrollPane1.setViewportView(mainText);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 760, 460));

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
    //</editor-fold> 

    private static void prepBattle(String save, String toons, String max, List<String> team0, List<String> team1) {
        
    }



    private void confirmButton() throws BadLocationException {
        String userInput = inputText.getText();
        new TypeEffect(mainText,userInput + "\n",10).start();
//        doc.insertString(doc.getLength(), userInput + "\n", null);
        
       // }
        
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
                new BattleGUI().setVisible(true);
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
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JTextArea mainText;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JButton team0AblButton;
    private javax.swing.JButton team0EffButton;
    private javax.swing.JLabel team0Label;
    private javax.swing.JList<String> team0List;
    private javax.swing.JScrollPane team0Pane;
    private javax.swing.JScrollPane team0TPane;
    private javax.swing.JTable team0Table;
    private javax.swing.JLabel team0Toon;
    private javax.swing.JButton team1AblButton;
    private javax.swing.JButton team1EffButton;
    private javax.swing.JButton team1ItemsButton;
    private javax.swing.JLabel team1Label;
    private javax.swing.JList<String> team1List;
    private javax.swing.JScrollPane team1Pane;
    private javax.swing.JScrollPane team1TPane;
    private javax.swing.JTable team1Table;
    private javax.swing.JLabel team1Toon;
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
