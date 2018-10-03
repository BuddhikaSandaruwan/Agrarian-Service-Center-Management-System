/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.YayaDAO;
import lk.ijse.agreriancenter.entity.Yaya;

/**
 *
 * @author Buddhika
 */
public class YayaDAOImpl implements YayaDAO{

    @Override
    public boolean save(Yaya entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into yaya values(?,?)", entity.getYayaID(),entity.getYayaName()) > 0;
    }

    @Override
    public boolean update(Yaya entity) throws Exception {
        return CrudUtil.executeUpdate("Update yaya set yayaName=? where yayaID=? ", entity.getYayaName(),entity.getYayaID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from yaya where yayaID=? ", id)>0;
    }

    @Override
    public Yaya search(String id) throws Exception {
        ResultSet resultSet=CrudUtil.executeQuery("Select * from yaya where yayaID=? ", id);
        if(resultSet.next()){
            return new Yaya(resultSet.getString("yayaID"),resultSet.getString("yayaName"));
        }
        return null;    }

    @Override
    public ArrayList<Yaya> getAll() throws Exception {
ResultSet rst = CrudUtil.executeQuery("Select * from yaya ");
        ArrayList<Yaya> yayas = new ArrayList();
        while (rst.next()) {
            yayas.add(new Yaya(rst.getString(1), rst.getString(2) ));
        }
        return yayas;    }
    
}
