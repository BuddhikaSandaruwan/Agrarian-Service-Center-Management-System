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
public class FertilizerDetailsDTO {
    private String paddyFieldID;
    private String fertilizerID;
    private double qtyIssued;

    public FertilizerDetailsDTO() {
    }

    public FertilizerDetailsDTO(String paddyFieldID, String fertilizerID, double qtyIssued) {
        this.paddyFieldID = paddyFieldID;
        this.fertilizerID = fertilizerID;
        this.qtyIssued = qtyIssued;
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

    /**
     * @return the qtyIssued
     */
    public double getQtyIssued() {
        return qtyIssued;
    }

    /**
     * @param qtyIssued the qtyIssued to set
     */
    public void setQtyIssued(double qtyIssued) {
        this.qtyIssued = qtyIssued;
    }

    @Override
    public String toString() {
        return "FertilizerDetailsDTO{" + "paddyFieldID=" + paddyFieldID + ", fertilizerID=" + fertilizerID + ", qtyIssued=" + qtyIssued + '}';
    }
    
}
