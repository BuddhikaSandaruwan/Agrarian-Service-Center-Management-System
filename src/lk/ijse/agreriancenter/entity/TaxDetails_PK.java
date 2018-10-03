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
public class TaxDetails_PK {
    private String paddyFieldID;
    private String taxID;

    public TaxDetails_PK() {
    }

    public TaxDetails_PK(String paddyFieldID, String taxID) {
        this.paddyFieldID = paddyFieldID;
        this.taxID = taxID;
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
    
}
