// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;



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
    String saveName;
    List<String> toonList = null;
    DefaultComboBoxModel toonDml = new DefaultComboBoxModel();
    DefaultComboBoxModel saveDml = new DefaultComboBoxModel();
    
    public NewGameGUI() throws IOException, Exception {
        this.appName = MainControls.appName;
        this.appVer = MainControls.appVer;
        initComponents();
        setLocationRelativeTo(null);
        saveName = getSave();        
        popsaveDrop();
        popcharDrop(saveName);
        changeChar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newgameLabel = new javax.swing.JLabel();
        titleLogo = new javax.swing.JLabel();
        saveLabel = new javax.swing.JLabel();
        saveDrop = new javax.swing.JComboBox<>();
        charToon = new javax.swing.JLabel();
        selectLabel = new javax.swing.JLabel();
        charDrop = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();

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
        newgameLabel.setText("New Game");
        newgameLabel.setFocusable(false);

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N

        saveLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saveLabel.setText("Current Save:");
        saveLabel.setFocusable(false);

        saveDrop.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        saveDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Testing the name" }));
        saveDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDropActionPerformed(evt);
            }
        });

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

        confirmButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");

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
                        .addComponent(saveDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(charToon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(charDrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newgameLabel)))
                .addGap(18, 18, 18)
                .addComponent(titleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(charToon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectLabel)
                .addGap(18, 18, 18)
                .addComponent(charDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(confirmButton)
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
                exitProcess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            exitProcess();
        }   
    }//GEN-LAST:event_formWindowClosing

    private void charDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charDropActionPerformed
        try {
            changeChar();
        } catch (SQLException | BadLocationException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_charDropActionPerformed

    private void saveDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDropActionPerformed
        try {
            savedropChange();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveDropActionPerformed

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
    
    private List<String> dbQuery(String save,String search,String table,String 
            col,String matchstr,boolean isitSingle) throws SQLException {
        String list = "";
        if (!isitSingle) {
            list = (new RunQuery().getSpecificRecord(save, search, table, col,
                    matchstr)).replaceAll("\\[", "").replaceAll("\\]","");
        } else {
            list = (new RunQuery().getSingleList(save, search, table, col))
                    .replaceAll("\\[", "").replaceAll("\\]","");
        }
        String[] stringList = list.split(",");
        List<String> convertedList = Arrays.asList(stringList);
        System.gc();
        return convertedList;
    }
    
    private void popsaveDrop() throws IOException {
        try {
            List<String> savelist = (Converters.foldertoList
                (MainControls.savesDir, MainControls.saveExt)).stream()
                .map(Object::toString).collect(Collectors.toList());
            fillSave(saveDrop,savelist,saveDml);
            File lastused = new File(MainControls.lastusedSave);
            String lastUsed = ChecksBalances.getLast(lastused);
            String lastusedSave = lastUsed.substring(0,lastUsed.indexOf(","));
            int lastusedChar = Integer.parseInt(lastUsed.substring(lastUsed
                .indexOf(",") + 1,lastUsed.length()));
            int found = 0;
            for(int i = 0; i < saveDrop.getItemCount(); i ++) {
                String x = saveDrop.getItemAt(i).toString().toLowerCase();
                if (x.contains(lastusedSave)) {
                    found = i;
                }
            }
            saveDrop.setSelectedIndex(found);
            if(charDrop.getItemCount() > 1) {
                charDrop.setSelectedIndex(lastusedChar);
                        }

        } catch (IOException ex) {
            logFile("severe","Save Select Error.\nEx: " + ex.toString());
        }
    }

    private void popcharDrop(String save) throws SQLException, IOException {
        try {
            toonList = dbQuery(save, "*","dbToonGame","toonName","", true);
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
    
    private String getSave() throws IOException {
        String s1 = Converters.getfromFile(MainControls.lastusedSave, 
            true, false);
        String savename = s1.substring(0, s1.indexOf(","));
        return savename;
    }
    
    private void fillSave(JComboBox<String> save, List<String> list, 
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
    
    private void savedropChange() throws IOException, InterruptedException, 
        SQLException, Exception {
        if(this.isVisible()) {
        try {
            String oldsave = ChecksBalances.getLast(new File(MainControls
                .lastusedSave));
            String newsave=saveDrop.getSelectedItem().toString().toLowerCase();
            System.gc();
            ChecksBalances.ifexistDelete(MainControls.lastusedSave);
            ChecksBalances.newfileCheck((MainControls.lastusedSave), true, 
                (newsave  + "," + charDrop.getSelectedIndex()),true);
            String title = "Change Saves?";
            String message = "Are you sure you want to change to the " + 
                (saveDrop.getSelectedItem()) + " save?";
            boolean yesno = Popups.yesnoPopup(title, message);
            if(yesno == true) {
                Popups.plainPopup("To Change Saves", "To change to the " + 
                    (saveDrop.getSelectedItem()) + " save,\nreturn to the Main "
                    + "Menu and Start a New Game.");
                menuOption();
            } else {
                System.gc();
                ChecksBalances.ifexistDelete(MainControls.lastusedSave);
                ChecksBalances.newfileCheck((MainControls.lastusedSave), true, 
                    oldsave,true);
                saveName = getSave();
                File lastused = new File(MainControls.lastusedSave);
                String lastUsed = ChecksBalances.getLast(lastused);
                String lastusedSave = lastUsed.substring(0,lastUsed.indexOf(",")
                    );
                int found = 0;
                for(int i = 0; i < saveDrop.getItemCount(); i ++) {
                    String x = saveDrop.getItemAt(i).toString().toLowerCase();
                    if (x.contains(lastusedSave)) {
                        found = i;
                    }
                }
                saveDrop.setSelectedIndex(found);
                int lastusedChar = Integer.parseInt(lastUsed.substring(lastUsed
                    .indexOf(",") + 1,lastUsed.length()));
                charDrop.setSelectedIndex(lastusedChar);
            }
        }catch (IOException | InterruptedException  ex) {
            logFile("severe","Save Change Box Error.\n Ex: " + ex.toString());
        }
        }
    }
    
    private void setChar(String save, String toonname) throws SQLException, 
        BadLocationException {
        List<String> listP1OGStats = dbQuery(save, "*","dbToons",
                "toonOGName",toonname, false);
        String[] p1OGField = ((listP1OGStats.toString()).substring(1,
            (listP1OGStats.toString()).length())).split(",");
        List<String> listP1Stats = dbQuery(save, "*","dbToonGame","toonName",
                toonname, false);
        String charImage = listP1Stats.get(34);
        new ToonImage().setImage(charToon,charImage);   
    }
    
    private void changeChar() throws SQLException, BadLocationException {
        setChar(saveName, (String) charDrop.getSelectedItem());
    }
            
    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    private void exitProcess() {
        cleanUp();
        System.exit(0);
    }
    
    private String formatter(String s) {
        char c = s.charAt(0);
        if(c == ' ') {
            s = s.substring(1);
        }
        s = s.replaceAll("\\[","");
        s = s.replaceAll("\\]","");
        return s;
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
    private javax.swing.JComboBox<String> charDrop;
    private javax.swing.JLabel charToon;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel newgameLabel;
    private javax.swing.JComboBox<String> saveDrop;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel titleLogo;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}