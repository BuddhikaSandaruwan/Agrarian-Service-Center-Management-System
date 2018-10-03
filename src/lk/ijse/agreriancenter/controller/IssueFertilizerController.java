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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.FarmerBO;
import lk.ijse.agreriancenter.business.custom.FertilizerBO;
import lk.ijse.agreriancenter.business.custom.IssueFertilizerBO;
import lk.ijse.agreriancenter.business.custom.PaddyFieldBO;
import lk.ijse.agreriancenter.business.custom.TaxDetailsBO;
import lk.ijse.agreriancenter.business.custom.impl.FarmerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.FertilizerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.IssueFertilizerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.PaddyFieldBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.TaxDetailsBOImpl;
import lk.ijse.agreriancenter.dao.custom.FarmerDAO;
import lk.ijse.agreriancenter.model.FarmerDTO;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.IssueFertilizerDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDetailsDTO;
import lk.ijse.agreriancenter.model.TaxDetailsDTO;

/**
 *
 * @author Buddhika
 */
public class IssueFertilizerController implements Initializable {

    @FXML
    private JFXTextField txtNic;
    
    private JFXTextField txtFeildId;

    @FXML
    private JFXButton butAdd;


    @FXML
    private JFXTextField txtFarmerType;

    @FXML
    private JFXTextField txtFieldName;

    @FXML
    private JFXTextField txtFieldSize;

    @FXML
    private JFXTextField txtTaxType;
    
    @FXML
    private JFXTextField txtIssueQty;

    @FXML
    private JFXTextField txtLastTaxPayment;

    @FXML
    private DatePicker datePicker;
    
     @FXML
    private JFXTextField txtStockOnHand;
     
      @FXML
    private JFXTextField txtFielfId;

    @FXML
    private JFXComboBox<String> combFertilizerName;

    private  static PaddyFieldBO paddyFieldBO;
    private  static FarmerBO farmerBO;
    private  static TaxDetailsBO taxDetailsBO;
    private  static FertilizerBO fertilizerBO;

    public IssueFertilizerController() {
        paddyFieldBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.paddyfield);
        farmerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.farmer);
        taxDetailsBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.taxdetails);
        fertilizerBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.fertilizer);
    }
    
    
     @FXML
    private JFXTextField txtName;
     
     IssueFertilizerBO issueFertilizerBO=new IssueFertilizerBOImpl();

    @FXML
    void addClick(MouseEvent event) throws Exception {
        int id=0;
        String fieldId=txtFielfId.getText();
        String temp = txtFielfId.getText();
        PaddyFieldDTO paddyFieldDTO = paddyFieldBO.searchPaddyField(temp);
        String farmerId=paddyFieldDTO.getFarmerID();
        String fertilizerId=combFertilizerName.getValue();
        String date=datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        double stockOnHand=Double.parseDouble(txtStockOnHand.getText());
        double issueQty=Double.parseDouble(txtIssueQty.getText());
        
        IssueFertilizerDTO issueFertilizerDTO=new IssueFertilizerDTO(id, fieldId, farmerId, fertilizerId, date,stockOnHand,issueQty);
        if(issueQty<stockOnHand){
            boolean isAdd=issueFertilizerBO.addIssueFertilizer(issueFertilizerDTO);
        if(isAdd){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Not Added", ButtonType.OK);
            alert.show();
        }
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR, "No Fertilizer..!", ButtonType.OK);
            alert.show();
        }
        
    }

    @FXML
    void searchAction(ActionEvent event) {

    }
    
    private void loadIDS() throws Exception {
        ArrayList<String> id = fertilizerBO.getAllFertilizerIds();
        combFertilizerName.getItems().clear();
        for (String ab : id) {
            combFertilizerName.getItems().add(ab);
        }
    }

    @FXML
    void fieldSearch(ActionEvent event) throws Exception {
        String id = txtFielfId.getText();
        PaddyFieldDTO paddyFieldDTO = paddyFieldBO.searchPaddyField(id);

        txtFieldName.setText(paddyFieldDTO.getPaddyFieldName());
        txtFieldSize.setText(paddyFieldDTO.getPaddyFieldSize() + "");

        FarmerDTO farmerDTO = farmerBO.searchFarmer(paddyFieldDTO.getFarmerID());
        txtNic.setText(farmerDTO.getFarmerNIC());
        txtName.setText(farmerDTO.getFarmerName());
        txtFarmerType.setText(farmerDTO.getFarmerType());

        try {
            TaxDetailsDTO taxDetailsDTO = taxDetailsBO.searchTaxDetails(paddyFieldDTO.getPaddyFieldID());
            txtTaxType.setText(taxDetailsDTO.getTaxID());
            txtLastTaxPayment.setText(taxDetailsDTO.getDate());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Not Updated Tax", ButtonType.OK);
            alert.show();
        }
    }
    
     @FXML
    void fertilizerSelect(ActionEvent event) throws Exception {
        
        String ferId=combFertilizerName.getValue();
        
        FertilizerDTO fertilizerDTO=fertilizerBO.searchFertilizer(ferId);
        txtStockOnHand.setText(fertilizerDTO.getQtyOnHand()+"");
         String id = txtFielfId.getText();
        PaddyFieldDTO paddyFieldDTO = paddyFieldBO.searchPaddyField(id);
        txtIssueQty.setText(""+fertilizerDTO.getFertilizerRate()*paddyFieldDTO.getPaddyFieldSize());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
        try {
            loadIDS();
            
        } catch (Exception ex) {
            Logger.getLogger(IssueFertilizerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
