/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.agreriancenter.business.custom.FarmerBO;
import static lk.ijse.agreriancenter.dao.DAOFactory.DAOTypes.tax;
import lk.ijse.agreriancenter.dao.custom.FarmerDAO;
import lk.ijse.agreriancenter.dao.custom.impl.FarmerDAOImpl;
import lk.ijse.agreriancenter.entity.Farmer;
import lk.ijse.agreriancenter.model.FarmerDTO;

/**
 *
 * @author Buddhika
 */
public class FarmerBOImpl implements FarmerBO{
    
    FarmerDAO farmerDAO=new FarmerDAOImpl();

    @Override
    public boolean addFarmer(FarmerDTO farmerDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteFarmer(String id) throws Exception {
        return farmerDAO.delete(id);
    }

    @Override
    public boolean updateFarmer(FarmerDTO farmerDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarmerDTO searchFarmer(String fieldID) throws Exception {
        Farmer farmer=farmerDAO.search(fieldID);
        return new FarmerDTO(farmer.getFarmerID(),farmer.getFarmerName(),farmer.getFarmerAdress(),farmer.getFarmerNIC(),farmer.getFarmerTP(),farmer.getFarmerType());
    }

    @Override
    public ArrayList<FarmerDTO> getAllFarmer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getFarmer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
