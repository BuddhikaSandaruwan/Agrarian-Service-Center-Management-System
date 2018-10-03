/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.management.RuntimeErrorException;
import lk.ijse.agreriancenter.db.DBConnection;

/**
 *
 * @author Buddhika
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql,Object... params)throws Exception{
        
        int paramsCount=sql.split("[?]").length -1;
        if(paramsCount !=params.length){
            throw new RuntimeException("Parameters count is mismatched");
        }
        
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareCall(sql);
        
        for(int i=0; i<params.length;i++){
            pstm.setObject(i+1,params[i]);
        }
         return pstm;
    }
    public  static  ResultSet executeQuery(String sql,Object... params)throws Exception{
        return getPreparedStatement(sql, params).executeQuery();
    }
    public  static  int executeUpdate(String sql,Object... params)throws Exception{
        
        return getPreparedStatement(sql, params).executeUpdate();
    }
}
