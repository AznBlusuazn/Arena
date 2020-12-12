package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
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
    
    public static List<String> getStats(String type, String toon, double XPratio) throws SQLException {
        String currentSavename = (Converters.capFirstLetter((MainControls.
            selectedSave).substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt))));
        switch(type) {
            case "Toon" :
                return getToonStats(currentSavename,toon,XPratio);
            case "Effects" :
                return getEffectStats(currentSavename, toon);
            case "Abls" :
                return getAblStats(currentSavename,toon);
            default :
                return null;
        }
    }
    
    private static List<String> getToonStats(String savename, String toon,
        double XPratio) throws SQLException {

        List<String> results = new ArrayList<>();
        List<String> toonstats = GetData.dbQuery(savename,"*","dbToons","toonNa"
            + "me",toon,false);
        double lvl = Double.parseDouble(toonstats.get(8)) + XPratio;
        String rac = toonstats.get(2);
        List<String> racestats = Arrays.asList((GetData.dbQuery(savename, "*","dbRace","raceID"+ "", rac,false).get(6)).split("x"));
        
//        List<String> racestats = GetData.dbQuery(savename, "*","dbRace","raceID"
//            + "", rac,false);
        String cls = toonstats.get(3);
        List<String> classstats = Arrays.asList((GetData.dbQuery(savename, "*","dbClass","classID"+ "", cls,false).get(3)).split("x"));
//        List<String> classstats = GetData.dbQuery(savename,"*","dbClass","class"
//            + "ID",cls,false);
        String alg = Calculator.getAlign(Integer.parseInt(toonstats.get(4)));
        List<String> alignstats = Arrays.asList((GetData.dbQuery(savename, "*","dbAlign","alignID"+ "", alg,false).get(4)).split("x"));
//        List<String> alignstats = GetData.dbQuery(savename,"*","dbAlign","align"
//            + "ID",alg,false);
        String nul = toonstats.get(5);
        //String sze = toonstats.get(6);
        String gen = toonstats.get(6);
        List<String> gendstats = Arrays.asList((GetData.dbQuery(savename, "*","dbGender","genderID"+ "", gen,false).get(3)).split("x"));
//        List<String> gendstats = GetData.dbQuery(savename,"*","dbGender","gende"
//            + "rID",gen,false);

String siz = Calculator.getSize((GetData.dbQuery(savename, "*","dbRace","raceID",toonstats.get(2), false)).get(1), (Calculator.getAge(Integer.parseInt(toonstats.get(7)),toonstats.get(2))));

        List<String> sizestats = Arrays.asList((GetData.dbQuery(savename, "*","dbSize","sizeName"+ "", siz,false).get(3)).split("x"));

        String age = toonstats.get(7);
        double ageadjuster = Calculator.getageAdjuster(Double.parseDouble(age) 
            / Double.parseDouble(GetData.dbQuery(savename, "*","dbRace","raceID"+ "", rac,false).get(5)));

        List<String> round1list = new ArrayList<>();
        
        //hp04 0
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(0))) + (Double.parseDouble(classstats.get(0))) + (Double.parseDouble(alignstats.get(0))) + Double.parseDouble(gendstats.get(0)) + Double.parseDouble(sizestats.get(0))))));
        //mp05 1
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(1))) + (Double.parseDouble(classstats.get(1))) + (Double.parseDouble(alignstats.get(1))) + Double.parseDouble(gendstats.get(1)) + Double.parseDouble(sizestats.get(1))))));
        //ap06 2
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(2))) + (Double.parseDouble(classstats.get(2))) + (Double.parseDouble(alignstats.get(2))) + Double.parseDouble(gendstats.get(2)) + Double.parseDouble(sizestats.get(2))))));
        //at07 3
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(3))) + (Double.parseDouble(classstats.get(3))) + (Double.parseDouble(alignstats.get(3))) + Double.parseDouble(gendstats.get(3)) + Double.parseDouble(sizestats.get(3))))));
        //st08 4
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(4))) + (Double.parseDouble(classstats.get(4))) + (Double.parseDouble(alignstats.get(4))) + Double.parseDouble(gendstats.get(4)) + Double.parseDouble(sizestats.get(4))))));
        //df09 5
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(5))) + (Double.parseDouble(classstats.get(5))) + (Double.parseDouble(alignstats.get(5))) + Double.parseDouble(gendstats.get(5)) + Double.parseDouble(sizestats.get(5))))));
        //sa10 6
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(6))) + (Double.parseDouble(classstats.get(6))) + (Double.parseDouble(alignstats.get(6))) + Double.parseDouble(gendstats.get(6)) + Double.parseDouble(sizestats.get(6))))));
        //sp11 7
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(7))) + (Double.parseDouble(classstats.get(7))) + (Double.parseDouble(alignstats.get(7))) + Double.parseDouble(gendstats.get(7)) + Double.parseDouble(sizestats.get(7))))));
        //ev12 8
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(8))) + (Double.parseDouble(classstats.get(8))) + (Double.parseDouble(alignstats.get(8))) + Double.parseDouble(gendstats.get(8)) + Double.parseDouble(sizestats.get(8))))));
        //dx13 9
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(9))) + (Double.parseDouble(classstats.get(9))) + (Double.parseDouble(alignstats.get(9))) + Double.parseDouble(gendstats.get(9)) + Double.parseDouble(sizestats.get(9))))));
        //my14 10
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(10))) + (Double.parseDouble(classstats.get(10))) + (Double.parseDouble(alignstats.get(10))) + Double.parseDouble(gendstats.get(10)) + Double.parseDouble(sizestats.get(10))))));
        //md15 11
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(11))) + (Double.parseDouble(classstats.get(11))) + (Double.parseDouble(alignstats.get(11))) + Double.parseDouble(gendstats.get(11)) + Double.parseDouble(sizestats.get(11))))));
        //me16 12
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(12))) + (Double.parseDouble(classstats.get(12))) + (Double.parseDouble(alignstats.get(12))) + Double.parseDouble(gendstats.get(12)) + Double.parseDouble(sizestats.get(12))))));
        //wl17 13
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(13))) + (Double.parseDouble(classstats.get(13))) + (Double.parseDouble(alignstats.get(13))) + Double.parseDouble(gendstats.get(13)) + Double.parseDouble(sizestats.get(13))))));
        //lk18 14
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(14))) + (Double.parseDouble(classstats.get(14))) + (Double.parseDouble(alignstats.get(14))) + Double.parseDouble(gendstats.get(14)) + Double.parseDouble(sizestats.get(14))))));
        //ch19 15
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(15))) + (Double.parseDouble(classstats.get(15))) + (Double.parseDouble(alignstats.get(15))) + Double.parseDouble(gendstats.get(15)) + Double.parseDouble(sizestats.get(15))))));
        //in20 16
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(16))) + (Double.parseDouble(classstats.get(16))) + (Double.parseDouble(alignstats.get(16))) + Double.parseDouble(gendstats.get(16)) + Double.parseDouble(sizestats.get(16))))));
        //fa21 17
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(17))) + (Double.parseDouble(classstats.get(17))) + (Double.parseDouble(alignstats.get(17))) + Double.parseDouble(gendstats.get(17)) + Double.parseDouble(sizestats.get(17))))));
        //sl22 18
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(18))) + (Double.parseDouble(classstats.get(18))) + (Double.parseDouble(alignstats.get(18))) + Double.parseDouble(gendstats.get(18)) + Double.parseDouble(sizestats.get(18))))));
        //de23 19
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(19))) + (Double.parseDouble(classstats.get(19))) + (Double.parseDouble(alignstats.get(19))) + Double.parseDouble(gendstats.get(19)) + Double.parseDouble(sizestats.get(19))))));
        //wt24 20
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(20))) + (Double.parseDouble(classstats.get(20))) + (Double.parseDouble(alignstats.get(20))) + Double.parseDouble(gendstats.get(20)) + Double.parseDouble(sizestats.get(20))))));
        //rp30 21
        round1list.add(String.valueOf((int) (lvl * (ageadjuster * 1))));

        
//        String hp04 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(0))) + (Double.parseDouble(classstats.get(0))) + (Double.parseDouble(alignstats.get(0))) + Double.parseDouble(gendstats.get(0)) + Double.parseDouble(sizestats.get(0)))));
//        String mp05 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(1))) + (Double.parseDouble(classstats.get(1))) + (Double.parseDouble(alignstats.get(1))) + Double.parseDouble(gendstats.get(1)) + Double.parseDouble(sizestats.get(1)))));
//        String ap06 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(2))) + (Double.parseDouble(classstats.get(2))) + (Double.parseDouble(alignstats.get(2))) + Double.parseDouble(gendstats.get(2)) + Double.parseDouble(sizestats.get(2)))));
//        String at07 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(3))) + (Double.parseDouble(classstats.get(3))) + (Double.parseDouble(alignstats.get(3))) + Double.parseDouble(gendstats.get(3)) + Double.parseDouble(sizestats.get(3)))));
//        String st08 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(4))) + (Double.parseDouble(classstats.get(4))) + (Double.parseDouble(alignstats.get(4))) + Double.parseDouble(gendstats.get(4)) + Double.parseDouble(sizestats.get(4)))));
//        String df09 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(5))) + (Double.parseDouble(classstats.get(5))) + (Double.parseDouble(alignstats.get(5))) + Double.parseDouble(gendstats.get(5)) + Double.parseDouble(sizestats.get(5)))));
//        String sa10 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(6))) + (Double.parseDouble(classstats.get(6))) + (Double.parseDouble(alignstats.get(6))) + Double.parseDouble(gendstats.get(6)) + Double.parseDouble(sizestats.get(6)))));
//        String sp11 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(7))) + (Double.parseDouble(classstats.get(7))) + (Double.parseDouble(alignstats.get(7))) + Double.parseDouble(gendstats.get(7)) + Double.parseDouble(sizestats.get(7)))));
//        String ev12 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(8))) + (Double.parseDouble(classstats.get(8))) + (Double.parseDouble(alignstats.get(8))) + Double.parseDouble(gendstats.get(8)) + Double.parseDouble(sizestats.get(8)))));
//        String dx13 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(9))) + (Double.parseDouble(classstats.get(9))) + (Double.parseDouble(alignstats.get(9))) + Double.parseDouble(gendstats.get(9)) + Double.parseDouble(sizestats.get(9)))));
//        String my14 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(10))) + (Double.parseDouble(classstats.get(10))) + (Double.parseDouble(alignstats.get(10))) + Double.parseDouble(gendstats.get(10)) + Double.parseDouble(sizestats.get(10)))));
//        String md15 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(11))) + (Double.parseDouble(classstats.get(11))) + (Double.parseDouble(alignstats.get(11))) + Double.parseDouble(gendstats.get(11)) + Double.parseDouble(sizestats.get(11)))));
//        String me16 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(12))) + (Double.parseDouble(classstats.get(12))) + (Double.parseDouble(alignstats.get(12))) + Double.parseDouble(gendstats.get(12)) + Double.parseDouble(sizestats.get(12)))));
//        String wl17 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(13))) + (Double.parseDouble(classstats.get(13))) + (Double.parseDouble(alignstats.get(13))) + Double.parseDouble(gendstats.get(13)) + Double.parseDouble(sizestats.get(13)))));
//        String lk18 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(14))) + (Double.parseDouble(classstats.get(14))) + (Double.parseDouble(alignstats.get(14))) + Double.parseDouble(gendstats.get(14)) + Double.parseDouble(sizestats.get(14)))));
//        String ch19 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(15))) + (Double.parseDouble(classstats.get(15))) + (Double.parseDouble(alignstats.get(15))) + Double.parseDouble(gendstats.get(15)) + Double.parseDouble(sizestats.get(15)))));
//        String in20 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(16))) + (Double.parseDouble(classstats.get(16))) + (Double.parseDouble(alignstats.get(16))) + Double.parseDouble(gendstats.get(16)) + Double.parseDouble(sizestats.get(16)))));
//        String fa21 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(17))) + (Double.parseDouble(classstats.get(17))) + (Double.parseDouble(alignstats.get(17))) + Double.parseDouble(gendstats.get(17)) + Double.parseDouble(sizestats.get(17)))));
//        String sl22 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(18))) + (Double.parseDouble(classstats.get(18))) + (Double.parseDouble(alignstats.get(18))) + Double.parseDouble(gendstats.get(18)) + Double.parseDouble(sizestats.get(18)))));
//        String de23 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(19))) + (Double.parseDouble(classstats.get(19))) + (Double.parseDouble(alignstats.get(19))) + Double.parseDouble(gendstats.get(19)) + Double.parseDouble(sizestats.get(19)))));
//        String wt24 = String.valueOf((int) (lvl * (ageadjuster * (Double.parseDouble(racestats.get(20))) + (Double.parseDouble(classstats.get(20))) + (Double.parseDouble(alignstats.get(20))) + Double.parseDouble(gendstats.get(20)) + Double.parseDouble(sizestats.get(20)))));
//        String rp30 = String.valueOf((int) (lvl * (ageadjuster * 1)));
        
        //getheldStats
        //getwearStats
        //getcharmStats
        List<String> round2list = getitemStats(savename,"Held",toonstats,round1list);
        List<String> round3list = getitemStats(savename,"Wear",toonstats,round2list);
        results = getitemStats(savename,"Charm",toonstats,round3list);
//        results.add(hp04);  //0
//        results.add(mp05);  //1
//        results.add(ap06);  //2
//        results.add(at07);  //3
//        results.add(st08);  //4
//        results.add(df09);  //5
//        results.add(sa10);  //6
//        results.add(sp11);  //7
//        results.add(ev12);  //8
//        results.add(dx13);  //9
//        results.add(my14);  //10
//        results.add(md15);  //11
//        results.add(me16);  //12
//        results.add(wl17);  //13
//        results.add(lk18);  //14
//        results.add(ch19);  //15
//        results.add(in20);  //16
//        results.add(fa21);  //17
//        results.add(sl22);  //18
//        results.add(de23);  //19
//        results.add(wt24);  //20
//        results.add(rp30);  //21
        return results;
    }
    
    public static void getitemsfromIDtoCBox(String save, List<String> list, 
        DefaultComboBoxModel dml, JComboBox<String> box, String dbname, String 
        searchcol, String matchcol) throws SQLException {
        for(int i = 0; i < list.size(); i++) {
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
    
    public static void getitemsfromIDtoJList(String save, List<String> list, 
        DefaultListModel dml, JList<String> jlist, String dbname, String 
        searchcol, String matchcol) throws SQLException {
        for(int i = 0; i < list.size(); i++) {
            if(!(ChecksBalances.isNullOrEmpty(list.get(i))) && !(list.get(i).equals("null"))) {
                String temp = GetData.dbQuery(save, "*",dbname,searchcol,list.get(i),false
                    ).get(1);
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
    
//    public static void getitemsfromIDx(String save, List<String> list, 
//        DefaultComboBoxModel dml, JComboBox<String> box, String dbname, String 
//        searchcol, String matchcol) throws SQLException {
//        for(int i = 0; i < list.size(); i++) {
//            if(!(ChecksBalances.isNullOrEmpty(list.get(i))) && !(list.get(i).equals("null"))) {
//                String temp = GetData.dbQuery(save, "*",dbname,searchcol,list.get(i),false
//                    ).get(1);
//                dml.addElement(temp);
//            }
//        }
//        if(dml.getSize() <= 0) {
//            dml.addElement("<None>");
//            box.setEnabled(false);
//        } else {
//            box.setEnabled(true);
//        }
//        box.setModel(dml);
//    }


    private static List<String> getEffectStats(String save, String toon) throws SQLException {
        List<String> toonstats = GetData.dbQuery(save,"*","dbToons","toonName",toon,false);
//        List<String> toonefflist = GetData.dbQuery(save, "*","dbToonEffects",
//            "toonID",toonstats.get(0), false);
        String sizeName = Calculator.getSize((GetData.dbQuery(save, "*","dbRace","raceID",toonstats.get(2), false)).get(1), (Calculator.getAge(Integer.parseInt(toonstats.get(7)), 
            toonstats.get(2))));
        String tooneff = toonstats.get(12);
        String raceeff = GetData.dbQuery(save,"*","dbRace","raceID",toonstats.get(2),false).get(9);
        String classeff = GetData.dbQuery(save,"*","dbClass","classID",toonstats.get(3),false).get(6);
        String aligneff = GetData.dbQuery(save,"*","dbAlign","alignID",Calculator.getAlign(Integer.parseInt(toonstats.get(4))),false).get(8);
        String gendeff = GetData.dbQuery(save,"*","dbGender","genderID",toonstats.get(6),false).get(7);
        String sizeeff = GetData.dbQuery(save,"*","dbSize","sizeName",sizeName,false).get(6);

        String itemequipped = "";
        
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(13)) && (!(toonstats.get(13)).equals("null"))) {
            itemequipped += toonstats.get(13) + "x";
        }
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(14)) && (!(toonstats.get(14)).equals("null"))) {
            itemequipped += toonstats.get(14) + "x";
        }
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(15)) && (!(toonstats.get(15)).equals("null"))) {
            itemequipped += toonstats.get(15);
        }
        List<String> itemlist = Arrays.asList(itemequipped.split("x"));
        if(itemequipped.endsWith("x")) {
            itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.length() - 1).split("x"));
        } 
        String tempitemeff = "";
        for(int i = 0; i < itemlist.size(); i++) {
            tempitemeff += (GetData.dbQuery(save,"*","dbItems","itemID",itemlist.get(i),false).get(12)) + "x";
        }
        String itemeff = tempitemeff;
        if(tempitemeff.endsWith("x")) {
            itemeff = tempitemeff.substring(0, itemeff.length() -1);
        }
        
//        List<String> raceefflist = GetData.dbQuery(save, "*","dbRaceEffects",
//            "raceID",toonstats.get(0), false);
//        List<String> classefflist = GetData.dbQuery(save, "*","dbClassEffects",
//            "classID",toonstats.get(0), false);
        String master = tooneff + "x" + raceeff + "x" + classeff + "x" + aligneff + "x" + gendeff + "x" + sizeeff + "x" + itemeff;
        master = master.replaceAll("null","");
//        if(master.endsWith(",")) {
//            master = master.substring(0,master.length() -1);
//        }
//        if(ChecksBalances.isNullOrEmpty(master) || master.length() == 0 || master.equals("null")) {
//            master = "0,";
//        }
        if((master.replaceAll(",","")).equals("")) {
            master = "0";
        }
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
        //align effects to be added later
//        List<String> alignefflist = GetData.dbQuery(save, "*","dbAlignEffects",
//            "alignID",toonstats.get(0), false);
        //
//        additemstolistfromList(toonefflist,results);
//        additemstolistfromList(raceefflist,results);
//        additemstolistfromList(classefflist,results);
//        Collections.sort(results);
//        results.add(0,"MASTER");
//        results.add(0,"MASTER");
        return results;
    }

    private static List<String> getAblStats(String save, String toon) throws SQLException {
        List<String> toonstats = GetData.dbQuery(save,"*","dbToons","toonName",toon,false);
        String sizeName = Calculator.getSize((GetData.dbQuery(save, "*","dbRace","raceID",toonstats.get(2), false)).get(1), (Calculator.getAge(Integer.parseInt(toonstats.get(7)), 
            toonstats.get(2))));
        String toonabl = toonstats.get(11);
        String raceabl = GetData.dbQuery(save,"*","dbRace","raceID",toonstats.get(2),false).get(8);
        String classabl = GetData.dbQuery(save,"*","dbClass","classID",toonstats.get(3),false).get(5);
        String alignabl = GetData.dbQuery(save,"*","dbAlign","alignID",Calculator.getAlign(Integer.parseInt(toonstats.get(4))),false).get(7);
        String gendabl = GetData.dbQuery(save,"*","dbGender","genderID",toonstats.get(6),false).get(6);
        String sizeabl = GetData.dbQuery(save,"*","dbSize","sizeName",sizeName,false).get(5);
        
        String itemequipped = "";
        
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(13)) && (!(toonstats.get(13)).equals("null"))) {
            itemequipped += toonstats.get(13) + "x";
        }
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(14)) && (!(toonstats.get(14)).equals("null"))) {
            itemequipped += toonstats.get(14) + "x";
        }
        if(!ChecksBalances.isNullOrEmpty(toonstats.get(15)) && (!(toonstats.get(15)).equals("null"))) {
            itemequipped += toonstats.get(15);
        }
        List<String> itemlist = Arrays.asList(itemequipped.split("x"));
        if(itemequipped.endsWith("x")) {
            itemlist = Arrays.asList(itemequipped.substring(0,itemequipped.length() - 1).split("x"));
        } 
        String tempitemabl = "";
        for(int i = 0; i < itemlist.size(); i++) {
            tempitemabl += (GetData.dbQuery(save,"*","dbItems","itemID",itemlist.get(i),false).get(11)) + "x";
        }
        String itemabl = tempitemabl;
        if(tempitemabl.endsWith("x")) {
            itemabl = tempitemabl.substring(0, itemabl.length() -1);
        }
        
        String master = toonabl + "x" + raceabl + "x" + classabl + "x" + alignabl + "x" + gendabl + "x" + sizeabl + "x" + itemabl;
        master = master.replaceAll("null","");
//        if((master.replaceAll(",","")).equals("")) {
//            master = "0";
//        }
        List<String> results = Arrays.asList(master.split("x"));
        Collections.sort(results);
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
    
    private static List<String> getitemStats(String save, String type, List<String> toonstats,List<String> templist) throws SQLException {
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
            return templist;
        }
        if(invlist.size() > 0 ) {
            for(int i = 0; i  < invlist.size(); i++ ) {
                templist = processitemStats(templist, (Arrays.asList((GetData.dbQuery(save,"*","dbItems","itemID",(String.valueOf(invlist.get(i))),false).get(9)).split("x"))));
            }
        }
        return templist;
    }
    
    private static List<String> processitemStats(List<String> oglist, List<String> statlist) {
        List<String> newlist = new ArrayList<>();
        if(statlist.size() > 0) {
            for(int i = 0; i < statlist.size(); i++) {
                String itemstat = statlist.get(i);
                double newvalue = 0;
                double finalvalue = 0;
                if(itemstat.contains("-")) {
                    newvalue = Double.parseDouble(itemstat.replaceAll("[^\\d]", "")) * -1;
                } else {
                    newvalue = Double.parseDouble(itemstat.replaceAll("[^\\d]", ""));
                }
                if(itemstat.contains("*")) {
                    finalvalue = Double.parseDouble(oglist.get(i)) * newvalue;
                } else {
                    finalvalue = Double.parseDouble(oglist.get(i)) + newvalue;
                }
                newlist.add(i, String.valueOf((int) finalvalue));
                }
            return newlist;
            } else {
            return oglist;
        }
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
