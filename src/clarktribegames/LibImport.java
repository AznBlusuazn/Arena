package clarktribegames;

import java.io.File;
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
public class LibImport {
    private boolean libCheck(String libDir) throws IOException {
        boolean retVal = false;
        try {
            File dirname = new File(libDir);
            boolean exists = dirname.exists();
            if(!exists) { //if there is no dir, then make one...
                retVal = true; //this means dir was made
            }
            new FileCheck().newdirCheck(libDir, true);
        } catch(IOException ex) {
            logFile("severe","LibCheck.  IOEx: " + ex.toString());
        }
        return retVal;
    }
    
    private void libCopy(String zip, String dir) throws IOException {
        try {
            Unzipper unzipper = new Unzipper();
            unzipper.unzip(zip, dir);
        } catch(IOException ex) {
            logFile("severe","LibCopy.  IOEx: " + ex.toString());
        }
    }
    
    public boolean libImport() throws IOException {
        boolean importVal = false;
        try {
            if(!libCheck (".\\lib\\")) { //this means dir was not made
                importVal = true;
            } else {
                libCopy("lib.zip", "./"); 
                importVal = false;
            }
        } catch(IOException ex) {
            logFile("severe","LibImport.  IOEx: " + ex.toString());
        }
        return importVal;
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
