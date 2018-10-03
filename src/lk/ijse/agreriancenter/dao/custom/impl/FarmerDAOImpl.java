/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.FarmerDAO;
import lk.ijse.agreriancenter.entity.Farmer;

/**
 *
 * @author Buddhika
 */
public class FarmerDAOImpl implements FarmerDAO{

    @Override
    public boolean save(Farmer entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into farmer values(?,?,?,?,?,?)", entity.getFarmerID(),entity.getFarmerName(),entity.getFarmerAdress(),entity.getFarmerNIC(),entity.getFarmerTP(),entity.getFarmerType()) > 0;
    }

    @Override
    public boolean update(Farmer entity) throws Exception {
        return CrudUtil.executeUpdate("Update farmer set farmerName=?,farmerAdress=?,farmerNIC=?,farmerTP=?,farmerType=? where farmerID=? ", entity.getFarmerName(),entity.getFarmerAdress(),entity.getFarmerNIC(),entity.getFarmerTP(),entity.getFarmerType(),entity.getFarmerID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from farmer where farmerID=? ", id)>0;
    }

    @Override
    public Farmer search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from farmer where farmerId=? ", id);
        if(resultSet.next()){
            return new Farmer(resultSet.getString("farmerID"),resultSet.getString("farmerName"),resultSet.getString("farmerAdress"),resultSet.getString("farmerNIC"),resultSet.getInt("farmerTP"),resultSet.getString("farmerType"));
        }
        return null;    }

    @Override
    public ArrayList<Farmer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
