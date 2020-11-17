package com.clarktribe.arena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    String field = "";
    
    String getSingleList(String search,String table,String field) throws 
            SQLException {
        this.search = search;
        this.table = table;
        this.field = field;
        String result = "";
        Connection con = DriverManager.getConnection(db1, db2, db3);
        Statement st = con.createStatement();
        String query = ("select " + search + " from " + table);
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            result = result + "," + rs.getString(field);
        }
        st.close();
        con.close();
        result = result.substring(1,result.length());
        return result;
    }
}
