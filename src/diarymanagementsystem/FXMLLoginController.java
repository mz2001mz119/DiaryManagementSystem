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

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField loginEmailTextField;
    @FXML
    private Label loginEmailLabel;
    @FXML
    private PasswordField loginPasswordTextField;
    @FXML
    private Label loginPasswordLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button forgotPasswordButton;
    @FXML
    private Button signupButton;
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
     */
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
        //check if the enterd email & password correct in the user table
        //..
        //..
        //..
        //if correct
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLMainInterface.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
        //else
        //check if the email & passowrd in the account confirmation table 
        //..
        //..
        //..
        //if yes then open the Emailconfirmation page and send new code
        //..
        //..
        //..
    }
    
}
