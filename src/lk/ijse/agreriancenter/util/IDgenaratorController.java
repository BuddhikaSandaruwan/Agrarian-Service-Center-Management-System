/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.agreriancenter.db.DBConnection;

/**
 *
 * @author Buddhika
 */
public class IDgenaratorController {

    public static String getLastID(String tablName, String colName) throws Exception {
        String sql = "SELECT " + colName + " FROM " + tablName + " ORDER BY 1 DESC LIMIT 1";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
