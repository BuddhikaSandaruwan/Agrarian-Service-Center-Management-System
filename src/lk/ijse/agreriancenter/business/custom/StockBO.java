/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.StockDTO;
import lk.ijse.agreriancenter.model.StockDetailsDTO;
import lk.ijse.agreriancenter.model.UpdateStockDTO;

/**
 *
 * @author Buddhika
 */
public interface StockBO extends SuperBO{
    public boolean addStock(UpdateStockDTO updateStockDTO)throws Exception;
    
    public boolean deleteStock(String ownerId)throws Exception;
    
    public boolean updateStock(UpdateStockDTO updateStockDTO)throws Exception;
    
    public StockDTO searchStock()throws Exception;
    
    public ArrayList<StockDTO> getAllStock()throws Exception;
    
    public ArrayList<String> getAllStockIds()throws Exception;
}
