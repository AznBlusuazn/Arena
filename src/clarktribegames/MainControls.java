package clarktribegames;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javazoom.jl.decoder.JavaLayerException;

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
    
    static String appName = "Limitless";
    static String appVer = "0.0.014";
    static String settingsFile = "settings.ini";
    static String musicPath = "sounds/intro.mp3";
    static boolean musicOn = true;
    static boolean soundOn = true;

    public static void main(String[] args) throws Exception {
        lookandfeelSettings();
        startupChecks();
        MainMenuGUI.main(args);
        MPlayer.playM();
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
    
    private static void firstCheck() throws IOException, InterruptedException {
        try {
            boolean libResult = (CmpImporter.cmpImport("lib"));
            boolean soundsResult = (CmpImporter.cmpImport("sounds"));
            ChecksBalances.newfileCheck(settingsFile,false,defaultSettings(),
                true);
            if(!libResult || !soundsResult) {
                String title = "Alert!";
                String message = "Welcome to Limitless!\n\nThis title is still "
                    + "in development.  Please be patient.\n\nThis is your firs"
                    + "t time initializing the game, please kindly restart the "
                    + "game again.\n\nThanks! ~ Geoff @ ClarkTribeGames";
                Popups.infoPopup(title, message);
                System.exit(0);
            }
        } catch(IOException ex) {
            logFile("severe",("checkLib IOException: " + ex.toString()));
        }
    }    
    
    
    private static void checkSaves() throws IOException, Exception {
        try {
            ChecksBalances.newdirCheck("./saves/", false);
            String ogPath = "data.accdb";
            String dbPath = "saves/default.limit";
            ChecksBalances.fileCheck(ogPath,dbPath,true,true);
            ChecksBalances.newfileCheck("saves/.lastused", true,"",false);
        } catch(Exception ex) {
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private static String defaultSettings() {
        return "<Limitless Game Options>\nMusic=ON\nSound=ON\n\n";
    }
    
    private static void checkSettings() throws IOException {
        if(getSettings("Music").equals("off")) {
            musicOn = false;
        }
        if(getSettings("Sound").equals("off")) {
            soundOn = false;
        }
    }
    
    private static String getSettings(String type) throws IOException {
        List<String> settings = Converters.filelistToList(settingsFile, "\n");
        List<String> listresult=(ChecksBalances.lineFinder(settings,type,true));
        String rawresult = Converters.listtoString(listresult);
        String result = rawresult.substring(rawresult.indexOf("=") +1 ,rawresult
            .length());
        return result;
    }
    
    public static void updateSettings() throws IOException,InterruptedException{
        String newSettings = Converters.listtoString(rebuildSettings());
        try {
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
        String sound = "Sound=ON";
        if(!musicOn) {
            music = "Music=OFF";
        }
        if(!soundOn) {
            sound = "Sound=OFF";
        }
        List<String> list1=Converters.filelistToList(settingsFile,"\n");
        List<String> list2=(ChecksBalances.findandRebuild(list1,"Music",music));
        List<String> list3=(ChecksBalances.findandRebuild(list2,"Sound",sound));
        return list3;
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
    private static void checkVersion (String name, String ver) throws IOException {
        boolean needUpdate = new verCheck().checkVersion(name, ver);
        if(needUpdate == true)
            new Updater().updateMessage(name, ver);
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
