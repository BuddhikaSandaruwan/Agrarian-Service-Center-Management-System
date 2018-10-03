/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicColorChooserUI;
import jdk.nashorn.internal.runtime.Property;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.FertilizerBO;
import lk.ijse.agreriancenter.business.custom.impl.FertilizerBOImpl;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;
import lk.ijse.agreriancenter.util.IDgenerator;

/**
 *
 * @author Buddhika
 */
public class FertilizerController implements Initializable {
    
    @FXML
    private JFXTextField txtFertilizerId;
    
    @FXML
    private JFXTextField txtFertilizerName;
    
    @FXML
    private JFXTextField txtQtyOnHand;
    
    @FXML
    private JFXTextField txtFertilizerRate;
    
    @FXML
    private JFXButton butAdd;
    
    @FXML
    private JFXButton butDelete;
    
    @FXML
    private TableView<FertilizerDTO> tableFertilizer;
    
    private FertilizerBO bOImpl;
    
    @FXML
    private JFXButton butUpdate;

    public FertilizerController() {
        bOImpl=BOFactory.getInstance().getBO(BOFactory.BOTypes.fertilizer);
    }
    
    
    
    @FXML
    void updateClick(MouseEvent event) throws Exception {
        
        FertilizerDTO fertilizerDTO = new FertilizerDTO(txtFertilizerId.getText(), txtFertilizerName.getText(), Double.parseDouble(txtQtyOnHand.getText()), Double.parseDouble(txtFertilizerRate.getText()));
        boolean isUpdated = bOImpl.updateFertilizer(fertilizerDTO);
        if (isUpdated) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated", ButtonType.OK);
            alert.show();
            try {
                butAdd.setDisable(false);
                bOImpl = new FertilizerBOImpl();
                tableFertilizer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
                tableFertilizer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fertilizerName"));
                tableFertilizer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
                tableFertilizer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fertilizerRate"));
                
                ArrayList<FertilizerDTO> aa = bOImpl.getAllFertilizer();
                tableFertilizer.setItems(FXCollections.observableArrayList(aa));
            } catch (Exception ex) {
                Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtFertilizerId.clear();
            txtFertilizerName.clear();
            txtQtyOnHand.clear();
            txtFertilizerRate.clear();
        }
    }
    
    @FXML
    void tableclick(MouseEvent event) {
        butAdd.setDisable(true);
        FertilizerDTO fertilizerDTO = tableFertilizer.getSelectionModel().getSelectedItem();
        txtFertilizerId.setText(fertilizerDTO.getFertilizerID());
        txtFertilizerName.setText(fertilizerDTO.getFertilizerName());
        txtQtyOnHand.setText(Double.toString(fertilizerDTO.getQtyOnHand()));
        txtFertilizerRate.setText(Double.toString(fertilizerDTO.getFertilizerRate()));
        
        try {
            bOImpl = new FertilizerBOImpl();
            tableFertilizer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
            tableFertilizer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fertilizerName"));
            tableFertilizer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            tableFertilizer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fertilizerRate"));
            
            ArrayList<FertilizerDTO> aa = bOImpl.getAllFertilizer();
            tableFertilizer.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    void deleteFertilizerOnMouseClicked(MouseEvent event) throws Exception {
        System.out.println("Delete Fertilizer");
        boolean deleted = bOImpl.deleteFertilizer(txtFertilizerId.getText());
        if (deleted) {
            butAdd.setDisable(false);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            a.show();
            txtFertilizerId.clear();
            txtFertilizerName.clear();
            txtQtyOnHand.clear();
            txtFertilizerRate.clear();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Not Deleted", ButtonType.OK);
            error.show();            
        }
        try {
            bOImpl = new FertilizerBOImpl();
            tableFertilizer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
            tableFertilizer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fertilizerName"));
            tableFertilizer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            tableFertilizer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fertilizerRate"));
            
            ArrayList<FertilizerDTO> aa = bOImpl.getAllFertilizer();
            tableFertilizer.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtFertilizerId.clear();
        txtFertilizerName.clear();
        txtQtyOnHand.clear();
        txtFertilizerRate.clear();
    }
    
    @FXML
    void addFertilizerOnMouseClicked(MouseEvent event) throws Exception {
        System.out.println("Add Fertilizer");
        String fertilizerId = txtFertilizerId.getText();
        String fertilizerName = txtFertilizerName.getText();
        double qtyOnHand = Double.parseDouble(txtQtyOnHand.getText());
        double fertilizerRate = Double.parseDouble(txtFertilizerRate.getText());
        
        FertilizerDTO fertilizerDTO = new FertilizerDTO(fertilizerId, fertilizerName, qtyOnHand, fertilizerRate);
        boolean isAdd = bOImpl.addFertilizer(fertilizerDTO);
        if (isAdd) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            txtFertilizerId.clear();
            txtFertilizerName.clear();
            txtQtyOnHand.clear();
            txtFertilizerRate.clear();
        }
        try {
            bOImpl = new FertilizerBOImpl();
            tableFertilizer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
            tableFertilizer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fertilizerName"));
            tableFertilizer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            tableFertilizer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fertilizerRate"));
            
            ArrayList<FertilizerDTO> aa = bOImpl.getAllFertilizer();
            tableFertilizer.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtFertilizerId.clear();
        txtFertilizerName.clear();
        txtQtyOnHand.clear();
        txtFertilizerRate.clear();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        try {
            txtFertilizerId.setText(IDgenerator.getNewID("fertilizer", "fertilizerID", "FER"));
            bOImpl = new FertilizerBOImpl();
            tableFertilizer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
            tableFertilizer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fertilizerName"));
            tableFertilizer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
            tableFertilizer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fertilizerRate"));
            
            ArrayList<FertilizerDTO> aa = bOImpl.getAllFertilizer();
            tableFertilizer.setItems(FXCollections.observableArrayList(aa));
        } catch (Exception ex) {
            Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
