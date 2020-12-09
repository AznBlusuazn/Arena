// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javazoom.jl.decoder.JavaLayerException;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * @version IN DEVELOPMENT
 * 
 */
//</editor-fold>

public class MainMenuGUI extends javax.swing.JFrame {

    String appName;
    String appVer;
    
    public MainMenuGUI() throws IOException, Exception {
        this.appName = MainControls.appName;
        this.appVer = MainControls.appVer;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLogo = new javax.swing.JLabel();
        newButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        optButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        donateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(this.appName + " [ALPHA v" + this.appVer + "]");
        setIconImage(new MainControls().imageIcon.getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N

        newButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newButton.setText("Exhibition (Future New Game)");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        loadButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loadButton.setText("Disabled (Future Load Game)");
        loadButton.setEnabled(false);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setText("Disabled (Future Editor)");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        optButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        optButton.setText("Game Options");
        optButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aboutButton.setText("About This Game");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        donateButton.setBackground(new java.awt.Color(255, 0, 0));
        donateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        donateButton.setForeground(new java.awt.Color(255, 0, 0));
        donateButton.setText("Donate To The Cause");
        donateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(500, 500, 500))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(newButton)
                .addGap(25, 25, 25)
                .addComponent(loadButton)
                .addGap(25, 25, 25)
                .addComponent(editButton)
                .addGap(25, 25, 25)
                .addComponent(optButton)
                .addGap(25, 25, 25)
                .addComponent(aboutButton)
                .addGap(25, 25, 25)
                .addComponent(donateButton)
                .addGap(25, 25, 25)
                .addComponent(exitButton)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        try {
            newButton();
        } catch (Exception ex) {
            try {
                logFile("severe","New Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_newButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        loadButton();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        editButton();
    }//GEN-LAST:event_editButtonActionPerformed

    private void optButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optButtonActionPerformed
        try {
            optButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Opt Button Error.  EX: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_optButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        try {
            aboutButton();
        } catch (IOException ex) {
            try {
                logFile("severe","About Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void donateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateButtonActionPerformed
        try {
            donateButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Donate Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_donateButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            exitButton();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MPlayer.mediaPlayer(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        MPlayer.mediaPlayer(true);
    }//GEN-LAST:event_formWindowActivated
    
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
            logFile("severe","ST Main Void Exception Error.\nException: " + ex.
                    toString());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenuGUI().setVisible(true);
                } catch (IOException ex) {
                    try {
                        logFile("severe","Main Void Exception Error.\nException"
                                + ": " + ex.toString());
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

    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile Method error:  Cannot fine log file (infi"
                    + "nite loop)!\nException:  " + ioex);
        }
    }
    //</editor-fold>
    
    private void newButton() throws InterruptedException, SQLException, 
            IOException, URISyntaxException, Exception {
        //dispose();
        try {
            cleanUp();
            if(!MainControls.samedbOn) {
                limitSelect();
            } else {
                MainControls.selectedSave = MainControls.defaultDB + "." + 
                    MainControls.saveExt;
            }
            MPlayer.stopMedia();
            new NewGameGUI().setVisible(true);
        } catch(Exception ex) {
            logFile("severe","New Button Error.  Exception: " + ex);
        }
    }

    private void loadButton() {
        
    }

    private void editButton() {
        
    }


    private void optButton() throws IOException, InterruptedException {
        optionPopup();
    }


    private void aboutButton() throws IOException {
        try {
            aboutPopup();
        } catch(IOException ex) {
            logFile("severe","About Button Error.  Exception: " + ex);
        }
    }

    private void donateButton() throws IOException {
        try {
            donatePopup();
        } catch(IOException ex) {
            logFile("severe","Donate Button Error.  Exception: " + ex);
        }
    }
    
    private void exitButton() throws IOException, InterruptedException {
        String title = ("Exit the Game?");
        String message = "Are you sure you want to exit?";
        boolean exitChoice = Popups.yesnoPopup(title, message);
        if(exitChoice == true)
            exitProcess();
    }
    
    private void limitSelect() throws IOException {
        String title = "New Game Database Selection";
        String message = "Select a Database for the New Game:\n\n";
        DefaultComboBoxModel limitdml = new DefaultComboBoxModel();
        JComboBox dboptions = new JComboBox();
        popLimit(dboptions,limitdml);
        if(dboptions.getItemCount() > 1) {
            String selection = Popups.comboboxPopup(title, message, dboptions);
            MainControls.selectedSave = (selection.toLowerCase() + "." + 
                MainControls.saveExt);
            String confirmMessage = selection + " Loaded";
            Popups.infoPopup(confirmMessage,confirmMessage + "!");
        } else {
            MainControls.selectedSave = (MainControls.defaultSave);
        }
    }
    
    private void popLimit(JComboBox box, DefaultComboBoxModel dml) throws 
        IOException {
        try {
            List<String> savelist = (Converters.foldertoList(MainControls
                .savesDir, MainControls.saveExt)).stream().map(Object::toString)
                .collect(Collectors.toList());
            fillLimit(box,savelist,dml);
        } catch (IOException ex) {
            logFile("severe","Save Select Error.\nEx: " + ex.toString());
        }
    }
    
    private void fillLimit(JComboBox<String> save, List<String> list, 
            DefaultComboBoxModel dml) {
        Font font = save.getFont();
        DefaultListCellRenderer lrCenter;
        lrCenter = new DefaultListCellRenderer();
        lrCenter.setHorizontalAlignment(DefaultListCellRenderer.LEFT);
        lrCenter.setFont(font.deriveFont(Font.BOLD));
        for(int i = 0; i < list.size(); i++) {
            String x = (list.get(i));
            String y = Converters.capFirstLetter(x.substring(x.indexOf("\\") + 1
                , x.indexOf(".",x.indexOf(MainControls.saveExt) - 2)));
            dml.addElement(y);
        }
        save.setModel(dml);
        save.setRenderer(lrCenter);
    }
    
    private void optionPopup() throws IOException, InterruptedException{
        String title = "Limitless Options";
        String message = "Limitless Options\n\n";
        boolean musicNotice = false;
        if(!MainControls.musicOn) {
            musicNotice = true;
        }
        JCheckBox music = new JCheckBox("Play Music");
        music.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if(!(e.getStateChange() == ItemEvent.SELECTED)) {
                try {
                    MPlayer.mediaPlayer(false);
                } catch (Exception ex) {
                    //
                } 
            };
            }
        });
        JCheckBox sound = new JCheckBox("Play Sound");
        JCheckBox samedb = new JCheckBox("Always Use Same Database");
        JComboBox<String> defaultdb = new JComboBox();
        samedb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if(!(e.getStateChange() == ItemEvent.SELECTED)) {
                try {
                    defaultdb.setEnabled(false);
                    defaultdbEnabled(defaultdb);
                } catch (IOException ex) {
                    //
                }
            } else {
                defaultdb.setEnabled(true);
                try {
                    defaultdbEnabled(defaultdb);
                } catch (IOException ex) {
                    //
                }
            };
            }
        });
        defaultdb.addItem("<Always Choose Your Database>");
        if(MainControls.musicOn) {
            music.setSelected(true);
        }
        if(MainControls.soundOn) {
            sound.setSelected(true);
        }
        if(MainControls.samedbOn) {
            samedb.setSelected(true);
            defaultdb.setEnabled(true);
        } else {
            defaultdb.setEnabled(false);
        }
        Object[] popup = {message, music, sound, samedb, defaultdb, "\n"};
        Popups.checkboxPopup(title, message, popup);
        if(musicNotice) {
            Popups.warnPopup("Music Notice", "You may need to restart the game "
                + "to reactivate the music.");
        }
        if(music.isSelected()) {
            MainControls.musicOn = true;
        } else {
            MainControls.musicOn = false;
        }
        if(sound.isSelected()) {
            MainControls.soundOn = true;
        } else {
            MainControls.soundOn = false;
        }
        if(samedb.isSelected()) { 
            MainControls.samedbOn = true;
            MainControls.defaultDB = defaultdb.getSelectedItem().toString();
        } else {
            MainControls.samedbOn = false;
            MainControls.defaultDB = MainControls.defaultSave.substring(0,
                MainControls.defaultSave.indexOf("." + MainControls.saveExt));
        }
       MainControls.updateSettings();
    }
    
    private void defaultdbEnabled(JComboBox<String> dropdown)throws IOException {
        if(dropdown.isEnabled()) {
            dropdown.removeAllItems();
            DefaultComboBoxModel dbdml = new DefaultComboBoxModel();
            try {
                List<String> savelist = (Converters.foldertoList(MainControls.
                    savesDir, MainControls.saveExt)).stream()
                    .map(Object::toString).collect(Collectors.toList());
                for(int i = 0; i < savelist.size(); i++) {
                    String x = (savelist.get(i));
                    String y = Converters.capFirstLetter(x.substring(x.indexOf
                        ("\\") + 1, x.indexOf(".",x.indexOf(MainControls.saveExt
                        ) - 2)));
                dbdml.addElement(y);
                }
            dropdown.setModel(dbdml);
            } catch (IOException ex) {
                logFile("severe","defDB Enabled Error.\nEx: " + ex.toString());
            }
        } else {
            dropdown.removeAllItems();
            dropdown.addItem("<Always Choose Your Database>");
        }
    }
    
    private void aboutPopup() throws IOException {
        try {
            String[] options = new String[] {"Facebook","Discord","YouTube","Be"
                + "nsound.com","OK"};
            String title = "About This Game";
            String message = ("<html>This application was created by ClarkTribe"
                + "Games.<br><br>It was the development of basically a one man "
                + "team with advice, suggestions, and feedback<br>from friends "
                + "and colleagues.<br><br>This game is dedicated to the kids of"
                + " the creator.<br><br>Please consider supporting the cause wi"
                + "th a donation via the <font color=red><b>Donate To The Cause"
                + "</b></font> button.<br><br><b>The music was provided by BenS"
                + "ound.com. Please visit their site for awesome tracks!</b>   "
                + "<br><br>Thank you for your continued support!<br><br>- Geoff"
                + " @ ClarkTribeGames<br><br></html>");
            int choice = Popups.optPopup(options, title, message);
            switch(choice) {
                case 0:
                    GoToWeb.openWeb("https://www.facebook.com/clarktribe.games")
                        ;
                    break;
                case 1:
                    GoToWeb.openWeb("https://discord.gg/6kW4der");
                    break;
                case 2:
                    GoToWeb.openWeb("https://www.youtube.com/channel/UCjcPw3Apu"
                        + "FduiETIdmAhFAQ");
                    break;
                case 3:
                    GoToWeb.openWeb("https://www.bensound.com/");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            logFile("severe","About Popup Error.  Exception: " + ex);
        }
    }
    
    private static void donatePopup() throws IOException {
        try {
            String[] options = new String[] {"Patreon","PayPal","Maybe Later"};
            String title = "Please Donate. :)";
            String message = ("<html><b>This application was created by ClarkTr"
                    + "ibeGames.</b><br><br>If you found this game fun and/or w"
                    + "ant to help with the<br>development of this game, please"
                    + " consider a donation,<br>even if it is $1 to keep projec"
                    + "ts like this alive.\n\nThank you! - Geoff @ ClarkTribeGa"
                    + "mes");
            int choice = Popups.optPopup(options, title, message);
            switch(choice) {
                case 0:
                    GoToWeb.openWeb("https://www.patreon.com/clarktribegames");
                    break;
                case 1:
                    GoToWeb.openWeb("https://www.paypal.me/aznblusuazn");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            logFile("severe","Donate Popup Error.  Exception: " + ex);
        }
    }

    private void cleanUp() throws IOException, InterruptedException {
        System.gc();
        dispose();
    }
    
    private void exitProcess() throws IOException, InterruptedException {
        cleanUp();
        MainControls.clearTemp();
        System.exit(0);
    }

//<editor-fold defaultstate="collapsed" desc="Footer Info">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton donateButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton optButton;
    private javax.swing.JLabel titleLogo;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}