/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import businessObjects.Automaker;
import businessObjects.Vehicle;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mwill
 */
public class MakerHandler {
    private SQLUtil sqlUtil;

    public MakerHandler() {
        sqlUtil = new SQLUtil();
    }
    
    
    public List<Automaker> getMakers(){
        List<Automaker> results = new ArrayList<>();
        String cmd = "select makerID, makerName from automaker;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()){
                int makerId = rs.getInt("makerID");
                String makerName = rs.getString("makerName");
                Automaker maker = new Automaker(makerId, makerName);
                results.add(maker);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
