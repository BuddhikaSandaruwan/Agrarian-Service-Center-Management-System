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
public class UpdateStockDTO {
    private StockDTO stockDTO;
    private StockDetailsDTO stockDetailsDTO;

    public UpdateStockDTO() {
    }

    public UpdateStockDTO(StockDTO stockDTO, StockDetailsDTO stockDetailsDTO) {
        this.stockDTO = stockDTO;
        this.stockDetailsDTO = stockDetailsDTO;
    }

    /**
     * @return the stockDTO
     */
    public StockDTO getStockDTO() {
        return stockDTO;
    }

    /**
     * @param stockDTO the stockDTO to set
     */
    public void setStockDTO(StockDTO stockDTO) {
        this.stockDTO = stockDTO;
    }

    /**
     * @return the stockDetailsDTO
     */
    public StockDetailsDTO getStockDetailsDTO() {
        return stockDetailsDTO;
    }

    /**
     * @param stockDetailsDTO the stockDetailsDTO to set
     */
    public void setStockDetailsDTO(StockDetailsDTO stockDetailsDTO) {
        this.stockDetailsDTO = stockDetailsDTO;
    }

    @Override
    public String toString() {
        return "UpdateStockDTO{" + "stockDTO=" + stockDTO + ", stockDetailsDTO=" + stockDetailsDTO + '}';
    }
    
}
