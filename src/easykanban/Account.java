package easykanban;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account
{
    private static final int PWD_LENGTH = 8;
    private static final int UNAME_LENGTH = 5;
    
    private String username;
    private String password;
    private String firstname;
    private String surname;
    
    // Create a user through entered data
    public Account(String username, String password, String firstname, String surname)
    {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
    }
    
    // Registration is done through constructor
    public Account()
    {
        Scanner kb = new Scanner(System.in);
        
        // Grab user's name and surname
        System.out.println("\n***Welcome to Registration ***");
        System.out.println("Enter your First name(s) >>>");
        firstname = kb.nextLine();
        System.out.println("Enter your surname >>>");
        surname = kb.nextLine();
        
        // Continously check for a valid username and password until a valid
        // entry is made
        do
        {
            System.out.println
            (
                    "Create a username for your account\n"
                    + "\tUsernames must contain:\n"
                    + "\t* at least " + UNAME_LENGTH + " characters\n"
                    + "\t* at least 1 underscore\n"
                    + ">>>"
            );
            username = kb.nextLine();
        }
        while (!checkUsername(username));
        
        do
        {
            System.out.println
            (
                    "\nCreate a password for your account\n"
                    + "\tPasswords must contain:\n"
                    + "\t* at least " + PWD_LENGTH + " characters\n"
                    + "\t* at least 1 uppercase character\n"
                    + ">>>"
            );
            password = kb.nextLine();
        }
        while (!checkPassword(password));
        
        // NOTE: Scanner cannot be closed, as this closes System.in, which we need later
        //kb.close();
    }
    
    public static boolean checkUsername(String input)
    {          
        if (input.length() < UNAME_LENGTH)
        {
            System.out.println
            (
                "Error: Username must contain at least " + UNAME_LENGTH + " characters\n"
            );
        }
        else // Username length check passed
        {
            if (!input.contains("_"))
            {
                System.out.println
                (
                    "Error: Username must contain an underscore\n"
                );                   
            }
            else // Username underscore check passed
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkPassword(String input)
    {
        Pattern specialPattern = Pattern.compile("[^A-Za-z0-9]");
        Pattern digitPattern = Pattern.compile("\\d");
        Pattern capsPattern = Pattern.compile("[A-Z]");
            
        if (input.length() < PWD_LENGTH)
        {
            System.out.println
            (
                "Error: Password must contain at least " + PWD_LENGTH + " characters\n"
            );

            return false;
        }

        Matcher specialMatcher = specialPattern.matcher(input);
        Matcher digitMatcher = digitPattern.matcher(input);
        Matcher capsMatcher = capsPattern.matcher(input);

        if (!specialMatcher.find())
        {
            System.out.println
            (
                "Error: Password must contain at least 1 special character\n"
            );

            return false;           
        }

        if (!digitMatcher.find())
        {
            System.out.println
            (
                "Error: Password must contain at least 1 digit\n"
            );

            return false;
        }

        if (!capsMatcher.find())
        {
            System.out.println
            (
                "Error: Password must contain at least 1 uppercase character\n"
            );

            return false;
        }

        System.out.println("You have successfully chosen a password");
        return true;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getSurname()
    {
        return surname;
    }
}
