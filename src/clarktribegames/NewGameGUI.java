
// <editor-fold defaultstate="collapsed" desc="Header Info">
package clarktribegames;

import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

    String saveName = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
    String saveToons=((MainControls.savesDir).substring(((MainControls.savesDir)
        .indexOf("/",0)))).substring(1,((MainControls.savesDir).substring(((
        MainControls.savesDir).indexOf("/",0)))).indexOf("/", 1));
    List<String> toonList = null;
    DefaultComboBoxModel toonDml = new DefaultComboBoxModel();
    
    public NewGameGUI() throws IOException, Exception {
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
        ftLabel = new javax.swing.JLabel();
        sdLabel = new javax.swing.JLabel();
        wmLabel = new javax.swing.JLabel();
        rpLabel = new javax.swing.JLabel();
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
        bioLabel = new javax.swing.JLabel();
        aliasLabel = new javax.swing.JLabel();
        aknownLabel = new javax.swing.JLabel();
        aliasVal = new javax.swing.JLabel();
        aknownVal = new javax.swing.JLabel();
        statusPane = new javax.swing.JPanel();
        statusPane1 = new javax.swing.JPanel();
        toonstatsPane = new javax.swing.JScrollPane();
        toonstatsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(MainControls.appTitle);
        setIconImage(new MainControls().imageIcon.getImage());
        setResizable(false);
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
        saveLabel.setText("Current Limitless Save Game:");
        saveLabel.setFocusable(false);
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 11, 230, 21));

        charToon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        charToon.setText("[Player 1 Image Here]");
        charToon.setFocusable(false);
        getContentPane().add(charToon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 200, 200));

        selectLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        selectLabel.setText("Select Your Character:");
        selectLabel.setFocusable(false);
        getContentPane().add(selectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 200, 19));

        charDrop.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charDrop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Populated List>" }));
        charDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charDropActionPerformed(evt);
            }
        });
        getContentPane().add(charDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 19));

        exitButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        exitButton.setText("Back to Main Menu");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 750, 200, 25));

        limitLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        limitLabel.setText("<Limit File Name>");
        limitLabel.setFocusable(false);
        getContentPane().add(limitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 11, 340, 21));

        confirmButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        confirmButton.setText("Start New Game");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 750, 200, 25));

        stat01Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat01Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat01Label.setText("<Alignment>");
        getContentPane().add(stat01Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 200, 19));

        stat02Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat02Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat02Label.setText("<Age> • <Gender>");
        getContentPane().add(stat02Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 200, 19));

        stat03Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat03Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat03Label.setText("<Size> • <Race>");
        getContentPane().add(stat03Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, 200, 19));

        stat04Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat04Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat04Label.setText("<Class> • <Lv>");
        getContentPane().add(stat04Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 19));

        stat05Label.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        stat05Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stat05Label.setText("<Status>");
        getContentPane().add(stat05Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 200, 19));

        bioPane.setBorder(null);
        bioPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bioPane.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N

        bioText.setEditable(false);
        bioText.setColumns(20);
        bioText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        bioText.setLineWrap(true);
        bioText.setRows(9);
        bioText.setText("This is where the player bio text goes.");
        bioText.setWrapStyleWord(true);
        bioText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bioPane.setViewportView(bioText);

        getContentPane().add(bioPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 625, 225, 148));

        ftLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ftLabel.setText("FA-Test Val:");
        getContentPane().add(ftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 625, 98, 25));

        sdLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sdLabel.setText("S&D-Test Val:");
        getContentPane().add(sdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, 98, 25));

        wmLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wmLabel.setText("WM-Test Val:");
        getContentPane().add(wmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 675, 98, 25));

        rpLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rpLabel.setText("RP-Test Value:");
        getContentPane().add(rpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, -1, 25));

        ftVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ftVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ftVal.setText("<value>");
        getContentPane().add(ftVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 625, 75, 25));

        sdVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        sdVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sdVal.setText("<value>");
        getContentPane().add(sdVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 75, 25));

        wmVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wmVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wmVal.setText("<value>");
        getContentPane().add(wmVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 675, 75, 25));

        rpVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        rpVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rpVal.setText("<value>");
        getContentPane().add(rpVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 700, 75, 25));

        effLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        effLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        effLabel.setText("Starting Effects");
        getContentPane().add(effLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 425, 225, 25));

        ablLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        ablLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ablLabel.setText("Starting Abilities");
        getContentPane().add(ablLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 250, 225, 25));

        heldLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        heldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heldLabel.setText("Equipment Held");
        getContentPane().add(heldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 250, 225, 25));

        wearLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        wearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wearLabel.setText("Wearables Equipped");
        getContentPane().add(wearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 350, 225, 25));

        charmLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        charmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        charmLabel.setText("Charms Equipped");
        getContentPane().add(charmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 525, 225, 25));

        invLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        invLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invLabel.setText("Starting Inventory");
        getContentPane().add(invLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 625, 225, 25));

        heldList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        heldList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        heldPane.setViewportView(heldList);

        getContentPane().add(heldPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 275, 225, 75));

        wearList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        wearList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        wearPane.setViewportView(wearList);

        getContentPane().add(wearPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 375, 225, 150));

        charmList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        charmList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        charmPane.setViewportView(charmList);

        getContentPane().add(charmPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 550, 225, 75));

        invList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        invList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        invPane.setViewportView(invList);

        getContentPane().add(invPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 650, 225, 123));

        effPane.setHorizontalScrollBar(null);

        effList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        effList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        effPane.setViewportView(effList);

        getContentPane().add(effPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 450, 225, 150));

        ablPane.setHorizontalScrollBar(null);

        ablList.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        ablList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ablPane.setViewportView(ablList);

        getContentPane().add(ablPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 275, 225, 150));

        startingworldLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        startingworldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startingworldLabel.setText("This game is in development");
        getContentPane().add(startingworldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 597, 430, 25));

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
        getContentPane().add(startingworldLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 430, 25));

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jTextPane1.setText("The values below and to the right are for testing only...");
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 625, 200, 50));

        bioLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        bioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bioLabel.setText("Character Bio");
        getContentPane().add(bioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 600, 225, 25));

        aliasLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aliasLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        aliasLabel.setText("Alias:");
        getContentPane().add(aliasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 675, 50, 25));

        aknownLabel.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aknownLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        aknownLabel.setText("Known:");
        getContentPane().add(aknownLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 700, 50, 25));

        aliasVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aliasVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aliasVal.setText("<value>");
        getContentPane().add(aliasVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 675, 160, 25));

        aknownVal.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aknownVal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aknownVal.setText("<value>");
        getContentPane().add(aknownVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 700, 160, 25));

        statusPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout statusPaneLayout = new javax.swing.GroupLayout(statusPane);
        statusPane.setLayout(statusPaneLayout);
        statusPaneLayout.setHorizontalGroup(
            statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        statusPaneLayout.setVerticalGroup(
            statusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        getContentPane().add(statusPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 200, 30));

        javax.swing.GroupLayout statusPane1Layout = new javax.swing.GroupLayout(statusPane1);
        statusPane1.setLayout(statusPane1Layout);
        statusPane1Layout.setHorizontalGroup(
            statusPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        statusPane1Layout.setVerticalGroup(
            statusPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(statusPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 773, 200, 25));

        toonstatsPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        toonstatsPane.setColumnHeaderView(null);
        toonstatsPane.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        toonstatsPane.setHorizontalScrollBar(null);

        toonstatsTable.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        toonstatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                " ", " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        toonstatsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        toonstatsTable.setAutoscrolls(false);
        toonstatsTable.setRowSelectionAllowed(false);
        toonstatsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        toonstatsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        toonstatsTable.getTableHeader().setReorderingAllowed(false);
        toonstatsPane.setViewportView(toonstatsTable);
        if (toonstatsTable.getColumnModel().getColumnCount() > 0) {
            toonstatsTable.getColumnModel().getColumn(0).setResizable(false);
            toonstatsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            toonstatsTable.getColumnModel().getColumn(1).setResizable(false);
            toonstatsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        getContentPane().add(toonstatsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 200, 300));

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
        } catch (SQLException | BadLocationException | IOException ex) {
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
            confirmButton();
        } catch (SQLException | IOException ex) {
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
            ChecksBalances.iffolderexistsDelete(MainControls.savesDir);
            MainControls.savesDir = MainControls.defaultsavesDir;
            System.gc();
            this.dispose();
            new MainMenuGUI().setVisible(true);
        } catch(IOException ex) {
            logFile("severe","MenuOption Error.\nIOEx: " + ex.toString());
        }
    }

    private void popcharDrop(String save) throws SQLException, IOException {
        limitLabel.setText("[" + Converters.capFirstLetter(saveToons) + 
            "] • [Database: " + saveName + "]");
        try {
            String savetoons = "sav" + saveToons + "Toons";
            toonList=GetData.dbQuery(save,"*",savetoons,"toonName","",true);
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
        BadLocationException,
        IOException {
        String savetoons = "sav" + saveToons + "Toons";
        List<String> toonstats = GetData.dbQuery(save, "*",savetoons,"toonName",
            toonname, false);
        Avatars.setAvatar(charToon, charDrop.getSelectedItem().toString(),
            toonstats.get(10));
        double charXP = Double.parseDouble(toonstats.get(21));
        double nextXP = Double.parseDouble(Calculator.getLevel("stalv", String.
            valueOf(Integer.parseInt(toonstats.get(8) + 1))));
        double ratioXP = charXP / nextXP;
        String alignID=Calculator.getAlign(Integer.parseInt(toonstats.get(4)));
        String alignName=(GetData.dbQuery(save,"*","dbAlign","alignID",alignID, 
            false)).get(1);
        Font stat01Font = new Font(stat01Label.getFont().getName(),Font.BOLD,
            stat01Label.getFont().getSize());

        String aligncolor=GetStats.getalignColor(Integer.parseInt((toonstats.get
            (4))));
        stat01Label.setText(alignName);
        stat01Label.setFont(stat01Font);
        stat01Label.setForeground((Converters.figureoutColor(aligncolor)));
        stat01Label.setToolTipText(alignName + ": " + (GetData.dbQuery(save, "*"
            ,"dbAlign","alignID",alignID, false)).get(2));
        String ageName = (Calculator.getAge(Integer.parseInt(toonstats.get(7)), 
            toonstats.get(2)));
        String raceName = (GetData.dbQuery(save, "*","dbRace","raceID",toonstats
            .get(2), false)).get(1);

        String gendName = (GetData.dbQuery(save, "*", "dbGender", "genderID",
            toonstats.get(6), false)).get(1);
        stat02Label.setText(ageName + " • " + gendName);
        stat02Label.setToolTipText(ageName + ": " + (GetData.dbQuery(save, "*", 
            "dbAge","ageName",ageName, false)).get(3) + " • " + gendName + ": " 
            + (GetData.dbQuery(save, "*","dbGender","genderID",toonstats.get(6),
            false)).get(2));
        String sizeID = toonstats.get(22);
        String sizeName=(GetData.dbQuery(save, "*", "dbSize", "sizeID", sizeID, 
            false)).get(1);
        stat03Label.setText(sizeName + " • " + raceName);
        stat03Label.setToolTipText(sizeName + ": " + (GetData.dbQuery(save, "*",
            "dbSize","sizeID",sizeID,false)).get(2) +  " • "  + raceName + 
            ": " + (GetData.dbQuery(save,"*","dbRace","raceID",toonstats.get(2),
            false)).get(2));
        String className = (GetData.dbQuery(save, "*", "dbClass", "classID",
            toonstats.get(3), false)).get(1);
        stat04Label.setText(className + " • Level " + toonstats.get(8));
        stat04Label.setToolTipText(className + ": " + (GetData.dbQuery(save,"*",
            "dbClass","classID",toonstats.get(3), false)).get(2) + " • Level " +
            toonstats.get(8));
        //toonheld 13 | toonwear 14 | tooncharms 15 | tooninv 16
        DefaultListModel heldDml = new DefaultListModel();
        DefaultListModel wearDml = new DefaultListModel();
        DefaultListModel charmDml = new DefaultListModel();
        DefaultListModel invDml = new DefaultListModel();
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonstats.get(13).
            split("x")),heldDml,heldList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonstats.get(14).
            split("x")),wearDml,wearList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonstats.get(15).
            split("x")),charmDml,charmList,"dbItems","itemID","itemName");
        GetStats.getitemsfromIDtoJList(save,Arrays.asList(toonstats.get(16).
            split("x")),invDml,invList,"dbItems","itemID","itemName");
        List<String> effStats;
        try {
            effStats = GetStats.getStats("Effects",toonstats,0,false);
            String statuscode=(((Arrays.toString(effStats.toArray())).replaceAll
            ("MASTER, ", "").replaceAll(",", "-")).replaceAll("[^\\d+\\-]",""));
            if(statuscode.length() <= 0) {
            statuscode = "0";
        }
        DefaultListModel effDml = new DefaultListModel();
        GetStats.getitemsfromIDtoJList(save,effStats,effDml,effList,"dbEffects",
            "effID","effName");
        if(effList.getModel().getElementAt(0).equals("<None>")) {
            effDml.removeAllElements();
            effDml.addElement("Normal Health");
            effList.setEnabled(true);
        }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        // add in status decoder here (can be method in GetStats)

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
            "dbGender","genderID",toonstats.get(6),false)).get(5))+" is a "+((
            GetData.dbQuery(save,"*","dbAlign","alignID",alignID,false)).get(6))
            + " " + ageName +" " + (GetData.dbQuery(save, "*", "dbGender", 
            "genderID",toonstats.get(6),false)).get(1) + " that is " + (GetData.
            dbQuery(save, "*","dbSize","sizeName",sizeName,false)).get(4) + " " 
            +(GetData.dbQuery(save,"*","dbRace","raceID",toonstats.get(2),false)
            ).get(7) + " " + ((GetData.dbQuery(save, "*", "dbClass", "classID",
            toonstats.get(3), false)).get(4)) + " and " + statusbio  + ".\n\n" +
            toonstats.get(9);
        stat05Label.setToolTipText(statusname + ": " + statusdesc);
            //update health status above
        bioText.setText(bioInfo);
        
        List<String> newstats=Arrays.asList((GetData.dbQuery(save,"*",savetoons.
            replaceAll("Toons","Temp"),"tempID",toonstats.get(0),false).get(1)).
            split("x"));
        
        for(int item = 0; item < 17; item++) {
            ((DefaultTableModel)toonstatsTable.getModel()).setValueAt(newstats.get(item + 8), item, 1);
        }

        ftVal.setText(newstats.get(25));
        sdVal.setText(newstats.get(26) + "/" + (newstats.get(27)));
        wmVal.setText(newstats.get(28));
        rpVal.setText(newstats.get(29));
        if(ChecksBalances.isNullOrEmpty(toonstats.get(17)) || (toonstats.get(17)
            .equals("null"))) {
            aliasVal.setVisible(false);
            aliasLabel.setVisible(false);
            aknownVal.setVisible(false);
            aknownLabel.setVisible(false);
        }
        aliasVal.setText(toonstats.get(17));
        if(toonstats.get(19).equals("0")) {
            aknownVal.setText("Alias Known");
        } else {
            aknownVal.setText("Secret Identity");
        }

//        hpVal.setToolTipText("HTP: Maximum amount of health -- the life force");
//        mpVal.setToolTipText("MYP: Maximum amount of mystic -- magic points");
//        apVal.setToolTipText("ABP: Maximum amount of ability -- points to do ab"
//            + "ilities");
//        atVal.setToolTipText("ATK: Power for physical attacks");
//        stVal.setToolTipText("STR: Physical strength");
//        dfVal.setToolTipText("DEF: Defense from physical attacks");
//        saVal.setToolTipText("STA: Amount before getting tired");
//        spVal.setToolTipText("SPD: How fast between turns");
//        evVal.setToolTipText("EVA: Ability to dodge physical attacks");
//        dxVal.setToolTipText("DEX: Flexibility to move");
//        myVal.setToolTipText("MYS: Magical power strength");
//        mdVal.setToolTipText("MYD: Defense against magical attacks");
//        meVal.setToolTipText("MYE: Ability to dodge magical attacks");
//        wlVal.setToolTipText("WIL: Inner heart and determination");
//        luVal.setToolTipText("LCK: How often luck is at the side");
//        chVal.setToolTipText("CHA: How attractive the personality is");
//        inVal.setToolTipText("INT: Ability to predict actions logically");
        ftVal.setToolTipText("FAT: To be hidden -- fatigue factor");
        sdVal.setToolTipText("S-D: To be hidden -- how close the soul is attach"
            + "ed - how much body has decayed");
        wmVal.setToolTipText("WTM: To be hidden -- modifier for how much weight"
            + " can be carried");
        rpVal.setToolTipText("REP: To be hidden -- reputation across the univer"
            + "se");
//        hpLabel.setToolTipText(hpVal.getToolTipText());
//        mpLabel.setToolTipText(mpVal.getToolTipText());
//        apLabel.setToolTipText(apVal.getToolTipText());
//        atLabel.setToolTipText(atVal.getToolTipText());
//        stLabel.setToolTipText(stVal.getToolTipText());
//        dfLabel.setToolTipText(dfVal.getToolTipText());
//        saLabel.setToolTipText(saVal.getToolTipText());
//        spLabel.setToolTipText(spVal.getToolTipText());
//        evLabel.setToolTipText(evVal.getToolTipText());
//        dxLabel.setToolTipText(dxVal.getToolTipText());
//        myLabel.setToolTipText(myVal.getToolTipText());
//        mdLabel.setToolTipText(mdVal.getToolTipText());
//        meLabel.setToolTipText(meVal.getToolTipText());
//        wlLabel.setToolTipText(wlVal.getToolTipText());
//        luLabel.setToolTipText(luVal.getToolTipText());
//        chLabel.setToolTipText(chVal.getToolTipText());
//        inLabel.setToolTipText(inVal.getToolTipText());
        ftLabel.setToolTipText(ftVal.getToolTipText());
        sdLabel.setToolTipText(sdVal.getToolTipText());
        wmLabel.setToolTipText(wmVal.getToolTipText());
        rpLabel.setToolTipText(rpVal.getToolTipText());
        List<String> toonabllist = GetStats.getStats("Abls",toonstats,0,false);
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
    
    private void changeChar() throws SQLException, BadLocationException,
        IOException {
        setChar(saveName, (String) charDrop.getSelectedItem());
    }
    
    private void worldinfoText(String save) throws SQLException {
        //add game date method here
        String week = "1";
        String month = "1";
        String day = "1";
        String year = "1";
        //above it temp date
        String savetoons = "sav" + saveToons + "Toons";
        int count = ((GetData.dbQuery(save,"*",savetoons,"toonName","",true)))
            .size();
        List<Integer> exps = new ArrayList<>();
        for(String exp : ((GetData.dbQuery(save,"*",savetoons,"toonExp","",
            true)))) exps.add(Integer.valueOf(exp));
        int toplv = Integer.MIN_VALUE;
        int topidx = -1;

        for (int l = 0; l < exps.size(); l++) {
            int val = exps.get(l);
            if (val > toplv) {
                toplv = val;
                topidx = l;
            }
        }

        List<String> toptoon = GetData.dbQuery(save, "*", savetoons, "toonID",
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
            + "l " + Calculator.getLevel("curlv", String.valueOf(toplv)) + ".\n"
            + "\nYour possiblities are Limitless!\n\nSelect your character and "
            + "then click Start New Game to begin your journey.";
        new TypeEffect(welcomeText,text,10).start();
    }
    
    private void confirmButton() throws SQLException, IOException {
        String savetoons = "sav" + saveToons + "Toons";
        String savemax = "sav" + saveToons + "Max";
        MainControls.selectedToon = GetData.dbQuery(saveName,"*",savetoons, 
            "toonID",String.valueOf(charDrop.getSelectedIndex()), false).get(0);
        boolean yesno = Popups.yesnoPopup("Character Selection", "You've select"
            + "ed " + charDrop.getSelectedItem() + " as your character.\n\nAre "
            + "you sure you want to start the game?");
        if(yesno) {
            ChecksBalances.newfileCheck(MainControls.savesDir+".lastused",true,
                MainControls.selectedToon+"\n"+MainControls.selectedSave
                ,true);
            cleanUp();
            StartGame.startGame(saveName, savetoons, savemax);
        } else {
            MainControls.selectedToon = "";
        }
    }
            
    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    private void exitProcess() throws IOException, JavaLayerException {
        cleanUp();
        ChecksBalances.iffolderexistsDelete(MainControls.savesDir);
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
    private javax.swing.JLabel aknownLabel;
    private javax.swing.JLabel aknownVal;
    private javax.swing.JLabel aliasLabel;
    private javax.swing.JLabel aliasVal;
    private javax.swing.JLabel bioLabel;
    private javax.swing.JScrollPane bioPane;
    private javax.swing.JTextArea bioText;
    private javax.swing.JPanel bottomPane;
    private javax.swing.JComboBox<String> charDrop;
    private static javax.swing.JLabel charToon;
    private javax.swing.JLabel charmLabel;
    private javax.swing.JList<String> charmList;
    private javax.swing.JScrollPane charmPane;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel effLabel;
    private javax.swing.JList<String> effList;
    private javax.swing.JScrollPane effPane;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel ftLabel;
    private javax.swing.JLabel ftVal;
    private javax.swing.JLabel heldLabel;
    private javax.swing.JList<String> heldList;
    private javax.swing.JScrollPane heldPane;
    private javax.swing.JLabel invLabel;
    private javax.swing.JList<String> invList;
    private javax.swing.JScrollPane invPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JLabel newgameLabel;
    private javax.swing.JLabel rpLabel;
    private javax.swing.JLabel rpVal;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JLabel sdLabel;
    private javax.swing.JLabel sdVal;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel startingworldLabel;
    private javax.swing.JLabel startingworldLabel1;
    private javax.swing.JLabel stat01Label;
    private javax.swing.JLabel stat02Label;
    private javax.swing.JLabel stat03Label;
    private javax.swing.JLabel stat04Label;
    private javax.swing.JLabel stat05Label;
    private javax.swing.JPanel statusPane;
    private javax.swing.JPanel statusPane1;
    private javax.swing.JLabel titleLogo;
    private javax.swing.JScrollPane toonstatsPane;
    private static javax.swing.JTable toonstatsTable;
    private javax.swing.JLabel wearLabel;
    private javax.swing.JList<String> wearList;
    private javax.swing.JScrollPane wearPane;
    private javax.swing.JScrollPane welcomePane;
    private javax.swing.JTextArea welcomeText;
    private javax.swing.JLabel wmLabel;
    private javax.swing.JLabel wmVal;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}