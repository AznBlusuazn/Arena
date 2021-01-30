package clarktribegames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class VersionCheck {
    
    public static boolean checkVersion(String installedName, String 
        installedVersion) throws IOException {
        URL webCheck=new URL("http://svr.clarktribegames.com:19762/"+
            installedName+".txt");
        try {
            BufferedReader versionIn=new BufferedReader(
            new InputStreamReader(webCheck.openStream()));
            String currentVersion;
            for(currentVersion=versionIn.readLine(); !(ChecksBalances.
                isNullOrEmpty(currentVersion)); currentVersion=versionIn.
                readLine()) {
                boolean verMatch=currentVersion.contains(installedVersion);
                if(verMatch == true) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (IOException ex) {
            logFile("severe",(webCheck.toString())+" does not exist.\nEx: "+ex);
            return false;
        }
        return false;
    }
    
    public static String versionNotes()  {
        String str="";
        String superstr="";
        try {
            String readmeURL=
                "https://github.com/AznBlusuazn/Arena/raw/master/README.txt";
            URL webCheck=new URL(readmeURL);
            BufferedReader in=new BufferedReader(
            new InputStreamReader(webCheck.openStream()));

            while ((str=in.readLine()) != null) {
                    str=in.readLine();
                    superstr+= str+"\n";
            }
        in.close();
        } catch (IOException ex) {
            try {
                StringBuilder contentBuilder=new StringBuilder();
                try (Stream<String> stream=Files.lines(Paths.get("README.txt"),
                    GetData.determineCharset(Paths.get("README.txt"))))
                {
                    stream.forEach(s -> contentBuilder.append(s).append("\n"));
                }
                superstr=contentBuilder.toString();
            } catch (IOException ex2) {
                superstr="XXXXXXXXXXXXXXXXX\n\n[CURRENT UPDATE]\n\n"+
                    MainControls.appTitle.substring(MainControls.appName.
                    length()+2,MainControls.appTitle.length()-1)+"-0000\n\n"+
                    "- No update notes available at this time.";
            }
        }
        String version=superstr.substring(superstr.indexOf("[CURRENT UPDATE")+17
            ,superstr.indexOf("-",superstr.indexOf("[CURRENT UPDATE]")+49));
        String notes="";
        try {
            notes=superstr.substring(((superstr.indexOf(version))+version.length
                ()),(superstr.indexOf("[PREVIOUS UPDATES]")));
        } catch (StringIndexOutOfBoundsException ex) {
            notes="- No update notes available at this time.";
        }
        return MainControls.appName.toUpperCase()+" "+version+"\n"+
            "by: ClarkTribeGames"+"\n\n"+"Release Notes:"+"\n\n"+notes;
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