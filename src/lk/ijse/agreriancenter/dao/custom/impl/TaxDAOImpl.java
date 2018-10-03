/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.TaxDAO;
import lk.ijse.agreriancenter.entity.Tax;

/**
 *
 * @author Buddhika
 */
public class TaxDAOImpl implements TaxDAO{

    @Override
    public boolean save(Tax entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into tax values(?,?,?)", entity.getTaxID(),entity.getTaxName(),entity.getTaxRate()) > 0;
    }

    @Override
    public boolean update(Tax entity) throws Exception {
        return CrudUtil.executeUpdate("Update tax set taxName=?,taxRate=? where taxID=? ", entity.getTaxName(),entity.getTaxRate(),entity.getTaxID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from tax where taxID=? ", id)>0;
    }

    @Override
    public Tax search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from tax where taxID=? ", id);
        if(resultSet.next()){
            return new Tax(resultSet.getString("taxID"),resultSet.getString("taxName"),resultSet.getDouble("taxRate"));
        }
        return null;
    }

    @Override
    public ArrayList<Tax> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from tax");
        ArrayList<Tax> taxs = new ArrayList();
        while (rst.next()) {
            taxs.add(new Tax(rst.getString(1), rst.getString(2),rst.getDouble(3) ));
            System.out.println("daoimpl");

        }
        return taxs;    
    }
    
}
