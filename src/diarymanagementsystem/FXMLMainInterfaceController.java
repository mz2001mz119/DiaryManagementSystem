/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import static java.lang.String.valueOf;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    static int dayDate;
    static int monthDate;
    static int yearDate;
    static int newClaendarYears;
    static int monthDays[]={31,28,31,30,31,30,31,31,30,31,30,31};
    static int monthDaysLeapYear[]={31,29,31,30,31,30,31,31,30,31,30,3};
    
    
    
    
    
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
    private AnchorPane calendarMonthPane;

    @FXML
    private AnchorPane diaryMonth1;

    @FXML
    private Label month1;

    @FXML
    private AnchorPane diaryMonth2;

    @FXML
    private Label month2;

    @FXML
    private AnchorPane diaryMonth3;

    @FXML
    private Label month3;

    @FXML
    private AnchorPane diaryMonth4;

    @FXML
    private Label month4;

    @FXML
    private AnchorPane diaryMonth5;

    @FXML
    private Label month5;

    @FXML
    private AnchorPane diaryMonth6;

    @FXML
    private Label month6;

    @FXML
    private AnchorPane diaryMonth7;

    @FXML
    private Label month7;

    @FXML
    private AnchorPane diaryMonth8;

    @FXML
    private Label month8;

    @FXML
    private AnchorPane diaryMonth9;

    @FXML
    private Label month9;

    @FXML
    private AnchorPane diaryMonth10;

    @FXML
    private Label month10;

    @FXML
    private AnchorPane diaryMonth11;

    @FXML
    private Label month11;

    @FXML
    private AnchorPane diaryMonth12;

    @FXML
    private Label month12;

    @FXML
    private AnchorPane calendarYearPane;

    @FXML
    private AnchorPane diaryYear1;

    @FXML
    private Label year1;

    @FXML
    private AnchorPane diaryYear2;

    @FXML
    private Label year2;

    @FXML
    private AnchorPane diaryYear3;

    @FXML
    private Label year3;

    @FXML
    private AnchorPane diaryYear4;

    @FXML
    private Label year4;

    @FXML
    private AnchorPane diaryYear5;

    @FXML
    private Label year5;

    @FXML
    private AnchorPane diaryYear6;

    @FXML
    private Label year6;

    @FXML
    private AnchorPane diaryYear7;

    @FXML
    private Label year7;

    @FXML
    private AnchorPane diaryYear8;

    @FXML
    private Label year8;

    @FXML
    private AnchorPane diaryYear9;

    @FXML
    private Label year9;

    @FXML
    private AnchorPane diaryYear10;

    @FXML
    private Label year10;

    @FXML
    private AnchorPane diaryYear11;

    @FXML
    private Label year11;

    @FXML
    private AnchorPane diaryYear12;

    @FXML
    private Label year12;

    @FXML
    private AnchorPane diaryYear13;

    @FXML
    private Label year13;

    @FXML
    private AnchorPane diaryYear14;

    @FXML
    private Label year14;

    @FXML
    private AnchorPane diaryYear15;

    @FXML
    private Label year15;

    @FXML
    private AnchorPane diaryYear16;

    @FXML
    private Label year16;

    @FXML
    private Button backButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Label calendarDate;

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
        //set current date
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        //set Calendar date lable
        String dateNow[]= formattedDate.split("-");
        calendarDate.setText(dateNow[1]+"/"+dateNow[2]);
        monthDate=Integer.parseInt(dateNow[1]);
        yearDate=Integer.parseInt(dateNow[2]);
        editcalendarDaysPane(monthDate,yearDate);
        newClaendarYears = yearDate;
        setCalendarYears(yearDate);
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
            editUserProfile.setStyle("");
            userInfoPane.setVisible(true);
            userEditInfoPane.setVisible(false);
            
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
            
            calendarDaysButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarMonthButton.setStyle("");
            calendarYearButton.setStyle("");
            
            LocalDate today = LocalDate.now();
            String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            //set Calendar date lable
            String dateNow[]= formattedDate.split("-");
            calendarDate.setText(dateNow[1]+"/"+dateNow[2]);
            monthDate=Integer.parseInt(dateNow[1]);
            yearDate=Integer.parseInt(dateNow[2]);
            editcalendarDaysPane(monthDate,yearDate);
            newClaendarYears = yearDate;
            setCalendarYears(yearDate);
        
            calendarDaysPane.setVisible(true);
            calendarMonthPane.setVisible(false);
            calendarYearPane.setVisible(false);
            
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
    // make profile image round
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
        //user Profile Top bar 
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
        
        //calendar Top bar
        else if(event.getSource()==calendarDaysButton){
            calendarDaysButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarMonthButton.setStyle("");
            calendarYearButton.setStyle("");
            
            calendarDaysPane.setVisible(true);
            calendarMonthPane.setVisible(false);
            calendarYearPane.setVisible(false);
        }
        else if(event.getSource()==calendarMonthButton){
            calendarMonthButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarDaysButton.setStyle("");
            calendarYearButton.setStyle("");
            
            calendarDaysPane.setVisible(false);
            calendarMonthPane.setVisible(true);
            calendarYearPane.setVisible(false);
        }
        else if(event.getSource()==calendarYearButton){
            calendarYearButton.setStyle("-fx-text-fill:#0A283E ;");
            calendarMonthButton.setStyle("");
            calendarDaysButton.setStyle("");
            
            calendarDaysPane.setVisible(false);
            calendarMonthPane.setVisible(false);
            calendarYearPane.setVisible(true);
        }
        
        //open diary top bar
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
        
        //add new diary Top bar Buttons
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
    //save the day when the user open a day on the calendar
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
        //close diary pane on calendar and reset the fields
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
        //add diary buttons adds diary and reset fields and close the pane
        if(event.getSource()==addNewMemory){
            //add memory
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
            //add event
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
            //add note
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
    private void actionButtons(ActionEvent event) {
        if(event.getSource()==editMyProfileSaveButton){
            //check the info then save
        }
    }
    @FXML
    private void setMonth(MouseEvent event) {
        //save month 
        if(event.getSource()==diaryMonth1){monthDate=1;}
        else if(event.getSource()==diaryMonth2){monthDate=2;}
        else if(event.getSource()==diaryMonth3){monthDate=3;}
        else if(event.getSource()==diaryMonth4){monthDate=4;}
        else if(event.getSource()==diaryMonth5){monthDate=5;}
        else if(event.getSource()==diaryMonth6){monthDate=6;}
        else if(event.getSource()==diaryMonth7){monthDate=7;}
        else if(event.getSource()==diaryMonth8){monthDate=8;}
        else if(event.getSource()==diaryMonth9){monthDate=9;}
        else if(event.getSource()==diaryMonth10){monthDate=10;}
        else if(event.getSource()==diaryMonth11){monthDate=11;}
        else if(event.getSource()==diaryMonth12){monthDate=12;}
        //change the label
        calendarDate.setText(""+monthDate+"/"+yearDate);
        editcalendarDaysPane(monthDate,yearDate);
        //open days pane
        calendarDaysButton.setStyle("-fx-text-fill:#0A283E ;");
        calendarMonthButton.setStyle("");
        calendarYearButton.setStyle("");
        
        calendarDaysPane.setVisible(true);
        calendarMonthPane.setVisible(false);
        calendarYearPane.setVisible(false);
    }
    private void editcalendarDaysPane(int monthDate,int year) {
        if(year%4==0){

            if(monthDaysLeapYear[monthDate-1]==29){
                diaryDay31.setDisable(true);
                diaryDay30.setDisable(true);
            }
            else if(monthDaysLeapYear[monthDate-1]==30){
                diaryDay31.setDisable(true);
                diaryDay30.setDisable(false);
                diaryDay29.setDisable(false);
            }
            else{
                diaryDay31.setDisable(false);
                diaryDay30.setDisable(false);
                diaryDay29.setDisable(false);
            }
        }
        else{
            if(monthDays[monthDate-1]==28){
                diaryDay31.setDisable(true);
                diaryDay30.setDisable(true);
                diaryDay29.setDisable(true);
            }
            else if(monthDays[monthDate-1]==30){
                diaryDay31.setDisable(true);
                diaryDay30.setDisable(false);
                diaryDay29.setDisable(false);
            }
            else{
                diaryDay31.setDisable(false);
                diaryDay30.setDisable(false);
                diaryDay29.setDisable(false);
            }
                
        }
    }
    @FXML
    private void setYear(MouseEvent event) {
        if(event.getSource()==diaryYear1){yearDate=Integer.parseInt(year1.getText());}
        else if(event.getSource()==diaryYear2){yearDate=Integer.parseInt(year2.getText());}
        else if(event.getSource()==diaryYear3){yearDate=Integer.parseInt(year3.getText());}
        else if(event.getSource()==diaryYear4){yearDate=Integer.parseInt(year4.getText());}
        else if(event.getSource()==diaryYear5){yearDate=Integer.parseInt(year5.getText());}
        else if(event.getSource()==diaryYear6){yearDate=Integer.parseInt(year6.getText());}
        else if(event.getSource()==diaryYear7){yearDate=Integer.parseInt(year7.getText());}
        else if(event.getSource()==diaryYear8){yearDate=Integer.parseInt(year8.getText());}
        else if(event.getSource()==diaryYear9){yearDate=Integer.parseInt(year9.getText());}
        else if(event.getSource()==diaryYear10){yearDate=Integer.parseInt(year10.getText());}
        else if(event.getSource()==diaryYear11){yearDate=Integer.parseInt(year11.getText());}
        else if(event.getSource()==diaryYear12){yearDate=Integer.parseInt(year12.getText());}
        else if(event.getSource()==diaryYear13){yearDate=Integer.parseInt(year13.getText());}
        else if(event.getSource()==diaryYear14){yearDate=Integer.parseInt(year14.getText());}
        else if(event.getSource()==diaryYear15){yearDate=Integer.parseInt(year15.getText());}
        else if(event.getSource()==diaryYear16){yearDate=Integer.parseInt(year16.getText());}
        
        //change the label
        calendarDate.setText(""+monthDate+"/"+yearDate);
        editcalendarDaysPane(monthDate,yearDate);
        //open days pane
        calendarMonthButton.setStyle("-fx-text-fill:#0A283E ;");
        calendarDaysButton.setStyle("");
        calendarYearButton.setStyle("");

        calendarDaysPane.setVisible(false);
        calendarMonthPane.setVisible(true);
        calendarYearPane.setVisible(false);
    }
    @FXML
    private void cahngeClaendarYears(ActionEvent event) {
        if(event.getSource()==backButton && newClaendarYears>1922){
             newClaendarYears -= 16;
             setCalendarYears(newClaendarYears);
        }
        if(event.getSource()==forwardButton && newClaendarYears<2122){
             newClaendarYears += 16;
             setCalendarYears(newClaendarYears);
        }
    }
    private void setCalendarYears(int currentYear){
        year1.setText(valueOf(currentYear-4));
        year2.setText(valueOf(currentYear-3));
        year3.setText(valueOf(currentYear-2));
        year4.setText(valueOf(currentYear-1));
        year5.setText(valueOf(currentYear));
        year6.setText(valueOf(currentYear+1));
        year7.setText(valueOf(currentYear+2));
        year8.setText(valueOf(currentYear+3));
        year9.setText(valueOf(currentYear+4));
        year10.setText(valueOf(currentYear+5));
        year11.setText(valueOf(currentYear+6));
        year12.setText(valueOf(currentYear+7));
        year13.setText(valueOf(currentYear+8));
        year14.setText(valueOf(currentYear+9));
        year15.setText(valueOf(currentYear+10));
        year16.setText(valueOf(currentYear+11));

        
    }
}
