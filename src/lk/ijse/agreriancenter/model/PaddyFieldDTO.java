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
public class PaddyFieldDTO {
    private String paddyFieldID;
    private String PaddyFieldName;
    private String PaddyFieldAdress;
    private double paddyFieldSize;
    private String northID;
    private String southID;
    private String westID;
    private String eastID;
    private String gsDivitionID;
    private String taxID;
    private String yayaID;
    private String ownerID;
    private String farmerID;

    public PaddyFieldDTO() {
    }

    public PaddyFieldDTO(String paddyFieldID, String PaddyFieldName, String PaddyFieldAdress, double paddyFieldSize, String northID, String southID, String westID, String eastID, String gsDivitionID, String taxID, String yayaID, String ownerID, String farmerID) {
        this.paddyFieldID = paddyFieldID;
        this.PaddyFieldName = PaddyFieldName;
        this.PaddyFieldAdress = PaddyFieldAdress;
        this.paddyFieldSize = paddyFieldSize;
        this.northID = northID;
        this.southID = southID;
        this.westID = westID;
        this.eastID = eastID;
        this.gsDivitionID = gsDivitionID;
        this.taxID = taxID;
        this.yayaID = yayaID;
        this.ownerID = ownerID;
        this.farmerID = farmerID;
    }

    /**
     * @return the paddyFieldID
     */
    public String getPaddyFieldID() {
        return paddyFieldID;
    }

    /**
     * @param paddyFieldID the paddyFieldID to set
     */
    public void setPaddyFieldID(String paddyFieldID) {
        this.paddyFieldID = paddyFieldID;
    }

    /**
     * @return the PaddyFieldName
     */
    public String getPaddyFieldName() {
        return PaddyFieldName;
    }

    /**
     * @param PaddyFieldName the PaddyFieldName to set
     */
    public void setPaddyFieldName(String PaddyFieldName) {
        this.PaddyFieldName = PaddyFieldName;
    }

    /**
     * @return the PaddyFieldAdress
     */
    public String getPaddyFieldAdress() {
        return PaddyFieldAdress;
    }

    /**
     * @param PaddyFieldAdress the PaddyFieldAdress to set
     */
    public void setPaddyFieldAdress(String PaddyFieldAdress) {
        this.PaddyFieldAdress = PaddyFieldAdress;
    }

    /**
     * @return the paddyFieldSize
     */
    public double getPaddyFieldSize() {
        return paddyFieldSize;
    }

    /**
     * @param paddyFieldSize the paddyFieldSize to set
     */
    public void setPaddyFieldSize(double paddyFieldSize) {
        this.paddyFieldSize = paddyFieldSize;
    }

    /**
     * @return the northID
     */
    public String getNorthID() {
        return northID;
    }

    /**
     * @param northID the northID to set
     */
    public void setNorthID(String northID) {
        this.northID = northID;
    }

    /**
     * @return the southID
     */
    public String getSouthID() {
        return southID;
    }

    /**
     * @param southID the southID to set
     */
    public void setSouthID(String southID) {
        this.southID = southID;
    }

    /**
     * @return the westID
     */
    public String getWestID() {
        return westID;
    }

    /**
     * @param westID the westID to set
     */
    public void setWestID(String westID) {
        this.westID = westID;
    }

    /**
     * @return the eastID
     */
    public String getEastID() {
        return eastID;
    }

    /**
     * @param eastID the eastID to set
     */
    public void setEastID(String eastID) {
        this.eastID = eastID;
    }

    /**
     * @return the gsDivitionID
     */
    public String getGsDivitionID() {
        return gsDivitionID;
    }

    /**
     * @param gsDivitionID the gsDivitionID to set
     */
    public void setGsDivitionID(String gsDivitionID) {
        this.gsDivitionID = gsDivitionID;
    }

    /**
     * @return the taxID
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * @param taxID the taxID to set
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     * @return the yayaID
     */
    public String getYayaID() {
        return yayaID;
    }

    /**
     * @param yayaID the yayaID to set
     */
    public void setYayaID(String yayaID) {
        this.yayaID = yayaID;
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

    @Override
    public String toString() {
        return "PaddyFieldDTO{" + "paddyFieldID=" + paddyFieldID + ", PaddyFieldName=" + PaddyFieldName + ", PaddyFieldAdress=" + PaddyFieldAdress + ", paddyFieldSize=" + paddyFieldSize + ", northID=" + northID + ", southID=" + southID + ", westID=" + westID + ", eastID=" + eastID + ", gsDivitionID=" + gsDivitionID + ", taxID=" + taxID + ", yayaID=" + yayaID + ", ownerID=" + ownerID + ", farmerID=" + farmerID + '}';
    }
    
}
