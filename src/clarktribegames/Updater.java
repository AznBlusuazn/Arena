package clarktribegames;

import java.io.IOException;
import javax.swing.JOptionPane;


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

    public void updateMessage(String appName, String installedVersion) throws 
            IOException {
        String messageString = (appName) + " v" + installedVersion + " is not "
                + "the most current version.  You will need to update to contin"
                + "ue.\n\nWould you like to download the latest update?";
        boolean updateNow = updateBox("Needs an Update",messageString);
        if(updateNow == true)
            openWeb("http://svr.clarktribegames.com:19762/" + appName + ".html")
                    ;
        System.gc();
        System.exit(0);
    }
    
    private boolean updateBox(String title, String message) {
        int updatePrompt = JOptionPane.showConfirmDialog(null,message,title,
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(updatePrompt == JOptionPane.NO_OPTION) {
                return false;
            } else {
                return true;
            }
    }
    
    private void openWeb(String website) throws IOException {
        String command = "rundll32 url.dll,FileProtocolHandler " + website;
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (Exception ex) {
                logFile("severe",("Cannot access website.  " + ex.toString()));
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