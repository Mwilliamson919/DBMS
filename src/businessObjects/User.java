/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author mwill
 */
public class User {
    private int userID;
    private String userRole;
    private String userName;
    
    public User(int userID, String userRole, String userName) {
        this.userID = userID;
        this.userRole = userRole;
        this.userName = userName;
    }
    
     public Vector getRow(){
        Vector vector = new Vector();
        vector.add(this.userID);
        vector.add(this.userName);
        vector.add(this.userRole);
        return vector;
    }
    
    public User(int userID, String userRole) {
        this.userID = userID;
        this.userRole = userRole;
    }

    public User(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
}
