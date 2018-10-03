













/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.PaddyFieldBO;
import lk.ijse.agreriancenter.dao.DAOFactory;
import lk.ijse.agreriancenter.dao.custom.FarmerDAO;
import lk.ijse.agreriancenter.dao.custom.GSDivitionDAO;
import lk.ijse.agreriancenter.dao.custom.OwnerDAO;
import lk.ijse.agreriancenter.dao.custom.PaddyFieldDAO;
import lk.ijse.agreriancenter.dao.custom.TaxDAO;
import lk.ijse.agreriancenter.dao.custom.YayaDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FarmerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.GSDivitionDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.OwnerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.PaddyFieldDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.TaxDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.YayaDAOImpl;
import lk.ijse.agreriancenter.db.DBConnection;
import lk.ijse.agreriancenter.entity.Farmer;
import lk.ijse.agreriancenter.entity.GSDivition;
import lk.ijse.agreriancenter.entity.Owner;
import lk.ijse.agreriancenter.entity.PaddyField;
import lk.ijse.agreriancenter.entity.Tax;
import lk.ijse.agreriancenter.entity.Yaya;
import lk.ijse.agreriancenter.model.FarmerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDetailsDTO;

/**
 *
 * @author Buddhika
 */
public class PaddyFieldBOImpl implements PaddyFieldBO {

    PaddyFieldDAO paddyFieldDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.paddyfield);
    
    OwnerDAO ownerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.owner);
    FarmerDAO farmerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.farmer);
    GSDivitionDAO divitionDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.gsdivition);
    TaxDAO taxDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.tax);
    YayaDAO yayaDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.yaya);
    

    @Override
    public boolean addPaddyField(PaddyFieldDetailsDTO paddyFieldDetailsDTO) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            PaddyFieldDTO paddyFieldDTO = paddyFieldDetailsDTO.getPaddyFieldDTO();
            FarmerDTO farmerDTO = paddyFieldDetailsDTO.getFarmerDTO();
            OwnerDTO ownerDTO = paddyFieldDetailsDTO.getOwnerDTO();

            boolean add = ownerDAO.save(new Owner(ownerDTO.getOwnerID(), ownerDTO.getOwnerName(), ownerDTO.getOwnerAdress(), ownerDTO.getOwnerNIC(), ownerDTO.getOwnerTP(), ownerDTO.getLandNumber()));
            if (!add) {
                System.out.println("owner false");
                return false;
            }
            add = farmerDAO.save(new Farmer(farmerDTO.getFarmerID(), farmerDTO.getFarmerName(), farmerDTO.getFarmerAdress(), farmerDTO.getFarmerNIC(), farmerDTO.getFarmerTP(), farmerDTO.getFarmerType()));
            if (!add) {
                System.out.println("farmer false");
                connection.rollback();
                return false;
            }
            add = paddyFieldDAO.save(new PaddyField(paddyFieldDTO.getPaddyFieldID(), paddyFieldDTO.getPaddyFieldName(), paddyFieldDTO.getPaddyFieldAdress(), paddyFieldDTO.getPaddyFieldSize(), paddyFieldDTO.getNorthID(), paddyFieldDTO.getSouthID(), paddyFieldDTO.getWestID(), paddyFieldDTO.getEastID(), paddyFieldDTO.getGsDivitionID(), paddyFieldDTO.getTaxID(), paddyFieldDTO.getYayaID(), paddyFieldDTO.getOwnerID(), paddyFieldDTO.getFarmerID()));
            if (!add) {
                connection.rollback();
                System.out.println("paddy false");
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean updatePaddyField(PaddyFieldDetailsDTO paddyFieldDetailsDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            PaddyFieldDTO paddyFieldDTO = paddyFieldDetailsDTO.getPaddyFieldDTO();
            FarmerDTO farmerDTO = paddyFieldDetailsDTO.getFarmerDTO();
            OwnerDTO ownerDTO = paddyFieldDetailsDTO.getOwnerDTO();

            boolean add = ownerDAO.update(new Owner(ownerDTO.getOwnerID(), ownerDTO.getOwnerName(), ownerDTO.getOwnerAdress(), ownerDTO.getOwnerNIC(), ownerDTO.getOwnerTP(), ownerDTO.getLandNumber()));
            if (!add) {
                System.out.println("owner false");
                return false;
            }
            add = farmerDAO.update(new Farmer(farmerDTO.getFarmerID(), farmerDTO.getFarmerName(), farmerDTO.getFarmerAdress(), farmerDTO.getFarmerNIC(), farmerDTO.getFarmerTP(), farmerDTO.getFarmerType()));
            if (!add) {
                System.out.println("farmer false");
                connection.rollback();
                return false;
            }
            add = paddyFieldDAO.update(new PaddyField(paddyFieldDTO.getPaddyFieldID(), paddyFieldDTO.getPaddyFieldName(), paddyFieldDTO.getPaddyFieldAdress(), paddyFieldDTO.getPaddyFieldSize(), paddyFieldDTO.getNorthID(), paddyFieldDTO.getSouthID(), paddyFieldDTO.getWestID(), paddyFieldDTO.getEastID(), paddyFieldDTO.getGsDivitionID(), paddyFieldDTO.getTaxID(), paddyFieldDTO.getYayaID(), paddyFieldDTO.getOwnerID(), paddyFieldDTO.getFarmerID()));
            if (!add) {
                connection.rollback();
                System.out.println("paddy false");
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<PaddyFieldDetailsDTO> getAllPaddyField() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getGsDivition() throws Exception {
        ArrayList<GSDivition> allGS = divitionDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (GSDivition gs : allGS) {
            ids.add(gs.getGsDivitionID());
        }
        return ids;

    }

    @Override
    public ArrayList<String> getTax() throws Exception {
        ArrayList<Tax> allGS = taxDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (Tax gs : allGS) {
            ids.add(gs.getTaxID());
        }
        return ids;
    }

    @Override
    public ArrayList<String> getYaya() throws Exception {
        ArrayList<Yaya> allGS = yayaDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (Yaya gs : allGS) {
            ids.add(gs.getYayaID());
        }
        return ids;
    }

    @Override
    public boolean deletePaddyField(String id) throws Exception {

//            PaddyFieldDTO paddyFieldDTO = paddyFieldDetailsDTO.getPaddyFieldDTO();
        boolean isAdd = farmerDAO.delete(id);
        return isAdd;

    }

    @Override
    public PaddyFieldDTO searchPaddyField(String fieldID) throws Exception {
        PaddyField field=paddyFieldDAO.search(fieldID);
        return new PaddyFieldDTO(field.getPaddyFieldID(),field.getPaddyFieldName(),field.getPaddyFieldAdress(),field.getPaddyFieldSize(),field.getNorthID(),field.getSouthID(),field.getWestID(),field.getEastID(),field.getGsDivitionID(),field.getTaxID(),field.getYayaID(),field.getOwnerID(),field.getFarmerID());
    }

    @Override
    public ArrayList<String> getFieldId() throws Exception {
        ArrayList<PaddyField> allGS = paddyFieldDAO.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (PaddyField gs : allGS) {
            ids.add(gs.getPaddyFieldID());
        }
        return ids;
    }

    @Override
    public ArrayList<String> getFieldName() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
