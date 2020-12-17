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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    static String db2 = "";
    static String db3 = "";
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
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, MainControls.saveExt);
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
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, MainControls.saveExt);
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
    
    public static void createnewSave(String save,String game)throws SQLException
        , IOException, InterruptedException {
        copyTab(save,"dbToons", "sav" + game.toLowerCase() + "Toons");
        buildtoonSave(save,game);
        copyTab(save,"sav"+game.toLowerCase()+"Toons","sav"+game.toLowerCase()+ 
            "Max");
    }
    
    private static void copyTab(String save,String oldtable,String newtable) 
        throws SQLException {
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
        db1 = db1.replaceAll(MainControls.saveExt + "." + MainControls.saveExt, MainControls.saveExt);
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
            String toonStats = (GetStats.getStats("Toon",toonstats,ratioXP,true)
                .toString()).replaceAll(", ", "x");
            toonStats = toonStats.substring(1, toonStats.length() - 1);
            String savepath = (MainControls.savesDir + Converters.capFirstLetter
                ((MainControls.selectedSave))).replaceAll(MainControls.saveExt + "." + MainControls.saveExt, MainControls.saveExt);;
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
    
    
}
