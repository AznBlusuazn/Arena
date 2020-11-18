package com.clarktribe.arena;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

    // <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * @version ALPHA 0.0.2 / 2020.11.18.0019
 * 
 */
// </editor-fold>

public class MainGUI extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="initialized variables">
    int p1Index = 0;
    String p1Name = "";
    String p1Race = "";
    String p1Class = "";
    String p1Align = "";
    int p1HP = 0;
    int p1AP = 0;
    int p1MP = 0;
    int p1Att = 0;
    int p1Str = 0;
    int p1Def = 0;
    int p1Sta = 0;
    int p1Spd = 0;
    int p1Eva = 0;
    int p1Dex = 0;
    int p1Mys = 0;
    int p1Wil = 0;
    int p1Lck = 0;
    int p1Chm = 0;
    int p1Int = 0;
    int p1Age = 0;
    int plLv = 0;
    int p1Exp = 0;
    int p1Rep = 0;
    String p1Bio = "";
    String p1Image = "";
    String p1Status = "Healthy";
    
    int p2Index = 0;
    String p2Name = "";
    String p2Race = "";
    String p2Class = "";
    String p2Align = "";
    int p2HP = 0;
    int p2AP = 0;
    int p2MP = 0;
    int p2Att = 0;
    int p2Str = 0;
    int p2Def = 0;
    int p2Sta = 0;
    int p2Spd = 0;
    int p2Eva = 0;
    int p2Dex = 0;
    int p2Mys = 0;
    int p2Wil = 0;
    int p2Lck = 0;
    int p2Chm = 0;
    int p2Int = 0;
    int p2Age = 0;
    int p2Lv = 0;
    int p2Exp = 0;
    int p2Rep = 0;
    String p2Bio = "";
    String p2Image = "";
    String p2Status = "Healthy";
    
    // </editor-fold>
    
    public MainGUI() throws InterruptedException, SQLException, IOException, URISyntaxException {
        initComponents();
        new DatabaseCheck().dbCheck();
        setLocationRelativeTo(null);
        welcomePlayer();
        testFill();
        setP1("The Man Of Iron");
        setP2("The Captain");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1Toon = new javax.swing.JLabel();
        p1Info = new javax.swing.JLabel();
        p1Select = new javax.swing.JComboBox<>();
        p1Pane = new javax.swing.JScrollPane();
        p1Text = new javax.swing.JTextArea();
        battlePane = new javax.swing.JScrollPane();
        battleText = new javax.swing.JTextArea();
        p2Toon = new javax.swing.JLabel();
        p2Info = new javax.swing.JLabel();
        p2Select = new javax.swing.JComboBox<>();
        p2Pane = new javax.swing.JScrollPane();
        p2Text = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arena Game [Alpha]");
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setName("mainGUI"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setResizable(false);

        p1Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Toon.setText("COM IMAGE");
        p1Toon.setFocusable(false);

        p1Info.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p1Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Info.setText("Race - Class - Age");
        p1Info.setFocusable(false);

        p1Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 1" }));

        p1Text.setColumns(20);
        p1Text.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p1Text.setLineWrap(true);
        p1Text.setRows(5);
        p1Text.setText("_Align_ - _Rep_\n\nStatus:  _\n\nLevel:  _\n\nHP:  _/_\nAP:  _/_\nMP:  _/_\n\nAttack:\t_\nStrength: \t_\nDefense:\t_\nStamina:  \t_\nSpeed:\t_\nEvade:\t_\nDexterity:\t_\nMystic:\t_\nWillpower:  \t_\nLuck:  \t_\nCharm:\t_\nIntellect:\t_\n\nExperience:  _/_\n\n_BIO_");
        p1Text.setWrapStyleWord(true);
        p1Text.setFocusable(false);
        p1Pane.setViewportView(p1Text);

        battleText.setColumns(20);
        battleText.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        battleText.setLineWrap(true);
        battleText.setRows(5);
        battleText.setWrapStyleWord(true);
        battleText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                battleTextKeyPressed(evt);
            }
        });
        battlePane.setViewportView(battleText);

        p2Toon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Toon.setText("PLAYER IMAGE");
        p2Toon.setFocusable(false);

        p2Info.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        p2Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Info.setText("Race - Class - Age");
        p2Info.setFocusable(false);

        p2Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 2" }));

        p2Text.setColumns(20);
        p2Text.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        p2Text.setLineWrap(true);
        p2Text.setRows(5);
        p2Text.setText("_Align_ - _Rep_\n\nStatus:  _\n\nLevel:  _\n\nHP:  _/_\nAP:  _/_\nMP:  _/_\n\nAttack:\t_\nStrength: \t_\nDefense:\t_\nStamina:  \t_\nSpeed:\t_\nEvade:\t_\nDexterity:\t_\nMystic:\t_\nWillpower:  \t_\nLuck:  \t_\nCharm:\t_\nIntellect:\t_\n\nExperience:  _/_\n\n_BIO_");
        p2Text.setWrapStyleWord(true);
        p2Text.setFocusable(false);
        p2Pane.setViewportView(p2Text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1Toon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 810, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p1Select, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p1Info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p1Pane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(battlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p2Toon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p2Pane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(p2Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p2Select, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1Toon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Toon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1Info, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Info, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p2Pane, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(battlePane)
                    .addComponent(p1Pane))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void battleTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battleTextKeyPressed
        lockSelect(p1Select);
        lockSelect(p2Select);
    }//GEN-LAST:event_battleTextKeyPressed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (InterruptedException | SQLException | IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void welcomePlayer() {
        String text = 
                "Welcome to the Arena Game.  This is an alpha version of the ga"
                + "me, thus don't expect a whole lot.  It's a work in progress."
                + "  This is just filler text for something greater, much, much"
                + " later.\n\nEnjoy. - Geoff";
        new TypeEffect(battleText,text).start();
        p1Select.setEnabled(true);
        p2Select.setEnabled(true);
    }
            
    private List<String> dbQuery(String search,String table,String column,
            String matchcol, String matchstr, boolean isitSingle) throws 
            SQLException {
        String list = "";
        if (!isitSingle) {
            System.out.println("IT IS NOTTRUE");
                list = (new RunQuery().getSpecificRecord(search, table, column,
                        matchcol, matchstr))
                .replaceAll("\\[", "").replaceAll("\\]","");
            } else {
            System.out.println("IT IS TRUE");
        list = (new RunQuery().getSingleList(search, table, column))
                .replaceAll("\\[", "").replaceAll("\\]","");
        }
        String[] stringList = list.split(",");
        List<String> convertedList = Arrays.asList(stringList);
        return convertedList;
    }
    
    private void testFill() throws SQLException {
        //fills Toon boxes
        List<String> toonList = dbQuery("*","dbToons","toonName","","", true);
        DefaultComboBoxModel dml1 = new DefaultComboBoxModel();
        DefaultComboBoxModel dml2 = new DefaultComboBoxModel();
        fillSelect(p1Select,(toonList),dml1);
        fillSelect(p2Select,(toonList),dml2);
    }
    
//    private void test2() throws SQLException {
//        List<String> toonStats = dbQuery("*","dbToons","toonName","toonName","The Man Of Iron", false);
//        String[] vars = ((toonStats.toString()).substring(1,(toonStats.toString()).length())).split(",");
//        System.out.println("First Pre: " + vars[0]);
//        System.out.println("First Post:" + removeSpace(vars[0]));
//        
//        System.out.println("SecondPre: " + vars[1]);
//        System.out.println("SecondPost:" + removeSpace(vars[1]));
//        
//        System.out.println();
//    }
    
    public void setP1(String toonname) throws SQLException {
        List<String> toonStats = dbQuery("*","dbToons","toonName","toonName",
                toonname, false);
        String[] p1Field = ((toonStats.toString()).substring(1,(toonStats.
                toString()).length())).split(",");
        System.out.println(p1Field[0] + " " + p1Field[1]);
        p1Index = Integer.parseInt(removeSpace(p1Field[0]));
        p1Name = removeSpace(p1Field[1]);
        p1Race = removeSpace(p1Field[2]);
        p1Class = removeSpace(p1Field[3]);
        p1Align = removeSpace(p1Field[4]);
        p1HP = Integer.parseInt(removeSpace(p1Field[5]));
        p1MP = Integer.parseInt(removeSpace(p1Field[6]));
        p1AP = Integer.parseInt(removeSpace(p1Field[7]));
        p1Att = Integer.parseInt(removeSpace(p1Field[8]));
        p1Str = Integer.parseInt(removeSpace(p1Field[9]));
        p1Def = Integer.parseInt(removeSpace(p1Field[10]));
        p1Sta = Integer.parseInt(removeSpace(p1Field[11]));
        p1Spd = Integer.parseInt(removeSpace(p1Field[12]));
        p1Eva = Integer.parseInt(removeSpace(p1Field[13]));
        p1Dex = Integer.parseInt(removeSpace(p1Field[14]));
        p1Mys = Integer.parseInt(removeSpace(p1Field[15]));
        p1Wil = Integer.parseInt(removeSpace(p1Field[16]));
        p1Lck = Integer.parseInt(removeSpace(p1Field[17]));
        p1Chm = Integer.parseInt(removeSpace(p1Field[18]));
        p1Int = Integer.parseInt(removeSpace(p1Field[19]));
        p1Age = Integer.parseInt(removeSpace(p1Field[25]));
        plLv = Integer.parseInt(removeSpace(p1Field[26]));
        p1Exp = Integer.parseInt(removeSpace(p1Field[27]));
        p1Rep = Integer.parseInt(removeSpace(p1Field[28]));
        p1Bio = removeSpace(p1Field[29]);
        p1Image = removeSpace(p1Field[30]).replace("]","");
        
        p1Select.setSelectedIndex(p1Index - 1);
        p1Text.setText(p1Align + " / " + p1Rep + "\n\nStatus:  \t" + p1Status 
                + "\n\nLevel: \t " + plLv + "\n\nHP: \t " + p1HP + "/" + p1HP 
                + "\nAP: \t" + p1AP + "/" + p1AP + "\nMP: \t " + p1MP + "/" +
                p1MP + "\n\nAttack:\t\t" + p1Att + "\nStrength: \t" + p1Str + 
                "\nDefense:\t" + p1Def + "\nStamina:  \t" + p1Sta + "\nSpeed:\t\t"
                + p1Spd + "\nEvade:\t\t" + p1Eva + "\nDexterity:\t" + p1Dex + 
                "\nMystic:\t\t" + p1Mys + "\nWillpower: \t" + p1Wil + 
                "\nLuck:\t\t" + p1Lck + "\nCharm:\t\t" + p1Chm + "\nIntellect:\t"
                + p1Int + "\n\nExperience:  \t" + p1Exp + "/" + p1Exp + "\n\n" 
                + p1Bio);
        p1Info.setText(p1Race + " - " + p1Class + " - " + "Age " + p1Age);
        new ToonImage().setImage(p1Toon,p1Image);
        lockSelect(p1Select);

    }
    
    public void setP2(String toonname) throws SQLException {
        List<String> toonStats = dbQuery("*","dbToons","toonName","toonName",
                toonname, false);
        String[] p2Field = ((toonStats.toString()).substring(1,(toonStats.
                toString()).length())).split(",");
        System.out.println(p2Field[0] + " " + p2Field[1]);
        p2Index = Integer.parseInt(removeSpace(p2Field[0]));
        p2Name = removeSpace(p2Field[1]);
        p2Race = removeSpace(p2Field[2]);
        p2Class = removeSpace(p2Field[3]);
        p2Align = removeSpace(p2Field[4]);
        p2HP = Integer.parseInt(removeSpace(p2Field[5]));
        p2MP = Integer.parseInt(removeSpace(p2Field[6]));
        p2AP = Integer.parseInt(removeSpace(p2Field[7]));
        p2Att = Integer.parseInt(removeSpace(p2Field[8]));
        p2Str = Integer.parseInt(removeSpace(p2Field[9]));
        p2Def = Integer.parseInt(removeSpace(p2Field[10]));
        p2Sta = Integer.parseInt(removeSpace(p2Field[11]));
        p2Spd = Integer.parseInt(removeSpace(p2Field[12]));
        p2Eva = Integer.parseInt(removeSpace(p2Field[13]));
        p2Dex = Integer.parseInt(removeSpace(p2Field[14]));
        p2Mys = Integer.parseInt(removeSpace(p2Field[15]));
        p2Wil = Integer.parseInt(removeSpace(p2Field[16]));
        p2Lck = Integer.parseInt(removeSpace(p2Field[17]));
        p2Chm = Integer.parseInt(removeSpace(p2Field[18]));
        p2Int = Integer.parseInt(removeSpace(p2Field[19]));
        p2Age = Integer.parseInt(removeSpace(p2Field[25]));
        plLv = Integer.parseInt(removeSpace(p2Field[26]));
        p2Exp = Integer.parseInt(removeSpace(p2Field[27]));
        p2Rep = Integer.parseInt(removeSpace(p2Field[28]));
        p2Bio = removeSpace(p2Field[29]);
        p2Image = removeSpace(p2Field[30]).replace("]","");
        
        p2Select.setSelectedIndex(p2Index - 1);
        p2Text.setText(p2Align + " / " + p2Rep + "\n\nStatus:  \t" + p2Status 
                + "\n\nLevel: \t " + plLv + "\n\nHP: \t " + p2HP + "/" + p2HP 
                + "\nAP:\t " + p2AP + "/" + p2AP + "\nMP: \t " + p2MP + "/" +
                p2MP + "\n\nAttack:\t\t" + p2Att + "\nStrength: \t" + p2Str + 
                "\nDefense:\t" + p2Def + "\nStamina:  \t" + p2Sta + "\nSpeed:\t\t"
                + p2Spd + "\nEvade:\t\t" + p2Eva + "\nDexterity:\t" + p2Dex + 
                "\nMystic:\t\t" + p2Mys + "\nWillpower: \t" + p2Wil + 
                "\nLuck:\t\t" + p2Lck + "\nCharm:\t\t" + p2Chm + "\nIntellect:\t"
                + p2Int + "\n\nExperience:  \t" + p2Exp + "/" + p2Exp + "\n\n" 
                + p2Bio);
        p2Info.setText(p2Race + " - " + p2Class + " - " + "Age " + p2Age);
        new ToonImage().setImage(p2Toon,p2Image);
        lockSelect(p2Select);

    }
    
    private void fillSelect(JComboBox<String> player, List<String> list, 
            DefaultComboBoxModel dml) {
        DefaultListCellRenderer lrCenter;
        lrCenter = new DefaultListCellRenderer();
        lrCenter.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        for(int i = 0; i < list.size(); i++) {
            dml.addElement((list.get(i)));
        }
        player.setModel(dml);
        player.setRenderer(lrCenter);
    }

    
    private void lockSelect(JComboBox<String> dropdown) {
        dropdown.setEditable(false);
        dropdown.setEnabled(false);
        dropdown.setUI(new BasicComboBoxUI() { 
        protected JButton createArrowButton() {
            return new JButton() {
                public int getWidth() {
                    return 0;
                    }
                @Override
                public synchronized void addMouseListener(MouseListener l) {
                }
            };
        }
        });
    }
    
    private String removeSpace(String s) {
        char c = s.charAt(0);
        if(c == ' ') {
            s = s.substring(1);
        }
        return s;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane battlePane;
    private javax.swing.JTextArea battleText;
    private javax.swing.JLabel p1Info;
    private javax.swing.JScrollPane p1Pane;
    private javax.swing.JComboBox<String> p1Select;
    private javax.swing.JTextArea p1Text;
    private javax.swing.JLabel p1Toon;
    private javax.swing.JLabel p2Info;
    private javax.swing.JScrollPane p2Pane;
    private javax.swing.JComboBox<String> p2Select;
    private javax.swing.JTextArea p2Text;
    private javax.swing.JLabel p2Toon;
    // End of variables declaration//GEN-END:variables

}
