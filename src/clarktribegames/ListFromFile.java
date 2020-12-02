/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clarktribegames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author admingec
 */
public class ListFromFile {
    public String getfromFile(String gffPath, boolean gffJustfirstline, boolean 
            gffFirstcap) throws IOException {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(gffPath));
            text = br.readLine();
            if(gffJustfirstline == false) {
                StringBuilder sb = new StringBuilder();
                text = br.readLine();
                while(text != null) {
                    sb.append(text).append("\n");
                    text = br.readLine();
                }
            } else {
                br.close();
            }
        } catch(IOException ex) {
            logFile("severe","1stLine Error.\nIOEx: " + ex.toString());
        }
        if(gffFirstcap == true) {
            text = capFirstLetter(text);
        }
        if(text == null || text.isEmpty() || text == "") {
            text = "default";
        }
        return text;
    }
    
    private String capFirstLetter(String string) {
        char ch = string.charAt(0);
        String newString = String.valueOf(ch).toUpperCase() + string.substring(1
                , string.length());
        return newString;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String log) throws IOException {
        try {
            new LogWriter().writeLog(type,log);
        } catch(IOException ioex) {
            logFile("severe","logFile Method error:  Cannot fine log file (infi"
                    + "nite loop)!\nException:  " + ioex);
        }
    }
    //</editor-fold>   
}
