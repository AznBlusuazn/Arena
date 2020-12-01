package clarktribegames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class FileCheck {

    public void fileCheck(String ogPath, String newPath, boolean isitStream) 
            throws FileNotFoundException, IOException, Exception {
        File ogFile = new File(ogPath);
        File newFile = new File(newPath);
        boolean exists = newFile.exists();
        if (!exists) {
            if (!isitStream) {
                FileChannel source;
                FileChannel destination;
                source = new FileInputStream(ogFile).getChannel();
                destination = new FileOutputStream(newFile).getChannel();
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
            } else {
                String fullPath = ExportResource(ogPath,newPath);
                
            }
        }
    }
    
    private static String ExportResource(String source, String dest) throws 
            IOException {
           InputStream stream = null;
           OutputStream resStreamOut = null;
           try {
               stream = FileCheck.class.getResourceAsStream(source);
               if(stream == null) {
                   logFile("severe","Export Resource error.  Dir:  " + source);
               }
               int readBytes;
               byte[] buffer = new byte[4096];
               resStreamOut = new FileOutputStream(dest);
               while ((readBytes = stream.read(buffer)) > 0) {
                   resStreamOut.write(buffer, 0, readBytes);
               }
           } catch (IOException ex) {
               logFile("severe","ExportResource.  IOEx: " + ex.toString());
           } finally {
               stream.close();
               resStreamOut.close();
           }
           return dest;
    }
    
    public void newfileCheck(String filepath, boolean hideorNot) throws 
            IOException {
        try{
            File filename = new File(filepath);
            boolean exists = filename.exists();
            if (exists == false) {
                filename.createNewFile();
                String empty = "";
                try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(filename))) {
                    writer.flush();
                    writer.write(empty);
                    writer.close();
                    if(hideorNot == true) {
                        hideFile(filename);
                    }
                }
            }
        } catch (IOException ex) {
            logFile("severe","NewFileCheck.  Ex: " + ex.toString());
        }
    }
    
    public void newdirCheck(String dirpath, boolean hideorNot) throws 
            IOException {
        try {
            File dirname = new File(dirpath);
            boolean exists = dirname.exists();
           if (exists == false) {
               Files.createDirectories(Paths.get(dirpath));
               if(hideorNot == true) {
                   hideFile(dirname);
               }
           }
        } catch (IOException ex) {
                   logFile("severe","NewDirCheck.  Ex: " + ex.toString());
        }
    }
    
    private static void hideFile(File hide) throws IOException {
        try {
          Process p = Runtime.getRuntime().exec("attrib +H " + hide.getPath());
          p.waitFor(); 
        } catch (IOException | InterruptedException e) {
            logFile("severe","HideFile Method.  Ex: " + e.toString());
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

