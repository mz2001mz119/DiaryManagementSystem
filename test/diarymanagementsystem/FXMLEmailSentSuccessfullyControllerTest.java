/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Noor Aldeen Muneer
 */
public class FXMLEmailSentSuccessfullyControllerTest {
/*
comment in class FXMLEmailSentSuccessfullyController lines 94-99 & 109
go to properties and run and delete vm options (--add-modules javafx.base,
javafx.controls,javafx.fxml,javafx.graphics,javafx.web,javafx.swing)
*/ 
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValidPassword method, of class FXMLEmailSentSuccessfullyController.
     */
    @Test
    public void testIsValidPassword1() {//all condition true
        System.out.println("isValidPassword");
        String password = "aW8*#98E";
        boolean expResult = true;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPassword2() {//not exsist special character
        System.out.println("isValidPassword");
        String password = "aW898Eert";
        boolean expResult = false;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidPassword3() {//less than 8
        System.out.println("isValidPassword");
        String password = "a*%898E";
        boolean expResult = false;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPassword4() {//not exsist upper case
        System.out.println("isValidPassword");
        String password = "a*%898d7ds";
        boolean expResult = false;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPassword5() {//not exsist lower case
        System.out.println("isValidPassword");
        String password = "RT*%8@98E";
        boolean expResult = false;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidPassword6() {//not exsist number
        System.out.println("isValidPassword");
        String password = "a*%E@PsTE";
        boolean expResult = false;
        boolean result = FXMLEmailSentSuccessfullyController.isValidPassword(password);
        assertEquals(expResult, result);
    }
}
