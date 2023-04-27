/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessObjects;

/**
 *
 * @author mwill
 */
public class semiTruck extends Vehicle{
    private String semi;
    private float loadCap;
    private float towWeight;

    public semiTruck(int sellerID, int autoID, int makerID, int year, int mpg, int msrp, int seatCap, String model, String trim, String color, String driveTrain, String type, float price, String semi, float loadCap, float towWeight) {
        super(sellerID, autoID, makerID, year, mpg, msrp, seatCap, model, trim, color, driveTrain, type, price);
        this.semi = semi;
        this.loadCap = loadCap;
        this.towWeight = towWeight;
    }

    public String getSemi() {
        return semi;
    }

    public void setSemi(String semi) {
        this.semi = semi;
    }

    public float getLoadCap() {
        return loadCap;
    }

    public void setLoadCap(float loadCap) {
        this.loadCap = loadCap;
    }

    public float getTowWeight() {
        return towWeight;
    }

    public void setTowWeight(float towWeight) {
        this.towWeight = towWeight;
    }
    
}
