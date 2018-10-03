/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.business;


import lk.ijse.agreriancenter.business.custom.impl.FarmerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.FertilizerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.GSDivitionBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.OfficerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.OwnerBOimpl;
import lk.ijse.agreriancenter.business.custom.impl.PaddyFieldBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.StockBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.StockDetailsBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.TaxBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.TaxDetailsBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.YayaBOImpl;

/**
 *
 * @author Buddhika
 */
public class BOFactory {
    public enum BOTypes{
       farmer,fertilizer,gsdivition,officer,owner,paddyfield,stock,stockdetails,tax,taxdetails,yaya  
    }
    private static BOFactory bOFactory;

    private BOFactory() {
        
    }
    public static BOFactory getInstance(){
        if(bOFactory==null){
            bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    public  <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case fertilizer:
                return (T) new FertilizerBOImpl();
            case gsdivition:
                return (T) new GSDivitionBOImpl();
            case officer:
                return (T) new OfficerBOImpl();
            case owner:
                return (T) new OwnerBOimpl();
            case stock:
                return (T) new StockBOImpl();
            case tax:
                return (T) new TaxBOImpl();
            case yaya:
                return (T) new YayaBOImpl();
            case paddyfield:
                return (T) new PaddyFieldBOImpl();
            case farmer:
                return (T) new FarmerBOImpl();
            case stockdetails:
                return (T) new StockDetailsBOImpl();
            case taxdetails:
                return (T) new TaxDetailsBOImpl();
            default:
                return null;
        }
    }
}
