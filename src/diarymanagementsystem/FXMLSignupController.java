/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import static diarymanagementsystem.FXMLForgotPasswordController.getAlphaNumericString;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLSignupController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField userName;

    @FXML
    private TextField password;

    @FXML
    private DatePicker birthdate;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private Button signup;

    @FXML
    private Button backButton;

    @FXML
    private Label EmailErrorLabel;

    @FXML
    private Label userNameErrorLabel;
    @FXML
    private Label passerrorErrorLabel;

    /**
     * Initializes the controller class.
     */
    public static String usernamefn;
    ObservableList<String>  list =FXCollections.observableArrayList("Male","Female");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gender.setItems(list);
        addTextLimiter(this.name,50);
        addTextLimiter(this.userName,50);
        addTextLimiter(this.email,30);
        addTextLimiter(this.name,50);
        addTextLimiter(this.password,20);
        password.setTooltip(FXMLEmailSentSuccessfullyController.passwordtooltip);
    }

    @FXML
    private void backToLoginPane(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    @FXML
    private void goToConfirmEmail(ActionEvent event) throws IOException {
            //check all of the fields if entered correctly and show red label for the errors
            //..
        try {
        String eemail=this.email.getText();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        boolean valemail=pat.matcher(eemail).matches();
        if(!valemail){
            EmailErrorLabel.setText("*Error: Please Enter A Correct Email");
            EmailErrorLabel.setVisible(true);
        }
        if(valemail)EmailErrorLabel.setVisible(false);
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/diarymanagementsystem","root", "");
              Statement stmt = conn.createStatement();
              String sqlstr="select * from `user` where Email ="+"'"+this.email.getText()+"';";
              ResultSet rs1 = stmt.executeQuery(sqlstr);
              stmt = conn.createStatement();
              String sqlr="select * from `user-email-confirmation` where Email ="+"'"+this.email.getText()+"';";
              ResultSet rs3 = stmt.executeQuery(sqlr);
              int spas=0;
              if(rs1.next()||rs3.next())spas=1;
              //                     continue check
              if(spas==1){
              EmailErrorLabel.setText("this email already used");
              EmailErrorLabel.setVisible(true);
              }
              //
              stmt = conn.createStatement();
              sqlstr="select * from `user-email-confirmation` where username ="+"'"+this.userName.getText()+"';";
              ResultSet rs = stmt.executeQuery(sqlstr);
              stmt = conn.createStatement();
              sqlstr="select * from `user` where username ="+"'"+this.userName.getText()+"';";
              ResultSet rs2 = stmt.executeQuery(sqlstr);
               int fff=0;
         char []a=this.userName.getText().toCharArray();
         int flag=0;
         for(int i=0;i<a.length;i++){
         if(Character.isLetterOrDigit(a[i])){}
         else if(a[i]=='-'){}
         else if(a[i]=='_'){}
         else if(a[i]=='.'){}
         else flag=1;
         }
        if(rs.next()||rs2.next()){
            userNameErrorLabel.setText("this user name already used please enter another username");
            userNameErrorLabel.setVisible(true);}
        else if(flag==1){
            userNameErrorLabel.setText("*Error: Please Enter A Correct User Name (Letters,Digits, . , - , _ ) Only");
            userNameErrorLabel.setVisible(true);
        }
        else {
            userNameErrorLabel.setVisible(false);
            fff=1;
        }
            //..
            //..
            //if all fields are valid then send confirmation cod to the email go to confirmation interface:
        boolean valpassw=FXMLEmailSentSuccessfullyController.isValidPassword(password.getText());
        if(!valpassw)passerrorErrorLabel.setVisible(true);
        else if(valpassw)passerrorErrorLabel.setVisible(false);
            if((valemail) && (fff==1) && (spas==0) && valpassw &&(name.getText()!="")&&(birthdate.getValue()!=null)&&(gender.getValue()!=null)){
             try {
              Statement stm = conn.createStatement();
              Random rand = new Random();
              String confcode=FXMLForgotPasswordController.getAlphaNumericString(8);
              String sqlst="INSERT INTO `user-email-confirmation` (`username`, `Name`, `Email`, `Gender`, `Birthdate`, `password`, `confirmationcode`) VALUES ('"+this.userName.getText()+"', '"+this.name.getText()+"', '"+this.email.getText()+"', '"+this.gender.getValue()+"', '"+this.birthdate.getValue()+"', '"+this.password.getText()+"', '"+confcode+"');";
              usernamefn=this.userName.getText();
              stm.executeUpdate(sqlst);
              send_email.sendemail(this.email.getText(), confcode);
              conn.close();
             }
             catch(Exception ex){ex.printStackTrace();}
            Parent Parent = FXMLLoader.load(getClass().getResource("FXMLEmailConfirmation.fxml"));
            Scene Scene = new Scene(Parent);
            Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
            }
      } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    
}
