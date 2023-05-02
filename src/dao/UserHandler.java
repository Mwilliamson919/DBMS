/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import businessObjects.User;
import utils.SQLUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mwill
 */
public class UserHandler {
    private SQLUtil sqlUtil;

    /**
     *
     */
    public UserHandler() {
        sqlUtil = new SQLUtil();
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    
    public int addUser(String username, String password, String phoneNum, String email, String address, String role){
        int phone = Integer.parseInt(phoneNum);
        String cmd = String.format("insert into users (userName, user_phone, email_address, address, userRole, userPassword) values('%s', '%d', '%s', '%s', '%s', '%s');", username, phone, email, address, role, password);
        return sqlUtil.executeUpdate(cmd);
    }
    
    public int updateUser(String role, int userId){
        String cmd = "update users set userRole = " + role + " where userId = " + userId + ";";
        return sqlUtil.executeUpdate(cmd);
    }
    
    public List<User> loadUsers(String keyword){
        String cmd;
        List<User> users = new ArrayList();
        if (keyword.equals("")){
            cmd = "select userID, userName, userRole from users;";
        } else {
            cmd = String.format("select userID, userName, userRole from users where userName = '%s';", keyword); 
        }

        ResultSet rs = sqlUtil.executeQuery(cmd);
        
        try {
            while (rs.next()){
                int userId = rs.getInt("userID");
                System.out.println(userId);
                String username = rs.getString("userName");
                System.out.println(username);
                String userRole = rs.getString("userRole");
                System.out.println(userRole);
                User usr = new User(userId, userRole, username);
                users.add(usr);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
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
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usr;
    }
    
}
