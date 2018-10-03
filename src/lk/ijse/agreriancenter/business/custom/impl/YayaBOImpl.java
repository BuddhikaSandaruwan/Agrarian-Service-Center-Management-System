/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.YayaBO;
import lk.ijse.agreriancenter.dao.custom.YayaDAO;
import lk.ijse.agreriancenter.dao.custom.impl.YayaDAOImpl;
import lk.ijse.agreriancenter.entity.Yaya;
import lk.ijse.agreriancenter.model.YayaDTO;

/**
 *
 * @author Buddhika
 */
public class YayaBOImpl implements YayaBO{
    private  static  YayaDAO yayaDAO=new YayaDAOImpl();
    @Override
    public boolean addYaya(YayaDTO yaya) throws Exception {
        return yayaDAO.save(new Yaya(yaya.getYayaID(),yaya.getYayaName()));
    }

    @Override
    public boolean deleteYaya(String yaya) throws Exception {
        return yayaDAO.delete(yaya);    }

    @Override
    public boolean updateYaya(YayaDTO yaya) throws Exception {
        return yayaDAO.update(new Yaya(yaya.getYayaID(),yaya.getYayaName()));
    }

    @Override
    public ArrayList<YayaDTO> getAllYaya() throws Exception {
        ArrayList<Yaya>yayas=yayaDAO.getAll();
        ArrayList<YayaDTO>dtos=new ArrayList<>();
        for(Yaya yaya: yayas){
            dtos.add(new YayaDTO(yaya.getYayaID(),yaya.getYayaName()));
        }
        return dtos;    }

    @Override
    public ArrayList<String> getAllYayaIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public YayaDTO searchYaya(String id) throws Exception {
        Yaya yaya=yayaDAO.search(id);
        return new YayaDTO(yaya.getYayaID(),yaya.getYayaName());
    }
    
    
}
