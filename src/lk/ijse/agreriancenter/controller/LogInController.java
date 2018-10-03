/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.valideter.PasswordUtil;

/**
 *
 * @author Buddhika
 */
public class LogInController implements Initializable{

    @FXML
    private AnchorPane logInpane;

    @FXML
    private JFXButton butLogIn;
    
     @FXML
    private JFXButton butChange;

    @FXML
    private JFXTextField txtLogIn;

    @FXML
    private JFXPasswordField TxtPassword;
    @FXML
    private JFXButton butCancel;

   

  
    
    @FXML
    void mouseClick(Event event) throws IOException, InterruptedException, Exception {
       //
    }
    
    
    @FXML
    private void actionClick(ActionEvent event) throws IOException, Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from user");
        if(rst.next()){
            String userName=rst.getString(2);
            String salt=rst.getString(3);
            String secPw=rst.getString(4);
            
            boolean ifPasswordMatches=PasswordUtil.verifyUserPassword(TxtPassword.getText(), secPw, salt);
            if (ifPasswordMatches && txtLogIn.getText().equals(userName)) {

  
                Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/ProgressBar.fxml"));
                Scene scene = new Scene(rootPane);
                Stage stage = (Stage) this.logInpane.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                // stage.setFullScreen(true);
                TranslateTransition tran = new TranslateTransition(Duration.millis(1000), scene.getRoot());
                tran.setToX(0);
                tran.setFromX(scene.getWidth());
                tran.play();
            } else {
                JOptionPane.showMessageDialog(null, "Error in username password combination!");
            }
        }  
    }

    @FXML
    private void changeClick(javafx.scene.input.MouseEvent event) throws IOException {
         Parent rootPane = FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/ChangePassword.fxml"));
            Scene scene = new Scene(rootPane);
            Stage stage = (Stage) this.logInpane.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
    }

    @FXML
    private void cancelclick(javafx.scene.input.MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void userNameAction(ActionEvent event) {
        TxtPassword.requestFocus();
    }

    @FXML
    private void passwordAction(ActionEvent event) {
        butLogIn.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       butChange.setVisible(false);
    }
}
