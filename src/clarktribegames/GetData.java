package clarktribegames;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.util.ImportUtil;
import com.healthmarketscience.jackcess.util.SimpleImportFilter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.swing.text.BadLocationException;
import net.ucanaccess.jdbc.UcanaccessSQLException;
import org.hsqldb.lib.StopWatch;

/**
 *
 * @author admingec
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
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
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
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
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
    
    public static void createnewSave(String save, String gamename) throws SQLException {
        copyTab(save,gamename,"dbToons");
        buildtoonSave(save,gamename);
    }
    
    private static void copyTab(String save, String game, String oldtable) throws SQLException {
        String newgame = "sav" + game.toLowerCase();
        String newtable = oldtable.replaceAll("db", (newgame));
        db1 = "jdbc:ucanaccess://" + MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
        try (Connection con = DriverManager.getConnection(db1, db2, db3)) {
            String savepath = MainControls.savesDir + "/" + save + "." + 
            MainControls.saveExt;
            try (Statement s = con.createStatement()) {
                try (ResultSet rs = s.executeQuery("SELECT * FROM [" + oldtable + "]")) {
                    Database db = new DatabaseBuilder().setAutoSync(false).setFile(new File(savepath)).open();
                    ImportUtil.importResultSet(rs, db, newtable,new SimpleImportFilter(), true);
                    db.flush();
                }
                if(oldtable.equals("dbToons")) {
                    
                    s.execute("ALTER TABLE " + newtable + " ADD COLUMN toonStats TEXT(255)");
                    s.execute("ALTER TABLE " + newtable + " ADD COLUMN toonExp TEXT(255)");
                    s.execute("ALTER TABLE " + newtable + " ADD COLUMN toonSize TEXT(5)");
                    s.execute("ALTER TABLE " + newtable + " ADD COLUMN toonTeam TEXT(5)");
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    private static void buildtoonSave(String save, String gamename) throws SQLException {
        String savetoons = "sav" + gamename.toLowerCase() + "Toons";
        int numbertoons = GetData.dbQuery(save,"*",savetoons,"toonID",null,true).size();
        for(int toonidx = 0; toonidx < numbertoons; toonidx++) {
            
            List<String> toonstats = GetData.dbQuery(save,"*",savetoons,"toonID",String.valueOf(toonidx),false);
            String toonExp = String.valueOf(Double.parseDouble(Calculator.getLevel("ranxp",(toonstats.get(8)))));
            double ratioXP = Double.parseDouble(toonExp) / (Double.parseDouble(Calculator.getLevel("stalv", String.valueOf(Integer.parseInt(toonstats.get(8) + 1)))));
            String toonSize = GetData.dbQuery(save, "*","dbSize","sizeName",(Calculator.getSize(((GetData.dbQuery(save, "*","dbRace","raceID",toonstats.get(2), false)).get(1)), (Calculator.getAge(Integer.parseInt(toonstats.get(7)),toonstats.get(2))))),false).get(0);
            String toonStats = (GetStats.getStats("Toon",toonstats,ratioXP,true).toString()).replaceAll(", ", "x");
            toonStats = toonStats.substring(1, toonStats.length() - 1);
            String savepath = MainControls.savesDir + "/" + save + "." + MainControls.saveExt;
            try (Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + savepath, db2, db3)) {
                try (Statement s = con.createStatement()) {
                    s.execute("UPDATE " + savetoons + " SET toonStats = '" + toonStats + "', toonExp = '" + toonExp + "', toonSize = '" + toonSize + "', toonTeam = '0' WHERE toonID = " + toonidx);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }
            
    
}
