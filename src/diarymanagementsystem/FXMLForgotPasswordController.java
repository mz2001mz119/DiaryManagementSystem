/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
sdfijelodkfb,okg
 */
package diarymanagementsystem;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
//
//
/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLForgotPasswordController implements Initializable {

    static public String Random;
    
    
 
     @FXML
    private Label forgotEmailLabel;

    @FXML
    private TextField forgotEmailTextField;

    @FXML
    private Button signupButton;

    @FXML
    private Button sendButton;

    @FXML
    private Button backButton;

    @FXML
    private Label EmailErrorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //control the "Email" labels transitions ubove the Email&Password Text Fields
        forgotEmailTextField.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    forgotEmailLabel.setTextFill(Color.rgb(234, 6, 64));
                    //move it up by 35px with 0.2s speed
                    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),forgotEmailLabel);
                    transition.setToY(-35);
                    transition.setToX(-10);
                    transition.play();
                }
                else
                {
                    if(forgotEmailTextField.getText().equals("")){
                        forgotEmailLabel.setTextFill(Color.rgb(218, 0, 55));
                        //move it up by 35px with 0.3s speed
                        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),forgotEmailLabel);
                        transition.setToY(0);
                        transition.setToX(10);
                        transition.play();
                    }
                }
            }
        });
    }    

    @FXML
    private void contactUs(ActionEvent event) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                URI mailto = new URI("mailto:john@example.com?subject=Forgot%20My%20Email");
                desktop.mail(mailto);
            }
        }
    }

    @FXML
    private void sendForgotEmail(ActionEvent event)  {
        
        //chack the Email First in database or not
       
        
       
       //Send an Email with new code and add the new random code on a forgotPassword table with validation date
try{     addTextLimiter(forgotEmailTextField, 50);
         String reseption=forgotEmailTextField.getText();
         Random=getAlphaNumericString(8);
         send_email.sendemail(reseption,Random);
         
        //the open the Email sent successfully
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLEmailSentSuccessfully.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();}
catch(Exception e){
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Invalid email");
alert.setHeaderText("Invalid email ");
alert.setContentText("please enter valid email");
alert.showAndWait();}
        
    }

    @FXML
    private void goToMain(ActionEvent event) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
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
     static String getAlphaNumericString(int n)
    {
  
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);
  
        String randomString
            = new String(array, Charset.forName("UTF-8"));
  
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
  
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {
  
            char ch = randomString.charAt(k);
  
            if (((ch >= 'a' && ch <= 'z')  || (ch >= 'A' && ch <= 'Z')
                 || (ch >= '0' && ch <= '9'))
                && (n > 0)) {
  
                r.append(ch);
                n--;
            }
        }
  
        // return the resultant string
        return r.toString();
    }
    
}
