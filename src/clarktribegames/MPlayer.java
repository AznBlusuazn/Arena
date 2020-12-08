/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clarktribegames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class MPlayer {
    
    public static Player mPlayer;
    
    public static void playM() throws FileNotFoundException, IOException, 
        JavaLayerException {
        if(MainControls.musicOn) {
            try (FileInputStream fis = new FileInputStream
                (MainControls.musicPath)) {
                mPlayer = new Player(fis);
                mPlayer.play();
            } catch (Exception ex) {
                //
            }
        }
    }
        
    public static void stopM() throws  Exception {
        try {
            if(MainControls.musicOn) {
                mPlayer.close();
            } 
        } catch (Exception ex) {
            //
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
