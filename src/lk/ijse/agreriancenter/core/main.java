/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.agreriancenter.core;

import java.awt.Rectangle;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Buddhika
 */


public class main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(this.getClass().getResource("/lk/ijse/agreriancenter/view/LogIn.fxml"));
        Scene temp=new Scene(root);
        
        primaryStage.setScene(temp);
        primaryStage.setTitle("LogIn");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        primaryStage.setResizable(true);
       
        
//     FadeTransition ft = new FadeTransition(Duration.millis(5000), root);
//     ft.setFromValue(1.0);
//     ft.setToValue(0.3);
//     ft.setCycleCount(4);
//     ft.setAutoReverse(true);
// 
//     ft.play();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
