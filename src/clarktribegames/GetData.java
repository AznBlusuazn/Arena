package clarktribegames;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.CursorBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import com.healthmarketscience.jackcess.util.ImportUtil;
import com.healthmarketscience.jackcess.util.SimpleImportFilter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */

public class GetData {
    
    static String db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + 
    MainControls.defaultSave;
    static String db2 = MainControls.dagger;
    static String db3 = MainControls.price;
    static String dataSearch = "";
    static String dataTable = "";
    static String dataCol = "";
    static String dataMatchcol = "";
    static String dataMatchstr = "";
    static boolean progress1 = false;

    
    public static List<String> dataQuery(String search,String table,String col,
        String matching,boolean OnlyOneRec,boolean SecondaryQ,String carriedDb1,
        Statement carriedSt) throws SQLException {
        Statement st;
        if(!SecondaryQ) {
            
            String limitFile=MainControls.savesDir + MainControls.selectedSave;
            db1 = "jdbc:ucanaccess://" + limitFile;
            Connection con = DriverManager.getConnection(db1, db2, db3);
            st = con.createStatement();
        } else {
            db1 = carriedDb1;
            st = carriedSt;
        }
        String tempList = "";
        if(!OnlyOneRec) {
            tempList = (getSingleRec(st,search,table,col,matching)).replaceAll
                ("\\[", "").replaceAll("\\]","");
        } else {
            tempList = (getSingList(st,search,table,col)).replaceAll("\\[","").
                replaceAll("\\]","");
        }
        String[] stringList = tempList.split(",");
        List<String> convertedList = Arrays.asList(stringList);       
        if(!SecondaryQ) {
            st.close();
            DriverManager.getConnection(db1, db2, db3).close();
        }
        System.gc();
        return convertedList; 
    }
  
    private static String getSingleRec(Statement st, String search,String table,
        String col,String matching) throws SQLException {
        String match = (col + "=\"" + matching + "\"");
        String result = "";
        String query = ("select " + search + " from " + table + " where " + 
                match);
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colC = (rsmd.getColumnCount());
        while (rs.next()) {
            for(int i = 1; i <= colC; i++) {
                result = result + "," + rs.getString(i);
            }
        }
        result = result.substring(1,result.length());
        return result;
    }

    private static String getSingList(Statement st, String search,String table,
        String column) throws SQLException {
        String result = "";
        String query = ("select " + search + " from " + table);
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            result = result + "," + rs.getString(column);
        }
        result = result.substring(1,result.length());
        return result;
    }

    
    public static void createnewSave(String save,String game)throws SQLException
        , IOException, InterruptedException, Exception {
        try{
        copyTab(save,"dbToons", "sav" + game.toLowerCase() + "Toons");
        buildtoonSave(game);
        while(!(new File(MainControls.savesDir + ".tmp0").exists())) {
            Thread.sleep(1);
        }
        Thread.sleep(150);
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        //includes generics and alts
        int numbertoons=dataQuery("*",savetoons,"toonID",null,true,false,null,
            null).size();        
        buildGenerics(game,numbertoons);
        while(!(new File(MainControls.savesDir + ".tmp1").exists())) {
            Thread.sleep(1);
        }
        buildAlts(game);        
        while(!(new File(MainControls.savesDir + ".tmp2").exists())) {
            Thread.sleep(1);
        }
        Converters.dbtabletoFile("sav"+game.toLowerCase()+"Toons","toonID",(
            MainControls.currentgamePath.replaceAll(MainControls.saveExt,"toons"
            )));
        ChecksBalances.fileCheck((MainControls.currentgamePath.replaceAll(
            MainControls.saveExt,"toons")),(MainControls.currentgamePath.
            replaceAll(MainControls.saveExt, "max")),false,true);
        ChecksBalances.ifexistDelete(MainControls.savesDir + ".tmp0");
        ChecksBalances.ifexistDelete(MainControls.savesDir + ".tmp1");
        ChecksBalances.ifexistDelete(MainControls.savesDir + ".tmp2");
        MainControls.created = true;
        } catch (Exception ex) {
            LogWriter.logFile("severe", "Alt Build Error. EX: " + ex);
        }
    }
    
    private static void copyTab(String save,String oldtable,String newtable) 
        throws SQLException {
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
            MainControls.saveExt);
        try (Connection con = DriverManager.getConnection(db1, db2, db3)) {
            String savepath = MainControls.savesDir + Converters.capFirstLetter(
                (MainControls.selectedSave).substring(0,(MainControls
                .selectedSave).indexOf("." + MainControls.saveExt))) + "." + 
                MainControls.saveExt;
            try (Statement s = con.createStatement()) {
                try (ResultSet rs = s.executeQuery("SELECT * FROM [" + oldtable 
                    + "]")) {
                    //Thread.sleep(750);
                    Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(savepath)).open();
                    ImportUtil.importResultSet(rs,db,newtable,new 
                        SimpleImportFilter(), true);
                    if(oldtable.equals("dbToons")) {
                        new ColumnBuilder("toonStats").setType(DataType.TEXT)
                            .setMaxLength().addToTable(db.getTable(newtable));
                        new ColumnBuilder("toonExp").setType(DataType.TEXT)
                            .setMaxLength().addToTable(db.getTable(newtable));
                        new ColumnBuilder("toonSize").setType(DataType.TEXT)
                            .setMaxLength().addToTable(db.getTable(newtable));
                        new ColumnBuilder("toonTeam").setType(DataType.TEXT)
                            .setMaxLength().addToTable(db.getTable(newtable));
                        String timetable = newtable.replaceAll("Toons", "Time");
                        Table table2 = new TableBuilder(timetable).addColumn(new
                            ColumnBuilder("timeID",DataType.TEXT)).addColumn(new
                            ColumnBuilder("rawTime",DataType.TEXT)).toTable(db);
                        Table table3 = db.getTable(timetable);
                        table3.addRow("0","0");
                    }
                    db.flush();
                }
            }
            con.close(); 
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    private static void buildtoonSave(String game) throws 
            SQLException, IOException, InterruptedException {
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        int numbertoons=dataQuery("*",savetoons,"toonID",null,true,false,null,
            null).size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            List<String> toonstats=dataQuery("*",savetoons,"toonID",String.
                valueOf(toonidx),false,false,null,null);
            String toonExp = String.valueOf((int) Double.parseDouble(Calculator
                .getLevel("ranxp",(toonstats.get(8)))));
            double ratioXP = Double.parseDouble(toonExp) / (Double.parseDouble
                (Calculator.getLevel("stalv", String.valueOf(Integer.parseInt
                (toonstats.get(8) + 1)))));
            String toonSize=dataQuery("*","dbSize","sizeName",(Calculator.
                getSize(((dataQuery("*","dbRace","raceID",toonstats.get(2),false
                ,false,null,null)).get(1)),(Calculator.getAge(Integer.parseInt(
                toonstats.get(7)),toonstats.get(2))))),false,false,null,null).
                get(0);
            String toonStats = (GetStats.getStats("Toon",toonstats.toArray(new 
                String[0]),ratioXP,true).toString()).replaceAll(", ","x");
            toonStats = toonStats.substring(1, toonStats.length() - 1);
            String savepath=(MainControls.savesDir+Converters.capFirstLetter((
                MainControls.selectedSave))).replaceAll(MainControls.saveExt+"."
                +MainControls.saveExt,MainControls.saveExt);;
            //Thread.sleep(250);
            try (Connection con=DriverManager.getConnection("jdbc:ucanaccess://"
                + savepath, db2, db3)) {
                try (Statement s = con.createStatement()) {
                    Database db = new DatabaseBuilder().setAutoSync(false)
                        .setFile(new File(savepath)).open();
                    Table tbl = db.getTable(savetoons);
                    Row row = CursorBuilder.findRow(tbl, Collections
                        .singletonMap("toonID", String.valueOf(toonidx)));
                    row.put("toonStats", toonStats);
                    row.put("toonExp", toonExp);
                    row.put("toonSize", toonSize);
                    row.put("toonTeam", "0");
                    tbl.updateRow(row);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
            if(toonidx == numbertoons -1) {
                ChecksBalances.newfileCheck(MainControls.savesDir+".tmp0",true,"",true);
            }
        }
    }
    
    private static void buildGenerics(String game, int numbertoons) throws 
        SQLException, IOException, InterruptedException {
        String savetoons = "sav" + game.toLowerCase() + "Toons";
//        int gensneeded=numbertoons * 3;
        int gensneeded=numbertoons - (numbertoons / 3);
        int numbergens=dataQuery("*","dbGeneric","genericID",null,true,
            false,null,null).size();
        int gensremain = gensneeded;
        if(numbergens > 0) {
            if(gensremain > 0) {
                for(int x=0; x < numbergens; x++) {
                    if(gensremain > 0) {
                        String rawmax=dataQuery("*","dbGeneric",
                            "genericID",String.valueOf(x),false,false,null,null)
                            .get(17);
                        int makenumber = 0;
                        if(rawmax.toLowerCase().equals("null") || rawmax.equals
                            ("0") || rawmax.isEmpty() || rawmax.equals("") || 
                            ChecksBalances.isNullOrEmpty(rawmax)) {
                            makenumber = (int) (gensremain * Math.random());
                        } else {
                            if(Integer.parseInt(rawmax) > gensremain) {
                                makenumber=(int) (1+(gensremain*Math.random()));
                            } else {
                                makenumber=(int) (1+(Integer.parseInt(rawmax)*
                                    Math.random()));
                            }
                        }
                        if(makenumber > 0) {
                            int[]genidnums=Randomizer.randomNumbers(makenumber);
                            //add genidnums method here;
                            for(int y=1; y <= makenumber; y++) {
                                List<String> genstats=dataQuery("*",
                                    "dbGeneric","genericID",String.valueOf(x),
                                    false,false,null,null);
                                int startlv=(int) ((Integer.parseInt(genstats.
                                    get(8))-Integer.parseInt(genstats.get(7)))*
                                    Math.random())+Integer.parseInt(genstats.get
                                    (7));
                                String genExp=String.valueOf((int) Double.
                                    parseDouble(Calculator.getLevel("ranxp",(
                                    String.valueOf(startlv)))));
                                double ratioXP=Double.parseDouble(genExp)/(
                                    Double.parseDouble(Calculator.getLevel(
                                    "stalv",String.valueOf(startlv + 1))));
                                int genage=(int) (((Integer.parseInt((
                                    dataQuery("*","dbRace","raceID",genstats.get
                                    (2),false,false,null,null).get(5)))) * .15)+ 
                                    Math.random()*(((Integer.parseInt((
                                    dataQuery("*","dbRace","raceID",genstats.get
                                    (2),false,false,null,null).get(5))))*.40)));
                                
                                //defines age: min 15% race age/max 40% race age
                                
                                String genSize=dataQuery("*","dbSize",
                                    "sizeName",(Calculator.getSize(((
                                    dataQuery("*","dbRace","raceID",genstats.get
                                    (2), false,false,null,null)).get(1)),(
                                    Calculator.getAge(genage,genstats.get(2)))))
                                    ,false,false,null,null).get(0);
                                List<String> gentoonstats = new ArrayList<>();
                                numbertoons += 1;
                                int genalign=(int) ((Integer.parseInt(genstats.
                                    get(5))-Integer.parseInt(genstats.get(4)))*
                                    Math.random())+Integer.parseInt(genstats.get
                                    (4));
                                gentoonstats.add(0, String.valueOf(numbertoons 
                                    -1));
                                gentoonstats.add(1, (genstats.get(1) + " #" + 
                                    genidnums[y-1]));
                                gentoonstats.add(2, genstats.get(2));
                                gentoonstats.add(3, genstats.get(3));
                                gentoonstats.add(4, String.valueOf(genalign));
                                gentoonstats.add(5, "1");
                                gentoonstats.add(6, genstats.get(6));
                                gentoonstats.add(7, String.valueOf(genage));
                                gentoonstats.add(8, String.valueOf(startlv));
                                gentoonstats.add(9, genstats.get(9));
                                gentoonstats.add(10, genstats.get(10));
                                gentoonstats.add(11, genstats.get(11));
                                gentoonstats.add(12, genstats.get(12));
                                gentoonstats.add(13, genstats.get(13));
                                gentoonstats.add(14, genstats.get(14));
                                gentoonstats.add(15, genstats.get(15));
                                gentoonstats.add(16, genstats.get(16));
                                gentoonstats.add(17, "");
                                gentoonstats.add(18, "");
                                gentoonstats.add(19, "0");
                                String genStats=(GetStats.getStats("Toon",
                                    gentoonstats.toArray(new String[0]),ratioXP,
                                    true).toString()).replaceAll(", ","x");
                                genStats=genStats.substring(1,genStats.length()
                                    -1);
                                String savepath=(MainControls.savesDir+
                                    Converters.capFirstLetter((MainControls.
                                    selectedSave))).replaceAll(MainControls.
                                    saveExt+"."+MainControls.saveExt,
                                    MainControls.saveExt);
                                //Thread.sleep(750);    
                                try (Connection con=DriverManager.getConnection(
                                    "jdbc:ucanaccess://"+savepath,db2,db3)) {
                                    try (Statement s = con.createStatement()) {
                                        Database db = new DatabaseBuilder().
                                            setAutoSync(false).setFile(new File(
                                                savepath)).open();
                                    Table tbl = db.getTable(savetoons);
                                    tbl.addRow(gentoonstats.get(0),gentoonstats.
                                        get(1),gentoonstats.get(2),gentoonstats.
                                        get(3),gentoonstats.get(4),gentoonstats.
                                        get(5),gentoonstats.get(6),gentoonstats.
                                        get(7),gentoonstats.get(8),gentoonstats.
                                        get(9),gentoonstats.get(10),gentoonstats
                                        .get(11).replaceAll("null",""),
                                        gentoonstats.get(12).replaceAll("null",
                                        ""),gentoonstats.get(13).replaceAll(
                                        "null",""),gentoonstats.get(14).
                                        replaceAll("null",""),gentoonstats
                                        .get(15).replaceAll("null",""),
                                        gentoonstats.get(16).replaceAll("null",
                                        ""),gentoonstats.get(17).replaceAll(
                                        "null",""),gentoonstats.get(18),
                                        gentoonstats.get(19),genStats,genExp,
                                        genSize,"0");
                                    Thread.sleep(250);
                                    }
                                    con.close();
                                } catch (Exception e) {
                                    e.printStackTrace(System.err);
                                }
                            }
                            gensremain -= makenumber;
                        } 
                    }
                    if(x == numbergens -1) {
                        ChecksBalances.newfileCheck(MainControls.savesDir+".tmp1",true,"",true);
                    }
                }
            } 
        } 
        
    }
    
    private static void buildAlts(String game) throws 
        SQLException, IOException, InterruptedException {
        Thread.sleep(15000);
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        int numbertoons=dataQuery("*",savetoons,"toonID",null,true,false,null,
            null).size();
        int nextnumber = numbertoons;
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            Thread.sleep(250);
            String toonuid=dataQuery("*",savetoons,"toonID",
                String.valueOf(toonidx),false,false,null,null).get(5);
            if(!toonuid.startsWith("7")) {
                String altvalue=dataQuery("*",savetoons,"toonID",
                    String.valueOf(toonidx),false,false,null,null).get(18);             
                if(!altvalue.equals("null") && !altvalue.isEmpty()) {
                    List<String> altstats = dataQuery("*","dbAlias",
                        "aliasID",altvalue,false,false,null,null);
                    String alttype=altstats.get(2);
                    if(!alttype.equals("1") && !alttype.equals("2") && 
                        !alttype.equals("3")) {
                        //0 name only no secret -- nothing
                    } else {
                        //1 transformation no secret
                        //2 secret with fake stats
                        //3 secret with transformation
                        nextnumber += 1;
                        List<String> alttoonstats=altBuilder(savetoons,toonidx,
                            nextnumber,altstats);
                        String savepath=(MainControls.savesDir+Converters
                            .capFirstLetter((MainControls.selectedSave)))
                            .replaceAll(MainControls.saveExt+"."+MainControls
                            .saveExt,MainControls.saveExt);
                        Thread.sleep(250);    
                        try (Connection con=DriverManager.getConnection(
                            "jdbc:ucanaccess://"+savepath,db2,db3)) {
                            try (Statement s = con.createStatement()) {
                                Database db = new DatabaseBuilder().
                                    setAutoSync(false).setFile(new File(
                                        savepath)).open();
                            Table tbl = db.getTable(savetoons);
                            tbl.addRow(alttoonstats.get(0),alttoonstats.get(1),
                                alttoonstats.get(2),alttoonstats.get(3),
                                alttoonstats.get(4),alttoonstats.get(5),
                                alttoonstats.get(6),alttoonstats.get(7),
                                alttoonstats.get(8),alttoonstats.get(9),
                                alttoonstats.get(10),alttoonstats.get(11).
                                replaceAll("null",""),alttoonstats.get(12)
                                .replaceAll("null",""),alttoonstats.get(13)
                                .replaceAll("null",""),alttoonstats.get(14)
                                .replaceAll("null",""),alttoonstats.get(15)
                                .replaceAll("null",""),alttoonstats.get(16)
                                .replaceAll("null",""),alttoonstats.get(17)
                                .replaceAll("null",""),alttoonstats.get(18),
                                alttoonstats.get(19),alttoonstats.get(20),
                                alttoonstats.get(21),alttoonstats.get(22),
                                alttoonstats.get(23));
                            Thread.sleep(250);
                            }
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace(System.err);
                        }
                    }
                }
            } 
            if(toonidx == numbertoons -1) {
                        ChecksBalances.newfileCheck(MainControls.savesDir+".tmp2",true,"",true);
            }
        }
    }
    
    private static List<String> altBuilder(String savetoons,int toonidx,
        int nextnumber,List<String> altstats) throws SQLException, IOException, InterruptedException {
        List<String> ogtoonstats = dataQuery("*",savetoons,"toonID",
            String.valueOf(toonidx),false,false,null,null);
        List<String> alttoonstats = new ArrayList<>();
        //alt id 0
        nextnumber = Integer.parseInt(ChecksBalances.doesIDExist(savetoons,
            "toonID", String.valueOf(nextnumber - 1))) + 1;
        alttoonstats.add(0, String.valueOf(nextnumber - 1));
        //alt name 1
        alttoonstats.add(1, (altstats.get(1)));
        //alt race 2
        if(altstats.get(3).equals("=") || altstats.get(3).equals("null") || 
            altstats.get(3).isEmpty()) {
            alttoonstats.add(2, ogtoonstats.get(2));
        } else  {
            alttoonstats.add(2, altstats.get(3));
        }
        //alt class 3
        String jobid = altstats.get(6);
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(3, ogtoonstats.get(3));
        } else {
            List<String> jobstats = dataQuery("*",
                "dbJobs","jobID",jobid,false,false,null,null);
            alttoonstats.set(2, jobstats.get(2));
            alttoonstats.add(3, jobstats.get(3));
        }
        //alt align 4
        alttoonstats.add(4, String.valueOf(ogtoonstats.get(4)));
        //alt uid 5
        alttoonstats.add(5, "7x" + toonidx);
        //alt gender 6
        if(altstats.get(5).equals("=") || altstats.get(5).equals("null") || 
            altstats.get(5).isEmpty()) {
            alttoonstats.add(6, ogtoonstats.get(6));
        } else  {
            alttoonstats.add(6, altstats.get(5));
        }
        //alt age 7
        if(!ogtoonstats.get(2).equals(alttoonstats.get(2))) {
            double ageratio=Double.parseDouble(ogtoonstats.
                get(7))/Double.parseDouble(dataQuery("*"
                ,"dbRace","raceID",ogtoonstats.get(2),false,
                false,null,null).get(5));
            int altage=(int) (ageratio*(Integer.parseInt(GetData
                .dataQuery("*","dbRace","raceID",alttoonstats.
                get(2),false,false,null,null).get(5))));
            alttoonstats.add(7, String.valueOf(altage));
        } else {
            alttoonstats.add(7, ogtoonstats.get(7));
        }
        //alt startlv 8
        int altlv = (int)(Integer.parseInt(ogtoonstats.get(8))
            *(.01*(20+(Math.random()*80))));
        String altexp=String.valueOf((int) Double.parseDouble(
            Calculator.getLevel("ranxp",(String.valueOf(altlv)))
            ));
        double altratioXP=Double.parseDouble(altexp)/(Double
            .parseDouble(Calculator.getLevel("stalv",String
            .valueOf(altlv + 1))));                        
        alttoonstats.add(8, String.valueOf(altlv));
        //alt bio 9
        alttoonstats.add(9, altstats.get(7));
        //alt image 10
        alttoonstats.add(10, altstats.get(8));
        //alt abl 11
        alttoonstats.add(11, "");
        //alt eff 12
        alttoonstats.add(12, "");
        //alt held 13
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(13, ogtoonstats.get(13));
        } else {                  
            alttoonstats.add(13, dataQuery("*","dbJobs",
                "jobID",jobid,false,false,null,null).get(5));
        }
        //alt wear 14
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(14, ogtoonstats.get(14));
        } else {    
            alttoonstats.add(14, dataQuery("*","dbJobs",
                "jobID",jobid,false,false,null,null).get(6));
        }
        //alt charms 15
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(15, ogtoonstats.get(15));
        } else {                  
            alttoonstats.add(15, dataQuery("*","dbJobs",
                "jobID",jobid,false,false,null,null).get(7));
        }
        //alt inv 16
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(16, ogtoonstats.get(16));
        } else {                  
            alttoonstats.add(16, dataQuery("*","dbJobs",
                "jobID",jobid,false,false,null,null).get(8));
        }
        //alt inv 17
        alttoonstats.add(17, ogtoonstats.get(17));
        //alt alias 18
        alttoonstats.add(18, null);
        //alt destiny 19
        alttoonstats.add(19, dataQuery("*","dbDestiny",
            "destinyName","Passive",false,false,null,null)
            .get(0));
        //alt toonstats 20
        String altStats=(GetStats.getStats("Toon",
            alttoonstats.toArray(new String[0]),altratioXP,
            true).toString()).replaceAll(", ","x");
        altStats=altStats.substring(1,altStats.length() - 1);
        alttoonstats.add(20, altStats);
        //alt toonexp 21
        alttoonstats.add(21, String.valueOf(altexp));
        //alt toonsize 22
        String altsize=dataQuery("*","dbSize",
            "sizeName",(Calculator.getSize(((dataQuery
            ("*","dbRace","raceID",alttoonstats.get(2),false,
            false,null,null)).get(1)),(Calculator.getAge(Integer
            .parseInt(alttoonstats.get(7)),alttoonstats.get(2)))
            )),false,false,null,null).get(0);
        alttoonstats.add(22, altsize);
        //alt toonteam 23
        alttoonstats.add(23, ogtoonstats.get(23));     
        return alttoonstats;
    }
    
    public static void buildBattle(String save, String game) throws IOException,
        SQLException, InterruptedException {
        createBattleTbl(save,game);
        buildBattleTable(save,game,Arrays.asList(BattleEngine.team0),"0");
        Thread.sleep(350);
        buildBattleTable(save,game,Arrays.asList(BattleEngine.team1),"1");
        Thread.sleep(700);
        copyTab(save,"battle"+game.toLowerCase()+"Toons","battle"+game
            .toLowerCase()+"Max");
    }
    
    private static void createBattleTbl(String save, String game) throws 
        IOException, InterruptedException {
        String battletable = "battle" + game.toLowerCase() + "Toons";
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
            MainControls.saveExt);
            try (Connection con = DriverManager.getConnection(db1, db2, db3)) {
            String savepath = MainControls.savesDir + Converters.capFirstLetter(
                (MainControls.selectedSave).substring(0,(MainControls
                .selectedSave).indexOf("." + MainControls.saveExt))) + "." + 
                MainControls.saveExt;
            try (Statement s = con.createStatement()) {
                Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(savepath)).open();
                Table table = new TableBuilder(battletable)
                    .addColumn(new ColumnBuilder("toonID",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonName",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonRace",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonClass",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonAlignRank",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonUID",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonGen",DataType.TEXT))
                    .addColumn(new ColumnBuilder("teamAge",DataType.TEXT))                        
                    .addColumn(new ColumnBuilder("toonLv",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonBio",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonImage",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonAbl",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonEff",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonHeld",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonWear",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonCharms",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonInv",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonAlias",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonAKnown",DataType.TEXT))
                    .addColumn(new ColumnBuilder("baseStats",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonExp",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonSize",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonTeam",DataType.TEXT))
                    .addColumn(new ColumnBuilder("combinedStats",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonAlignment",DataType.TEXT))
                    .addColumn(new ColumnBuilder("toonGender",DataType.TEXT))
                    .addColumn(new ColumnBuilder("teamAgeGroup",DataType.TEXT))                        
                    .addColumn(new ColumnBuilder("teamSizeName",DataType.TEXT))
                    .addColumn(new ColumnBuilder("teamRaceName",DataType.TEXT))
                    .addColumn(new ColumnBuilder("teamClassName",DataType.TEXT))
                    .toTable (db);
                    db.flush();
            }
            con.close(); 
            Thread.sleep(350);
        } catch (Exception e) {
            String savepath = MainControls.savesDir + Converters.capFirstLetter(
                (MainControls.selectedSave).substring(0,(MainControls
                .selectedSave).indexOf("." + MainControls.saveExt))) + "." + 
                MainControls.saveExt;
            Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(savepath)).open();
            Table t = db.getTable(battletable);
            for (Row r : t) {
                t.deleteRow(r);
            }
            Table t2 = db.getTable(battletable.replaceAll("Toons", "Max"));
            for (Row r : t2) {
                t2.deleteRow(r);
            }
            Thread.sleep(350);
        }
    }
    
    private static void buildBattleTable(String save,String game,List<String> 
        team,String teamno) throws SQLException,InterruptedException,IOException
        {
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        String battletable = "battle" + game.toLowerCase() + "Toons";
        int numbertoons = team.size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            String[] toonstats = (Converters.getSpecificLine((MainControls.
                currentgamePath.replaceAll(MainControls.saveExt,"toons")),
                Integer.parseInt(String.valueOf(team.get(toonidx))))).split(",")
                ;
            String raceSize=dataQuery("*","dbRace","raceID",toonstats[2],false,
                false,null,null).get(1);
            String toonSize=dataQuery("*","dbSize","sizeName",(Calculator.
                getSize(raceSize,(Calculator.getAge(Integer.parseInt(toonstats
                [7]),toonstats[2])))),false,false,null,null).get(0);
            String savepath=(MainControls.savesDir + Converters.capFirstLetter((
                MainControls.selectedSave))).replaceAll(MainControls.saveExt+"."
                +MainControls.saveExt, MainControls.saveExt);
            String[] toonbasestats = (toonstats[20]).split("x");
            List<String> baselist = new ArrayList<>();
            baselist.addAll(Arrays.asList(toonbasestats));
            String[] charmlist = GetStats.fetchitemStats(save,"Charm",toonstats,
                baselist);
            String[] wearlist = GetStats.fetchitemStats(save,"Wear",toonstats,
                baselist);
            String[] heldlist = GetStats.fetchitemStats(save,"Held",toonstats,
                baselist);
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.length; x++) {
                double total=Double.parseDouble(baselist.get(x))+Double.
                    parseDouble(charmlist[x])+Double.parseDouble(wearlist[x])+
                    Double.parseDouble(heldlist[x]);
                combined.add(String.valueOf((int) total));
            }
            String AlignName=(dataQuery("*","dbAlign","alignID",(Calculator.
                getAlign(Integer.parseInt(toonstats[4]))),false,false,null,null)
                ).get(1);            
            String GenderName=(dataQuery("*","dbGender","genderID",toonstats[6],
                false,false,null,null)).get(1);
            String AgeGroup=Calculator.getAge(Integer.parseInt(toonstats[7]),((
                dataQuery("*","dbRace","raceID",(toonstats[2]),false,false,null,
                null)).get(0)));
            String SizeName=(dataQuery("*","dbSize","sizeID",toonSize,false,
                false,null,null)).get(1);
            String RaceName=(dataQuery("*","dbRace","raceID",toonstats[2],false,
                false,null,null)).get(1);
            String ClassName=(dataQuery("*","dbClass","classID",toonstats[3],
                false,false,null,null).get(1));

            try (Connection con=DriverManager.getConnection("jdbc:ucanaccess://"
                + savepath, db2, db3)) {
                try (Statement s = con.createStatement()) {
                    Database db = new DatabaseBuilder().setAutoSync(false)
                        .setFile(new File(savepath)).open();
                    Table tbl = db.getTable(battletable);
                    tbl.addRow(toonstats[0],toonstats[1],toonstats[2
                        ],toonstats[3],toonstats[4],toonstats[5],
                        toonstats[6],toonstats[7],toonstats[8],
                        toonstats[9],toonstats[10],toonstats[11],
                        toonstats[12],toonstats[13],toonstats[14],
                        toonstats[15],toonstats[16],toonstats[17],
                        toonstats[18],toonstats[20],toonstats[21],
                        toonstats[22],teamno,(combined.stream().collect
                        (Collectors.joining("x"))),AlignName,GenderName,AgeGroup
                        ,SizeName,RaceName,ClassName);
                    Thread.sleep(350);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public static void getSavedGameToon(JList savegameList,JLabel savedToon,
        JLabel savedToonName,JLabel savedToonRankDate,JLabel savedToonStats, 
        JLabel savedToonLevel) throws IOException, SQLException {
        try {
            String saveFolder=MainControls.savesDir + savegameList.
                getSelectedValue().toString().toLowerCase();
            String toonID = ChecksBalances.getFirstLine(new File(saveFolder + 
                "/.lastused"));
            MainControls.selectedSave=savegameList.getSelectedValue().toString()
                .toLowerCase() + "/" + MainControls.selectedSave;
            List<String> savedToonInfo = dataQuery("*","sav"+savegameList
                .getSelectedValue().toString().toLowerCase()+"Toons","toonID",
                toonID,false,false,null,null);
            String toonGender=dataQuery("*","dbGender","genderID",savedToonInfo.
                get(6),false,false,null,null).get(1);
            String toonRace=dataQuery("*","dbRace","raceID",savedToonInfo.get(2)
                ,false,false,null,null).get(1);
            String toonClass=dataQuery("*","dbClass","classID",savedToonInfo.get
                (3),false,false,null,null).get(1);
            savedToonStats.setForeground((Converters.figureoutColor(GetStats
                .getalignColor(Integer.parseInt((savedToonInfo.get(4)))))));
            Avatars.setAvatar(savedToon,savedToonInfo.get(1),savedToonInfo.get
                (10));
            savedToonName.setText(savedToonInfo.get(1));
            //use savedToonRank for date + rank
            String lastused = MainControls.savesDir + savegameList.
                getSelectedValue().toString().toLowerCase() + "/.lastused";
            String[] tempDateTime = Converters.convertTime(Integer.parseInt(
                Converters.getSpecificLine(lastused, 2)));
            savedToonRankDate.setText("Yr "+tempDateTime[0]+" Mo "+
                tempDateTime[1]+" Wk "+tempDateTime[2]+" Day "+tempDateTime[3]+
                " : Hr "+tempDateTime[4]+" Min "+tempDateTime[5]);
            savedToonStats.setText(Calculator.getAge(Integer.parseInt(
                savedToonInfo.get(7)),savedToonInfo.get(2))+" "+toonRace+" "+
                toonClass+" "+toonGender);
            savedToonLevel.setText("Level "+savedToonInfo.get(8));
        } catch (IOException | NumberFormatException | SQLException | 
            NullPointerException ex) {
            if(Limitless.lgList.getModel().getSize() > 0) {
                Limitless.lgList.setSelectedIndex(0);
            }
        }
            MainControls.selectedSave = MainControls.defaultSave;
    }
    
    public static List<String> getNewGameToonList() throws IOException,
        SQLException {
        return dataQuery("*","sav"+MainControls.savesDir.replaceAll("saves/","")
            .replaceAll("/", "")+"Toons","toonName",null,true,false,null,null);
    }
}
    




