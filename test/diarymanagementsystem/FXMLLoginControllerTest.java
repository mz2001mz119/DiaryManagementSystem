/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diarymanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class FXMLLoginControllerTest {
    
    public FXMLLoginControllerTest() {
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

    /**
     * Test of initialize method, of class FXMLLoginController.
     */
               @Test
    public void testcheckifexsist() throws SQLException {
        FXMLLoginController sd=new FXMLLoginController();
        String username = "abuaws";
        boolean expResult = true;
        boolean result = sd.checkifexsist(username);
        assertEquals(expResult, result);
        sd=null;
    }
                   @Test
    public void testcheckifexsist2() throws SQLException {
        FXMLLoginController sd=new FXMLLoginController();
        String username = "sdddff";
        boolean expResult = false;
        boolean result = sd.checkifexsist(username);
        assertEquals(expResult, result);
        sd=null;
    }
}
