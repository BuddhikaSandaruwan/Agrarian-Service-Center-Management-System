/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.SuperBO;
import lk.ijse.agreriancenter.model.TaxDetailsDTO;

/**
 *
 * @author Buddhika
 */
public interface TaxDetailsBO extends SuperBO{
    public boolean addTaxDetails(TaxDetailsDTO taxDetailsDTO)throws Exception;
    
    public boolean daleteTaxDetails(String taxId)throws Exception;
    
    public boolean updateTaxDetails(TaxDetailsDTO taxDetailsDTO)throws Exception;
    
    public TaxDetailsDTO searchTaxDetails(String id)throws Exception;
    
    public ArrayList<TaxDetailsDTO> getAllTaxDetails()throws Exception;
    
    public ArrayList<String> getAllTaxDetailsIds()throws Exception;  
}
