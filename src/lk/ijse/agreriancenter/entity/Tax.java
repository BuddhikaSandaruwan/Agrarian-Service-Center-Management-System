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
public class Tax {
    private String taxID;
    private String taxName;
    private double taxRate;

    public Tax() {
    }

    public Tax(String taxID, String taxName, double taxRate) {
        this.taxID = taxID;
        this.taxName = taxName;
        this.taxRate = taxRate;
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
     * @return the taxName
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * @param taxName the taxName to set
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    
}
