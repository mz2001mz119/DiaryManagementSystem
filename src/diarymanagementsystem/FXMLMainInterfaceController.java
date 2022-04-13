/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HI-TECH
 */
public class FXMLMainInterfaceController implements Initializable {
    //to find if the menu is hedden or not 
    boolean isSliderMenuHidden=false;

    
    
    
    @FXML
    private AnchorPane sliderMenuPane;
    @FXML
    private ImageView sliderMenuHideIcon;
    @FXML
    private Button sliderMenuHideButton;
    @FXML
    private ImageView sliderMenuHomeIcon;
    @FXML
    private Button sliderMenuHomeButton;
    @FXML
    private ImageView sliderMenuProfileIcon;
    @FXML
    private Button sliderMenuProfileButton;
    @FXML
    private ImageView sliderMenuCalendarIcon;
    @FXML
    private Button sliderMenuCalendarButton;
    @FXML
    private ImageView sliderMenuGroupsIcon;
    @FXML
    private Button sliderMenuGroupsButton;
    @FXML
    private ImageView sliderMenuInvitationIcon;
    @FXML
    private Button sliderMenuInvitationButton;
    @FXML
    private ImageView sliderMenuSettingsIcon;
    @FXML
    private Button sliderMenuSettingsButton;
    @FXML
    private Button sliderMenuHideButton2;
    @FXML
    private Button sliderMenuHomeButton2;
    @FXML
    private Button sliderMenuProfileButton2;
    @FXML
    private Button sliderMenuCalendarButton2;
    @FXML
    private Button sliderMenuGroupsButton2;
    @FXML
    private Button sliderMenuInvitationButton2;
    @FXML
    private Button sliderMenuSettingsButton2;
    @FXML
    private AnchorPane SliderMenu;
    @FXML
    private ImageView userImage;
    @FXML
    private Label userFullName;
    @FXML
    private Label userName;
    @FXML
    private AnchorPane profilePane;
    @FXML
    private Button userInfoButton;
    @FXML
    private Button editUserProfile;
    @FXML
    private AnchorPane userInfoPane;
    @FXML
    private TextField profileEmail;
    @FXML
    private TextField profileBirthdate;
    @FXML
    private TextField profileGender;
    @FXML
    private AnchorPane userEditInfoPane;
    @FXML
    private TextField editName;
    @FXML
    private TextField editUserName;
    @FXML
    private DatePicker editBirthdate;
    @FXML
    private TextField editEmail;
    @FXML
    private ComboBox<?> editGender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //set the main button pressed for the main pane
        sliderMenuHomeButton.setStyle("-fx-background-color: #C30032; ");
        sliderMenuHomeButton2.setStyle("-fx-background-color: #C30032; -fx-text-fill:white;");
        sliderMenuHomeIcon.setVisible(true);
        roundImage(userImage);
        userInfoButton.setStyle("-fx-text-fill:#0A283E ;");
    }    

    @FXML
    private void sliderMenuAction(ActionEvent event) {
        //slide the menu
        if(event.getSource()==sliderMenuHideButton || event.getSource()==sliderMenuHideButton2){
            if(!isSliderMenuHidden){
                //move it up by 35px with 0.2s speed
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),SliderMenu);
                transition.setToX(200);
                transition.setByX(1000);
                transition.play();
                //show icons
                sliderMenuHideIcon.setVisible(true);
                
                isSliderMenuHidden=true;
            }
            else{
                //hide icons
                sliderMenuHideIcon.setVisible(false);
                //move it up by 35px with 0.2s speed
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2),SliderMenu);
                transition.setToX(0);
                transition.play();

                isSliderMenuHidden=false;
            }
        }
        // ****** change pressed button color and its icon color ******
        if(event.getSource()==sliderMenuHomeButton || event.getSource()==sliderMenuHomeButton2){
            sliderMenuHomeButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuHomeButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuProfileButton.setStyle("");
            sliderMenuCalendarButton.setStyle("");
            sliderMenuGroupsButton.setStyle("");
            sliderMenuInvitationButton.setStyle("");
            sliderMenuSettingsButton.setStyle("");
            sliderMenuProfileButton2.setStyle("");
            sliderMenuCalendarButton2.setStyle("");
            sliderMenuGroupsButton2.setStyle("");
            sliderMenuInvitationButton2.setStyle("");
            sliderMenuSettingsButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(true);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(false);
        }
        else if(event.getSource()==sliderMenuProfileButton||event.getSource() == sliderMenuProfileButton2){
            sliderMenuProfileButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuProfileButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuHomeButton.setStyle("");
            sliderMenuCalendarButton.setStyle("");
            sliderMenuGroupsButton.setStyle("");
            sliderMenuInvitationButton.setStyle("");
            sliderMenuSettingsButton.setStyle("");
            sliderMenuHomeButton2.setStyle("");
            sliderMenuCalendarButton2.setStyle("");
            sliderMenuGroupsButton2.setStyle("");
            sliderMenuInvitationButton2.setStyle("");
            sliderMenuSettingsButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(true);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(true);
        }
        else if(event.getSource()==sliderMenuCalendarButton||event.getSource()==sliderMenuCalendarButton2){
            sliderMenuCalendarButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuCalendarButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuHomeButton.setStyle("");
            sliderMenuProfileButton.setStyle("");
            sliderMenuGroupsButton.setStyle("");
            sliderMenuInvitationButton.setStyle("");
            sliderMenuSettingsButton.setStyle("");
            sliderMenuHomeButton2.setStyle("");
            sliderMenuProfileButton2.setStyle("");
            sliderMenuGroupsButton2.setStyle("");
            sliderMenuInvitationButton2.setStyle("");
            sliderMenuSettingsButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(true);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(false);
        }
        else if(event.getSource()==sliderMenuGroupsButton||event.getSource()==sliderMenuGroupsButton2){
            sliderMenuGroupsButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuGroupsButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuHomeButton.setStyle("");
            sliderMenuProfileButton.setStyle("");
            sliderMenuCalendarButton.setStyle("");
            sliderMenuInvitationButton.setStyle("");
            sliderMenuSettingsButton.setStyle("");
            sliderMenuHomeButton2.setStyle("");
            sliderMenuProfileButton2.setStyle("");
            sliderMenuCalendarButton2.setStyle("");
            sliderMenuInvitationButton2.setStyle("");
            sliderMenuSettingsButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(true);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(false);
        }
        else if(event.getSource()==sliderMenuInvitationButton||event.getSource()==sliderMenuInvitationButton2){
            sliderMenuInvitationButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuInvitationButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuHomeButton.setStyle("");
            sliderMenuProfileButton.setStyle("");
            sliderMenuCalendarButton.setStyle("");
            sliderMenuGroupsButton.setStyle("");
            sliderMenuSettingsButton.setStyle("");
            sliderMenuHomeButton2.setStyle("");
            sliderMenuProfileButton2.setStyle("");
            sliderMenuCalendarButton2.setStyle("");
            sliderMenuGroupsButton2.setStyle("");
            sliderMenuSettingsButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(true);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(false);
        }
        else if(event.getSource()==sliderMenuSettingsButton||event.getSource() == sliderMenuSettingsButton2){
            sliderMenuSettingsButton.setStyle("-fx-background-color: #C30032;");
            sliderMenuSettingsButton2.setStyle("-fx-background-color: #C30032;-fx-text-fill:white;");
            sliderMenuHomeButton.setStyle("");
            sliderMenuProfileButton.setStyle("");
            sliderMenuCalendarButton.setStyle("");
            sliderMenuGroupsButton.setStyle("");
            sliderMenuInvitationButton.setStyle("");
            sliderMenuHomeButton2.setStyle("");
            sliderMenuProfileButton2.setStyle("");
            sliderMenuCalendarButton2.setStyle("");
            sliderMenuGroupsButton2.setStyle("");
            sliderMenuInvitationButton2.setStyle("");
            
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(true);
            
            profilePane.setVisible(false);
        }

    }

    private void roundImage(ImageView img) {
         // set a clip to apply rounded border to the original image.
            Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
            );
            clip.setArcWidth(150);
            clip.setArcHeight(150);
            img.setClip(clip);

            // snapshot the rounded image.
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            WritableImage image = img.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            img.setClip(null);

            // apply a shadow effect.
            img.setEffect(new DropShadow(20, Color.BLACK));

            // store the rounded image in the imageView.
            img.setImage(image);
        
    }

    @FXML
    private void topBarAction(ActionEvent event) {
        if(event.getSource()==userInfoButton){
            userInfoButton.setStyle("-fx-text-fill:#0A283E ;");
            editUserProfile.setStyle("");
            userInfoPane.setVisible(true);
            userEditInfoPane.setVisible(false);
        }
        else if(event.getSource()==editUserProfile){
            editUserProfile.setStyle("-fx-text-fill:#0A283E ;");
            userInfoButton.setStyle("");
            userInfoPane.setVisible(false);
            userEditInfoPane.setVisible(true);
        }
    }


    
}
