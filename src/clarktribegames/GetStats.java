package clarktribegames;

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
    
    public static List<String> getStats(String type, String[] toonstats, 
        double XPratio, boolean forNewGame) throws SQLException, IOException {
        return getToonStats(toonstats,XPratio,forNewGame);
    }
    
    public static String[] getAEStats(String type,String[] toonstats) throws 
        SQLException {
        switch(type) {
            case "Effects" :
                return getEffectStats(toonstats);
            case "Abls" :
                return getAblStats(toonstats);
            default :
                return null;
        }
    }

    private static List<String> getToonStats(String[] toonstats,double XPratio,
        boolean forNewGame) throws SQLException, 
        IOException {
        double lvl = Double.parseDouble(toonstats[8]) + XPratio;
        List<String> racestats=statEncoder(Converters.fetchfromTable(MemoryBank.
            dbRace,toonstats[2],0,6),Converters.createBlank("0",30));
        List<String> classstats=statEncoder(Converters.fetchfromTable(MemoryBank
            .dbClass,toonstats[3],0,3),Converters.createBlank("0",30));
        List<String> alignstats=statEncoder(Converters.fetchfromTable(MemoryBank
            .dbAlign,Calculator.getAlign(Integer.parseInt(toonstats[4])),0,4),
            Converters.createBlank("0",30));
        List<String> gendstats=statEncoder(Converters.fetchfromTable(MemoryBank.
            dbGender,toonstats[6],0,3),Converters.createBlank("0",30));
        String raceSize=Converters.fetchfromTable(MemoryBank.dbRace,toonstats[2]
            ,0,1);
        List<String> sizestats=statEncoder(Converters.fetchfromTable(MemoryBank.
            dbSize,Calculator.getSize(raceSize,(Calculator.getAge(Integer.
            parseInt(toonstats[7]),toonstats[2]))),1,3),Converters.createBlank(
            "0",30));

        String nul = toonstats[5];
        String age = toonstats[7];

        double ageadjuster = Calculator.getageAdjuster(Double.parseDouble(age) /
            Double.parseDouble(Converters.fetchfromTable(MemoryBank.dbRace,
            toonstats[2],0,5)));

        List<String> basestatslist = new ArrayList<>();
        for(int r = 0; r <= 29; r++ ) {
            if(r>7 && r<25) {
            double baserate = (lvl * ageadjuster);
            double racestat = baserate + statDecoder(baserate,racestats.get(r));
            double classstat = baserate+statDecoder(baserate,classstats.get(r));
            double alignstat = baserate+statDecoder(baserate,alignstats.get(r));
            double gendstat = baserate + statDecoder(baserate,gendstats.get(r));
            double sizestat = baserate + statDecoder(baserate,sizestats.get(r));
            basestatslist.add(String.valueOf((int)(baserate+(racestat+classstat+
                alignstat+gendstat+sizestat))));
            } else {
                basestatslist.add("0");
            }
        }
        if(forNewGame) {
            String[] charmlist = getitemStats("Charm",toonstats,basestatslist);
            String[] wearlist = getitemStats("Wear",toonstats,basestatslist);
            String[] heldlist = getitemStats("Held",toonstats,basestatslist);
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.length; x++) {
                double total = Double.parseDouble(basestatslist.get(x)) + Double
                    .parseDouble(charmlist[x]) + Double.parseDouble(wearlist
                    [x]) + Double.parseDouble(heldlist[x]);
                combined.add(String.valueOf((int) total));
            }
            String templist = Arrays.toString(combined.toArray());
            
            MemoryBank.savTemp.add((toonstats[0]+","+(templist.substring(1,
                templist.length()-1))+"\n").replaceAll(" ",""));
            return basestatslist;
        } else {
            String[] charmlist = getitemStats("Charm",toonstats,basestatslist);
            String[] wearlist = getitemStats("Wear",toonstats,basestatslist);
            String[] heldlist = getitemStats("Held",toonstats,basestatslist);
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.length; x++) {
                double total = Double.parseDouble(basestatslist.get(x)) + Double
                    .parseDouble(charmlist[x]) + Double.parseDouble(wearlist
                    [x]) + Double.parseDouble(heldlist[x]);
                combined.add(String.valueOf((int) total));
            }
            return combined;
        }
    }    

    public static void getitemsfromIDtoJList(List<String> list, 
        DefaultListModel dml, JList<String> jlist,List<String> table,int 
        matchcol,int fetchcol) throws SQLException {
        for(int i = 0; i < list.size(); i++) {
            if(!(ChecksBalances.isNullOrEmpty(list.get(i)))) {
                String temp = Converters.fetchfromTable(table,list.get(i),
                    matchcol,fetchcol);
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

    public static String getitemsfromIDtoString(String[] list,List<String> table
        ,int matchcol,int fetchcol) throws SQLException {
        String finalString = "";
        DefaultListModel tempdml = new DefaultListModel();

        for(int i = 0; i < list.length; i++) {
            if(!(ChecksBalances.isNullOrEmpty(list[i]))) {
                String temp = Converters.fetchfromTable(table,list[i],
                    matchcol,fetchcol);
                tempdml.addElement(temp);
                finalString+=temp + "\n";
            }
        }
        

//*
//        
//        for(int i = 0; i < list.size(); i++) {
//            if(!(ChecksBalances.isNullOrEmpty(list.get(i)))) {
//                String temp = GetData.dataQuery("*",dbname,searchcol,list.
//                    get(i),false,false,null,null).get(1);
//                tempdml.addElement(temp);
//                finalString+=temp + "\n";
//            }
//        }
//        
//*        
        
         if(tempdml.getSize() <= 0) {
            finalString+="<None>";
        }
        return finalString;
    }
    
    private static String[] getEffectStats(String[] toonstats) throws 
        SQLException {
        String sizeName=Calculator.getSize(Converters.fetchfromTable(MemoryBank.
            dbRace,toonstats[2],0,1),(Calculator.getAge(Integer.parseInt(
            toonstats[7]),toonstats[2])));
        String tooneff = toonstats[12];
        String raceeff=Converters.fetchfromTable(MemoryBank.dbRace,toonstats[2],
            0,9);
        String classeff=Converters.fetchfromTable(MemoryBank.dbClass,toonstats
            [3],0,6);
        String aligneff=Converters.fetchfromTable(MemoryBank.dbAlign,Calculator
            .getAlign(Integer.parseInt(toonstats[4])),0,8);
        String gendeff=Converters.fetchfromTable(MemoryBank.dbGender,toonstats
            [6],0,7);
        String sizeef=Converters.fetchfromTable(MemoryBank.dbSize,sizeName,1,6);
        String itemequipped = "";
       for(int c = 13; c <= 15; c++) {
            if(!ChecksBalances.isNullOrEmpty(toonstats[c])) {
                itemequipped += toonstats[c] + "x";
            }
        }
        String itemeff;
        if(!ChecksBalances.isNullOrEmpty(itemequipped)) {
            List<String> itemlist = Arrays.asList(itemequipped.split("x"));
            if(itemequipped.endsWith("x")) {
                itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.
                    length() - 1).split("x"));
            } 
            String tempitemeff = "";
            for(int i = 0; i < itemlist.size(); i++) {
                tempitemeff += Converters.fetchfromTable(MemoryBank.dbItems,
                    itemlist.get(i),0,12)+"x";
            }
            itemeff = tempitemeff;
            if(tempitemeff.endsWith("x")) {
                itemeff = tempitemeff.substring(0, itemeff.length() -1);
            }
        } else {
            itemeff = "";
        }
        String master = (tooneff+"x"+raceeff+"x"+classeff+"x"+aligneff+"x"+
            gendeff+"x"+sizeef+"x"+itemeff).replaceAll("null","");
        if((master.replaceAll(",","")).equals("")) {
            master = "0";
        }
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
        return results.toArray(new String[0]);
    }

    private static String[] getAblStats(String[] toonstats) throws SQLException{
        String raceSize=Converters.fetchfromTable(MemoryBank.dbRace,toonstats[2]
            ,0,1);
        String sizeName=Calculator.getSize(raceSize,(Calculator.getAge(Integer.
            parseInt(toonstats[7]),toonstats[2])));
        String toonabl = toonstats[11];
        String raceabl=Converters.fetchfromTable(MemoryBank.dbRace,toonstats[2],
            0,8);
        String classabl=Converters.fetchfromTable(MemoryBank.dbClass,toonstats
            [3],0,5);
        String alignabl=Converters.fetchfromTable(MemoryBank.dbAlign,Calculator.
            getAlign(Integer.parseInt(toonstats[4])),0,7);
        String gendabl=Converters.fetchfromTable(MemoryBank.dbGender,toonstats
            [6],0,6);
        String sizeab=Converters.fetchfromTable(MemoryBank.dbSize,sizeName,1,5);
        String itemequipped = "";
        for(int c = 13; c <= 15; c++) {
            if(!ChecksBalances.isNullOrEmpty(toonstats[c])) {
                itemequipped += toonstats[c] + "x";
            }
        }
        String itemabl;
        if(!ChecksBalances.isNullOrEmpty(itemequipped)) {                
            List<String> itemlist = Arrays.asList(itemequipped.split("x"));
            if(itemequipped.endsWith("x")) {
                itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.
                    length() - 1).split("x"));
            } 
            String tempitemabl = "";
            for(int i = 0; i < itemlist.size(); i++) {
                tempitemabl += Converters.fetchfromTable(MemoryBank.dbItems,
                    itemlist.get(i),0,11)+"x";
            }
            itemabl = tempitemabl;
            if(tempitemabl.endsWith("x")) {
                itemabl = tempitemabl.substring(0, itemabl.length() -1);
            }
        } else {
            itemabl = "";
        }
        String master=(toonabl+"x"+raceabl+"x"+classabl+"x"+alignabl+"x"+gendabl
            +"x"+sizeab+"x"+itemabl).replaceAll("null","");
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
        return results.toArray(new String[0]);
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
    
    public static String[] fetchitemStats(String type,String[] toonstats,
        List<String> baselist) throws SQLException {
        return getitemStats(type,toonstats,baselist);
    }
    
    private static String[] getitemStats(String type,String[] toonstats,
        List<String> baselist) throws SQLException {
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
        String[] invlist = toonstats[x].split("x");
        if(ChecksBalances.isNullOrEmpty(invlist[0])||invlist[0].contains("null")
            ) {
            return baselist.toArray(new String[0]);
        }
        if(invlist.length > 0 ) {
            for(int i = 0; i  < invlist.length; i++ ) {
                baselist = processitemStats(baselist,(Arrays.asList((Converters.
                    fetchfromTable(MemoryBank.dbItems,String.valueOf(invlist[i])
                    ,0,9).split("x")))));
            }
        }
        return baselist.toArray(new String[0]);
    }
    
    private static List<String> processitemStats(List<String> baselist, 
        List<String> statlist) {
        if(statlist.size() > 0) {
            List<String> processedList = new ArrayList<>();
            for(int j=0 ; j < baselist.size(); j++) {
                processedList.add(baselist.get(j));
            }
            for(int i=0 ; i < statlist.size(); i++) {
                int slot = whichslotforStat(statlist.get(i));
                double number=statDecoder(Double.parseDouble(baselist.get(slot))
                    , statlist.get(i));
                baselist.remove(slot);
                baselist.add(slot,String.valueOf((int) number));
            }
        } else {
            
        }
        return baselist;
    }
    
    private static List<String> statEncoder(String stats, List<String> list) {
        if(ChecksBalances.isNullOrEmpty(stats) || stats.equals("0")) {
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
    
    public static String[] getAblStat(String type, String code) {
        switch(type) {
            case "c" :
                return getAblCost(code);
            case "t" :
                return getAblTarget(code);
            case "i" :
                return getAblCost(code);
            case "b" :
                return getAblBase(code);
            case "e" :
                if(ChecksBalances.isNullOrEmpty(code)) {
                    return new String[] {""};
                } else {
                    return new String[] {code};
                }
            default :
                return null;
        }
    }
    
    private static String[] getAblCost(String code) {
        String type;
        switch(code.substring(0,2)) {
            case "AL" :
                type = "00";
                break;
            case "AG" :
                type = "01";
                break;
            case "GE" :
                type = "02";
                break;
            case "SZ" :
                type = "03";
                break;
            case "RC" :
                type = "04";
                break;
            case "CL" :
                type = "05";
                break;
            case "EP" :
                type = "06";
                break;
            case "UI" :
                type = "07";
                break;
            case "HP" :
                type = "08";
                break;
            case "MP" :
                type = "09";
                break;
            case "AP" :
                type = "10";
                break;
            case "AT" :
                type = "11";
                break;
            case "ST" :
                type = "12";
                break;
            case "DF" :
                type = "13";
                break;
            case "SA" :
                type = "14";
                break;
            case "SP" :
                type = "15";
                break;
            case "EV" :
                type = "16";
                break;
            case "DT" :
                type = "17";
                break;
            case "MY" :
                type = "18";
                break;
            case "MD" :
                type = "19";
                break;
            case "ME" :
                type = "20";
                break;
            case "WL" :
                type = "21";
                break;
            case "LU" :
                type = "22";
                break;
            case "CH" :
                type = "23";
                break;
            case "IN" :
                type = "24";
                break;
            case "FA" :
                type = "25";
                break;
            case "SO" :
                type = "26";
                break;
            case "DC" :
                type = "27";
                break;
            case "WM" :
                type = "28";
                break;
            case "RP" :
                type = "29";
                break;
            default :
                type = null;
                break;
        }
        return new String [] {type, code.substring(2,3), code.substring(3,4), 
            code.substring(4,code.length())};
    }
    
    private static String [] getAblTarget(String target) {
        List<String> targets = new ArrayList<>();
        if(target.contains("S")) {
            targets.add("Self");
        }
        if(target.contains("T")) {
            targets.add("Target");
        }
        if(target.contains("A")) {
            targets.add("Allies");
        }
        if(target.contains("M")) {
            targets.add("Multiple");
        }
        if(target.contains("E")) {
            targets.add("Everyone");
        }
        return targets.toArray(new String[0]);
    }

    private static String[] getAblBase(String code) {
        String type;
        switch(code) {
            case "AL" :
                type = "00";
                break;
            case "AG" :
                type = "01";
                break;
            case "GE" :
                type = "02";
                break;
            case "SZ" :
                type = "03";
                break;
            case "RC" :
                type = "04";
                break;
            case "CL" :
                type = "05";
                break;
            case "EP" :
                type = "06";
                break;
            case "UI" :
                type = "07";
                break;
            case "HP" :
                type = "08";
                break;
            case "MP" :
                type = "09";
                break;
            case "AP" :
                type = "10";
                break;
            case "AT" :
                type = "11";
                break;
            case "ST" :
                type = "12";
                break;
            case "DF" :
                type = "13";
                break;
            case "SA" :
                type = "14";
                break;
            case "SP" :
                type = "15";
                break;
            case "EV" :
                type = "16";
                break;
            case "DT" :
                type = "17";
                break;
            case "MY" :
                type = "18";
                break;
            case "MD" :
                type = "19";
                break;
            case "ME" :
                type = "20";
                break;
            case "WL" :
                type = "21";
                break;
            case "LU" :
                type = "22";
                break;
            case "CH" :
                type = "23";
                break;
            case "IN" :
                type = "24";
                break;
            case "FA" :
                type = "25";
                break;
            case "SO" :
                type = "26";
                break;
            case "DC" :
                type = "27";
                break;
            case "WM" :
                type = "28";
                break;
            case "RP" :
                type = "29";
                break;
            default :
                type = "NA";
                break;
        }
        return new String [] {type};
    }    
    
    public static List<String> findeffCriteria (String code) {
        return effectCritDecoder(code);
    }
    
    private static List<String> effectCritDecoder (String code) {
        List<String> ors = new ArrayList<>(Arrays.asList(code.split("z")));
            for(int i = 0; i < ors.size(); i++ ) {
                if(ors.get(i).contains("x")) {
                    List<String> temp = new ArrayList<>(Arrays.asList(ors.get(i)
                        .split("x")));
                        for(int j = 0; j < temp.size(); j++) {
                            String newtemp=effectCritCode(temp.get(j).substring
                                (0,1))+temp.get(j).substring(2,temp.get(j).
                                length());
                            temp.remove(j);
                            temp.add(j,newtemp);
                        }
                    String newtemp = Arrays.toString(temp.toArray());
                    String newlist = newtemp.substring(1,newtemp.length() -1).
                        replaceAll(", ","x");
                    ors.remove(i);
                    ors.add(i, newlist);
                } else {
                    String newtemp=effectCritCode(ors.get(i).substring(0,1))+
                        ors.get(i).substring(2,ors.get(i).length());
                    ors.remove(i);
                    ors.add(i,newtemp);
                }
            }
        return ors;
    }
    
    private static String effectCritCode (String code) {
        String type;
        switch(code) {
            case "AL" :
                type = "00";
                break;
            case "AG" :
                type = "01";
                break;
            case "GE" :
                type = "02";
                break;
            case "SZ" :
                type = "03";
                break;
            case "RC" :
                type = "04";
                break;
            case "CL" :
                type = "05";
                break;
            case "EP" :
                type = "06";
                break;
            case "UI" :
                type = "07";
                break;
            case "HP" :
                type = "08";
                break;
            case "MP" :
                type = "09";
                break;
            case "AP" :
                type = "10";
                break;
            case "AT" :
                type = "11";
                break;
            case "ST" :
                type = "12";
                break;
            case "DF" :
                type = "13";
                break;
            case "SA" :
                type = "14";
                break;
            case "SP" :
                type = "15";
                break;
            case "EV" :
                type = "16";
                break;
            case "DT" :
                type = "17";
                break;
            case "MY" :
                type = "18";
                break;
            case "MD" :
                type = "19";
                break;
            case "ME" :
                type = "20";
                break;
            case "WL" :
                type = "21";
                break;
            case "LU" :
                type = "22";
                break;
            case "CH" :
                type = "23";
                break;
            case "IN" :
                type = "24";
                break;
            case "FA" :
                type = "25";
                break;
            case "SO" :
                type = "26";
                break;
            case "DC" :
                type = "27";
                break;
            case "WM" :
                type = "28";
                break;
            case "RP" :
                type = "29";
                break;
            default :
                type = "NA";
                break;
        }
        return type;
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
