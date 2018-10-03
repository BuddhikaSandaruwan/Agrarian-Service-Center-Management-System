/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.FarmerDTO;

/**
 *
 * @author Buddhika
 */
public interface FarmerBO extends SuperBO{
     public boolean addFarmer(FarmerDTO farmerDTO)throws Exception;
    
    public boolean deleteFarmer(String id)throws Exception;
    
    public boolean updateFarmer(FarmerDTO farmerDTO)throws Exception;
    
    public FarmerDTO searchFarmer(String fieldID)throws Exception;
    
    public ArrayList<FarmerDTO> getAllFarmer()throws Exception;
    
    public ArrayList<String> getFarmer()throws Exception;
    
   
}
