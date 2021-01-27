package clarktribegames;

import com.healthmarketscience.jackcess.ColumnBuilder;
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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
    static int buildingToons = 0;
    static int buildingToonsOG = 0;

    
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
        String[] stringList = tempList.replaceAll(", ",",").split(",");;
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
        
        //reset variables
        buildingToons = 0;
        buildingToonsOG = 0;
        StartGame.savToons = new ArrayList<>();
        StartGame.genToons = new ArrayList<>();
        StartGame.altToons = new ArrayList<>();
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        createSav(save,"dbToons",savetoons);
        buildtoonSave(StartGame.savToons);
        buildGenerics(StartGame.genToons);
        buildAlts(StartGame.altToons);
        sendtoNewDB(game.toLowerCase(),StartGame.savToons,StartGame.genToons,
            StartGame.altToons);
//        Converters.dbtabletoFile(savetoons,"toonID",(MainControls.
//            currentgamePath.replaceAll(MainControls.saveExt,"toons")));
//        ChecksBalances.fileCheck((MainControls.currentgamePath.replaceAll(
//            MainControls.saveExt,"toons")),(MainControls.currentgamePath.
//            replaceAll(MainControls.saveExt,"max")),false,true);
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

    private static void createSav(String save,String oldtable,String newtable) 
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
                    Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(savepath)).open();
                    if(oldtable.equals("dbToons")) {
                        Table table = new TableBuilder(newtable).addColumn(new 
                        ColumnBuilder("toonID").setType(DataType.NUMERIC).
                        setMaxLength()).addColumn(new ColumnBuilder("toonName").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonRace").setType(DataType.NUMERIC).
                        setMaxLength()).addColumn(new ColumnBuilder("toonClass")
                        .setType(DataType.NUMERIC).setMaxLength()).addColumn(new
                        ColumnBuilder("toonAlign").setType(DataType.NUMERIC).
                        setMaxLength()).addColumn(new ColumnBuilder("toonUID").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonGen").setType(DataType.NUMERIC).
                        setMaxLength()).addColumn(new ColumnBuilder("toonAge").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonStartLv").setType(DataType.TEXT).
                        setMaxLength()).addColumn(new ColumnBuilder("toonBio").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonImage").setType(DataType.TEXT).
                        setMaxLength()).addColumn(new ColumnBuilder("toonAbl").
                        setType(DataType.MEMO).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonEff").setType(DataType.MEMO).
                        setMaxLength()).addColumn(new ColumnBuilder("toonHeld").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonWear").setType(DataType.TEXT).
                        setMaxLength()).addColumn(new ColumnBuilder(
                        "toonCharms").setType(DataType.TEXT).setMaxLength()).
                        addColumn(new ColumnBuilder("toonInv").setType(DataType.
                        TEXT).setMaxLength()).addColumn(new ColumnBuilder(
                        "toonLifeO").setType(DataType.TEXT).setMaxLength()).
                        addColumn(new ColumnBuilder("toonAlias").setType(
                        DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonDestiny").setType(DataType.NUMERIC).
                        setMaxLength()).addColumn(new ColumnBuilder("toonStats")
                        .setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonExp").setType(DataType.TEXT).
                        setMaxLength()).addColumn(new ColumnBuilder("toonSize").
                        setType(DataType.TEXT).setMaxLength()).addColumn(new 
                        ColumnBuilder("toonTeam").setType(DataType.TEXT).
                        setMaxLength()).toTable(db);
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
    
    private static void buildtoonSave(List<String> savtoons) throws SQLException, 
        IOException,InterruptedException {
        int numbertoons=MemoryBank.dbToons.size();
        buildingToons = numbertoons;
        buildingToonsOG = numbertoons;
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            String[] toonstats = (Converters.expListtoArray(MemoryBank.dbToons.
                get(toonidx)));
            String toonExp = String.valueOf((int) Double.parseDouble(Calculator
                .getLevel("ranxp",(toonstats[8]))));
            double ratioXP = Double.parseDouble(toonExp) / (Double.parseDouble
                (Calculator.getLevel("stalv", String.valueOf(Integer.parseInt
                (toonstats[8] + 1)))));
            String toonSize=dataQuery("*","dbSize","sizeName",(Calculator.
                getSize(Converters.fetchString(MemoryBank.dbRace,toonstats[2],1)
                ,(Calculator.getAge(Integer.parseInt(toonstats[7]),toonstats[2])
                ))),false,false,null,null).get(0);
            String toonStats = (GetStats.getStats("Toon",toonstats,ratioXP,true)
                .toString()).replaceAll(", ","x");
            toonStats = toonStats.substring(1, toonStats.length() - 1);
            String tempSav=(Arrays.toString(toonstats));
            tempSav=tempSav.substring(1,tempSav.length() -1).replace(", ",",");
            tempSav=tempSav+","+toonStats+","+toonExp+","+toonSize+",0";
            savtoons.add(tempSav);
        }
    }
    
    private static void buildGenerics(List<String> gentoons) throws 
        SQLException, IOException, InterruptedException {
//        int gensneeded=numbertoons * 3;
        int gensneeded=buildingToons - (buildingToons / 3);
        int numbergens=MemoryBank.dbGeneric.size();
        int gensremain = gensneeded;
        if(numbergens > 0) {
            if(gensremain > 0) {
                for(int x=0; x < numbergens; x++) {
                    if(gensremain > 0) {
                        String rawmax=Converters.fetchString(MemoryBank.
                            dbGeneric,String.valueOf(x),17);
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
                                String[] genstats = Converters.expListtoArray(
                                    MemoryBank.dbGeneric.get(x));
                                int startlv=(int) ((Integer.parseInt(genstats[8]
                                    )-Integer.parseInt(genstats[7]))*Math.random
                                    ())+Integer.parseInt(genstats[7]);
                                String genExp=String.valueOf((int) Double.
                                    parseDouble(Calculator.getLevel("ranxp",(
                                    String.valueOf(startlv)))));
                                double ratioXP=Double.parseDouble(genExp)/(
                                    Double.parseDouble(Calculator.getLevel(
                                    "stalv",String.valueOf(startlv + 1))));
                                int genage=(int) (((Integer.parseInt((Converters
                                    .fetchString(MemoryBank.dbRace,genstats[2],5
                                    ))))*.15)+Math.random()*(((Integer.parseInt(
                                    (Converters.fetchString(MemoryBank.dbRace,
                                    genstats[2],5))))*.40)));

                                //defines age: min 15% race age/max 40% race age
                                
                                String genSize=dataQuery("*","dbSize","sizeName"
                                    ,(Calculator.getSize((Converters.fetchString
                                    (MemoryBank.dbRace,genstats[2],1)),
                                    Calculator.getAge(genage,genstats[2]))),
                                    false,false,null,null).get(0);
                                List<String> gentoonstats = new ArrayList<>();
                                
                                int genalign=(int)((Integer.parseInt(genstats[5]
                                    )-Integer.parseInt(genstats[4]))*Math.random
                                    ())+Integer.parseInt(genstats[4]);
                                gentoonstats.add(0, "");
                                gentoonstats.add(1,(genstats[1]+" #"+genidnums
                                    [y-1]));
                                gentoonstats.add(2,genstats[2]);
                                gentoonstats.add(3,genstats[3]);
                                gentoonstats.add(4,String.valueOf(genalign));
                                gentoonstats.add(5,"1");
                                gentoonstats.add(6,genstats[6]);
                                gentoonstats.add(7,String.valueOf(genage));
                                gentoonstats.add(8,String.valueOf(startlv));
                                gentoonstats.add(9,genstats[9]);
                                gentoonstats.add(10,genstats[10]);
                                gentoonstats.add(11,genstats[11]);
                                gentoonstats.add(12,genstats[12]);
                                gentoonstats.add(13,genstats[13]);
                                gentoonstats.add(14,genstats[14]);
                                gentoonstats.add(15,genstats[15]);
                                gentoonstats.add(16,genstats[16]);
                                gentoonstats.add(17,"");
                                gentoonstats.add(18,"");
                                gentoonstats.add(19,"0");
                                String genStats=(GetStats.getStats("Toon",
                                    gentoonstats.toArray(new String[0]),ratioXP,
                                    true).toString()).replaceAll(", ","x");
                                genStats=genStats.substring(1,genStats.length()
                                    -1);
                                String tempGen=(Arrays.toString(gentoonstats.
                                    toArray()));
                                tempGen=tempGen.substring(3,tempGen.length() -1)
                                    .replace(", ", ",");
                                tempGen=tempGen+","+genStats+","+genExp+","+
                                    genSize+",0";
                                gentoons.add(tempGen);
                            }
                            gensremain -= makenumber;
                        }
                    }
                }
            } 
        } 
    }

    private static void buildAlts(List<String> alttoons) throws 
        SQLException, IOException, InterruptedException {
        for(int toonidx = 0; toonidx < buildingToonsOG; toonidx++) {
            String[] toon = (StartGame.savToons.get(toonidx)).replaceAll(", ",
                ",").split(",");
            String toonuid=toon[5];
            if(!toonuid.startsWith("7")) {
                String altvalue=toon[18];
                if(!altvalue.equals("null") && !altvalue.isEmpty()) {
                    String[] altstats = Converters.expListtoArray(MemoryBank.
                        dbAlias.get(Integer.parseInt(altvalue)));
                    String alttype=altstats[2];
                    if(!alttype.equals("1") && !alttype.equals("2") && !alttype.
                        equals("3")) {
                        //0 name only no secret -- nothing
                    } else {
                        //1 transformation no secret
                        //2 secret with fake stats
                        //3 secret with transformation
                        List<String> alttoonstats=altBuilder(toon,toonidx,
                            altstats);
                        String tmpAlt=(Arrays.toString(alttoonstats.toArray()));
                        tmpAlt = tmpAlt.substring(3,tmpAlt.length() -1).replace(
                            ", ", ",");
                        alttoons.add(tmpAlt);
                    }
                }
            }
        }
    }
    
    private static List<String> altBuilder(String[] ogtoonstats,int toonidx,
        String[]altstats) throws SQLException,IOException,InterruptedException{
        List<String> alttoonstats = new ArrayList<>();
        //alt id 0
        alttoonstats.add(0,"");
        //alt name 1
        alttoonstats.add(1,altstats[1]);
        //alt race 2
        if(altstats[3].equals("=") || altstats[3].equals("null") || 
            altstats[3].isEmpty()) {
            alttoonstats.add(2,ogtoonstats[2]);
        } else  {
            alttoonstats.add(2,altstats[3]);
        }
        //alt class 3
        String jobid = altstats[6];
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(3,ogtoonstats[3]);
        } else {
            String[] jobstats = Converters.expListtoArray(MemoryBank.dbJobs.get(
                Integer.parseInt(jobid)));
            alttoonstats.set(2,jobstats[2]);
            alttoonstats.add(3, jobstats[3]);
        }
        //alt align 4
        alttoonstats.add(4,String.valueOf(ogtoonstats[4]));
        //alt uid 5
        alttoonstats.add(5,"7x"+toonidx);
        //alt gender 6
        if(altstats[5].equals("=") || altstats[5].equals("null") || 
            altstats[5].isEmpty()) {
            alttoonstats.add(6,ogtoonstats[6]);
        } else  {
            alttoonstats.add(6,altstats[5]);
        }
        //alt age 7
        if(!ogtoonstats[2].equals(alttoonstats.get(2))) {
            double ageratio=Double.parseDouble(ogtoonstats[7])/Double.
                parseDouble(Converters.fetchString(MemoryBank.dbRace,ogtoonstats
                [2],5));
            int altage=(int)(ageratio*(Integer.parseInt(Converters.fetchString(
                MemoryBank.dbRace,alttoonstats.get(2),5))));
            alttoonstats.add(7,String.valueOf(altage));
        } else {
            alttoonstats.add(7,ogtoonstats[7]);
        }
        //alt startlv 8
        int altlv = (int)(Integer.parseInt(ogtoonstats[8])*(.01*(20+(Math.random
            ()*80))));
        String altexp=String.valueOf((int)Double.parseDouble(Calculator.getLevel
            ("ranxp",(String.valueOf(altlv)))));
        double altratioXP=Double.parseDouble(altexp)/(Double.parseDouble(
            Calculator.getLevel("stalv",String.valueOf(altlv + 1))));                        
        alttoonstats.add(8,String.valueOf(altlv));
        //alt bio 9
        alttoonstats.add(9,altstats[7]);
        //alt image 10
        alttoonstats.add(10,altstats[8]);
        //alt abl 11
        alttoonstats.add(11,"");
        //alt eff 12
        alttoonstats.add(12,"");
        //alt held 13
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(13,ogtoonstats[13]);
        } else {                  
            alttoonstats.add(13,Converters.fetchString(MemoryBank.dbJobs,jobid,5
                ));
        }
        //alt wear 14
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(14,ogtoonstats[14]);
        } else {    
            alttoonstats.add(14,Converters.fetchString(MemoryBank.dbJobs,jobid,6
                ));
        }
        //alt charms 15
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(15,ogtoonstats[15]);
        } else {                  
            alttoonstats.add(15,Converters.fetchString(MemoryBank.dbJobs,jobid,7
                ));
        }
        //alt inv 16
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(16,ogtoonstats[16]);
        } else {                  
            alttoonstats.add(16,Converters.fetchString(MemoryBank.dbJobs,jobid,8
                ));
        }
        //alt inv 17
        alttoonstats.add(17,ogtoonstats[17]);
        //alt alias 18
        alttoonstats.add(18,null);
        //alt destiny 19
        alttoonstats.add(19,dataQuery("*","dbDestiny","destinyName","Passive",
            false,false,null,null).get(0));
        //alt toonstats 20
        String altStats=(GetStats.getStats("Toon",alttoonstats.toArray(
            new String[0]),altratioXP,true).toString()).replaceAll(", ","x");
        altStats=altStats.substring(1,altStats.length()-1);
        alttoonstats.add(20,altStats);
        //alt toonexp 21
        alttoonstats.add(21,String.valueOf(altexp));
        //alt toonsize 22
        String altsize=dataQuery("*","dbSize","sizeName",(Calculator.
            getSize((Converters.fetchString(MemoryBank.dbRace,alttoonstats.
            get(2),1)),(Calculator.getAge(Integer.parseInt(alttoonstats.get(7)),
            alttoonstats.get(2))))),false,false,null,null).get(0);
        alttoonstats.add(22,altsize);
        //alt toonteam 23
        alttoonstats.add(23,ogtoonstats[23]);
        return alttoonstats;
    }

    private static void sendtoNewDB(String game,List<String> savtoons,
        List<String> gentoons,List<String> alttoons) throws IOException, 
        InterruptedException, SQLException {
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        String savepath=(MainControls.savesDir+Converters.capFirstLetter((
            MainControls.selectedSave))).replaceAll(MainControls.saveExt+"."
            +MainControls.saveExt,MainControls.saveExt);
        List<String> newSaveToons = new ArrayList<>();
        try (Connection con=DriverManager.getConnection("jdbc:ucanaccess://"+
            savepath,db2,db3)) {
            try (Statement s = con.createStatement()) {
                Database db = new DatabaseBuilder().setAutoSync(false).setFile(
                    new File(savepath)).open();
        // sav
                Table tbl = db.getTable(savetoons);
                long totalsavtoons = savtoons.size();
                for(int i=0;i<totalsavtoons;i++) {
                    String[] tempsavToon = savtoons.get(i).replaceAll(", ",",").
                        split(",");
                    newSaveToons.add(Arrays.toString(tempsavToon).substring(1,
                        Arrays.toString(tempsavToon).length()-1).replaceAll(", "
                        ,","));
                    tbl.addRow(tempsavToon[0],tempsavToon[1],
                        tempsavToon[2],tempsavToon[3],tempsavToon[4],
                        tempsavToon[5],tempsavToon[6],tempsavToon[7],
                        tempsavToon[8],tempsavToon[9],tempsavToon[10],
                        tempsavToon[11],tempsavToon[12],tempsavToon[13],
                        tempsavToon[14],tempsavToon[15],tempsavToon[16],
                        tempsavToon[17],tempsavToon[18],tempsavToon[19],
                        tempsavToon[20],tempsavToon[21],tempsavToon[22],
                        tempsavToon[23]);
                }
        //gens
                long totalgentoons = gentoons.size();
                for(int i=0;i<totalgentoons;i++) {
                    String[] tempgenToon = gentoons.get(i).replaceAll(", ",",").
                        split(",");
                    int genid = buildingToons;
                    newSaveToons.add(genid+", "+Arrays.toString(tempgenToon)
                        .substring(1,Arrays.toString(tempgenToon).length()-1).
                        replaceAll(", ",","));
                    tbl.addRow(genid, tempgenToon[0],
                        tempgenToon[1],tempgenToon[2],
                        tempgenToon[3],tempgenToon[4],
                        tempgenToon[5],tempgenToon[6],
                        tempgenToon[7],tempgenToon[8],
                        tempgenToon[9],tempgenToon[10],
                        tempgenToon[11],tempgenToon[12],
                        tempgenToon[13],tempgenToon[14],
                        tempgenToon[15],tempgenToon[16],
                        tempgenToon[17],tempgenToon[18],
                        tempgenToon[19],tempgenToon[20],
                        tempgenToon[21],tempgenToon[22]);
                    buildingToons += 1;
                }
        //alts
                long totalalttoons = alttoons.size();
                for(int i=0;i<totalalttoons;i++) {
                    String[] tempaltToon = alttoons.get(i).replaceAll(", ",",").
                        split(",");
                    int altid = buildingToons;
                    newSaveToons.add(altid+", "+Arrays.toString(tempaltToon)
                        .substring(1,Arrays.toString(tempaltToon).length()-1).
                        replaceAll(", ",","));
                    tbl.addRow(String.valueOf(altid),tempaltToon[0],
                        tempaltToon[1],tempaltToon[2],tempaltToon[3],
                        tempaltToon[4],tempaltToon[5],tempaltToon[6],
                        tempaltToon[7],tempaltToon[8],tempaltToon[9],
                        tempaltToon[10],tempaltToon[11],tempaltToon[12],
                        tempaltToon[13],tempaltToon[14],tempaltToon[15],
                        tempaltToon[16],tempaltToon[17],tempaltToon[18],
                        tempaltToon[19],tempaltToon[20],tempaltToon[21],
                        tempaltToon[22]);
                    buildingToons += 1;
                }
            }
        }
        MemoryBank.savToons = newSaveToons;
        for(int i=0;i<MemoryBank.savToons.size();i++) {
            System.out.println(MemoryBank.savToons.get(i));
        }
        StartGame.savToons = new ArrayList<>();
        StartGame.genToons = new ArrayList<>();
        StartGame.altToons = new ArrayList<>();
    }
    
    public static void buildBattle(String save, String game) throws IOException,
        SQLException, InterruptedException {
        createBattleTbl(save,game);
        buildBattleTable(game,Arrays.asList(BattleEngine.team0),"0");
        Thread.sleep(350);
        buildBattleTable(game,Arrays.asList(BattleEngine.team1),"1");
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
    
    private static void buildBattleTable(String game,List<String> 
        team,String teamno) throws SQLException,InterruptedException,IOException
        {
        String battletable = "battle" + game.toLowerCase() + "Toons";
        int numbertoons = team.size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            String[] toonstats = MemoryBank.savToons.get(Integer.parseInt(String
                .valueOf(team.get(toonidx)))).replaceAll(", ",",").split(",");
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
            String[] charmlist = GetStats.fetchitemStats("Charm",toonstats,
                baselist);
            String[] wearlist = GetStats.fetchitemStats("Wear",toonstats,
                baselist);
            String[] heldlist = GetStats.fetchitemStats("Held",toonstats,
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
    
    static Charset determineCharset(Path path) throws IOException {
        
        byte[] bytes = Files.readAllBytes(path);
        for (int i = 0; i < bytes.length; ++i) {
            byte b = bytes[i];
            if (b == 0) {
                return i % 2 == 0
                        ? StandardCharsets.UTF_16
                        : StandardCharsets.UTF_16LE;
            }
            if (b < 0) {
                int high1s= 0; 
                while ((b & 0x80) == 0x80) {
                    ++high1s;
                    b = (byte)(b << 1);
                } 
                if (high1s == 1 || i + high1s > bytes.length) {
                    return Charset.defaultCharset()
                        .equals(StandardCharsets.UTF_8)
                        ? StandardCharsets.ISO_8859_1
                        : Charset.defaultCharset();
                }
                int contBytes = high1s - 1;
                while (i + 1 < bytes.length
                        && (bytes[i+1] & 0b1100_0000)
                           == 0b1000_0000) {
                     ++i;
                     --contBytes;
                }
                if (contBytes != 0) {
                    return Charset.defaultCharset()
                        .equals(StandardCharsets.UTF_8)
                        ? StandardCharsets.ISO_8859_1
                        : Charset.defaultCharset();
                }
            }
        }
        return StandardCharsets.UTF_8;
    }
    
}