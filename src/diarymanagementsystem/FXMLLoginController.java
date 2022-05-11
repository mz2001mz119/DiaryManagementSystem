/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
//----
//-------
public class FXMLLoginController implements Initializable {

    @FXML
    private Label loginEmailLabel;

    @FXML
    private TextField loginEmailTextField;

    @FXML
    private Label loginPasswordLabel;

    @FXML
    private PasswordField loginPasswordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button forgotPasswordButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label EmailErrorLabel;

    @FXML
    private Label PasswordErrorLabel;

    @FXML
    private Button facebookButton;

    @FXML
    private Button instagramButton;

    @FXML
    private Button twitterButton;

    @FXML
    private Button siteButton;

    /**
     * Initializes the controller class.
     * 
     */
    
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
    
       public static boolean checkifexsist(String username) throws SQLException{
        boolean flag=false;
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/diarymanagementsystem","root", "");
         Statement stmt = conn.createStatement();
         String sqlstr="select * from `user` where username ="+"'"+username+"';";
         ResultSet rs1 = stmt.executeQuery(sqlstr);
         if(rs1.next())flag=true;
         conn.close();
        return flag;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //control the "Email" & "Password" labels transitions ubove the Email&Password Text Fields
        
        loginEmailTextField.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    loginEmailLabel.setTextFill(Color.rgb(234, 6, 64));
                    //move it up by 35px with 0.2s speed
                    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),loginEmailLabel);
                    transition.setToY(-35);
                    transition.setToX(-10);
                    transition.play();
                }
                else
                {
                    if(loginEmailTextField.getText().equals("")){
                        loginEmailLabel.setTextFill(Color.rgb(218, 0, 55));
                        //move it up by 35px with 0.3s speed
                        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),loginEmailLabel);
                        transition.setToY(0);
                        transition.setToX(10);
                        transition.play();
                    }
                }
            }
        });
        loginPasswordTextField.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    loginPasswordLabel.setTextFill(Color.rgb(234, 6, 64));
                    //move it up by 35px with 0.2s speed
                    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),loginPasswordLabel);
                    transition.setToY(-35);
                    transition.setToX(-10);
                    transition.play();
                }
                else
                {
                    if(loginPasswordTextField.getText().equals("")){
                        loginPasswordLabel.setTextFill(Color.rgb(218, 0, 55));
                        //move it up by 35px with 0.3s speed
                        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),loginPasswordLabel);
                        transition.setToY(0);
                        transition.setToX(0);
                        transition.play();
                    }
                }
            }
            
            
            
            
        });
    }    

    @FXML
    private void openSignupPane(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLSignup.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
    //function to control FOLLOW US buttons links
    @FXML
    private void openBrowser(ActionEvent event) throws MalformedURLException, URISyntaxException, IOException {
        if(event.getSource()==facebookButton){
            Desktop.getDesktop().browse(new URL("https://www.facebook.com").toURI());
        }
        else if(event.getSource()==instagramButton){
            Desktop.getDesktop().browse(new URL("https://www.instagram.com").toURI());
        }
        else if(event.getSource()==twitterButton){
            Desktop.getDesktop().browse(new URL("https://www.twitter.com").toURI());
        }
        else if(event.getSource()==siteButton){
            Desktop.getDesktop().browse(new URL("https://www.google.com").toURI());
        }
    }

    @FXML
    private void openForgotPasswordPane(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLForgotPassword.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    @FXML
    private void logIntoMainInterface(ActionEvent event) throws IOException {
        
        PasswordErrorLabel.setVisible(false);
        EmailErrorLabel.setVisible(false);

        
               if(loginEmailTextField.getText().length()>50|loginPasswordTextField.getText().length()>20){
           
           
           if(loginEmailTextField.getText().length()>50){
           EmailErrorLabel.setVisible(true);

               
           }
           else if(loginPasswordTextField.getText().length()>20){
           
           PasswordErrorLabel.setVisible(true);
           loginPasswordTextField.setText("");
           
           }
       }
       else{

    try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/diarymanagementsystem","root", "");
        Statement stmt = conn.createStatement();
        
        //check if the Email is correct  
        String qry="select * from `user` where Email=? or username=?";
        PreparedStatement pst=conn.prepareStatement(qry);
        pst.setString(1, loginEmailTextField.getText());
        pst.setString(2, loginEmailTextField.getText());
        ResultSet rs=pst.executeQuery();
        
        //check if the password is correct 
        if(rs.next()){  
        String qry6="select * from `user` where (Email=? or username=?) and password=?;";
        PreparedStatement pst1=conn.prepareStatement(qry6);
        pst1.setString(1, loginEmailTextField.getText());
        pst1.setString(2, loginEmailTextField.getText());
        pst1.setString(3, loginPasswordTextField.getText());
        ResultSet rs1=pst1.executeQuery();
        
        
        // the Email and password are correct (open the Main Page)
        if(rs1.next()){  
            FXMLMainInterfaceController.loginUserName=rs1.getString("username");
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLMainInterface.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();}
        
        // Error password
        else {
             String qry1="select * from `user-email-confirmation` where Email=? or username=?";
        pst=conn.prepareStatement(qry1);
        pst.setString(1, loginEmailTextField.getText());
        pst.setString(2, loginEmailTextField.getText());
        ResultSet rs4=pst.executeQuery();
        
            
        if(rs4.next()){
        String qry8="select * from `user-email-confirmation` where (Email=? or username=?) and password=?";
        pst=conn.prepareStatement(qry8);
        pst.setString(1, loginEmailTextField.getText());
        pst.setString(2, loginEmailTextField.getText());
        pst.setString(3, loginPasswordTextField.getText());
        ResultSet rs2=pst.executeQuery();
        
        
        
        if(rs2.next()){       
        // the Email and password are correct (open the Email confirmation page and send new code)
        Parent Parent2 = FXMLLoader.load(getClass().getResource("FXMLEmailConfirmation.fxml"));
        Scene Scene2 = new Scene(Parent2);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene2);
        Stage.show();}
        else{
            PasswordErrorLabel.setVisible(true);
            
        }}

        
        
         //check if username is correct    
        else{


        PasswordErrorLabel.setVisible(true);} 

            
            
        }}
             
            
        //check if the username is correct                  
           
                
// check username/Email and password in user-email-confirmation table 
             
        else{     
        String qry1="select * from `user-email-confirmation` where Email=? or username=?";
        pst=conn.prepareStatement(qry1);
        pst.setString(1, loginEmailTextField.getText());
        pst.setString(2, loginEmailTextField.getText());
        ResultSet rs4=pst.executeQuery();
        
            
        if(rs4.next()){
        String qry8="select * from `user-email-confirmation` where (Email=? or username=?) and password=?";
        pst=conn.prepareStatement(qry8);
        pst.setString(1, loginEmailTextField.getText());
        pst.setString(2, loginEmailTextField.getText());
        pst.setString(3, loginPasswordTextField.getText());
        ResultSet rs2=pst.executeQuery();
        
        
        
        if(rs2.next()){       
        // the Email and password are correct (open the Email confirmation page and send new code)
        Parent Parent2 = FXMLLoader.load(getClass().getResource("FXMLEmailConfirmation.fxml"));
        Scene Scene2 = new Scene(Parent2);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene2);
        Stage.show();}
        else{
            PasswordErrorLabel.setVisible(true);
        }}

        
        
         //check if username is correct    
        else{

        PasswordErrorLabel.setVisible(true);
        EmailErrorLabel.setVisible(true);} }
        conn.close();}
        
    catch(Exception e1){
        e1.printStackTrace();}}
    }
    
}
