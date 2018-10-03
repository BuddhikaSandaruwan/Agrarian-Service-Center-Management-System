/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.FarmerDTO;
import lk.ijse.agreriancenter.model.FertilizerDTO;

/**
 *
 * @author Buddhika
 */
public interface FertilizerBO extends SuperBO{
    public boolean addFertilizer(FertilizerDTO fertilizer)throws Exception;
    
    public boolean deleteFertilizer(String fertilizerId)throws Exception;
    
    public boolean updateFertilizer(FertilizerDTO fertilizer)throws Exception;
    
    public FertilizerDTO searchFertilizer(String id)throws Exception;
    
    public ArrayList<FertilizerDTO> getAllFertilizer()throws Exception;
    
    public ArrayList<String> getAllFertilizerIds()throws Exception;
}
