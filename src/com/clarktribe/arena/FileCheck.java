package com.clarktribe.arena;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

    // <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * 
 */
// </editor-fold>

public class FileCheck {

    public void dbCheck(String ogPath, String dbPath) throws 
            FileNotFoundException, IOException {
        File ogFile = new File(ogPath);
        File dbFile = new File(dbPath);
        boolean exists = dbFile.exists();
        if (!exists) {
            FileChannel source = null;
            FileChannel destination = null;
            source = new FileInputStream(ogFile).getChannel();
            destination = new FileOutputStream(dbFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
            //hideFile(dbFile);
        }
    }
    
    private static void hideFile(File hide) {
        try {
          Process p = Runtime.getRuntime().exec("attrib +H " + hide.getPath());
          p.waitFor(); 
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
      }

    
}

