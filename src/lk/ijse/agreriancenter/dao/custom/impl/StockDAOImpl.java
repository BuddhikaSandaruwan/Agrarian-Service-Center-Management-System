/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.StockDAO;
import lk.ijse.agreriancenter.entity.Stock;

/**
 *
 * @author Buddhika
 */
public class StockDAOImpl implements StockDAO{

    @Override
    public boolean save(Stock entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into stock values(?,?)", entity.getStockID(),entity.getDate()) > 0;
    }

    @Override
    public boolean update(Stock entity) throws Exception {
        return false;
//        return CrudUtil.executeUpdate("Update paddyfield set PaddyFieldName=?,PaddyFieldAdress=?,paddyFieldSize=?,northID=?,southID=?,westID=?,eastID=?,gsDivitionID=?,taxID=?,yayaID=?,ownerID=?,farmerID=? where paddyFieldID=? ", entity.getPaddyFieldName(),entity.getPaddyFieldAdress(),entity.getPaddyFieldSize(),entity.getNorthID(),entity.getSouthID(),entity.getWestID(),entity.getEastID(),entity.getGsDivitionID(),entity.getTaxID(),entity.getYayaID(),entity.getOwnerID(),entity.getFarmerID(),entity.getPaddyFieldID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from stock where stockID=? ", id)>0;
    }

    @Override
    public Stock search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Stock> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
