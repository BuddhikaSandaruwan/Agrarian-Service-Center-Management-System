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
public class StockDTO {
    private String stockID;
    private String date;

    public StockDTO() {
    }

    public StockDTO(String stockID, String date) {
        this.stockID = stockID;
        this.date = date;
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

    @Override
    public String toString() {
        return "StockDTO{" + "stockID=" + stockID + ", date=" + date + '}';
    }
    
}
