/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mwill
 */
public class SQLUtil {
    private Connection con;
    private Statement stm;
    
    public SQLUtil() {
        String url = "jdbc:mysql://localhost:3306/car_db";
        String username = "root";
        String password = "root";
        try {
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();//PreparedStatement
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
        return con;
    }
    public Statement getStatement() {
        return stm;
    }
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            
        }
    }
    @Override
    protected void finalize() throws Throwable {
        closeConnection();
        super.finalize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    public int executeUpdate(String cmd){
        try {
            return this.stm.executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public ResultSet executeQuery(String cmd){
        try {
            return this.stm.executeQuery(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
