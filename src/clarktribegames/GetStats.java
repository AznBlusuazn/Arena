package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public static List<String> getStats(String toon, double XPratio) throws SQLException {
        return getToonStats(toon,XPratio);
    }
    
    private static List<String> getToonStats(String toon, double XPratio) throws SQLException {
        String savename = (Converters.capFirstLetter((MainControls.selectedSave)
            .substring(0,(MainControls.selectedSave).indexOf("." + MainControls.
            saveExt))));
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
