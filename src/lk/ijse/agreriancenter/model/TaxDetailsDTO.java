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
public class TaxDetailsDTO {
    private String paddyFieldID;
    private String taxID;
    private String date;
    private double amount;

    public TaxDetailsDTO() {
    }

    public TaxDetailsDTO(String paddyFieldID, String taxID, String date, double amount) {
        this.paddyFieldID = paddyFieldID;
        this.taxID = taxID;
        this.date = date;
        this.amount = amount;
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

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TaxDetailsDTO{" + "paddyFieldID=" + paddyFieldID + ", taxID=" + taxID + ", date=" + date + ", amount=" + amount + '}';
    }
    
}
