/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.StockDetailsDAO;
import lk.ijse.agreriancenter.entity.StockDetails;
import lk.ijse.agreriancenter.entity.StockDetails_PK;

/**
 *
 * @author Buddhika
 */
public class StockDetailsDAOImpl implements StockDetailsDAO{

    @Override
    public boolean save(StockDetails entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into stockdetails values(?,?,?)", entity.getStockDetails_PK().getFertilizerID(),entity.getStockDetails_PK().getStockID(),entity.getQty()) > 0;
    }

    @Override
    public boolean update(StockDetails entity) throws Exception {
        return false;
//        return CrudUtil.executeUpdate("Update stockdetails set PaddyFieldName=?,PaddyFieldAdress=?,paddyFieldSize=?,northID=?,southID=?,westID=?,eastID=?,gsDivitionID=?,taxID=?,yayaID=?,ownerID=?,farmerID=? where paddyFieldID=? ", entity.getPaddyFieldName(),entity.getPaddyFieldAdress(),entity.getPaddyFieldSize(),entity.getNorthID(),entity.getSouthID(),entity.getWestID(),entity.getEastID(),entity.getGsDivitionID(),entity.getTaxID(),entity.getYayaID(),entity.getOwnerID(),entity.getFarmerID(),entity.getPaddyFieldID())>0;
    }

    @Override
    public boolean delete(StockDetails_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StockDetails search(StockDetails_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<StockDetails> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from stockdetails ");
        ArrayList<StockDetails> stockDetailses = new ArrayList();
        while (rst.next()) {
            stockDetailses.add(new StockDetails(rst.getString(1), rst.getString(2),rst.getDouble(3) ));

        }
        return stockDetailses;    }
    
}
