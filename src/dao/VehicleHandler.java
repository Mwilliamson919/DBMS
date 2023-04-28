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
public class VehicleHandler {
    private SQLUtil sqlUtil;
    public VehicleHandler() {
        sqlUtil = new SQLUtil();
    }
    
    public int updateVehicle(int autoID, int makerID, String model, String trim, int year, String color, int mpg, double msrp, int capacity, String drivetrain, String type, double fPrice){
        String cmdTemplate = "update vehicle set makerId = '%d', model = '%s', trim = '%s', year = '%d', color = '%s', mpg = '%d', msrp = '%f', seat_capacity = '%d', drivetrain = '%s', type = '%s', price = '%f' where autoId = '%d';";
        String cmd = String.format(cmdTemplate, makerID, model, trim, year, color, mpg, msrp, capacity, drivetrain, type, fPrice, autoID);
        return sqlUtil.executeUpdate(cmd);
    }
    public int deleteVehicle(int autoID){
        String cmdTemplate = "delete from vehicle where autoID = %d";
        String cmd = String.format(cmdTemplate, autoID);
        return sqlUtil.executeUpdate(cmd);
        
    }
    
    public int addVehicle(int makerID, String model, String trim, int year, String color, int mpg, double msrp,
            int capacity, String drivetrain, String type, double fPrice){
        String cmd = String.format("insert into vehicle (makerID, model, trim, year, color, mpg, msrp, seat_capacity, drivetrain, type, price)"
                + " values('%d', '%s', '%s', '%d', '%s', '%d', '%f', '%d', '%s', '%s', '%f');",
                    makerID, model, trim, year, color, mpg, msrp, capacity, drivetrain, type, fPrice);
        return sqlUtil.executeUpdate(cmd);
    }
    
   
    public List<Vehicle> loadVehicles(String keyword){
        List<Vehicle> vehicles = new ArrayList<>();
        int key = 0;
        String cmd;
        cmd = String.format("select autoID, makerID, model, trim, year, color, mpg, msrp, seat_capacity, drivetrain, type, price from vehicle;"); 
        List<Automaker> makers = new MakerHandler().getMakers();
        key = new MakerHandler().getIndexOfMaker(makers, keyword);
        if (key == -1){
            cmd = "select autoID, makerID, model, trim, year, color, mpg, msrp, seat_capacity, drivetrain, type, price from vehicle;";
        }else {
            key += 1;
            cmd = String.format("select autoID, makerID, model, trim, year, color, mpg, msrp, seat_capacity, drivetrain, type, price from vehicle where makerID = '%d';", key);
        }
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()){
                int autoID = rs.getInt("autoID");
                int makerID = rs.getInt("makerID");
                String model = rs.getString("model");
                String trim = rs.getString("trim");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                int mpg = rs.getInt("mpg");
                double msrp = rs.getDouble("msrp");
                int capacity = rs.getInt("seat_capacity");
                String drivetrain = rs.getString("drivetrain");
                String type = rs.getString("type");
                double fPrice = rs.getDouble("price");
                Vehicle vehicle = new Vehicle(autoID, makerID, model, trim, year, color, mpg, msrp, capacity, drivetrain, type, fPrice);
                vehicles.add(vehicle);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
}
