/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.TaxDetailsDAO;
import lk.ijse.agreriancenter.entity.TaxDetails;
import lk.ijse.agreriancenter.entity.TaxDetails_PK;

/**
 *
 * @author Buddhika
 */
public class TaxDetailsDAOImpl implements TaxDetailsDAO{

    @Override
    public boolean save(TaxDetails entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into taxdetails values(?,?,?,?)", entity.getPaddfieldId(),entity.getTaxId(),entity.getDate(),entity.getAmount()) > 0;
    }

    @Override
    public boolean update(TaxDetails entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public boolean search(String id) throws Exception {
//        return CrudUtil.executeUpdate("select * from taxDetails where taxID=? ",id) > 0;
//    }

    @Override
    public ArrayList<TaxDetails> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from taxdetails ");
        ArrayList<TaxDetails> officers = new ArrayList();
        while (rst.next()) {
            officers.add(new TaxDetails(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4) ));

        }
        return officers;    }

    @Override
    public TaxDetails search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from taxdetails where paddyFieldID=? ", id);
        if(resultSet.next()){
            return new TaxDetails(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4));
        }
        return null;
    }
    
}
