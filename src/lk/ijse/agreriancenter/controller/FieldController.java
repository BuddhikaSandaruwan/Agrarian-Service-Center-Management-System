/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.business.BOFactory;
import lk.ijse.agreriancenter.business.custom.FarmerBO;
import lk.ijse.agreriancenter.business.custom.OwnerBo;
import lk.ijse.agreriancenter.business.custom.PaddyFieldBO;
import lk.ijse.agreriancenter.business.custom.impl.FarmerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.OwnerBOimpl;
import lk.ijse.agreriancenter.business.custom.impl.PaddyFieldBOImpl;
import lk.ijse.agreriancenter.model.FarmerDTO;
import lk.ijse.agreriancenter.model.OwnerDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDTO;
import lk.ijse.agreriancenter.model.PaddyFieldDetailsDTO;
import lk.ijse.agreriancenter.util.IDgenerator;

/**
 *
 * @author Buddhika
 */
public class FieldController implements Initializable {

    @FXML
    private JFXButton butAdd;

    @FXML
    private JFXTextField txtFieldId;

    @FXML
    private JFXTextField txtFieldName;

    @FXML
    private JFXTextField txtFieldSize;

    @FXML
    private JFXComboBox<String> combGsDivition;

    @FXML
    private JFXComboBox<String> combTax;

    @FXML
    private JFXComboBox<String> combYaya;

    @FXML
    private JFXTextField txtEast;

    @FXML
    private JFXTextField txtWest;

    @FXML
    private JFXTextField txtNorth;

    @FXML
    private JFXTextField txtSouth;

    @FXML
    private JFXTextField txtOwnerId;

    @FXML
    private JFXTextField txtOwnerName;

    @FXML
    private JFXTextField txtOwnerNic;

    @FXML
    private JFXTextField txtOwnerTp;

    @FXML
    private JFXTextField txtLandNumber;

    @FXML
    private JFXTextField txtFatmerId;

    @FXML
    private JFXTextField txtFarmerNic;

    @FXML
    private JFXTextField txtFarmerAdress;

    @FXML
    private JFXTextField txtFarmerTp;

    @FXML
    private JFXButton butDelete;

    @FXML
    private JFXButton butUpdate;

    @FXML
    private JFXTextField txtOwnerAdress;

    @FXML
    private JFXTextField txtFarmerName;

    @FXML
    private JFXTextField txtFieldAdress;

    @FXML
    private JFXTextField txtFarmerType;

    @FXML
    private JFXButton butSearch;

    PaddyFieldBO paddyFieldBO;
    OwnerBo ownerBo;
    FarmerBO farmerBo;

    public FieldController() {
        paddyFieldBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.paddyfield);
        ownerBo=BOFactory.getInstance().getBO(BOFactory.BOTypes.owner);
        farmerBo=BOFactory.getInstance().getBO(BOFactory.BOTypes.farmer);
    }
    
    @FXML
    private JFXRadioButton radioFarmer;
    @FXML
    private ToggleGroup group;
    @FXML
    private JFXRadioButton radioOwner;

    @FXML
    void butAddMouseClicked(MouseEvent event) throws Exception {
        String fieldId = txtFieldId.getText();
        String fieldName = txtFieldName.getText();
        String fieldAdress = txtFieldAdress.getText();
        double fieldSize = Double.parseDouble(txtFieldSize.getText());
        String gsDivition = combGsDivition.getValue().toString();
        String tax = combTax.getValue().toString();
        String yaya = combYaya.getValue().toString();
        String north = txtNorth.getText();
        String east = txtEast.getText();
        String south = txtSouth.getText();
        String west = txtWest.getText();
        String ownerId = txtOwnerId.getText();
        String ownerName = txtOwnerName.getText();
        String ownerNic = txtOwnerNic.getText();
        String ownerAdress = txtOwnerAdress.getText();
        int ownerTp = Integer.parseInt(txtOwnerTp.getText());
        String landNumber = txtLandNumber.getText();
        String farmerId = txtFatmerId.getText();
        String farmerName = txtFarmerName.getText();
        String farmerNic = txtFarmerNic.getText();
        String farmerAdress = txtFarmerAdress.getText();
        int farmerTp = Integer.parseInt(txtFarmerTp.getText());
        String farmerType = txtFarmerType.getText();

        PaddyFieldDTO paddyFieldDTO = new PaddyFieldDTO(fieldId, fieldName, fieldAdress, fieldSize, north, south, west, east, gsDivition, tax, yaya, ownerId, farmerId);
        OwnerDTO ownerDTO = new OwnerDTO(ownerId, ownerName, ownerAdress, ownerNic, ownerTp, landNumber);
        FarmerDTO farmerDTO = new FarmerDTO(farmerId, farmerName, farmerAdress, farmerNic, farmerTp, farmerType);

        PaddyFieldDetailsDTO paddyFieldDetailsDTO = new PaddyFieldDetailsDTO(paddyFieldDTO, ownerDTO, farmerDTO);
        boolean isAdd = paddyFieldBO.addPaddyField(paddyFieldDetailsDTO);
        if (isAdd) {
            clearText();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
            // getAll();

        }
    }

    @FXML
    void butDeleteeMouseClick(MouseEvent event) {
        String ownerId = txtOwnerId.getText();
        String farmerId = txtFatmerId.getText();

        try {
            boolean isAdd = ownerBo.deleteOwner(ownerId);
            boolean isDelete = farmerBo.deleteFarmer(farmerId);

            if (isAdd && isDelete) {
                clearText();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "ERROR", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(FieldController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void searchClick(MouseEvent event) throws Exception {
        String fieldId = txtFieldId.getText();
        String fieldName = txtFieldName.getText();
        String fieldAdress = txtFieldAdress.getText();
        double fieldSize = Double.parseDouble(txtFieldSize.getText());
        String gsDivition = combGsDivition.getValue().toString();
        String tax = combTax.getValue().toString();
        String yaya = combYaya.getValue().toString();
        String north = txtNorth.getText();
        String east = txtEast.getText();
        String south = txtSouth.getText();
        String west = txtWest.getText();
        String ownerId = txtOwnerId.getText();
        String ownerName = txtOwnerName.getText();
        String ownerNic = txtOwnerNic.getText();
        String ownerAdress = txtOwnerAdress.getText();
        int ownerTp = Integer.parseInt(txtOwnerTp.getText());
        String landNumber = txtLandNumber.getText();
        String farmerId = txtFatmerId.getText();
        String farmerName = txtFarmerName.getText();
        String farmerNic = txtFarmerNic.getText();
        String farmerAdress = txtFarmerAdress.getText();
        int farmerTp = Integer.parseInt(txtFarmerTp.getText());
        String farmerType = txtFarmerType.getText();

        PaddyFieldDTO paddyFieldDTO = new PaddyFieldDTO(fieldId, fieldName, fieldAdress, fieldSize, north, south, west, east, gsDivition, tax, yaya, ownerId, farmerId);
        OwnerDTO ownerDTO = new OwnerDTO(ownerId, ownerName, ownerAdress, ownerNic, ownerTp, landNumber);
        FarmerDTO farmerDTO = new FarmerDTO(farmerId, farmerName, farmerAdress, farmerNic, farmerTp, farmerType);

        PaddyFieldDetailsDTO paddyFieldDetailsDTO = new PaddyFieldDetailsDTO(paddyFieldDTO, ownerDTO, farmerDTO);
        boolean isAdd = paddyFieldBO.updatePaddyField(paddyFieldDetailsDTO);
        if (isAdd) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void butUpdateMouseClick(MouseEvent event) throws Exception {  //Search=======================================
        String id = txtFieldId.getText();
        PaddyFieldDTO paddy = paddyFieldBO.searchPaddyField(id);
        if (paddy != null) {
            txtFieldName.setText(paddy.getPaddyFieldName());
            txtFieldSize.setText("" + paddy.getPaddyFieldSize());
            combGsDivition.setValue(paddy.getGsDivitionID());
            combTax.setValue(paddy.getTaxID());
            combYaya.setValue(paddy.getYayaID());
            txtFieldAdress.setText(paddy.getPaddyFieldAdress());
            txtNorth.setText(paddy.getNorthID());
            txtSouth.setText(paddy.getSouthID());
            txtEast.setText(paddy.getEastID());
            txtWest.setText(paddy.getWestID());
            txtOwnerId.setText(paddy.getOwnerID());
            txtFatmerId.setText(paddy.getFarmerID());

        }
        OwnerDTO owner = ownerBo.searchOwner(paddy.getOwnerID());
        if (owner != null) {
            txtOwnerName.setText(owner.getOwnerName());
            txtOwnerNic.setText(owner.getOwnerNIC());
            txtOwnerAdress.setText(owner.getOwnerAdress());
            txtOwnerTp.setText(owner.getOwnerTP() + "");
            txtLandNumber.setText(owner.getLandNumber());
        }
        FarmerDTO farmer = farmerBo.searchFarmer(paddy.getFarmerID());
        if (farmer != null) {
            butDelete.setDisable(false);
            butSearch.setDisable(false);
            txtFarmerName.setText(farmer.getFarmerName());
            txtFarmerNic.setText(farmer.getFarmerNIC());
            txtFarmerAdress.setText(farmer.getFarmerAdress());
            txtFarmerTp.setText(farmer.getFarmerTP() + "");
            txtFarmerType.setText(farmer.getFarmerType());
        }
    }

    void clearText() {
        txtFieldId.clear();
        txtFieldName.clear();
        txtFieldSize.clear();

        txtFieldAdress.clear();
        txtNorth.clear();
        txtSouth.clear();
        txtEast.clear();
        txtWest.clear();
        txtOwnerId.clear();
        txtOwnerName.clear();
        txtOwnerNic.clear();
        txtOwnerAdress.clear();
        txtOwnerTp.clear();
        txtLandNumber.clear();
        txtFatmerId.clear();
        txtFarmerName.clear();
        txtFarmerNic.clear();
        txtFarmerAdress.clear();
        txtFarmerTp.clear();
        txtFarmerType.clear();

    }

    @FXML
    void FieldIdKeyRelease(KeyEvent event) {
        //String id= txtFieldId.getText();

    }

    @FXML
    void ActionEvent(ActionEvent event) throws Exception {

    }

    public void lordGsDivition() throws Exception {
        ArrayList<String> divition = paddyFieldBO.getGsDivition();
        combGsDivition.getItems().clear();
        for (String ab : divition) {
            combGsDivition.getItems().add(ab);
        }
    }

    public void lordTax() throws Exception {
        ArrayList<String> tax = paddyFieldBO.getTax();
        combTax.getItems().clear();
        for (String ab : tax) {
            System.out.println(ab);
            combTax.getItems().add(ab);
        }
    }

    public void lordYaya() throws Exception {
        ArrayList<String> yaya = paddyFieldBO.getYaya();
        combYaya.getItems().clear();
        for (String ab : yaya) {
            combYaya.getItems().add(ab);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioFarmer.setUserData("Farmer");
        radioOwner.setUserData("Owner");
        butDelete.setDisable(true);
        butSearch.setDisable(true);
        try {
            lordGsDivition();
            lordTax();
            lordYaya();
            txtFatmerId.setText(IDgenerator.getNewID("farmer", "farmerID", "FAR"));
            txtFieldId.setText(IDgenerator.getNewID("paddyfield", "paddyFieldID", "PAD"));
            txtOwnerId.setText(IDgenerator.getNewID("owner", "ownerID", "OWN"));
        } catch (Exception excp) {
        }
    }

    @FXML
    private void onClickFarmer(ActionEvent event) {
        txtFarmerName.clear();
        txtFarmerNic.clear();
        txtFarmerAdress.clear();
        txtFarmerTp.clear();
        txtFarmerType.clear();
    }

    @FXML
    private void onclickOwner(ActionEvent event) {
        if (group.getSelectedToggle() != null) {
            txtFarmerName.setText(txtOwnerName.getText());
            txtFarmerNic.setText(txtOwnerNic.getText());
            txtFarmerAdress.setText(txtOwnerAdress.getText());
            txtFarmerTp.setText(txtOwnerTp.getText());
            txtFarmerType.setText("Owner");

        }
    }

}
