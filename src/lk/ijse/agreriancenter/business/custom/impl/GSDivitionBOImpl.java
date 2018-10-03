/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.GSDivitionBO;
import lk.ijse.agreriancenter.dao.custom.GSDivitionDAO;
import lk.ijse.agreriancenter.dao.custom.OfficerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.GSDivitionDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.OfficerDAOImpl;
import lk.ijse.agreriancenter.entity.GSDivition;
import lk.ijse.agreriancenter.entity.Officer;
import lk.ijse.agreriancenter.model.GSDivitionDTO;

/**
 *
 * @author Buddhika
 */
public class GSDivitionBOImpl implements GSDivitionBO{
    private  static  GSDivitionDAO dAO=new GSDivitionDAOImpl();
    private static OfficerDAO dAO1=new OfficerDAOImpl();
    @Override
    public boolean addGSDivition(GSDivitionDTO gsDivition) throws Exception {
        return dAO.save(new GSDivition(gsDivition.getGsDivitionID(), gsDivition.getGsDivitionName(), gsDivition.getGsName(), gsDivition.getGsTP(), gsDivition.getGsAdress(), gsDivition.getGsNIC(), gsDivition.getOfficerID()));
    }

    @Override
    public boolean deletrGSDivition(String fertilizerId) throws Exception {
        return dAO.delete(fertilizerId);
    }

    @Override
    public boolean updateGSDivition(GSDivitionDTO gsDivition) throws Exception {
        return dAO.update(new GSDivition(gsDivition.getGsDivitionID(),gsDivition.getGsDivitionName(),gsDivition.getGsName(),gsDivition.getGsTP(),gsDivition.getGsAdress(),gsDivition.getGsNIC(),gsDivition.getOfficerID()));
    }

    
    @Override
    public ArrayList<GSDivitionDTO> getAllGSDivition() throws Exception {
 ArrayList<GSDivition>sDivitions=dAO.getAll();
        ArrayList<GSDivitionDTO>dtos=new ArrayList<>();
        for(GSDivition divition: sDivitions){
            dtos.add(new GSDivitionDTO(divition.getGsDivitionID(),divition.getGsDivitionName(),divition.getGsName(),divition.getGsTP(),divition.getGsAdress(),divition.getGsNIC(),divition.getOfficerID()));
        }
        return dtos;
            }

    @Override
    public ArrayList<String> getAllGsDivitionIds() throws Exception {
       ArrayList<Officer>allGS=dAO1.getAll();
       ArrayList<String>ids=new ArrayList<>();
        for (Officer gs : allGS) {
            ids.add(gs.getOfficerID());
        }
        return ids;
       
    }

    @Override
    public GSDivitionDTO searchGSDivition(String Id) throws Exception {
        GSDivition divition=dAO.search(Id);
        return new GSDivitionDTO(divition.getGsDivitionID(),divition.getGsDivitionName(),divition.getGsName(),divition.getGsTP(),divition.getGsAdress(),divition.getGsNIC(),divition.getOfficerID());
    }
}
