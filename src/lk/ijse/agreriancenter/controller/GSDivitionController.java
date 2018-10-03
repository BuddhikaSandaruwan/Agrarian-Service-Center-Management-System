/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.FarmerBO;
import lk.ijse.agreriancenter.business.custom.GSDivitionBO;
import lk.ijse.agreriancenter.business.custom.impl.GSDivitionBOImpl;
import lk.ijse.agreriancenter.db.DBConnection;
import lk.ijse.agreriancenter.model.GSDivitionDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;
import lk.ijse.agreriancenter.valideter.Validetion;
import lk.ijse.agreriancenter.util.IDgenerator;
import lk.ijse.edu.kfcsystem.jasper.jasperviewer.MyJasperViewer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Buddhika
 */
public class GSDivitionController implements Initializable {

    @FXML
    private JFXTextField txtGSDivitionId;

    @FXML
    private JFXTextField txtGsDivitionName;

    @FXML
    private JFXTextField txtGSName;

    @FXML
    private JFXTextField txtGSAdress;

    @FXML
    private JFXTextField txtGSTP;

    @FXML
    private JFXTextField txtGSNIC;

    @FXML
    private JFXButton butAdd;

    @FXML
    private TableView<GSDivitionDTO> tableGSDivition;

    @FXML
    private JFXComboBox<String> combOfficerID;

    @FXML
    private JFXButton butDelete;

    @FXML
    private JFXButton butUpdate;

    private GSDivitionBO bO;

    public GSDivitionController() {
      bO=BOFactory.getInstance().getBO(BOFactory.BOTypes.gsdivition);
    }
    
    
    GSDivitionDTO dTO;
    @FXML
    private JFXButton btReport;

    @FXML
    void divisionNameAction(ActionEvent event) {
        if (Validetion.nameValidation(txtGsDivitionName.getText())) {
            txtGSName.requestFocus();
        } else {
            txtGsDivitionName.requestFocus();
        }
    }

    @FXML
    void addClicked(MouseEvent event) throws Exception {
        String gsDivitionID = txtGSDivitionId.getText();
        String gsDivitionName = txtGsDivitionName.getText();
        String gsName = txtGSName.getText();
        int gsTP = Integer.parseInt(txtGSTP.getText());
        String gsAdress = txtGSAdress.getText();
        String gsNIC = txtGSNIC.getText();
        String officerID = combOfficerID.getValue().toString();

        dTO = new GSDivitionDTO(gsDivitionID, gsDivitionName, gsName, gsTP, gsAdress, gsNIC, officerID);
        boolean isAdd = bO.addGSDivition(dTO);
        if (isAdd) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            OrderID();

            txtGSDivitionId.setText(IDgenerator.getNewID("gsdivition", "gsDivitionID", "GSD"));
            txtGSDivitionId.clear();
            txtGsDivitionName.clear();
            txtGSName.clear();
            txtGSTP.clear();
            txtGSAdress.clear();
            txtGSNIC.clear();

        }
    }

    @FXML
    void deleteClicked(MouseEvent event) throws Exception {
        boolean deleted = bO.deletrGSDivition(txtGSDivitionId.getText());
        if (deleted) {
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            error.show();
            getAll();
            OrderID();
            txtGSDivitionId.setText(IDgenerator.getNewID("gsdivition", "gsDivitionID", "GSD"));
            txtGSDivitionId.clear();
            txtGsDivitionName.clear();
            txtGSName.clear();
            txtGSTP.clear();
            txtGSAdress.clear();
            txtGSNIC.clear();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Not Deleted", ButtonType.OK);
            error.show();

        }
    }

    @FXML
    void tableclicked(MouseEvent event) {
        butAdd.setDisable(true);
        dTO = tableGSDivition.getSelectionModel().getSelectedItem();
        txtGSDivitionId.setText(dTO.getGsDivitionID());
        txtGsDivitionName.setText(dTO.getGsDivitionName());
        txtGSName.setText(dTO.getGsName());
        txtGSTP.setText(Integer.toString(dTO.getGsTP()));
        txtGSAdress.setText(dTO.getGsAdress());
        txtGSNIC.setText(dTO.getGsNIC());
        combOfficerID.setValue(dTO.getOfficerID());

    }

    @FXML
    void updateClicked(MouseEvent event) throws Exception {

        dTO = new GSDivitionDTO(txtGSDivitionId.getText(), txtGsDivitionName.getText(), txtGSName.getText(), Integer.parseInt(txtGSTP.getText()), txtGSAdress.getText(), txtGSNIC.getText(), combOfficerID.getValue().toString());
        boolean isUpdated = bO.updateGSDivition(dTO);
        if (isUpdated) {
            butAdd.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            OrderID();
            txtGSDivitionId.setText(IDgenerator.getNewID("gsdivition", "gsDivitionID", "GSD"));
            txtGSDivitionId.clear();
            txtGsDivitionName.clear();
            txtGSName.clear();
            txtGSTP.clear();
            txtGSAdress.clear();
            txtGSNIC.clear();
        }
    }

    private void getAll() {

        try {
            tableGSDivition.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("gsDivitionID"));
            tableGSDivition.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("gsDivitionName"));
            tableGSDivition.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("gsName"));
            tableGSDivition.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gsTP"));
            tableGSDivition.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gsAdress"));
            tableGSDivition.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("gsNIC"));
            tableGSDivition.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("officerID"));
            lordFertilizer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lordFertilizer() throws Exception {
        tableGSDivition.setItems(FXCollections.observableArrayList(bO.getAllGSDivition()));
    }

    private void loadIDS() throws Exception {
        ArrayList<String> id = bO.getAllGsDivitionIds();
        combOfficerID.getItems().clear();
        for (String ab : id) {
            combOfficerID.getItems().add(ab);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAll();
        txtGSDivitionId.setDisable(true);
        btReport.setVisible(false);
        try {
            loadIDS();
            OrderID();
        } catch (Exception ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void OrderID() {
        
        try {
            String orderId;
            orderId = IDgenerator.getNewID("gsdivition", "gsDivitionID", "GSD");
            txtGSDivitionId.setText(orderId);
        } catch (SQLException ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void btReport_onAction(ActionEvent event) {

        try {
            InputStream file = getClass().getResourceAsStream("/lk/ijse/agreriancenter/report/Blank_A4.jrxml");
            JasperReport report = JasperCompileManager.compileReport(file);
            HashMap map = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(report, map, DBConnection.getInstance().getConnection());

            new MyJasperViewer(print).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GSDivitionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void gsAdresss(ActionEvent event) {
        if (Validetion.addressValidation(txtGSAdress.getText())) {
            txtGSTP.requestFocus();
        } else {
            txtGSAdress.requestFocus();
        }
        if (Validetion.addressValidation(txtGSAdress.getText())) {
            txtGSTP.requestFocus();
        } else {
            txtGSAdress.requestFocus();
        }
    }

    @FXML
    void gsNameAction(ActionEvent event) {
        if (Validetion.nameValidation(txtGSName.getText())) {
            txtGSAdress.requestFocus();
        } else {
            txtGSName.requestFocus();
        }
    }

    @FXML
    void gsTp(ActionEvent event) {
        if (Validetion.contactNoValidation(txtGSTP.getText())) {
            txtGSNIC.requestFocus();
        } else {
            txtGSTP.requestFocus();
        }
    }

    @FXML
    void gsNic(ActionEvent event) {
        if (Validetion.nicValidation(txtGSNIC.getText())) {
            combOfficerID.requestFocus();
        } else {
            txtGSNIC.requestFocus();
        }
    }

}
