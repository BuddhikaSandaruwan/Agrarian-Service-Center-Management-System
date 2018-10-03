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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.OfficerBO;
import lk.ijse.agreriancenter.business.custom.impl.OfficerBOImpl;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.OfficerDTO;
import lk.ijse.agreriancenter.util.IDgenerator;
import lk.ijse.agreriancenter.valideter.Validetion;

/**
 *
 * @author Buddhika
 */
public class OfficerController implements Initializable{
     @FXML
    private JFXTextField txtOfficerName;

    @FXML
    private JFXTextField txtOfficerAdress;

    @FXML
    private JFXTextField txtOfficerNic;

    @FXML
    private JFXTextField txtOfficerTp;

    @FXML
    private JFXButton butAdd;

    @FXML
    private JFXTextField txtOfficerId;
    
     @FXML
    private TableView<OfficerDTO> tableOfficer;
     
    @FXML
    private JFXButton butDelete;
    
    @FXML
    private JFXButton butUpdate;

    OfficerBO officerBO;

    public OfficerController() {
        officerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.officer);
    }
    
    
    
    private void getAll() {

        try {
            tableOfficer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("officerID"));
            tableOfficer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("officerName"));
            tableOfficer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("officerAdress"));
            tableOfficer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("officerNic"));
            tableOfficer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("officerTP"));
            lordFertilizer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lordFertilizer() throws Exception {
        tableOfficer.setItems(FXCollections.observableArrayList(officerBO.getAllOfficer()));
    }
    
    @FXML
    void addMouseclick(MouseEvent event) throws Exception {
        String officerId = txtOfficerId.getText();
        String officerName = txtOfficerName.getText();
        String officerAdress = txtOfficerAdress.getText();
        String offocerNic = txtOfficerNic.getText();
        int officerTp = Integer.parseInt(txtOfficerTp.getText());
        

        OfficerDTO officerDTO = new OfficerDTO(officerId, officerName, officerAdress, offocerNic,officerTp);
        boolean isAdd = officerBO.addOfficer(officerDTO);
        if (isAdd) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtOfficerId.clear();
            txtOfficerName.clear();
            txtOfficerAdress.clear();
            txtOfficerNic.clear();
            txtOfficerTp.clear();
        }
    }
    
     @FXML
    void updateClick(MouseEvent event) throws Exception {
        OfficerDTO officerDTO=new OfficerDTO(txtOfficerId.getText(),txtOfficerName.getText(),txtOfficerAdress.getText(),txtOfficerNic.getText(),Integer.parseInt(txtOfficerTp.getText()));
        boolean isUpdated=officerBO.updateOfficer(officerDTO);
        if (isUpdated) {
            butAdd.setDisable(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            getAll();
            txtOfficerId.clear();
            txtOfficerName.clear();
            txtOfficerAdress.clear();
            txtOfficerNic.clear();
            txtOfficerTp.clear();
        }
    }
     @FXML
    void tableclicked(MouseEvent event) {
        
        butAdd.setDisable(true);
        OfficerDTO officerDTO=tableOfficer.getSelectionModel().getSelectedItem();
        txtOfficerId.setText(officerDTO.getOfficerID());
        txtOfficerName.setText(officerDTO.getOfficerName());
        txtOfficerAdress.setText(officerDTO.getOfficerAdress());
        txtOfficerNic.setText(officerDTO.getOfficerNic());
        txtOfficerTp.setText(Integer.toString(officerDTO.getOfficerTP()));
    }
     @FXML
    void actionSearch(ActionEvent event) {
         try {
             String id=txtOfficerId.getText();
             OfficerDTO officerDTO=officerBO.searchOfficer(id);
             txtOfficerName.setText(officerDTO.getOfficerName());
             txtOfficerAdress.setText(officerDTO.getOfficerAdress());
             txtOfficerNic.setText(officerDTO.getOfficerNic());
             txtOfficerTp.setText(""+officerDTO.getOfficerTP());
             
         } catch (Exception ex) {
             Logger.getLogger(OfficerController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     @FXML
    void deleteClick(MouseEvent event) throws Exception {
        boolean deleted=officerBO.deleteOfficer(txtOfficerId.getText());
        if(deleted){
            butAdd.setDisable(false);
            Alert error=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            error.show();
            getAll();
            txtOfficerId.clear();
            txtOfficerName.clear();
            txtOfficerAdress.clear();
            txtOfficerNic.clear();
            txtOfficerTp.clear();
        }else{
            Alert error=new Alert(Alert.AlertType.ERROR, "Not Deleted", ButtonType.OK);
            error.show();
           
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {
             txtOfficerId.setText(IDgenerator.getNewID("officer", "officerID", "OFI"));
             getAll();
         } catch (Exception ex) {
             Logger.getLogger(OfficerController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     @FXML
    void nameAction(ActionEvent event) {
         if(Validetion.nameValidation(txtOfficerAdress.getText())){
            txtOfficerAdress.requestFocus();
            }else{
                txtOfficerNic.requestFocus();
            }
    }

    @FXML
    void nicAction(ActionEvent event) {
         if(Validetion.nicValidation(txtOfficerNic.getText())){
            txtOfficerTp.requestFocus();
            }else{
                txtOfficerNic.requestFocus();
            }
    }

    @FXML
    void officerNameAction(ActionEvent event) {
         if(Validetion.nameValidation(txtOfficerName.getText())){
            txtOfficerAdress.requestFocus();
            }else{
                txtOfficerName.requestFocus();
            }
    }
      @FXML
    void tpAction(ActionEvent event) {
         if(Validetion.contactNoValidation(txtOfficerTp.getText())){
            butAdd.requestFocus();
            }else{
                txtOfficerTp.requestFocus();
            }
    }
}
