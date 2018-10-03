/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.IssueFertilizerDAO;
import lk.ijse.agreriancenter.entity.IssueFertilizer;

/**
 *
 * @author Buddhika
 */
public class IssueFertilizerDAOImpl implements IssueFertilizerDAO{

    @Override
    public boolean save(IssueFertilizer entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into issuefertilizerdetails values(?,?,?,?,?)", 0,entity.getFieldId(),entity.getFarmerNic(),entity.getFertilizerId(),entity.getDate()) > 0;
    }

    @Override
    public boolean update(IssueFertilizer entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IssueFertilizer search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IssueFertilizer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
