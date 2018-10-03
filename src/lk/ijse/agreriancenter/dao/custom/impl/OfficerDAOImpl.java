/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;


import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.OfficerDAO;
import lk.ijse.agreriancenter.entity.Fertilizer;
import lk.ijse.agreriancenter.entity.Officer;

/**
 *
 * @author Buddhika
 */
public class OfficerDAOImpl implements OfficerDAO{

    @Override
    public boolean save(Officer entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into officer values(?,?,?,?,?)", entity.getOfficerID(),entity.getOfficerName(),entity.getOfficerAdress(),entity.getOfficerNic(),entity.getOfficerTP()) > 0;
    }

    @Override
    public boolean update(Officer entity) throws Exception {
        return CrudUtil.executeUpdate("Update officer set officerName=?,officerAdress=?,officerNic=?,officerTP=? where officerID=? ", entity.getOfficerName(),entity.getOfficerAdress(),entity.getOfficerNic(),entity.getOfficerTP(),entity.getOfficerID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from officer where officerID=? ", id)>0;
    }

    @Override
    public Officer search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from officer where officerID=? ", id);
        if(resultSet.next()){
            return new Officer(resultSet.getString("officerID"),resultSet.getString("officerName"),resultSet.getString("officerAdress"),resultSet.getString("officerNic"),resultSet.getInt("officerTP"));
        }
        return null;
    }

    @Override
    public ArrayList<Officer> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from officer ");
        ArrayList<Officer> officers = new ArrayList();
        while (rst.next()) {
            officers.add(new Officer(rst.getString(1), rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5) ));

        }
        return officers;
    }
    
}


