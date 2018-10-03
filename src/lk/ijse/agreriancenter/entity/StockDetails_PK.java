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
public class StockDetails_PK {
    private String fertilizerID;
    private String stockID;

    public StockDetails_PK() {
    }

    public StockDetails_PK(String fertilizerID, String stockID) {
        this.fertilizerID = fertilizerID;
        this.stockID = stockID;
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
    
}
