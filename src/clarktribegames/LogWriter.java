package clarktribegames;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.FileHandler;


// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>
public class LogWriter {
    
    public void writeLog(String type, String loginfo) throws IOException {
        String logDir = (".\\logs\\");
        String logFile = ("error_" + (logDateTime(0)) + ".log");
        new FileCheck().newdirCheck(logDir, false);
        new FileCheck().newfileCheck(logDir + logFile, false);
        boolean append = true;
        FileHandler logHandler = new FileHandler(logDir + logFile, append);
        Logger logger = Logger.getLogger(logFile);
        logger.addHandler(logHandler);
        switch(type) {
            case "severe":
                logger.severe(loginfo);
                logHandler.close();
                break;
            case "warning":
                logger.warning(loginfo);
                logHandler.close();
                break;
            case "config":
                logger.config(loginfo);
                logHandler.close();
                break;
            case "fine":
                logger.fine(loginfo);
                logHandler.close();
                break;
            case "finer":
                logger.finer(loginfo);
                logHandler.close();
                break;
            case "finest":
                logger.finest(loginfo);
                logHandler.close();
                break;
            default:
                logger.info(loginfo);
                logHandler.close();
                break;
        }
    }

    private static String logDateTime(int whichone) {
        Date date = Calendar.getInstance().getTime();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        if(whichone == 1) {
            format = new SimpleDateFormat("HHmmss");
        } 
        String string = format.format(date);
        return string;
    }
            
    
}