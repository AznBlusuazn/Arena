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

public class GoToWeb {
    
    public static void openWeb(String URL) throws IOException {
        String command = "rundll32 url.dll,FileProtocolHandler " + URL;
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
                logFile("severe",("Cannot access website.  " + ex.toString()));
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
