package lk.ijse.agreriancenter.dao.custom.impl;


import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.dao.custom.FertilizerDAO;
import lk.ijse.agreriancenter.entity.Fertilizer;
import lk.ijse.agreriancenter.entity.Officer;

public class FertilizerDAOImpl implements FertilizerDAO{

    @Override
    public boolean save(Fertilizer entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into fertilizer values(?,?,?,?) ", entity.getFertilizerID(),entity.getFertilizerName(),entity.getQtyOnHand(),entity.getFertilizerRate()) > 0;
    }

    @Override
    public boolean update(Fertilizer entity) throws Exception {
        return CrudUtil.executeUpdate("Update fertilizer set fertilizerName=?,qtyOnHand=?,fertilizerRate=? where fertilizerID=? ", entity.getFertilizerName(),entity.getQtyOnHand(),entity.getFertilizerRate(),entity.getFertilizerID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("Delete from fertilizer where fertilizerID=? ",id)>0;
    }

    @Override
    public Fertilizer search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from fertilizer where fertilizerID=? ",id);
        if (rst.next()) {
            System.out.println("okkkkkk");
            return new Fertilizer(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getDouble(4));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Fertilizer> getAll() throws Exception {
         ResultSet rst = CrudUtil.executeQuery("Select * from fertilizer");
        ArrayList<Fertilizer> fertilizers = new ArrayList();
        while (rst.next()) {
           
            fertilizers.add(new Fertilizer(rst.getString(1), rst.getString(2),rst.getDouble(3),rst.getDouble(4) ));

        }
        return fertilizers;
    }

    @Override
    public boolean updateQty(Fertilizer entity) throws Exception {
        return CrudUtil.executeUpdate("Update fertilizer set qtyOnHand=? where fertilizerID=? ", entity.getQtyOnHand(),entity.getFertilizerID())>0;
    }

    @Override
    public boolean updateStockOnHand(String id, double qtyi) throws Exception {
        return CrudUtil.executeUpdate("Update fertilizer set qtyOnHand=? where fertilizerID=? ", qtyi,id)>0;
    }
    
    
}