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

    public static List<String> dbQuery(String save,String search,String table,
        String col,String matchstr,boolean isitSingle) throws SQLException {
        String tempList = "";
        if (!isitSingle) {
            tempList = (getSpecificRecord(save, search, table, col,
                    matchstr)).replaceAll("\\[", "").replaceAll("\\]","");
        } else {
            tempList = (getSingleList(save, search, table, col))
                    .replaceAll("\\[", "").replaceAll("\\]","");
        }
        String[] stringList = tempList.split(",");
        List<String> convertedList = Arrays.asList(stringList);
        System.gc();
        return convertedList;
    }
    
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
    
    private static String getSingleList(String save, String search,String table,
        String column) throws SQLException {
        if(!(MainControls.savesDir.equals("saves/"))) {
            db1 = "jdbc:ucanaccess://" + MainControls.savesDir.substring(0,
                MainControls.savesDir.length() -1) + "/" + save.toLowerCase() 
                + "." + MainControls.saveExt;
        } else {
            db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save.
                toLowerCase() + "." + MainControls.saveExt;
        }
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
            MainControls.saveExt);
        String result = "";
        Connection con = DriverManager.getConnection(db1, db2, db3);
        Statement st = con.createStatement();
        String query = ("select " + search + " from " + table);
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            result = result + "," + rs.getString(column);
        }
        st.close();
        con.close();
        result = result.substring(1,result.length());
        return result;
    }
    
    private static String getSpecificRecord(String save, String search,String 
        table, String column, String matchstr) throws SQLException {
        if(!(MainControls.savesDir.equals("saves/"))) {
            db1 = "jdbc:ucanaccess://" + MainControls.savesDir.substring(0, 
                MainControls.savesDir.length() -1) + "/" + save.toLowerCase() + 
                "." + MainControls.saveExt;
        } else {
            db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save
                .toLowerCase() + "." + MainControls.saveExt;
        }
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
            MainControls.saveExt);
        String match = (column + "=\"" + matchstr + "\"");
        String result = "";
        
        Connection con = DriverManager.getConnection(db1, db2, db3);
        Statement st = con.createStatement();
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
        st.close();
        con.close();
        result = result.substring(1,result.length());
        return result;
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
        , IOException, InterruptedException {
        copyTab(save,"dbToons", "sav" + game.toLowerCase() + "Toons");
        buildtoonSave(save,game);
        copyTab(save,"sav"+game.toLowerCase()+"Toons","sav"+game.toLowerCase()+ 
            "Max");
        MainControls.created = true;
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
                    Thread.sleep(750);
                    Database db=new DatabaseBuilder().setAutoSync(false).setFile
                        (new File(savepath)).open();
                    ImportUtil.importResultSet(rs, db, newtable,new 
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
                        String temptable = newtable.replaceAll("Toons", "Temp");
                        Table table = new TableBuilder(temptable).addColumn(new 
                            ColumnBuilder("tempID",DataType.TEXT)).addColumn(new
                            ColumnBuilder("tempStats",DataType.TEXT)).toTable
                            (db);
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
    
    private static void buildtoonSave(String save, String game) throws 
            SQLException, IOException, InterruptedException {
        String savetoons = "sav" + game.toLowerCase() + "Toons";
        int numbertoons = GetData.dbQuery(save,"*",savetoons,"toonID",null,true)
            .size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            List<String> toonstats = GetData.dbQuery(save,"*",savetoons,"toonID"
                ,String.valueOf(toonidx),false);
            String toonExp = String.valueOf((int) Double.parseDouble(Calculator
                .getLevel("ranxp",(toonstats.get(8)))));
            double ratioXP = Double.parseDouble(toonExp) / (Double.parseDouble
                (Calculator.getLevel("stalv", String.valueOf(Integer.parseInt
                (toonstats.get(8) + 1)))));
            String toonSize = GetData.dbQuery(save, "*","dbSize","sizeName",
                (Calculator.getSize(((GetData.dbQuery(save,"*","dbRace","raceID"
                ,toonstats.get(2), false)).get(1)), (Calculator.getAge(Integer
                .parseInt(toonstats.get(7)),toonstats.get(2))))),false).get(0);
            //temp is built here
            String toonStats = (GetStats.getStats("Toon",toonstats,ratioXP,true)
                .toString()).replaceAll(", ", "x");
            toonStats = toonStats.substring(1, toonStats.length() - 1);
            String savepath = (MainControls.savesDir + Converters.capFirstLetter
                ((MainControls.selectedSave))).replaceAll(MainControls.saveExt +
                    "." + MainControls.saveExt, MainControls.saveExt);;
            Thread.sleep(750);
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

        }
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
            List<String> toonstats = GetData.dbQuery(save,"*",savetoons,"toonID"
                ,String.valueOf(team.get(toonidx)),false);
            String toonSize = GetData.dbQuery(save, "*","dbSize","sizeName",
                (Calculator.getSize(((GetData.dbQuery(save,"*","dbRace","raceID"
                ,toonstats.get(2), false)).get(1)), (Calculator.getAge(Integer
                .parseInt(toonstats.get(7)),toonstats.get(2))))),false).get(0);
            String savepath = (MainControls.savesDir + Converters.capFirstLetter
                ((MainControls.selectedSave))).replaceAll(MainControls.saveExt +
                    "." + MainControls.saveExt, MainControls.saveExt);;
            String[] toonbasestats = (toonstats.get(20)).split("x");
            List<String> baselist = new ArrayList<>();
            baselist.addAll(Arrays.asList(toonbasestats));
            List<String> charmlist = GetStats.fetchitemStats(save,"Charm",
                toonstats,baselist);
            List<String> wearlist = GetStats.fetchitemStats(save,"Wear",
                toonstats,baselist);
            List<String> heldlist = GetStats.fetchitemStats(save,"Held",
                toonstats,baselist);
            List<String> combined = new ArrayList<>();
            for(int x = 0; x < charmlist.size(); x++) {
                double total = Double.parseDouble(baselist.get(x)) + Double
                    .parseDouble(charmlist.get(x)) + Double.parseDouble(wearlist
                    .get(x)) + Double.parseDouble(heldlist.get(x));
                combined.add(String.valueOf((int) total));
            }
            String AlignName=(GetData.dbQuery(save,"*","dbAlign","alignID",(
                Calculator.getAlign(Integer.parseInt(toonstats.get(4)))),false))
                .get(1);
            String GenderName=(GetData.dbQuery(save,"*","dbGender","genderID",
                toonstats.get(6),false)).get(1);
            String AgeGroup=Calculator.getAge(Integer.parseInt(toonstats.get(7))
                ,((GetData.dbQuery(save,"*","dbRace","raceID",(toonstats.get(2))
                ,false)).get(0)));
            String SizeName=(GetData.dbQuery(save,"*","dbSize","sizeID",toonSize
                ,false)).get(1);
            String RaceName=(GetData.dbQuery(save,"*","dbRace","raceID",
                toonstats.get(2),false)).get(1);
            String ClassName=(GetData.dbQuery(save,"*","dbClass","classID",
                toonstats.get(3),false).get(1));

            try (Connection con=DriverManager.getConnection("jdbc:ucanaccess://"
                + savepath, db2, db3)) {
                try (Statement s = con.createStatement()) {
                    Database db = new DatabaseBuilder().setAutoSync(false)
                        .setFile(new File(savepath)).open();
                    Table tbl = db.getTable(battletable);
                    tbl.addRow(toonstats.get(0),toonstats.get(1),toonstats.get(2
                        ),toonstats.get(3),toonstats.get(4),toonstats.get(5),
                        toonstats.get(6),toonstats.get(7),toonstats.get(8),
                        toonstats.get(9),toonstats.get(10),toonstats.get(11),
                        toonstats.get(12),toonstats.get(13),toonstats.get(14),
                        toonstats.get(15),toonstats.get(16),toonstats.get(17),
                        toonstats.get(18),toonstats.get(20),toonstats.get(21),
                        toonstats.get(22),teamno,(combined.stream().collect
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
        JLabel savedToonName,JLabel savedToonRankDate,JLabel savedToonStats, JLabel 
        savedToonLevel) throws IOException, SQLException {
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
            Avatars.setAvatar(savedToon,savedToonInfo.get(1),saveFolder);
            savedToonName.setText(savedToonInfo.get(1));
            //use savedToonRank for date + rank
            String lastused = MainControls.savesDir + savegameList.getSelectedValue().toString().toLowerCase() + "/.lastused";
            String[] tempDateTime = Converters.convertTime(Integer.parseInt(Converters.getSpecificLine(lastused, 2)));
            savedToonRankDate.setText("Yr " + tempDateTime[0] + " Mo " + tempDateTime[1] + " Wk " + tempDateTime[2] + " Day " + tempDateTime[3] + " : Hr " + tempDateTime[4] + " Min " + tempDateTime[5]);
            savedToonStats.setText(Calculator.getAge(Integer.parseInt(
                savedToonInfo.get(7)), savedToonInfo.get(2)) + " " + toonRace + 
                " "+ toonClass + " " + toonGender);
            savedToonLevel.setText("Level " + savedToonInfo.get(8));
        } catch (IOException | NumberFormatException | SQLException | NullPointerException ex) {
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
    




