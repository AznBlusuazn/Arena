package clarktribegames;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
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
    
    public static List<String> subfolderstoList(String dir) throws IOException {
        return Arrays.asList(new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        }));
    }
    
    public static String filenamefromPath(File absolutepath, boolean noExtension
        ) {
        int absEnd = absolutepath.getAbsolutePath().length();
        if(noExtension) {
            absEnd = absolutepath.getAbsolutePath().lastIndexOf(".");
        }
        String filename = (absolutepath.getAbsolutePath().substring(absolutepath
            .getAbsolutePath().lastIndexOf("\\")+1,absEnd));
        return filename;
    }
    
    public static String getSpecificLine(String getpath, int getline) throws 
        IOException {
        return Files.readAllLines(Paths.get(getpath)).get(getline);
    }
    
    public static String getfromFile(String gffPath, boolean gffJustfirstline, 
        boolean gffFirstcap) throws IOException {
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
    
    public static void savelisttoFile(List<String> listtoSave,String savePath) 
        throws IOException {
        try (FileWriter writer = new FileWriter(savePath, true)) {
            String convertedList=listtoString(listtoSave).replaceAll("\n","x");
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw);
            out.println(convertedList);
            out.close();
            }
    }
    
    public static List<String> capStringList(List<String> listtoCap) {
        if(listtoCap.size() > 0) {
            for (int index = 0; index < listtoCap.size(); index++) {
                String name = listtoCap.get(index);
                String[] names = name.split("\\s+");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < names.length; i++) {
                    if (i != 0) {
                        sb.append(' ');
                    }
                    sb.append(Character.toUpperCase(names[i].charAt(0)));
                    sb.append(names[i].substring(1).toLowerCase());
                }
                listtoCap.set(index, sb.toString());
            }
        }
        return listtoCap;
    }
    
    public static List<String> createBlank(String defstring, int rows) {
        List<String> newlist = new ArrayList<>();
        for(int i = 0; i< rows; i++) {
            newlist.add("0");
        }
        return newlist;
    }
    
    public static String[] convertTime(int rawTime) {
        //60 minutes in an hour
        //1440 mins in a day
        //10080 mins in a week
        //40320 mins in a month
        //483840 mins in a year
        int years = 1;
        int months = 1;
        int weeks = 1;
        int days = 1;
        int hours = 0;
        int minutes = 0;
        if(rawTime >= 483840) {
            years = rawTime / 483840;
            months = (rawTime - (years * 483840)) / 40320;
            weeks = (rawTime - ((years * 483840) + (months * 40320))) / 10080;
            days = (rawTime - ((years * 483840) + (months * 40320) + (weeks * 
                10080))) / 1440;
            hours = (rawTime - ((years * 483840) + (months * 40320) + (weeks * 
                10080) + (days * 1440))) / 60;
            minutes = (rawTime - ((years * 483840) + (months * 40320) + (weeks *
                10080 + (days * 1440) + (hours * 60))));
        }
        if(rawTime < 483840 && rawTime >= 40320) {
            years = 1;
            months = rawTime / 40320;
            weeks = (rawTime - (months * 40320)) / 10080;
            days = (rawTime - ((months * 40320) + (weeks * 10080))) / 1440;
            hours = (rawTime - ((months * 40320) + (weeks * 10080) + (days * 
                1440))) / 60;
            minutes = (rawTime - ((months * 40320) + (weeks * 10080 + (days * 
                1440) + (hours * 60))));
        }
        if(rawTime < 40320 && rawTime >= 10080) {
            years = 1;
            months = 1;
            weeks = rawTime / 10080;
            days = (rawTime - (weeks * 10080)) / 1440;
            hours = (rawTime - ((weeks * 10080) + (days * 1440))) / 60;
            minutes = (rawTime - ((weeks * 10080 + (days * 1440) + (hours * 
                60))));
        }
        if(rawTime < 10080 && rawTime >= 1440) {
            years = 1;
            months = 1;
            weeks = 1;
            days = rawTime / 1440;
            hours = (rawTime - (days * 1440)) / 60;
            minutes = rawTime - ((days * 1440) + (hours * 60));
        }
        if(rawTime < 1440 && rawTime >= 60) {
            years = 1;
            months = 1;
            weeks = 1;
            days = 1;
            hours = rawTime / 60;
            minutes = rawTime - (hours * 60);
        }
            years += 1;
            months += 1;
            weeks += 1;
            days += 1;
            hours += 1;
            if(minutes > 60) {
                minutes = 0;
                hours += 1;
            }
            if(hours > 24) {
                hours = 0;
                days += 1;
            }
            if(days > 7) {
                days = 1;
                weeks += 1;
            }
            if(weeks > 4) {
                weeks = 1;
                months += 1;
            }
            if(months > 12) {
                months = 1;
                years += 1;
            }
            return new String[] { String.valueOf(years),String.valueOf(months),
                String.valueOf(weeks),String.valueOf(days),String.valueOf(hours)
                ,String.valueOf(minutes) };
    }
    
    public static void dbtabletoFile(String table, String icol, String dest) 
        throws SQLException, IOException, InterruptedException {
        ChecksBalances.newfileCheck(dest, true, "", true);
        int tableLines=GetData.dataQuery("*",table,icol,null,true,false,null,
            null).size();
        for(int index = 0; index < tableLines; index++) {
            List<String> tabledata=GetData.dataQuery("*",table,icol,String.
                valueOf(index),false,false,null,null);
            String rawdata = Arrays.toString(tabledata.toArray());
            try {
                Files.write(Paths.get(dest),
                    (rawdata.substring(1, rawdata.length()-1).replaceAll(", ",
                        ",").replaceAll("null", "")+"\n").getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException ex) {
                //
            }
        }   
    }

    
    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException
        {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile cannot fine log file (infinite loop)!");
        }
    }
    //</editor-fold>
}