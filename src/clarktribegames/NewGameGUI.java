
// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javazoom.jl.decoder.JavaLayerException;



/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class NewGameGUI extends javax.swing.JFrame {

    String appName;
    String appVer;
    String saveName = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
    List<String> toonList = null;
    DefaultComboBoxModel toonDml = new DefaultComboBoxModel();
    
    public NewGameGUI() throws IOException, Exception {
        this.appName = MainControls.appName;
        this.appVer = MainControls.appVer;

        initComponents();
        setLocationRelativeTo(null);  
        popcharDrop(saveName);
        changeChar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newgameLabel = new javax.swing.JLabel();
        titleLogo = new javax.swing.JLabel();
        saveLabel = new javax.swing.JLabel();
        charToon = new javax.swing.JLabel();
        selectLabel = new javax.swing.JLabel();
        charDrop = new javax.swing.JComboBox<>();
        exitButton = new javax.swing.JButton();
        limitLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        stat01Label = new javax.swing.JLabel();
        stat02Label = new javax.swing.JLabel();
        stat03Label = new javax.swing.JLabel();
        stat04Label = new javax.swing.JLabel();
        bioPane = new javax.swing.JScrollPane();
        bioText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(this.appName + " [ALPHA v" + this.appVer + "]");
        setIconImage(new MainControls().imageIcon.getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        newgameLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        newgameLabel.setText("New Game • Character Selection");
        newgameLabel.setFocusable(false);

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N

        saveLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saveLabel.setText("Current Limitless Database:");
        saveLabel.setFocusable(false);

        charToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        charToon.setText("[Player 1 Image Here]");
        charToon.setFocusable(false);

        selectLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        selectLabel.setText("Select Your Character:");
        selectLabel.setFocusable(false);

        charDrop.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Populated List>" }));
        charDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charDropActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        exitButton.setText("Back to Main Menu");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        limitLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        limitLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        limitLabel.setText("<Limit File Name>");
        limitLabel.setFocusable(false);

        confirmButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        confirmButton.setText("Start New Game");

        stat01Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat01Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat01Label.setText("<Alignment>");

        stat02Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat02Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat02Label.setText("<Age> • <Race>");

        stat03Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat03Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat03Label.setText("Level <Lv> • <Class>");

        stat04Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat04Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat04Label.setText("<Status>");

        bioPane.setBorder(null);
        bioPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bioPane.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        bioText.setColumns(20);
        bioText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        bioText.setLineWrap(true);
        bioText.setRows(9);
        bioText.setText("Player name is a <alignment> <age modifier> Level <lv> <race> <class> <status modifier>.  <Add bio info>");
        bioText.setWrapStyleWord(true);
        bioPane.setViewportView(bioText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newgameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limitLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stat01Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(charToon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(charDrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(780, 780, 780)
                        .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stat02Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stat03Label, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(stat04Label, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(bioPane))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newgameLabel)
                    .addComponent(limitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(charToon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectLabel)
                .addGap(18, 18, 18)
                .addComponent(charDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stat01Label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stat02Label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stat03Label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stat04Label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bioPane, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(confirmButton))
                .addContainerGap())
        );

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

    private void charDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charDropActionPerformed
        try {
            changeChar();
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_charDropActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
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
    }//GEN-LAST:event_exitButtonActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Main Void">
    public static void main(String args[]) throws IOException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.
                    UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            logFile("severe","NG Main Void Exception Error.\nException: " + ex.
                    toString());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewGameGUI().setVisible(true);
                } catch (IOException ex) {
                    try {
                        logFile("severe","NGRunError.\nIOEx: " + ex.toString());
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    //</editor-fold>
    
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

    private void popcharDrop(String save) throws SQLException, IOException {
        limitLabel.setText(saveName);
        try {
            toonList=GetData.dbQuery(save,"*","dbToonGame","toonName","",true);
            fillSelect(charDrop,(toonList),toonDml);
        } catch(Exception ex) {
            logFile("severe","Char Select Error.\nEx: " + ex.toString());
        }
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
 
    private void setChar(String save, String toonname) throws SQLException, 
        BadLocationException {
        List<String> toonStats = GetData.dbQuery(save, "*","dbToons",
            "toonName",toonname, false);
        new Avatars().setAvatar(charToon, charDrop.getSelectedItem().toString(), toonStats.get(11));
        stat01Label.setText((GetData.dbQuery(save, "*",
            "dbAlign","alignID",toonStats.get(4), false)).get(1));
        stat02Label.setText((Calculator.getAge(Integer.parseInt(toonStats
            .get(8)),toonStats.get(2))) + " • " + (GetData.dbQuery(save, "*",
            "dbRace","raceID",toonStats.get(2), false)).get(1));
        
        stat03Label.setText("Level <lv#>" + " • " + (GetData.dbQuery(save, "*",
            "dbClass","classID",toonStats.get(3), false)).get(1));
        String bioInfo = charDrop.getSelectedItem() + " is a " + ((GetData.dbQuery(save, "*",
            "dbAlign","alignID",toonStats.get(4), false)).get(29)) + " " + (Calculator.getAge(Integer.parseInt(toonStats
            .get(8)),toonStats.get(2))) + " Level <lv> " + ((GetData.dbQuery(save, "*",
            "dbRace","raceID",toonStats.get(2), false)).get(29)) + " " + ((GetData.dbQuery(save, "*",
            "dbClass","classID",toonStats.get(3), false)).get(29)) + " in <health status here>.\n\n" + toonStats.get(10);
        bioText.setText(bioInfo);
        
        
    }
    
    private void changeChar() throws SQLException, BadLocationException {
        setChar(saveName, (String) charDrop.getSelectedItem());
    }
            
    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    private void exitProcess() throws IOException, JavaLayerException {
        cleanUp();
        System.exit(0);
    }
    
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

//<editor-fold defaultstate="collapsed" desc="Footer Info">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bioPane;
    private javax.swing.JTextArea bioText;
    private javax.swing.JComboBox<String> charDrop;
    private javax.swing.JLabel charToon;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JLabel newgameLabel;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel stat01Label;
    private javax.swing.JLabel stat02Label;
    private javax.swing.JLabel stat03Label;
    private javax.swing.JLabel stat04Label;
    private javax.swing.JLabel titleLogo;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}