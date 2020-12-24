package clarktribegames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author admingec
 */
public class OptionsMenu {
    
    public static void OptionsMenu() throws IOException, InterruptedException, 
        Exception{
        String title = "Limitless Options";
        String message = "Limitless Options\n\n";
        JButton manageavatars = new JButton("Manage Avatar Library");
        manageavatars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> ca = new JComboBox();
                DefaultComboBoxModel cava = new DefaultComboBoxModel();
                try {
                    List<String> calist = (Converters.foldertoList(MainControls.
                    imageDir, "png")).stream().map(Object::toString).
                    collect(Collectors.toList());
                    if(calist.size() > 0) {
                        ca.setEnabled(true);
                        for(int i = 0; i < calist.size(); i++) {
                            String x = (calist.get(i));
                            String y = Converters.capFirstLetter(x.substring(x.
                                indexOf("\\") + 1,x.indexOf(".",x.indexOf("png")-2)));
                            cava.addElement(y);
                        }
                    } else {
                        cava.addElement("<No Custom Avatars Available>");
                        ca.setEnabled(false);
                    }
                } catch (IOException ex) {
                    try {
                        logFile("severe","defDB Enabled Error.\nEx: " + ex.
                            toString());
                    } catch (IOException ex1) {
                        //
                    }
            }
                ca.setModel(cava);
                JButton importa = new JButton("Import Avatars");
                importa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ChecksBalances.importtoCustom("avatar");
                        try {
                                ca.removeAllItems();
                                List<String> calist = (Converters.foldertoList(
                                    MainControls.imageDir, "png")).stream
                                    ().map(Object::toString).collect(Collectors.
                                    toList());
                                if(calist.size() > 0) {
                                    ca.setEnabled(true);
                                    for(int i = 0; i < calist.size(); i++) {
                                        String x = (calist.get(i));
                                        String y = Converters.capFirstLetter(x.
                                            substring(x.indexOf("\\") + 1,x.indexOf(".",x.
                                                indexOf("png")-2)));
                                        cava.addElement(y);
                                    }
                                } else {
                                    cava.addElement("<No Avatars Available>");
                                    ca.setEnabled(false);
                                }
                            } catch (IOException ex) {
                            }
                    }
                });
                JButton deletea = new JButton("Delete Avatars");
                deletea.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selected=ca.getSelectedItem().toString()+".png";
                        if(selected.equals("_empty_.png")) {
                            Popups.warnPopup("Cannot delete default avatar",
                                "You cannot delete default avatar!");
                        } else {
                        String title=("Are you sure you want to delete " +
                            selected + "?");
                        String message="Are you sure you want to delete\n the "+
                            "avatar file\n"+ selected + "?";
                        boolean deleteChoice = Popups.yesnoPopup(title,message);
                        if(deleteChoice) {
                            try {
                                ChecksBalances.ifexistDelete(MainControls.
                                        imageDir + "/" + selected);
                                Popups.plainPopup("Delete Successful", selected 
                                    + " was deleted successfully.");
                                ca.removeAllItems();
                                List<String> calist = (Converters.foldertoList(
                                    MainControls.imageDir, "png")).stream
                                    ().map(Object::toString).collect(Collectors.
                                    toList());
                                if(calist.size() > 0) {
                                    ca.setEnabled(true);
                                    for(int i = 0; i < calist.size(); i++) {
                                        String x = (calist.get(i));
                                        String y = Converters.capFirstLetter(x.
                                            substring(x.indexOf("\\") + 1,x.indexOf(".",x.
                                                indexOf("png")-2)));
                                        cava.addElement(y);
                                    }
                                } else {
                                    cava.addElement("<No Avatars Available>");
                                    ca.setEnabled(false);
                                }
                            } catch (IOException | InterruptedException ex) {
                                Popups.warnPopup("Error", "There was an error "
                                    + "trying to delete the file.");
                            }
                            
                        }
                    }
                    }
                });
                Object[] popup={"Limitless Avatar Library","\nAvatar"
                    + "Library",ca,importa,deletea,"\n"};
                Popups.checkboxPopup("Box", null, popup);
            }
        });
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
        JButton managecustomlib = new JButton("Manage Custom Library");
        managecustomlib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cm = new JComboBox();
                JComboBox<String> cs = new JComboBox();
                DefaultComboBoxModel cmusic = new DefaultComboBoxModel();
                DefaultComboBoxModel csound = new DefaultComboBoxModel();
                try {
                    List<String> cmlist = (Converters.foldertoList(MainControls.
                    custommusicPath, "mp3")).stream().map(Object::toString).
                    collect(Collectors.toList());
                    if(cmlist.size() > 0) {
                        cm.setEnabled(true);
                        for(int i = 0; i < cmlist.size(); i++) {
                            String x = (cmlist.get(i));
                            String y = Converters.capFirstLetter(x.substring(x.
                                indexOf("\\") + (MainControls.custommusicPath.
                                length()-5),x.indexOf(".",x.indexOf("mp3")-2)));
                            cmusic.addElement("[Music] " + y);
                        }
                    } else {
                        cmusic.addElement("<No Custom Music Available>");
                        cm.setEnabled(false);
                    }
                    List<String> cslist = (Converters.foldertoList(MainControls.
                        custommusicSounds,"mp3")).stream().map(Object::toString)
                        .collect(Collectors.toList());
                    if(cslist.size() > 0) {
                        cs.setEnabled(true);
                        for(int i = 0; i < cslist.size(); i++) {
                            String x = (cslist.get(i));
                            String y = Converters.capFirstLetter(x.substring(x.
                                indexOf("\\") + (MainControls.custommusicSounds.
                                length()-5),x.indexOf(".",x.indexOf("mp3")-2)));
                            csound.addElement("[Sounds] " + y);
                        }
                    } else {
                        csound.addElement("<No Custom Sounds Available>");
                        cs.setEnabled(false);
                    }
                } catch (IOException ex) {
                    try {
                        logFile("severe","defDB Enabled Error.\nEx: " + ex.
                            toString());
                    } catch (IOException ex1) {
                        //
                    }
            }
                cm.setModel(cmusic);
                cs.setModel(csound);
                JButton importm = new JButton("Import Custom Music");
                importm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ChecksBalances.importtoCustom("music");
                        try {
                                cm.removeAllItems();
                                List<String> cmlist = (Converters.foldertoList(
                                    MainControls.custommusicPath, "mp3")).stream
                                    ().map(Object::toString).collect(Collectors.
                                    toList());
                                if(cmlist.size() > 0) {
                                    cm.setEnabled(true);
                                    for(int i = 0; i < cmlist.size(); i++) {
                                        String x = (cmlist.get(i));
                                        String y = Converters.capFirstLetter(x.
                                            substring(x.indexOf("\\") + (
                                                MainControls.custommusicPath.
                                                length()-5),x.indexOf(".",x.
                                                indexOf("mp3")-2)));
                                        cmusic.addElement("[Music] " + y);
                                    }
                                } else {
                                    cmusic.addElement("<No Custom Music "
                                        + "Available>");
                                    cm.setEnabled(false);
                                }
                            } catch (IOException ex) {
                            }
                    }
                });
                JButton deletem = new JButton("Delete Custom Music");
                deletem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selected = cm.getSelectedItem().toString().
                            replaceAll("\\[Music\\] ", "") + ".mp3";
                        String title=("Are you sure you want to delete " +
                            selected + "?");
                        String message="Are you sure you want to delete\n the "+
                            "custom music file\n"+ selected + "?";
                        boolean deleteChoice = Popups.yesnoPopup(title,message);
                        if(deleteChoice) {
                            try {
                                ChecksBalances.ifexistDelete(MainControls.
                                        custommusicPath + "/" + selected);
                                Popups.plainPopup("Delete Successful", selected 
                                    + " was deleted successfully.");
                                cm.removeAllItems();
                                List<String> cmlist = (Converters.foldertoList(
                                    MainControls.custommusicPath, "mp3")).stream
                                    ().map(Object::toString).collect(Collectors.
                                    toList());
                                if(cmlist.size() > 0) {
                                    cm.setEnabled(true);
                                    for(int i = 0; i < cmlist.size(); i++) {
                                        String x = (cmlist.get(i));
                                        String y = Converters.capFirstLetter(x.
                                            substring(x.indexOf("\\") + (
                                                MainControls.custommusicPath.
                                                length()-5),x.indexOf(".",x.
                                                indexOf("mp3")-2)));
                                        cmusic.addElement("[Music] " + y);
                                    }
                                } else {
                                    cmusic.addElement("<No Custom Music "
                                        + "Available>");
                                    cm.setEnabled(false);
                                }
                            } catch (IOException | InterruptedException ex) {
                                Popups.warnPopup("Error", "There was an error "
                                    + "trying to delete the file.");
                            }
                            
                        }
                    }
                });
                JButton imports = new JButton("Import Custom Sounds");
                imports.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ChecksBalances.importtoCustom("sound");
                        try {

                            cs.removeAllItems();
                            List<String> cslist = (Converters.foldertoList(
                                MainControls.custommusicSounds, "mp3")).stream
                                ().map(Object::toString).collect(Collectors.
                                toList());
                            if(cslist.size() > 0) {
                                cs.setEnabled(true);
                                for(int i = 0; i < cslist.size(); i++) {
                                    String x = (cslist.get(i));
                                    String y = Converters.capFirstLetter(x.
                                        substring(x.indexOf("\\") + (
                                            MainControls.custommusicSounds.
                                            length()-5),x.indexOf(".",x.
                                            indexOf("mp3")-2)));
                                    csound.addElement("[Sounds] " + y);
                                }
                            } else {
                                csound.addElement("<No Custom Sounds "
                                    + "Available>");
                                cs.setEnabled(false);
                            }
                        } catch (IOException ex) {
                        }
                    }
                });
                JButton deletes = new JButton("Delete Custom Sounds");
                deletes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selected = cs.getSelectedItem().toString().
                            replaceAll("\\[Sounds\\] ", "") + ".mp3";
                        String title=("Are you sure you want to delete " +
                            selected + "?");
                        String message="Are you sure you want to delete\n the "+
                            "custom sound file\n"+ selected + "?";
                        boolean deleteChoice = Popups.yesnoPopup(title,message);
                        if(deleteChoice) {
                            try {
                                ChecksBalances.ifexistDelete(MainControls.
                                    custommusicSounds + "/" + selected);
                                Popups.plainPopup("Delete Successful", selected 
                                    + " was deleted successfully.");
                                cs.removeAllItems();
                                List<String> cslist = (Converters.foldertoList(
                                    MainControls.custommusicSounds, "mp3"))
                                    .stream().map(Object::toString).collect(
                                    Collectors.toList());
                                if(cslist.size() > 0) {
                                    cs.setEnabled(true);
                                    for(int i = 0; i < cslist.size(); i++) {
                                        String x = (cslist.get(i));
                                        String y = Converters.capFirstLetter(x.
                                            substring(x.indexOf("\\") + (
                                                MainControls.custommusicSounds.
                                                length()-5),x.indexOf(".",x.
                                                indexOf("mp3")-2)));
                                        csound.addElement("[Sounds] " + y);
                                    }
                                } else {
                                    csound.addElement("<No Custom Sounds "
                                        + "Available>");
                                    cs.setEnabled(false);
                                }
                            } catch (IOException | InterruptedException ex) {
                                Popups.warnPopup("Error", "There was an error "
                                    + "trying to delete the file.");
                            }
                        }
                    }
                });               
                Object[] popup={"Limitless Custom Library","\nCustom Music "
                    + "Library",cm,importm,deletem,"\n","Custom Sound Library",
                    cs,imports,deletes,"\n"};
                Popups.checkboxPopup("Box", null, popup);
                custommusic.setSelected(false);
                custommusic.setSelected(true);
            }
        });
        JComboBox<String> introlist = new JComboBox();
        JComboBox<String> battlelist = new JComboBox();
        JComboBox<String> winlist = new JComboBox();
        JComboBox<String> loselist = new JComboBox();
        custommusic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if(!(e.getStateChange() == ItemEvent.SELECTED)) {
                managecustomlib.setEnabled(false);
                if(introlist.getItemCount() > 0) {
                    introlist.removeAllItems();
                }
                introlist.addItem("<Default Intro Music>");
                MainControls.musicPath = MainControls.defaultIntro;
                introlist.setEnabled(false);
                if(battlelist.getItemCount() > 0) {
                    battlelist.removeAllItems();
                }
                battlelist.addItem("<Default Battle Music>");
                battlelist.setEnabled(false);
                if(winlist.getItemCount() > 0) {
                    winlist.removeAllItems();
                }
                winlist.addItem("<Default Victory Music>");
                winlist.setEnabled(false);                
                if(loselist.getItemCount() > 0) {
                    loselist.removeAllItems();
                }
                loselist.addItem("<Default Defeat Music>");
                loselist.setEnabled(false);                
            } else {
                try {
                    custommusicEnabled(introlist,battlelist,winlist,loselist);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    MPlayer.stopMedia();
                } catch (Exception ex) {
                    //
                };
                MainControls.custommusicOn = true;
                managecustomlib.setEnabled(true);
                introlist.setEnabled(true);
                battlelist.setEnabled(true);
                winlist.setEnabled(true);
                loselist.setEnabled(true);
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
            managecustomlib.setEnabled(true);
            introlist.setEnabled(true);
            battlelist.setEnabled(true);
            winlist.setEnabled(true);
            loselist.setEnabled(true);
        } else {
            introlist.addItem("<Default Intro Music>");
            introlist.setEnabled(false);
            battlelist.addItem("<Default Battle Music>");
            battlelist.setEnabled(false);
            winlist.addItem("<Default Victory Music>");
            winlist.setEnabled(false);
            loselist.addItem("<Default Defeat Music>");
            loselist.setEnabled(false);
            managecustomlib.setEnabled(false);
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
        Object[] popup={message,manageavatars,music,sound,custommusic,managecustomlib,
            introlist,battlelist,winlist,loselist,samedb,defaultdb,"\n"};
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
                MainControls.custIntro = introlist.getSelectedItem().toString().
                    replaceAll("\\[Intro\\] ", "");
            }
            if(battlelist.getSelectedIndex() == 0) {
                MainControls.custBattle = "";
            } else {
                MainControls.custBattle=battlelist.getSelectedItem().toString().
                    replaceAll("\\[Battle\\] ", "");
            }
            if(winlist.getSelectedIndex() == 0) {
                MainControls.custWin = "";
            } else {
                MainControls.custWin = winlist.getSelectedItem().toString().
                    replaceAll("\\[Victory\\] ", "");
            }
            if(loselist.getSelectedIndex() == 0) {
                MainControls.custLose = "";
            } else {
                MainControls.custLose = loselist.getSelectedItem().toString().
                    replaceAll("\\[Defeat\\] ", "");
            }
            MainControls.musicPath = MainControls.custommusicPath + "/" +
                MainControls.custIntro + ".mp3";
        } else {
            MainControls.custommusicOn = false;
            MainControls.custIntro = "";
            MainControls.custBattle = "";
            MainControls.custWin = "";
            MainControls.custLose = "";
        }
        MainControls.updateSettings();
    }
    
    private static void defaultdbEnabled(JComboBox<String> dropdown)throws 
        IOException{
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
    
    private static void custommusicEnabled(JComboBox<String> introdown,
        JComboBox<String> battledown,JComboBox<String> windown,JComboBox<String>
        losedown)throws IOException{
        if(true) {
            introdown.removeAllItems();
            battledown.removeAllItems();
            windown.removeAllItems();
            losedown.removeAllItems();            
            DefaultComboBoxModel intro = new DefaultComboBoxModel();
            DefaultComboBoxModel battle = new DefaultComboBoxModel();
            DefaultComboBoxModel win = new DefaultComboBoxModel();
            DefaultComboBoxModel lose = new DefaultComboBoxModel();
            try {
                List<String> savelist = (Converters.foldertoList(MainControls.
                    custommusicPath, "mp3")).stream()
                    .map(Object::toString).collect(Collectors.toList());
                intro.addElement("<Default Intro Music>");
                battle.addElement("<Default Battle Music>");
                win.addElement("<Default Victory Music>");
                lose.addElement("<Default Defeat Music>");
                for(int i = 0; i < savelist.size(); i++) {
                    String x = (savelist.get(i));
                    String y = Converters.capFirstLetter(x.substring(x.indexOf
                        ("\\") + (MainControls.custommusicPath.length() - 5), 
                        x.indexOf(".",x.indexOf("mp3") - 2)));
                    intro.addElement("[Intro] " + y);
                    battle.addElement("[Battle] " + y);
                    win.addElement("[Victory] " + y);
                    lose.addElement("[Defeat] " + y);
                    if(y.toLowerCase().equals(MainControls.custIntro.toLowerCase
                    ())) {
                        intro.setSelectedItem("[Intro] " + y);
                    } 
                    if(y.toLowerCase().equals(MainControls.custBattle
                    .toLowerCase())) {
                        battle.setSelectedItem("[Battle] " + y);
                    } 
                    if(y.toLowerCase().equals(MainControls.custWin.toLowerCase()
                    )) {
                        win.setSelectedItem("[Victory] " + y);
                    } 
                    if(y.toLowerCase().equals(MainControls.custLose.toLowerCase(
                    ))) {
                        lose.setSelectedItem("[Defeat] " + y);
                    } 
                }
            introdown.setModel(intro);
            battledown.setModel(battle);
            windown.setModel(win);
            losedown.setModel(lose);
            } catch (IOException ex) {
                logFile("severe","defDB Enabled Error.\nEx: " + ex.toString());
            }
        } else {
            introdown.removeAllItems();
            battledown.removeAllItems();
            windown.removeAllItems();
            losedown.removeAllItems();
            introdown.addItem("<Default Intro Music>");
            battledown.addItem("<Default Battle Music>"); 
            windown.addItem("<Default Intro Music>");
            losedown.addItem("<Default Battle Music>"); 
            MainControls.musicPath = MainControls.defaultIntro;
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
