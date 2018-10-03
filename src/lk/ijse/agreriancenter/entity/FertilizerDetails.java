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
public class FertilizerDetails {
        private FertilizerDetails_PK fertilizerDetails_PK;
        private double qty;
        private String nic;
        private String date;

    public FertilizerDetails() {
    }

    public FertilizerDetails(FertilizerDetails_PK fertilizerDetails_PK, double qty, String nic, String date) {
        this.fertilizerDetails_PK = fertilizerDetails_PK;
        this.qty = qty;
        this.nic = nic;
        this.date = date;
    }

    /**
     * @return the fertilizerDetails_PK
     */
    public FertilizerDetails_PK getFertilizerDetails_PK() {
        return fertilizerDetails_PK;
    }

    /**
     * @param fertilizerDetails_PK the fertilizerDetails_PK to set
     */
    public void setFertilizerDetails_PK(FertilizerDetails_PK fertilizerDetails_PK) {
        this.fertilizerDetails_PK = fertilizerDetails_PK;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
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
