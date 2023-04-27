/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import businessObjects.User;
import utils.SQLUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mwill
 */
public class SellerHandler {
    private SQLUtil sqlUtil;

    /**
     *
     */
    public SellerHandler() {
        sqlUtil = new SQLUtil();
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        User usr = null;
        try {
            String cmd = String.format("select userID, userRole from users where userName = '%s' and userPassword = '%s'", username, password);
            ResultSet rs = sqlUtil.executeQuery(cmd);
            if (rs.next()){
                int usrId = rs.getInt("userID");
                String usrRole = rs.getString("userRole");
                System.out.println("userID:" + usrId + " Role: " + usrRole);
                usr = new User(usrId, usrRole);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usr;
    }
    
}
