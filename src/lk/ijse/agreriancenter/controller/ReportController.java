/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.db.DBConnection;
import lk.ijse.edu.kfcsystem.jasper.jasperviewer.MyJasperViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Buddhika
 */
public class ReportController {

   @FXML
    private JFXButton butAdd;

    @FXML
    private JFXButton butAdd1;

    @FXML
    private JFXButton butAdd2;

    @FXML
    private JFXButton butAdd3;

    @FXML
    private JFXButton butAdd4;

    @FXML
    private JFXButton butAdd5;

    @FXML
    private JFXButton butAdd6;

    @FXML
    private JFXButton butAdd11;

    @FXML
    private JFXButton butAdd21;

    @FXML
    private JFXButton butAdd31;

    @FXML
    private JFXButton butAdd41;

    @FXML
    private JFXButton butAdd51;

    @FXML
    void addClick(MouseEvent event) {

    }

    @FXML
    void farmerClick(MouseEvent event) {
         try {
            InputStream file = getClass().getResourceAsStream("/lk/ijse/agreriancenter/report/farmer.jrxml");
            JasperReport report = JasperCompileManager.compileReport(file);
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(report, map, DBConnection.getInstance().getConnection());
            
            new MyJasperViewer(print).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void fertilizerClick(MouseEvent event) {
        try {
            InputStream file = getClass().getResourceAsStream("/lk/ijse/agreriancenter/report/fertilizer.jrxml");
            JasperReport report = JasperCompileManager.compileReport(file);
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(report, map, DBConnection.getInstance().getConnection());
            
            new MyJasperViewer(print).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void gsDivitionClick(MouseEvent event) {
       
    }

    @FXML
    void officerClick(MouseEvent event) {
        
    }

    @FXML
    void ownerClick(MouseEvent event) {
      
    }

    @FXML
    void paddyFieldClick(MouseEvent event) {

    }

    @FXML
    void stockClick(MouseEvent event) {

    }

    @FXML
    void txxClick(MouseEvent event) {

    }

    @FXML
    void yayaClick(MouseEvent event) {

    }
    
}
