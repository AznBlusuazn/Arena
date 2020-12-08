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
            GoToWeb.openWeb("http://svr.clarktribegames.com:19762/" + appName + 
                ".html");
            MainControls.clearTemp();
            System.gc();
            System.exit(0);
        }
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