package easykanban;

import java.io.ByteArrayInputStream;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EasyKanbanNGTest {
    
    @Test
    public void testAdminLogin()
    {
        System.out.println("Testing login as an admin"); 
        assertTrue(EasyKanban.checkLogin("admin", "admin"));
    }
    
    @Test
    public void testUserLogin()
    {
        System.out.println("Testing login as user");
        
        // Create a simulated user
        EasyKanban.user = new Account
        (
                "etha_", 
                "BigPassword1!",        
               "Ethan", 
                 "Edwards"
        );

        assertTrue(EasyKanban.checkLogin("etha_", "BigPassword1!")); 
    }
    
    @Test
    public void testFailedLogin()
    {
        System.out.println("Testing a failed login");
        
        // Create a simulated user
        EasyKanban.user = new Account
        (
                "etha_", 
                "BigPassword1!",        
               "Ethan", 
                 "Edwards"
        );

        assertFalse(EasyKanban.checkLogin("wrong", "wrong")); 
    }
}
