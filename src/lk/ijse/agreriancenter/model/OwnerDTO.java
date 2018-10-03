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
public class OwnerDTO {
    private String ownerID;
    private String ownerName;
    private String ownerAdress;
    private String ownerNIC;
    private int ownerTP;
    private String landNumber;

    public OwnerDTO() {
    }

    public OwnerDTO(String ownerID, String ownerName, String ownerAdress, String ownerNIC, int ownerTP, String landNumber) {
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.ownerAdress = ownerAdress;
        this.ownerNIC = ownerNIC;
        this.ownerTP = ownerTP;
        this.landNumber = landNumber;
    }

    /**
     * @return the ownerID
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * @param ownerID the ownerID to set
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the ownerAdress
     */
    public String getOwnerAdress() {
        return ownerAdress;
    }

    /**
     * @param ownerAdress the ownerAdress to set
     */
    public void setOwnerAdress(String ownerAdress) {
        this.ownerAdress = ownerAdress;
    }

    /**
     * @return the ownerNIC
     */
    public String getOwnerNIC() {
        return ownerNIC;
    }

    /**
     * @param ownerNIC the ownerNIC to set
     */
    public void setOwnerNIC(String ownerNIC) {
        this.ownerNIC = ownerNIC;
    }

    /**
     * @return the ownerTP
     */
    public int getOwnerTP() {
        return ownerTP;
    }

    /**
     * @param ownerTP the ownerTP to set
     */
    public void setOwnerTP(int ownerTP) {
        this.ownerTP = ownerTP;
    }

    /**
     * @return the landNumber
     */
    public String getLandNumber() {
        return landNumber;
    }

    /**
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" + "ownerID=" + ownerID + ", ownerName=" + ownerName + ", ownerAdress=" + ownerAdress + ", ownerNIC=" + ownerNIC + ", ownerTP=" + ownerTP + ", landNumber=" + landNumber + '}';
    }
    
}
