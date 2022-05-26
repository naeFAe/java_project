package com.company.jdbc;

import java.sql.*;

public class DBconn {
    private static DBconn db_conn = null;
    private Connection conn = null;

    private DBconn(){
    }
    public static DBconn getInstance(){
        if(db_conn == null)
            db_conn = new DBconn();
        return db_conn;
    }

    public void startConn() throws SQLException, ClassNotFoundException{
        if(conn == null){
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-test","root","1234");
        }
    }

    public Connection getConn(){
        return conn;
    }

    public void closeConn(){
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
