/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.OwnerBo;
import lk.ijse.agreriancenter.dao.custom.OwnerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.OwnerDAOImpl;
import lk.ijse.agreriancenter.entity.Owner;
import lk.ijse.agreriancenter.model.OwnerDTO;

/**
 *
 * @author Buddhika
 */
public class OwnerBOimpl implements OwnerBo{
    
    OwnerDAO ownerDAO=new OwnerDAOImpl();

    @Override
    public boolean addOwner(OwnerDTO ownerDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOwner(String ownerId) throws Exception {
        return ownerDAO.delete(ownerId);
    }

    @Override
    public boolean updateOwner(OwnerDTO ownerDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OwnerDTO searchOwner(String ID) throws Exception {
        Owner owner=ownerDAO.search(ID);
        return new OwnerDTO(owner.getOwnerID(),owner.getOwnerName(),owner.getOwnerAdress(),owner.getOwnerNIC(),owner.getOwnerTP(),owner.getLandNumber());
    }

    @Override
    public ArrayList<OwnerDTO> getAllOwner() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllOwnerIds() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
