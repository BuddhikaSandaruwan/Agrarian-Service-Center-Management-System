/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.PaddyFieldBO;
import lk.ijse.agreriancenter.business.custom.TaxBO;
import lk.ijse.agreriancenter.business.custom.TaxDetailsBO;
import lk.ijse.agreriancenter.business.custom.impl.PaddyFieldBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.TaxBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.TaxDetailsBOImpl;
import lk.ijse.agreriancenter.model.PaddyFieldDTO;
import lk.ijse.agreriancenter.model.TaxDTO;
import lk.ijse.agreriancenter.model.TaxDetailsDTO;

/**
 *
 * @author Buddhika
 */
public class UpdateTaxController implements Initializable {
    ObservableList<TaxDetailsDTO> list=FXCollections.observableArrayList();
    
    @FXML
    private JFXTextField txtFieldSize;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXButton butAdd;

    @FXML
    private JFXComboBox<String> combFieldId;

    @FXML
    private JFXComboBox<String> cobbTaxId;

    @FXML
    private JFXTextField txtRistNo;

    @FXML
    private TableView<TaxDetailsDTO> table;

    @FXML
    private DatePicker datePicaer;

    @FXML
    private JFXTextField txtFieldName;

    @FXML
    private JFXTextField txtTaxName;

    PaddyFieldBO paddyFieldBO;
    TaxBO taxBO;
    TaxDetailsBO taxDetailsBO;

    public UpdateTaxController() {
        paddyFieldBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.paddyfield);
        taxBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.tax);
        taxDetailsBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.taxdetails);
    }
    

    @FXML
    void addMouseClick(MouseEvent event) throws Exception {
        String fieldId = combFieldId.getValue();
        String txtId = cobbTaxId.getValue();
        String date = Date.valueOf(datePicaer.getValue()).toString();
        String amount = txtAmount.getText();

        TaxDetailsDTO taxDetailsDTO = new TaxDetailsDTO(fieldId, txtId, date, Double.parseDouble(amount));
        boolean isAdd = taxDetailsBO.addTaxDetails(taxDetailsDTO);
        if (isAdd) {
            getAll();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void searchFromPaddyField(ActionEvent event) throws Exception {
        try {
            PaddyFieldDTO paddyFieldDTO = paddyFieldBO.searchPaddyField(combFieldId.getSelectionModel().getSelectedItem());

            if (paddyFieldDTO != null) {
                txtFieldName.setText(paddyFieldDTO.getPaddyFieldName() + "");
                txtFieldSize.setText(paddyFieldDTO.getPaddyFieldSize() + "");
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchFromTax(ActionEvent event) throws Exception {
        try {
            TaxDTO taxDTO = taxBO.searchTax(cobbTaxId.getSelectionModel().getSelectedItem());
            PaddyFieldDTO paddyFieldDTO = paddyFieldBO.searchPaddyField(combFieldId.getSelectionModel().getSelectedItem());

            if (taxDTO != null) {
                txtTaxName.setText(taxDTO.getTaxName() + "");
                txtAmount.setText(taxDTO.getTaxRate() * paddyFieldDTO.getPaddyFieldSize() + "");
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateStockController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void lordTax() throws Exception {
        ArrayList<String> yaya = taxBO.getAllTaxIds();
        cobbTaxId.getItems().clear();
        for (String ab : yaya) {
            cobbTaxId.getItems().add(ab);
        }
    }

    public void lordField() throws Exception {
        ArrayList<String> yaya = paddyFieldBO.getFieldId();
        combFieldId.getItems().clear();
        for (String ab : yaya) {
            combFieldId.getItems().add(ab);
        }
    }
     private void getAll() {

        try {
            table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("paddyFieldID"));
            table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("taxID"));
            table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
            table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("amount"));
            
            lordFertilizer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lordFertilizer() throws Exception {
        table.setItems(FXCollections.observableArrayList(taxDetailsBO.getAllTaxDetails()));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicaer.setValue(LocalDate.now());
        try {
            lordTax();
            lordField();
            getAll();
           
        } catch (Exception ex) {
            Logger.getLogger(UpdateTaxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
