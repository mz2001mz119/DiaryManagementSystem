/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

/**
 *
 * @author HI-TECH
 */
public class Diary {
    public String ID;
    public String Title;
    public String Description;
    public String Date;
    Diary (){
        this.ID=null;
        this.Title=null;
        this.Description=null;
        this.Date=null;
    }
    Diary(String ID,String Title ,String Description,String Date){
        this.ID=ID;
        this.Title=Title;
        this.Description=Description;
        this.Date=Date;
    }
}
