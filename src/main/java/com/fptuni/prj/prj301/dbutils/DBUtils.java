/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasBV
 */
public class DBUtils {

    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection(url, userID, password);
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/take-attendance", userID, password);
    }
    private final static String serverName = "localhost";
    private final static String dbName = "prj301-take-attendence";
    private final static String portNumber = "1433";
    private final static String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//    private final static String userID = "sa";
    private final static String userID = "QUOCBINH";
    private final static String password = "binh091202";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Student id: " + rs.getInt(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
