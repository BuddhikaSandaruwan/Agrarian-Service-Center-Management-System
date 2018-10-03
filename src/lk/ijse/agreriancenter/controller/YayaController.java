/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import lk.ijse.agreriancenter.business.custom.YayaBO;
import lk.ijse.agreriancenter.business.custom.impl.YayaBOImpl;
import lk.ijse.agreriancenter.model.YayaDTO;
import lk.ijse.agreriancenter.util.IDgenerator;

/**
 *
 * @author Buddhika
 */
public class YayaController implements Initializable{
    @FXML
    private TableView<YayaDTO> tableYaya;

    @FXML
    private JFXButton butAdd;

    @FXML
    private JFXButton butDelete;

    @FXML
    private JFXButton butUpdate;
    
     @FXML
    private JFXTextField txtYayaName;

    @FXML
    private JFXTextField txtYayaId;
    
    YayaBO bO;

    public YayaController() {
        bO=BOFactory.getInstance().getBO(BOFactory.BOTypes.yaya);
    }
    

    @FXML
    void addClick(MouseEvent event) throws Exception {
        String YayaId = txtYayaId.getText();
        String YayaName = txtYayaName.getText();
        
        YayaDTO dTO = new YayaDTO(YayaId,YayaName);
        boolean isAdd = bO.addYaya(dTO);
        if (isAdd) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtYayaId.clear();
            txtYayaName.clear();
        }
    }

    @FXML
    void deleteClick(MouseEvent event) throws Exception {
         boolean deleted=bO.deleteYaya(txtYayaId.getText());
        if(deleted){
            butAdd.setDisable(false);
            Alert error=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            error.show();
            getAll();
            txtYayaId.clear();
            txtYayaName.clear();
        }else{
            Alert error=new Alert(Alert.AlertType.ERROR, "Not Deleted", ButtonType.OK);
            error.show();
            
           
        }
    }

    @FXML
    void tableClick(MouseEvent event) {
        butAdd.setDisable(true);
        YayaDTO yayaDTO=tableYaya.getSelectionModel().getSelectedItem();
        txtYayaId.setText(yayaDTO.getYayaID());
        txtYayaName.setText(yayaDTO.getYayaName());
    }

    @FXML
    void updateClick(MouseEvent event) throws Exception {
        YayaDTO dTO=new YayaDTO(txtYayaId.getText(),txtYayaName.getText());
        boolean isUpdated=bO.updateYaya(dTO);
        if (isUpdated) {
            butAdd.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtYayaId.clear();
            txtYayaName.clear();
        }
    }

    private void getAll() {

        try {
            tableYaya.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("yayaID"));
            tableYaya.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("yayaName"));
            
            lordFertilizer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lordFertilizer() throws Exception {
        tableYaya.setItems(FXCollections.observableArrayList(bO.getAllYaya()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            txtYayaId.setText(IDgenerator.getNewID("yaya", "yayaID", "YAYA"));
            getAll();
        } catch (Exception ex) {
            Logger.getLogger(YayaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
