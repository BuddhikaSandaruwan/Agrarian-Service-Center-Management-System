/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.GSDivitionDAO;
import lk.ijse.agreriancenter.entity.GSDivition;

/**
 *
 * @author Buddhika
 */
public class GSDivitionDAOImpl implements GSDivitionDAO{

    @Override
    public boolean save(GSDivition entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into gsdivition values(?,?,?,?,?,?,?)", entity.getGsDivitionID(),entity.getGsDivitionName(),entity.getGsAdress(),entity.getGsName(),entity.getGsTP(),entity.getGsNIC(),entity.getOfficerID()) > 0;
    }

    @Override
    public boolean update(GSDivition entity) throws Exception {
        return CrudUtil.executeUpdate("Update gsdivition set gsDivitionName=?,GSDivitionAdress=?,gsName=?,gsTP=?,gsNIC=?,officerID=? where gsDivitionID=? ", entity.getGsDivitionName(),entity.getGsAdress(),entity.getGsName(),entity.getGsTP(),entity.getGsNIC(),entity.getOfficerID(),entity.getGsDivitionID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from gsdivition where gsDivitionID=? ", id)>0;
    }

    @Override
    public GSDivition search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from gsdivition where gsDivitionID=? ", id);
        if(resultSet.next()){
            return new GSDivition(resultSet.getString("gsDivitionID"),resultSet.getString("gsDivitionName"),resultSet.getString("gsName"),resultSet.getInt("gsTP"),resultSet.getString("gsAdress"),resultSet.getString("gsNIC"),resultSet.getString("officerID"));
        }
        return null;
    }

    @Override
    public ArrayList<GSDivition> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from gsdivition");
            ArrayList<GSDivition> gSDivitions = new ArrayList();
            while (rst.next()) {
                gSDivitions.add(new GSDivition(rst.getString(1), rst.getString(2),rst.getString(3),rst.getInt(5),rst.getString(4),rst.getString(6),rst.getString(7) ));

            }
            return gSDivitions;
    }
    
}
