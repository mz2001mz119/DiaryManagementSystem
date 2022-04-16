
package diarymanagementsystem;

import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import javax.mail.Authenticator;

public class send_email {
    
   public static void sendemail(String recepient,String Random) throws MessagingException{

    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 // Get a Properties object
    Properties props = System.getProperties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    props.setProperty("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.port", "888");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.starttls.enable","true"); 

    final String username ="systemdiarymanagement@gmail.com" ;
    final String password ="Sys2022Dia";
   
      Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
      Message msg = new MimeMessage(session);

   // -- Set the FROM and TO fields --
      msg.setFrom(new InternetAddress(username));
      msg.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse( recepient ,false));
      msg.setSubject("Wellcome to Diary Management System ");
      msg.setText("to continue with your email verfication ,\n please enter the following code :\n"
              + "Verfication Code:\n"+Random
             );
      msg.setSentDate(new Date());
      Transport.send(msg);         
   }
       

    
}