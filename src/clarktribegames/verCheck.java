package clarktribegames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class verCheck {
    
    public static boolean checkVersion(String installedName, String 
        installedVersion) throws IOException {
        URL webCheck = new URL("http://svr.clarktribegames.com:19762/" + 
                installedName + ".txt");
        try {
            BufferedReader versionIn = new BufferedReader(
            new InputStreamReader(webCheck.openStream()));
            
            String currentVersion;
            for(currentVersion = versionIn.readLine(); currentVersion != null; 
                    currentVersion = versionIn.readLine()) {
                boolean verMatch = currentVersion.contains(installedVersion);
                if(verMatch == true) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (IOException ex) {
            logFile("severe",(webCheck.toString()) + " does not exist.\nExcepti"
                    + "on: " + ex);
            return false;
        }
        return false;
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