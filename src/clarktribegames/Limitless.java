package clarktribegames;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        menuPanel = new javax.swing.JPanel();
        titleLogo = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        loadButton = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        optsButton = new javax.swing.JLabel();
        aboutButton = new javax.swing.JLabel();
        donateButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        mToon = new javax.swing.JLabel();
        tlToon = new javax.swing.JLabel();
        trToon = new javax.swing.JLabel();
        blToon = new javax.swing.JLabel();
        brToon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("limitless"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(MainControls.backColor);
        menuPanel.setForeground(MainControls.textColor);
        menuPanel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        menuPanel.setMaximumSize(new java.awt.Dimension(1200, 800));
        menuPanel.setMinimumSize(new java.awt.Dimension(1200, 800));
        menuPanel.setName(""); // NOI18N
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N
        titleLogo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                titleLogoComponentShown(evt);
            }
        });
        menuPanel.add(titleLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));

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
        menuPanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 25));

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
        menuPanel.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 325, 200, 25));

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
        menuPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 400, 200, 25));

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
        menuPanel.add(optsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 475, 200, 25));

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
        menuPanel.add(aboutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 550, 200, 25));

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
        menuPanel.add(donateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 625, 200, 25));

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
        menuPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 700, 200, 25));

        mToon.setForeground(MainControls.textColor);
        mToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mToon.setBorder(javax.swing.BorderFactory.createLineBorder(MainControls.textColor));
        mToon.setFocusable(false);
        menuPanel.add(mToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 388, 200, 200));

        tlToon.setForeground(MainControls.textColor);
        tlToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlToon.setFocusable(false);
        menuPanel.add(tlToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 200, 200));

        trToon.setForeground(MainControls.textColor);
        trToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trToon.setFocusable(false);
        menuPanel.add(trToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 200, 200));

        blToon.setForeground(MainControls.textColor);
        blToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blToon.setFocusable(false);
        menuPanel.add(blToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 525, 200, 200));

        brToon.setForeground(MainControls.textColor);
        brToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brToon.setFocusable(false);
        menuPanel.add(brToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 525, 200, 200));

        getContentPane().add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        startButton();
    }//GEN-LAST:event_startButtonMouseClicked

    private void loadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseClicked
        loadButton();
    }//GEN-LAST:event_loadButtonMouseClicked

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        editButton();
    }//GEN-LAST:event_editButtonMouseClicked

    private void optsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optsButtonMouseClicked
        optsButton();
    }//GEN-LAST:event_optsButtonMouseClicked

    private void aboutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseClicked
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
    }//GEN-LAST:event_aboutButtonMouseClicked

    private void donateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donateButtonMouseClicked
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

    private void titleLogoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_titleLogoComponentShown
        //
    }//GEN-LAST:event_titleLogoComponentShown

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
                        LogWriter.logFile("severe","Initial Open Error.  Exception: " + ex);
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                }
            }
        });
    }
    
    private void setAvatars() throws IOException {
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
    
    private void setAvatarBox(ArrayList<Path> list, JLabel box, int num) {
        Avatars.setAvatar(box,(list.get(num).toString()).replaceAll(MainControls
            .imageDir.substring(0,MainControls.imageDir.length()-1) + "\\\\","")
            .replaceAll(".png",""), list.get(num).toString());
        box.setBorder(BorderFactory.createLineBorder(MainControls.textColor));
    }
            
    
    private void buttonOver(JLabel button) {
        button.setForeground(Color.RED);
    }
    
    private void buttonOff(JLabel button) {
        button.setForeground(MainControls.textColor);
    }
    
    private void buttonPressed(JLabel button) {
        if(button.isEnabled()) {
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED
                ));
            button.setForeground(Color.BLUE);
        }
    }
    
    private void buttonReleased(JLabel button) {
        if(button.isEnabled()) {
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)
                );
            button.setForeground(MainControls.textColor);
        }
    }
    
    private static void startButton() {
        MainControls.startNewGame();
    }
    
    private static void loadButton() {
        MainControls.loadSavedGame();
    }
    
    private static void editButton() {
        
    }
    
    private static void optsButton() {

    }
    
    private static void aboutButton() throws IOException {
        try {
            MainControls.aboutPopup();
        } catch (IOException ex) {
            LogWriter.logFile("severe","About Button Error.  Exception: "+ex);
        }        
    }
    
    private static void donateButton() throws IOException {
        try {
            MainControls.donatePopup();
        } catch (IOException ex) {
            LogWriter.logFile("severe","Donate Button Error.  Exception: "+ex);
        }
    }
    
    private static void exitButton() throws IOException {
        try {
            MainControls.exitGame();
        } catch (IOException | InterruptedException ex) {
            LogWriter.logFile("severe","Exit Button Error.  Exception: " + ex);
        }
    }
    
    private void savegameCheck() {
        if(!(ChecksBalances.checknoofSubdirs(MainControls.savesDir))) {
            loadButton.setText("  No Saved Games");
            loadButton.setEnabled(false);
        } else {
            loadButton.setText("  Continue Saved Game");
            loadButton.setEnabled(true);
        }
    }
    
    private void showMenu() throws IOException {
        menuPanel.setVisible(true);
        MainControls.savesDir = MainControls.defaultsavesDir;
        MainControls.turnonMusic(MainControls.checkforcustMusic("intro"),"intro"
            );
        try {
            setAvatars();
        } catch (IOException ex) {
            LogWriter.logFile("severe", "Show Menu Error. Ex: " + ex);
        }
        savegameCheck();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel aboutButton;
    private static javax.swing.JLabel blToon;
    private static javax.swing.JLabel brToon;
    private static javax.swing.JLabel donateButton;
    private static javax.swing.JLabel editButton;
    private static javax.swing.JLabel exitButton;
    private static javax.swing.JLabel loadButton;
    private static javax.swing.JLabel mToon;
    private javax.swing.JPanel menuPanel;
    private static javax.swing.JLabel optsButton;
    private static javax.swing.JLabel startButton;
    private javax.swing.JLabel titleLogo;
    private static javax.swing.JLabel tlToon;
    private static javax.swing.JLabel trToon;
    // End of variables declaration//GEN-END:variables
}
