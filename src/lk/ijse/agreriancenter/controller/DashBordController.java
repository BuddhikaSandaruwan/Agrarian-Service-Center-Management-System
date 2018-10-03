/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Buddhika
 */
public class DashBordController implements Initializable {

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton butPaddyField;

    @FXML
    private JFXButton butGSDivition;

    @FXML
    private JFXButton butOfficer;

    @FXML
    private JFXButton butYaya;

    @FXML
    private JFXButton butTax;

    @FXML
    private JFXButton butFertilizer;

    @FXML
    private JFXButton butUpdateStock;

    @FXML
    private JFXButton butIssueFertilizer;

    @FXML
    private JFXButton butUpdateTax;

    @FXML
    private AnchorPane lordPnl;

    @FXML
    private JFXButton butLogOut;

    @FXML
    private JFXButton butReport;

    @FXML
    void mouseClickedFertilizer(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Fertilizer.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }
    
     @FXML
    void reportClick(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Report.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedGSDivition(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/GSDivition.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedIssueFertilizer(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/IssueFertilizer.fxml"));
        Scene scene = new Scene(rootPane);
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedOfficer(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Officer.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedPaddyField(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Farm.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedTax(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Tax.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedUpdateStock(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/UpdateStock.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedUpdateTax(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/UpdateTax.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedyaya(MouseEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/Yaya.fxml"));
        lordPnl.getChildren().clear();
        lordPnl.getChildren().add(rootPane);
    }

    @FXML
    void mouseClickedLogOut(MouseEvent event) throws IOException {
        //LogInController.askQuestion("Are You Sure..?");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure..?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> btSet = a.showAndWait();
        if (btSet.get() == ButtonType.YES) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/LogIn.fxml"));
            Scene thisScene = new Scene(root);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(thisScene);
            mainStage.centerOnScreen();
        } else if (btSet.get() == ButtonType.NO) {

        } else {

        }
    }

    @FXML
    void mouseEnterdPaddyField(MouseEvent event) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butPaddyField);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

    }

    @FXML
    void mouseEnterdFertilizer(MouseEvent event) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butFertilizer);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdGsDivition(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butGSDivition);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

    }

    @FXML
    void mouseEnterdIssueFertilizer(MouseEvent event) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butIssueFertilizer);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdLogOut(MouseEvent event) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butLogOut);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdOfficer(MouseEvent event) {

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butOfficer);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdReports(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butReport);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdTax(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butTax);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdUpdateTax(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butUpdateTax);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdYaya(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butYaya);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @FXML
    void mouseEnterdUpdateStock(MouseEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), butUpdateStock);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void setDateTime() {
        Timeline newTimeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }

        }), new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDateTime();
    }

}
