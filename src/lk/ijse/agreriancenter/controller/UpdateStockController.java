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
import javafx.collections.FXCollections;
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
import lk.ijse.agreriancenter.business.custom.FertilizerBO;
import lk.ijse.agreriancenter.business.custom.StockBO;
import lk.ijse.agreriancenter.business.custom.StockDetailsBO;
import lk.ijse.agreriancenter.business.custom.impl.FertilizerBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.StockBOImpl;
import lk.ijse.agreriancenter.business.custom.impl.StockDetailsBOImpl;
import lk.ijse.agreriancenter.model.FertilizerDTO;
import lk.ijse.agreriancenter.model.StockDTO;
import lk.ijse.agreriancenter.model.StockDetailsDTO;
import lk.ijse.agreriancenter.model.UpdateStockDTO;
import lk.ijse.agreriancenter.util.IDgenerator;

/**
 *
 * @author Buddhika
 */
public class UpdateStockController implements Initializable {

    @FXML
    private JFXTextField txtStockOnHand;

    @FXML
    private JFXTextField txtNewQty;

    @FXML
    private JFXComboBox<String> combFertilizerId;

    @FXML
    private JFXButton butAdd;

    @FXML
    private DatePicker datePicker;

    @FXML
    private JFXTextField txtStockId;

    @FXML
    private JFXButton butDelete;

    @FXML
    private JFXButton butPrint;

    @FXML
    private JFXButton butUpdate;
    
    @FXML
    private TableView<StockDetailsDTO> table;
    
    StockDetailsBO stockDetailsBO;

    public UpdateStockController() {
        stockDetailsBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.stockdetails);
        stockBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.stock);
    }
    

    @FXML
    void deleteClick(MouseEvent event) throws Exception {
        boolean isDelete = stockBO.deleteStock(txtStockId.getText());
        if (isDelete) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Deleted !", ButtonType.OK);
            a.show();
            getAll();
            cleaTxt();
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "not Deleted !", ButtonType.OK);
            a.show();
        }
    }

    @FXML
    void updateClick(MouseEvent event) throws Exception {
        String stockId = txtStockId.getText();
        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        StockDTO stockDTO = new StockDTO(stockId, date);

        String fertilizerId = (String) combFertilizerId.getValue();
        double qty = Double.parseDouble(txtNewQty.getText());
        StockDetailsDTO stockDetailsDTO = new StockDetailsDTO(fertilizerId, stockId, qty);

        UpdateStockDTO updateStockDTO = new UpdateStockDTO(stockDTO, stockDetailsDTO);
        
        boolean isAdd = stockBO.updateStock(updateStockDTO);
        if (isAdd) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Updated !", ButtonType.OK);
            a.show();
            getAll();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Not Updated !", ButtonType.OK);
            a.show();
        }
        
    }

    StockBO stockBO = new StockBOImpl();

    FertilizerBO fertilizerBO = new FertilizerBOImpl();
    
    private void getAll() {

        try {
            table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fertilizerID"));
            table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("stockID"));
            table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
            
            lordStock();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     private void lordStock() throws Exception {
        table.setItems(FXCollections.observableArrayList(stockDetailsBO.getAllStockDetails()));
    }

    @FXML
    void addClicked(MouseEvent event) throws Exception {
        String stockId = txtStockId.getText();
        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        StockDTO stockDTO = new StockDTO(stockId, date);

        String fertilizerId = (String) combFertilizerId.getValue();
        double qty = Double.parseDouble(txtNewQty.getText());
        StockDetailsDTO stockDetailsDTO = new StockDetailsDTO(fertilizerId, stockId, qty);

        UpdateStockDTO updateStockDTO = new UpdateStockDTO(stockDTO, stockDetailsDTO);

        boolean isAdd = stockBO.addStock(updateStockDTO);
        if (isAdd) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Added !", ButtonType.OK);
            a.show();
            getAll();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Not Added !", ButtonType.OK);
            a.show();
        }
        
    }

    public void lordFertilizer() throws Exception {
        ArrayList<FertilizerDTO> tax = fertilizerBO.getAllFertilizer();
        ArrayList<String> fertilizer = new ArrayList<>();
        combFertilizerId.getItems().clear();
        for (FertilizerDTO d : tax) {
            fertilizer.add(d.getFertilizerID());
        }
        for (String string : fertilizer) {
            combFertilizerId.getItems().add(string);
        }

    }

    @FXML
    void printClick(MouseEvent event) throws Exception {
       
    }
    
    public void cleaTxt(){
        txtStockId.clear();
        txtNewQty.clear();
        txtStockOnHand.clear();
        combFertilizerId.setValue(null);
    }
    
    @FXML
    void tableSelected(MouseEvent event) {
        StockDetailsDTO stockDetailsDTO=table.getSelectionModel().getSelectedItem();
        txtStockId.setText(stockDetailsDTO.getStockID());
        combFertilizerId.setValue(stockDetailsDTO.getFertilizerID());
        txtNewQty.setText(Double.toString(stockDetailsDTO.getQty()));
    }

    @FXML
    void searchFromID(ActionEvent event) {
        try {
            FertilizerDTO fertilizerDTO = fertilizerBO.searchFertilizer(combFertilizerId.getSelectionModel().getSelectedItem());

            if (fertilizerDTO != null) {
                txtStockOnHand.setText(fertilizerDTO.getQtyOnHand() + "");
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        butDelete.setVisible(false);
        butUpdate.setVisible(false);
        datePicker.setValue(LocalDate.now());
        try {
            lordFertilizer();
             txtStockId.setText(IDgenerator.getNewID("stock", "stockID", "STK"));
            getAll();
        } catch (Exception ex) {
            Logger.getLogger(UpdateStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
