/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.StockBO;
import lk.ijse.agreriancenter.dao.custom.FertilizerDAO;
import lk.ijse.agreriancenter.dao.custom.StockDAO;
import lk.ijse.agreriancenter.dao.custom.StockDetailsDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.StockDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.StockDetailsDAOImpl;
import lk.ijse.agreriancenter.db.DBConnection;
import lk.ijse.agreriancenter.entity.Fertilizer;
import lk.ijse.agreriancenter.entity.Stock;
import lk.ijse.agreriancenter.entity.StockDetails;
import lk.ijse.agreriancenter.model.StockDTO;
import lk.ijse.agreriancenter.model.StockDetailsDTO;
import lk.ijse.agreriancenter.model.UpdateStockDTO;

/**
 *
 * @author Buddhika
 */
public class StockBOImpl implements StockBO{
    
    StockDAO stockDAO=new StockDAOImpl();
    StockDetailsDAO stockDetailsDAO=new StockDetailsDAOImpl();
    FertilizerDAO fertilizerDAO=new FertilizerDAOImpl();

   
    @Override
    public boolean addStock(UpdateStockDTO updateStockDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            StockDTO stockDTO = updateStockDTO.getStockDTO();
            StockDetailsDTO stockDetailsDTO=updateStockDTO.getStockDetailsDTO();

            boolean add = stockDAO.save(new Stock(stockDTO.getStockID(),stockDTO.getDate()));
            if (!add) {
                System.out.println("owner false");
                return false;
            }
            add = stockDetailsDAO.save(new StockDetails(stockDetailsDTO.getFertilizerID(),stockDetailsDTO.getStockID(),stockDetailsDTO.getQty()));
            if (!add) {
                System.out.println("farmer false");
                connection.rollback();
                return false;
            }
            Fertilizer f=fertilizerDAO.search(updateStockDTO.getStockDetailsDTO().getFertilizerID());
            double qtyOnHand=f.getQtyOnHand();
            qtyOnHand=qtyOnHand+updateStockDTO.getStockDetailsDTO().getQty();
            f.setQtyOnHand(qtyOnHand);
            add=fertilizerDAO.update(f);
            if(!add){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteStock(String ownerId) throws Exception {
        boolean delete=stockDAO.delete(ownerId);
        return delete;
    }

    @Override
    public StockDTO searchStock() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<StockDTO> getAllStock() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllStockIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStock(UpdateStockDTO updateStockDTO) throws Exception {
 Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            StockDTO stockDTO=updateStockDTO.getStockDTO();
            StockDetailsDTO stockDetailsDTO=updateStockDTO.getStockDetailsDTO();

            boolean add = stockDAO.update(new Stock(stockDTO.getStockID(),stockDTO.getDate()));
            if (!add) {
        
                return false;
            }
            add = stockDetailsDAO.update(new StockDetails(stockDetailsDTO.getFertilizerID(),stockDetailsDTO.getStockID(),stockDetailsDTO.getQty()));
            if (!add) {
               
                connection.rollback();
                return false;
            }
         
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }    }

   
    
    
}
