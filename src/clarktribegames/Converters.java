package clarktribegames;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
