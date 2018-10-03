/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.model;

/**
 *
 * @author Buddhika
 */
public class FarmerDTO {
 private String farmerID;
 private String farmerName;
 private String farmerAdress;
 private String farmerNIC;
 private int farmerTP;
 private String farmerType;

    public FarmerDTO() {
    }

    public FarmerDTO(String farmerID, String farmerName, String farmerAdress, String farmerNIC, int farmerTP, String farmerType) {
        this.farmerID = farmerID;
        this.farmerName = farmerName;
        this.farmerAdress = farmerAdress;
        this.farmerNIC = farmerNIC;
        this.farmerTP = farmerTP;
        this.farmerType = farmerType;
    }

    /**
     * @return the farmerID
     */
    public String getFarmerID() {
        return farmerID;
    }

    /**
     * @param farmerID the farmerID to set
     */
    public void setFarmerID(String farmerID) {
        this.farmerID = farmerID;
    }

    /**
     * @return the farmerName
     */
    public String getFarmerName() {
        return farmerName;
    }

    /**
     * @param farmerName the farmerName to set
     */
    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    /**
     * @return the farmerAdress
     */
    public String getFarmerAdress() {
        return farmerAdress;
    }

    /**
     * @param farmerAdress the farmerAdress to set
     */
    public void setFarmerAdress(String farmerAdress) {
        this.farmerAdress = farmerAdress;
    }

    /**
     * @return the farmerNIC
     */
    public String getFarmerNIC() {
        return farmerNIC;
    }

    /**
     * @param farmerNIC the farmerNIC to set
     */
    public void setFarmerNIC(String farmerNIC) {
        this.farmerNIC = farmerNIC;
    }

    /**
     * @return the farmerTP
     */
    public int getFarmerTP() {
        return farmerTP;
    }

    /**
     * @param farmerTP the farmerTP to set
     */
    public void setFarmerTP(int farmerTP) {
        this.farmerTP = farmerTP;
    }

    /**
     * @return the farmerType
     */
    public String getFarmerType() {
        return farmerType;
    }

    /**
     * @param farmerType the farmerType to set
     */
    public void setFarmerType(String farmerType) {
        this.farmerType = farmerType;
    }

    @Override
    public String toString() {
        return "FarmerDTO{" + "farmerID=" + farmerID + ", farmerName=" + farmerName + ", farmerAdress=" + farmerAdress + ", farmerNIC=" + farmerNIC + ", farmerTP=" + farmerTP + ", farmerType=" + farmerType + '}';
    }
 
}
