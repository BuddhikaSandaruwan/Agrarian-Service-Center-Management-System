/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.IssueFertilizerBO;
import lk.ijse.agreriancenter.dao.custom.FertilizerDAO;
import lk.ijse.agreriancenter.dao.custom.IssueFertilizerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.IssueFertilizerDAOImpl;
import lk.ijse.agreriancenter.db.DBConnection;
import lk.ijse.agreriancenter.entity.IssueFertilizer;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.IssueFertilizerDTO;

/**
 *
 * @author Buddhika
 */
public class IssueFertilizerBOImpl implements IssueFertilizerBO{
    
    IssueFertilizerDAO issueFertilizerDAO=new IssueFertilizerDAOImpl();
    FertilizerDAO fertilizerDAO=new FertilizerDAOImpl();

    @Override
    public boolean addIssueFertilizer(IssueFertilizerDTO issueFertilizerDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
           
            boolean add = issueFertilizerDAO.save(new IssueFertilizer(issueFertilizerDTO.getId(),issueFertilizerDTO.getFieldId(),issueFertilizerDTO.getFarmerNic(),issueFertilizerDTO.getFertilizerId(),issueFertilizerDTO.getDate()));
            if (!add) {
                return false;
            }
            add = fertilizerDAO.updateStockOnHand(issueFertilizerDTO.getFertilizerId(),(issueFertilizerDTO.getStockOnHand()-issueFertilizerDTO.getIssueQty()));
            if (!add) {
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteIssueFertilizer(String issueFertilizerId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateIssueFertilizer(IssueFertilizerDTO issueFertilizerDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IssueFertilizerDTO searchIssueFertilizer(String ID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IssueFertilizerDTO> getAllIssueFertilizer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllIssueFertilizerId() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
