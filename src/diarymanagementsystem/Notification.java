/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.util.Date;

/**
 *
 * @author HI-TECH
 */
public class Notification {
    public String notificationDate;
    public String notificationHour;
    public String notificationMinute;
    public String diaryId;
    public String userName;
    Notification (){
        this.notificationDate=null;
        this.notificationHour=null;
        this.notificationMinute=null;
        this.diaryId=null;
        this.userName=null;
    }
    Notification(String notificationDate,String notificationHour ,String notificationMinute){
        this.notificationDate=notificationDate;
        this.notificationHour=notificationHour;
        this.notificationMinute=notificationMinute;
        this.diaryId=null;
        this.userName=null;
    }
    Notification(String notificationDate,String notificationHour ,String notificationMinute,String diaryId,String userName){
        this.notificationDate=notificationDate;
        this.notificationHour=notificationHour;
        this.notificationMinute=notificationMinute;
        this.diaryId=diaryId;
        this.userName=userName;
    }
}
