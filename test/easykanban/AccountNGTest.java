package easykanban;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AccountNGTest {
    @Test
    public void testGoodUsername()
    {       
        assertTrue(Account.checkUsername("kyl_1"));
    }
    
    @Test
    public void testBadUsername()
    {
        assertFalse(Account.checkUsername("kyle!!!!!!!"));
    }
    
    @Test
    public void testGoodPassword()
    {      
        assertTrue(Account.checkPassword("Ch&&sec@ke99!"));
    }
    
    @Test
    public void testBadPassword()
    {
        assertFalse(Account.checkPassword("password"));
    }
}
