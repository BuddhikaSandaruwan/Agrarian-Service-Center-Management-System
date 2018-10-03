/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.GSDivitionDTO;

/**
 *
 * @author Buddhika
 */
public interface GSDivitionBO extends SuperBO{
    public boolean addGSDivition(GSDivitionDTO gsDivition)throws Exception;
    
    public boolean deletrGSDivition(String fertilizerId)throws Exception;
    
    public boolean updateGSDivition(GSDivitionDTO gsDivition)throws Exception;
    
    public GSDivitionDTO searchGSDivition(String Id)throws Exception;
    
    public ArrayList<GSDivitionDTO> getAllGSDivition()throws Exception;
    
    public ArrayList<String> getAllGsDivitionIds()throws Exception;
}
