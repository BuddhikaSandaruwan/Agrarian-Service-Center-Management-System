/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao.custom;

import lk.ijse.agreriancenter.dao.CrudDAO;
import lk.ijse.agreriancenter.entity.Fertilizer;

/**
 *
 * @author Buddhika
 */
public interface FertilizerDAO extends CrudDAO<Fertilizer, String> {

    public boolean updateQty(Fertilizer entity) throws Exception;

    public boolean updateStockOnHand(String id, double qtyi) throws Exception;

}
