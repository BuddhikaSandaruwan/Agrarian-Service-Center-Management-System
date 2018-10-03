/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.controller;

import java.net.URL;
import java.security.spec.InvalidKeySpecException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.agreriancenter.dao.CrudUtil;
import lk.ijse.agreriancenter.valideter.PasswordUtil;

/**
 * FXML Controller class
 *
 * @author Buddhika
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private Button butAdd;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void butAdd(MouseEvent event) throws Exception {
        try {
            String userName=txtUserName.getText();
            String password=txtPassword.getText();
            String salt=PasswordUtil.getSalt(30);
            String secPw=PasswordUtil.generateSecurePassword(password, salt);
            CrudUtil.executeUpdate("Insert into user values(?,?,?,?)", "001",userName,salt,secPw);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
