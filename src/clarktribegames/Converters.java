package clarktribegames;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

public class Converters {
    
    public static List<String> resourcefileToList(String resFile) throws 
        IOException {
        String convertedString;
        InputStream stream = null;
        ByteArrayOutputStream resStreamOut = null;
        try {
            stream = ChecksBalances.class.getResourceAsStream(resFile);
            if(stream == null) {
                logFile("severe","Resource to List.  Dir:  " + resFile);
            }
            int readBytes;
            byte[] buffer = new byte[4096];
            resStreamOut = new ByteArrayOutputStream();
            while ((readBytes = stream.read(buffer)) > 0) {
                resStreamOut.write(buffer, 0, readBytes);
            }
        } catch (IOException ex) {
            logFile("severe","Resource to List.  IOEx: " + ex.toString());
        } finally {
            convertedString = new String(resStreamOut.toByteArray());
            stream.close();
            resStreamOut.close();
        }
        List<String> convertedList = Stream.of(convertedString.split(",", -1)).
                collect(Collectors.toList());
        return convertedList;
    }
    
    public static List<String> filelistToList(String ogFile, String delim)
            throws IOException {
        File file = new File(ogFile);
        Scanner input = new Scanner(file);
        List<String> filetoList = new ArrayList<>();
        while(input.hasNextLine()) {
            filetoList.add(input.nextLine());
        }
        return filetoList;
    }
    
    public static String listtoString(List<String> ogList) {
        String[] stringlistArray = ogList.toArray(new String[0]);
        String stringList1 = Arrays.toString(stringlistArray);
        String stringList2 = stringList1.replaceAll("\\[", "");
        String stringList3 = stringList2.replaceAll("\\]", "");
        return stringList3.replaceAll(", ", "\n");
    }
    
    public static String capFirstLetter(String tobeconvertedtoCap) {
        char ch = tobeconvertedtoCap.charAt(0);
        String convertedString = String.valueOf(ch).toUpperCase() + 
                tobeconvertedtoCap.substring(1, tobeconvertedtoCap.length());
        return convertedString;
    }
    
    public static List<Path> foldertoList(String dir, String ext) throws 
        IOException {
        List<Path> result = new ArrayList<>();
        String extension = "." + ext;
        try (Stream<Path> walk = Files.walk(Paths.get(dir))) {
            result = walk.filter(Files::isRegularFile).filter(x -> x.getFileName
                ().toString().endsWith(extension)).collect(Collectors.toList());
        } catch (IOException ex) {
            logFile("severe","Folder To List Converter, Ex:" + ex.toString());
        }
        return result;
    }
    
    public static String filenamefromPath(File absolutepath, boolean noExtension
        ) {
        int absEnd = absolutepath.getAbsolutePath().length();
        if(noExtension) {
            absEnd = absolutepath.getAbsolutePath().lastIndexOf(".");
        }
        String filename = (absolutepath.getAbsolutePath().substring(absolutepath.
            getAbsolutePath().lastIndexOf("\\")+1,absEnd));
        return filename;
    }
    
    public static String getfromFile(String gffPath, boolean gffJustfirstline, boolean 
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
    
    public static Color figureoutColor(String color) {
        Color retColor = Color.black;
        if(color.toLowerCase().equals("red")) {
            retColor = Color.red;
        }
        if(color.toLowerCase().equals("green")) {
            retColor = new Color(0, 102, 0);
        }
        if(color.toLowerCase().equals("orange")) {
            retColor = Color.orange;
        }
        if(color.toLowerCase().equals("purple")) {
            retColor = Color.magenta;
        }
        if(color.toLowerCase().equals("blue")) {
            retColor = Color.blue;
        }
        if(color.toLowerCase().equals("pink")) {
            retColor = Color.pink;
        }
        if(color.toLowerCase().equals("brown")) {
            retColor = new Color(102, 51, 0);
        }
        if(color.toLowerCase().equals("dark brown")) {
            retColor = new Color(51, 0, 0);
        }
        if(color.toLowerCase().equals("dark red")) {
            retColor = new Color(153, 0, 0);
        }
        if(color.toLowerCase().equals("dark blue")) {
            retColor = new Color(0, 0, 204);
        }
        if(color.toLowerCase().equals("light blue")) {
            retColor = new Color(51, 153, 255);
        }
        if(color.toLowerCase().equals("cyan")) {
            retColor = Color.cyan;
        }
        return retColor;
    }
    
    public static String convertstatSign(String status) {
        String newstatus = status;
        if(status.contains("+")) {
            newstatus = status.replaceAll("+","<b>Strong Against ") + "</b>";
        }
        if(status.contains("-")) {
            newstatus = status.replaceAll("-","<i>Strong Against ") + "</i>";
        }
        if(status.contains("±")) {
            newstatus = status.replaceAll("±","<b>Absorbs ") + "</b>";
        }
        return newstatus;
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
