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
public class TaxDetails {
   private String paddfieldId;
   private String taxId;
   private String date;
   private double amount;

    public TaxDetails() {
    }

    public TaxDetails(String paddfieldId, String taxId, String date, double amount) {
        this.paddfieldId = paddfieldId;
        this.taxId = taxId;
        this.date = date;
        this.amount = amount;
    }

    /**
     * @return the paddfieldId
     */
    public String getPaddfieldId() {
        return paddfieldId;
    }

    /**
     * @param paddfieldId the paddfieldId to set
     */
    public void setPaddfieldId(String paddfieldId) {
        this.paddfieldId = paddfieldId;
    }

    /**
     * @return the taxId
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * @param taxId the taxId to set
     */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
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

}