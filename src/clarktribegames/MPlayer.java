package clarktribegames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author admingec
 */
public class MPlayer {
    
    public static Player mPlayer;
    public static boolean mplayerOn;
        
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
                //
            } catch (Exception ex) {
                //
            }
        }
    }

    public static void playMedia() throws FileNotFoundException, IOException, 
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
        
    public static void stopMedia() throws  Exception {
        try {
            if(MainControls.musicOn) {
                mPlayer.close();
            } 
        } catch (Exception ex) {
            //
        }
    }
    
    public static void mediaPlayer(boolean play) {
        if(play) {
            mplayerOn = true;
        } else {
            mplayerOn = false;
        }
        Thread mplayerThread = new Thread(new mplayerRunnable());
        mplayerThread.start();
    }
    
}
