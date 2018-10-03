/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.YayaDTO;

/**
 *
 * @author Buddhika
 */
public interface YayaBO extends SuperBO{
    public boolean addYaya(YayaDTO yaya)throws Exception;
    
    public boolean deleteYaya(String yaya)throws Exception;
    
    public boolean updateYaya(YayaDTO yaya)throws Exception;
    
    public YayaDTO searchYaya(String id)throws Exception;
    
    public ArrayList<YayaDTO> getAllYaya()throws Exception;
    
    public ArrayList<String> getAllYayaIds()throws Exception;  
}
