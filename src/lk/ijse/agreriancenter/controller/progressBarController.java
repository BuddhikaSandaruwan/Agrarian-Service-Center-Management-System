/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Buddhika
 */
public class progressBarController implements Initializable {

    @FXML
    private AnchorPane progressPnl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(9600), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                try {
                    Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/DashBord.fxml"));
                    Scene thisScene = new Scene(root);
                    Stage mainStage = (Stage) progressPnl.getScene().getWindow();
                    mainStage.setScene(thisScene);
                    mainStage.centerOnScreen();
                } catch (IOException ex) {
                    Logger.getLogger(progressBarController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        timeline.play();
    }

}
