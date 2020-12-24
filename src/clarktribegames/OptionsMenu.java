package clarktribegames;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author admingec
 */
public class OptionsMenu {
    
    public static void OptionsMenu() throws IOException, InterruptedException, Exception{
        String title = "Limitless Options";
        String message = "Limitless Options\n\n";
        JCheckBox music = new JCheckBox("Play Music");
        music.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if(!(e.getStateChange() == ItemEvent.SELECTED)) {
                try {
                    MPlayer.stopMedia();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            };
            }
        });
        JCheckBox custommusic = new JCheckBox("Use Custom Music");
        JComboBox<String> introlist = new JComboBox();
        JComboBox<String> battlelist = new JComboBox();
        custommusic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if(!(e.getStateChange() == ItemEvent.SELECTED)) {
                if(introlist.getItemCount() > 0) {
                    introlist.removeAllItems();
                }
                introlist.addItem("<Default Intro Music>");
                MainControls.musicPath = "sounds/intro.mp3";
                introlist.setEnabled(false);
                if(battlelist.getItemCount() > 0) {
                    battlelist.removeAllItems();
                }
                battlelist.addItem("<Default Battle Music>");
                battlelist.setEnabled(false);
            } else {
                try {
                    custommusicEnabled(introlist,battlelist);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    MPlayer.stopMedia();
                } catch (Exception ex) {
                    //
                };
                MainControls.custommusicOn = true;
                introlist.setEnabled(true);
                battlelist.setEnabled(true);
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
        if(MainControls.custommusicOn) {
            custommusic.setSelected(true);
            introlist.setEnabled(true);
            battlelist.setEnabled(true);
        } else {
            introlist.addItem("<Default Intro Music>");
            introlist.setEnabled(false);
            battlelist.addItem("<Default Battle Music>");
            battlelist.setEnabled(false);
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
        Object[] popup = {message, music, sound, custommusic, introlist, battlelist, samedb, defaultdb, "\n"};
        Popups.checkboxPopup(title, message, popup);
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
        if(custommusic.isSelected()) {
            MainControls.custommusicOn = true;
            if(introlist.getSelectedIndex() == 0) {
                MainControls.custIntro = "";
            } else {
                MainControls.custIntro = introlist.getSelectedItem().toString().replaceAll("\\[Intro\\] ", "");
            }
            if(battlelist.getSelectedIndex() == 0) {
                MainControls.custBattle = "";
            } else {
                MainControls.custBattle = battlelist.getSelectedItem().toString().replaceAll("\\[Battle\\] ", "");
            }
            MainControls.musicPath = MainControls.custommusicPath + "/" + MainControls.custIntro + ".mp3";
        } else {
            MainControls.custommusicOn = false;
            MainControls.custIntro = "";
            MainControls.custBattle = "";
        }
        MainControls.updateSettings();
    }
    
    private static void defaultdbEnabled(JComboBox<String> dropdown)throws IOException{
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
                if(!y.contains("\\")) {
                    dbdml.addElement(y);
                }
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
    
    private static void custommusicEnabled(JComboBox<String> introdown,JComboBox<String> battledown)throws IOException{
        if(true) {
            introdown.removeAllItems();
            battledown.removeAllItems();
            DefaultComboBoxModel intro = new DefaultComboBoxModel();
            DefaultComboBoxModel battle = new DefaultComboBoxModel();
            try {
                List<String> savelist = (Converters.foldertoList(MainControls.
                    custommusicPath, "mp3")).stream()
                    .map(Object::toString).collect(Collectors.toList());
                intro.addElement("<Default Intro Music>");
                battle.addElement("<Default Battle Music>");
                for(int i = 0; i < savelist.size(); i++) {
                    String x = (savelist.get(i));
                    String y = Converters.capFirstLetter(x.substring(x.indexOf
                        ("\\") + (MainControls.custommusicPath.length() - 5), x.indexOf(".",x.indexOf("mp3"
                        ) - 2)));
                    intro.addElement("[Intro] " + y);
                    battle.addElement("[Battle] " + y);
                    if(y.toLowerCase().equals(MainControls.custIntro.toLowerCase())) {
                        intro.setSelectedItem("[Intro] " + y);
                    } 
                    if(y.toLowerCase().equals(MainControls.custBattle.toLowerCase())) {
                        battle.setSelectedItem("[Battle] " + y);
                    } 
                }
            introdown.setModel(intro);
            battledown.setModel(battle);
            } catch (IOException ex) {
                logFile("severe","defDB Enabled Error.\nEx: " + ex.toString());
            }
        } else {
            introdown.removeAllItems();
            battledown.removeAllItems();
            introdown.addItem("<Default Intro Music>");
            battledown.addItem("<Default Battle Music>"); 
            MainControls.musicPath = "sounds/intro.mp3";
        }
    }
    
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
}
