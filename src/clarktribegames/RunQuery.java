package clarktribegames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

class RunQuery {
    String db1 = "jdbc:ucanaccess://saves//default.limit";
    String db2 = "";
    String db3 = "";
    String search = "";
    String table = "";
    String column = "";
    String matchcol = "";
    String matchstr = "";
    
    String getSingleList(String save, String search,String table,String column) 
            throws SQLException {
        db1 = "jdbc:ucanaccess://saves//" + save + ".limit";
        this.search = search;
        this.table = table;
        this.column = column;
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
    
    String getSpecificRecord(String save, String search,String table, String 
            column, String matchstr) throws SQLException {
        db1 = "jdbc:ucanaccess://saves//" + save + ".limit";
        this.search = search;
        this.table = table;
        this.column = column;
        this.matchstr = matchstr;
        
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
}
