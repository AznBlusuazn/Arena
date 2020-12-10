
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
        ablLabel = new javax.swing.JLabel();
        effLabel = new javax.swing.JLabel();
        leftLabel = new javax.swing.JLabel();
        rightLabel = new javax.swing.JLabel();
        headLabel = new javax.swing.JLabel();
        faceLabel = new javax.swing.JLabel();
        bodyLabel = new javax.swing.JLabel();
        armsLabel = new javax.swing.JLabel();
        handsLabel = new javax.swing.JLabel();
        legsLabel = new javax.swing.JLabel();
        feeLabel = new javax.swing.JLabel();
        invLabel = new javax.swing.JLabel();
        ablBox = new javax.swing.JComboBox<>();
        effBox = new javax.swing.JComboBox<>();
        leftVal = new javax.swing.JLabel();
        rightVal = new javax.swing.JLabel();
        headVal = new javax.swing.JLabel();
        faceVal = new javax.swing.JLabel();
        bodyVal = new javax.swing.JLabel();
        armsVal = new javax.swing.JLabel();
        handsVal = new javax.swing.JLabel();
        legsVal = new javax.swing.JLabel();
        feetVal = new javax.swing.JLabel();
        invPane = new javax.swing.JScrollPane();
        invList = new javax.swing.JList<>();

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

        hpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        hpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hpLabel.setText("Max Health Points:");

        mpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mpLabel.setText("Max Mystic Points:");

        apLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        apLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        apLabel.setText("Max Ability Points:");

        atLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        atLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        atLabel.setText("Attack Power:");

        stLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stLabel.setText("Strength:");

        dfLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dfLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dfLabel.setText("Defense:");

        saLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        saLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        saLabel.setText("Stamina:");

        spLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        spLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        spLabel.setText("Speed:");

        evLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        evLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        evLabel.setText("Attack Evade:");

        dxLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dxLabel.setText("Dexterity:");

        myLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        myLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        myLabel.setText("Mystic Power:");

        mdLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mdLabel.setText("Mystic Defense:");

        meLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        meLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        meLabel.setText("Mystic Evade:");

        wlLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wlLabel.setText("Willpower:");

        luLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        luLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        luLabel.setText("Luck:");

        chLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        chLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chLabel.setText("Charisma:");

        inLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        inLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inLabel.setText("Intelligence:");

        ftLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ftLabel.setText("Fatigue(Hide):");

        sdLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sdLabel.setText("Soul/Decay(Hide):");

        wmLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wmLabel.setText("Weight Mod(Hide):");

        rpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rpLabel.setText("Reputation(Hide):");

        hpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        hpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hpVal.setText("<value>");

        mpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mpVal.setText("<value>");

        apVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        apVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apVal.setText("<value>");

        atVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        atVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        atVal.setText("<value>");

        stVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stVal.setText("<value>");

        dfVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dfVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dfVal.setText("<value>");

        saVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        saVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saVal.setText("<value>");

        spVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        spVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        spVal.setText("<value>");

        evVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        evVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        evVal.setText("<value>");

        dxVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        dxVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dxVal.setText("<value>");

        myVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        myVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        myVal.setText("<value>");

        mdVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        mdVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mdVal.setText("<value>");

        meVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        meVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        meVal.setText("<value>");

        wlVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wlVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wlVal.setText("<value>");

        luVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        luVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        luVal.setText("<value>");

        chVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        chVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chVal.setText("<value>");

        inVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        inVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inVal.setText("<value>");

        ftVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ftVal.setText("<value>");

        sdVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sdVal.setText("<value>");

        wmVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wmVal.setText("<value>");

        rpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rpVal.setText("<value>");

        ablLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ablLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ablLabel.setText("Starting Abilities:");

        effLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        effLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        effLabel.setText("Starting Effects:");

        leftLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        leftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        leftLabel.setText("Left Hand Equipped:");

        rightLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rightLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rightLabel.setText("Right Hand Equipped:");

        headLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        headLabel.setText("Head Equipped:");

        faceLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        faceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        faceLabel.setText("Face Equipped:");

        bodyLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        bodyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bodyLabel.setText("Body Equipped:");

        armsLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        armsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        armsLabel.setText("Arms Equipped:");

        handsLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        handsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        handsLabel.setText("Hands Equipped:");

        legsLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        legsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        legsLabel.setText("Legs Equipped:");

        feeLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        feeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        feeLabel.setText("Feet Equipped:");

        invLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        invLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invLabel.setText("Starting Inventory:");

        ablBox.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ablBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<value>" }));

        effBox.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        effBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<value>" }));

        leftVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        leftVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        leftVal.setText("<value>");

        rightVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rightVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rightVal.setText("<value>");

        headVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        headVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        headVal.setText("<value>");

        faceVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        faceVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        faceVal.setText("<value>");

        bodyVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        bodyVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bodyVal.setText("<value>");

        armsVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        armsVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        armsVal.setText("<value>");

        handsVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        handsVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        handsVal.setText("<value>");

        legsVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        legsVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        legsVal.setText("<value>");

        feetVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        feetVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        feetVal.setText("<value>");

        invList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        invList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        invPane.setViewportView(invList);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(stat01Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(charToon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(charDrop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(stat02Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stat03Label, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(stat04Label, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(bioPane)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(atLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(evLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(meVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wlVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(luVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sdVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wmVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(hpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ablLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(apVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(effLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(atVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(stVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(headLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dfVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(faceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(saVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bodyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(spVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(armsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(evVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(handsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dxVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(legsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(myVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(feeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(mdVal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(invLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(leftVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(ablBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(effBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rightVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(headVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(faceVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(bodyVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(armsVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(handsVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(legsVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(feetVal, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(confirmButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ablLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ablBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(effLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(effBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(apVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leftVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(atVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rightVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(headVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dfVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faceVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bodyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bodyVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(armsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(armsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(evVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(handsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(handsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dxVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(legsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(legsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(myVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feetVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(mdVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(meVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wlVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(luVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ftVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sdVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wmVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rpVal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(invPane))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(atLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(evLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(meLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
        new Avatars().setAvatar(charToon, charDrop.getSelectedItem().toString(),
            toonStats.get(11));
        double charXP=Double.parseDouble(Calculator.getLevel("ranxp",(toonStats.
            get(9))));
        double nextXP = Double.parseDouble(Calculator.getLevel("stalv", String.
            valueOf(Integer.parseInt(toonStats.get(9) + 1))));
        double ratioXP = charXP / nextXP;
        String alignName=(GetData.dbQuery(save,"*","dbAlign","align00",toonStats
            .get(4), false)).get(1);
        stat01Label.setText(alignName);
        stat01Label.setToolTipText(alignName + ": " + (GetData.dbQuery(save, "*"
            ,"dbAlign","align00",toonStats.get(4), false)).get(2));
        String ageName = (Calculator.getAge(Integer.parseInt(toonStats.get(8)), 
            toonStats.get(2)));
        String raceName = (GetData.dbQuery(save, "*","dbRace","raceID",toonStats
            .get(2), false)).get(1);
        String gendName = (GetData.dbQuery(save, "*", "dbGender", "genderID",
            toonStats.get(7), false)).get(1);
        stat02Label.setText(ageName + " • " + gendName + " " + raceName);
        stat02Label.setToolTipText(ageName + ": " + (GetData.dbQuery(save, "*", 
            "dbAge","ageName",ageName, false)).get(3) + " • " + gendName + ": " 
            + (GetData.dbQuery(save, "*","dbGender","genderID",toonStats.get(7),
            false)).get(2) + " • " + raceName + ": " + (GetData.dbQuery(save,"*"
            ,"dbRace","raceID",toonStats.get(2), false)).get(2));
        String className = (GetData.dbQuery(save, "*", "dbClass", "classID",
            toonStats.get(3), false)).get(1);
        stat03Label.setText("Level " + toonStats.get(9) + " • " + className);
        stat03Label.setToolTipText("Level: Based on the amount of experience ga"
            + "ined • " + className + ": " + (GetData.dbQuery(save, "*","dbClass"
            + "","classID",toonStats.get(3), false)).get(2));
        //add size somewhere
        //create size math
        //add status info for stat04Label.setText();
        stat04Label.setToolTipText("Status:  <Status info will go here>");
        String bioInfo = Converters.capFirstLetter((GetData.dbQuery(save,"*","d"
            + "bGender","genderID",toonStats.get(7),false)).get(32)) + " is " +
            (GetData.dbQuery(save, "*", "dbGender", "genderID",toonStats.get(7),
            false)).get(31) + " " + ((GetData.dbQuery(save, "*","dbAlign","alig"
            + "n00",toonStats.get(4),false)).get(31)) + " " + (Calculator.getAge
            (Integer.parseInt(toonStats.get(8)),toonStats.get(2))) + " " + (
            (GetData.dbQuery(save, "*","dbRace","raceID",toonStats.get(2), false
            )).get(31)) + " " + ((GetData.dbQuery(save, "*","dbClass","classID",
            toonStats.get(3), false)).get(31)) + " in " + 
                "<health status here>" 
            + ".\n\n" + toonStats.get(10);
            //add size somewhere
            //update health status above
        bioText.setText(bioInfo);
        List<String> newStats = GetStats.getStats(charDrop.getSelectedItem().
            toString(),ratioXP);
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
        sdVal.setToolTipText("S-D: To be hidden -- how close the soul is attache"
            + "d - how much body has decayed");
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
        List<String> toonabllist = GetData.dbQuery(save, "*","dbToonAbl",
            "toonID",toonStats.get(0), false);
        DefaultComboBoxModel ablDml = new DefaultComboBoxModel();
        GetStats.getitemsfromID(save,toonabllist,ablDml,ablBox,"dbAbl","ablID","ablName");
        List<String> toonefflist = GetData.dbQuery(save, "*","dbToonEffects",
            "toonID",toonStats.get(0), false);
        DefaultComboBoxModel effDml = new DefaultComboBoxModel();
        GetStats.getitemsfromID(save,toonefflist,effDml,effBox,"dbEffects","effID","effName");
        //all below is temporary
        String tempEmpty = "<Empty>";
        leftVal.setText(tempEmpty);
        rightVal.setText(tempEmpty);
        headVal.setText(tempEmpty);
        faceVal.setText(tempEmpty);
        bodyVal.setText(tempEmpty);
        armsVal.setText(tempEmpty);
        handsVal.setText(tempEmpty);
        legsVal.setText(tempEmpty);
        feetVal.setText(tempEmpty);
        DefaultListModel<String> invDml = new DefaultListModel<>();
        invDml.add(0,tempEmpty);
        invList.setModel(invDml);
        invList.setEnabled(false);
        //adjust in future with real queries
        
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
    private javax.swing.JComboBox<String> ablBox;
    private javax.swing.JLabel ablLabel;
    private javax.swing.JLabel apLabel;
    private javax.swing.JLabel apVal;
    private javax.swing.JLabel armsLabel;
    private javax.swing.JLabel armsVal;
    private javax.swing.JLabel atLabel;
    private javax.swing.JLabel atVal;
    private javax.swing.JScrollPane bioPane;
    private javax.swing.JTextArea bioText;
    private javax.swing.JLabel bodyLabel;
    private javax.swing.JLabel bodyVal;
    private javax.swing.JLabel chLabel;
    private javax.swing.JLabel chVal;
    private javax.swing.JComboBox<String> charDrop;
    private javax.swing.JLabel charToon;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dfLabel;
    private javax.swing.JLabel dfVal;
    private javax.swing.JLabel dxLabel;
    private javax.swing.JLabel dxVal;
    private javax.swing.JComboBox<String> effBox;
    private javax.swing.JLabel effLabel;
    private javax.swing.JLabel evLabel;
    private javax.swing.JLabel evVal;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel faceLabel;
    private javax.swing.JLabel faceVal;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JLabel feetVal;
    private javax.swing.JLabel ftLabel;
    private javax.swing.JLabel ftVal;
    private javax.swing.JLabel handsLabel;
    private javax.swing.JLabel handsVal;
    private javax.swing.JLabel headLabel;
    private javax.swing.JLabel headVal;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel hpVal;
    private javax.swing.JLabel inLabel;
    private javax.swing.JLabel inVal;
    private javax.swing.JLabel invLabel;
    private javax.swing.JList<String> invList;
    private javax.swing.JScrollPane invPane;
    private javax.swing.JLabel leftLabel;
    private javax.swing.JLabel leftVal;
    private javax.swing.JLabel legsLabel;
    private javax.swing.JLabel legsVal;
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
    private javax.swing.JLabel rightLabel;
    private javax.swing.JLabel rightVal;
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
    private javax.swing.JLabel stat01Label;
    private javax.swing.JLabel stat02Label;
    private javax.swing.JLabel stat03Label;
    private javax.swing.JLabel stat04Label;
    private javax.swing.JLabel titleLogo;
    private javax.swing.JLabel wlLabel;
    private javax.swing.JLabel wlVal;
    private javax.swing.JLabel wmLabel;
    private javax.swing.JLabel wmVal;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}