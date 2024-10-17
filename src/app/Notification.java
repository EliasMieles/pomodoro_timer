/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import java.awt.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elias
 */
public class Notification extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        FXTrayIcon fxti = new FXTrayIcon(stage, getClass().getResource("pb.png"));
        
        fxti.show();
    }
    
}
