/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.stage.StageStyle;

/**
 *
 * @author elias
 */
public class NotificationController implements Initializable{
    
    Stage stage = new Stage();
    @FXML
    Button btn_cancel = new Button();
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void start() throws Exception{
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Notification.fxml"));
        Parent root = loader.load();

        // Obtener el controlador del archivo FXML y pasarle el Stage actual
        NotificationController controller = loader.getController();
        controller.setStage(new Stage());

        Scene scene = new Scene(root);
        controller.stage.setScene(scene);

        controller.stage.setOnShown(event -> {
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            controller.stage.setX(screenBounds.getMaxX() - controller.stage.getWidth());
            controller.stage.setY(screenBounds.getMaxY() - controller.stage.getHeight());
        });

        controller.stage.initStyle(StageStyle.UNDECORATED);
        controller.stage.show();
    }

    // Método para inyectar el stage en el controlador
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void cancel_window(){
        stage.close();
    }

}
