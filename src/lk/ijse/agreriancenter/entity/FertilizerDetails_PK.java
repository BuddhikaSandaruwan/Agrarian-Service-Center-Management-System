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
public class FertilizerDetails_PK {
    private String paddyFieldID;
    private String fertilizerID;

    public FertilizerDetails_PK() {
    }

    public FertilizerDetails_PK(String paddyFieldID, String fertilizerID) {
        this.paddyFieldID = paddyFieldID;
        this.fertilizerID = fertilizerID;
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
     * @return the fertilizerID
     */
    public String getFertilizerID() {
        return fertilizerID;
    }

    /**
     * @param fertilizerID the fertilizerID to set
     */
    public void setFertilizerID(String fertilizerID) {
        this.fertilizerID = fertilizerID;
    }
    
}
