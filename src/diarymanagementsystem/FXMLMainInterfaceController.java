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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
import javafx.scene.layout.VBox;
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
    int dayDate;
    
    
    
    @FXML
    private AnchorPane profilePane;

    @FXML
    private ImageView userImage;

    @FXML
    private Label userFullName;

    @FXML
    private Label userName;

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

    @FXML
    private Button editMyProfileSaveButton;

    @FXML
    private AnchorPane calendarPane;

    @FXML
    private Button calendarDaysButton;

    @FXML
    private Button calendarMonthButton;

    @FXML
    private Button calendarYearButton;

    @FXML
    private AnchorPane calendarDaysPane;

    @FXML
    private AnchorPane diaryDay1;

    @FXML
    private Label day1;

    @FXML
    private AnchorPane diaryDay2;

    @FXML
    private Label day2;

    @FXML
    private AnchorPane diaryDay3;

    @FXML
    private Label day3;

    @FXML
    private AnchorPane diaryDay4;

    @FXML
    private Label day4;

    @FXML
    private AnchorPane diaryDay5;

    @FXML
    private Label day5;

    @FXML
    private AnchorPane diaryDay6;

    @FXML
    private Label day6;

    @FXML
    private AnchorPane diaryDay7;

    @FXML
    private Label day7;

    @FXML
    private AnchorPane diaryDay8;

    @FXML
    private Label day8;

    @FXML
    private AnchorPane diaryDay9;

    @FXML
    private Label day9;

    @FXML
    private AnchorPane diaryDay10;

    @FXML
    private Label day10;

    @FXML
    private AnchorPane diaryDay11;

    @FXML
    private Label day11;

    @FXML
    private AnchorPane diaryDay12;

    @FXML
    private Label day12;

    @FXML
    private AnchorPane diaryDay13;

    @FXML
    private Label day13;

    @FXML
    private AnchorPane diaryDay14;

    @FXML
    private Label day14;

    @FXML
    private AnchorPane diaryDay15;

    @FXML
    private Label day15;

    @FXML
    private AnchorPane diaryDay16;

    @FXML
    private Label day16;

    @FXML
    private AnchorPane diaryDay17;

    @FXML
    private Label day17;

    @FXML
    private AnchorPane diaryDay18;

    @FXML
    private Label day18;

    @FXML
    private AnchorPane diaryDay19;

    @FXML
    private Label day19;

    @FXML
    private AnchorPane diaryDay20;

    @FXML
    private Label day20;

    @FXML
    private AnchorPane diaryDay21;

    @FXML
    private Label day21;

    @FXML
    private AnchorPane diaryDay22;

    @FXML
    private Label day22;

    @FXML
    private AnchorPane diaryDay23;

    @FXML
    private Label day23;

    @FXML
    private AnchorPane diaryDay24;

    @FXML
    private Label day24;

    @FXML
    private AnchorPane diaryDay25;

    @FXML
    private Label day25;

    @FXML
    private AnchorPane diaryDay26;

    @FXML
    private Label day26;

    @FXML
    private AnchorPane diaryDay27;

    @FXML
    private Label day27;

    @FXML
    private AnchorPane diaryDay28;

    @FXML
    private Label day28;

    @FXML
    private AnchorPane diaryDay29;

    @FXML
    private Label day29;

    @FXML
    private AnchorPane diaryDay30;

    @FXML
    private Label day30;

    @FXML
    private AnchorPane diaryDay31;

    @FXML
    private Label day31;

    @FXML
    private Label calendarDate;

    @FXML
    private AnchorPane calendarMonthPane;

    @FXML
    private AnchorPane diary;

    @FXML
    private AnchorPane diaryDay41;

    @FXML
    private Label day41;

    @FXML
    private AnchorPane diaryDay51;

    @FXML
    private Label day51;

    @FXML
    private AnchorPane diaryDay61;

    @FXML
    private Label day61;

    @FXML
    private AnchorPane diaryDay71;

    @FXML
    private Label day71;

    @FXML
    private AnchorPane diaryDay81;

    @FXML
    private Label day81;

    @FXML
    private AnchorPane diaryDay91;

    @FXML
    private Label day91;

    @FXML
    private AnchorPane diaryDay101;

    @FXML
    private Label day101;

    @FXML
    private AnchorPane diaryDay111;

    @FXML
    private Label day111;

    @FXML
    private AnchorPane diaryDay121;

    @FXML
    private Label day121;

    @FXML
    private AnchorPane diaryDay131;

    @FXML
    private Label day131;

    @FXML
    private AnchorPane diaryDay141;

    @FXML
    private Label day141;

    @FXML
    private AnchorPane diaryDay151;

    @FXML
    private Label day151;

    @FXML
    private AnchorPane diaryDay161;

    @FXML
    private Label day161;

    @FXML
    private AnchorPane diaryDay171;

    @FXML
    private Label day171;

    @FXML
    private AnchorPane diaryDay181;

    @FXML
    private Label day181;

    @FXML
    private AnchorPane diaryDay191;

    @FXML
    private Label day191;

    @FXML
    private AnchorPane diaryDay201;

    @FXML
    private Label day201;

    @FXML
    private AnchorPane diaryDay211;

    @FXML
    private Label day211;

    @FXML
    private AnchorPane diaryDay221;

    @FXML
    private Label day221;

    @FXML
    private AnchorPane diaryDay231;

    @FXML
    private Label day231;

    @FXML
    private AnchorPane diaryDay241;

    @FXML
    private Label day241;

    @FXML
    private AnchorPane diaryDay251;

    @FXML
    private Label day251;

    @FXML
    private AnchorPane diaryDay261;

    @FXML
    private Label day261;

    @FXML
    private AnchorPane diaryDay271;

    @FXML
    private Label day271;

    @FXML
    private AnchorPane diaryDay281;

    @FXML
    private Label day281;

    @FXML
    private AnchorPane diaryDay291;

    @FXML
    private Label day291;

    @FXML
    private AnchorPane diaryDay301;

    @FXML
    private Label day301;

    @FXML
    private AnchorPane diaryDay311;

    @FXML
    private Label day311;

    @FXML
    private AnchorPane SliderMenu;

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
    private AnchorPane sliderMenuPane;

    @FXML
    private Button sliderMenuHideButton;

    @FXML
    private ImageView sliderMenuHideIcon;

    @FXML
    private Button sliderMenuHomeButton;

    @FXML
    private ImageView sliderMenuHomeIcon;

    @FXML
    private Button sliderMenuProfileButton;

    @FXML
    private ImageView sliderMenuProfileIcon;

    @FXML
    private Button sliderMenuCalendarButton;

    @FXML
    private ImageView sliderMenuCalendarIcon;

    @FXML
    private Button sliderMenuGroupsButton;

    @FXML
    private ImageView sliderMenuGroupsIcon;

    @FXML
    private Button sliderMenuInvitationButton;

    @FXML
    private ImageView sliderMenuInvitationIcon;

    @FXML
    private Button sliderMenuSettingsButton;

    @FXML
    private ImageView sliderMenuSettingsIcon;

    @FXML
    private AnchorPane diaryDayBlackPane;

    @FXML
    private Button myDiaryButton;

    @FXML
    private Button addNewDiaryButton;

    @FXML
    private Label closeDiaryDayBlackPane;

    @FXML
    private AnchorPane myDiaryPane;

    @FXML
    private VBox myDiaryVBox;

    @FXML
    private AnchorPane addNewDiaryPane;

    @FXML
    private Button addMemory;

    @FXML
    private Button addEvent;

    @FXML
    private Button addNote;

    @FXML
    private AnchorPane addNewMemoryPane;

    @FXML
    private TextField addMemoryTitle;

    @FXML
    private TextArea addMemoryDescription;

    @FXML
    private CheckBox addMemoryNotification;

    @FXML
    private DatePicker addMemoryNotificationDate;

    @FXML
    private Button addNewMemory;

    @FXML
    private TextField addMemoryNotificationMinutes;

    @FXML
    private TextField addMemoryNotificationHours;

    @FXML
    private AnchorPane addNewEventPane;

    @FXML
    private TextField addEventTitle;

    @FXML
    private TextArea addEventDescription;

    @FXML
    private CheckBox addEventNotification;

    @FXML
    private DatePicker addEventNotificationDate;

    @FXML
    private Button addNewEvent;

    @FXML
    private TextField addEventNotificationMinutes;

    @FXML
    private TextField addEventNotificationHours;

    @FXML
    private AnchorPane addNewNotePane;

    @FXML
    private TextField addNoteTitle;

    @FXML
    private TextArea addNoteDescription;

    @FXML
    private CheckBox addNoteFix;

    @FXML
    private Button addNewNote;



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
            calendarPane.setVisible(false);
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
            
            userInfoButton.setStyle("-fx-text-fill:#0A283E ;");
            userInfoPane.setVisible(true);
        
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(true);
            sliderMenuCalendarIcon.setVisible(false);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(true);
            calendarPane.setVisible(false);
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
            
            calendarDaysButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarDaysPane.setVisible(true);

            myDiaryButton.setStyle("-fx-text-fill:#0A283E ;");
            myDiaryPane.setVisible(true);

            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addNewMemoryPane.setVisible(true);
        
            sliderMenuHomeIcon.setVisible(false);
            sliderMenuProfileIcon.setVisible(false);
            sliderMenuCalendarIcon.setVisible(true);
            sliderMenuGroupsIcon.setVisible(false);
            sliderMenuInvitationIcon.setVisible(false);
            sliderMenuSettingsIcon.setVisible(false);
            
            profilePane.setVisible(false);
            calendarPane.setVisible(true);
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
            calendarPane.setVisible(false);
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
            calendarPane.setVisible(false);
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
            calendarPane.setVisible(false);
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
        
        
        else if(event.getSource()==calendarDaysButton){
            calendarDaysButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarMonthButton.setStyle("");
            calendarYearButton.setStyle("");
            
            calendarDaysPane.setVisible(true);
        }
        else if(event.getSource()==calendarMonthButton){
            calendarMonthButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarDaysButton.setStyle("");
            calendarYearButton.setStyle("");
            
            calendarDaysPane.setVisible(false);
        }
        else if(event.getSource()==calendarYearButton){
            calendarYearButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarMonthButton.setStyle("");
            calendarDaysButton.setStyle("");
            
            calendarDaysPane.setVisible(false);
        }
        
        
        else if(event.getSource()==myDiaryButton){
            myDiaryButton.setStyle("-fx-text-fill:#0A283E ;");
            addNewDiaryButton.setStyle("");
            
            myDiaryPane.setVisible(true);
            addNewDiaryPane.setVisible(false);
        }
        else if(event.getSource()==addNewDiaryButton){
            addNewDiaryButton.setStyle("-fx-text-fill:#0A283E ;");
            myDiaryButton.setStyle("");
            
            myDiaryPane.setVisible(false);
            addNewDiaryPane.setVisible(true);
        }
        
        //Top bar Buttons
        else if(event.getSource()==addMemory){
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");
            
            addMemoryTitle.setText("");
            addMemoryDescription.setText("");
            addMemoryNotificationHours.setText("");
            addMemoryNotificationMinutes.setText("");
            addMemoryNotificationDate.setValue(null);
            addMemoryNotification.setSelected(false);
            
            
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            
        }
        else if(event.getSource()==addEvent){
            addEvent.setStyle("-fx-text-fill:#0A283E ;");
            addMemory.setStyle("");
            addNote.setStyle("");
            
            addEventTitle.setText("");
            addEventNotificationHours.setText("");
            addEventNotificationMinutes.setText("");
            addEventDescription.setText("");
            addEventNotificationDate.setValue(null);
            addEventNotification.setSelected(false);
            
            
            addNewMemoryPane.setVisible(false);
            addNewEventPane.setVisible(true);
            addNewNotePane.setVisible(false);
        }
        else if(event.getSource()==addNote){
            addNote.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addMemory.setStyle("");
            
            addNoteTitle.setText("");
            addNoteDescription.setText("");
            addNoteFix.setSelected(false);
            
            
            addNewMemoryPane.setVisible(false);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(true);
        }
        
        
    }
    @FXML
    private void openDayDiary(MouseEvent event) {
        if(event.getSource()==diaryDay1){dayDate=1;}
        else if(event.getSource()==diaryDay2){dayDate=2;}
        else if(event.getSource()==diaryDay3){dayDate=3;}
        else if(event.getSource()==diaryDay4){dayDate=4;}
        else if(event.getSource()==diaryDay5){dayDate=5;}
        else if(event.getSource()==diaryDay6){dayDate=6;}
        else if(event.getSource()==diaryDay7){dayDate=7;}
        else if(event.getSource()==diaryDay8){dayDate=8;}
        else if(event.getSource()==diaryDay9){dayDate=9;}
        else if(event.getSource()==diaryDay10){dayDate=10;}
        else if(event.getSource()==diaryDay11){dayDate=11;}
        else if(event.getSource()==diaryDay12){dayDate=12;}
        else if(event.getSource()==diaryDay13){dayDate=13;}
        else if(event.getSource()==diaryDay14){dayDate=14;}
        else if(event.getSource()==diaryDay15){dayDate=15;}
        else if(event.getSource()==diaryDay16){dayDate=16;}
        else if(event.getSource()==diaryDay17){dayDate=17;}
        else if(event.getSource()==diaryDay18){dayDate=18;}
        else if(event.getSource()==diaryDay19){dayDate=19;}
        else if(event.getSource()==diaryDay20){dayDate=20;}
        else if(event.getSource()==diaryDay21){dayDate=21;}
        else if(event.getSource()==diaryDay22){dayDate=22;}
        else if(event.getSource()==diaryDay23){dayDate=23;}
        else if(event.getSource()==diaryDay24){dayDate=24;}
        else if(event.getSource()==diaryDay25){dayDate=25;}
        else if(event.getSource()==diaryDay26){dayDate=26;}
        else if(event.getSource()==diaryDay27){dayDate=27;}
        else if(event.getSource()==diaryDay28){dayDate=28;}
        else if(event.getSource()==diaryDay29){dayDate=29;}
        else if(event.getSource()==diaryDay30){dayDate=30;}
        else if(event.getSource()==diaryDay31){dayDate=31;}
        diaryDayBlackPane.setVisible(true);
    }

    @FXML
    private void closePane(MouseEvent event) {
        if(event.getSource()==closeDiaryDayBlackPane){
            addMemoryTitle.setText("");
            addMemoryDescription.setText("");
            addMemoryNotificationHours.setText("");
            addMemoryNotificationMinutes.setText("");
            addMemoryNotificationDate.setValue(null);
            addMemoryNotification.setSelected(false);
            addEventTitle.setText("");
            addEventNotificationHours.setText("");
            addEventNotificationMinutes.setText("");
            addEventDescription.setText("");
            addEventNotificationDate.setValue(null);
            addEventNotification.setSelected(false);
            addNoteTitle.setText("");
            addNoteDescription.setText("");
            addNoteFix.setSelected(false);
            diaryDayBlackPane.setVisible(false);
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");       
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            addNewDiaryPane.setVisible(false);
            
            
            
        }
    }
    @FXML
    void addDiaryButtonAction(ActionEvent event) {
        // I HAVE TO ADD THE SAME FUNCTIONALITY LIKE event.getSource()==addMemory TO RESET THE PANE
        if(event.getSource()==addNewMemory){
            //add memry
            //--
            //--
            addMemoryTitle.setText("");
            addMemoryDescription.setText("");
            addMemoryNotificationHours.setText("");
            addMemoryNotificationMinutes.setText("");
            addMemoryNotificationDate.setValue(null);
            addMemoryNotification.setSelected(false);
            
            diaryDayBlackPane.setVisible(false);
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");       
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            addNewDiaryPane.setVisible(false);
        }
        if(event.getSource()==addNewEvent){
            //add memry
            //--
            //--
            addEventTitle.setText("");
            addEventNotificationHours.setText("");
            addEventNotificationMinutes.setText("");
            addEventDescription.setText("");
            addEventNotificationDate.setValue(null);
            addEventNotification.setSelected(false);
            
            diaryDayBlackPane.setVisible(false);
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");       
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            addNewDiaryPane.setVisible(false);
        }
        if(event.getSource()==addNewNote){
            //add memry
            //--
            //--
            addNoteTitle.setText("");
            addNoteDescription.setText("");
            addNoteFix.setSelected(false);
            
            diaryDayBlackPane.setVisible(false);
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");       
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            addNewDiaryPane.setVisible(false);
        }
    }
    @FXML
    void actionButtons(ActionEvent event) {

    }
}
