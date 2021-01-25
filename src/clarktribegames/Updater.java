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

    public static void updateMessage(String appName, String installedVersion) 
        throws IOException, InterruptedException {
        String messageString = (appName) + " v" + installedVersion + " is not t"
                + "he most current version.  You will need to update to continu"
                + "e.\n\nWould you like to download the latest update?";
        boolean updateNow = Popups.yesnoPopup("Needs an Update",messageString);
        if(updateNow == true) {
            cleanUpdate.cleanUpdate();
        } else {
            String reminderTitle="This is an older release!";
            String reminderMessage="As a reminder, this is an older ALPHA "+
                "release of "+MainControls.appName+"!\n\nPlease be sure to "+
                "update in order to ensure the best experience.\n\nThank you\n"+
                "\nGeoff @ ClarkTribeGames";
            Popups.warnPopup(reminderTitle, reminderMessage);
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