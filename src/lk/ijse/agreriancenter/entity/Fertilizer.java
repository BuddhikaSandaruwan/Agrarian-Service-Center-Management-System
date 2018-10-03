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
public class Fertilizer {
  private String fertilizerID;
  private String fertilizerName;
  private double qtyOnHand;
  private double fertilizerRate;

    public Fertilizer() {
    }

    public Fertilizer(String fertilizerID, String fertilizerName, double qtyOnHand, double fertilizerRate) {
        this.fertilizerID = fertilizerID;
        this.fertilizerName = fertilizerName;
        this.qtyOnHand = qtyOnHand;
        this.fertilizerRate = fertilizerRate;
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
     * @return the fertilizerName
     */
    public String getFertilizerName() {
        return fertilizerName;
    }

    /**
     * @param fertilizerName the fertilizerName to set
     */
    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }

    /**
     * @return the qtyOnHand
     */
    public double getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    /**
     * @return the fertilizerRate
     */
    public double getFertilizerRate() {
        return fertilizerRate;
    }

    /**
     * @param fertilizerRate the fertilizerRate to set
     */
    public void setFertilizerRate(double fertilizerRate) {
        this.fertilizerRate = fertilizerRate;
    }
    
}
