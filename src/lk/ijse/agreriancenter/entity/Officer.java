/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.entity;

/**
 *
 * @author Buddhika
 */
public class Officer {
    private String officerID;
    private String officerName;
    private String officerAdress;
    private String officerNic;
    private int officerTP;

    public Officer() {
    }

    public Officer(String officerID, String officerName, String officerAdress, String officerNic, int officerTP) {
        this.officerID = officerID;
        this.officerName = officerName;
        this.officerAdress = officerAdress;
        this.officerNic = officerNic;
        this.officerTP = officerTP;
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

    /**
     * @return the officerName
     */
    public String getOfficerName() {
        return officerName;
    }

    /**
     * @param officerName the officerName to set
     */
    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    /**
     * @return the officerAdress
     */
    public String getOfficerAdress() {
        return officerAdress;
    }

    /**
     * @param officerAdress the officerAdress to set
     */
    public void setOfficerAdress(String officerAdress) {
        this.officerAdress = officerAdress;
    }

    /**
     * @return the officerNic
     */
    public String getOfficerNic() {
        return officerNic;
    }

    /**
     * @param officerNic the officerNic to set
     */
    public void setOfficerNic(String officerNic) {
        this.officerNic = officerNic;
    }

    /**
     * @return the officerTP
     */
    public int getOfficerTP() {
        return officerTP;
    }

    /**
     * @param officerTP the officerTP to set
     */
    public void setOfficerTP(int officerTP) {
        this.officerTP = officerTP;
    }
    
}
