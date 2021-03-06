package clarktribegames;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class CmpManager {
    
    private static final int BUFFER_SIZE=4096;
    
    public void openCmp(String cmpPath, String destPath) throws 
            IOException {
        File destDir=new File(destPath);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        Class unzipClass=this.getClass();   
        InputStream inStream=unzipClass.getResourceAsStream(cmpPath);
        try (ZipInputStream cmpIn=new ZipInputStream(inStream)) {
            ZipEntry entry=cmpIn.getNextEntry();
            while (entry != null) {
                String filePath=destPath + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(cmpIn, filePath);
                } else {
                    File dir=new File(filePath);
                    dir.mkdirs();
                }
                cmpIn.closeEntry();
                entry=cmpIn.getNextEntry();
            }
        } catch (IOException ex) {
            logFile("severe","Unzip Method.  Exception: " + ex.toString());
        }
    }   
    
    private void extractFile(ZipInputStream cmpIn, String filePath) throws 
            IOException {
        try {
            BufferedOutputStream bos=new BufferedOutputStream(new 
                FileOutputStream(filePath));
            byte[] bytesIn=new byte[BUFFER_SIZE];
            int read=0;
            while ((read=cmpIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
            bos.close();
        } catch (IOException ex) {
            logFile("severe","ExtractFile Method.  Exception" + ex.toString());
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
