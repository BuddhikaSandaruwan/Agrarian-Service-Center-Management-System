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
public class StockDetailsDTO {
    private String fertilizerID;
    private String stockID;
    private double qty;

    public StockDetailsDTO() {
    }

    public StockDetailsDTO(String fertilizerID, String stockID, double qty) {
        this.fertilizerID = fertilizerID;
        this.stockID = stockID;
        this.qty = qty;
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
     * @return the stockID
     */
    public String getStockID() {
        return stockID;
    }

    /**
     * @param stockID the stockID to set
     */
    public void setStockID(String stockID) {
        this.stockID = stockID;
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

    @Override
    public String toString() {
        return "StockDetailsDTO{" + "fertilizerID=" + fertilizerID + ", stockID=" + stockID + ", qty=" + qty + '}';
    }
    
}
