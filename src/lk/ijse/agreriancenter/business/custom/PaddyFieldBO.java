/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDetailsDTO;

/**
 *
 * @author Buddhika
 */
public interface PaddyFieldBO extends SuperBO{
    
    public boolean addPaddyField(PaddyFieldDetailsDTO paddyFieldDetailsDTO)throws Exception;
    
    public boolean deletePaddyField(String id)throws Exception;
    
    public boolean updatePaddyField(PaddyFieldDetailsDTO paddyFieldDetailsDTO)throws Exception;
    
    public PaddyFieldDTO searchPaddyField(String fieldID)throws Exception;
    
    public ArrayList<PaddyFieldDetailsDTO> getAllPaddyField()throws Exception;
    
    public ArrayList<String> getGsDivition()throws Exception;
    
    public ArrayList<String> getTax()throws Exception;
    
    public ArrayList<String> getYaya()throws Exception;
    
    public ArrayList<String> getFieldId()throws Exception;
    
    public ArrayList<String> getFieldName()throws Exception;
    
    
}
