/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.OfficerBO;
import lk.ijse.agreriancenter.dao.custom.FertilizerDAO;
import lk.ijse.agreriancenter.dao.custom.OfficerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.OfficerDAOImpl;
import lk.ijse.agreriancenter.entity.Fertilizer;
import lk.ijse.agreriancenter.entity.Officer;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;

/**
 *
 * @author Buddhika
 */
public class OfficerBOImpl implements OfficerBO {

    private static OfficerDAO officerDAO = new OfficerDAOImpl();

    @Override
    public boolean addOfficer(OfficerDTO officer) throws Exception {
        return officerDAO.save(new Officer(officer.getOfficerID(), officer.getOfficerName(), officer.getOfficerAdress(), officer.getOfficerNic(), officer.getOfficerTP()));
    }

    @Override
    public boolean deleteOfficer(String officerId) throws Exception {
        return officerDAO.delete(officerId);
    }

    @Override
    public boolean updateOfficer(OfficerDTO officer) throws Exception {
        return officerDAO.update(new Officer(officer.getOfficerID(), officer.getOfficerName(), officer.getOfficerAdress(), officer.getOfficerNic(), officer.getOfficerTP()));
    }

    @Override
    public ArrayList<OfficerDTO> getAllOfficer() throws Exception {
        ArrayList<Officer> officers = officerDAO.getAll();
        ArrayList<OfficerDTO> dtos = new ArrayList<>();
        for (Officer off : officers) {
            dtos.add(new OfficerDTO(off.getOfficerID(), off.getOfficerName(), off.getOfficerAdress(), off.getOfficerNic(), off.getOfficerTP()));
        }
        return dtos;

    }

    @Override
    public ArrayList<String> getAllOfficerIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OfficerDTO searchOfficer(String ID) throws Exception {
        Officer officer = officerDAO.search(ID);
        return new OfficerDTO(officer.getOfficerID(), officer.getOfficerName(), officer.getOfficerAdress(), officer.getOfficerNic(), officer.getOfficerTP());
    }

}
