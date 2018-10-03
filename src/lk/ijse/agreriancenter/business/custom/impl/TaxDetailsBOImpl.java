/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.TaxDetailsBO;
import lk.ijse.agreriancenter.dao.custom.TaxDetailsDAO;
import lk.ijse.agreriancenter.dao.custom.impl.TaxDetailsDAOImpl;
import lk.ijse.agreriancenter.entity.Officer;
import lk.ijse.agreriancenter.entity.TaxDetails;
import lk.ijse.agreriancenter.model.TaxDetailsDTO;

/**
 *
 * @author Buddhika
 */
public class TaxDetailsBOImpl implements TaxDetailsBO {

   private static TaxDetailsDAO taxDetailsDAO = new TaxDetailsDAOImpl();

    @Override
    public boolean addTaxDetails(TaxDetailsDTO taxDetailsDTO) throws Exception {
        return taxDetailsDAO.save(new TaxDetails(taxDetailsDTO.getPaddyFieldID(), taxDetailsDTO.getTaxID(), taxDetailsDTO.getDate(), taxDetailsDTO.getAmount()));
    }

    @Override
    public boolean daleteTaxDetails(String taxId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTaxDetails(TaxDetailsDTO taxDetailsDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaxDetailsDTO searchTaxDetails(String id) throws Exception {
        TaxDetails taxDetailsDTO = taxDetailsDAO.search(id);
        return new TaxDetailsDTO(taxDetailsDTO.getPaddfieldId(), taxDetailsDTO.getTaxId(), taxDetailsDTO.getDate(), taxDetailsDTO.getAmount());
    }

    @Override
    public ArrayList<TaxDetailsDTO> getAllTaxDetails() throws Exception {
        ArrayList<TaxDetails> officers = taxDetailsDAO.getAll();
        ArrayList<TaxDetailsDTO> dtos = new ArrayList<>();
        for (TaxDetails off : officers) {
            dtos.add(new TaxDetailsDTO(off.getPaddfieldId(), off.getTaxId(), off.getDate(), off.getAmount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllTaxDetailsIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
