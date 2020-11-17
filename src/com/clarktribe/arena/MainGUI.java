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

/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * @version alpha 0.0.1
 * 
 */

public class MainGUI extends javax.swing.JFrame {

    public MainGUI() throws InterruptedException, SQLException, IOException, URISyntaxException {
        initComponents();
        new DatabaseCheck().dbCheck();
        setLocationRelativeTo(null);
        welcomePlayer();
        test();
        test2();
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

        p1Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1Info.setText("Race - Class - Age");
        p1Info.setFocusable(false);

        p1Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player 1" }));

        p1Text.setEditable(false);
        p1Text.setColumns(20);
        p1Text.setLineWrap(true);
        p1Text.setRows(5);
        p1Text.setText("_Align_ - _Rep_\n\nStatus:  _\n\nLevel:  _\n\nHP:  _/_\nAP:  _/_\nMP:  _/_\n\nStrength:  _\nDefense:  _\nWisdom:  _\nDarkness: _\nWill:  _\nLuck:  _\nStamina:  _\nSpeed:  _\nDexterity:  _\n\nExperience:  _/_\n\n_BIO_");
        p1Text.setWrapStyleWord(true);
        p1Text.setFocusable(false);
        p1Pane.setViewportView(p1Text);

        battleText.setColumns(20);
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

        p2Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2Info.setText("Race - Class - Age");
        p2Info.setFocusable(false);

        p2Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        p2Text.setEditable(false);
        p2Text.setColumns(20);
        p2Text.setLineWrap(true);
        p2Text.setRows(5);
        p2Text.setText("Level:  _\n\nHP:  _/_\nMP:  _/_\n\nStrength:  _\nDefense:  _\nWisdom:  _\nDarkness: _\nWill:  _\nLuck:  _\nStamina:  _\nSpeed:  _\n\nExperience:  _/_\n\nBio:  _");
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
    
    private void test() throws SQLException {
        //fills Toon boxes
        List<String> toonList = dbQuery("*","dbToons","toonName","","", true);
        DefaultComboBoxModel dml1 = new DefaultComboBoxModel();
        DefaultComboBoxModel dml2 = new DefaultComboBoxModel();
        fillSelect(p1Select,(toonList),dml1);
        fillSelect(p2Select,(toonList),dml2);
        p1Select.setSelectedIndex(0);
        p2Select.setSelectedIndex(1);
    }
    
    private void test2() throws SQLException {
        List<String> toonStats = dbQuery("*","dbToons","toonName","toonName","The Man Of Iron", false);
        System.out.println(toonStats.toString());
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
