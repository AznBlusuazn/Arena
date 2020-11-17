package com.clarktribe.arena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admingec
 */
class RunQuery {
    String db1 = "jdbc:ucanaccess://data.accdb";
    String db2 = "";
    String db3 = "";
    String search = "";
    String table = "";
    String column = "";
    String matchcol = "";
    String matchstr = "";
    
    String getSingleList(String search,String table,String column) throws 
            SQLException {
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
    
    String getSpecificRecord(String search,String table, String column, String 
            matchcol, String matchstr) throws SQLException {
        this.search = search;
        this.table = table;
        this.column = column;
        this.matchcol = matchcol;
        this.matchstr = matchstr;
        
        String match = (matchcol + "=\"" + matchstr + "\"");
        String result = "";
        
        Connection con = DriverManager.getConnection(db1, db2, db3);
        Statement st = con.createStatement();
        String query = ("select " + search + " from " + table + " where " + 
                match);
        System.out.println("Attempted Query: " + query);
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colC = (rsmd.getColumnCount() - 1);
        System.out.println("Count: " + colC);
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
