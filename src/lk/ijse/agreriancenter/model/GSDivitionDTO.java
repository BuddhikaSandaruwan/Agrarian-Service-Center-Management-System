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
public class GSDivitionDTO {
    private String gsDivitionID;
    private String gsDivitionName;
    private String gsName;
    private int gsTP;
    private String gsAdress;
    private String gsNIC;
    private String officerID;

    public GSDivitionDTO() {
    }

    public GSDivitionDTO(String gsDivitionID, String gsDivitionName, String gsName, int gsTP, String gsAdress, String gsNIC, String officerID) {
        this.gsDivitionID = gsDivitionID;
        this.gsDivitionName = gsDivitionName;
        this.gsName = gsName;
        this.gsTP = gsTP;
        this.gsAdress = gsAdress;
        this.gsNIC = gsNIC;
        this.officerID = officerID;
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
     * @return the gsDivitionName
     */
    public String getGsDivitionName() {
        return gsDivitionName;
    }

    /**
     * @param gsDivitionName the gsDivitionName to set
     */
    public void setGsDivitionName(String gsDivitionName) {
        this.gsDivitionName = gsDivitionName;
    }

    /**
     * @return the gsName
     */
    public String getGsName() {
        return gsName;
    }

    /**
     * @param gsName the gsName to set
     */
    public void setGsName(String gsName) {
        this.gsName = gsName;
    }

    /**
     * @return the gsTP
     */
    public int getGsTP() {
        return gsTP;
    }

    /**
     * @param gsTP the gsTP to set
     */
    public void setGsTP(int gsTP) {
        this.gsTP = gsTP;
    }

    /**
     * @return the gsAdress
     */
    public String getGsAdress() {
        return gsAdress;
    }

    /**
     * @param gsAdress the gsAdress to set
     */
    public void setGsAdress(String gsAdress) {
        this.gsAdress = gsAdress;
    }

    /**
     * @return the gsNIC
     */
    public String getGsNIC() {
        return gsNIC;
    }

    /**
     * @param gsNIC the gsNIC to set
     */
    public void setGsNIC(String gsNIC) {
        this.gsNIC = gsNIC;
    }

    /**
     * @return the officerID
     */
    public String getOfficerID() {
        return officerID;
    }

    /**
     * @param officerID the officerID to set
     */
    public void setOfficerID(String officerID) {
        this.officerID = officerID;
    }

    @Override
    public String toString() {
        return "GSDivitionDTO{" + "gsDivitionID=" + gsDivitionID + ", gsDivitionName=" + gsDivitionName + ", gsName=" + gsName + ", gsTP=" + gsTP + ", gsAdress=" + gsAdress + ", gsNIC=" + gsNIC + ", officerID=" + officerID + '}';
    }
   
}
