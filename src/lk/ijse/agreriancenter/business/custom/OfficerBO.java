/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;

/**
 *
 * @author Buddhika
 */
public interface OfficerBO extends SuperBO{
    public boolean addOfficer(OfficerDTO officer)throws Exception;
    
    public boolean deleteOfficer(String officerId)throws Exception;
    
    public boolean updateOfficer(OfficerDTO officer)throws Exception;
    
    public OfficerDTO searchOfficer(String ID)throws Exception;
    
    public ArrayList<OfficerDTO> getAllOfficer()throws Exception;
    
    public ArrayList<String> getAllOfficerIds()throws Exception;
}
