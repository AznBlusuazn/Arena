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
    static String appVer = "0.0.038";
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
    //Date and Time
    static int gameWeek = 1;
    static int gameDay = 1;
    static int gameMonth = 1;
    static int gameYear = 1;
    static int gameHour = 0;
    static int gameMin = 0;
    static int rawTime = 0;
    //Settings.ini
    static boolean darkOn = true;
    static boolean musicOn = true;
    static boolean custommusicOn = false;
    static boolean soundOn = true;
    static boolean samedbOn = true;
    static String defaultDB = defaultSave.substring(0,defaultSave.indexOf("." + 
        saveExt));
    static boolean created = false;
    static boolean justswitch = false;
    static String passiveDestinyID = "1";

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
            LogWriter.logFile("severe",("Startup Check IOException: "+ex
                .toString()));
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
            LogWriter.logFile("severe",("Saves Check Exception: "+ex.toString())
                );
        }
    }
    
    private static String defaultSettings() {
        return "<Limitless Game Options>"
            + "\nDark=ON\nMusic=ON\nCustM=OFF\nCustI=\nCustB=\nCustW=\nCustL=\n"
            + "Sound=ON\nSameDB=YES\nDefaultDB=Default\n\n";
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
            musicPath = custommusicPath + "/" + custIntro.replaceAll("[Intro] ",
                "") + ".mp3";
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
    
    public static void updateSettings() throws IOException,InterruptedException,
        Exception{
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
            LogWriter.logFile("severe","Update Settings.  EX: " +ex.toString());
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
            
            //create reset variables method
            created = false;
            //this is temp for now
            if(!samedbOn) {
                limitSelect();
            } else {
                selectedSave = defaultDB + "." + 
                    saveExt;
            }
            boolean continueon = false;
            currentgamePath=currentgamePath=Limitless.ngText.getText().
                toLowerCase();
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
                Popups.infoPopup("Building Save Game","Your new game world will"
                    + " now be built.  Please be patient.");
                backgroundBuild();
                while(!created) {
                    Thread.sleep(1);
                }
                rawTime = Integer.parseInt(GetData.dataQuery("*","sav"+
                    Converters.capFirstLetter(Limitless.ngText.getText())+"Time"
                    ,"timeID","0",false,false,null,null).get(1));
                String[] dateTime=Converters.convertTime(rawTime);
                gameYear=Integer.parseInt(dateTime[0]);
                gameMonth=Integer.parseInt(dateTime[1]);
                gameWeek=Integer.parseInt(dateTime[2]);
                gameDay=Integer.parseInt(dateTime[3]);
                gameHour=Integer.parseInt(dateTime[4]);
                gameMin=Integer.parseInt(dateTime[5]);

                Limitless.setLoadingAvatars();
                Limitless.loadingLabel.setText("Game World Has Been Built!");
                Popups.infoPopup("Save Game Built",
                    "Your new game world has been built.  Thank you for your "
                    + "patience.");
                Thread.sleep(1500);
                Limitless.showNewGameList();
                newgamelistMenu();
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
                    "/",0),currentgamePath.indexOf("/",
                    currentgamePath.indexOf("/") + 1)).replaceAll("/","");
                savesDir="saves/" + currentgame + "/";
                GetData.createnewSave(Converters.capFirstLetter((selectedSave).
                    substring(0,(selectedSave).indexOf("."+saveExt))),
                    currentgame);
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
        } else {
            newgametoonList = new String[newgameToonList.size()][2];
            for(int i=0;i < newgameToonList.size();i++) {
                newgametoonList[i][0] = newgameToonList.get(i);
                newgametoonList[i][1] = String.valueOf(i);
            }
            Arrays.sort(newgametoonList, new Comparator<String[]>() {
                @Override
                public int compare(final String[] entry1,final String[] entry2){
                    final String toon1 = entry1[0];
                    final String toon2 = entry2[0];
                    return toon1.compareTo(toon2);
                }
            });
            for (final String[] s : newgametoonList) {
                newtlDml.addElement(s[0]);
            }
            Limitless.altName.setVisible(false);
            Limitless.newgameList.setModel(newtlDml);
            Limitless.newgameList.setEnabled(true);
            try {
                passiveDestinyID = GetData.dataQuery("*","dbDestiny",
                    "destinyName","Passive", false, false, null,null).get(0);
            } catch (Exception ex) {
                passiveDestinyID = "1";
            }
        }
    }    
    
    private static void worldtextInfo() throws SQLException {
        //add game date method here
        String save=savesDir.replaceAll("saves/","").replaceAll("/"
            , "");
        String savetoons = "sav" + save + "Toons";
        String rawtime = GetData.dataQuery("*", "sav"+save+"Time","timeID","0",
            false,false,null,null).get(1);
        String[] datetime = Converters.convertTime(Integer.parseInt(rawtime));
        gameYear = Integer.parseInt(datetime[0]);
        gameMonth = Integer.parseInt(datetime[1]);
        gameWeek = Integer.parseInt(datetime[2]);
        gameDay = Integer.parseInt(datetime[3]);
        gameHour = Integer.parseInt(datetime[4]);
        gameMin = Integer.parseInt(datetime[5]);
        //above it temp date
        int count = ((GetData.dataQuery("*", savetoons, "toonName", null, true, 
            false, null, null))).size();
        List<Integer> exps = new ArrayList<>();
        for(String exp : ((GetData.dataQuery("*", savetoons, "toonExp", null, 
            true, false, null, null)))) exps.add(Integer.valueOf(exp));
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
        
        String text = "This world starts at Year " + gameYear + ", Month " + 
            gameMonth + ", Week " + gameWeek + ", Day " + gameDay + " at Hour " 
            + gameHour + " Minute " + gameMin +".\n\nCurrently, there are " 
            + count + " characters in the world.\n\nThe highest level character"
            + " is " + topplayer + ", who is a " + alignment + " " + age + " " 
            + gender + " that is " + size + " " + race + " " + clas + " at Leve"
            + "l " + Calculator.getLevel("curlv", String.valueOf(toplv)) + ".\n"
            + "\nYour possiblities are Limitless!\n\nSelect your character and "
            + "then click Start New Game to begin your journey.";
        new TypeEffect(Limitless.welcomeText,text,10,false,null,null).start();
        Limitless.newgameList.setSelectedIndex((int) (Math.random() * count));
    }
    
    public static void ngToonSelect(String selectedToonID) throws SQLException, 
        IOException {
        String[] selectedToon =(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "toons")),Integer.
            parseInt(selectedToonID))).split(",");
        Limitless.charName.setText(selectedToon[1]);
        Avatars.setAvatar(Limitless.charToon, selectedToon[1],selectedToon[10]);
        
        Limitless.charStat01.setText((GetData.dataQuery("*","dbAlign","alignID",
            Calculator.getAlign(Integer.parseInt(selectedToon[4])),false,
            false,null,null)).get(1));
        Limitless.charStat01.setFont(new Font(Limitless.charStat01.getFont().
            getName(),Font.BOLD,Limitless.charStat01.getFont().getSize()));
        Limitless.charStat01.setForeground((Converters.figureoutColor(GetStats.
            getalignColor(Integer.parseInt((selectedToon[4]))))));
        Limitless.charStat01.setToolTipText(Limitless.charStat01.getText()+": "+
            (GetData.dataQuery("*","dbAlign","alignID",Calculator.getAlign(
            Integer.parseInt(selectedToon[4])), false, false, null,null)).
            get(2));
        
        String ageName=(Calculator.getAge(Integer.parseInt(selectedToon[7]), 
            selectedToon[2]));
        String gendName=(GetData.dataQuery("*","dbGender","genderID",
            selectedToon[6],false,false,null,null)).get(1);
        Limitless.charStat02.setText(ageName + " • " + gendName);
        Limitless.charStat02.setToolTipText(ageName+": "+(GetData.dataQuery("*",
            "dbAge","ageName",ageName,false,false,null,null)).get(3)+" • "+
            gendName+": "+(GetData.dataQuery("*","dbGender","genderID",
            selectedToon[6],false,false,null,null)).get(2));
        String sizeID = selectedToon[22];
        String sizeName=(GetData.dataQuery("*", "dbSize", "sizeID",sizeID,false,
            false,null,null)).get(1);
        String raceName=GetData.dataQuery("*","dbRace","raceID",selectedToon[2],
            false,false,null,null).get(1);
        Limitless.charStat03.setText(sizeName + " • " + raceName);
        Limitless.charStat03.setToolTipText(sizeName+": "+(GetData.dataQuery("*"
            ,"dbSize","sizeID",sizeID,false,false,null,null)).get(2)+ " • "+
            raceName+": "+(GetData.dataQuery("*","dbRace","raceID",
            selectedToon[2],false,false,null,null)).get(2));
        String UID = selectedToon[5];
        if(UID.startsWith("7")) {
            String ogID = UID.replace("7x", "");
            String[] ogToon =(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "toons")),Integer.
            parseInt(ogID))).split(",");
            String jobID=(GetData.dataQuery("*","dbAlias","aliasID",ogToon[18],
                false,false,null,null)).get(6);
            String className=(GetData.dataQuery("*","dbJobs","jobID",jobID,false
                ,false,null,null)).get(1);
            Limitless.charStat04.setText(className+" • Level "+selectedToon[8]);
            Limitless.charStat04.setToolTipText(className+": "+(GetData
                .dataQuery("*","dbJobs","jobID",jobID,false,false,null,null)).
                get(4)+" • Level "+selectedToon[8]);  
        } else {
            String className=(GetData.dataQuery("*","dbClass","classID",
                selectedToon[3],false,false,null,null)).get(1);
            Limitless.charStat04.setText(className+" • Level "+selectedToon[8]);
            Limitless.charStat04.setToolTipText(className+": "+(GetData.
                dataQuery("*","dbClass","classID",selectedToon[3],false,false,
                null,null)).get(2)+" • Level "+selectedToon[8]);        
        }

        // add in status decoder here (can be method in GetStats)

        String statusname=(GetData.dataQuery("*","dbStatus","statusName",
            "Normal",false,false,null,null)).get(1);
        String statuscolor=(GetData.dataQuery("*","dbStatus","statusName",
            "Normal",false,false,null,null)).get(2);
        String statusdesc=(GetData.dataQuery("*","dbStatus","statusName",
            "Normal", false,false,null,null)).get(3);
        String statusbio=(GetData.dataQuery("*","dbStatus","statusName","Normal"
            , false,false,null,null)).get(4);
//        if(ChecksBalances.isNullOrEmpty(statuscode) || statuscode.equals("0"))
//            {
//            //put normal status here
//        }

        Font charstat05Font=new Font(Limitless.charStat05.getFont().getName(),
            Font.BOLD,Limitless.charStat05.getFont().getSize());
        Limitless.charStat05.setText(statusname);
        Limitless.charStat05.setFont(charstat05Font);
        Limitless.charStat05.setForeground((Converters.figureoutColor
            (statuscolor)));
        Limitless.charStat05.setToolTipText(statusdesc);
        if(selectedToon[19].equals(passiveDestinyID) || selectedToon[5].equals("1")) {
            Limitless.ngstartButton.setEnabled(false);
        } else {
            Limitless.ngstartButton.setEnabled(true);
        }
        ngToonSelectButtons("bio");
    }
    
    public static void ngToonSelectButtons(String option) throws SQLException, 
        IOException {
        String selectedToonID=newgametoonList[Limitless.newgameList
            .getSelectedIndex()][1];
        String[] selectedToon =(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "toons")),Integer.
            parseInt(selectedToonID))).split(",");
        if(!selectedToon[18].isEmpty() && !selectedToon[18].equals("null") && 
            !selectedToon[18].equals("")) {
            Limitless.altName.setVisible(true);
        } else {
            Limitless.altName.setVisible(false);
        }
        
        switch(option) {
            case "stats" :
                ngToonSelectStats(selectedToon);
                break;
            case "effs" :
                ngToonSelectEffs(selectedToon);
                break;
            case "abls" :
                ngToonSelectAbls(selectedToon);
                break;
            case "equip" :
                ngToonSelectEquip(selectedToon);
                break;
            default :
                ngToonSelectBio(selectedToon);
                break;
        }
    }
    
    private static void ngToonSelectStats(String[] selectedToon) throws 
        SQLException, IOException {
        String[] newstats=(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "temp")),Integer.
            parseInt(selectedToon[0]))).split(",");
        String statsinfo="[" + selectedToon[1] + " Stats]\n\n"
            + " Health Points:  " + newstats[9] + "\n"
            + " Mystic Points:  " + newstats[10] + "\n"
            + "Ability Points:  " + newstats[11] + "\n"
            + "  Attack Power:  " + newstats[12] + "\n"
            + "      Strength:  " + newstats[13] + "\n"
            + "       Defense:  " + newstats[14] + "\n"
            + "       Stamina:  " + newstats[15] + "\n"
            + "         Speed:  " + newstats[16] + "\n"
            + "         Evade:  " + newstats[17] + "\n"
            + "     Dexterity:  " + newstats[18] + "\n"
            + "  Mystic Power:  " + newstats[19] + "\n"
            + "Mystic Defense:  " + newstats[20] + "\n"
            + "  Mystic Evade:  " + newstats[21] + "\n"
            + "     Willpower:  " + newstats[22] + "\n"
            + "          Luck:  " + newstats[23] + "\n"
            + "      Charisma:  " + newstats[24] + "\n"
            + "  Intelligence:  " + newstats[25] + "\n\n"
            + " Fatigue (Hid):  " + newstats[26] + "\n"
            + " Soul (Hidden):  " + newstats[27] + "\n"
            + "Decay (Hidden):  " + newstats[28] + "\n"
            + "WeightMod(Hid):  " + newstats[29] + "\n"
            + "  Rep (Hidden):  " + newstats[30];
        Limitless.charStatText.setText(statsinfo);
    }
    
    private static void ngToonSelectEffs(String[] selectedToon) throws 
        SQLException, IOException {
        String[] effStats=GetStats.getAEStats("Effects",selectedToon);
        String statuscode=(((Arrays.toString(effStats)).replaceAll
            ("MASTER, ", "").replaceAll(",", "-")).replaceAll("[^\\d+\\-]",""));
        if(statuscode.length() <= 0) {
            statuscode = "0";
        }
        String effsinfo="["+selectedToon[1]+" Starting Effects]\n\n"+
            GetStats.getitemsfromIDtoString(GetStats.getAEStats("Effects",
            selectedToon),"dbEffects","effID","effName")
            +"\n\n(Hidden) Status Code: " + statuscode;
        Limitless.charStatText.setText(effsinfo);
    }

    private static void ngToonSelectAbls(String[] selectedToon) throws 
        SQLException, IOException {
        String ablsinfo="["+selectedToon[1]+" Abilities]\n\n"+GetStats.
            getitemsfromIDtoString(GetStats.getAEStats("Abls",selectedToon),
            "dbAbl","ablID","ablName");
        Limitless.charStatText.setText(ablsinfo);
    }

    private static void ngToonSelectEquip(String[]  selectedToon) 
        throws SQLException {
        String equipinfo="["+selectedToon[1]+"]\n\n"+
            "[Equipment Held]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[13].split("x")),"dbItems","itemID","itemName")+"\n\n"+
            "[Wearables Equipped]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[14].split("x")),"dbItems","itemID","itemName")+"\n\n"+
            "[Charms Equipped]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[15].split("x")),"dbItems","itemID","itemName")+"\n\n"+
            "[Starting Inventory]\n"+GetStats.getitemsfromIDtoString((
            selectedToon[16].split("x")),"dbItems","itemID","itemName");
        Limitless.charStatText.setText(equipinfo);
    }

    private static void ngToonSelectBio(String[] selectedToon) throws 
        SQLException, IOException {
        String bioInfo=Converters.capFirstLetter((GetData.dataQuery("*",
            "dbGender","genderID",selectedToon[6],false,false,null,null)).
            get(5))+" is a "+
            ((GetData.dataQuery("*","dbAlign","alignID",Calculator.getAlign(
            Integer.parseInt(selectedToon[4])),false,false,null,null)).get
            (6))+" "+
            (Calculator.getAge(Integer.parseInt(selectedToon[7]),
            selectedToon[2]))+" "+
            (GetData.dataQuery("*", "dbGender","genderID",selectedToon[6],
            false,false,null,null)).get(1)+" that is "+
            (GetData.dataQuery("*","dbSize","sizeName",(GetData.dataQuery("*",
            "dbSize", "sizeID",selectedToon[22],false,false,null,null)).
            get(1),false,false,null,null)).get(4)+" "+
            (GetData.dataQuery("*","dbRace","raceID",selectedToon[2],false,
            false,null,null)).get(7)+" ";
        String UID = selectedToon[5];
        if(UID.startsWith("7x")) {
            Limitless.altName.setVisible(true);
            String ogID = UID.replace("7x", "");
            String[] ogToon =(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "toons")),Integer.
            parseInt(ogID))).split(",");
            String jobID=(GetData.dataQuery("*","dbAlias","aliasID",ogToon[18],
                false,false,null,null)).get(6);
            bioInfo +=(GetData.dataQuery("*","dbJobs","jobID",jobID,false
                ,false,null,null)).get(1);
        } else {
            bioInfo +=(GetData.dataQuery("*","dbClass","classID",selectedToon[3]
                ,false,false,null,null)).get(4);
        }
        bioInfo += " and "+ (GetData.dataQuery("*","dbStatus","statusName",
            Limitless.charStat05.getText(),false,false,null,null)).get(4)+
            ".\n\n"+selectedToon[9];
        if(UID.startsWith("7x")) {
            String ogID = UID.replace("7x", "");
            String[] ogToon =(Converters.getSpecificLine((
            currentgamePath.replaceAll(saveExt, "toons")),Integer.
            parseInt(ogID))).split(",");
            if(!ogToon[18].equals("null") && !(ChecksBalances.isNullOrEmpty
                (ogToon[18]))) {
                List<String> ogAlias = getAliasInfo(ogToon[18]);
                if(ogAlias.get(2).equals("0") || ogAlias.get(2).equals("1")) {
                    //and og 18 is either 0 or 1
                    //name is the identity of xyz known to the public   
                    bioInfo+="\n\n"+Converters.capFirstLetter((GetData
                        .dataQuery("*","dbGender","genderID",selectedToon[6],
                        false,false,null,null)).get(5))+" is also " +ogToon[1]+ 
                        " as known to the public.";
                    Limitless.altName.setVisible(true);
                }
                if(!ogAlias.get(2).equals("0") && !ogAlias.get(2).equals("1")) {
                    Limitless.altName.setVisible(false);  
                }
            } else {
                Limitless.altName.setVisible(false);
            }
        } else {
            
            if(ChecksBalances.isNullOrEmpty(selectedToon[18]) || 
                (selectedToon[18].equals("null"))) {
                Limitless.altName.setVisible(false);
                //do nothing with alias here
            } else {
                Limitless.altName.setVisible(true);
                List<String> toonAlias = getAliasInfo(selectedToon[18]);
                //0 name only no secret -- nothing
                //1 transformation no secret
                if(toonAlias.get(2).equals("0") || toonAlias.get(2).equals("1"))
                    {
                        bioInfo+="\n\n"+Converters.capFirstLetter((GetData
                        .dataQuery("*","dbGender","genderID",selectedToon[6],
                        false,false,null,null)).get(5))+" has a known alias as "
                        +GetData.dataQuery("*","dbAlias","aliasID",
                        selectedToon[18],false,false,null,null).get(1)+" when"+
                        " "+GetData.dataQuery("*","dbGender","genderID",
                        selectedToon[6],false,false,null,null).get(5)+" is not "
                        +selectedToon[1]+".";
                        if(toonAlias.get(2).equals("0")) {
                            justswitch = true;
                        } else {
                            justswitch = false;
                        }
                    } else {
                    Limitless.altName.setVisible(false);
                }
                //2 secret with fake stats
                //3 secret with transformation
                if(toonAlias.get(2).equals("2") || toonAlias.get(2).equals("3"))
                    {
                        Limitless.altName.setVisible(false);
                        bioInfo+="\n\n"+Converters.capFirstLetter((GetData
                            .dataQuery("*","dbGender","genderID",selectedToon[6]
                            ,false,false,null,null)).get(5))+
                            " has a Secret Identity that is not known to the "
                            + "public.";
                    }
            }
        }
        if(selectedToon[5].equals("1")) {
            bioInfo+="\n\n"+
                "***This character is generated generic character.  You cannot "
                + "start a game with this character.***";
        }
        if(selectedToon[19].equals(passiveDestinyID) && !selectedToon[5].equals(
            "1")) {
            bioInfo+="\n\n"+
                "***This character is set to Passive.  You cannot start a game "
                + "with this character.***";
        }
        //update health status above
        Limitless.charStatText.setText(bioInfo);
    }
    
    public static void altnameButton(String opt) throws IOException, 
        SQLException {
        String selectedToonID=newgametoonList[Limitless.newgameList
            .getSelectedIndex()][1];
        String[] selectedToon =(Converters.getSpecificLine((
             currentgamePath.replaceAll(saveExt, "toons")),Integer.
             parseInt(selectedToonID))).split(",");
        switch(opt) {
            case "Change" :
                if(!selectedToon[18].isEmpty() && !selectedToon[18]
                    .equals("null") && !selectedToon[18].equals("")) {
                    List<String> toonAlias = getAliasInfo(selectedToon[18]);
                    if(toonAlias.get(2).equals("1")) {
                        for(int i=0;i<Limitless.newgameList.getModel().getSize()
                            ;i++) {
                            if(Limitless.newgameList.getModel().getElementAt(i).
                                contains(toonAlias.get(1))) {
                                Limitless.newgameList.setSelectedIndex(i);
                            }
                        }
                    }
                } else {
                    if(selectedToon[5].startsWith("7x")) {
                        String[]ogToon=(Converters.getSpecificLine((
                            currentgamePath.replaceAll(saveExt,"toons")),Integer
                            .parseInt(selectedToon[5].replaceAll("7x","")))).
                            split(",");
                        for(int i=0;i<Limitless.newgameList.getModel().getSize()
                            ;i++) {
                            if(Limitless.newgameList.getModel().getElementAt(i).
                                contains(ogToon[1])) {
                                Limitless.newgameList.setSelectedIndex(i);
                            }
                        }
                    }
                }
                break;
            case "Switch" :
                if(!selectedToon[18].isEmpty() && !selectedToon[18].equals
                    ("null") && !selectedToon[18].equals("")) {
                    List<String> toonAlias = getAliasInfo(selectedToon[18]);
                    if(toonAlias.get(2).equals("0")) {
                        Avatars.setAvatar(Limitless.charToon, toonAlias.get(1),
                            toonAlias.get(8));
                        Limitless.charName.setText(toonAlias.get(1));
                    }
                }
                break;
            case "Revert" :
                if(!selectedToon[18].isEmpty() && !selectedToon[18].equals
                    ("null") && !selectedToon[18].equals("")) {
                    List<String> toonAlias = getAliasInfo(selectedToon[18]);
                    if(toonAlias.get(2).equals("0")) {
                        Avatars.setAvatar(Limitless.charToon, selectedToon[1],
                            selectedToon[10]);
                        Limitless.charName.setText(selectedToon[1]);
                    }
                }
                break;
            default :
                //
                break;
        }
    }

    public static void ngStartButton(String toonID) throws SQLException, 
        IOException, InterruptedException {
        String ngsaveName=Converters.capFirstLetter((selectedSave).substring(0,
            (selectedSave).indexOf("."+saveExt)));
        String ngsaveToon=((savesDir).substring(((savesDir).indexOf("/",0)))).
            substring(1,((savesDir).substring(((savesDir).indexOf("/",0)))).
            indexOf("/",1));
        String ngsaveToons = "sav" + ngsaveToon + "Toons";
        String ngsaveMax = "sav" + ngsaveToon + "Max";
        selectedToon=GetData.dataQuery("*",ngsaveToons,"toonID",String.valueOf
            (toonID),false,false,null,null).get(0);
        boolean yesno=Popups.yesnoPopup("Character Selection", "You've selected"
            +" "+GetData.dataQuery("*",ngsaveToons,"toonID",String.valueOf
            (toonID),false,false,null,null).get(1)+" as your character.\n\n"
            +"Are you sure you want to start the game?");
        if(yesno) {
            ChecksBalances.newfileCheck(savesDir+".lastused",true,selectedToon+
            "\n"+selectedSave+"\n"+rawTime+"\n",true);
            System.gc();
            StartGame.startGame(ngsaveName, ngsaveToons, ngsaveMax);
        } else {
            selectedToon = "";
        }
    }
    
    private static void limitSelect() throws IOException {
        String title = "New Game Database Selection";
        String message = "Select a Database for the New Game:\n\n";
        DefaultComboBoxModel limitdml = new DefaultComboBoxModel();
        JComboBox dboptions = new JComboBox();
        popLimit(dboptions,limitdml);
        if(dboptions.getItemCount() > 1) {
            String selection=Popups.comboboxPopup(title,message,dboptions,null);
            if(ChecksBalances.isNullOrEmpty(selection)) {
                //
            } else {
                selectedSave = (selection.toLowerCase() + "." + saveExt);
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
            List<String> savelist = (Converters.foldertoList(savesDir,saveExt)).
                stream().map(Object::toString).collect(Collectors.toList());
            fillLimit(box,savelist,dml);
        } catch (IOException ex) {
            LogWriter.logFile("severe","SAV Select Error.\nEx: "+ex.toString());
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
            String y = Converters.capFirstLetter(x.substring(x.indexOf("\\")+1,
                x.indexOf(".",x.indexOf(saveExt) - 2)));
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
            selectedToon=Converters.getSpecificLine(savesDir+".lastused",0);
            selectedSave=Converters.getSpecificLine(savesDir+".lastused",1);
            rawTime=Integer.parseInt(Converters.getSpecificLine(savesDir+
                ".lastused",2));
            String[] dateTime = Converters.convertTime(rawTime);
            gameYear=Integer.parseInt(dateTime[0]);
            gameMonth=Integer.parseInt(dateTime[1]);
            gameWeek=Integer.parseInt(dateTime[2]);
            gameDay=Integer.parseInt(dateTime[3]);
            gameHour=Integer.parseInt(dateTime[4]);
            gameMin=Integer.parseInt(dateTime[5]);
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
    
    private static List<String> getAliasInfo (String aID) throws SQLException {
        return GetData.dataQuery("*","dbAlias","aliasID",aID,false,false,null,
            null);
    }

    public static void exitGame () throws IOException, InterruptedException {
        try {
            String title = ("Exit the Game?");
            String message = "Are you sure you want to exit?";
            boolean exitChoice = Popups.yesnoPopup(title, message);
            if(exitChoice == true) {
                System.gc();
                if(!savesDir.equals(defaultsavesDir)) {
                    if(!(new File(savesDir + ".lastused").exists())) {
                        ChecksBalances.iffolderexistsDelete(savesDir);
                    }
                }
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
        if((VersionCheck.checkVersion(name, ver))) {
            Updater.updateMessage(name, ver);
        }
    }
}