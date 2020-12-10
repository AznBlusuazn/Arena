package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;




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
    
    public static List<String> getStats(String type, String toon, double XPratio) throws SQLException {
        String currentSavename = (Converters.capFirstLetter((MainControls.
            selectedSave).substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt))));
        switch(type) {
            case "Toon" :
                return getToonStats(currentSavename,toon,XPratio);
            case "Effects" :
                return getEffectStats(currentSavename, toon);
                
            default :
                return null;
        }
    }
    
    private static List<String> getToonStats(String savename, String toon,
        double XPratio) throws SQLException {
        List<String> results = new ArrayList<>();
        List<String> toonstats = GetData.dbQuery(savename,"*","dbToons","toonNa"
            + "me",toon,false);
        double lvl = Double.parseDouble(toonstats.get(9)) + XPratio;
        String rac = toonstats.get(2);
        List<String> racestats = GetData.dbQuery(savename, "*","dbRace","raceID"
            + "", rac,false);
        String cls = toonstats.get(3);
        List<String> classstats = GetData.dbQuery(savename,"*","dbClass","class"
            + "ID",cls,false);
        String alg = toonstats.get(4);
        List<String> alignstats = GetData.dbQuery(savename,"*","dbAlign","align"
            + "ID",alg,false);
        String nul = toonstats.get(5);
        String sze = toonstats.get(6);
        String gen = toonstats.get(7);
        List<String> gendstats = GetData.dbQuery(savename,"*","dbGender","gende"
            + "rID",gen,false);

        String age = toonstats.get(8);

        double ageadjuster = Calculator.getageAdjuster(Double.parseDouble(age) 
            / Double.parseDouble(racestats.get(25)));
        String hp04 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(4))) + (Double.parseDouble(classstats.get(4))) + (Double.parseDouble(alignstats.get(4))) + Double.parseDouble(gendstats.get(4)))));
        String mp05 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(5))) + (Double.parseDouble(classstats.get(5))) + (Double.parseDouble(alignstats.get(5))) + Double.parseDouble(gendstats.get(5)))));
        String ap06 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(6))) + (Double.parseDouble(classstats.get(6))) + (Double.parseDouble(alignstats.get(6))) + Double.parseDouble(gendstats.get(6)))));
        String at07 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(7))) + (Double.parseDouble(classstats.get(7))) + (Double.parseDouble(alignstats.get(7))) + Double.parseDouble(gendstats.get(7)))));
        String st08 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(8))) + (Double.parseDouble(classstats.get(8))) + (Double.parseDouble(alignstats.get(8))) + Double.parseDouble(gendstats.get(8)))));
        String df09 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(9))) + (Double.parseDouble(classstats.get(9))) + (Double.parseDouble(alignstats.get(9))) + Double.parseDouble(gendstats.get(9)))));
        String sa10 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(10))) + (Double.parseDouble(classstats.get(10))) + (Double.parseDouble(alignstats.get(10))) + Double.parseDouble(gendstats.get(10)))));
        String sp11 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(11))) + (Double.parseDouble(classstats.get(11))) + (Double.parseDouble(alignstats.get(11))) + Double.parseDouble(gendstats.get(11)))));
        String ev12 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(12))) + (Double.parseDouble(classstats.get(12))) + (Double.parseDouble(alignstats.get(12))) + Double.parseDouble(gendstats.get(12)))));
        String dx13 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(13))) + (Double.parseDouble(classstats.get(13))) + (Double.parseDouble(alignstats.get(13))) + Double.parseDouble(gendstats.get(13)))));
        String my14 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(14))) + (Double.parseDouble(classstats.get(14))) + (Double.parseDouble(alignstats.get(14))) + Double.parseDouble(gendstats.get(14)))));
        String md15 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(15))) + (Double.parseDouble(classstats.get(15))) + (Double.parseDouble(alignstats.get(15))) + Double.parseDouble(gendstats.get(15)))));
        String me16 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(16))) + (Double.parseDouble(classstats.get(16))) + (Double.parseDouble(alignstats.get(16))) + Double.parseDouble(gendstats.get(16)))));
        String wl17 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(17))) + (Double.parseDouble(classstats.get(17))) + (Double.parseDouble(alignstats.get(17))) + Double.parseDouble(gendstats.get(17)))));
        String lk18 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(18))) + (Double.parseDouble(classstats.get(18))) + (Double.parseDouble(alignstats.get(18))) + Double.parseDouble(gendstats.get(18)))));
        String ch19 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(19))) + (Double.parseDouble(classstats.get(19))) + (Double.parseDouble(alignstats.get(19))) + Double.parseDouble(gendstats.get(19)))));
        String in20 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(20))) + (Double.parseDouble(classstats.get(20))) + (Double.parseDouble(alignstats.get(20))) + Double.parseDouble(gendstats.get(20)))));
        String fa21 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(21))) + (Double.parseDouble(classstats.get(21))) + (Double.parseDouble(alignstats.get(21))) + Double.parseDouble(gendstats.get(21)))));
        String sl22 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(22))) + (Double.parseDouble(classstats.get(22))) + (Double.parseDouble(alignstats.get(22))) + Double.parseDouble(gendstats.get(22)))));
        String de23 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(23))) + (Double.parseDouble(classstats.get(23))) + (Double.parseDouble(alignstats.get(23))) + Double.parseDouble(gendstats.get(23)))));
        String wt24 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(24))) + (Double.parseDouble(classstats.get(24))) + (Double.parseDouble(alignstats.get(24))) + Double.parseDouble(gendstats.get(24)))));
        String rp30 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(30))) + (Double.parseDouble(classstats.get(30))) + (Double.parseDouble(alignstats.get(30))) + Double.parseDouble(gendstats.get(30)))));
        
        results.add(hp04);  //0
        results.add(mp05);  //1
        results.add(ap06);  //2
        results.add(at07);  //3
        results.add(st08);  //4
        results.add(df09);  //5
        results.add(sa10);  //6
        results.add(sp11);  //7
        results.add(ev12);  //8
        results.add(dx13);  //9
        results.add(my14);  //10
        results.add(md15);  //11
        results.add(me16);  //12
        results.add(wl17);  //13
        results.add(lk18);  //14
        results.add(ch19);  //15
        results.add(in20);  //16
        results.add(fa21);  //17
        results.add(sl22);  //18
        results.add(de23);  //19
        results.add(wt24);  //20
        results.add(rp30);  //21
        
        return results;
    }
    
    public static void getitemsfromID(String save, List<String> list, 
        DefaultComboBoxModel dml, JComboBox<String> box, String dbname, String 
        searchcol, String matchcol) throws SQLException {
        for(int i = 1; i < list.size(); i++) {
            if(!(ChecksBalances.isNullOrEmpty(list.get(i))) && !(list.get(i).equals("null"))) {
                String temp = GetData.dbQuery(save, "*",dbname,searchcol,list.get(i),false
                    ).get(1);
                dml.addElement(temp);
            }
        }
        if(dml.getSize() <= 0) {
            dml.addElement("<None>");
            box.setEnabled(false);
        } else {
            box.setEnabled(true);
        }
        box.setModel(dml);
    }

    private static List<String> getEffectStats(String save, String toon) throws SQLException {
        List<String> results = new ArrayList<>();
        List<String> toonstats = GetData.dbQuery(save,"*","dbToons","toonName",toon,false);
        List<String> toonefflist = GetData.dbQuery(save, "*","dbToonEffects",
            "toonID",toonstats.get(0), false);
        List<String> raceefflist = GetData.dbQuery(save, "*","dbRaceEffects",
            "raceID",toonstats.get(0), false);
        List<String> classefflist = GetData.dbQuery(save, "*","dbClassEffects",
            "classID",toonstats.get(0), false);
        //align effects to be added later
//        List<String> alignefflist = GetData.dbQuery(save, "*","dbAlignEffects",
//            "alignID",toonstats.get(0), false);
        //
        additemstolistfromList(toonefflist,results);
        additemstolistfromList(raceefflist,results);
        additemstolistfromList(classefflist,results);
        Collections.sort(results);
        results.add(0,"MASTER");
        return results;
    }
    
    private static List<String> additemstolistfromList(List<String> source, List<String> dest) {
        if(source.size() > 0) {
            for(int i = 1; i < source.size(); i++ ) {
                String item = source.get(i);
                if(!ChecksBalances.isNullOrEmpty(item) || !(item.equals("null"))) {
                    dest.add(item);
                }
            }
        }
        dest.removeAll(Collections.singleton(null));
        dest.removeAll(Collections.singleton("null"));
        return dest;
    }
    
    public static String getalignColor(String alignment) throws SQLException {
        String currentSavename = (Converters.capFirstLetter((MainControls.
            selectedSave).substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt))));
        return alignColor(currentSavename,alignment);
    }
    
    private static String alignColor(String save, String align) throws SQLException {
        String retVal = "black";
        int total = GetData.dbQuery(save,"*","dbAlign","align00","",true).size();
        double firstvalue = (double) getvalueAlign(save,align);
        double secondvalue = firstvalue / ((double) total) * 100;
        int alignvalue = (int) secondvalue;
        if(alignvalue < 15) {
            retVal = "red";
        }
        if(alignvalue >= 15 && alignvalue < 30) {
            retVal = "dark red";
        }
        if(alignvalue >= 30 && alignvalue < 50) {
            retVal = "brown";
        }
        if(alignvalue == 50) {
            retVal = "black";
        }
        if(alignvalue > 50 && alignvalue <= 60) {
            retVal = "dark blue";
        }
        if(alignvalue >= 60 && alignvalue < 85) {
            retVal = "blue";
        }
        if(alignvalue >= 85) {
            retVal = "light blue";
        }
        return retVal;
    }
    
    private static int getvalueAlign(String save, String align) throws SQLException {
        int alignIndex = Integer.parseInt(GetData.dbQuery(save,"*","dbAlign","alignName",align,false).get(0));
        List<String> alignNumbers =GetData.dbQuery(save,"*","dbAlign","align00","",true);
        List<Integer> intList = new ArrayList<>();
        for(String s : alignNumbers) intList.add(Integer.valueOf(s));
        int[] minarray = intList.stream().mapToInt(i->i).toArray();
        int minvalue = greatestNegative(minarray);
        List<Integer> newalign = new ArrayList<>();
        for(int i = 0; i < alignNumbers.size(); i++) {
            if(minvalue < 0) {
                int newminvalue = minvalue * -1;
                newalign.add(Integer.parseInt(alignNumbers.get(i)) + newminvalue);
            } else {
            newalign.add(Integer.parseInt(alignNumbers.get(i)));
            }
        }
        return newalign.get(alignIndex -1);
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
