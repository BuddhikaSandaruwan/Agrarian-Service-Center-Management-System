/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.IssueFertilizerDTO;

/**
 *
 * @author Buddhika
 */
public interface IssueFertilizerBO extends SuperBO{
    public boolean addIssueFertilizer(IssueFertilizerDTO issueFertilizerDTO)throws Exception;
    
    public boolean deleteIssueFertilizer(String issueFertilizerId)throws Exception;
    
    public boolean updateIssueFertilizer(IssueFertilizerDTO issueFertilizerDTO)throws Exception;
    
    public IssueFertilizerDTO searchIssueFertilizer(String ID)throws Exception;
    
    public ArrayList<IssueFertilizerDTO> getAllIssueFertilizer()throws Exception;
    
    public ArrayList<String> getAllIssueFertilizerId()throws Exception;
}
