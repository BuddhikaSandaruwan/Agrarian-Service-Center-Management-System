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
public class IssueFertilizerDTO {
    
    private int id;
    private String fieldId;
    private String farmerNic;
    private String fertilizerId;
    private String date;
    private double stockOnHand;
    private double issueQty;

    public IssueFertilizerDTO() {
    }

    public IssueFertilizerDTO(int id, String fieldId, String farmerNic, String fertilizerId, String date, double stockOnHand, double issueQty) {
        this.id = id;
        this.fieldId = fieldId;
        this.farmerNic = farmerNic;
        this.fertilizerId = fertilizerId;
        this.date = date;
        this.stockOnHand = stockOnHand;
        this.issueQty = issueQty;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fieldId
     */
    public String getFieldId() {
        return fieldId;
    }

    /**
     * @param fieldId the fieldId to set
     */
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    /**
     * @return the farmerNic
     */
    public String getFarmerNic() {
        return farmerNic;
    }

    /**
     * @param farmerNic the farmerNic to set
     */
    public void setFarmerNic(String farmerNic) {
        this.farmerNic = farmerNic;
    }

    /**
     * @return the fertilizerId
     */
    public String getFertilizerId() {
        return fertilizerId;
    }

    /**
     * @param fertilizerId the fertilizerId to set
     */
    public void setFertilizerId(String fertilizerId) {
        this.fertilizerId = fertilizerId;
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
     * @return the stockOnHand
     */
    public double getStockOnHand() {
        return stockOnHand;
    }

    /**
     * @param stockOnHand the stockOnHand to set
     */
    public void setStockOnHand(double stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    /**
     * @return the issueQty
     */
    public double getIssueQty() {
        return issueQty;
    }

    /**
     * @param issueQty the issueQty to set
     */
    public void setIssueQty(double issueQty) {
        this.issueQty = issueQty;
    }

    @Override
    public String toString() {
        return "IssueFertilizerDTO{" + "id=" + id + ", fieldId=" + fieldId + ", farmerNic=" + farmerNic + ", fertilizerId=" + fertilizerId + ", date=" + date + ", stockOnHand=" + stockOnHand + ", issueQty=" + issueQty + '}';
    }

       
}
