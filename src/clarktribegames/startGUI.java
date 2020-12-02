// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * @version IN DEVELOPMENT
 * 
 */
//</editor-fold>

public class startGUI extends javax.swing.JFrame {

    String appName = "Limitless";
    String appVer = "0.0.013";
    
    public startGUI() throws IOException, Exception {
        initComponents();
        setLocationRelativeTo(null);
        startupChecks();
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
        setTitle(appName + " [ALPHA v" + appVer + "]");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setText("[Limitless Logo Here]");
        titleLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        optButton.setText("Disabled (Future Options)");
        optButton.setEnabled(false);
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
        optButton();
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
        exitButton();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //exitButton();
    }//GEN-LAST:event_formWindowClosing
    
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
                    new startGUI().setVisible(true);
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
    
    //<editor-fold defaultstate="collapsed" desc="Check Version Method">
    private static void checkVersion (String name, String ver) throws IOException {
        boolean needUpdate = new verCheck().checkVersion(name, ver);
        if(needUpdate == true)
            new Updater().updateMessage(name, ver);
    }
    //</editor-fold>
    
    private void newButton() throws InterruptedException, SQLException, 
            IOException, URISyntaxException, Exception {
        //dispose();
        try {
            cleanUp();
            new NewGameGUI().setVisible(true);
        } catch(Exception ex) {
            logFile("severe","New Button Error.  Exception: " + ex);
        }
    }

    private void loadButton() {
        
    }

    private void editButton() {
        
    }


    private void optButton() {
        
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
    
    private void exitButton() {
        boolean exitChoice = yesorNo("Are you sure you want to exit?","Exit the"
                + " Game?");
        if(exitChoice == true)
            exitProcess();
    }
    
    private void aboutPopup() throws IOException {
        try {
            String[] options = new String[] {"Facebook","Discord","YouTube","OK"
                    };
            String message = ("<html>This application was created by ClarkTribe"
                    + "Games.<br><br>It was the development of basically a one "
                    + "man team<br>with advice, suggestions, and feedback from "
                    + "friends<br>and colleagues.<br><br>This game is dedicated"
                    + " to the kids of the creator.<br><br>Please consider supp"
                    + "orting the cause with a donation<br>via the <font color="
                    + "red><b>Donate To The Cause</b></font> button.<br><br>Tha"
                    + "nk you for your continued support!<br><br>- Geoff @ Clar"
                    + "kTribeGames<br><br></html>");
            int aboutChoice = popupResponse(options, "About This Game",message);

            switch(aboutChoice) {
                case 0:
                    openWeb("https://www.facebook.com/clarktribe.games");
                    break;
                case 1:
                    openWeb("https://discord.gg/6kW4der");
                    break;
                case 2:
                    openWeb("https://www.youtube.com/channel/UCjcPw3ApuFduiETId"
                            + "mAhFAQ");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            logFile("severe","About Popup Error.  Exception: " + ex);
        }
    }
    
    private void donatePopup() throws IOException {
        try {
            String[] options = new String[] {"Patreon","PayPal","Maybe Later"};
            String message = ("<html><b>This application was created by ClarkTr"
                    + "ibeGames.</b><br><br>If you found this game fun and/or w"
                    + "ant to help with the<br>development of this game, please"
                    + " consider a donation,<br>even if it is $1 to keep projec"
                    + "ts like this alive.\n\nThank you! - Geoff @ ClarkTribeGa"
                    + "mes");
        int donateChoice = popupResponse(options, "Please Donate. :)", message);
        switch(donateChoice) {
            case 0:
                openWeb("https://www.patreon.com/clarktribegames");
                break;
            case 1:
                openWeb("https://www.paypal.me/aznblusuazn");
                break;
            default:
                break;
            }
        } catch(IOException ex) {
            logFile("severe","Donate Popup Error.  Exception: " + ex);
        }
    }
    
    private void openWeb(String website) throws IOException {
        String command = "rundll32 url.dll,FileProtocolHandler " + website;
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
                logFile("severe",("Cannot access website.  " + ex.toString()));
            }
    }
    
    private int popupResponse(String[] options, String title, String message) {
        int response = JOptionPane.showOptionDialog(null, message, title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.
                PLAIN_MESSAGE,null, options, options[0]);
        return response;
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
    
    private void checkLibs() throws IOException {
        try {
            boolean result = (new LibImport().libImport());
            if(!result) {
                JOptionPane.showMessageDialog(null,"Initializing Default Databa"
                        + "se.\n\nPlease restart the game.","Alert!",JOptionPane
                        .WARNING_MESSAGE);
                exitProcess();
            }
        } catch(IOException ex) {
            logFile("severe",("checkLib IOException: " + ex.toString()));
        }
    }
    
    private void checkSaves() throws IOException, Exception {
        try {
            new FileCheck().newdirCheck("./saves/", false);
            String ogPath = "data.accdb";
            String dbPath = "saves/default.limit";
            new FileCheck().fileCheck(ogPath,dbPath,true);
            new FileCheck().newfileCheck("saves/.lastused", true);
        } catch(Exception ex) {
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private void startupChecks() throws IOException, Exception {
        try {
            checkVersion(appName,appVer);
            checkLibs();
            checkSaves();
        } catch(IOException ex) {
            logFile("severe",("Startup Check IOException: " + ex.toString()));
        }
        
    }
    
    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    private void exitProcess() {
        cleanUp();
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