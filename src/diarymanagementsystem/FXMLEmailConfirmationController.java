/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLEmailConfirmationController implements Initializable {

    @FXML
    private TextField confirmCodeTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private Button backButton;

    @FXML
    private Label codeErrorLabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToMain(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    @FXML
    private void checkCode(ActionEvent event) throws IOException {
        //check the code 
        //..
        //..
        Connection conn;
        try {
            System.out.println(FXMLSignupController.usernamefn);
            conn = DriverManager.getConnection("jdbc:mysql://localhost/diary management system","root", "");
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT * FROM `user-email-confirmation` WHERE username='"+FXMLSignupController.usernamefn+"';";
            ResultSet rs = stmt.executeQuery(sqlstr);
            
            
        //..
        //if the code correct then:
        if(rs.next()){
        if(rs.getString("confirmationcode").equals(this.confirmCodeTextField.getText())){
            try{
            stmt = conn.createStatement();
            sqlstr="INSERT INTO `user` (`Name`, `username`, `Email`, `Gender`, `Birthdate`, `password`) VALUES ('"+rs.getString("Name")+"', '"+rs.getString("username")+"', '"+rs.getString("Email")+"', '"+rs.getString("Gender")+"', '"+rs.getString("Birthdate")+"', '"+rs.getString("password")+"');";
            stmt.executeUpdate(sqlstr);
            stmt = conn.createStatement();
            sqlstr="DELETE FROM `user-email-confirmation` WHERE username ='"+FXMLSignupController.usernamefn+"';";
            stmt.executeUpdate(sqlstr);
            }catch(Exception ex){}
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
        conn.close();}
        else{
        codeErrorLabel.setVisible(true);
        }
        }
        } catch (Exception ex) {
            
        }
    }
    
}
