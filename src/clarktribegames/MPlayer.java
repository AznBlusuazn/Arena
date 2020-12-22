package clarktribegames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author admingec
 */
public class MPlayer {
    
//    public static Player mPlayer;
    public static AdvancedPlayer mPlayer;
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
            try {
                do {
                FileInputStream fis = new FileInputStream(MainControls.musicPath);
                mPlayer = new AdvancedPlayer(fis);
                mPlayer.play();
//                mPlayer.setPlayBackListener(new PlaybackListener() {
//                    @Override
//                    public void playbackStarted(PlaybackEvent event) {}
//                    @Override
//                    public void playbackFinished(PlaybackEvent event) {
//                        try {
//                            System.out.println("HERE");
//                            mPlayer.close();
//                            playMedia();
//                        } catch (IOException | JavaLayerException e) {
//                            e.printStackTrace();
//                        } 
//                    }
//                });
                }while(mplayerOn);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            
//            try {
//                    FileInputStream fis = new FileInputStream(MainControls.musicPath);
//                    while(true) {
//                    mPlayer = new Player(fis);
//
//                        mPlayer.play();
//                    }
//            } catch (Exception ex) {
//                //
//            }
    }
        
    public static void stopMedia() throws  Exception {
        try {
            mplayerOn = false;
            if(MainControls.musicOn) {
                System.out.println(MainControls.threadName);
                for(Thread t : Thread.getAllStackTraces().keySet()) {
                    if(t.getName().equals(MainControls.threadName)) {
                        t.interrupt();
                        break;
                    }
                }
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
        MainControls.threadName = mplayerThread.getName();
        mplayerThread.start();
   
    }
}
    