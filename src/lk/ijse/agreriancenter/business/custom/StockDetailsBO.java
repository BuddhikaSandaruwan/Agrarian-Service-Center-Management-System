/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.StockDetailsDTO;

/**
 *
 * @author Buddhika
 */
public interface StockDetailsBO extends SuperBO{
    public boolean addStockDetails(StockDetailsDTO stockDetailsDTO)throws Exception;
    
    public boolean deleteStockDetails(String id)throws Exception;
    
    public boolean updateStockDetails(StockDetailsDTO stockDetailsDTO)throws Exception;
    
    public StockDetailsDTO searchStockDetails(String fieldID)throws Exception;
    
    public ArrayList<StockDetailsDTO> getAllStockDetails()throws Exception;
    
   
}
