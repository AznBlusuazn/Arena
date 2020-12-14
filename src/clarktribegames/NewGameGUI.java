
// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
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
        worldinfoText(saveName);
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
        stat05Label = new javax.swing.JLabel();
        bioPane = new javax.swing.JScrollPane();
        bioText = new javax.swing.JTextArea();
        hpLabel = new javax.swing.JLabel();
        mpLabel = new javax.swing.JLabel();
        apLabel = new javax.swing.JLabel();
        atLabel = new javax.swing.JLabel();
        stLabel = new javax.swing.JLabel();
        dfLabel = new javax.swing.JLabel();
        saLabel = new javax.swing.JLabel();
        spLabel = new javax.swing.JLabel();
        evLabel = new javax.swing.JLabel();
        dxLabel = new javax.swing.JLabel();
        myLabel = new javax.swing.JLabel();
        mdLabel = new javax.swing.JLabel();
        meLabel = new javax.swing.JLabel();
        wlLabel = new javax.swing.JLabel();
        luLabel = new javax.swing.JLabel();
        chLabel = new javax.swing.JLabel();
        inLabel = new javax.swing.JLabel();
        ftLabel = new javax.swing.JLabel();
        sdLabel = new javax.swing.JLabel();
        wmLabel = new javax.swing.JLabel();
        rpLabel = new javax.swing.JLabel();
        hpVal = new javax.swing.JLabel();
        mpVal = new javax.swing.JLabel();
        apVal = new javax.swing.JLabel();
        atVal = new javax.swing.JLabel();
        stVal = new javax.swing.JLabel();
        dfVal = new javax.swing.JLabel();
        saVal = new javax.swing.JLabel();
        spVal = new javax.swing.JLabel();
        evVal = new javax.swing.JLabel();
        dxVal = new javax.swing.JLabel();
        myVal = new javax.swing.JLabel();
        mdVal = new javax.swing.JLabel();
        meVal = new javax.swing.JLabel();
        wlVal = new javax.swing.JLabel();
        luVal = new javax.swing.JLabel();
        chVal = new javax.swing.JLabel();
        inVal = new javax.swing.JLabel();
        ftVal = new javax.swing.JLabel();
        sdVal = new javax.swing.JLabel();
        wmVal = new javax.swing.JLabel();
        rpVal = new javax.swing.JLabel();
        effLabel = new javax.swing.JLabel();
        ablLabel = new javax.swing.JLabel();
        heldLabel = new javax.swing.JLabel();
        wearLabel = new javax.swing.JLabel();
        charmLabel = new javax.swing.JLabel();
        invLabel = new javax.swing.JLabel();
        heldPane = new javax.swing.JScrollPane();
        heldList = new javax.swing.JList<>();
        wearPane = new javax.swing.JScrollPane();
        wearList = new javax.swing.JList<>();
        charmPane = new javax.swing.JScrollPane();
        charmList = new javax.swing.JList<>();
        invPane = new javax.swing.JScrollPane();
        invList = new javax.swing.JList<>();
        effPane = new javax.swing.JScrollPane();
        effList = new javax.swing.JList<>();
        ablPane = new javax.swing.JScrollPane();
        ablList = new javax.swing.JList<>();
        startingworldLabel = new javax.swing.JLabel();
        bottomPane = new javax.swing.JPanel();
        welcomePane = new javax.swing.JScrollPane();
        welcomeText = new javax.swing.JTextArea();
        startingworldLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(this.appName + " [ALPHA v" + this.appVer + "]");
        setIconImage(new MainControls().imageIcon.getImage());
        setSize(new java.awt.Dimension(1200, 850));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newgameLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        newgameLabel.setText("New Game • Character Selection");
        newgameLabel.setFocusable(false);
        getContentPane().add(newgameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 600, -1));

        titleLogo.setFont(new java.awt.Font("Lucida Console", 1, 48)); // NOI18N
        titleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/logo.png"))); // NOI18N
        getContentPane().add(titleLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 1200, 190));

        saveLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saveLabel.setText("Current Limitless Database:");
        saveLabel.setFocusable(false);
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 11, 434, 21));

        charToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        charToon.setText("[Player 1 Image Here]");
        charToon.setFocusable(false);
        getContentPane().add(charToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 200, 200));

        selectLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        selectLabel.setText("Select Your Character:");
        selectLabel.setFocusable(false);
        getContentPane().add(selectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 200, 19));

        charDrop.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Populated List>" }));
        charDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charDropActionPerformed(evt);
            }
        });
        getContentPane().add(charDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 200, 19));

        exitButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        exitButton.setText("Back to Main Menu");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 760, 200, -1));

        limitLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        limitLabel.setText("<Limit File Name>");
        limitLabel.setFocusable(false);
        getContentPane().add(limitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 11, 134, 21));

        confirmButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        confirmButton.setText("Start New Game");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 760, 200, -1));

        stat01Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat01Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat01Label.setText("<Alignment>");
        getContentPane().add(stat01Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 525, 200, 19));

        stat02Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat02Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat02Label.setText("<Age> • <Gender>");
        getContentPane().add(stat02Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 200, 19));

        stat03Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat03Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat03Label.setText("<Size> • <Race>");
        getContentPane().add(stat03Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 575, 200, 19));

        stat04Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat04Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat04Label.setText("<Class> • <Lv>");
        getContentPane().add(stat04Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 200, 19));

        stat05Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat05Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat05Label.setText("<Status>");
        getContentPane().add(stat05Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 625, 200, 19));

        bioPane.setBorder(null);
        bioPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bioPane.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        bioText.setColumns(20);
        bioText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        bioText.setLineWrap(true);
        bioText.setRows(9);
        bioText.setText("This is where the player bio text goes.");
        bioText.setWrapStyleWord(true);
        bioPane.setViewportView(bioText);

        getContentPane().add(bioPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 200, 130));

        hpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        hpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hpLabel.setText("Max Health Points:");
        getContentPane().add(hpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 133, 19));

        mpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mpLabel.setText("Max Mystic Points:");
        getContentPane().add(mpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 275, 133, 19));

        apLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        apLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        apLabel.setText("Max Ability Points:");
        getContentPane().add(apLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 133, 19));

        atLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        atLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        atLabel.setText("Attack Power:");
        getContentPane().add(atLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 325, 133, 19));

        stLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stLabel.setText("Strength:");
        getContentPane().add(stLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 133, 19));

        dfLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dfLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dfLabel.setText("Defense:");
        getContentPane().add(dfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 375, 133, 19));

        saLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        saLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saLabel.setText("Stamina:");
        getContentPane().add(saLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 133, 19));

        spLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        spLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        spLabel.setText("Speed:");
        getContentPane().add(spLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 425, 133, 19));

        evLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        evLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        evLabel.setText("Attack Evade:");
        getContentPane().add(evLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 133, 19));

        dxLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dxLabel.setText("Dexterity:");
        getContentPane().add(dxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 475, 133, 19));

        myLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        myLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myLabel.setText("Mystic Power:");
        getContentPane().add(myLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 133, 19));

        mdLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mdLabel.setText("Mystic Defense:");
        getContentPane().add(mdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 525, 133, 19));

        meLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        meLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        meLabel.setText("Mystic Evade:");
        getContentPane().add(meLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 133, 19));

        wlLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wlLabel.setText("Willpower:");
        getContentPane().add(wlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 575, 133, 19));

        luLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        luLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        luLabel.setText("Luck:");
        getContentPane().add(luLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 133, 19));

        chLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        chLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chLabel.setText("Charisma:");
        getContentPane().add(chLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 625, 133, 19));

        inLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        inLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inLabel.setText("Intelligence:");
        getContentPane().add(inLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 133, 19));

        ftLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ftLabel.setText("FA-Test Val:");
        getContentPane().add(ftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, 98, 19));

        sdLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sdLabel.setText("S&D-Test Val:");
        getContentPane().add(sdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 675, 98, 19));

        wmLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wmLabel.setText("WM-Test Val:");
        getContentPane().add(wmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, 98, 19));

        rpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rpLabel.setText("RP-Test Value:");
        getContentPane().add(rpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 725, -1, 19));

        hpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        hpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hpVal.setText("<value>");
        getContentPane().add(hpVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, 19));

        mpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mpVal.setText("<value>");
        getContentPane().add(mpVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 275, 120, 19));

        apVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        apVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apVal.setText("<value>");
        getContentPane().add(apVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 120, 19));

        atVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        atVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        atVal.setText("<value>");
        getContentPane().add(atVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 325, 120, 19));

        stVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stVal.setText("<value>");
        getContentPane().add(stVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 120, 19));

        dfVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dfVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dfVal.setText("<value>");
        getContentPane().add(dfVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 375, 120, 19));

        saVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        saVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saVal.setText("<value>");
        getContentPane().add(saVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 120, 19));

        spVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        spVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        spVal.setText("<value>");
        getContentPane().add(spVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 425, 120, 19));

        evVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        evVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        evVal.setText("<value>");
        getContentPane().add(evVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 120, 19));

        dxVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dxVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dxVal.setText("<value>");
        getContentPane().add(dxVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 475, 120, 19));

        myVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        myVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        myVal.setText("<value>");
        getContentPane().add(myVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 120, 19));

        mdVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mdVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mdVal.setText("<value>");
        getContentPane().add(mdVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 525, 120, 19));

        meVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        meVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        meVal.setText("<value>");
        getContentPane().add(meVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 120, 19));

        wlVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wlVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wlVal.setText("<value>");
        getContentPane().add(wlVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 575, 120, 19));

        luVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        luVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        luVal.setText("<value>");
        getContentPane().add(luVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 600, 120, 19));

        chVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        chVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chVal.setText("<value>");
        getContentPane().add(chVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 625, 120, 19));

        inVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        inVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inVal.setText("<value>");
        getContentPane().add(inVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, 120, 19));

        ftVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ftVal.setText("<value>");
        getContentPane().add(ftVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 75, 19));

        sdVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sdVal.setText("<value>");
        getContentPane().add(sdVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 675, 75, 19));

        wmVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wmVal.setText("<value>");
        getContentPane().add(wmVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 700, 75, 19));

        rpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rpVal.setText("<value>");
        getContentPane().add(rpVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 725, 75, 19));

        effLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        effLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        effLabel.setText("Starting Effects:");
        getContentPane().add(effLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 675, 133, 19));

        ablLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ablLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ablLabel.setText("Starting Abilities:");
        getContentPane().add(ablLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 250, -1, 19));

        heldLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        heldLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        heldLabel.setText("Equipment Held:");
        getContentPane().add(heldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 350, 133, 19));

        wearLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wearLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wearLabel.setText("Wearables Equipped:");
        getContentPane().add(wearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 400, -1, 19));

        charmLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charmLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        charmLabel.setText("Charms Equipped:");
        getContentPane().add(charmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 550, 133, 19));

        invLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        invLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invLabel.setText("Starting Inventory:");
        getContentPane().add(invLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 600, -1, 19));

        heldList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        heldList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        heldPane.setViewportView(heldList);

        getContentPane().add(heldPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 350, 120, 50));

        wearList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wearList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        wearPane.setViewportView(wearList);

        getContentPane().add(wearPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 400, 120, 150));

        charmList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charmList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        charmPane.setViewportView(charmList);

        getContentPane().add(charmPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 550, 120, 50));

        invList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        invList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        invPane.setViewportView(invList);

        getContentPane().add(invPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 600, 120, 180));

        effList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        effList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        effPane.setViewportView(effList);

        getContentPane().add(effPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 675, 120, 105));

        ablList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ablList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ablPane.setViewportView(ablList);

        getContentPane().add(ablPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 250, 120, 100));

        startingworldLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        startingworldLabel.setForeground(new java.awt.Color(255, 0, 0));
        startingworldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startingworldLabel.setText("This game is in development");
        getContentPane().add(startingworldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 625, 430, 19));

        bottomPane.setEnabled(false);
        bottomPane.setFocusable(false);

        javax.swing.GroupLayout bottomPaneLayout = new javax.swing.GroupLayout(bottomPane);
        bottomPane.setLayout(bottomPaneLayout);
        bottomPaneLayout.setHorizontalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        bottomPaneLayout.setVerticalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(bottomPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 1200, 20));

        welcomeText.setColumns(20);
        welcomeText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        welcomeText.setLineWrap(true);
        welcomeText.setRows(12);
        welcomeText.setWrapStyleWord(true);
        welcomePane.setViewportView(welcomeText);

        getContentPane().add(welcomePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 275, 430, 320));

        startingworldLabel1.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        startingworldLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startingworldLabel1.setText("Starting Game World");
        getContentPane().add(startingworldLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 430, 19));

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jTextPane1.setText("The values to the right are for testing only...");
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 675, 200, 40));

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

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try {
            GetData.createnewSave(saveName, "test");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            toonList=GetData.dbQuery(save,"*","dbToons","toonName","",true);
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
        new Avatars().setAvatar(charToon, charDrop.getSelectedItem().toString(),
            toonStats.get(10));
        double charXP=Double.parseDouble(Calculator.getLevel("ranxp",(toonStats.
            get(8))));
        double nextXP = Double.parseDouble(Calculator.getLevel("stalv", String.
            valueOf(Integer.parseInt(toonStats.get(8) + 1))));
        double ratioXP = charXP / nextXP;
        String alignID=Calculator.getAlign(Integer.parseInt(toonStats.get(4)));
        String alignName=(GetData.dbQuery(save,"*","dbAlign","alignID",alignID, 
            false)).get(1);
        Font stat01Font = new Font(stat01Label.getFont().getName(),Font.BOLD,
            stat01Label.getFont().getSize());

        String aligncolor=GetStats.getalignColor(Integer.parseInt((toonStats.get
            (4))));
        stat01Label.setText(alignName);
        stat01Label.setFont(stat01Font);
        stat01Label.setForeground((Converters.figureoutColor(aligncolor)));
        stat01Label.setToolTipText(alignName + ": " + (GetData.dbQuery(save, "*"
            ,"dbAlign","alignID",alignID, false)).get(2));
        String ageName = (Calculator.getAge(Integer.parseInt(toonStats.get(7)), 
            toonStats.get(2)));
        String raceName = (GetData.dbQuery(save, "*","dbRace","raceID",toonStats
            .get(2), false)).get(1);

        String gendName = (GetData.dbQuery(save, "*", "dbGender", "genderID",
            toonStats.get(6), false)).get(1);

        stat02Label.setText(ageName + " • " + gendName);
        stat02Label.setToolTipText(ageName + ": " + (GetData.dbQuery(save, "*", 
            "dbAge","ageName",ageName, false)).get(3) + " • " + gendName + ": " 
            + (GetData.dbQuery(save, "*","dbGender","genderID",toonStats.get(6),
            false)).get(2));

        String sizeName = Calculator.getSize(raceName, ageName);
        stat03Label.setText(sizeName + " • " + raceName);
        stat03Label.setToolTipText(sizeName + ": " + (GetData.dbQuery(save, "*",
            "dbSize","sizeName",sizeName,false)).get(2) +  " • "  + raceName + 
            ": " + (GetData.dbQuery(save,"*","dbRace","raceID",toonStats.get(2),
            false)).get(2));
        String className = (GetData.dbQuery(save, "*", "dbClass", "classID",
            toonStats.get(3), false)).get(1);
        stat04Label.setText(className + " • Level " + toonStats.get(8));
        stat04Label.setToolTipText(className + ": " + (GetData.dbQuery(save,"*",
            "dbClass","classID",toonStats.get(3), false)).get(2) + " • Level " +
            toonStats.get(8));
        //toonheld 13 | toonwear 14 | tooncharms 15 | tooninv 16
        DefaultListModel heldDml = new DefaultListModel();
        DefaultListModel wearDml = new DefaultListModel();
        DefaultListModel charmDml = new DefaultListModel();
        DefaultListModel invDml = new DefaultListModel();
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonStats.get(13).
            split("x")),heldDml,heldList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonStats.get(14).
            split("x")),wearDml,wearList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonStats.get(15).
            split("x")),charmDml,charmList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonStats.get(16).
            split("x")),invDml,invList,"dbItems","itemID","itemName");
        List<String> effStats = GetStats.getStats("Effects",toonStats,0,false);
        String statuscode = (((Arrays.toString(effStats.toArray())).replaceAll(
            "MASTER, ", "").replaceAll(",", "-")).replaceAll("[^\\d+\\-]",""));
        if(statuscode.length() <= 0) {
            statuscode = "0";
        }

        // add in status decoder here (can be method in GetStats)
        DefaultListModel effDml = new DefaultListModel();
        GetStats.getitemsfromIDtoJList(save,effStats,effDml,effList,"dbEffects",
            "effID","effName");
        if(effList.getModel().getElementAt(0).equals("<None>")) {
            effDml.removeAllElements();
            effDml.addElement("Normal Health");
            effList.setEnabled(true);
        }

        String statusname = (GetData.dbQuery(save,"*","dbStatus","statusName",""
            + "Normal", false)).get(1);
        String statuscolor = (GetData.dbQuery(save,"*","dbStatus","statusName",
            "Normal", false)).get(2);
        String statusdesc = (GetData.dbQuery(save,"*","dbStatus","statusName",""
            + "Normal", false)).get(3);
        String statusbio = (GetData.dbQuery(save,"*","dbStatus","statusName","N"
            + "ormal", false)).get(4);
//        if(ChecksBalances.isNullOrEmpty(statuscode) || statuscode.equals("0"))
//            {
//            //put normal status here
//        }

        Font stat05Font = new Font(stat05Label.getFont().getName(),Font.BOLD,
            stat05Label.getFont().getSize());
        stat05Label.setText(statusname);
        stat05Label.setFont(stat05Font);
        stat05Label.setForeground((Converters.figureoutColor(statuscolor)));

        String bioInfo = Converters.capFirstLetter((GetData.dbQuery(save, "*",
            "dbGender","genderID",toonStats.get(6),false)).get(5))+" is a "+((
            GetData.dbQuery(save,"*","dbAlign","alignID",alignID,false)).get(6))
            + " " + ageName +" " + (GetData.dbQuery(save, "*", "dbGender", 
            "genderID",toonStats.get(6),false)).get(1) + " that is " + (GetData.
            dbQuery(save, "*","dbSize","sizeName",sizeName,false)).get(4) + " " 
            +(GetData.dbQuery(save,"*","dbRace","raceID",toonStats.get(2),false)
            ).get(7) + " " + ((GetData.dbQuery(save, "*", "dbClass", "classID",
            toonStats.get(3), false)).get(4)) + " and " + statusbio  + ".\n\n" +
            toonStats.get(9);
        stat05Label.setToolTipText(statusname + ": " + statusdesc);
            //update health status above
        bioText.setText(bioInfo);

        List<String> newStats = GetStats.getStats("Toon",toonStats,ratioXP,false);

        hpVal.setText(newStats.get(0));
        mpVal.setText(newStats.get(1));
        apVal.setText(newStats.get(2));
        atVal.setText(newStats.get(3));
        stVal.setText(newStats.get(4));
        dfVal.setText(newStats.get(5));
        saVal.setText(newStats.get(6));
        spVal.setText(newStats.get(7));
        evVal.setText(newStats.get(8));
        dxVal.setText(newStats.get(9));
        myVal.setText(newStats.get(10));
        mdVal.setText(newStats.get(11));
        meVal.setText(newStats.get(12));
        wlVal.setText(newStats.get(13));
        luVal.setText(newStats.get(14));
        chVal.setText(newStats.get(15));
        inVal.setText(newStats.get(16));
        ftVal.setText(newStats.get(17));
        sdVal.setText(newStats.get(18) + "/" + (newStats.get(19)));
        wmVal.setText(newStats.get(20));
        rpVal.setText(newStats.get(21));

        hpVal.setToolTipText("HTP: Maximum amount of health -- the life force");
        mpVal.setToolTipText("MYP: Maximum amount of mystic -- magic points");
        apVal.setToolTipText("ABP: Maximum amount of ability -- points to do ab"
            + "ilities");
        atVal.setToolTipText("ATK: Power for physical attacks");
        stVal.setToolTipText("STR: Physical strength");
        dfVal.setToolTipText("DEF: Defense from physical attacks");
        saVal.setToolTipText("STA: Amount before getting tired");
        spVal.setToolTipText("SPD: How fast between turns");
        evVal.setToolTipText("EVA: Ability to dodge physical attacks");
        dxVal.setToolTipText("DEX: Flexibility to move");
        myVal.setToolTipText("MYS: Magical power strength");
        mdVal.setToolTipText("MYD: Defense against magical attacks");
        meVal.setToolTipText("MYE: Ability to dodge magical attacks");
        wlVal.setToolTipText("WIL: Inner heart and determination");
        luVal.setToolTipText("LCK: How often luck is at the side");
        chVal.setToolTipText("CHA: How attractive the personality is");
        inVal.setToolTipText("INT: Ability to predict actions logically");
        ftVal.setToolTipText("FAT: To be hidden -- fatigue factor");
        sdVal.setToolTipText("S-D: To be hidden -- how close the soul is attach"
            + "ed - how much body has decayed");
        wmVal.setToolTipText("WTM: To be hidden -- modifier for how much weight"
            + " can be carried");
        rpVal.setToolTipText("REP: To be hidden -- reputation across the univer"
            + "se");
        hpLabel.setToolTipText(hpVal.getToolTipText());
        mpLabel.setToolTipText(mpVal.getToolTipText());
        apLabel.setToolTipText(apVal.getToolTipText());
        atLabel.setToolTipText(atVal.getToolTipText());
        stLabel.setToolTipText(stVal.getToolTipText());
        dfLabel.setToolTipText(dfVal.getToolTipText());
        saLabel.setToolTipText(saVal.getToolTipText());
        spLabel.setToolTipText(spVal.getToolTipText());
        evLabel.setToolTipText(evVal.getToolTipText());
        dxLabel.setToolTipText(dxVal.getToolTipText());
        myLabel.setToolTipText(myVal.getToolTipText());
        mdLabel.setToolTipText(mdVal.getToolTipText());
        meLabel.setToolTipText(meVal.getToolTipText());
        wlLabel.setToolTipText(wlVal.getToolTipText());
        luLabel.setToolTipText(luVal.getToolTipText());
        chLabel.setToolTipText(chVal.getToolTipText());
        inLabel.setToolTipText(inVal.getToolTipText());
        ftLabel.setToolTipText(ftVal.getToolTipText());
        sdLabel.setToolTipText(sdVal.getToolTipText());
        wmLabel.setToolTipText(wmVal.getToolTipText());
        rpLabel.setToolTipText(rpVal.getToolTipText());
        List<String> toonabllist = GetStats.getStats("Abls",toonStats,0,false);
        // add in status decoder here (can be method in GetStats)
        DefaultListModel ablDml = new DefaultListModel();
        GetStats.getitemsfromIDtoJList(save,toonabllist,ablDml,ablList,"dbAbl",
            "ablID","ablName");
        //all below is temporary
//        String tempEmpty = "<Empty>";
//add list for equip here
//        DefaultListModel<String> invDml = new DefaultListModel<>();
//        invDml.add(0,tempEmpty);
//        invList.setModel(invDml);
//        invList.setEnabled(false);
        //adjust in future with real queries
        
    }
    
    private void changeChar() throws SQLException, BadLocationException {
        setChar(saveName, (String) charDrop.getSelectedItem());
    }
    
    private void worldinfoText(String save) throws SQLException {
        //add game date method here
        String week = "1";
        String month = "1";
        String day = "1";
        String year = "1";
        //above it temp date
        int count = ((GetData.dbQuery(save,"*","dbToons","toonName","",true)))
            .size();
        List<Integer> lvls = new ArrayList<>();
        for(String lv : ((GetData.dbQuery(save,"*","dbToons","toonStartLv","",
            true)))) lvls.add(Integer.valueOf(lv));
        int toplv = Integer.MIN_VALUE;
        int topidx = -1;
        for (int l = 0; l < lvls.size(); l++) {
            int val = lvls.get(l);
            if (val > toplv) {
                toplv = val;
                topidx = l;
            }
        }
        List<String> toptoon = GetData.dbQuery(save, "*", "dbToons", "toonID",
            String.valueOf(topidx), false);
        String topplayer = toptoon.get(1);
        String alignment=((GetData.dbQuery(save, "*", "dbAlign", "alignID",
            Calculator.getAlign(Integer.parseInt(toptoon.get(4))), false)).get(6
            ));
        String age = (Calculator.getAge(Integer.parseInt(toptoon.get(7)), 
            toptoon.get(2)));
        String gender = ((GetData.dbQuery(save,"*","dbGender","genderID",toptoon
            .get(6),false)).get(1));
        String race = (GetData.dbQuery(save,"*","dbRace","raceID",toptoon.get(2)
            ,false)).get(7);
        String clas = ((GetData.dbQuery(save, "*", "dbClass", "classID",toptoon.
            get(3), false)).get(4));
        String size = Calculator.getSize((GetData.dbQuery(save, "*", "dbRace",
            "raceID",toptoon.get(2),false)).get(1), age);
        
        String text = "This world start at Week " + week + ", Month " + month 
            + ", Day " + day + ", Year " + year + ".\n\nCurrently, there are " 
            + count + " characters in the world.\n\nThe highest level character"
            + " is " + topplayer + ", who is a " + alignment + " " + age + " " 
            + gender + " that is " + size + " " + race + " " + clas + " at Leve"
            + "l " + toplv + ".\n\nYour possiblities are Limitless!\n\nSelect y"
            + "our character and then click Start New Game to begin your journe"
            + "y.";
        new TypeEffect(welcomeText,text,10).start();
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
    private javax.swing.JLabel ablLabel;
    private javax.swing.JList<String> ablList;
    private javax.swing.JScrollPane ablPane;
    private javax.swing.JLabel apLabel;
    private javax.swing.JLabel apVal;
    private javax.swing.JLabel atLabel;
    private javax.swing.JLabel atVal;
    private javax.swing.JScrollPane bioPane;
    private javax.swing.JTextArea bioText;
    private javax.swing.JPanel bottomPane;
    private javax.swing.JLabel chLabel;
    private javax.swing.JLabel chVal;
    private javax.swing.JComboBox<String> charDrop;
    private javax.swing.JLabel charToon;
    private javax.swing.JLabel charmLabel;
    private javax.swing.JList<String> charmList;
    private javax.swing.JScrollPane charmPane;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dfLabel;
    private javax.swing.JLabel dfVal;
    private javax.swing.JLabel dxLabel;
    private javax.swing.JLabel dxVal;
    private javax.swing.JLabel effLabel;
    private javax.swing.JList<String> effList;
    private javax.swing.JScrollPane effPane;
    private javax.swing.JLabel evLabel;
    private javax.swing.JLabel evVal;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel ftLabel;
    private javax.swing.JLabel ftVal;
    private javax.swing.JLabel heldLabel;
    private javax.swing.JList<String> heldList;
    private javax.swing.JScrollPane heldPane;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel hpVal;
    private javax.swing.JLabel inLabel;
    private javax.swing.JLabel inVal;
    private javax.swing.JLabel invLabel;
    private javax.swing.JList<String> invList;
    private javax.swing.JScrollPane invPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JLabel luLabel;
    private javax.swing.JLabel luVal;
    private javax.swing.JLabel mdLabel;
    private javax.swing.JLabel mdVal;
    private javax.swing.JLabel meLabel;
    private javax.swing.JLabel meVal;
    private javax.swing.JLabel mpLabel;
    private javax.swing.JLabel mpVal;
    private javax.swing.JLabel myLabel;
    private javax.swing.JLabel myVal;
    private javax.swing.JLabel newgameLabel;
    private javax.swing.JLabel rpLabel;
    private javax.swing.JLabel rpVal;
    private javax.swing.JLabel saLabel;
    private javax.swing.JLabel saVal;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JLabel sdLabel;
    private javax.swing.JLabel sdVal;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel spLabel;
    private javax.swing.JLabel spVal;
    private javax.swing.JLabel stLabel;
    private javax.swing.JLabel stVal;
    private javax.swing.JLabel startingworldLabel;
    private javax.swing.JLabel startingworldLabel1;
    private javax.swing.JLabel stat01Label;
    private javax.swing.JLabel stat02Label;
    private javax.swing.JLabel stat03Label;
    private javax.swing.JLabel stat04Label;
    private javax.swing.JLabel stat05Label;
    private javax.swing.JLabel titleLogo;
    private javax.swing.JLabel wearLabel;
    private javax.swing.JList<String> wearList;
    private javax.swing.JScrollPane wearPane;
    private javax.swing.JScrollPane welcomePane;
    private javax.swing.JTextArea welcomeText;
    private javax.swing.JLabel wlLabel;
    private javax.swing.JLabel wlVal;
    private javax.swing.JLabel wmLabel;
    private javax.swing.JLabel wmVal;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}