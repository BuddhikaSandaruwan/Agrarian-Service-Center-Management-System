/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.TaxBO;
import lk.ijse.agreriancenter.dao.custom.TaxDAO;
import lk.ijse.agreriancenter.dao.custom.impl.TaxDAOImpl;
import lk.ijse.agreriancenter.entity.Tax;
import lk.ijse.agreriancenter.model.TaxDTO;

/**
 *
 * @author Buddhika
 */
public class TaxBOImpl implements TaxBO{
       private  static  TaxDAO taxDAO=new TaxDAOImpl();

    @Override
    public boolean addTax(TaxDTO tax) throws Exception {
        return taxDAO.save(new Tax(tax.getTaxID(),tax.getTaxName(),tax.getTaxRate()));
    }

    @Override
    public boolean daleteTax(String taxId) throws Exception {
        return taxDAO.delete(taxId);
    }

    @Override
    public boolean updateTax(TaxDTO tax) throws Exception {
        return taxDAO.update(new Tax(tax.getTaxID(),tax.getTaxName(),tax.getTaxRate()));
    }

    @Override
    public ArrayList<TaxDTO> getAllTax() throws Exception {
        ArrayList<Tax> taxs = taxDAO.getAll();
        ArrayList<TaxDTO> dtos = new ArrayList<>();
        for (Tax tax : taxs) {
            dtos.add(new TaxDTO(tax.getTaxID(),tax.getTaxName(),tax.getTaxRate()));
            System.out.println("boimpl");
        }
        return dtos;    
    }

    @Override
    public ArrayList<String> getAllTaxIds() throws Exception {
        ArrayList<Tax> allGS = taxDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (Tax gs : allGS) {
            ids.add(gs.getTaxID());
        }
        return ids;    }

    @Override
    public TaxDTO searchTax(String id) throws Exception {
        Tax tax=taxDAO.search(id);
        return new TaxDTO(tax.getTaxID(),tax.getTaxName(),tax.getTaxRate());
    }
    
}
