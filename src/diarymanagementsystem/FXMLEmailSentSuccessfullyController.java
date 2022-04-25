/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import static diarymanagementsystem.FXMLForgotPasswordController.addTextLimiter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import java.sql.ResultSet;
 

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLEmailSentSuccessfullyController  implements Initializable {

        public static boolean isValidPassword(String password)
    {     String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }
            public static void addTextLimiter(final TextField tf, final int maxLength) {
    tf.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        }
    });
    
}
  
       
    @FXML
    private Button backButton;

    @FXML
    private TextField confirmationCodeTextField;

    @FXML
    private TextField confirmationPasswordTextField;

    @FXML
    private Label codeErrorLabel;

    @FXML
    private Button confirmButton;

   static final Tooltip passwordtooltip = new Tooltip("It contains at least 8 characters and at most 20 characters" +"\n" +
"It contains at least one digit" +"\n" +
"It contains at least one upper case alphabet" +"\n" +
"It contains at least one lower case alphabet" +"\n" +
"It contains at least one special character !@#$%&"+"\n" +
"It doesn’t contain any white space");
    /**
     * Initializes the controller class.
     * 
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     addTextLimiter(confirmationCodeTextField, 50);
     addTextLimiter(confirmationPasswordTextField, 50);
       confirmationPasswordTextField.setTooltip(passwordtooltip);
    }    

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
        
    }
    @FXML
    private void checkCode(ActionEvent event) throws IOException {
        //check the code 
        String code =confirmationCodeTextField.getText();
        String newPassword =confirmationPasswordTextField.getText();
        
  
      if(code.equals(FXMLForgotPasswordController.Random)){
           //if the code correct then cheak password:
           codeErrorLabel.setVisible(false);
        if(isValidPassword(newPassword)){
        //set new pasword to data base if it valid 
        //*************
        try{
        try{
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/diarymanagementsystem","root", "");
            Statement stmt = conn.createStatement(); 
            String sqlstr="UPDATE `user` SET `password`='"+newPassword+"' WHERE `user`.`Email`='"+FXMLForgotPasswordController.reseption+"';";
            stmt.executeUpdate(sqlstr);
            conn.commit();
            conn.close();
        }
        catch(Exception e){}
                   Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
     
        }
        catch(Exception e){}
        
   }
        
         else{
            //invalid passwrd
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Invalid password");
      alert.setHeaderText("Invalid password ");
      alert.setContentText(
"  It contains at least 8 characters and at most 20 characters.\n" +
"  It contains at least one digit.\n" +
"  It contains at least one upper case alphabet.\n" +
"  It contains at least one lower case alphabet.\n" +
"  It contains at least one special character !@#$%&.\n" +
"  It doesn’t contain any white space");
      alert.showAndWait();}
   
    }
      
      else{
          // invalid code 
    codeErrorLabel.setVisible(true);}
    
    }
    
    
}
    