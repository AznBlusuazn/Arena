package clarktribegames;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class MainControls {
    
    
    //Main Controls Variables
    static String appName = "Limitless";
    static String appVer = "0.0.030";
    static String appTitle = appName + " [ALPHA v" + appVer + "]";
    static String settingsFile = "settings.ini";
    static String defaultIntro = "sounds/intro.mp3";
    static String defaultBattle = "sounds/battle.mp3";
    static String defaultWin = "sounds/victory.mp3";
    static String defaultLose = "sounds/loss.mp3";
    static String musicPath = defaultIntro;
    static String custommusicPath = "custom/music";
    static String custIntro = "";
    static String custBattle = "";
    static String custWin = "";
    static String custLose = "";
    static String custommusicSounds = "custom/sounds";
    static String defaultOGSave = "data.mdb";
    static String saveExt = "limit";
    static String defaultSave = "default" + "." + saveExt;
    static String defaultsavesDir = "saves/";
    static String savesDir = defaultsavesDir;
    static String imageDir = "avatars/";
    static String tempDir = "temp/";
    static String lastusedSave = savesDir + ".lastused";
    static String selectedSave = defaultSave;
    static boolean currentlyTyping = false;
    public URL iconURL = getClass().getResource("/clarktribegames/icon.png");
    public ImageIcon imageIcon = new ImageIcon(iconURL);
    static String currentgamePath = "";
    static String currentgame = "";
    static String selectedToon = "";
    static String price = "";
    static String dagger = "";
    static boolean musicPlaying = false;
    static Thread currentSong;
    static String threadName = "";
    static String[][] newgametoonList;
    //Color Mode
    static Color backColor = Color.BLACK;
    static Color textColor = Color.WHITE;
    
    //Settings.ini
    static boolean darkOn = true;
    static boolean musicOn = true;
    static boolean custommusicOn = false;
    static boolean soundOn = true;
    static boolean samedbOn = true;
    static String defaultDB = defaultSave.substring(0,defaultSave.indexOf("." + 
        saveExt));
    static boolean created = false;

    public static void main(String[] args) throws Exception {
        lookandfeelSettings();
        startupChecks();
        Limitless.main(args);

    }
    
    private static void startupChecks() throws IOException, Exception {
        try {
            checkVersion(appName,appVer);
            firstCheck();
            checkSaves();
            checkSettings();
        } catch(IOException ex) {
            LogWriter.logFile("severe",("Startup Check IOException: " + ex.toString()));
        }
    }
    
    private static void firstCheck() throws IOException, InterruptedException, 
        Exception {
        try {
            clearTemp();
            ChecksBalances.newdirCheck(tempDir, true);
            ChecksBalances.newdirCheck(imageDir, false);
            ChecksBalances.newdirCheck(custommusicPath, false);
            ChecksBalances.newdirCheck(custommusicSounds, false);
            ChecksBalances.fileCheck("_empty_.png",(imageDir + "_empty_.png"),
                true,false);
            boolean libResult = (CmpImporter.cmpImport("lib"));
            boolean soundsResult = (CmpImporter.cmpImport("sounds"));
            ChecksBalances.newfileCheck(settingsFile,false,defaultSettings(),
                true);
            if(!libResult || !soundsResult) {
                String[] opts = new String[] {"Patreon","PayPal","Maybe Later"};
                String title = "Alert!";
                String message = "Welcome to Limitless!\n\nThis title is still "
                    + "in development.  Please be patient.\n\nYou can become a "
                    + "Patreon or Donate if you want to \nhelp support the caus"
                    + "e.\n\nThanks! ~ Geoff @ ClarkTribeGames";
                int choice = Popups.optPopup(opts, title, message);
                switch(choice) {
                    case 0:
                        GoToWeb.openWeb("https://www.patreon.com/clarktribegame"
                            + "s");
                        break;
                    case 1:
                        GoToWeb.openWeb("https://www.paypal.me/aznblusuazn");
                        break;
                    default:
                        break;
                }
            }
            dagger = Converters.resourcefileToList("all.cmp").get(0);
            price = Converters.resourcefileToList("magic.cmp").get(0);
            
        } catch(IOException ex) {
            LogWriter.logFile("severe","Donate Popup Error.  Exception: " + ex);
        }
    }
    
    public static void clearTemp() throws IOException, InterruptedException {
        System.gc();
        ChecksBalances.ifexistDelete(tempDir);
    }
    
    public static void turnonMusic(String trackPath, String trackType) {
        musicPath = trackPath;
        if(!(new File(musicPath).exists())) {
            musicPath = defaultMusic(trackType);
        }
        SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                MPlayer.mediaPlayer(musicOn);
                return null;
            }
        };
        if(!musicPlaying) {
        musicPlaying = true;
        worker.execute();
        }
    }
    
    public static String checkforcustMusic(String type) {
        switch(type) {
            case "battle" :
                if(!custommusicOn) {
                    return defaultBattle;
                } else {
                    if(custBattle.equals("")) { 
                        return defaultBattle;
                    } else {
                        return custommusicPath + "/" + custBattle + ".mp3";
                    }
            }
            case "intro" :
                if(!custommusicOn) {
                    return defaultIntro;
                } else {
                    return custommusicPath + "/" + custIntro + ".mp3";
                }
            case "win" :
                if(!custommusicOn) {
                    return defaultWin;
                } else {
                    if(custWin.equals("")) {
                        return defaultWin;
                    } else {
                        return custommusicPath + "/" + custWin + ".mp3";
                    }
                }
                
            case "lose" :
                if(!custommusicOn) {
                    return defaultLose;
                } else {
                    if(custLose.equals("")) {
                        return defaultLose;
                    } else {
                        return custommusicPath + "/" + custLose + ".mp3";
                    }
                }                
            default :
                return defaultIntro;
        }
    }
    
    private static String defaultMusic(String type) {
        switch(type) {
            case "battle" :
                return defaultBattle;
            case "intro" :
                return defaultIntro;
            default :
                return defaultIntro;
        }
    }
    
    private static void checkSaves() throws IOException, Exception {
        try {
            ChecksBalances.newdirCheck("./" + savesDir, false);
            String ogPath = defaultOGSave;
            String dbPath = savesDir + defaultSave;
            ChecksBalances.fileCheck(ogPath,dbPath,true,true);
            ChecksBalances.newfileCheck(lastusedSave, true,"default,0",false);
        } catch(Exception ex) {
            LogWriter.logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private static String defaultSettings() {
        return "<Limitless Game Options>\nDark=ON\nMusic=ON\nCustM=OFF\nCustI=\nCustB=\n"
            +"CustW=\nCustL=\nSound=ON\nSameDB=YES\nDefaultDB=Default\n\n";
    }
    
    private static void checkSettings() throws IOException {
        if(getSettings("Dark").equals("off")) {
            darkOn = false;
            backColor = Color.WHITE;
            textColor = Color.BLACK;
        }
        if(getSettings("Music").equals("off")) {
            musicOn = false;
        }
        custIntro = getSettings("CustI");
        custBattle = getSettings("CustB");
        custWin = getSettings("CustW");
        custLose = getSettings("CustL");
        if(getSettings("CustM").equals("on")) {
            custommusicOn = true;
            musicPath = custommusicPath + "/" + custIntro.replaceAll("[Intro] ", "") + ".mp3";
            if(custIntro.equals("") || custIntro.isEmpty()) {
                musicPath = defaultIntro;
            }
        }
        if(getSettings("Sound").equals("off")) {
            soundOn = false;
        }
        if(getSettings("SameDB").equals("no")) {
            samedbOn = false;
        }
        defaultDB = getSettings("DefaultDB");
    }
    
    private static String getSettings(String type) throws IOException {
        List<String> settings = Converters.filelistToList(settingsFile, "\n");
        List<String> listresult=(ChecksBalances.lineFinder(settings,type,true));
        String rawresult = Converters.listtoString(listresult);
        String result = rawresult.substring(rawresult.indexOf("=") +1 ,rawresult
            .length());
        return result;
    }
    
    public static void updateSettings() throws IOException,InterruptedException, Exception{
        String newSettings = Converters.listtoString(rebuildSettings());
        try {
            if(!musicOn) {
                MPlayer.stopMedia();
            }
            System.gc();
            ChecksBalances.ifexistDelete(settingsFile);
            System.gc();
            ChecksBalances.newfileCheck(settingsFile, false, newSettings, true);
        } catch (IOException ex) {
            LogWriter.logFile("severe","Update Settings.  EX: " + ex.toString());
        }
    }
    
    private static List<String> rebuildSettings() throws IOException {
        String dark = "Dark=ON";
        String music = "Music=ON";
        String custmusic = "CustM=OFF";
        String custintro = "CustI=" + custIntro;
        String custbattle = "CustB=" + custBattle;
        String custwin = "CustW=" + custWin;
        String custlose = "CustL=" + custLose;
        String sound = "Sound=ON";
        String samedb = "SameDB=YES";
        String defaultdb = "DefaultDB=" + defaultDB;
        if(!darkOn) {
            dark = "Dark=OFF";
        }
        if(!musicOn) {
            music = "Music=OFF";
        }
        if(custommusicOn) {
            custmusic = "CustM=ON";
        }
        if(!soundOn) {
            sound = "Sound=OFF";
        }
        if(!samedbOn) {
            samedb = "SameDB=NO";
        }
        if(defaultDB.equals(defaultSave.substring(0,defaultSave.indexOf("." + 
        saveExt)))) {
            defaultdb = "DefaultDB=Default";
        } else {
            if(!(ChecksBalances.searchdirList(defaultDB,savesDir,saveExt))) {
                defaultdb = "DefaultDB=Default";
            }
        }
        List<String> x1=Converters.filelistToList(settingsFile,"\n");
        List<String> x2=(ChecksBalances.findandRebuild(x1,"Dark",dark));
        List<String> x3=(ChecksBalances.findandRebuild(x2,"Music",music));
        List<String> x4=(ChecksBalances.findandRebuild(x3,"CustM",custmusic));
        List<String> x5=(ChecksBalances.findandRebuild(x4,"CustI",custintro));
        List<String> x6=(ChecksBalances.findandRebuild(x5,"CustB",custbattle));
        List<String> x7=(ChecksBalances.findandRebuild(x6,"CustW",custwin));
        List<String> x8=(ChecksBalances.findandRebuild(x7,"CustL",custlose));
        List<String> x9=(ChecksBalances.findandRebuild(x8,"Sound",sound));
        List<String> x10=(ChecksBalances.findandRebuild(x9,"SameDB",samedb));
        List<String> finalList=(ChecksBalances.findandRebuild(x10,"DefaultDB",
            defaultdb));
        return finalList;
    }
    
    private static void lookandfeelSettings () {
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
            ex.printStackTrace();
        }
    }
    
    public static void startNewGame() {
       try {
            if(!samedbOn) {
                limitSelect();
            } else {
                selectedSave = defaultDB + "." + 
                    saveExt;
            }
            boolean continueon = false;
            currentgamePath=currentgamePath=Limitless.ngText.getText().toLowerCase();
            if(currentgamePath.isEmpty()) {
                currentgamePath = "";
                Limitless.showMenu();
            }
            continueon = ChecksBalances.newGame(currentgamePath);
            if(continueon) {
                loadingScreen();
            }
            if(continueon) {
                //method to change screen here
                //newButton.setText("Building Save Game");
//                currentgame=currentgamePath.substring(
//                    currentgamePath.indexOf("/",0),MainControls
//                    .currentgamePath.indexOf("/",currentgamePath
//                    .indexOf("/") + 1)).replaceAll("/","");
                Popups.infoPopup("Building Save Game","Your new game world will"
                    + " now be built.  Please be patient.");
//                savesDir="saves/" + currentgame + "/";
//                GetData.createnewSave(Converters.capFirstLetter((MainControls
//                    .selectedSave).substring(0,(selectedSave)
//                    .indexOf("." + saveExt))), MainControls
//                    .currentgame);

                backgroundBuild();
                while(!MainControls.created) {
                    Thread.sleep(1);
                }
                Limitless.setLoadingAvatars();
                Limitless.loadingLabel.setText("Game World Has Been Built!");
                Popups.infoPopup("Save Game Built","Your new game world has bee"
                    + "n built.  Thank you for your patience.");
                Thread.sleep(1500);
                Limitless.showNewGameList();
                newgamelistMenu();
                //new NewGameGUI().setVisible(true);
            } else {
                currentgamePath = "";
                //Limitless.showMenu();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void loadingScreen() {
        SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Limitless.menuPanel.setVisible(false);
                Limitless.loadingPanel.setVisible(true);
                Limitless.setLoadingAvatars();
                Limitless.loadingLabel.setText("Game World Is Building...");
                return null;
            }
        };
        worker.execute();
    }
    
    private static void backgroundBuild() {
        SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                currentgame=currentgamePath.substring(currentgamePath.indexOf(
                    "/",0),MainControls.currentgamePath.indexOf("/",
                    currentgamePath.indexOf("/") + 1)).replaceAll("/","");
//                Popups.infoPopup("Building Save Game","Your new game world will"
//                    + " now be built.  Please be patient.");
                savesDir="saves/" + currentgame + "/";
                GetData.createnewSave(Converters.capFirstLetter((MainControls
                    .selectedSave).substring(0,(selectedSave).indexOf("."+
                    saveExt))),MainControls.currentgame);
                return null;
            }
            
        };
        worker.execute();
    }

    public static void newgamelistMenu() throws IOException, SQLException {
        popNewGameToonList();
        worldtextInfo();
    }
    
    private static void popNewGameToonList() throws IOException, SQLException {
        
        List<String> newgameToonList = GetData.getNewGameToonList();
        DefaultListModel newtlDml = new DefaultListModel();
        if(newgameToonList.size() <= 0) {
            Limitless.newgameList.setEnabled(false);
            newtlDml.removeAllElements();
            newtlDml.addElement("<No Toons Available>");
//            Limitless.lgyesButton.setEnabled(false);
//            Limitless.lgdelButton.setEnabled(false);
        } else {
            newgametoonList = new String[newgameToonList.size()][2];
            for(int i=0;i < newgameToonList.size();i++) {
                newgametoonList[i][0] = newgameToonList.get(i);
                newgametoonList[i][1] = String.valueOf(i);
            }
            Arrays.sort(newgametoonList, new Comparator<String[]>() {
                @Override
                public int compare(final String[] entry1, final String[] entry2) {
                    final String toon1 = entry1[0];
                    final String toon2 = entry2[0];
                    return toon1.compareTo(toon2);
                }
            });
            for (final String[] s : newgametoonList) {
                newtlDml.addElement(s[0]);
            }
            
            Limitless.newgameList.setModel(newtlDml);
//            Limitless.lgyesButton.setEnabled(true);
//            Limitless.lgdelButton.setEnabled(true);
//            newtlDml.removeAllElements();
//            SortedListModel sortedtoonlist = new SortedListModel();
//            Limitless.newgameList.setModel(sortedtoonlist);
//            for(int i=0; i < newgameToonList.size(); i++) {
            Limitless.newgameList.setEnabled(true);
//                sortedtoonlist.add(newgameToonList.get(i));
//            }
            
            
        }
        
        //Limitless.newgameList.setModel(newtlDml);
    }    
    
    private static void worldtextInfo() throws SQLException {
                //add game date method here
        String week = "1";
        String month = "1";
        String day = "1";
        String year = "1";
        //above it temp date
        String save=MainControls.savesDir.replaceAll("saves/","").replaceAll("/", "");
        String savetoons = "sav" + save + "Toons";
        int count = ((GetData.dataQuery("*", savetoons, "toonName", null, true, false, null, null))).size();
        List<Integer> exps = new ArrayList<>();
        for(String exp : ((GetData.dataQuery("*", savetoons, "toonExp", null, true, false, null, null)))) exps.add(Integer.valueOf(exp));
        int toplv = Integer.MIN_VALUE;
        int topidx = -1;

        for (int l = 0; l < exps.size(); l++) {
            int val = exps.get(l);
            if (val > toplv) {
                toplv = val;
                topidx = l;
            }
        }

        List<String> toptoon = GetData.dataQuery("*", savetoons, "toonID",
            String.valueOf(topidx), false, false, null, null);
        String topplayer = toptoon.get(1);

        String alignment=((GetData.dataQuery("*", "dbAlign", "alignID",
            Calculator.getAlign(Integer.parseInt(toptoon.get(4))), false, false,
            null, null)).get(6));
        String age = (Calculator.getAge(Integer.parseInt(toptoon.get(7)), 
            toptoon.get(2)));
        String gender = ((GetData.dataQuery("*","dbGender","genderID",toptoon
            .get(6),false, false, null, null)).get(1));
        String race = (GetData.dataQuery("*","dbRace","raceID",toptoon.get(2)
            ,false, false, null, null)).get(7);
        String clas = ((GetData.dataQuery( "*", "dbClass", "classID",toptoon.
            get(3), false, false, null, null)).get(4));
        String size = Calculator.getSize((GetData.dataQuery("*", "dbRace",
            "raceID",toptoon.get(2),false, false, null, null)).get(1), age);
        
        String text = "This world start at Week " + week + ", Month " + month 
            + ", Day " + day + ", Year " + year + ".\n\nCurrently, there are " 
            + count + " characters in the world.\n\nThe highest level character"
            + " is " + topplayer + ", who is a " + alignment + " " + age + " " 
            + gender + " that is " + size + " " + race + " " + clas + " at Leve"
            + "l " + Calculator.getLevel("curlv", String.valueOf(toplv)) + ".\n"
            + "\nYour possiblities are Limitless!\n\nSelect your character and "
            + "then click Start New Game to begin your journey.";
        new TypeEffect(Limitless.welcomeText,text,10,false,null,null).start();
    }
    
    public static void ngToonSelect(String selectedToonID) throws SQLException {
        String savetoons = "sav" + MainControls.savesDir.replaceAll("saves/","")
            .replaceAll("/", "") + "Toons";
        List<String> selectedToon = GetData.dataQuery("*", savetoons, "toonID",
            selectedToonID, false, false, null, null);
        Limitless.charName.setText(selectedToon.get(1));
        Avatars.setAvatar(Limitless.charToon, selectedToon.get(1), "");
    }
    
    private static void limitSelect() throws IOException {
        String title = "New Game Database Selection";
        String message = "Select a Database for the New Game:\n\n";
        DefaultComboBoxModel limitdml = new DefaultComboBoxModel();
        JComboBox dboptions = new JComboBox();
        popLimit(dboptions,limitdml);
        if(dboptions.getItemCount() > 1) {
            String selection=Popups.comboboxPopup(title, message, dboptions,null
                );
            if(ChecksBalances.isNullOrEmpty(selection)) {
                //
            } else {
                selectedSave = (selection.toLowerCase() + "." + 
                    saveExt);
                String confirmMessage = selection + " Loaded";
                Popups.infoPopup(confirmMessage,confirmMessage + "!");
            }
        } else {
            selectedSave = (defaultSave);
        }
    }
    
    private static void popLimit(JComboBox box, DefaultComboBoxModel dml) throws 
        IOException {
        try {
            List<String> savelist = (Converters.foldertoList(MainControls
                .savesDir, saveExt)).stream().map(Object::toString)
                .collect(Collectors.toList());
            fillLimit(box,savelist,dml);
        } catch (IOException ex) {
            LogWriter.logFile("severe","Save Select Error.\nEx: " + ex.toString());
        }
    }
    
    private static void fillLimit(JComboBox<String> save, List<String> list, 
            DefaultComboBoxModel dml) {
        Font font = save.getFont();
        DefaultListCellRenderer lrCenter;
        lrCenter = new DefaultListCellRenderer();
        lrCenter.setHorizontalAlignment(DefaultListCellRenderer.LEFT);
        lrCenter.setFont(font.deriveFont(Font.BOLD));
        for(int i = 0; i < list.size(); i++) {
            String x = (list.get(i));
            String y = Converters.capFirstLetter(x.substring(x.indexOf("\\") + 1
                , x.indexOf(".",x.indexOf(saveExt) - 2)));
            dml.addElement(y);
        }
        save.setModel(dml);
        save.setRenderer(lrCenter);
    }
    
    public static void saveGameMenu() {
        popSaveGameList();
    }
    
    private static void popSaveGameList() {
        List<String> savegameList = ChecksBalances.getSavedGames();
        DefaultListModel lgDml = new DefaultListModel();
        if(savegameList.size() <= 0) {
            Limitless.lgList.setEnabled(false);
            lgDml.removeAllElements();
            lgDml.addElement("<No Saved Games>");
            Limitless.lgyesButton.setEnabled(false);
            Limitless.lgdelButton.setEnabled(false);
        } else {
            Limitless.lgyesButton.setEnabled(true);
            Limitless.lgdelButton.setEnabled(true);
            lgDml.removeAllElements();
            for(int i=0; i < savegameList.size(); i++) {
                Limitless.lgList.setEnabled(true);
                lgDml.addElement(savegameList.get(i));
            }
        }
        Limitless.lgList.setModel(lgDml);
    }
    
    public static void loadSavedGame() {
        try {
            savesDir=defaultsavesDir + Limitless.lgList.getSelectedValue() +"/";
            selectedSave=ChecksBalances.getLast(new File(savesDir+".lastused"));
            selectedToon=Converters.getfromFile(savesDir + ".lastused",true,
                false);
            StartGame.startGame(selectedSave,"sav"+Limitless.lgList
                .getSelectedValue()+"Toons","sav"+Limitless.lgList
                .getSelectedValue()+"Max");
        } catch (IOException | InterruptedException | SQLException ex) {
            //
        }
    }
    
    public static void delSavedGame() {
        String title=("Are you sure you want to delete " + Limitless.lgList
            .getSelectedValue());
        String message="Are you sure you want to delete\n the save game "+
            Limitless.lgList.getSelectedValue() + "?";
        boolean deleteChoice = Popups.yesnoPopup(title,message);
        if(deleteChoice == true) {
            try {
                ChecksBalances.iffolderexistsDelete(defaultsavesDir+Limitless.
                    lgList.getSelectedValue());
            } catch (IOException ex) {
                //
            }
        savesDir = defaultsavesDir;
        }
    }
    
    public static void loadSavedGameold() {
        try {
            if(ChecksBalances.checknoofSubdirs(savesDir)) {
            List<String> loadlist = Converters.capStringList(Converters
                .subfolderstoList(savesDir));
            JComboBox<String> loadOptions = new JComboBox<>();
            loadOptions.setModel(new DefaultComboBoxModel<>(loadlist.toArray(new
                String[0])));
            String[] popupchoices = new String[3];
            popupchoices[0] = "OK";
            popupchoices[1] = "Cancel";
            popupchoices[2] = "Delete";
            String loadChoice=(Popups.comboboxPopup("Load a Saved Game", "Select"
                + " the Saved Game to Load:", loadOptions, popupchoices)).
                toLowerCase();
            if(ChecksBalances.isNullOrEmpty(loadChoice)) {
                //
            } else {
                if(loadChoice.startsWith("timetotakeitout_")) {
                    String title=("Are you sure you want to delete "+Converters.
                        capFirstLetter(loadChoice.replaceAll("timetotakeitout_",
                        "")));
                    String message="Are you sure you want to delete\n the save "
                        +"game "+Converters.capFirstLetter(loadChoice.replaceAll
                        ("timetotakeitout_","")) + "?";
                    boolean deleteChoice = Popups.yesnoPopup(title,message);
                    if(deleteChoice == true) {
                        ChecksBalances.iffolderexistsDelete(
                            defaultsavesDir + loadChoice.replaceAll(
                            "timetotakeitout_","").toLowerCase());
                        savesDir = defaultsavesDir;
                    } else {
                        //
                    }
                } else {
                    savesDir = defaultsavesDir + 
                        loadChoice + "/";
                    selectedSave = ChecksBalances.getLast(new File(
                        savesDir + ".lastused"));
                    selectedToon = Converters.getfromFile(
                        savesDir + ".lastused", true, false);
                    //change screen here
                    StartGame.startGame(selectedSave, "sav" + 
                        loadChoice + "Toons", "sav" + loadChoice + " Max");
                }
            }
        } else {
            Popups.warnPopup("No Saves Available", "You have no save games avai"
                + "lable.");
            }
        } catch (IOException | InterruptedException | SQLException ex) {
                
        }
    }
    
    public static void aboutPopup() throws IOException {
        try {
            String[] options = new String[] {"Facebook","Discord","YouTube","Be"
                + "nsound.com","OK"};
            String title = "About This Game";
            String message = ("<html>This application was created by ClarkTribe"
                + "Games.<br><br>It was the development of basically a one man "
                + "team with advice, suggestions, and feedback<br>from friends "
                + "and colleagues.<br><br>This game is dedicated to the kids of"
                + " the creator.<br><br>Please consider supporting the cause wi"
                + "th a donation via the <font color=red><b>Donate To The Cause"
                + "</b></font> button.<br><br><b>The music was provided by BenS"
                + "ound.com. Please visit their site for awesome tracks!</b>   "
                + "<br><br>Thank you for your continued support!<br><br>- Geoff"
                + " @ ClarkTribeGames<br><br></html>");
            int choice = Popups.optPopup(options, title, message);
            switch(choice) {
                case 0:
                    GoToWeb.openWeb("https://www.facebook.com/clarktribe.games")
                        ;
                    break;
                case 1:
                    GoToWeb.openWeb("https://discord.gg/6kW4der");
                    break;
                case 2:
                    GoToWeb.openWeb("https://www.youtube.com/channel/UCjcPw3Apu"
                        + "FduiETIdmAhFAQ");
                    break;
                case 3:
                    GoToWeb.openWeb("https://www.bensound.com/");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            LogWriter.logFile("severe","About Popup Error.  Exception: " + ex);
        }
    }
    
    public static void donatePopup() throws IOException {
        try {
            String[] options = new String[] {"Patreon","PayPal","Maybe Later"};
            String title = "Please Donate. :)";
            String message = ("<html><b>This application was created by ClarkTr"
                    + "ibeGames.</b><br><br>If you found this game fun and/or w"
                    + "ant to help with the<br>development of this game, please"
                    + " consider a donation,<br>even if it is $1 to keep projec"
                    + "ts like this alive.\n\nThank you! - Geoff @ ClarkTribeGa"
                    + "mes");
            int choice = Popups.optPopup(options, title, message);
            switch(choice) {
                case 0:
                    GoToWeb.openWeb("https://www.patreon.com/clarktribegames");
                    break;
                case 1:
                    GoToWeb.openWeb("https://www.paypal.me/aznblusuazn");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            LogWriter.logFile("severe","Donate Popup Error.  Exception: " + ex);
        }
    }
    
    public static void exitGame () throws IOException, InterruptedException {
        try {
            String title = ("Exit the Game?");
            String message = "Are you sure you want to exit?";
            boolean exitChoice = Popups.yesnoPopup(title, message);
            if(exitChoice == true) {
                System.gc();
                clearTemp();
                System.exit(0);
            } else {
                //
            }
        } catch (IOException | InterruptedException ex) {
            LogWriter.logFile("severe","Exit Game Error.  Exception: " + ex);
        }
    }
    
    private static void checkVersion (String name, String ver) throws 
        IOException, InterruptedException {
        if((verCheck.checkVersion(name, ver))) {
            Updater.updateMessage(name, ver);
        }
    }
       
}