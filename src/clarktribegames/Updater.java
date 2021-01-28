package clarktribegames;

import java.io.IOException;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Updater {

    public static void updateMessage(boolean dborno,String appName,
        String installedVersion) throws IOException, InterruptedException {
        String messageStr="";
        if(!dborno) {
            messageStr+=(appName)+" v"+installedVersion+" is not the most "+
                "current version.  You will need to update to continue.\n\n"+
                "Would you like to download the latest update?";
            boolean updateNow=Popups.yesnoPopup("Needs an Update",messageStr);
            if(updateNow == true) {
                CleanUpdate.cleanUpdate();
            } else {
                String reminderTitle="This is an older release!";
                String reminderMessage="As a reminder, this is an older ALPHA "+
                    "release of "+MainControls.appName+"!\n\nPlease be sure to"+
                    " update in order to ensure the best experience.\n\n"+
                    "Thank you\n\nGeoff @ ClarkTribeGames";
                Popups.warnPopup(reminderTitle, reminderMessage);
            }
        } else {
            messageStr+="Your default "+(appName)+" database is not the most "+
                "current version.  You will need to update to continue.\n\n"+
                "Would you like to download the latest update?";
            boolean updateNow=Popups.yesnoPopup("Needs an Update",messageStr);
            if(updateNow == true) {
                CleanUpdate.cleanUpdate();
            } else {
                String reminderTitle="This is an older release!";
                String reminderMessage="You cannot continue forward with this "+
                    "older version of the database.\n\nYou will need to update"+
                    " before you can proceed.\n\n"+
                    "Thank you\n\nGeoff @ ClarkTribeGames";
                Popups.warnPopup(reminderTitle, reminderMessage);
                System.gc();
                System.exit(0);
            }
        }
    }
    
    public static void updateProcess() throws IOException {
        GoToWeb.openWeb("http://svr.clarktribegames.com:19762/"+MainControls.
            appName+".html");        
    }
    
//<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile cannot fine log file (infinite loop)!");
        }
    }
//</editor-fold>
    
}