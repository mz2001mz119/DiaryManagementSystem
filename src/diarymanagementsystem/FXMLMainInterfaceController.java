/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
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
    Connection conn;
    static String loginUserName;
    ArrayList <Notification> diaryNotification= new ArrayList();
    ArrayList <Notification> userNotifications= new ArrayList();
    ArrayList <Notification> editUserNotifications= new ArrayList();
    ArrayList <Diary> userDiary= new ArrayList();
    private static ObservableList <Diary> allUserDiary = FXCollections.observableArrayList();
    ArrayList <String> userGroupsAdminIds= new ArrayList();
    String diaryType;
    boolean groupEditCalendar;
    boolean calendarFromGroupPane;
    String invitationCardName;
    String invitationCardNameJasper;
    
    
    
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
    private ComboBox<String> editGender;

    @FXML
    private Button editMyProfileSaveButton;

    @FXML
    private AnchorPane fixNotesPane;

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
    private AnchorPane caledarSearchPane;

    @FXML
    private TextField calendarSearchTextField;


    @FXML
    private VBox caledarSearchVBox;

    @FXML
    private AnchorPane groupPane;

    @FXML
    private TextField publicGroupsSearchTextField;

    @FXML
    private VBox publicGroupVBox;

    @FXML
    private AnchorPane myGroupsPane;


    @FXML
    private Button createNewGroup;


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
    private AnchorPane notificationsPane;

    @FXML
    private VBox notificationsVBox;

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
    private Button addNewMemory;

    @FXML
    private Button addMemoryNotification;

    @FXML
    private AnchorPane addNewEventPane;

    @FXML
    private TextField addEventTitle;

    @FXML
    private TextArea addEventDescription;

    @FXML
    private Button addNewEvent;

    @FXML
    private Button addEventNotification;

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

    @FXML
    private AnchorPane dirayNotificationBlackPane;

    @FXML
    private Label closeNotificationBlackPane;

    @FXML
    private VBox notificationVBox;

    @FXML
    private DatePicker addNotificationDate;

    @FXML
    private TextField addNotificationMinutes;

    @FXML
    private TextField addNotificationHours;

    @FXML
    private Button addNotification;

    @FXML
    private AnchorPane showDiaryBlackPane;

    @FXML
    private Label closeShowDiaryBlackPane;

    @FXML
    private TextField showDiaryTitle;

    @FXML
    private TextField showDiaryDate;

    @FXML
    private TextArea showDiaryText;

    @FXML
    private AnchorPane showNotifiactionsBlackPane;

    @FXML
    private Label closeShowNotifiactionsBlackPane;

    @FXML
    private TextField showNotificationTitle;

    @FXML
    private TextField showNotificationDate;

    @FXML
    private TextArea showNotificationText;
    @FXML
    private AnchorPane createGroupBlackPane;
    @FXML
    private Label closeCreateGroupBlackPane;
    @FXML
    private TextField createGroupId;
    @FXML
    private TextField createGroupName;
    @FXML
    private TextField createGroupDescription;
    @FXML
    private ComboBox<String> createGroupPrivicy;
    @FXML
    private CheckBox createGroupSendMessages;
    @FXML
    private CheckBox createGroupAddDiary;
    @FXML
    private Button createGroup;
    @FXML
    private TextField userGroupsSearchTextField;
    @FXML
    private VBox userGroupsSearchVBox;
    @FXML
    private Label groupIdErrorLabel;
    @FXML
    private Label groupIdErrorLabelUnique;
    @FXML
    private Label groupNameErrorLabel;
    @FXML
    private AnchorPane userGroupPane;
    @FXML
    private Button userGroupBack;
    @FXML
    private AnchorPane userGroupTopInfoPane;
    @FXML
    private Button userGroupCalender;
    @FXML
    private ImageView userGroupImage;
    @FXML
    private Label userGroupName;
    @FXML
    private Label userGroupId;
    @FXML
    private AnchorPane userGroupInfoPane;
    @FXML
    private TextField userGroupInfoId;
    @FXML
    private TextField userGroupInfoName;
    @FXML
    private TextField userGroupInfoDescription;
    @FXML
    private ComboBox<String> userGroupInfoPrivicy;
    @FXML
    private CheckBox userGroupInfoSendMessages;
    @FXML
    private CheckBox userGroupInfoAddDiary;
    @FXML
    private Button userGroupInfoEdit;
    @FXML
    private TextField userGroupInfoMemberTextField;
    @FXML
    private Button userGroupInfoAdd;
    @FXML
    private Button userGroupInfoChoose;
    @FXML
    private Label userGroupInfoAddText;
    @FXML
    private Label userGroupInfoImageText;
    @FXML
    private Button userGroupInfoBack;
    @FXML
    private Button userGroupInfoRequests;
    @FXML
    private AnchorPane userGroupMessagesPane;
    @FXML
    private TextField userGroupInfoImage;
    @FXML
    private Button userGroupInfoMembers;
    @FXML
    private Label memberUsernameErrorLabel;
    @FXML
    private AnchorPane groupReqBlackPane;
    @FXML
    private Label closeGroupReqBlackPane;
    @FXML
    private VBox groupReqVBox;
    @FXML
    private CheckBox editDiaryFix;
    @FXML
    private Button editDiary;
    @FXML
    private Button editNotifications;
    @FXML
    private TextField showDiaryId;
    @FXML
    private Label editDiaryErrorLabel;
    @FXML
    private AnchorPane editDirayNotificationBlackPane;
    @FXML
    private VBox editnotificationVBox;
    @FXML
    private DatePicker addEditNotificationDate;
    @FXML
    private TextField addEditNotificationMinutes;
    @FXML
    private TextField addEditNotificationHours;
    @FXML
    private Button addEditNotification;
    @FXML
    private Label closeeditDirayNotificationBlackPane;
    @FXML
    private AnchorPane groupMembersBlackPane;
    @FXML
    private Label closeGroupMembersBlackPane;
    @FXML
    private VBox groupMembersVBox;
    @FXML
    private VBox groupMessagesVBox;
    @FXML
    private TextArea sendGroupMessageText;
    @FXML
    private Button sendGroupMessageButton;
    @FXML
    private ScrollPane groupMessagesScrollPane;
    @FXML
    private ScrollPane caledarSearchScrollPane;
    @FXML
    private ScrollPane myDiaryScrollPane;
    @FXML
    private AnchorPane groupSendMessagePane;
    @FXML
    private Button userEditImageChoose;
    @FXML
    private TextField userEditImageImage;
    @FXML
    private Label profileEmailErrorLabel;
    @FXML
    private Label profileImageErrorLabel;
    @FXML
    private AnchorPane invitationsPane;
    @FXML
    private Button partyButton;
    @FXML
    private Button birthdayButton;
    @FXML
    private Button weddingButton;
    @FXML
    private AnchorPane partyPane;
    @FXML
    private AnchorPane birthPane;
    @FXML
    private AnchorPane weddingPane;
    @FXML
    private Button p1;
    @FXML
    private Button p2;
    @FXML
    private Button p3;
    @FXML
    private Button p4;
    @FXML
    private Button p5;
    @FXML
    private Button p6;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button w1;
    @FXML
    private Button w2;
    @FXML
    private Button w3;
    @FXML
    private Button w4;
    @FXML
    private Button w5;
    @FXML
    private Button w6;
    @FXML
    private AnchorPane createInvitationCardPane;
    @FXML
    private Button createCardButton;
    @FXML
    private Button showCardsButton;
    @FXML
    private AnchorPane createCardsPane;
    @FXML
    private Label closeCreateInvitationCardPane;
    @FXML
    private Button createInvitationCard;
    @FXML
    private TextField nameInv;
    @FXML
    private Label textInvLabel;
    @FXML
    private TextField textInv;
    @FXML
    private TextField TDInvi;
    @FXML
    private TextField addressInvi;
    @FXML
    private TextField streetInv;
    @FXML
    private TextField placeInv;
    @FXML
    private Label CreateInvErrorLabel;
    @FXML
    private Button myInvitationsButton;
    @FXML
    private Label textInvLabel1;
    @FXML
    private Label invitationUsernameError;
    @FXML
    private TextField usernameInv;
    @FXML
    private TextField titleInv;
    @FXML
    private TextField desInv;
    @FXML
    private AnchorPane createInvitationCardSentPane;
    @FXML
    private Button closeCreateInvitationCardSentPane;
    @FXML
    private Text usernameInvErrorText;
    @FXML
    private Text invSentLabel;
    @FXML
    private AnchorPane showCardsPane;
    @FXML
    private VBox showCardsVBox;
    @FXML
    private VBox myInvitaionsVBox;
    @FXML
    private AnchorPane myInvitaionsPane;
    @FXML
    private AnchorPane homePane;
    @FXML
    private VBox fixNoteVBox;
    @FXML
    private VBox homePageVBox;
    @FXML
    private Button logoutButton;






//000
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/diarymanagementsystem","root", "");
            //Statement stmt = conn.createStatement();
            //String sqlstr="INSERT INTO `user` (`Name`, `username`, `Email`, `Gender`, `Birthdate`, `password`) VALUES ('Noor aldeen abu shehadeh', 'noorasaldeen', 'anooraldeen@gmail.com', 'Male', '2002-02-05', 'asdfg1234');";
            //stmt.executeUpdate(sqlstr);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateUserDiary();
        updateUserNotifications(); 
        //notification listener
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1.0), e -> {
                updateUserNotifications(); 
                if(LocalTime.now().format(DateTimeFormatter.ofPattern("ss")).toString().equals("00")){
                    for(int i=0;i<userNotifications.size();i++){
                        LocalDate today = LocalDate.now();
                        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        String hour = LocalTime.now().format(DateTimeFormatter.ofPattern("HH")).toString();
                        String minute = LocalTime.now().format(DateTimeFormatter.ofPattern("mm")).toString();
                        if(userNotifications.get(i).notificationDate.equals(formattedDate) && userNotifications.get(i).notificationHour.equals(hour) && userNotifications.get(i).notificationMinute.equals(minute)){
                            notificationsPane.setVisible(true);
                            AnchorPane a=new AnchorPane();
                            a.setStyle("-fx-pref-width:280px; -fx-pref-height:70px; -fx-border-color:#DA0037; -fx-background-color:#082032;");
                            Label notificationTitle = new Label("New Notification");
                            Label notificationDT = new Label(userNotifications.get(i).notificationDate+"\t"+userNotifications.get(i).notificationHour+":"+userNotifications.get(i).notificationMinute+" ...click for more");
                            notificationTitle.setStyle("-fx-font-size: 20px; -fx-text-fill:#EA0640;");
                            notificationDT.setStyle("-fx-font-size: 12px; -fx-text-fill: #DA0037;");
                            a.getChildren().add(notificationTitle);
                            a.setTopAnchor(notificationTitle, 5.0);
                            a.setLeftAnchor(notificationTitle, 5.0);
                            
                            a.getChildren().add(notificationDT);
                            a.setTopAnchor(notificationDT, 35.0);
                            a.setLeftAnchor(notificationDT, 20.0);
                            
                            final String id=userNotifications.get(i).diaryId;
                            a.setOnMouseClicked(new EventHandler<MouseEvent>(){
                                @Override
                                public void handle(MouseEvent t) {
                                    try {
                                        showNotifiactionsBlackPane.setVisible(true);
                                        Statement stmt = conn.createStatement();
                                        String sqlstr="SELECT `Title`, `Description`, `Date` FROM `diary` WHERE ID='"+id+"';";
                                        ResultSet diaryID=stmt.executeQuery(sqlstr);
                                        diaryID.next();
                                        showNotificationTitle.setText(diaryID.getString("Title"));
                                        showNotificationDate.setText(diaryID.getString("Date"));
                                        showNotificationText.setText(diaryID.getString("Description"));
                                        notificationsVBox.getChildren().remove(a);
                                        if(notificationsVBox.getChildren().isEmpty())
                                            notificationsPane.setVisible(false);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            
                            });
                            try{
                                //String uriString = new File(""C:\\Users\\Mike\\workspace\\b\\src\\hero.mp3"").toURI().toString();
                                
                            }catch(Exception ex){
                                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            String uriString = new File("src\\diarymanagementsystem\\media\\notification.mp3").toURI().toString();
                            Media media = new Media(uriString); 
                            MediaPlayer player = new MediaPlayer(media); 
                            player.play();
                            notificationsVBox.getChildren().add(a);
                            PauseTransition delay = new PauseTransition(Duration.seconds(10));
                            delay.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    notificationsVBox.getChildren().remove(a);
                                    if(notificationsVBox.getChildren().isEmpty())
                                        notificationsPane.setVisible(false);
                                }
                            });
                            delay.play();
                        }
                    }
                    
                }
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
           
        // TODO
        //set the main button pressed for the main pane
        sliderMenuHomeButton.setStyle("-fx-background-color: #C30032; ");
        sliderMenuHomeButton2.setStyle("-fx-background-color: #C30032; -fx-text-fill:white;");
        sliderMenuHomeIcon.setVisible(true);
        fixNotesPane.setVisible(true);
        roundImage(userImage,150,150);
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
        fillFixNotePane();
        fillHomeVBox() ;
        fixNotesPane.setVisible(true);
        homePane.setVisible(true);
    }    
void functionshowinformation(){
        try{
    Statement stmt = conn.createStatement();
    String sqlstr="SELECT * FROM `User` WHERE username='"+loginUserName+"';";
    ResultSet rs=stmt.executeQuery(sqlstr);
    rs.next();
    profileEmail.setText(rs.getString("Email"));
    profileBirthdate.setText(rs.getString("Birthdate"));
    profileGender.setText(rs.getString("Gender"));
    }catch(Exception e){
    }
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
            fillFixNotePane();
            fillHomeVBox();
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
            
            fixNotesPane.setVisible(true);
            homePane.setVisible(true);
            profilePane.setVisible(false);
            calendarPane.setVisible(false);
            caledarSearchPane.setVisible(false);
            groupPane.setVisible(false);
            myGroupsPane.setVisible(false);
            userGroupPane.setVisible(false);
            invitationsPane.setVisible(false);
        }
        else if(event.getSource()==sliderMenuProfileButton||event.getSource() == sliderMenuProfileButton2){
            try {
                fillFixNotePane();
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
                
                fixNotesPane.setVisible(true);
                homePane.setVisible(false);
                profilePane.setVisible(true);
                calendarPane.setVisible(false);
                caledarSearchPane.setVisible(false);
                groupPane.setVisible(false);
                myGroupsPane.setVisible(false);
                userGroupPane.setVisible(false);
                invitationsPane.setVisible(false);
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `Name`, `username`, `Email`, `Gender`, `Birthdate`, `password`, `userimage` FROM `user` WHERE `username`='"+loginUserName+"'";
                ResultSet userInfo=stmt.executeQuery(sqlstr);
                userInfo.next();
                InputStream input;
                input = userInfo.getBinaryStream("userimage");
                if (input != null && input.available() > 1) {
                    Image imge = new Image(input);
                    userImage.setImage(imge);
                    
                }
                userFullName.setText(userInfo.getString("Name"));
                userName.setText(userInfo.getString("username"));
                functionshowinformation();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(event.getSource()==sliderMenuCalendarButton||event.getSource()==sliderMenuCalendarButton2){
            SearchOnDiaryData();
            caledarSearchVBox.getChildren().clear();
            calendarSearchTextField.setText("");
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
            
            fixNotesPane.setVisible(false);
            homePane.setVisible(false);
            profilePane.setVisible(false);
            calendarPane.setVisible(true);
            caledarSearchPane.setVisible(true);
            groupPane.setVisible(false);
            myGroupsPane.setVisible(false);
            userGroupPane.setVisible(false);
            invitationsPane.setVisible(false);
            //to reset the buttons when user use his calendar not group calendar
            addMemoryNotification.setDisable(false);
            addEventNotification.setDisable(false);
            addNoteFix.setDisable(false);
            editNotifications.setDisable(false);
            editDiaryFix.setDisable(false);
            editDiary.setDisable(false);
            addNewDiaryButton.setDisable(false);
            calendarFromGroupPane=false;
            caledarSearchScrollPane.setFitToWidth(true);
            myDiaryScrollPane.setFitToWidth(true);
            
        }
        else if(event.getSource()==sliderMenuGroupsButton||event.getSource()==sliderMenuGroupsButton2){
            FillGroupAdminList();
            SearchOnPublicGroups();
            SearchOnUserGroups();
            caledarSearchVBox.getChildren().clear();
            calendarSearchTextField.setText("");
            SearchOnDiaryData();
            
            LocalDate today = LocalDate.now();
            String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            //set Calendar date lable
            String dateNow[]= formattedDate.split("-");
            calendarDate.setText(dateNow[1]+"/"+dateNow[2]);
            monthDate=Integer.parseInt(dateNow[1]);
            yearDate=Integer.parseInt(dateNow[2]);
            editcalendarDaysPane(monthDate,yearDate);
            newClaendarYears = yearDate;
        
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
            invitationsPane.setVisible(false);
            
            fixNotesPane.setVisible(false);
            homePane.setVisible(false);
            profilePane.setVisible(false);
            calendarPane.setVisible(false);
            caledarSearchPane.setVisible(false);
            groupPane.setVisible(true);
            myGroupsPane.setVisible(true);
            userGroupPane.setVisible(false);
            invitationsPane.setVisible(false);
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
            
            fixNotesPane.setVisible(false);
            homePane.setVisible(false);
            profilePane.setVisible(false);
            calendarPane.setVisible(false);
            caledarSearchPane.setVisible(false);
            groupPane.setVisible(false);
            myGroupsPane.setVisible(false);
            userGroupPane.setVisible(false);
            invitationsPane.setVisible(true);
            partyButton.setStyle("-fx-text-fill:#0A283E ;");
            createCardButton.setStyle("-fx-text-fill:#0A283E ;");
            showCardsButton.setStyle("");
            myInvitationsButton.setStyle("");
            
            createCardsPane.setVisible(true);
            showCardsPane.setVisible(false);
            myInvitaionsPane.setVisible(false);
            partyButton.setStyle("-fx-text-fill:#0A283E ;");
            birthdayButton.setStyle("");
            weddingButton.setStyle("");
            partyPane.setVisible(true);
            createCardsPane.setVisible(true);
            CreateInvErrorLabel.setVisible(false);
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
            
            fixNotesPane.setVisible(false);
            homePane.setVisible(false);
            profilePane.setVisible(false);
            calendarPane.setVisible(false);
            caledarSearchPane.setVisible(false);
            groupPane.setVisible(false);
            myGroupsPane.setVisible(false);
            userGroupPane.setVisible(false);
            invitationsPane.setVisible(false);
        }

    }
    // make profile image round
    private void roundImage(ImageView img,int width,int height) {
         // set a clip to apply rounded border to the original image.
            Rectangle clip = new Rectangle(
                img.getFitWidth(), img.getFitHeight()
            );
            clip.setArcWidth(width);
            clip.setArcHeight(height);
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
            functionshowinformation();
            
        }
        else if(event.getSource()==editUserProfile){
            editUserProfile.setStyle("-fx-text-fill:#0A283E ;");
            userInfoButton.setStyle("");
            userInfoPane.setVisible(false);
            userEditInfoPane.setVisible(true);
            ObservableList<String>  list =FXCollections.observableArrayList("Male","Female");
             try{
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT * FROM `User` WHERE username='"+loginUserName+"';";
                ResultSet rs=stmt.executeQuery(sqlstr);
                rs.next();
                editEmail.setText(rs.getString("Email"));
                editBirthdate.setValue(LocalDate.parse(rs.getDate("Birthdate").toString()));
                editGender.setItems(list);
                editGender.setValue(rs.getString("Gender"));
                editUserName.setText(rs.getString("username"));
                editName.setText(rs.getString("Name"));
                } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            refreshDiaryVBox();
            updateUserDiary();
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
            
            
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            
        }
        else if(event.getSource()==addEvent){
            addEvent.setStyle("-fx-text-fill:#0A283E ;");
            addMemory.setStyle("");
            addNote.setStyle("");
            
            addEventTitle.setText("");
            addEventDescription.setText("");
            
            
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
        else if(event.getSource()==partyButton){
            partyButton.setStyle("-fx-text-fill:#0A283E ;");
            birthdayButton.setStyle("");
            weddingButton.setStyle("");
            
            partyPane.setVisible(true);
            birthPane.setVisible(false);
            weddingPane.setVisible(false);
        }
        else if(event.getSource()==birthdayButton){
            birthdayButton.setStyle("-fx-text-fill:#0A283E ;");
            partyButton.setStyle("");
            weddingButton.setStyle("");
            
            partyPane.setVisible(false);
            birthPane.setVisible(true);
            weddingPane.setVisible(false);
        }
        else if(event.getSource()==weddingButton){
            weddingButton.setStyle("-fx-text-fill:#0A283E ;");
            partyButton.setStyle("");
            birthdayButton.setStyle("");
            
            partyPane.setVisible(false);
            birthPane.setVisible(false);
            weddingPane.setVisible(true);
        }
        else if(event.getSource()==createCardButton){
            createCardButton.setStyle("-fx-text-fill:#0A283E ;");
            showCardsButton.setStyle("");
            myInvitationsButton.setStyle("");
            
            createCardsPane.setVisible(true);
            showCardsPane.setVisible(false);
            myInvitaionsPane.setVisible(false);
        }
        else if(event.getSource()==showCardsButton){
            createCardButton.setStyle("");
            showCardsButton.setStyle("-fx-text-fill:#0A283E ;");
            myInvitationsButton.setStyle("");
            
            
            createCardsPane.setVisible(false);
            showCardsPane.setVisible(true);
            myInvitaionsPane.setVisible(false);
            fillShowCardsVBox();
            
        }
        else if(event.getSource()==myInvitationsButton){
            createCardButton.setStyle("");
            showCardsButton.setStyle("");
            myInvitationsButton.setStyle("-fx-text-fill:#0A283E ;");
            
            
            createCardsPane.setVisible(false);
            showCardsPane.setVisible(false);
            myInvitaionsPane.setVisible(true);
            fillMyInvitationsVBox();
            
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
            addEventTitle.setText("");
            addEventDescription.setText("");
            addNoteTitle.setText("");
            addNoteDescription.setText("");
            addNoteFix.setSelected(false);
            diaryDayBlackPane.setVisible(false);
            myDiaryButton.setStyle("");
            addNewDiaryButton.setStyle("");
            addMemory.setStyle("-fx-text-fill:#0A283E ;");
            addEvent.setStyle("");
            addNote.setStyle("");       
            addNewMemoryPane.setVisible(true);
            addNewEventPane.setVisible(false);
            addNewNotePane.setVisible(false);
            addNewDiaryPane.setVisible(false);
            myDiaryPane.setVisible(false);
        }
        else if(event.getSource()==closeNotificationBlackPane){
            addNotificationDate.setValue(null);
            addNotificationMinutes.setText("");
            addNotificationHours.setText("");
            notificationVBox.getChildren().clear();
            dirayNotificationBlackPane.setVisible(false);
        }
        else if(event.getSource()==closeShowNotifiactionsBlackPane){
            showNotifiactionsBlackPane.setVisible(false);
            showNotificationTitle.setText("");
            showNotificationDate.setText("");
            showNotificationText.setText("");
        }
        else if(event.getSource()==closeShowDiaryBlackPane){
            showDiaryBlackPane.setVisible(false);
            showDiaryTitle.setText("");
            showDiaryDate.setText("");
            showDiaryText.setText("");
            editNotifications.setVisible(false);
            editDiaryFix.setVisible(false);
        }
        else if(event.getSource()==closeCreateGroupBlackPane){
            createGroupId.setText("");
            createGroupName.setText("");
            createGroupDescription.setText("");
            createGroupPrivicy.getSelectionModel().select(0);
            createGroupSendMessages.setSelected(false);
            createGroupAddDiary.setSelected(false);
            createGroupBlackPane.setVisible(false);
            groupIdErrorLabel.setVisible(false);
            groupNameErrorLabel.setVisible(false);
            groupIdErrorLabelUnique.setVisible(false);
        }
        else if(event.getSource()==closeGroupReqBlackPane){
            groupReqVBox.getChildren().clear();
            groupReqBlackPane.setVisible(false);
        }
        else if(event.getSource()==closeeditDirayNotificationBlackPane){
            editnotificationVBox.getChildren().clear();
            addEditNotificationDate.setValue(null);
            addEditNotificationHours.setText("");
            addEditNotificationMinutes.setText("");
            editDirayNotificationBlackPane.setVisible(false);
            
        }
        else if (event.getSource()==closeGroupMembersBlackPane){
            groupMembersBlackPane.setVisible(false);
            groupMembersVBox.getChildren().clear();
        }
        else if (event.getSource()==closeCreateInvitationCardPane){
            createInvitationCardPane.setVisible(false);
            CreateInvErrorLabel.setVisible(false);
            nameInv.setText("");
            textInv.setText("");
            TDInvi.setText("");
            addressInvi.setText("");
            streetInv.setText("");
            placeInv.setText("");
            usernameInv.setText("");
            titleInv.setText("");
            desInv.setText("");
        }
        
    }
    @FXML
    void openNotificationPane(ActionEvent event) {
        if(event.getSource()==addEventNotification  ){
            dirayNotificationBlackPane.setVisible(true);
        }
        if(event.getSource()==addMemoryNotification ){
            dirayNotificationBlackPane.setVisible(true);
            limitTimeTextField(addNotificationMinutes,59);
            limitTimeTextField(addNotificationHours,23);
            //set min date of the notification the current date
            LocalDate minDate = LocalDate.now();
            addNotificationDate.setDayCellFactory(d ->
                       new DateCell() {
                           @Override public void updateItem(LocalDate item, boolean empty) {
                               super.updateItem(item, empty);
                               setDisable(item.isBefore(minDate));
                           }});
        }
    }
    private void limitTimeTextField(TextField t,int endNum){
        t.setTextFormatter(new TextFormatter<Integer>(change -> {
            // Deletion should always be possible.
            if (change.isDeleted()) {return change;}
            // How would the text look like after the change?
            String txt = change.getControlNewText();
            // There shouldn't be leading zeros.
            if (txt.matches("0\\d+")) {return null;}
            // Try parsing and check if the result is in [0, 64].
            try {
                int n = Integer.parseInt(txt);
                return 0 <= n && n <= endNum ? change : null;
            } catch (NumberFormatException e) {
                return null;
            }
        }));
    }
    @FXML
    void addDiaryButtonAction(ActionEvent event) {
        //add diary buttons adds diary and reset fields and close the pane
        if(event.getSource()==addNewMemory){
            try {
                if(!calendarFromGroupPane){
                    //add memory
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addMemoryTitle.getText()+"','"+addMemoryDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addMemoryTitle.getText()+"' AND Description='"+addMemoryDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `user-calendar`(`username`, `diaryid`) VALUES ('"+loginUserName+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                    if(diaryNotification.isEmpty()){
                        sqlstr="INSERT INTO `memory`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','0')";
                        stmt.executeUpdate(sqlstr);
                    }
                    else{
                        sqlstr="INSERT INTO `memory`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','1')";
                        stmt.executeUpdate(sqlstr);
                        for(int i=0;i<diaryNotification.size();i++){
                            sqlstr="INSERT INTO `usernotification`(`username`, `diaryid`, `datetime`) VALUES ('"+loginUserName+"','"+diaryId+"','"+diaryNotification.get(i).notificationDate +" "+diaryNotification.get(i).notificationHour+":"+diaryNotification.get(i).notificationMinute+":00" +"')";
                            stmt.executeUpdate(sqlstr);
                        }
                    }
                    updatAllUserDiary();
                    updateUserNotifications();
                    diaryNotification.clear();
                    notificationVBox.getChildren().clear();
                }
                else{
                    //add memory
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addMemoryTitle.getText()+"','"+addMemoryDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addMemoryTitle.getText()+"' AND Description='"+addMemoryDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `group-calender`(`groupid`, `Diaryid`) VALUES ('"+userGroupId.getText()+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                    sqlstr="INSERT INTO `memory`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','0')";
                    stmt.executeUpdate(sqlstr);
                    updatAllUserDiary();
                    diaryNotification.clear();
                    notificationVBox.getChildren().clear();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            addMemoryTitle.setText("");
            addMemoryDescription.setText("");
            
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
            try {
                if(!calendarFromGroupPane){
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addEventTitle.getText()+"','"+addEventDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addEventTitle.getText()+"' AND Description='"+addEventDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `user-calendar`(`username`, `diaryid`) VALUES ('"+loginUserName+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                    if(diaryNotification.isEmpty()){
                        sqlstr="INSERT INTO `event`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','0')";
                        stmt.executeUpdate(sqlstr);
                    }
                    else{
                        sqlstr="INSERT INTO `event`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','1')";
                        stmt.executeUpdate(sqlstr);
                        for(int i=0;i<diaryNotification.size();i++){
                            sqlstr="INSERT INTO `usernotification`(`username`, `diaryid`, `datetime`) VALUES ('"+loginUserName+"','"+diaryId+"','"+diaryNotification.get(i).notificationDate +" "+diaryNotification.get(i).notificationHour+":"+diaryNotification.get(i).notificationMinute+":00" +"')";
                            stmt.executeUpdate(sqlstr);
                        }
                    }
                    updatAllUserDiary();
                    updateUserNotifications();
                    diaryNotification.clear();
                    notificationVBox.getChildren().clear();
                }
                else{
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addEventTitle.getText()+"','"+addEventDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addEventTitle.getText()+"' AND Description='"+addEventDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `group-calender`(`groupid`, `Diaryid`) VALUES ('"+userGroupId.getText()+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                    sqlstr="INSERT INTO `event`(`diaryid`, `Notification`) VALUES ('"+diaryId+"','0')";
                    stmt.executeUpdate(sqlstr);
                    updatAllUserDiary();
                    diaryNotification.clear();
                    notificationVBox.getChildren().clear();
                }
                } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            addEventTitle.setText("");
            addEventDescription.setText("");
            
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
            try {
                if(!calendarFromGroupPane){
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addNoteTitle.getText()+"','"+addNoteDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addNoteTitle.getText()+"' AND Description='"+addNoteDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `user-calendar`(`username`, `diaryid`) VALUES ('"+loginUserName+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                    if(addNoteFix.isSelected()){
                        sqlstr="INSERT INTO `note`(`diaryid`, `Fix Note`) VALUES ('"+diaryId+"','1')";
                        stmt.executeUpdate(sqlstr);
                    }
                    else{
                        sqlstr="INSERT INTO `note`(`diaryid`, `Fix Note`) VALUES ('"+diaryId+"','0')";
                        stmt.executeUpdate(sqlstr);
                         
                    }
                }
                else{
                    Statement stmt = conn.createStatement();
                    String sqlstr="INSERT INTO `diary` (`Title`, `Description`, `Date`) VALUES ('"+addNoteTitle.getText()+"','"+addNoteDescription.getText()+"','"+yearDate+"-"+monthDate+"-"+dayDate+"');";
                    stmt.executeUpdate(sqlstr);
                     
                    //connect with user calendar
                    sqlstr="SELECT ID from diary where Title = '"+addNoteTitle.getText()+"' AND Description='"+addNoteDescription.getText()+"' and date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER BY ID DESC;";
                    ResultSet diaryID=stmt.executeQuery(sqlstr);
                    diaryID.next();
                    int diaryId = diaryID.getInt(1);
                    diaryID.close();
                    sqlstr="INSERT INTO `group-calender`(`groupid`, `Diaryid`) VALUES ('"+userGroupId.getText()+"','"+diaryId+"');";
                    stmt.executeUpdate(sqlstr);
                     
                    sqlstr="INSERT INTO `note`(`diaryid`, `Fix Note`) VALUES ('"+diaryId+"','0')";
                    stmt.executeUpdate(sqlstr);
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            updatAllUserDiary();
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
        if(event.getSource()==addNotification){
            //make sure theres no Repetition
            boolean isAdded =false;
                if(!diaryNotification.isEmpty()){
                    for(int i=0;i<diaryNotification.size();i++){
                        if(addNotificationDate.getValue()!=null && addNotificationDate.getValue().toString().equals(diaryNotification.get(i).notificationDate) && addNotificationHours.getText().equals(diaryNotification.get(i).notificationHour) && addNotificationMinutes.getText().equals(diaryNotification.get(i).notificationMinute)){
                            isAdded =true;
                        }
                    }
                }
                if(diaryNotification.isEmpty() || !isAdded){
                    if(addNotificationDate.getValue()!=null &&!addNotificationHours.getText().equals("") && !addNotificationMinutes.getText().equals(""))
                    diaryNotification.add(new Notification(addNotificationDate.getValue().toString(),addNotificationHours.getText(),addNotificationMinutes.getText()));
                    refreshNotificationVBox();
                }
                
        }
    }
    //refresh the vbox to delete any notification
    private void refreshNotificationVBox(){
        notificationVBox.getChildren().clear();
        for(int i=0;i<diaryNotification.size();i++){
            final int ii = i;
            String notiHour =valueOf(diaryNotification.get(i).notificationHour) ;
             String notiMinute =valueOf(diaryNotification.get(i).notificationMinute) ;
            AnchorPane a=new AnchorPane();
            a.setStyle("-fx-pref-width:500px; -fx-pref-height:70px; -fx-border-color:#DA0037");
            if(Integer.parseInt(diaryNotification.get(i).notificationHour)<10)
                notiHour="0"+notiHour;
            if(Integer.parseInt(diaryNotification.get(i).notificationMinute)<10)
                notiMinute="0"+notiMinute;
            Label notificationDT = new Label(diaryNotification.get(i).notificationDate+"\t"+notiHour+":"+notiMinute);
            notificationDT.setStyle("-fx-font-size: 20px;");
            a.getChildren().add(notificationDT);
            a.setTopAnchor(notificationDT, 10.0);
            a.setBottomAnchor(notificationDT, 10.0);
            a.setLeftAnchor(notificationDT, 10.0);
            Label deleteNotification = new Label("X");//delete date
            deleteNotification.setOnMouseClicked((mouseEvent) -> {
                diaryNotification.remove(ii);
                refreshNotificationVBox();
            });
            deleteNotification.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
            a.getChildren().add(deleteNotification);
            a.setTopAnchor(deleteNotification, 10.0);
            a.setBottomAnchor(deleteNotification, 10.0);
            a.setRightAnchor(deleteNotification, 20.0);
            notificationVBox.getChildren().add(a);
        }
    }
    @FXML
    private void actionButtons(ActionEvent event) throws FileNotFoundException {
        
        if(event.getSource()==createNewGroup){
            createGroupId.setText("");
            createGroupName.setText("");
            createGroupDescription.setText("");
            createGroupPrivicy.getItems().clear();
            createGroupPrivicy.getItems().addAll("Public", "Private");
            createGroupPrivicy.getSelectionModel().select(0);
            createGroupSendMessages.setSelected(false);
            createGroupAddDiary.setSelected(false);
            createGroupBlackPane.setVisible(true);
        }
        else if(event.getSource()==logoutButton){
            try {
                loginUserName="";
                Parent Parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
                Scene Scene = new Scene(Parent);
                Stage Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Stage.setScene(Scene);
                Stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(event.getSource()==createGroup){
            try {
                //check the valid inputs
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `groupid` FROM `dms-group` WHERE 1";
                ResultSet groupsId=stmt.executeQuery(sqlstr);
                boolean groupIsExists =false;
                while(groupsId.next()){
                    if(groupsId.getString("groupid").equals(createGroupId.getText())){
                        groupIsExists =true;
                    }
                }
                if(!groupIsExists){
                    groupIdErrorLabelUnique.setVisible(false);
                    boolean flag=true;
                     createGroupId.setText(createGroupId.getText().trim());
                    if(createGroupId.getText().length()<=4)
                        flag=false;
                    else{
                       
                        for(int i=0;i<createGroupId.getText().length();i++){
                            if((createGroupId.getText().charAt(i)>='a'||createGroupId.getText().charAt(i)<='z'||createGroupId.getText().charAt(i)>='A'||createGroupId.getText().charAt(i)<='Z'||createGroupId.getText().charAt(i)>='0'||createGroupId.getText().charAt(i)<='9'||createGroupId.getText().charAt(i)=='.'||createGroupId.getText().charAt(i)=='-'||createGroupId.getText().charAt(i)=='_')&&createGroupId.getText().charAt(i)!=' '){
                                ;
                            }
                            else
                                flag=false;
                        }
                    }
                    if(flag){
                        groupIdErrorLabel.setVisible(false);
                        if(createGroupName.getText().trim().equals("")){
                            groupNameErrorLabel.setVisible(true);
                            throw new Exception();
                        }
                        else{
                            groupNameErrorLabel.setVisible(false);
                            int message=0,diary=0,privicy=0;
                            if(createGroupSendMessages.isSelected())
                                message=1;
                            if(createGroupAddDiary.isSelected())
                                diary=1;
                            if(createGroupPrivicy.getSelectionModel().getSelectedItem().equals("Public"))
                                privicy=1;
                            else
                                privicy=0;
                            Statement stmt3 = conn.createStatement();
                            String sqlstr3="INSERT INTO `dms-group`(`groupid`, `name`, `adminusername`, `description`,  `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy`) VALUES ('"+createGroupId.getText()+"','"+createGroupName.getText()+"','"+loginUserName+"','"+createGroupDescription.getText()+"','"+message+"','"+diary+"','"+privicy+"')";
                            stmt3.executeUpdate(sqlstr3);
                             
                            Statement stmt1 = conn.createStatement();
                            String sqlstr1="INSERT INTO `user-group`(`username`, `groupid`, `userapproverequest`, `adminapproverequest`) VALUES ('"+loginUserName+"','"+createGroupId.getText()+"','1','1')";
                            stmt1.executeUpdate(sqlstr1);
                             
                            createGroupBlackPane.setVisible(false);
                            FillUserGroupsVBox();
                        }
                    }
                    else{
                        groupIdErrorLabel.setVisible(true);
                        throw new Exception();
                    }
                }
                else{
                    groupIdErrorLabelUnique.setVisible(true);
                    throw new Exception();
                }
                
                
                //add to the group table with admin name = the variable loginUserName
                //add defult image to the grpup from images/icons/group.png
                createGroupId.setText("");
                createGroupName.setText("");
                createGroupDescription.setText("");
                createGroupPrivicy.getItems().clear();
                createGroupPrivicy.getItems().addAll("Public", "Private");
                createGroupPrivicy.getSelectionModel().select(0);
                createGroupSendMessages.setSelected(false);
                createGroupAddDiary.setSelected(false);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(event.getSource()==userGroupBack){
            groupPane.setVisible(true);
            userGroupPane.setVisible(false);
        }
        else if(event.getSource()==userGroupInfoBack){
            try {
                userGroupInfoPane.setVisible(false);
                userGroupMessagesPane.setVisible(true);
                memberUsernameErrorLabel.setVisible(false);
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group` where `groupid`='"+userGroupId.getText()+"'";
                ResultSet userGroups=stmt.executeQuery(sqlstr);
                userGroups.next();
                userGroupInfoName.setText(userGroups.getString("name"));
                userGroupInfoId.setText(userGroups.getString("groupid"));
                userGroupInfoDescription.setText(userGroups.getString("description"));
                userGroupInfoPrivicy.getItems().clear();
                userGroupInfoPrivicy.getItems().addAll("Public", "Private");
                if(userGroups.getInt("attributeprivicy") == 0){
                    userGroupInfoPrivicy.getSelectionModel().select(1);
                }
                else
                    userGroupInfoPrivicy.getSelectionModel().select(0);
                if(userGroups.getInt("memberscansendmessage") == 1)
                    userGroupInfoSendMessages.selectedProperty().setValue(true);
                if(userGroups.getInt("memberscaneditcalendar") == 1)
                    userGroupInfoAddDiary.selectedProperty().setValue(true);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(event.getSource()==userGroupInfoEdit){
            try {
                int message=0,diary=0,privicy=0;
                if(userGroupInfoSendMessages.isSelected())
                    message=1;
                if(userGroupInfoAddDiary.isSelected())
                    diary=1;
                if(userGroupInfoPrivicy.getSelectionModel().getSelectedItem().equals("Public"))
                    privicy=1;
                else
                    privicy=0;
                if(!userGroupInfoName.getText().trim().equals("") && !userGroupInfoDescription.getText().trim().equals("")){
                Statement stmt = conn.createStatement();
                String sqlstr="UPDATE `dms-group` SET `name`='"+userGroupInfoName.getText()+"',`description`='"+userGroupInfoDescription.getText()+"',`memberscansendmessage`='"+message+"',`memberscaneditcalendar`='"+diary+"',`attributeprivicy`='"+privicy+"' WHERE `groupid`='"+ userGroupInfoId.getText()+"'" ;//`imagegroup`='LOAD_FILE("+userGroupInfoImage.getText()+")'
                stmt.executeUpdate(sqlstr);
                if(!userGroupInfoImage.getText().isEmpty()){
                    FileInputStream fis = null;
                    PreparedStatement ps = null;
                    String INSERT_PICTURE = "UPDATE `dms-group` SET `imagegroup`=? WHERE `groupid`='"+ userGroupInfoId.getText()+"'";
                    try {
                      File file = new File(userGroupInfoImage.getText());
                      fis = new FileInputStream(file);
                      ps = conn.prepareStatement(INSERT_PICTURE);
                      ps.setBinaryStream(1, fis, (int) file.length());
                      ps.executeUpdate();
                       
                    } finally {

                    }
                }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            userGroupInfoPane.setVisible(false);
            userGroupPane.setVisible(false);
            FillUserGroupsVBox();
        }
        else if(event.getSource()==editMyProfileSaveButton){
            try {
                if(!userEditImageImage.getText().isEmpty()){
                    
                    FileInputStream fis = null;
                    PreparedStatement ps = null;
                    String INSERT_PICTURE = "UPDATE `user` SET `userimage`=? WHERE `username`='"+ loginUserName+"'";
                    try {
                      File file = new File(userEditImageImage.getText());
                      fis = new FileInputStream(file);
                      ps = conn.prepareStatement(INSERT_PICTURE);
                      ps.setBinaryStream(1, fis, (int) file.length());
                      ps.executeUpdate();
                       
                    } finally {

                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            userEditImageChoose.setStyle("");
            userEditImageImage.setText("");
            try{
                String emaleold=editEmail.getText();
                Statement stmt = conn.createStatement();
              String sqlstr="select * from `user` where Email ="+"'"+emaleold+"';";
              ResultSet rs1 = stmt.executeQuery(sqlstr);
            if(rs1.next()){
             stmt = conn.createStatement();
             sqlstr="select * from `user` where username ="+"'"+loginUserName+"';";
              ResultSet rs2 = stmt.executeQuery(sqlstr);
              if(rs2.next())
                emaleold= rs2.getString("Email");
            }
            String smrt="UPDATE `user` SET `Gender` = '"+editGender.getValue()
                    +"',`Name`='"+editName.getText()+"',`Birthdate`='"+editBirthdate.getValue()+
                    "',`Email`='"+emaleold
                    +"' WHERE `user`.`username` = '"+loginUserName+"';";
            PreparedStatement preparedStmt = conn.prepareStatement(smrt);
             preparedStmt.executeUpdate();
              
             
            }catch(Exception e){}
        }
        else if(event.getSource()==userGroupInfoChoose){
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            if(file!=null){
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                    if((int)image.getWidth()==(int)image.getHeight()){
                        userGroupInfoImage.setText(file.getPath());
                    }


                } catch (IOException ex) {
                    Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        }
        else if(event.getSource()==userEditImageChoose){
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            if(file!=null){
                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                    if((int)image.getWidth()==(int)image.getHeight()){
                        userEditImageImage.setText(file.getPath());
                        profileImageErrorLabel.setVisible(false);
                        userEditImageChoose.setStyle("-fx-background-color: #DA0037;");
                    }
                    else{
                        userEditImageImage.setText("");
                        profileImageErrorLabel.setVisible(true);
                        userEditImageChoose.setStyle("");
                    }


                } catch (IOException ex) {
                    Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        }
        else if(event.getSource()==userGroupInfoAdd){
            try {
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `username` FROM `user` WHERE `username`='"+userGroupInfoMemberTextField.getText()+"'";
                ResultSet username=stmt.executeQuery(sqlstr);
                if(username.next()){
                    memberUsernameErrorLabel.setVisible(false);
                    Statement stmt2 = conn.createStatement();
                    String sqlstr2="SELECT `username`, `groupid` FROM `user-group` WHERE `username`='"+userGroupInfoMemberTextField.getText()+"' and `groupid`='"+userGroupId.getText()+"'";
                    ResultSet usernameInGroup=stmt2.executeQuery(sqlstr2);
                    if(usernameInGroup.next()){
                        memberUsernameErrorLabel.setText("*Error: The user is already invited to this group");
                        memberUsernameErrorLabel.setVisible(true);
                    }
                    else{
                        memberUsernameErrorLabel.setVisible(false);
                        Statement stmt3 = conn.createStatement();
                        String sqlstr3="INSERT INTO `user-group`( `username`, `groupid`, `userapproverequest`, `adminapproverequest`) VALUES ('"+userGroupInfoMemberTextField.getText()+"','"+userGroupId.getText()+"','0','1')";
                        stmt.executeUpdate(sqlstr3);
                         
                    }
                }
                else{
                    memberUsernameErrorLabel.setText("*Error: Please Enter A Correct Username");
                    memberUsernameErrorLabel.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (event.getSource()==userGroupInfoRequests){
            groupReqBlackPane.setVisible(true);
             fillGroupMembersReqVBox();
        }
        else if (event.getSource()==editDiary){
            if(!showDiaryTitle.getText().equals("") && !showDiaryDate.getText().equals("") && !showDiaryText.getText().equals("") ){
                editDiaryErrorLabel.setVisible(false);
                if(diaryType.equals("note")){
                    int notFix=0;
                    if(editDiaryFix.isSelected())
                         notFix=1;
                    try {
                        Statement stmt = conn.createStatement();
                        String sqlstr="UPDATE `note` SET `Fix Note`='"+notFix+"' WHERE `diaryid`='"+showDiaryId.getText()+"'";
                        stmt.executeUpdate(sqlstr);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try{
                    Statement stmt = conn.createStatement();
                    String sqlstr="UPDATE `diary` SET `Title`='"+showDiaryTitle.getText()+"',`Description`='"+showDiaryText.getText()+"' WHERE `ID`='"+showDiaryId.getText()+"'";
                    stmt.executeUpdate(sqlstr);
                    refreshDiaryVBox();
                } catch (SQLException ex) {
                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else{
                editDiaryErrorLabel.setVisible(true);
            }
        }
        else if (event.getSource()==editNotifications){
                editUserNotifications.clear();
                editnotificationVBox.getChildren().clear();
                editDirayNotificationBlackPane.setVisible(true);
                limitTimeTextField(addEditNotificationMinutes,59);
                limitTimeTextField(addEditNotificationHours,23);
                //set min date of the notification the current date
                LocalDate minDate = LocalDate.now();
                addEditNotificationDate.setDayCellFactory(d ->
                        new DateCell() {
                            @Override public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                setDisable(item.isBefore(minDate));
                            }});
                updateEditnotificationVBox();
                for(int i=0;i<editUserNotifications.size();i++){
                    
                }
            
        }
        else if(event.getSource()==addEditNotification){
            boolean isAdded =false;
                if(!editUserNotifications.isEmpty()){
                    for(int i=0;i<editUserNotifications.size();i++){
                        if(addEditNotificationDate.getValue()!=null && addEditNotificationDate.getValue().toString().equals(editUserNotifications.get(i).notificationDate) && addEditNotificationHours.getText().equals(editUserNotifications.get(i).notificationHour) && addEditNotificationMinutes.getText().equals(editUserNotifications.get(i).notificationMinute)){
                            isAdded =true;
                        }
                    }
                }
                if(editUserNotifications.isEmpty() || !isAdded){
                    if(addEditNotificationDate.getValue()!=null &&!addEditNotificationHours.getText().equals("") && !addEditNotificationMinutes.getText().equals(""))
                    editUserNotifications.add(new Notification(addEditNotificationDate.getValue().toString(),addEditNotificationHours.getText(),addEditNotificationMinutes.getText()));
                    if(editUserNotifications.isEmpty()){
                        try {
                            Statement stmt = conn.createStatement();
                            String sqlstr="INSERT INTO `"+diaryType+"`(`diaryid`, `Notification`) VALUES ('"+showDiaryId.getText()+"','0')";
                            stmt.executeUpdate(sqlstr);
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        try {
                            
                            Statement stmt = conn.createStatement();
                            String sqlstr="INSERT INTO `"+diaryType+"`(`diaryid`, `Notification`) VALUES ('"+showDiaryId.getText()+"','1')";
                            stmt.executeUpdate(sqlstr);
                            Statement stmt1 = conn.createStatement();
                            String sqlstr1="DELETE FROM `usernotification` WHERE `username`='"+loginUserName+"' and `diaryid`='"+showDiaryId.getText()+"'";
                            stmt1.executeUpdate(sqlstr1);
                            for(int i=0;i<editUserNotifications.size();i++){
                                sqlstr="INSERT INTO `usernotification`(`username`, `diaryid`, `datetime`) VALUES ('"+loginUserName+"','"+showDiaryId.getText()+"','"+editUserNotifications.get(i).notificationDate +" "+editUserNotifications.get(i).notificationHour+":"+editUserNotifications.get(i).notificationMinute+":00" +"')";
                                stmt.executeUpdate(sqlstr);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    refreshEditNotificationVBox();
                }
        }
        else if(event.getSource()==userGroupInfoMembers){
            groupMembersBlackPane.setVisible(true);
            FillGroupMembersVBox();
        }
        else if(event.getSource()==userGroupCalender){
            try {
                addMemoryNotification.setDisable(true);
                addEventNotification.setDisable(true);
                addNoteFix.setDisable(true);
                editNotifications.setDisable(true);
                editDiaryFix.setDisable(true);
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `adminusername`, `memberscaneditcalendar` FROM `dms-group` WHERE `groupid`='"+userGroupId.getText()+"'";
                ResultSet membersCandAddDiary=stmt.executeQuery(sqlstr);
                membersCandAddDiary.next();
                if(membersCandAddDiary.getBoolean("memberscaneditcalendar")){
                    groupEditCalendar=true;
                }
                else{
                    if(membersCandAddDiary.getString("adminusername").equals(loginUserName))
                        groupEditCalendar=true;
                    else
                        groupEditCalendar=false;
                }
                if(groupEditCalendar){
                    editDiary.setDisable(false);
                    addNewDiaryButton.setDisable(false);
                }
                else{
                    editDiary.setDisable(true);
                    addNewDiaryButton.setDisable(true);
                } 
                userGroupPane.setVisible(false);
                myGroupsPane.setVisible(false);
                calendarFromGroupPane=true;
                calendarPane.setVisible(true);
                caledarSearchPane.setVisible(true);
                caledarSearchScrollPane.setFitToWidth(true);
                myDiaryScrollPane.setFitToWidth(true);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (event.getSource()==closeCreateInvitationCardSentPane){
            createInvitationCardSentPane.setVisible(false);
            usernameInvErrorText.setVisible(false);
            CreateInvErrorLabel.setVisible(false);
            usernameInvErrorText.setText("Error: receiver username is not correct:");
        }
        else if(event.getSource()==createInvitationCard){
            if(!nameInv.getText().trim().equals("")&&!textInv.getText().trim().equals("")&&!TDInvi.getText().trim().equals("")&&!addressInvi.getText().trim().equals("")&&!streetInv.getText().trim().equals("")&&!placeInv.getText().trim().equals("")&&!usernameInv.getText().trim().equals("")&&!titleInv.getText().trim().equals("")&&!desInv.getText().trim().equals("")){
                CreateInvErrorLabel.setVisible(false);
                    InputStream input;
                    JasperDesign jasperDesign;
                    JasperReport jasperReport;
                    JasperPrint jasperPrint;
                    HashMap dd=new HashMap();
                    try {
                        input=new FileInputStream(new File("src\\diarymanagementsystem\\"+invitationCardName));
                        jasperDesign=JRXmlLoader.load(input);
                       String name=nameInv.getText();
                       String age=textInv.getText();
                       String timeDate=TDInvi.getText();
                       String address=addressInvi.getText();
                       String street=streetInv.getText();
                       String hotel=placeInv.getText();

                       dd.put("name", name);
                       dd.put(invitationCardNameJasper, age);
                       dd.put("timeDate", timeDate);
                       dd.put("address", address);
                       dd.put("street", street);
                       dd.put("hotel", hotel);

                       JRDesignQuery dds=new JRDesignQuery();
                       dds.setText("");
                       jasperDesign.setQuery(dds);
                        jasperReport=JasperCompileManager.compileReport(jasperDesign);

                        jasperPrint=JasperFillManager.fillReport(jasperReport, dd, new JREmptyDataSource());

                        
                        LocalDateTime DTNow = LocalDateTime.now();
                        String formattedDate = DTNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));
                        File file;  
                        file = new File("src\\diarymanagementsystem\\invitations\\MyCard"+formattedDate+".png");
                 OutputStream ouputStream= null; 
                 ouputStream= new FileOutputStream(file);     
                    DefaultJasperReportsContext.getInstance();   
                    JasperPrintManager printManager = JasperPrintManager.getInstance(DefaultJasperReportsContext.getInstance());      

                    BufferedImage rendered_image = null;      
                    rendered_image = (BufferedImage)printManager.printPageToImage(jasperPrint, 0,0.2f); 
                    ImageIO.write(rendered_image, "png", ouputStream); 
                    if(usernameInv.getText().trim().equals("#")){
                        
                    }
                    else{
                        FileInputStream fis = null;
                        PreparedStatement ps = null;
                        //INSERT INTO `invitation`(`title`, `description`, `imagecard`) VALUES ('?','?','?')
                        String INSERT_PICTURE = "INSERT INTO `invitation`(`title`, `description`, `imagecard`) VALUES (?,?,?)";
                        try {
                          
                            System.out.println(file.getPath());
                          File nfile = new File(file.getPath());
                          fis = new FileInputStream(nfile);
                          ps = conn.prepareStatement(INSERT_PICTURE);
                          ps.setString(1, titleInv.getText());
                          ps.setString(2, desInv.getText());
                          ps.setBinaryStream(3, fis, (int) nfile.length());
                          ps.executeUpdate();
                           
                        } finally {

                        }
                        Statement stmt0 = conn.createStatement();
                        String sender=loginUserName;
                        Statement stmt1 = conn.createStatement();
                        String sqlstr1="SELECT `ID` FROM `invitation` WHERE `title`='"+titleInv.getText()+"' and `description`='"+ desInv.getText()+"'order by `ID` desc";
                        ResultSet invId=stmt1.executeQuery(sqlstr1);
                        invId.next();
                        String invUsername[];
                        if(usernameInv.getText().contains(",")){
                        invUsername =usernameInv.getText().trim().split(",");
                        }
                        else{
                            usernameInv.setText(usernameInv.getText().trim()+",");
                            invUsername =usernameInv.getText().trim().split(",");
                        }
                        
                        String invalidUsers="";
                        for(int i=0;i<invUsername.length;i++){
                            //SELECT  `username` FROM `user` WHERE 1
                            if(!invUsername[i].trim().equals("")){
                                Statement stmt = conn.createStatement();
                                String sqlstr="SELECT  `username` FROM `user` WHERE `username`='"+invUsername[i].trim()+"'";
                                ResultSet username=stmt.executeQuery(sqlstr);
                                if(username.next()){
                                    
                                    Statement stmt3 = conn.createStatement();
                                    String sqlstr3="INSERT INTO `send-invitation`( `invitationid`, `senderusername`, `receiverusername`, `date`) VALUES ('"+invId.getInt("ID")+"','"+sender+"','"+username.getString("username")+"','"+formattedDate+"')";
                                    stmt3.executeUpdate(sqlstr3);
                                    System.out.println(sqlstr3);
                                }
                                else{
                                    invalidUsers+=invUsername[i].trim()+",";
                                }
                            }
                            else{
                                usernameInvErrorText.setText("Please dont leave any user name Blank");
                                usernameInvErrorText.setVisible(true);
                                createInvitationCardSentPane.setVisible(true);
                            }
                            
                        }
                        if(invalidUsers.length()!=0){
                            usernameInvErrorText.setText("Error: receiver username is not correct:"+invalidUsers);
                            usernameInvErrorText.setVisible(true);
                            createInvitationCardSentPane.setVisible(true);
                        }
                        else{
                            usernameInvErrorText.setText("Error: receiver username is not correct:");
                            usernameInvErrorText.setVisible(false);
                            createInvitationCardSentPane.setVisible(true);
                        }
                        
                    }
                    
                    

                    ////////
                        JFrame frame = new JFrame("Chocolat Report");
                        frame.getContentPane().add(new JRViewer(jasperPrint));
                        frame.pack();
                        frame.setVisible(true);
                        frame.setSize(900, 750);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                createInvitationCardPane.setVisible(false);
                nameInv.setText("");
                textInv.setText("");
                TDInvi.setText("");
                addressInvi.setText("");
                streetInv.setText("");
                placeInv.setText("");
                usernameInv.setText("");
                titleInv.setText("");
                desInv.setText("");
            }
            else{
                CreateInvErrorLabel.setVisible(true);
            }
        }
        
        
        
    }
    
    private void updateEditnotificationVBox(){
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `username`, `diaryid`, `datetime` FROM `usernotification` WHERE `username`='"+loginUserName+"' and `diaryid`='"+showDiaryId.getText()+"';";
            ResultSet editUserNotificationsSQL=stmt.executeQuery(sqlstr);
            while(editUserNotificationsSQL.next()){
                String []t=editUserNotificationsSQL.getTime("datetime").toString().split(":");
                editUserNotifications.add(new Notification(editUserNotificationsSQL.getDate("datetime").toString(),t[0],t[1],editUserNotificationsSQL.getString("diaryid"),editUserNotificationsSQL.getString("username")));
            }
            refreshEditNotificationVBox();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void refreshEditNotificationVBox(){
        
        editnotificationVBox.getChildren().clear();
        for(int i=0;i<editUserNotifications.size();i++){
            final int ii = i;
            String notiHour =valueOf(editUserNotifications.get(i).notificationHour) ;
            String notiMinute =valueOf(editUserNotifications.get(i).notificationMinute) ;
            AnchorPane a=new AnchorPane();
            a.setStyle("-fx-pref-width:500px; -fx-pref-height:70px; -fx-border-color:#DA0037");
            
            Label notificationDT = new Label(editUserNotifications.get(i).notificationDate+"\t"+notiHour+":"+notiMinute);
            notificationDT.setStyle("-fx-font-size: 20px;");
            a.getChildren().add(notificationDT);
            a.setTopAnchor(notificationDT, 10.0);
            a.setBottomAnchor(notificationDT, 10.0);
            a.setLeftAnchor(notificationDT, 10.0);
            Label deleteNotification = new Label("X");//delete date
            deleteNotification.setOnMouseClicked((mouseEvent) -> {
                    editUserNotifications.remove(ii);
                    refreshEditNotificationVBox();
                
            });
            deleteNotification.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
            a.getChildren().add(deleteNotification);
            a.setTopAnchor(deleteNotification, 10.0);
            a.setBottomAnchor(deleteNotification, 10.0);
            a.setRightAnchor(deleteNotification, 20.0);
            editnotificationVBox.getChildren().add(a);
        }
    }
    private void fillGroupMembersReqVBox(){
         groupReqVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `username` FROM `user-group` WHERE `groupid`='"+userGroupId.getText()+"' and `adminapproverequest`='0'";
            ResultSet usernameReqGroup=stmt.executeQuery(sqlstr);
            while(usernameReqGroup.next()){
                AnchorPane a=new AnchorPane();
                a.setStyle("-fx-pref-width:500px; -fx-pref-height:50px; -fx-border-color:transparent transparent #DA0037 transparent ; -fx-background-color:#d1d1d1;");
                Label gUserName = new Label(usernameReqGroup.getString("username"));
                final String userName = usernameReqGroup.getString("username");
                gUserName.setStyle("-fx-font-size: 20px;");
                a.getChildren().add(gUserName);
                a.setTopAnchor(gUserName, 10.0);
                a.setLeftAnchor(gUserName, 10.0);
                Label deleteReq = new Label("Remove");//delete date
                deleteReq.setOnMouseClicked((mouseEvent) -> {
                    try {
                        Statement stmt2 = conn.createStatement();
                        String sqlstr2="DELETE FROM `user-group` WHERE `username`='"+userName+"' and `groupid`='"+userGroupId.getText()+"';";
                        stmt2.executeUpdate(sqlstr2);
                        fillGroupMembersReqVBox();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                deleteReq.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
                a.getChildren().add(deleteReq);
                a.setTopAnchor(deleteReq, 10.0);
                a.setRightAnchor(deleteReq, 20.0);
                Label approveReq = new Label("approve");
                approveReq.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
                a.getChildren().add(approveReq);
                a.setTopAnchor(approveReq, 10.0);
                a.setRightAnchor(approveReq, 100.0);
                approveReq.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent t) {
                        try {
                            Statement stmt3 = conn.createStatement();
                            String sqlstr3="UPDATE `user-group` SET `adminapproverequest`='1' WHERE `username`='"+userName+"';";
                            stmt3.executeUpdate(sqlstr3);
                            fillGroupMembersReqVBox();
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
                groupReqVBox.getChildren().add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void updateUserNotifications() {
        try {
            userNotifications.clear();
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `username`, `diaryid`, `datetime` FROM `usernotification` WHERE username ='"+loginUserName+"' ORDER BY datetime asc;";
            ResultSet diaryID=stmt.executeQuery(sqlstr);
            while(diaryID.next()){
                String []t=diaryID.getTime("datetime").toString().split(":");
                userNotifications.add(new Notification(diaryID.getDate("datetime").toString(),t[0],t[1],diaryID.getString("diaryid"),diaryID.getString("username")));
            }
            diaryID.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateUserDiary() {
        try {
            if(!calendarFromGroupPane){
                userDiary.clear();
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT diary.ID, diary.Title, diary.Description, diary.Date, `user-calendar`.`username` FROM `diary`, `user-calendar` WHERE `user-calendar`.`diaryid` = diary.ID AND `USER-calendar`.`username` = '"+loginUserName+"' and diary.Date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER by diary.ID DESC;";
                ResultSet diaryID=stmt.executeQuery(sqlstr);
                while(diaryID.next()){
                    userDiary.add(new Diary(diaryID.getString("ID"),diaryID.getString("Title"),diaryID.getString("Description"),diaryID.getDate("Date").toString()));
                }
                diaryID.close();
            }
            else{
                userDiary.clear();
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT diary.ID, diary.Title, diary.Description, diary.Date,  `group-calender`.`groupid` FROM `diary`, `group-calender` WHERE `group-calender`.`Diaryid` = diary.ID AND `group-calender`.`groupid` = '"+userGroupId.getText()+"' and diary.Date='"+yearDate+"-"+monthDate+"-"+dayDate+"' ORDER by diary.ID DESC;";
                ResultSet diaryID=stmt.executeQuery(sqlstr);
                while(diaryID.next()){
                    userDiary.add(new Diary(diaryID.getString("ID"),diaryID.getString("Title"),diaryID.getString("Description"),diaryID.getDate("Date").toString()));
                }
                diaryID.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void refreshDiaryVBox() {
        
        updateUserDiary();
        myDiaryVBox.getChildren().clear();
        for(int i=0;i<userDiary.size();i++){
            final int ii = i;
            AnchorPane a=new AnchorPane();
            a.setStyle("-fx-pref-width:896px; -fx-pref-height:100px; -fx-border-color:#DA0037; -fx-background-color:#d1d1d1;");
            Label diaryTitle = new Label(userDiary.get(i).Title);
            diaryTitle.setStyle("-fx-font-size: 20px;-fx-cursor: hand;");
            a.getChildren().add(diaryTitle);
            a.setTopAnchor(diaryTitle, 10.0);
            a.setLeftAnchor(diaryTitle, 10.0);
            Label deleteDiary = new Label("Delete");//delete date
            
            deleteDiary.setOnMouseClicked((mouseEvent) -> {
                try {
                    
                    Statement stmt = conn.createStatement();
                    String sqlstr="DELETE FROM `diary` WHERE ID='"+userDiary.get(ii).ID+"';";
                    stmt.executeUpdate(sqlstr);
                    userDiary.remove(ii);
                    refreshDiaryVBox();
                    updateUserDiary();
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            deleteDiary.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
            a.getChildren().add(deleteDiary);
            a.setTopAnchor(deleteDiary, 30.0);
            a.setRightAnchor(deleteDiary, 20.0);
            Label EditDiary = new Label("Edit");//delete date
            EditDiary.setOnMouseClicked((mouseEvent) -> {
                showDiaryBlackPane.setVisible(true);
                showDiaryTitle.setText(userDiary.get(ii).Title);
                showDiaryDate.setText(userDiary.get(ii).Date);
                showDiaryText.setText(userDiary.get(ii).Description);
                showDiaryId.setText(userDiary.get(ii).ID);
                showDiaryTitle.setEditable(true);
                    showDiaryText.setEditable(true);
                    editDiary.setVisible(true);
                editDiary();
            });
            EditDiary.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
            a.getChildren().add(EditDiary);
            a.setTopAnchor(EditDiary, 30.0);
            a.setRightAnchor(EditDiary, 100.0);
            if(!groupEditCalendar&&calendarFromGroupPane){
                deleteDiary.setDisable(true);
                EditDiary.setDisable(true);
            }
            else{
                deleteDiary.setDisable(false);
                EditDiary.setDisable(false);
            }
            diaryTitle.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent t) {
                    showDiaryBlackPane.setVisible(true);
                    showDiaryTitle.setText(userDiary.get(ii).Title);
                    showDiaryDate.setText(userDiary.get(ii).Date);
                    showDiaryText.setText(userDiary.get(ii).Description);
                    showDiaryId.setText(userDiary.get(ii).ID);
                    showDiaryTitle.setEditable(false);
                    showDiaryText.setEditable(false);
                    editDiary.setVisible(false);
                }

            });
            myDiaryVBox.getChildren().add(a);
        }
    }
    public void SearchOnDiaryData(){
        calendarSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updatAllUserDiary();
            caledarSearchVBox.getChildren().clear();
            if(newValue == null || newValue.isEmpty()){
                caledarSearchVBox.getChildren().clear();
                return;
            }
            for(int i =0;i<allUserDiary.size();i++){
                if(allUserDiary.get(i).Description.toLowerCase().contains(calendarSearchTextField.getText().toLowerCase()) || allUserDiary.get(i).Title.toLowerCase().contains(calendarSearchTextField.getText().toLowerCase())){
                    updateUserDiary();
                        final int ii = i;
                        AnchorPane a=new AnchorPane();
                        a.setStyle("-fx-pref-width:896px; -fx-pref-height:100px; -fx-border-color:#DA0037; -fx-background-color:#d1d1d1;-fx-background-radius: 10px;-fx-border-radius: 10px;");
                        Label diaryTitle = new Label(allUserDiary.get(i).Title);
                        diaryTitle.setStyle("-fx-font-size: 20px;-fx-cursor: hand;");
                        a.getChildren().add(diaryTitle);
                        a.setTopAnchor(diaryTitle, 10.0);
                        a.setLeftAnchor(diaryTitle, 10.0);
                        Label diaryDate = new Label(allUserDiary.get(i).Date);
                        diaryTitle.setStyle("-fx-font-size: 20px;");
                        a.getChildren().add(diaryDate);
                        a.setBottomAnchor(diaryDate, 10.0);
                        a.setLeftAnchor(diaryDate, 30.0);
                        diaryTitle.setOnMouseClicked(new EventHandler<MouseEvent>(){
                            @Override
                            public void handle(MouseEvent t) {
                                showDiaryBlackPane.setVisible(true);
                                showDiaryTitle.setText(allUserDiary.get(ii).Title);
                                showDiaryDate.setText(allUserDiary.get(ii).Date);
                                showDiaryText.setText(allUserDiary.get(ii).Description);
                                showDiaryId.setText(allUserDiary.get(ii).ID);
                                showDiaryTitle.setEditable(false);
                                showDiaryText.setEditable(false);
                                editDiary.setVisible(false);
                            }

                        });
                        caledarSearchVBox.getChildren().add(a);
                    
                }
                    
            }
        });
    }
    private void editDiary(){//action for the button
            try {
                
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT  `Notification` FROM `memory` WHERE `diaryid`='"+showDiaryId.getText()+"'";
                ResultSet editDiary=stmt.executeQuery(sqlstr);
                if(editDiary.next()){
                    editNotifications.setVisible(true);
                    diaryType="memory";
                }
                else {
                    Statement stmt2 = conn.createStatement();
                    String sqlstr2="SELECT  `Notification` FROM `event` WHERE `diaryid`='"+showDiaryId.getText()+"'";
                    ResultSet editDiary2=stmt2.executeQuery(sqlstr2);
                    if(editDiary2.next()){
                        editNotifications.setVisible(true);
                        diaryType="event";
                    }
                    else{
                        editDiaryFix.setVisible(true);
                        Statement stmt3 = conn.createStatement();
                        String sqlstr3="SELECT `Fix Note` FROM `note` WHERE `diaryid`='"+showDiaryId.getText()+"'";
                        ResultSet editDiary3=stmt3.executeQuery(sqlstr3);
                        editDiary3.next();
                        
                        if(editDiary3.getInt("Fix Note")==1){
                            editDiaryFix.setSelected(true);
                            diaryType="note";
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
    }

    public void SearchOnPublicGroups(){
        publicGroupsSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                publicGroupVBox.getChildren().clear();
                if(newValue == null || newValue.isEmpty()){
                    publicGroupVBox.getChildren().clear();
                    return;
                }
                if(publicGroupsSearchTextField.getText().length()>4){
                    Statement stmt = conn.createStatement();
                    String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group` WHERE `name` LIKE '%"+publicGroupsSearchTextField.getText()+"%' or `description` LIKE '%"+publicGroupsSearchTextField.getText()+"%' or `groupid` LIKE '%"+publicGroupsSearchTextField.getText()+"%' and `attributeprivicy`='1' and `adminusername` <> '"+loginUserName+"'";
                    ResultSet publicGroups=stmt.executeQuery(sqlstr);
                    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    String sqlstr2="SELECT `id`, `username`, `groupid`, `userapproverequest`, `adminapproverequest` FROM `user-group` WHERE `username`='"+loginUserName+"'";
                    ResultSet userGroups=stmt2.executeQuery(sqlstr2);
                    while(publicGroups.next()){
                        boolean notHisGroup= true;
                        while(userGroups.next()){
                            if(publicGroups.getString("groupid").equals(userGroups.getString("groupid"))){
                                notHisGroup= false;
                            }
                        }
                        userGroups.beforeFirst();
                        if(notHisGroup){
                            AnchorPane a=new AnchorPane();
                            a.setStyle("-fx-pref-width:1000px; -fx-pref-height:100px; -fx-border-color:transparent transparent #DA0037 transparent; -fx-background-color:#BCBCBC;");
                            Label groupName = new Label(publicGroups.getString("name"));
                            groupName.setStyle("-fx-font-size: 20px;");
                            a.getChildren().add(groupName);
                            a.setTopAnchor(groupName, 10.0);
                            a.setLeftAnchor(groupName, 100.0);
                            Label GroupID = new Label(publicGroups.getString("groupid"));
                            GroupID.setStyle("-fx-font-size: 12px; -fx-text-fill: gray");
                            a.getChildren().add(GroupID);
                            a.setTopAnchor(GroupID, 40.0);
                            a.setLeftAnchor(GroupID, 120.0);
                            Label joinGroup = new Label("Join");
                            joinGroup.setStyle("-fx-font-size: 20px; -fx-text-fill: #DA0037;-fx-cursor: hand;");
                            a.getChildren().add(joinGroup);
                            a.setTopAnchor(joinGroup, 30.0);
                            a.setRightAnchor(joinGroup, 120.0);
                            joinGroup.setOnMouseClicked(new EventHandler<MouseEvent>(){
                                @Override
                                public void handle(MouseEvent t) {
                                    try {
                                        Statement stmt = conn.createStatement();
                                        String sqlstr="INSERT INTO `user-group`(`username`, `groupid`, `userapproverequest`, `adminapproverequest`) VALUES ('"+loginUserName+"','"+GroupID.getText()+"','1','0');";
                                        stmt.executeUpdate(sqlstr);
                                        publicGroupVBox.getChildren().clear();
                                        SearchOnPublicGroups();
                                        FillUserGroupsVBox();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            });
                            publicGroupVBox.getChildren().add(a);
                    }
                    }
                    publicGroups.close();
                    userGroups.close();
                }
            } catch (SQLException ex) {                    
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    private void FillUserGroupsVBox(){
        userGroupsSearchVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group`";
            ResultSet publicGroups=stmt.executeQuery(sqlstr);
            Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sqlstr2="SELECT `id`, `username`, `groupid`, `userapproverequest`, `adminapproverequest` FROM `user-group` WHERE `username`='"+loginUserName+"' and `userapproverequest`='1' and `adminapproverequest`='1'";
            ResultSet userGroups=stmt2.executeQuery(sqlstr2);
            while(publicGroups.next()){
                boolean notHisGroup= false;
                while(userGroups.next()){
                    if(publicGroups.getString("groupid").equals(userGroups.getString("groupid"))){
                        notHisGroup= true;
                    }
                }
                userGroups.beforeFirst();
                if(notHisGroup){
                    
                    AnchorPane a=new AnchorPane();
                    a.setStyle("-fx-pref-width:330px; -fx-pref-height:70px; -fx-border-color: transparent transparent #DA0037 transparent ; -fx-background-color:#BCBCBC;");
                    Label groupName = new Label(publicGroups.getString("name"));
                    groupName.setStyle("-fx-font-size: 20px;-fx-cursor: hand;");
                    a.getChildren().add(groupName);
                    a.setTopAnchor(groupName, 10.0);
                    a.setLeftAnchor(groupName, 10.0);
                    Label GroupID = new Label("@"+publicGroups.getString("groupid"));
                    GroupID.setStyle("-fx-font-size: 12px; -fx-text-fill: gray");
                    a.getChildren().add(GroupID);
                    a.setTopAnchor(GroupID, 40.0);
                    a.setLeftAnchor(GroupID, 30.0);
                    String gName=publicGroups.getString("name");
                    String gId=publicGroups.getString("groupid");
                    InputStream input;
                    input = publicGroups.getBinaryStream("imagegroup");

                
                    groupName.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent t) {
                            try {
                                userGroupName.setText(gName);
                                userGroupId.setText(gId);
                                if (input != null && input.available() > 1) {
                                    Image imge = new Image(input);
                                    userGroupImage.setImage(imge);
                                }
                                OpenUserGroup();
                                Statement stmt = conn.createStatement();
                                String sqlstr="SELECT `adminusername`, `memberscansendmessage` FROM `dms-group` WHERE `groupid`='"+userGroupId.getText()+"'";
                                ResultSet membersCandSendMessages=stmt.executeQuery(sqlstr);
                                membersCandSendMessages.next();
                                if(membersCandSendMessages.getBoolean("memberscansendmessage")){
                                    groupSendMessagePane.setDisable(false);
                                }
                                else{
                                    if(membersCandSendMessages.getString("adminusername").equals(loginUserName))
                                        groupSendMessagePane.setDisable(false);
                                    else{
                                        groupSendMessagePane.setDisable(true);
                                        System.out.println("6532");
                                    }
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                        }
                        
                    });
                    userGroupsSearchVBox.getChildren().add(a);
                    
                    
                }
            }
            publicGroups.close();
            userGroups.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void SearchOnUserGroups(){
        FillUserGroupsVBox();
        userGroupsSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                userGroupsSearchVBox.getChildren().clear();
                if(newValue == null || newValue.isEmpty()){
                    FillUserGroupsVBox();
                    return;
                }
                if(userGroupsSearchTextField.getText().length()>4){
                    userGroupsSearchVBox.getChildren().clear();
                    Statement stmt = conn.createStatement();
                    String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group` WHERE `name` LIKE '%"+userGroupsSearchTextField.getText()+"%' or `description` LIKE '%"+userGroupsSearchTextField.getText()+"%' or `groupid` LIKE '%"+userGroupsSearchTextField.getText()+"%' ";
                    ResultSet publicGroups=stmt.executeQuery(sqlstr);
                    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    String sqlstr2="SELECT `id`, `username`, `groupid`, `userapproverequest`, `adminapproverequest` FROM `user-group` WHERE `username`='"+loginUserName+"' and `userapproverequest`='1' and  `adminapproverequest`='1'";
                    ResultSet userGroups=stmt2.executeQuery(sqlstr2);
                    while(publicGroups.next()){
                        boolean notHisGroup= false;
                        while(userGroups.next()){
                            if(publicGroups.getString("groupid").equals(userGroups.getString("groupid"))){
                                notHisGroup= true;
                            }
                        }
                        userGroups.beforeFirst();
                        if(notHisGroup){
                            
                            AnchorPane a=new AnchorPane();
                            a.setStyle("-fx-pref-width:330px; -fx-pref-height:60px; -fx-border-color:transparent transparent #DA0037 transparent; -fx-background-color:#BCBCBC;");
                            Label groupName = new Label(publicGroups.getString("name"));
                            groupName.setStyle("-fx-font-size: 20px;-fx-cursor: hand;");
                            a.getChildren().add(groupName);
                            a.setTopAnchor(groupName, 10.0);
                            a.setLeftAnchor(groupName, 10.0);
                            Label GroupID = new Label("@"+publicGroups.getString("groupid"));
                            GroupID.setStyle("-fx-font-size: 12px; -fx-text-fill: gray");
                            a.getChildren().add(GroupID);
                            a.setTopAnchor(GroupID, 40.0);
                            a.setLeftAnchor(GroupID, 30.0);
                            String gName=publicGroups.getString("name");
                            String gId=publicGroups.getString("groupid");
                            InputStream input;
                            input = publicGroups.getBinaryStream("imagegroup");

                            groupName.setOnMouseClicked(new EventHandler<MouseEvent>(){
                                @Override
                                public void handle(MouseEvent t) {
                                    try {
                                        userGroupName.setText(gName);
                                        userGroupId.setText(gId);
                                        if (input != null && input.available() > 1) {
                                            System.out.println("image available");
                                            Image imge = new Image(input);
                                            userGroupImage.setImage(imge);

                                        }
                                        OpenUserGroup();
                                        Statement stmt = conn.createStatement();
                                        String sqlstr="SELECT `adminusername`, `memberscansendmessage` FROM `dms-group` WHERE `groupid`='"+userGroupId.getText()+"'";
                                        ResultSet membersCandSendMessages=stmt.executeQuery(sqlstr);
                                        membersCandSendMessages.next();
                                        if(membersCandSendMessages.getBoolean("memberscansendmessage")){
                                            groupSendMessagePane.setDisable(false);
                                        }
                                        else{
                                            if(membersCandSendMessages.getString("adminusername").equals(loginUserName))
                                                groupSendMessagePane.setDisable(false);
                                            else{
                                                groupSendMessagePane.setDisable(true);
                                                System.out.println("6532");
                                            }
                                        }
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            });
                            userGroupsSearchVBox.getChildren().add(a);

                        
                    }
                    }
                    publicGroups.close();
                    userGroups.close();
                    
                }
            } catch (SQLException ex) {                    
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
    private void OpenUserGroup(){
        groupPane.setVisible(false);
        FillGroupMessagesVBox();
        userGroupPane.setVisible(true);
        userGroupMessagesPane.setVisible(true);
        userGroupInfoPane.setVisible(false);
        
        roundImage(userGroupImage,50,50);
        
    }
    private void updatAllUserDiary() {
        
        try {
            if(!calendarFromGroupPane){
                allUserDiary.clear();
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT diary.ID, diary.Title, diary.Description, diary.Date, `user-calendar`.`username` FROM `diary`, `user-calendar` WHERE `user-calendar`.`diaryid` = diary.ID AND `USER-calendar`.`username` = '"+loginUserName+"' ORDER by diary.ID DESC;";
                ResultSet diaryID=stmt.executeQuery(sqlstr);
                while(diaryID.next()){
                    allUserDiary.add(new Diary(diaryID.getString("ID"),diaryID.getString("Title"),diaryID.getString("Description"),diaryID.getDate("Date").toString()));
                }
                diaryID.close();
            }
            else{
                allUserDiary.clear();
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT diary.ID, diary.Title, diary.Description, diary.Date, `group-calender`.`groupid` FROM `diary`, `group-calender` WHERE `group-calender`.`Diaryid` = diary.ID AND `group-calender`.`groupid` = '"+userGroupId.getText()+"' ORDER by diary.ID DESC;";
                ResultSet diaryID=stmt.executeQuery(sqlstr);
                while(diaryID.next()){
                    allUserDiary.add(new Diary(diaryID.getString("ID"),diaryID.getString("Title"),diaryID.getString("Description"),diaryID.getDate("Date").toString()));
                }
                diaryID.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openuserGroupInfoPane(MouseEvent event) {
        userGroupInfoPane.setVisible(true);
        userGroupMessagesPane.setVisible(false);
        FillGroupAdminList();
        boolean isAdmin=false;
        for(int i=0;i<userGroupsAdminIds.size();i++){
            if(userGroupsAdminIds.get(i).equals(userGroupId.getText()))
                isAdmin=true;
        }
        if(!isAdmin){
            try {
                userGroupInfoChoose.setVisible(false);
                userGroupInfoAdd.setVisible(false);
                userGroupInfoMemberTextField.setVisible(false);
                userGroupInfoAdd.setVisible(false);
                userGroupInfoAddText.setVisible(false);
                userGroupInfoEdit.setVisible(false);
                userGroupInfoRequests.setVisible(false);
                userGroupInfoImageText.setVisible(false);
                userGroupInfoName.setEditable(false);
                userGroupInfoId.setEditable(false);
                userGroupInfoDescription.setEditable(false);
                userGroupInfoPrivicy.setDisable(true);
                userGroupInfoSendMessages.setDisable(true);
                userGroupInfoAddDiary.setDisable(true);
                userGroupInfoMembers.setVisible(false);
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group` where `groupid`='"+userGroupId.getText()+"'";
                ResultSet userGroups=stmt.executeQuery(sqlstr);
                userGroups.next();
                userGroupInfoName.setText(userGroups.getString("name"));
                userGroupInfoId.setText(userGroups.getString("groupid"));
                userGroupInfoDescription.setText(userGroups.getString("description"));
                userGroupInfoPrivicy.getItems().clear();
                userGroupInfoPrivicy.getItems().addAll("Public", "Private");
                if(userGroups.getInt("attributeprivicy") == 0){
                    userGroupInfoPrivicy.getSelectionModel().select(1);
                }
                else
                    userGroupInfoPrivicy.getSelectionModel().select(0);
                if(userGroups.getInt("memberscansendmessage") == 1)
                    userGroupInfoSendMessages.selectedProperty().setValue(true);
                if(userGroups.getInt("memberscaneditcalendar") == 1)
                    userGroupInfoAddDiary.selectedProperty().setValue(true);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                
                userGroupInfoChoose.setVisible(true);
                userGroupInfoAdd.setVisible(true);
                userGroupInfoMemberTextField.setVisible(true);
                userGroupInfoAdd.setVisible(true);
                userGroupInfoAddText.setVisible(true);
                userGroupInfoEdit.setVisible(true);
                userGroupInfoRequests.setVisible(true);
                userGroupInfoImageText.setVisible(true);
                userGroupInfoName.setEditable(true);
                userGroupInfoId.setEditable(false);
                userGroupInfoDescription.setEditable(true);
                userGroupInfoPrivicy.setDisable(false);
                userGroupInfoSendMessages.setDisable(false);
                userGroupInfoAddDiary.setDisable(false);
                userGroupInfoMembers.setVisible(true);
                Statement stmt = conn.createStatement();
                String sqlstr="SELECT `groupid`, `name`, `adminusername`, `description`, `imagegroup`, `memberscansendmessage`, `memberscaneditcalendar`, `attributeprivicy` FROM `dms-group` where `groupid`='"+userGroupId.getText()+"'";
                ResultSet userGroups=stmt.executeQuery(sqlstr);
                userGroups.next();
                userGroupInfoName.setText(userGroups.getString("name"));
                userGroupInfoId.setText(userGroups.getString("groupid"));
                userGroupInfoDescription.setText(userGroups.getString("description"));
                userGroupInfoPrivicy.getItems().clear();
                userGroupInfoPrivicy.getItems().addAll("Public", "Private");
                if(userGroups.getInt("attributeprivicy") == 0){
                    userGroupInfoPrivicy.getSelectionModel().select(1);
                }
                else
                    userGroupInfoPrivicy.getSelectionModel().select(0);
                if(userGroups.getInt("memberscansendmessage") == 1)
                    userGroupInfoSendMessages.selectedProperty().setValue(true);
                if(userGroups.getInt("memberscaneditcalendar") == 1)
                    userGroupInfoAddDiary.selectedProperty().setValue(true);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void FillGroupAdminList() {
        try {
            userGroupsAdminIds.clear();
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `groupid`,`adminusername` FROM `dms-group` WHERE `adminusername`='"+loginUserName+"'";
            ResultSet userAdminGroups=stmt.executeQuery(sqlstr);
            while(userAdminGroups.next()){
                userGroupsAdminIds.add(userAdminGroups.getString("groupid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openEditDiaryPane() {
        
    }

    private void FillGroupMembersVBox() {
        try {
            groupMembersVBox.getChildren().clear();
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT  `username`, `groupid`, `userapproverequest`, `adminapproverequest` FROM `user-group` WHERE `groupid`='"+userGroupId.getText()+"' and `adminapproverequest`='1' and `username`<>'"+loginUserName+"'";
            ResultSet groupMembers=stmt.executeQuery(sqlstr);
            while(groupMembers.next()){
                String memberType;
                if(groupMembers.getBoolean("userapproverequest")){
                    memberType="Member";
                }
                else{
                    memberType="invited";
                }
                AnchorPane a=new AnchorPane();
                a.setStyle("-fx-pref-width:500px; -fx-pref-height:70px; -fx-border-color:transparent transparent #DA0037 transparent ; -fx-background-color:#d1d1d1;");
                Label gUserName = new Label(groupMembers.getString("username"));
                final String userName = groupMembers.getString("username");
                gUserName.setStyle("-fx-font-size: 20px;");
                a.getChildren().add(gUserName);
                a.setTopAnchor(gUserName, 10.0);
                a.setLeftAnchor(gUserName, 10.0);
                Label deleteMember = new Label("Remove");//delete date
                deleteMember.setOnMouseClicked((mouseEvent) -> {
                    try {
                        Statement stmt2 = conn.createStatement();
                        String sqlstr2="DELETE FROM `user-group` WHERE `username`='"+userName+"' and `groupid`='"+userGroupId.getText()+"';";
                        stmt2.executeUpdate(sqlstr2);
                        FillGroupMembersVBox();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                deleteMember.setStyle("-fx-text-fill:#DA0037; -fx-font-size: 20px; -fx-cursor: hand;");
                a.getChildren().add(deleteMember);
                a.setTopAnchor(deleteMember, 10.0);
                a.setRightAnchor(deleteMember, 20.0);
                Label memType = new Label(memberType);
                memType.setStyle("-fx-text-fill:gray; -fx-font-size: 12px; ");
                a.getChildren().add(memType);
                a.setTopAnchor(memType, 40.0);
                a.setLeftAnchor(memType, 20.0);
                
                groupMembersVBox.getChildren().add(a);

        }
    } catch (SQLException ex) {
        Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void sendGroupMessage(ActionEvent event) {
        sendGroupMessageText.setText(sendGroupMessageText.getText().trim());
        if(!sendGroupMessageText.getText().equals("")){
            try {
                LocalDateTime DTNow = LocalDateTime.now();
                String formattedDate = DTNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
                Statement stmt = conn.createStatement();
                String sqlstr="INSERT INTO `group-messages`( `groupid`, `senderusername`, `text`, `sendingdate`) VALUES ('"+userGroupId.getText()+"','"+loginUserName+"','"+sendGroupMessageText.getText()+"','"+formattedDate+"');";
                stmt.executeUpdate(sqlstr);
                sendGroupMessageText.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FillGroupMessagesVBox();
    }

    private void FillGroupMessagesVBox() {
        groupMessagesVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `groupid`, `senderusername`, `text`, `sendingdate` FROM `group-messages` WHERE `groupid`='"+userGroupId.getText()+"'  ORDER BY `sendingdate` asc;";
            ResultSet groupMessages=stmt.executeQuery(sqlstr);
            String backGroundColor;
            while(groupMessages.next()){
                if(groupMessages.getString("senderusername").equals(loginUserName)){
                    backGroundColor="-fx-background-color:#DA0037;";
                }
                else
                    backGroundColor="-fx-background-color:white;";
                AnchorPane b=new AnchorPane();
                b.setStyle("-fx-pref-width:1090px; ");
                AnchorPane a=new AnchorPane();
                b.getChildren().add(a);
                a.setStyle("-fx-pref-width:500px; -fx-min-height:50px;  -fx-background-radius:10px; -fx-border-radius:10px;"+backGroundColor);
                Text message = new Text(groupMessages.getString("text"));
                message.setWrappingWidth(450);
                if(groupMessages.getString("senderusername").equals(loginUserName)){
                    b.setTopAnchor(a, 5.0);
                    b.setRightAnchor(a, 5.0);
                    b.setBottomAnchor(a, 5.0);
                    a.setTopAnchor(message, 10.0);
                    a.setBottomAnchor(message, 10.0);
                    a.setRightAnchor(message, 20.0);
                    message.setStyle("-fx-font-size: 20px;");
                    message.setFill(Color.WHITE);
                }
                else{
                    message.setStyle("-fx-text-fill:black;-fx-font-size: 20px;");
                    b.setTopAnchor(a, 5.0);
                    b.setLeftAnchor(a, 5.0);
                    b.setBottomAnchor(a, 5.0);
                    Label userName = new Label(groupMessages.getString("senderusername"));
                    userName.setStyle("-fx-font-size: 25px; -fx-text-fill: #DA0037;");
                    a.getChildren().add(userName);
                    a.setTopAnchor(userName, 5.0);
                    a.setLeftAnchor(userName, 20.0);
                    a.setTopAnchor(message, 40.0);
                    a.setBottomAnchor(message, 5.0);
                    a.setLeftAnchor(message, 20.0);
                }
                a.getChildren().add(message);
                groupMessagesVBox.getChildren().add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        groupMessagesScrollPane.vvalueProperty().bind(groupMessagesVBox.heightProperty());
        groupMessagesScrollPane.setFitToWidth(true);
    }

    @FXML
    private void invitationButtonsAction(ActionEvent event) {
        if(event.getSource()==p1){invitationCardName="party1.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==p2){invitationCardName="party22.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==p3){invitationCardName="party33.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==p4){invitationCardName="party4.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==p5){invitationCardName="party5.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==p6){invitationCardName="party6.jrxml";invitationCardNameJasper="event";createInvitationCardPane.setVisible(true);textInvLabel.setText("Eevent description:");}
        if(event.getSource()==b1){invitationCardName="birth1.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==b2){invitationCardName="birth2.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==b3){invitationCardName="birth3.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==b4){invitationCardName="birth4.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==b5){invitationCardName="birth5.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==b6){invitationCardName="birth6.jrxml";invitationCardNameJasper="age";createInvitationCardPane.setVisible(true);textInvLabel.setText("Age:");}
        if(event.getSource()==w1){invitationCardName="wedding1.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
        if(event.getSource()==w2){invitationCardName="wedding2.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
        if(event.getSource()==w3){invitationCardName="wedding3.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
        if(event.getSource()==w4){invitationCardName="wedding4.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
        if(event.getSource()==w5){invitationCardName="wedding5.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
        if(event.getSource()==w6){invitationCardName="wedding6.jrxml";invitationCardNameJasper="name2";createInvitationCardPane.setVisible(true);textInvLabel.setText("Name2:");}
    }

    private void fillShowCardsVBox() {
        showCardsVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `id`, `invitationid`, `senderusername`, `receiverusername`, `date` FROM `send-invitation` WHERE `senderusername`='"+loginUserName+"' group by `invitationid`;";
            ResultSet userInv=stmt.executeQuery(sqlstr);
            while(userInv.next()){
                Statement stmt2 = conn.createStatement();
                String sqlstr2="SELECT `ID`, `title`, `description`, `imagecard` FROM `invitation` WHERE `ID`='"+userInv.getInt("id")+"'";
                ResultSet userInvInfo=stmt2.executeQuery(sqlstr2);
                userInvInfo.next();
                    AnchorPane  a=new AnchorPane ();
                    a.setStyle("-fx-pref-width:330px; -fx-pref-height:70px; -fx-border-color: transparent transparent #DA0037 transparent ; -fx-background-color:#BCBCBC;");
                    ImageView invImage = new ImageView();
                    invImage.setStyle("-fx-background-repeat: no-repeat; \n" +
"    -fx-background-position: center center;\n" +
"    -fx-border-color: #DA0037;\n" +
"    -fx-border-width:  2px;\n" +
"    -fx-background-size: cover;");
                    a.getChildren().add(invImage);
                    Label title=new Label(userInvInfo.getString("title"));
                    Label senderUserName=new Label(userInv.getString("receiverusername"));
                    Text description= new Text(userInvInfo.getString("description"));
                    description.setWrappingWidth(500);
                    title.setStyle("-fx-font-size: 40px;-fx-text-fill:gray");
                    senderUserName.setStyle("-fx-font-size: 30px;-fx-text-fill:#DA0037 ");
                    description.setStyle("-fx-font-size: 20px;-fx-text-fill:gray;");
                    description.setFill(Color.GRAY);
                    a.getChildren().add(title);
                    a.getChildren().add(senderUserName);
                    a.getChildren().add(description);
                    a.setTopAnchor(title, 100.0);
                    a.setLeftAnchor(title, 500.0);
                    a.setTopAnchor(senderUserName, 10.0);
                    a.setLeftAnchor(senderUserName, 500.0);
                    a.setTopAnchor(description, 150.0);
                    a.setLeftAnchor(description, 500.0);
                    
                    a.setTopAnchor(invImage, 0.0);
                    a.setLeftAnchor(invImage, 50.0);
                    InputStream input;
                    input = userInvInfo.getBinaryStream("imagecard");
                    
                    invImage.setImage(new Image(input));
                    a.setCursor(Cursor.HAND);
                    a.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent t) {
                            LocalDateTime DTNow = LocalDateTime.now();
                            String formattedDate = DTNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));
                            File outputFile = new File("src\\diarymanagementsystem\\downloadedInv\\MyDownloadedCard"+formattedDate+".png");
                            BufferedImage bImage = SwingFXUtils.fromFXImage(a.getChildren().get(0).snapshot(null, null), null);
                            try {
                                ImageIO.write(bImage, "png", outputFile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            
                            
                           
                        }
                        
                    });
                    showCardsVBox.getChildren().add(a);
                    
                    
                
            }
            userInv.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void fillMyInvitationsVBox() {
        myInvitaionsVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `id`, `invitationid`, `senderusername`, `receiverusername`, `date` FROM `send-invitation` WHERE `receiverusername`='"+loginUserName+"' order by `date` desc";
            ResultSet userInv=stmt.executeQuery(sqlstr);
            while(userInv.next()){
                Statement stmt2 = conn.createStatement();
                String sqlstr2="SELECT `ID`, `title`, `description`, `imagecard` FROM `invitation` WHERE `ID`='"+userInv.getInt("id")+"'";
                ResultSet userInvInfo=stmt2.executeQuery(sqlstr2);
                userInvInfo.next();
                    AnchorPane  a=new AnchorPane ();
                    a.setStyle("-fx-pref-width:330px; -fx-pref-height:70px; -fx-border-color: transparent transparent #DA0037 transparent ; -fx-background-color:#BCBCBC;");
                    ImageView invImage = new ImageView();
                    invImage.setStyle("-fx-background-repeat: no-repeat; \n" +
"    -fx-background-position: center center;\n" +
"    -fx-border-color: -fx-primary-color;\n" +
"    -fx-border-width:  2px;\n" +
"    -fx-background-size: cover;");
                    a.getChildren().add(invImage);
                    Label title=new Label(userInvInfo.getString("title"));
                    Label senderUserName=new Label(userInv.getString("senderusername"));
                    Text description= new Text(userInvInfo.getString("description"));
                    description.setWrappingWidth(500);
                    title.setStyle("-fx-font-size: 40px;-fx-text-fill:gray");
                    senderUserName.setStyle("-fx-font-size: 30px;-fx-text-fill:#DA0037 ");
                    description.setStyle("-fx-font-size: 20px;-fx-text-fill:gray;");
                    description.setFill(Color.GRAY);
                    a.getChildren().add(title);
                    a.getChildren().add(senderUserName);
                    a.getChildren().add(description);
                    a.setTopAnchor(title, 100.0);
                    a.setLeftAnchor(title, 500.0);
                    a.setTopAnchor(senderUserName, 10.0);
                    a.setLeftAnchor(senderUserName, 500.0);
                    a.setTopAnchor(description, 150.0);
                    a.setLeftAnchor(description, 500.0);
                    
                    a.setTopAnchor(invImage, 0.0);
                    a.setLeftAnchor(invImage, 50.0);
                    InputStream input;
                    input = userInvInfo.getBinaryStream("imagecard");
                    
                    invImage.setImage(new Image(input));
                    a.setCursor(Cursor.HAND);
                    a.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent t) {
                            LocalDateTime DTNow = LocalDateTime.now();
                            String formattedDate = DTNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));
                            File outputFile = new File("src\\diarymanagementsystem\\downloadedInv\\MyDownloadedCard"+formattedDate+".png");
                            BufferedImage bImage = SwingFXUtils.fromFXImage(a.getChildren().get(0).snapshot(null, null), null);
                            try {
                                ImageIO.write(bImage, "png", outputFile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            
                            
                           
                        }
                        
                    });
                    myInvitaionsVBox.getChildren().add(a);
                    
                    
                
            }
            userInv.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void fillFixNotePane() {
        fixNoteVBox.getChildren().clear();
        try {
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `Title`, `Description`, `Date`,`Fix Note` FROM `diary`,`note`,`user-calendar` WHERE `diary`.`ID`=`note`.`diaryid` and `user-calendar`.`diaryid`=`diary`.`ID`and `Fix Note`='1' and `user-calendar`.`username`='"+loginUserName+"' ORDER by `diary`.`Date` desc";
            ResultSet fixedNotes=stmt.executeQuery(sqlstr);
            while(fixedNotes.next()){
                    AnchorPane  a=new AnchorPane ();//
                    a.setStyle("-fx-pref-width:330px;-fx-pref-height:USE_COMPUTED_SIZE; -fx-border-color: transparent transparent #DA0037 transparent ; -fx-background-color:#EFEFEF;");
                    Label title=new Label(fixedNotes.getString("Title"));
                    Label nDate=new Label(fixedNotes.getString("Date"));
                    Text description= new Text(fixedNotes.getString("Description"));
                    description.setWrappingWidth(300);
                    title.setStyle("-fx-font-size: 20px;");
                    nDate.setStyle("-fx-font-size: 10px;-fx-text-fill:gray;");
                    description.setStyle("-fx-font-size: 15px;-fx-text-fill:gray;");
                    description.setFill(Color.GRAY);
                    a.getChildren().add(title);
                    a.getChildren().add(nDate);
                    a.getChildren().add(description);
                    a.setTopAnchor(title, 5.0);
                    a.setLeftAnchor(title, 5.0);
                    a.setTopAnchor(nDate, 40.0);
                    a.setLeftAnchor(nDate, 5.0);
                    a.setTopAnchor(description, 60.0);
                    a.setLeftAnchor(description, 10.0);
                    
                    fixNoteVBox.getChildren().add(a);
                    
                    
                
            }
            fixedNotes.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void fillHomeVBox() {
        homePageVBox.getChildren().clear();
        try {
            LocalDate today = LocalDate.now();
            String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Statement stmt = conn.createStatement();
            String sqlstr="SELECT `Title`, `Description`, `Date` FROM `diary`,`event`,`user-calendar` WHERE `diary`.`ID`=`event`.`diaryid` and `user-calendar`.`diaryid`=`diary`.`ID`and `user-calendar`.`username`='"+loginUserName+"' and `Date`>='"+formattedDate+"'ORDER by `diary`.`Date` asc LIMIT 0,10;";
            ResultSet nEvents=stmt.executeQuery(sqlstr);
            while(nEvents.next()){
                    AnchorPane  a=new AnchorPane ();//
                    a.setStyle("-fx-pref-width:970px;-fx-pref-height:USE_COMPUTED_SIZE; -fx-border-color: transparent transparent #DA0037 transparent ; -fx-background-color:#BCBCBC;");
                    Label title=new Label(nEvents.getString("Title"));
                    Label nDate=new Label(nEvents.getString("Date"));
                    Text description= new Text(nEvents.getString("Description"));
                    description.setWrappingWidth(900);
                    title.setStyle("-fx-font-size: 20px;");
                    nDate.setStyle("-fx-font-size: 10px;-fx-text-fill:gray;");
                    description.setStyle("-fx-font-size: 15px;-fx-text-fill:gray;");
                    description.setFill(Color.GRAY);
                    a.getChildren().add(title);
                    a.getChildren().add(nDate);
                    a.getChildren().add(description);
                    a.setTopAnchor(title, 5.0);
                    a.setLeftAnchor(title, 5.0);
                    a.setTopAnchor(nDate, 40.0);
                    a.setLeftAnchor(nDate, 5.0);
                    a.setTopAnchor(description, 60.0);
                    a.setLeftAnchor(description, 10.0);
                    
                    homePageVBox.getChildren().add(a);
                    
                    
                
            }
            nEvents.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
