package clarktribegames;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;




// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class GetStats {
    
    public static List<String> getStats(String type, List<String> toonstats, 
        double XPratio, boolean forNewGame) throws SQLException, IOException {
        String currentSavename = (Converters.capFirstLetter((MainControls.
            selectedSave).substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt))));
        switch(type) {
            case "Toon" :
            {
                try {
                    return getToonStats(currentSavename,toonstats,XPratio, 
                        forNewGame);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            case "Effects" :
                return getEffectStats(currentSavename,toonstats);
            case "Abls" :
                return getAblStats(currentSavename,toonstats);
            default :
                return null;
        }
    }
    
    private static List<String> getToonStats(String savename, List<String> 
        toonstats,double XPratio, boolean forNewGame) throws SQLException, 
        IOException {
        double lvl = Double.parseDouble(toonstats.get(8)) + XPratio;
        List<String> racestats=statEncoder(GetData.dbQuery(savename,"*","dbRace"
            ,"raceID",toonstats.get(2),false).get(6),Converters.createBlank("0",
            30));
        List<String> classstats=statEncoder(GetData.dbQuery(savename,"*",
            "dbClass","classID",toonstats.get(3),false).get(3),Converters
            .createBlank("0",30));
        List<String> alignstats=statEncoder(GetData.dbQuery(savename,"*",
            "dbAlign","alignID",Calculator.getAlign(Integer.parseInt(
            toonstats.get(4))),false).get(4),Converters.createBlank("0",30));
        List<String> gendstats=statEncoder(GetData.dbQuery(savename, "*",
            "dbGender","genderID",toonstats.get(6),false).get(3),Converters
            .createBlank("0",30));    
        List<String> sizestats=statEncoder(GetData.dbQuery(savename, "*",
            "dbSize","sizeName", (Calculator.getSize((GetData.dbQuery(savename, 
            "*","dbRace","raceID",toonstats.get(2), false)).get(1),(Calculator.
            getAge(Integer.parseInt(toonstats.get(7)),toonstats.get(2))))),false
            ).get(3),Converters.createBlank("0",30));
//        List<String> racestats = Arrays.asList((GetData.dbQuery(savename,"*","d"
//            + "bRace","raceID",toonstats.get(2),false).get(6)).split("x"));
//        List<String> classstats = Arrays.asList((GetData.dbQuery(savename, "*",
//            "dbClass","classID",toonstats.get(3),false).get(3)).split("x"));
//        List<String> alignstats = Arrays.asList((GetData.dbQuery(savename, "*",
//            "dbAlign","alignID",Calculator.getAlign(Integer.parseInt(
//            toonstats.get(4))),false).get(4)).split("x"));
        String nul = toonstats.get(5);

//        List<String> gendstats = Arrays.asList((GetData.dbQuery(savename, "*",
//            "dbGender","genderID",toonstats.get(6),false).get(3)).split("x"));
//        List<String> sizestats = Arrays.asList((GetData.dbQuery(savename, "*",
//            "dbSize","sizeName", (Calculator.getSize((GetData.dbQuery(savename, 
//            "*","dbRace","raceID",toonstats.get(2), false)).get(1),(Calculator.
//            getAge(Integer.parseInt(toonstats.get(7)),toonstats.get(2))))),false
//            ).get(3)).split("x"));
        String age = toonstats.get(7);

        double ageadjuster = Calculator.getageAdjuster(Double.parseDouble(age) /
            Double.parseDouble(GetData.dbQuery(savename, "*", "dbRace","raceID",
            toonstats.get(2),false).get(5)));

        List<String> basestatslist = new ArrayList<>();
        for(int r = 0; r <= 29; r++ ) {
            if(r>7 && r<25) {
            double baserate = (lvl * ageadjuster);
            double racestat = baserate + statDecoder(baserate, racestats.get(r));
            double classstat = baserate + statDecoder(baserate, classstats.get(r));
            double alignstat = baserate + statDecoder(baserate, alignstats.get(r));
            double gendstat = baserate + statDecoder(baserate, gendstats.get(r));
            double sizestat = baserate + statDecoder(baserate, sizestats.get(r));
//            basestatslist.add(String.valueOf((int)(lvl * (ageadjuster * (Double.
//                parseDouble(racestats.get(r))) + (Double.parseDouble(classstats.
//                get(r))) + (Double.parseDouble(alignstats.get(r))) + Double.
//                parseDouble(gendstats.get(r)) + Double.parseDouble(sizestats.get
//                (r))))));
            basestatslist.add(String.valueOf((int) (baserate + (racestat + classstat + alignstat + gendstat + sizestat))));
            } else {
                basestatslist.add("0");
            }
        
//        (String.valueOf((int)(lvl * (ageadjuster * (Double.
//                parseDouble(racestats.get(r))) + (Double.parseDouble(classstats.
//                get(r))) + (Double.parseDouble(alignstats.get(r))) + Double.
//                parseDouble(gendstats.get(r)) + Double.parseDouble(sizestats.get
//                (r))))));
        }
        //the next line is for reputation -- update at some point
        //basestatslist.add(String.valueOf((int)(lvl*(ageadjuster*1))));
        if(forNewGame) {
            List<String> charmlist = getitemStats(savename,"Charm",toonstats,basestatslist);
            List<String> wearlist = getitemStats(savename,"Wear",toonstats,basestatslist);
            List<String> heldlist = getitemStats(savename,"Held",toonstats,basestatslist);
            
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.size(); x++) {
                double total = Double.parseDouble(basestatslist.get(x)) + Double.parseDouble(charmlist.get(x)) + Double.parseDouble(wearlist.get(x)) + Double.parseDouble(heldlist.get(x));
                combined.add(String.valueOf((int) total));
            }
            
            String templist = Arrays.toString(combined.toArray());
            
//            List<String> firstlist = getitemStats(savename,"Charm",
//                toonstats,(getitemStats(savename,"Wear",toonstats,getitemStats(savename,"Held",toonstats,basestatslist))));
//            String templist = Arrays.toString(firstlist.toArray());
  
            Database db = new DatabaseBuilder().setAutoSync(false).setFile(new 
                File(MainControls.savesDir + Converters.capFirstLetter
                ((MainControls.selectedSave)))).open();
            Table tbl = db.getTable(("sav" + ("dbToons".replaceAll("db", 
                MainControls.currentgame))).replaceAll("Toons", "Temp"));
            tbl.addRow(toonstats.get(0), (templist.substring(1,templist.length()-1)).replaceAll(", ","x"));
            db.close();
            
        
        
            return basestatslist;
        } else {
            List<String> charmlist = getitemStats(savename,"Charm",toonstats,basestatslist);
            List<String> wearlist = getitemStats(savename,"Wear",toonstats,basestatslist);
            List<String> heldlist = getitemStats(savename,"Held",toonstats,basestatslist);
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.size(); x++) {
                double total = Double.parseDouble(basestatslist.get(x)) + Double.parseDouble(charmlist.get(x)) + Double.parseDouble(wearlist.get(x)) + Double.parseDouble(heldlist.get(x));
                combined.add(String.valueOf((int) total));
            }
            return combined;
//        return getitemStats(savename,"Charm",toonstats,(getitemStats(savename,
//            "Wear",toonstats,getitemStats(savename,"Held",toonstats,
//            basestatslist))));
        }
    }
    
    public static void getitemsfromIDtoJList(String save, List<String> list, 
        DefaultListModel dml, JList<String> jlist, String dbname, String 
        searchcol, String matchcol) throws SQLException {
        for(int i = 0; i < list.size(); i++) {
            if(!(ChecksBalances.isNullOrEmpty(list.get(i))) && !(list.get(i).
                equals("null"))) {
                String temp = GetData.dbQuery(save, "*",dbname,searchcol,list.
                    get(i),false).get(1);
                dml.addElement(temp);
            }
        }
         if(dml.getSize() <= 0) {
            dml.addElement("<None>");
            jlist.setEnabled(false);
        } else {
            jlist.setEnabled(true);
        }
        jlist.setModel(dml);
    }

    private static List<String> getEffectStats(String save, List<String>
        toonstats) throws SQLException {
        String sizeName = Calculator.getSize((GetData.dbQuery(save,"*","dbRace",
            "raceID",toonstats.get(2),false)).get(1),(Calculator.getAge(Integer.
            parseInt(toonstats.get(7)),toonstats.get(2))));
        String tooneff = toonstats.get(12);
        String raceeff = GetData.dbQuery(save,"*","dbRace","raceID",toonstats.
            get(2),false).get(9);
        String classeff = GetData.dbQuery(save,"*","dbClass","classID",toonstats
            .get(3),false).get(6);
        String aligneff=GetData.dbQuery(save,"*","dbAlign","alignID",Calculator.
            getAlign(Integer.parseInt(toonstats.get(4))),false).get(8);
        String gendeff=GetData.dbQuery(save,"*","dbGender","genderID",toonstats.
            get(6),false).get(7);
        String sizeeff = GetData.dbQuery(save,"*","dbSize","sizeName",sizeName,
            false).get(6);
        String itemequipped = "";
       for(int c = 13; c <= 15; c++) {
            if(!ChecksBalances.isNullOrEmpty(toonstats.get(c)) && (!(toonstats.
                get(c)).equals("null"))) {
                itemequipped += toonstats.get(c) + "x";
            }
        }
        //fix issue with no items here!
        List<String> itemlist = Arrays.asList(itemequipped.split("x"));
        if(itemequipped.endsWith("x")) {
            itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.
                length() - 1).split("x"));
        } 
        String tempitemeff = "";
        for(int i = 0; i < itemlist.size(); i++) {
            tempitemeff += (GetData.dbQuery(save,"*","dbItems","itemID",itemlist
                .get(i),false).get(12)) + "x";
        }
        String itemeff = tempitemeff;
        if(tempitemeff.endsWith("x")) {
            itemeff = tempitemeff.substring(0, itemeff.length() -1);
        }
        String master = (tooneff+"x"+raceeff+"x"+classeff+"x"+aligneff+"x"+
            gendeff+"x"+sizeeff+"x"+itemeff).replaceAll("null","");
        if((master.replaceAll(",","")).equals("")) {
            master = "0";
        }
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
        return results;
    }

    private static List<String> getAblStats(String save, List<String> toonstats
        ) throws SQLException {
        String sizeName = Calculator.getSize((GetData.dbQuery(save,"*","dbRace",
            "raceID",toonstats.get(2),false)).get(1),(Calculator.getAge(Integer.
            parseInt(toonstats.get(7)),toonstats.get(2))));
        String toonabl = toonstats.get(11);
        String raceabl = GetData.dbQuery(save,"*","dbRace","raceID",toonstats.
            get(2),false).get(8);
        String classabl = GetData.dbQuery(save,"*","dbClass","classID",toonstats
            .get(3),false).get(5);
        String alignabl=GetData.dbQuery(save,"*","dbAlign","alignID",Calculator.
            getAlign(Integer.parseInt(toonstats.get(4))),false).get(7);
        String gendabl=GetData.dbQuery(save,"*","dbGender","genderID",toonstats.
            get(6),false).get(6);
        String sizeabl = GetData.dbQuery(save,"*","dbSize","sizeName",sizeName,
            false).get(5);
        String itemequipped = "";
                for(int c = 13; c <= 15; c++) {
            if(!ChecksBalances.isNullOrEmpty(toonstats.get(c)) && (!(toonstats.
                get(c)).equals("null"))) {
                itemequipped += toonstats.get(c) + "x";
            }
        }
        List<String> itemlist = Arrays.asList(itemequipped.split("x"));
        if(itemequipped.endsWith("x")) {
            itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.
                length() - 1).split("x"));
        } 
        String tempitemabl = "";
        for(int i = 0; i < itemlist.size(); i++) {
            tempitemabl += (GetData.dbQuery(save,"*","dbItems","itemID",itemlist
                .get(i),false).get(11)) + "x";
        }
        String itemabl = tempitemabl;
        if(tempitemabl.endsWith("x")) {
            itemabl = tempitemabl.substring(0, itemabl.length() -1);
        }
        String master=(toonabl+"x"+raceabl+"x"+classabl+"x"+alignabl+"x"+gendabl
            +"x"+sizeabl+"x"+itemabl).replaceAll("null","");
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
        return results;
    }    
    
    public static String getalignColor(int alignValue) throws SQLException {
        return alignColor(alignValue);
    }
    
    private static String alignColor(int alignval) throws SQLException {
        String retVal = "black";
        double alignvalue = (double) alignval;
        if(alignvalue < 13) {
            retVal = "red";
        }
        if(alignvalue >= 13 && alignvalue < 25) {
            retVal = "dark red";
        }
        if(alignvalue >= 25 && alignvalue < 37) {
            retVal = "dark brown";
        }
        if(alignvalue >= 37 && alignvalue < 50) {
            retVal = "brown";
        }
        if(alignvalue == 50) {
            retVal = "black";
        }
        if(alignvalue > 50 && alignvalue <= 63) {
            retVal = "purple";
        }
        if(alignvalue > 63 && alignvalue <= 75) {
            retVal = "dark blue";
        }        
        if(alignvalue >= 63 && alignvalue < 87) {
            retVal = "blue";
        }
        if(alignvalue >= 87) {
            retVal = "light blue";
        }
        return retVal;
    }
    
    public static int greatestNegative(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0) {
                    result = list[i];
            }
        }
        return result;
    }
    
    private static List<String> getitemStats(String save, String type, 
        List<String> toonstats,List<String> baselist) throws SQLException {
        int x = 0;
        if(type.equals("Held")) {
            x = 13;
        } else {
            if(type.equals("Wear")) {
                x = 14;
            } else {
                x = 15;
            }
        }
        List<String> invlist = Arrays.asList(toonstats.get(x).split("x"));
        if(invlist.get(0).contains("null")) {
            return baselist;
        }
        if(invlist.size() > 0 ) {
            for(int i = 0; i  < invlist.size(); i++ ) {
                baselist = processitemStats(baselist,(Arrays.asList((GetData.
                    dbQuery(save,"*","dbItems","itemID",(String.valueOf(invlist.
                    get(i))),false).get(9)).split("x"))));
            }
        }
        return baselist;
    }
    
    private static List<String> processitemStats(List<String> baselist, List<String> statlist) {
        if(statlist.size() > 0) {
            List<String> processedList = new ArrayList<>();
            for(int j=0 ; j < baselist.size(); j++) {
                processedList.add(baselist.get(j));
            }
            for(int i=0 ; i < statlist.size(); i++) {
                int slot = whichslotforStat(statlist.get(i));
                double number = statDecoder(Double.parseDouble(baselist.get(slot)), statlist.get(i));
                baselist.remove(slot);
                baselist.add(slot,String.valueOf((int) number));
            }
        } else {
            
        }
        return baselist;
    }
    
//    private static List<String> processitemStats(List<String> oglist, 
//        List<String> statlist) {
//  //      System.out.println("OG: " + Arrays.toString(oglist.toArray()));
//        List<String> newlist = statEncoder("0",Converters.createBlank("0", 30));
////        System.out.println("Statlist" + ":" + Arrays.toString(statlist.toArray()));
//        if(statlist.size() > 0) {
//            for(int i = 0; i < statlist.size(); i++) {
//                List<String> itemstats = statEncoder(statlist.get(i),Converters.createBlank("0", 30));
//                for(int j = 0; j < 29; j++) {
//                    double itemstat = statDecoder(Double.parseDouble(oglist.get(j)), itemstats.get(j));
//                    double newval = Double.parseDouble(newlist.get(j)) + itemstat;
//                    newlist.remove(j);
//                    newlist.add(j, String.valueOf(newval));
//                }
//            }
//
//        }
//         //   System.out.println(Arrays.toString(newlist.toArray()));
//            return newlist;            
//    }                
   //og             
//                double newvalue = 0;
//                double finalvalue = 0;
//                if(itemstat.contains("-")) {
//                    newvalue = Double.parseDouble(itemstat.replaceAll("[^\\d]",
//                        "")) * -1;
//                } else {
//                    newvalue = Double.parseDouble(itemstat.replaceAll("[^\\d]",
//                        ""));
//                }
//                if(itemstat.contains("*")) {
//                    finalvalue = Double.parseDouble(oglist.get(i)) * newvalue;
//                } else {
//                    finalvalue = Double.parseDouble(oglist.get(i)) + newvalue;
//                }
//                newlist.add(i, String.valueOf((int) finalvalue));
//                }
//            return newlist;
//            } else {
//            return oglist;
//        }
//    }
    
    private static List<String> statEncoder(String stats, List<String> list) {
        if(ChecksBalances.isNullOrEmpty(stats) || stats.equals("null") || stats
            .equals("0")) {
        } else {
            List<String> templist = Arrays.asList(stats.split("x"));
            for(int x = 0; x < templist.size(); x++) {
                String code;
                switch(templist.get(x).substring(0,2)) {
                    case "AL" :
                        code = "00";
                        break;
                    case "AG" :
                        code = "01";
                        break;
                    case "GE" :
                        code = "02";
                        break;
                    case "SZ" :
                        code = "03";
                        break;
                    case "RC" :
                        code = "04";
                        break;
                    case "CL" :
                        code = "05";
                        break;
                    case "EP" :
                        code = "06";
                        break;
                    case "UI" :
                        code = "07";
                        break;
                    case "HP" :
                        code = "08";
                        break;
                    case "MP" :
                        code = "09";
                        break;
                    case "AP" :
                        code = "10";
                        break;
                    case "AT" :
                        code = "11";
                        break;
                    case "ST" :
                        code = "12";
                        break;
                    case "DF" :
                        code = "13";
                        break;
                    case "SA" :
                        code = "14";
                        break;
                    case "SP" :
                        code = "15";
                        break;
                    case "EV" :
                        code = "16";
                        break;
                    case "DT" :
                        code = "17";
                        break;
                    case "MY" :
                        code = "18";
                        break;
                    case "MD" :
                        code = "19";
                        break;
                    case "ME" :
                        code = "20";
                        break;
                    case "WL" :
                        code = "21";
                        break;
                    case "LU" :
                        code = "22";
                        break;
                    case "CH" :
                        code = "23";
                        break;
                    case "IN" :
                        code = "24";
                        break;
                    case "FA" :
                        code = "25";
                        break;
                    case "SO" :
                        code = "26";
                        break;
                    case "DC" :
                        code = "27";
                        break;
                    case "WM" :
                        code = "28";
                        break;
                    case "RP" :
                        code = "29";
                        break;
                    default :
                        code = null;
                        break;
                }
                list.remove(Integer.parseInt(code));
                list.add(Integer.parseInt(code), templist.get(x));
            }   
        }
        return list;

    }
    
    private static double statDecoder(double base, String code) {
        double retVal = 0;
        if(code.equals("0")) {
        } else {
            double valu = Double.parseDouble(code.substring(4,code.length()));
            switch (code.substring(3,4)) {
                case "C" :
                    switch(code.substring(2,3)) {
                        case "P" :
                            retVal = base + (base * (valu * .01));
                            break;
                        case "N" :
                            retVal = base - (base * (valu * .01));
                            break;
                        case "M" :
                            retVal = base * (base * (valu * .01));
                            break;
                        case "D" :
                            retVal = base / (base * (valu * .01));
                            break;
                        case "S" :
                            retVal = (base * (valu * .01)) - base;
                            break;
                        default :
                            retVal = 0;
                            break;
                    }
                    break;
                case "V" :
                    switch(code.substring(2,3)) {
                        case "P" :
                            retVal = base + valu;
                            break;
                        case "N" :
                            retVal = base - valu;
                            break;
                        case "M" :
                            retVal = base * valu;
                            break;
                        case "D" :
                            retVal = base / valu;
                            break;
                        case "S" :
                            retVal = valu - base;
                            break;
                        default :
                            retVal = 0;
                            break;
                    }
                    break;
                default :
                    retVal = 0;
                    break;
            }
        }
        return retVal;
    }
    
    private static int whichslotforStat(String code) {
        int retVal;
        switch(code.substring(0,2)) {
            case "AL" :
                retVal = 0;
                break;
            case "AG" :
                retVal = 1;
                break;
            case "GE" :
                retVal = 2;
                break;
            case "SZ" :
                retVal = 3;
                break;
            case "RC" :
                retVal = 4;
                break;
            case "CL" :
                retVal = 5;
                break;
            case "EP" :
                retVal = 6;
                break;
            case "UI" :
                retVal = 7;
                break;
            case "HP" :
                retVal = 8;
                break;
            case "MP" :
                retVal = 9;
                break;
            case "AP" :
                retVal = 10;
                break;
            case "AT" :
                retVal = 11;
                break;
            case "ST" :
                retVal = 12;
                break;
            case "DF" :
                retVal = 13;
                break;
            case "SA" :
                retVal = 14;
                break;
            case "SP" :
                retVal = 15;
                break;
            case "EV" :
                retVal = 16;
                break;
            case "DT" :
                retVal = 17;
                break;
            case "MY" :
                retVal = 18;
                break;
            case "MD" :
                retVal = 19;
                break;
            case "ME" :
                retVal = 20;
                break;
            case "WL" :
                retVal = 21;
                break;
            case "LU" :
                retVal = 22;
                break;
            case "CH" :
                retVal = 23;
                break;
            case "IN" :
                retVal = 24;
                break;
            case "FA" :
                retVal = 25;
                break;
            case "SO" :
                retVal = 26;
                break;
            case "DC" :
                retVal = 27;
                break;
            case "WM" :
                retVal = 28;
                break;
            case "RP" :
                retVal = 29;
                break;
            default :
                retVal = -1;
                break;
        }
        return retVal;
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
