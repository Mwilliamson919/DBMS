/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessObjects;

import dao.MakerHandler;
import java.util.List;
import java.util.Vector;
import utils.Utils;

/**
 *
 * @author mwill
 */
public class Vehicle {
    private int autoID;
    private int makerID;
    private String makerName;
    private int year;
    private int mpg;
    private double msrp;
    private int seatCap;
    
    
    private String model;
    private String trim;
    private String color;
    private String drivetrain;
    private String type;
    
    private double price;

    public Vehicle(int autoID, int makerID, String model, String trim, int year, String color, int mpg, double msrp, int seatCap, String drivetrain, String type, double price) {
        this.autoID = autoID;
        this.makerID = makerID;
        this.year = year;
        this.mpg = mpg;
        this.msrp = msrp;
        this.seatCap = seatCap;
        this.model = model;
        this.trim = trim;
        this.color = color;
        this.drivetrain = drivetrain;
        this.type = type;
        this.price = price;
    }
    public Vector getRow(){
        Vector vector = new Vector();
        vector.add(this.autoID);
        this.makerName = new MakerHandler().getMakerNameFromId(makerID);
        vector.add(this.makerName);
        vector.add(this.model);
        vector.add(this.trim);
        vector.add(this.year);
        vector.add(this.color);
        vector.add(this.mpg);
        vector.add(this.msrp);
        vector.add(this.seatCap);
        vector.add(this.drivetrain);
        vector.add(this.type);
        vector.add(this.price);
        return vector;
    }
    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getAutoID() {
        return autoID;
    }

    public void setAutoID(int autoID) {
        this.autoID = autoID;
    }

    public int getMakerID() {
        return makerID;
    }

    public void setMakerID(int makerID) {
        this.makerID = makerID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    public int getSeatCap() {
        return seatCap;
    }

    public void setSeatCap(int seatCap) {
        this.seatCap = seatCap;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
