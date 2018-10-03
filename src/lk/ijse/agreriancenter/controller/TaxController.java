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
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.TaxBO;
import lk.ijse.agreriancenter.business.custom.impl.TaxBOImpl;
import lk.ijse.agreriancenter.model.TaxDTO;
import lk.ijse.agreriancenter.util.IDgenerator;

/**
 *
 * @author Buddhika
 */
public class TaxController implements Initializable{
     @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtRAte;

    @FXML
    private JFXButton butAdd;

    @FXML
    private TableView<TaxDTO> tableTax;

    @FXML
    private JFXButton butDelete;

    @FXML
    private JFXButton butUpdate;
    
    TaxBO taxBO;

    public TaxController() {
        taxBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.tax);
    }
    
    
    @FXML
    void addClick(MouseEvent event) throws Exception {
        String taxID = txtID.getText();
        String taxName = txtName.getText();
        double taxRate = Double.parseDouble(txtRAte.getText());
        

        TaxDTO taxDTO = new TaxDTO(taxID,taxName,taxRate);
        boolean isAdd = taxBO.addTax(taxDTO);
        if (isAdd) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtID.clear();
            txtName.clear();
            txtRAte.clear();
            getAll();
        }
    }

    @FXML
    void deleteClick(MouseEvent event) throws Exception {
         boolean deleted=taxBO.daleteTax(txtID.getText());
        if(deleted){
            butAdd.setDisable(false);
            Alert error=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            error.show();
            getAll();
            txtID.clear();
            txtName.clear();
            txtRAte.clear();
        }else{
            Alert error=new Alert(Alert.AlertType.ERROR, "Not Deleted", ButtonType.OK);
            error.show();
           
        }
    }

    @FXML
    void tableClicked(MouseEvent event) {
        butAdd.setDisable(true);
        TaxDTO taxDTO=tableTax.getSelectionModel().getSelectedItem();
        txtID.setText(taxDTO.getTaxID());
        txtName.setText(taxDTO.getTaxName());
        txtRAte.setText(Double.toString(taxDTO.getTaxRate()));
        
    }

    @FXML
    void updateClick(MouseEvent event) throws Exception {
        TaxDTO taxDTO=new TaxDTO(txtID.getText(),txtName.getText(),Double.parseDouble(txtRAte.getText()));
        boolean isUpdated=taxBO.updateTax(taxDTO);
        if (isUpdated) {
            butAdd.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtID.clear();
            txtName.clear();
            txtRAte.clear();
        }
    }
    private void getAll() {
        try {
            taxBO = new TaxBOImpl();
            tableTax.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("taxID"));
            tableTax.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("taxName"));
            tableTax.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("taxRate"));

            ArrayList<TaxDTO> taxDTOs = taxBO.getAllTax();
            tableTax.setItems(FXCollections.observableArrayList(taxDTOs));
        } catch (Exception ex) {
            Logger.getLogger(FertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lordFertilizer() throws Exception {
        tableTax.setItems(FXCollections.observableArrayList(taxBO.getAllTax()));
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {
             txtID.setText(IDgenerator.getNewID("tax", "taxID", "TAX"));
             getAll();
         } catch (Exception ex) {
             Logger.getLogger(TaxController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
