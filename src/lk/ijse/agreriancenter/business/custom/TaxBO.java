/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.TaxDTO;

/**
 *
 * @author Buddhika
 */
public interface TaxBO extends SuperBO{
  public boolean addTax(TaxDTO tax)throws Exception;
    
    public boolean daleteTax(String taxId)throws Exception;
    
    public boolean updateTax(TaxDTO tax)throws Exception;
    
    public TaxDTO searchTax(String id)throws Exception;
    
    public ArrayList<TaxDTO> getAllTax()throws Exception;
    
    public ArrayList<String> getAllTaxIds()throws Exception;  
}
