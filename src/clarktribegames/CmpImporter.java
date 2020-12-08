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
public class CmpImporter {
    
    private static boolean cmpCheck(String dir) throws IOException {
        boolean retVal = false;
        try {
            File dirname = new File(dir);
            boolean exists = dirname.exists();
            if(!exists) { //if there is no dir, then make one...
                retVal = true; //this means dir was made
            }
            ChecksBalances.newdirCheck(dir, true);
        } catch(IOException ex) {
            logFile("severe","CMP Check.  IOEx: " + ex.toString());
        }
        return retVal;
    }
    
    private static void cmpCopy(String cmp, String dir) throws IOException {
        try {
            CmpManager unzipper = new CmpManager();
            unzipper.openCmp(cmp, dir);
        } catch(IOException ex) {
            logFile("severe","CMP Copy.  IOEx: " + ex.toString());
        }
    }
    
    public static boolean cmpImport(String name) throws IOException {
        boolean importVal = false;
        try {
            if(!cmpCheck (".\\" + name + "\\")) { //this means dir was not made
                importVal = true;
            } else {
                cmpCopy(name + ".cmp", "./"); 
                importVal = false;
            }
        } catch(IOException ex) {
            logFile("severe","CMP Import.  IOEx: " + ex.toString());
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
