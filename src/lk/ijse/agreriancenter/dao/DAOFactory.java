/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao;

import lk.ijse.agreriancenter.dao.custom.impl.FarmerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.FertilizerDetailsDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.GSDivitionDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.OfficerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.OwnerDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.PaddyFieldDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.StockDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.StockDetailsDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.TaxDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.TaxDetailsDAOImpl;
import lk.ijse.agreriancenter.dao.custom.impl.YayaDAOImpl;

/**
 *
 * @author Buddhika
 */
public class DAOFactory {

    public enum DAOTypes {
        farmer, fertilizer, fertilizerdetails, gsdivition, officer, owner, paddyfield, stock, stockdetails, tax, taxdetails, yaya;
    }
    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case farmer:
                return (T) new FarmerDAOImpl();
            case fertilizer:
                return (T) new FertilizerDAOImpl();
            case fertilizerdetails:
                return (T) new FertilizerDetailsDAOImpl();
            case gsdivition:
                return (T) new GSDivitionDAOImpl();
            case officer:
                return (T) new OfficerDAOImpl();
            case owner:
                return (T) new OwnerDAOImpl();
            case paddyfield:
                return (T) new PaddyFieldDAOImpl();
            case stock:
                return (T) new StockDAOImpl();
            case stockdetails:
                return (T) new StockDetailsDAOImpl();
            case tax:
                return (T) new TaxDAOImpl();
            case taxdetails:
                return (T) new TaxDetailsDAOImpl();
            case yaya:
                return (T) new YayaDAOImpl();
            default:
                return null;
        }
    }
}
