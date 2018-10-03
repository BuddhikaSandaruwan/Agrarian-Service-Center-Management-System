/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.OwnerDTO;

/**
 *
 * @author Buddhika
 */
public interface OwnerBo extends SuperBO{
    public boolean addOwner(OwnerDTO ownerDTO)throws Exception;
    
    public boolean deleteOwner(String ownerId)throws Exception;
    
    public boolean updateOwner(OwnerDTO ownerDTO)throws Exception;
    
    public OwnerDTO searchOwner(String ID)throws Exception;
    
    public ArrayList<OwnerDTO> getAllOwner()throws Exception;
    
    public ArrayList<String> getAllOwnerIds()throws Exception;
    
}
