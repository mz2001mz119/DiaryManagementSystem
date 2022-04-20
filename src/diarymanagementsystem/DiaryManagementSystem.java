
package diarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DiaryManagementSystem extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        //stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setMinWidth(1510);
        stage.setMinHeight(730);
        stage.setTitle("Diary Management System");
        stage.setScene(scene);
        stage.show();
       //hello
    }
    
    
}
