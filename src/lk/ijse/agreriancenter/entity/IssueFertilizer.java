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
public class IssueFertilizer {
    private int id;
    private String fieldId;
    private String farmerNic;
    private String fertilizerId;
    private String date;

    public IssueFertilizer() {
    }

    public IssueFertilizer(int id, String fieldId, String farmerNic, String fertilizerId, String date) {
        this.id = id;
        this.fieldId = fieldId;
        this.farmerNic = farmerNic;
        this.fertilizerId = fertilizerId;
        this.date = date;
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
    
}
