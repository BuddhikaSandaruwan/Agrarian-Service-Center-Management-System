/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.PaddyFieldDAO;
import lk.ijse.agreriancenter.entity.GSDivition;
import lk.ijse.agreriancenter.entity.PaddyField;

/**
 *
 * @author Buddhika
 */
public class PaddyFieldDAOImpl implements PaddyFieldDAO{

    @Override
    public boolean save(PaddyField entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into paddyfield values(?,?,?,?,?,?,?,?,?,?,?,?,?)", entity.getPaddyFieldID(),entity.getPaddyFieldName(),entity.getPaddyFieldAdress(),entity.getPaddyFieldSize(),entity.getNorthID(),entity.getSouthID(),entity.getWestID(),entity.getEastID(),entity.getGsDivitionID(),entity.getTaxID(),entity.getYayaID(),entity.getOwnerID(),entity.getFarmerID()) > 0;
    }

    @Override
    public boolean update(PaddyField entity) throws Exception {
        return CrudUtil.executeUpdate("Update paddyfield set PaddyFieldName=?,PaddyFieldAdress=?,paddyFieldSize=?,northID=?,southID=?,westID=?,eastID=?,gsDivitionID=?,taxID=?,yayaID=?,ownerID=?,farmerID=? where paddyFieldID=? ", entity.getPaddyFieldName(),entity.getPaddyFieldAdress(),entity.getPaddyFieldSize(),entity.getNorthID(),entity.getSouthID(),entity.getWestID(),entity.getEastID(),entity.getGsDivitionID(),entity.getTaxID(),entity.getYayaID(),entity.getOwnerID(),entity.getFarmerID(),entity.getPaddyFieldID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from paddyfield where paddyFieldID=? ", id)>0;
    }

    @Override
    public PaddyField search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from paddyfield where paddyFieldID=? ", id);
        if(resultSet.next()){
            return new PaddyField(resultSet.getString("paddyFieldID"),resultSet.getString("PaddyFieldName"),resultSet.getString("PaddyFieldAdress"),resultSet.getDouble("paddyFieldSize"),resultSet.getString("northID"),resultSet.getString("southID"),resultSet.getString("westID"),resultSet.getString("eastID"),resultSet.getString("gsDivitionID"),resultSet.getString("taxID"),resultSet.getString("yayaID"),resultSet.getString("ownerID"),resultSet.getString("farmerID"));
        }
        return null;
    }

    @Override
    public ArrayList<PaddyField> getAll() throws Exception {
            ResultSet rst = CrudUtil.executeQuery("Select * from paddyfield ");
            ArrayList<PaddyField> PaddyField = new ArrayList();
            while (rst.next()) {
                PaddyField.add(new PaddyField(rst.getString(1), rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13)));

            }
            return PaddyField;
    }
    
}
