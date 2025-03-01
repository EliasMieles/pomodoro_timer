/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * FXML Controller class
 *
 * @author elias
 */
public class PruebaController implements Initializable{

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField duration_field = new TextField();
    @FXML
    Label time_label = new Label();
    int seconds;
    int minutes;
    Timer timer;
    NotificationController notification;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        seconds = 0;
        minutes = 0;
        notification = new NotificationController();
        
        
        timer = new Timer(100, (e) -> {
            
            Platform.runLater(() -> {
                time_label.setText(minutes + ":" + seconds);
            });

            seconds += 1;

            if (seconds == 60) {
                seconds = 0;
                minutes += 1;
            }
            
            if(Integer.parseInt(duration_field.getText()) == minutes){
                timer.stop();
                
                Platform.runLater(() -> {
                    try {
                        notification.start();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                });
                
            }    
        });        
    }

    public boolean validate_num(String input) {
        return input.matches("^\\d+$");
    }

    public void start_timer() {

        if (!validate_num(duration_field.getText())) {
            JOptionPane.showMessageDialog(null, "Antes de iniciar debe ingresar el tiempo deseado");
        } else {
            duration_field.setDisable(true);
            timer.start();
        }

    }

    public void reset_timer() {

        timer.stop();
        seconds = 0;
        minutes = 0;
        time_label.setText(minutes + ":" + seconds);
        duration_field.setDisable(false);
        duration_field.setText("");
    }

}
