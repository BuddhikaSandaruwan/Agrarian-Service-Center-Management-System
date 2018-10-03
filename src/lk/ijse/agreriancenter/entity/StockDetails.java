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
public class StockDetails {
  private StockDetails_PK stockDetails_PK;
  private double qty;

    public StockDetails() {
    }

    public StockDetails(StockDetails_PK stockDetails_PK, double qty) {
        this.stockDetails_PK = stockDetails_PK;
        this.qty = qty;
    }
      public StockDetails(String fertilizerID,String stockID , double qty) {
        this.stockDetails_PK = new StockDetails_PK(fertilizerID, stockID);
        this.qty = qty;
    }

    /**
     * @return the stockDetails_PK
     */
    public StockDetails_PK getStockDetails_PK() {
        return stockDetails_PK;
    }

    /**
     * @param stockDetails_PK the stockDetails_PK to set
     */
    public void setStockDetails_PK(StockDetails_PK stockDetails_PK) {
        this.stockDetails_PK = stockDetails_PK;
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
  
}
