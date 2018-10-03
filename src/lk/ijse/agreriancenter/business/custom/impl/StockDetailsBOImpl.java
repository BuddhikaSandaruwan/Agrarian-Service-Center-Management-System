/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.StockDetailsBO;
import lk.ijse.agreriancenter.dao.custom.StockDetailsDAO;
import lk.ijse.agreriancenter.dao.custom.impl.StockDetailsDAOImpl;
import lk.ijse.agreriancenter.entity.StockDetails;
import lk.ijse.agreriancenter.model.StockDetailsDTO;

/**
 *
 * @author Buddhika
 */
public class StockDetailsBOImpl implements StockDetailsBO{
    
    StockDetailsDAO stockDetailsDAO=new StockDetailsDAOImpl();

    @Override
    public boolean addStockDetails(StockDetailsDTO stockDetailsDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteStockDetails(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStockDetails(StockDetailsDTO stockDetailsDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StockDetailsDTO searchStockDetails(String fieldID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<StockDetailsDTO> getAllStockDetails() throws Exception {
        
        ArrayList<StockDetails> taxs = stockDetailsDAO.getAll();
        ArrayList<StockDetailsDTO> dtos = new ArrayList<>();
        for (StockDetails details : taxs) {
            dtos.add(new StockDetailsDTO(details.getStockDetails_PK().getFertilizerID(),details.getStockDetails_PK().getStockID(),details.getQty()));
        }
        return dtos;        }
    
}
