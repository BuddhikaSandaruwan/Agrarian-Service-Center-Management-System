/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.FertilizerBO;
import lk.ijse.agreriancenter.dao.custom.FertilizerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDAOImpl;
import lk.ijse.agreriancenter.entity.Fertilizer;
import lk.ijse.agreriancenter.entity.Officer;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;

/**
 *
 * @author Buddhika
 */
public class FertilizerBOImpl implements FertilizerBO{
 private  static  FertilizerDAO dAOImpl;
    public FertilizerBOImpl() {
        dAOImpl=new FertilizerDAOImpl();
    }
    
    
    @Override
    public boolean addFertilizer(FertilizerDTO fertilizer) throws Exception {
        return dAOImpl.save(new Fertilizer(fertilizer.getFertilizerID(),fertilizer.getFertilizerName(),fertilizer.getQtyOnHand(),fertilizer.getFertilizerRate()));
    }

    @Override
    public boolean deleteFertilizer(String fertilizerId) throws Exception {
        return dAOImpl.delete(fertilizerId);
    }

    @Override
    public boolean updateFertilizer(FertilizerDTO fertilizer) throws Exception {
        return dAOImpl.update(new Fertilizer(fertilizer.getFertilizerID(),fertilizer.getFertilizerName(),fertilizer.getQtyOnHand(),fertilizer.getFertilizerRate()));
    }

    @Override
    public FertilizerDTO searchFertilizer(String id) throws Exception {
        Fertilizer fertilizer=dAOImpl.search(id);
        if(fertilizer!=null){
            return new FertilizerDTO(fertilizer.getFertilizerID(),fertilizer.getFertilizerName(), fertilizer.getQtyOnHand(),fertilizer.getFertilizerRate());
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<FertilizerDTO> getAllFertilizer() throws Exception {
         ArrayList<Fertilizer>fertilizers=dAOImpl.getAll();
        ArrayList<FertilizerDTO>dtos=new ArrayList<>();
        for(Fertilizer fer: fertilizers){
            System.out.println("der");
            dtos.add(new FertilizerDTO(fer.getFertilizerID(),fer.getFertilizerName(),fer.getQtyOnHand(),fer.getFertilizerRate()));
        }
        return dtos;
        
    }

    @Override
    public ArrayList<String> getAllFertilizerIds() throws Exception {
       ArrayList<Fertilizer>allGS=dAOImpl.getAll();
       ArrayList<String>ids=new ArrayList<>();
        for (Fertilizer gs : allGS) {
            ids.add(gs.getFertilizerID());
        } 
        
        return ids;
           }
    
}
