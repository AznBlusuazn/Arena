package clarktribegames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

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
    public static AdvancedPlayer mPlayer;
    public volatile static boolean mplayerOn;
        
    public static class mplayerRunnable implements Runnable {
        @Override
        public void run() {
            try {
                if(mplayerOn) {
                    playMedia();
                } else {
                    stopMedia();
                }
            } catch (IOException | JavaLayerException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void playMedia() throws FileNotFoundException, IOException, 
        JavaLayerException {
        if(MainControls.musicOn) {
            try {
                do {
                FileInputStream fis = new FileInputStream(MainControls.musicPath);
                mPlayer = new AdvancedPlayer(fis);
                mPlayer.play();
                }while(mplayerOn);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
    }
        
    public static void stopMedia() throws  Exception {
        try {
            mplayerOn = false;
            MainControls.musicPlaying = mplayerOn;
            if(MainControls.musicOn) {
                for(Thread t : Thread.getAllStackTraces().keySet()) {
                    if(t.getName().equals(MainControls.threadName)) {
                        t.interrupt();
                        break;
                    }
                }
                mPlayer.close();
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void mediaPlayer(boolean play) throws InterruptedException {
        if(play) {
            mplayerOn = true;
        } else {
            mplayerOn = false;
        }
        Thread mplayerThread = new Thread(new mplayerRunnable());
        MainControls.threadName = mplayerThread.getName();
        mplayerThread.start();
    }
}
    