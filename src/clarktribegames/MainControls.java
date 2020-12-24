package clarktribegames;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
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
    static String appVer = "0.0.028";
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
    //Settings.ini
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
        MainMenuGUI.main(args);

    }
    
    private static void startupChecks() throws IOException, Exception {
        try {
            checkVersion(appName,appVer);
            firstCheck();
            checkSaves();
            checkSettings();
        } catch(IOException ex) {
            logFile("severe",("Startup Check IOException: " + ex.toString()));
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
            logFile("severe","Donate Popup Error.  Exception: " + ex);
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
                if(!MainControls.custommusicOn) {
                    return MainControls.defaultBattle;
                } else {
                    return MainControls.custommusicPath + "/" + MainControls.custBattle + ".mp3";
            }
            case "intro" :
                if(!MainControls.custommusicOn) {
                    return MainControls.defaultIntro;
                } else {
                    return MainControls.custommusicPath + "/" + MainControls.custIntro + ".mp3";
                }
            case "win" :
                if(!MainControls.custommusicOn) {
                    return MainControls.defaultWin;
                } else {
                    return MainControls.custommusicPath + "/" + MainControls.custWin + ".mp3";
                }
                
            case "lose" :
                if(!MainControls.custommusicOn) {
                    return MainControls.defaultLose;
                } else {
                    return MainControls.custommusicPath + "/" + MainControls.custLose + ".mp3";
                }                
            default :
                return MainControls.defaultIntro;
        }
    }
    
    private static String defaultMusic(String type) {
        switch(type) {
            case "battle" :
                return MainControls.defaultBattle;
            case "intro" :
                return MainControls.defaultIntro;
            default :
                return MainControls.defaultIntro;
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
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private static String defaultSettings() {
        return "<Limitless Game Options>\nMusic=ON\nCustM=OFF\nCustI=\nCustB=\n"
            +"CustW=\nCustL=\nSound=ON\nSameDB=YES\nDefaultDB=Default\n\n";
    }
    
    private static void checkSettings() throws IOException {
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
            ChecksBalances.ifexistDelete(MainControls.settingsFile);
            System.gc();
            ChecksBalances.newfileCheck(settingsFile, false, newSettings, true);
        } catch (IOException ex) {
            logFile("severe","Update Settings.  EX: " + ex.toString());
        }
    }
    
    private static List<String> rebuildSettings() throws IOException {
        String music = "Music=ON";
        String custmusic = "CustM=OFF";
        String custintro = "CustI=" + custIntro;
        String custbattle = "CustB=" + custBattle;
        String custwin = "CustW=" + custWin;
        String custlose = "CustL=" + custLose;
        String sound = "Sound=ON";
        String samedb = "SameDB=YES";
        String defaultdb = "DefaultDB=" + defaultDB;
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
        List<String> x2=(ChecksBalances.findandRebuild(x1,"Music",music));
        List<String> x3=(ChecksBalances.findandRebuild(x2,"CustM",custmusic));
        List<String> x4=(ChecksBalances.findandRebuild(x3,"CustI",custintro));
        List<String> x5=(ChecksBalances.findandRebuild(x4,"CustB",custbattle));
        List<String> x6=(ChecksBalances.findandRebuild(x5,"CustW",custwin));
        List<String> x7=(ChecksBalances.findandRebuild(x6,"CustL",custlose));
        List<String> x8=(ChecksBalances.findandRebuild(x7,"Sound",sound));
        List<String> x9=(ChecksBalances.findandRebuild(x8,"SameDB",samedb));
        List<String> finalList=(ChecksBalances.findandRebuild(x9,"DefaultDB",
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
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Check Version Method">
    private static void checkVersion (String name, String ver) throws 
        IOException, InterruptedException {
        if((verCheck.checkVersion(name, ver))) {
            Updater.updateMessage(name, ver);
        }
    }
    //</editor-fold>
    
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

