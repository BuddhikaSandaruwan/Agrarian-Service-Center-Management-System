/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.OwnerDAO;
import lk.ijse.agreriancenter.entity.Owner;

/**
 *
 * @author Buddhika
 */
public class OwnerDAOImpl implements OwnerDAO{

    @Override
    public boolean save(Owner entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into owner values(?,?,?,?,?,?)", entity.getOwnerID(),entity.getOwnerName(),entity.getOwnerAdress(),entity.getOwnerNIC(),entity.getOwnerTP(),entity.getLandNumber()) > 0;
    }

    @Override
    public boolean update(Owner entity) throws Exception {
        return CrudUtil.executeUpdate("Update owner set ownerName=?,ownerAdress=?,ownerNIC=?,ownerTP=?,landNumber=? where ownerID=? ", entity.getOwnerName(),entity.getOwnerAdress(),entity.getOwnerNIC(),entity.getOwnerTP(),entity.getLandNumber(),entity.getOwnerID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("Delete from owner where ownerID=? ",id)>0;
    }

    @Override
    public Owner search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from owner where OwnerId=? ", id);
        if(resultSet.next()){
            return new Owner(resultSet.getString("ownerID"),resultSet.getString("ownerName"),resultSet.getString("ownerAdress"),resultSet.getString("ownerNIC"),resultSet.getInt("ownerTP"),resultSet.getString("landNumber"));
        }
        return null;
    }

    @Override
    public ArrayList<Owner> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
