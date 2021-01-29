package clarktribegames;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
//    static String db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + 
//    MainControls.defaultSave;
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
        setDb1();
        String db1=MemoryBank.db1;
        Statement st;
        if(!SecondaryQ) {
            
//            String limitFile=MainControls.savesDir + MainControls.selectedSave;
//            db1 = "jdbc:ucanaccess://" + limitFile;
            Connection con=DriverManager.getConnection(db1,db2,db3);
            st = con.createStatement();
        } else {
            db1=carriedDb1;
            st=carriedSt;
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
            DriverManager.getConnection(db1,db2,db3).close();
        }
        System.gc();
        return convertedList; 
    }
    
    private static void setDb1() {
        if(MemoryBank.ingame) {
            MemoryBank.db1="jdbc:ucanaccess://"+MemoryBank.currentSave;
        } else {
            MemoryBank.db1="jdbc:ucanaccess://"+MemoryBank.currentDb;
        }
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
    
    public static void dataUpdateSingle(String table,String setfield,String 
        newvalue,String matchcol, String matchvalue) throws SQLException {
//        String limitFile=MainControls.savesDir + MainControls.selectedSave;
//        db1 = "jdbc:ucanaccess://" + limitFile;
        setDb1();
        String db1 = MemoryBank.db1;
        Connection con=DriverManager.getConnection(db1,db2,db3);
        String sql=("UPDATE "+table+" SET "+setfield+"=? WHERE "+matchcol+"=?");
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1,newvalue);
            st.setString(2,matchvalue);
            int rowsUpdate = st.executeUpdate();
            }
        DriverManager.getConnection(db1,db2,db3).close();
    }
    
    public static void createnewSave()throws SQLException
        , IOException, InterruptedException, Exception {
        try{
        
        //reset variables
        buildingToons=0;
        buildingToonsOG=0;
        StartGame.savToons=new ArrayList<>();
        StartGame.genToons=new ArrayList<>();
        StartGame.altToons=new ArrayList<>();
        String savetoons="sav"+MemoryBank.currentGame.toLowerCase()+"Toons";
        createSav("dbToons",savetoons);
        buildtoonSave(StartGame.savToons);
        buildGenerics(StartGame.genToons);
        buildAlts(StartGame.altToons);
        sendtoNewDB(StartGame.savToons,StartGame.genToons,StartGame.altToons);
        MemoryBank.created=true;
        } catch (Exception ex) {
            LogWriter.logFile("severe", "Alt Build Error. EX: " + ex);
        }
    }

    private static void createSav(String oldtable,String newtable) 
        throws SQLException {
        setDb1();
        String db1=MemoryBank.db1;
        //db1="jdbc:ucanaccess://"+save;
//        db1=db1.replaceAll(MainControls.saveExt+"."+MainControls.saveExt,
//            MainControls.saveExt);
        try (Connection con=DriverManager.getConnection(db1,db2,db3)) {
//            String savepath=MainControls.savesDir+Converters.capFirstLetter(
//                (MainControls.selectedSave).substring(0,(MainControls
//                .selectedSave).indexOf("."+MainControls.saveExt)))+"."+
//                MainControls.saveExt;
            try (Statement s=con.createStatement()) {
                try (ResultSet rs=s.executeQuery("SELECT * FROM ["+oldtable+"]")
                    ) {
                    Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(MemoryBank.currentSave)).open();
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
                        Table table2 = new TableBuilder("dbTime").addColumn(new
                            ColumnBuilder("timeID",DataType.TEXT)).addColumn(new
                            ColumnBuilder("rawTime",DataType.TEXT)).toTable(db);
                        Table table3 = db.getTable("dbTime");
                        table3.addRow("0","0");
                        Table table4=new TableBuilder("saveSettings").addColumn
                            (new ColumnBuilder("savesetID",DataType.TEXT)).
                            addColumn(new ColumnBuilder("savesetName",DataType.
                            TEXT)).addColumn(new ColumnBuilder("savesetConfig",
                            DataType.MEMO)).toTable(db);
                        table4.addRow("0","database",MemoryBank.currentDb);
                        table4.addRow("1","playertoon","");
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
            String toonSize=Converters.fetchfromTable(MemoryBank.dbSize,
                Calculator.getSize(Converters.fetchfromTable(MemoryBank.dbRace,
                toonstats[2],0,1),Calculator.getAge(Integer.parseInt(toonstats
                [7]),toonstats[2])),1,0);
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
                        String rawmax=Converters.fetchfromTable(MemoryBank.
                            dbGeneric,String.valueOf(x),0,17);
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
                                    .fetchfromTable(MemoryBank.dbRace,genstats
                                    [2],0,5))))*.15)+Math.random()*(((Integer.
                                    parseInt(Converters.fetchfromTable(
                                    MemoryBank.dbRace,genstats[2],0,5)))*.40)));

                                //defines age: min 15% race age/max 40% race age
                                
                                String genSize=Converters.fetchfromTable(
                                    MemoryBank.dbSize,Calculator.getSize(
                                    Converters.fetchfromTable(MemoryBank.dbRace,
                                    genstats[2],0,1),Calculator.getAge(genage,
                                    genstats[2])),1,0);
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
                parseDouble(Converters.fetchfromTable(MemoryBank.dbRace,
                ogtoonstats[2],0,5));
            int altage=(int)(ageratio*(Integer.parseInt(Converters.
                fetchfromTable(MemoryBank.dbRace,alttoonstats.get(2),0,5))));
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
            alttoonstats.add(13,Converters.fetchfromTable(MemoryBank.dbJobs,
            jobid,0,5));
        }
        //alt wear 14
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(14,ogtoonstats[14]);
        } else {    
            alttoonstats.add(14,Converters.fetchfromTable(MemoryBank.dbJobs,
            jobid,0,6));
        }
        //alt charms 15
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(15,ogtoonstats[15]);
        } else {                  
            alttoonstats.add(15,Converters.fetchfromTable(MemoryBank.dbJobs,
                jobid,0,7));
        }
        //alt inv 16
        if(jobid.equals("=") || jobid.equals("null") || jobid.isEmpty()) {
            alttoonstats.add(16,ogtoonstats[16]);
        } else {                  
            alttoonstats.add(16,Converters.fetchfromTable(MemoryBank.dbJobs,
                jobid,0,8));
        }
        //alt inv 17
        alttoonstats.add(17,ogtoonstats[17]);
        //alt alias 18
        alttoonstats.add(18,null);
        //alt destiny 19
        alttoonstats.add(19,Converters.fetchfromTable(MemoryBank.dbDestiny,
            "Passive",1,0));
        //alt toonstats 20
        String altStats=(GetStats.getStats("Toon",alttoonstats.toArray(
            new String[0]),altratioXP,true).toString()).replaceAll(", ","x");
        altStats=altStats.substring(1,altStats.length()-1);
        alttoonstats.add(20,altStats);
        //alt toonexp 21
        alttoonstats.add(21,String.valueOf(altexp));
        //alt toonsize 22
        String altsize=Converters.fetchfromTable(MemoryBank.dbSize,(Calculator.
            getSize(Converters.fetchfromTable(MemoryBank.dbRace,alttoonstats.get
            (2),0,1),(Calculator.getAge(Integer.parseInt(alttoonstats.get(7)),
            alttoonstats.get(2))))),1,0);
        alttoonstats.add(22,altsize);
        //alt toonteam 23
        alttoonstats.add(23,ogtoonstats[23]);
        return alttoonstats;
    }

    private static void sendtoNewDB(List<String> savtoons,List<String> gentoons,
        List<String> alttoons) throws IOException,InterruptedException,
        SQLException {
        String savetoons="sav"+MemoryBank.currentGame.toLowerCase()+"Toons";
//        String savepath=(MainControls.savesDir+Converters.capFirstLetter((
//            MainControls.selectedSave))).replaceAll(MainControls.saveExt+"."
//            +MainControls.saveExt,MainControls.saveExt);
        List<String> newSaveToons = new ArrayList<>();
        setDb1();
        String db1=MemoryBank.db1;
        try (Connection con=DriverManager.getConnection(db1,db2,db3)) {
            try (Statement s = con.createStatement()) {
                Database db = new DatabaseBuilder().setAutoSync(false).setFile(
                    new File(MemoryBank.currentSave)).open();
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
        }
        StartGame.savToons = new ArrayList<>();
        StartGame.genToons = new ArrayList<>();
        StartGame.altToons = new ArrayList<>();
    }
    
//    public static void buildBattle(String game) throws IOException,
//        SQLException, InterruptedException {
////        createBattleTbl(game);
////        buildBattleTable(game,Arrays.asList(BattleEngine.team0),"0");
////        Thread.sleep(350);
////        buildBattleTable(game,Arrays.asList(BattleEngine.team1),"1");
////        Thread.sleep(700);
////        copyTab(save,"battle"+game.toLowerCase()+"Toons","battle"+game
////            .toLowerCase()+"Max");
//    }
    
//    private static void createBattleTbl(String game) throws 
//        IOException, InterruptedException {
//        String battletable = "battle" + game.toLowerCase() + "Toons";
//        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
//            MainControls.saveExt;
//        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
//            MainControls.saveExt);
//            try (Connection con = DriverManager.getConnection(db1, db2, db3)) {
//            String savepath = MainControls.savesDir + Converters.capFirstLetter(
//                (MainControls.selectedSave).substring(0,(MainControls
//                .selectedSave).indexOf("." + MainControls.saveExt))) + "." + 
//                MainControls.saveExt;
//            try (Statement s = con.createStatement()) {
//                Database db=new DatabaseBuilder().setAutoSync(false).setFile
//                        (new File(savepath)).open();
//                Table table = new TableBuilder(battletable)
//                    .addColumn(new ColumnBuilder("toonID",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonName",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonRace",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonClass",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonAlignRank",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonUID",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonGen",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("teamAge",DataType.TEXT))                        
//                    .addColumn(new ColumnBuilder("toonLv",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonBio",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonImage",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonAbl",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonEff",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonHeld",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonWear",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonCharms",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonInv",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonAlias",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonAKnown",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("baseStats",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonExp",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonSize",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonTeam",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("combinedStats",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonAlignment",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("toonGender",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("teamAgeGroup",DataType.TEXT))                        
//                    .addColumn(new ColumnBuilder("teamSizeName",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("teamRaceName",DataType.TEXT))
//                    .addColumn(new ColumnBuilder("teamClassName",DataType.TEXT))
//                    .toTable (db);
//                    db.flush();
//            }
//            con.close(); 
//            Thread.sleep(350);
//        } catch (Exception e) {
//            String savepath = MainControls.savesDir + Converters.capFirstLetter(
//                (MainControls.selectedSave).substring(0,(MainControls
//                .selectedSave).indexOf("." + MainControls.saveExt))) + "." + 
//                MainControls.saveExt;
//            Database db=new DatabaseBuilder().setAutoSync(false).setFile
//                        (new File(savepath)).open();
//            Table t = db.getTable(battletable);
//            for (Row r : t) {
//                t.deleteRow(r);
//            }
//            Table t2 = db.getTable(battletable.replaceAll("Toons", "Max"));
//            for (Row r : t2) {
//                t2.deleteRow(r);
//            }
//            Thread.sleep(350);
//        }
//    }
    
    private static void buildBattleTable(String game,List<String> 
        team,String teamno) throws SQLException,InterruptedException,IOException
        {
        String battletable = "battle" + game.toLowerCase() + "Toons";
        int numbertoons = team.size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            String[] toonstats = MemoryBank.savToons.get(Integer.parseInt(String
                .valueOf(team.get(toonidx)))).replaceAll(", ",",").split(",");
            String raceSize=Converters.fetchfromTable(MemoryBank.dbRace,
                toonstats[2],0,1);
            String toonSize=Converters.fetchfromTable(MemoryBank.dbSize,Calculator.
                getSize(raceSize,(Calculator.getAge(Integer.parseInt(toonstats
                [7]),toonstats[2]))),1,0);
//            String savepath=(MainControls.savesDir + Converters.capFirstLetter((
//                MainControls.selectedSave))).replaceAll(MainControls.saveExt+"."
//                +MainControls.saveExt, MainControls.saveExt);
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
            String AlignName=Converters.fetchfromTable(MemoryBank.dbAlign,
                Calculator.getAlign(Integer.parseInt(toonstats[4])),0,1);
            String GenderName=Converters.fetchfromTable(MemoryBank.dbGender,
                toonstats[6],0,1);
            String AgeGroup=Calculator.getAge(Integer.parseInt(toonstats[7]),
                toonstats[2]);
            String SizeName=Converters.fetchfromTable(MemoryBank.dbSize,toonSize
                ,0,1);
            String RaceName=Converters.fetchfromTable(MemoryBank.dbRace,
                toonstats[2],0,1);
            String ClassName=Converters.fetchfromTable(MemoryBank.dbClass,
                toonstats[3],0,1);
            setDb1();
            String db1=MemoryBank.db1;
            try (Connection con=DriverManager.getConnection(db1, db2, db3)) {
                try (Statement s = con.createStatement()) {
                    Database db = new DatabaseBuilder().setAutoSync(false)
                        .setFile(new File(MemoryBank.currentSave)).open();
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
//            String saveFolder=MainControls.savesDir + savegameList.
//                getSelectedValue().toString().toLowerCase();
            
            //**Set something to get save here**
            MemoryBank.currentSave=MainControls.savesDir+savegameList.
                getSelectedValue().toString().toLowerCase()+MainControls.saveExt
                ;
            MemoryBank.ingame=true;
            String toonID=GetData.dataQuery("*","saveSettings","savesetName",
                "playertoon",false,false,null,null).get(2);
//            String toonID = ChecksBalances.getFirstLine(new File(saveFolder + 
//                "/.lastused"));
           
//            MainControls.selectedSave=savegameList.getSelectedValue().toString()
//                .toLowerCase() + "/" + MainControls.selectedSave;
            String[] savedToonInfo=Converters.expListtoArray(MemoryBank.savToons
                .get(Integer.parseInt(toonID)));
            String toonGender=Converters.fetchfromTable(MemoryBank.dbGender,
                savedToonInfo[6],0,1);
            String toonRace=Converters.fetchfromTable(MemoryBank.dbRace,
                savedToonInfo[2],0,1);
            String toonClass=Converters.fetchfromTable(MemoryBank.dbClass,
                savedToonInfo[3],0,1);
            savedToonStats.setForeground(Converters.figureoutColor(GetStats
                .getalignColor(Integer.parseInt((savedToonInfo[4])))));
            Avatars.setAvatar(savedToon,savedToonInfo[1],savedToonInfo[10]);
            savedToonName.setText(savedToonInfo[1]);
            //use savedToonRank for date + rank
            int lastRawTime=Integer.parseInt(GetData.dataQuery("*","dbTime",
                "timeID","0",false,false,null,null).get(1));
            String[] tempDateTime=Converters.convertTime(lastRawTime);
//               String lastused=MainControls.savesDir+savegameList.getSelectedValue
//                ().toString().toLowerCase()+"/.lastused";
//            String[] tempDateTime=Converters.convertTime(Integer.parseInt(
//                Converters.getSpecificLine(lastused,2)));
            savedToonRankDate.setText("Yr "+tempDateTime[0]+" Mo "+
                tempDateTime[1]+" Wk "+tempDateTime[2]+" Day "+tempDateTime[3]+
                " : Hr "+tempDateTime[4]+" Min "+tempDateTime[5]);
            savedToonStats.setText(Calculator.getAge(Integer.parseInt(
                savedToonInfo[7]),savedToonInfo[2])+" "+toonRace+" "+toonClass+
                " "+toonGender);
            savedToonLevel.setText("Level "+savedToonInfo[8]);
        } catch (NumberFormatException | SQLException | 
            NullPointerException ex) {
            if(Limitless.lgList.getModel().getSize() > 0) {
                Limitless.lgList.setSelectedIndex(0);
            }
        }
        MemoryBank.currentSave="";
        MemoryBank.ingame=false;
//            MainControls.selectedSave = MainControls.defaultSave;
    }
    
    public static List<String> getNewGameToonList() throws SQLException {
        List<String> newgametoonList = new ArrayList<>();
        for(int i=0;i<MemoryBank.savToons.size();i++) {
            newgametoonList.add(Converters.fetchfromTable(MemoryBank.savToons,
                String.valueOf(i),0,1));
        }
        return newgametoonList;
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