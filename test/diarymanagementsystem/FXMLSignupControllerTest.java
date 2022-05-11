/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;
/*
go to properties and run and delete vm options (--add-modules javafx.base,
javafx.controls,javafx.fxml,javafx.graphics,javafx.web,javafx.swing)
*/
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
public class FXMLSignupControllerTest {
    
    public FXMLSignupControllerTest() {
    }
    
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

    

    @Test
    public void testCheckemailtrue1() {//all cases true
        System.out.println("checkemailtrue");
        String eemail = "anooraldeen@gmail.com";
        boolean expResult = true;
        boolean result = FXMLSignupController.checkemailtrue(eemail);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckemailtrue2() {// . not exsist
        System.out.println("checkemailtrue");
        String eemail = "anooraldeen@gmailcom";
        boolean expResult = false;
        boolean result = FXMLSignupController.checkemailtrue(eemail);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckemailtrue3() {// @ not exsist
        System.out.println("checkemailtrue");
        String eemail = "anooraldeengmail.com";
        boolean expResult = false;
        boolean result = FXMLSignupController.checkemailtrue(eemail);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckemailtrue4() {//com not exsist
        System.out.println("checkemailtrue");
        String eemail = "anooraldeen@gmail.";
        boolean expResult = false;
        boolean result = FXMLSignupController.checkemailtrue(eemail);
        assertEquals(expResult, result);
    }

 
    @Test
    public void testCheckusername1() {
        System.out.println("checkusername");
        String username = "noor@aldeen";
        boolean expResult = false;
        boolean result = FXMLSignupController.checkusername(username);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckusername2() {
        System.out.println("checkusername");
        String username = "noor_aldeen";
        boolean expResult = true;
        boolean result = FXMLSignupController.checkusername(username);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckusername3() {
        System.out.println("checkusername");
        String username = "noor-aldeen";
        boolean expResult = true;
        boolean result = FXMLSignupController.checkusername(username);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckusername4() {
        System.out.println("checkusername");
        String username = "noor$aldeen";
        boolean expResult = false;
        boolean result = FXMLSignupController.checkusername(username);
        assertEquals(expResult, result);
    }


}
