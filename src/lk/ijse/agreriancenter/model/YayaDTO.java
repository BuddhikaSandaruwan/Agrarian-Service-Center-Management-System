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
public class YayaDTO {
    private String yayaID;
    private String yayaName;

    public YayaDTO() {
    }

    public YayaDTO(String yayaID, String yayaName) {
        this.yayaID = yayaID;
        this.yayaName = yayaName;
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
     * @return the yayaName
     */
    public String getYayaName() {
        return yayaName;
    }

    /**
     * @param yayaName the yayaName to set
     */
    public void setYayaName(String yayaName) {
        this.yayaName = yayaName;
    }

    @Override
    public String toString() {
        return "YayaDTO{" + "yayaID=" + yayaID + ", yayaName=" + yayaName + '}';
    }
    
}
