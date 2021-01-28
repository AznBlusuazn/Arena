package clarktribegames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>
public class VersusGUI extends javax.swing.JFrame {
   
    public VersusGUI() throws SQLException, IOException, FileNotFoundException, JavaLayerException, InterruptedException, Exception {
        initComponents();
        setLocationRelativeTo(null);  
        popVersus();
//        popVersus(BattleEngine.saveName, BattleEngine.saveToons);
    }
    
    private boolean checkforCustom(String toon,List<String> custlist) {
        String toonpath = MainControls.custommusicPath + "/" + toon + ".mp3";
        if(new File(toonpath).exists()) {
            return true;
        } else {
            for (String s : custlist) {
                if(s.equals(BattleEngine.team1[0])) {
                    return true;
                } 
            }
            return false;
        }
    }
    
    private void popVersus() throws SQLException, IOException, FileNotFoundException, JavaLayerException, InterruptedException, Exception {
        //add if multiple team captains instead
        char1Label.setText(Converters.fetchfromTable(MemoryBank.savToons,
            BattleEngine.team0[0],0,1));
//                GetData.dataQuery("*",savetoons, "toonID",
//            BattleEngine.team0[0], false,false,null,null).get(1));
        char2Label.setText(Converters.fetchfromTable(MemoryBank.savToons,
            BattleEngine.team1[0],0,1));
//                GetData.dataQuery("*",savetoons, "toonID",
//            BattleEngine.team1[0], false,false,null,null).get(1));
        Avatars.setAvatar(char1Toon, char1Label.getText(),Converters.
            fetchfromTable(MemoryBank.savToons,char1Label.getText(),1,10));
//            (GetData.dataQuery("*",savetoons, "toonName",char1Label.getText(), false,false,null,null).get(10)));
        Avatars.setAvatar(char2Toon, char2Label.getText(),Converters.
            fetchfromTable(MemoryBank.savToons,char2Label.getText(),1,10));
//            (GetData.dataQuery("*",savetoons,"toonName",char2Label.getText(), false,false,null,null).get(10)));
        List<String> custTList=GetData.dataQuery("*","dbCustM","toonID",null,
            true,false,null,null);
        boolean toontheme = checkforCustom(char2Label.getText().toLowerCase(),
            custTList);
        if(MainControls.musicPlaying) {
            MPlayer.stopMedia();
        }
        MainControls.musicPath = MainControls.defaultBattle;
        if(toontheme) {
            for (String s : custTList) {
                if(s.equals(BattleEngine.team1[0])) {
                    String custpath=MainControls.custommusicPath+"/"+(GetData.
                        dataQuery("*","dbCustM","toonID",BattleEngine.team1[0],
                        false,false,null,null).get(1)) + ".mp3";
                    if(new File(custpath).exists()) {
                        MainControls.musicPath = custpath;
                        break;
                    }
                    MainControls.musicPath=MainControls.custommusicPath+"/"+
                        char2Label.getText()+".mp3";
                } else {
                    
            }
            }
                MainControls.turnonMusic(MainControls.musicPath, "battle");
        } else {
            MainControls.turnonMusic(MainControls.checkforcustMusic("battle"),
                "battle");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        char1Toon = new javax.swing.JLabel();
        char2Toon = new javax.swing.JLabel();
        vsLabel = new javax.swing.JLabel();
        char1Label = new javax.swing.JLabel();
        char2Label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        char1Toon.setForeground(new java.awt.Color(255, 255, 255));
        char1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        char1Toon.setText("[Player 1 Image Here]");
        char1Toon.setFocusable(false);
        getContentPane().add(char1Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 200));

        char2Toon.setForeground(new java.awt.Color(255, 255, 255));
        char2Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        char2Toon.setText("[Player 2 Image Here]");
        char2Toon.setFocusable(false);
        getContentPane().add(char2Toon, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 200, 200));

        vsLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        vsLabel.setForeground(new java.awt.Color(255, 255, 255));
        vsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsLabel.setText("vs.");
        getContentPane().add(vsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 23));

        char1Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        char1Label.setForeground(new java.awt.Color(255, 255, 255));
        char1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(char1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 20));

        char2Label.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        char2Label.setForeground(new java.awt.Color(255, 255, 255));
        char2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(char2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 200, 23));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.gc();
        this.dispose();
        BattleGUI.main(null);
    }//GEN-LAST:event_formMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VersusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VersusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VersusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VersusGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VersusGUI().setVisible(true);
                } catch (SQLException | IOException | JavaLayerException | 
                    InterruptedException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel char1Label;
    private javax.swing.JLabel char1Toon;
    private javax.swing.JLabel char2Label;
    private javax.swing.JLabel char2Toon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel vsLabel;
    // End of variables declaration//GEN-END:variables
}
