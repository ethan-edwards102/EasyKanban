package easykanban;

import java.util.Scanner;

public class EasyKanban
{
    private static boolean loggedIn;
    public static Account user = null;
    
    public static void main(String[] args)
    {
        while(!loggedIn)
        {
           menu();
        }
    }
    
    public static void menu()
    {
        Scanner kb = new Scanner(System.in);
        
        System.out.println
        (
                "*** Main Menu ***\n" +
                "Select (1) for instructions\n" +
                "Select (2) for login\n" +
                "Select (3) for registration\n" +
                "Select (4) to exit\n\n" +
                "Enter your selection >>>"
        );
        
        switch (Integer.parseInt(kb.nextLine()))
        {
            case 1:
                instructions();
                break;
            case 2:
                loggedIn = login();
                break;
            case 3:
                user = new Account();
                loggedIn = login();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println
                (
                    "Unknown selection, please enter one of the above options"
                );
        }
        
        System.out.println("\n");
    }
    
    public static void instructions()
    {
        System.out.println
        (
                "Instructions:\n" +
                "1. Select an option from the main menu, by entering the " +
                "corresponding number"
        );
    }
    
    public static boolean login()
    {
        String username = "";
        String password = "";
        Scanner kb = new Scanner(System.in);
        
        System.out.println("\n***Welcome to login ***");
        
        for (int i = 2; i >= 0; i--)
        {   
            System.out.println("Enter your username >>>");
            username = kb.nextLine();
            
            System.out.println("Enter your password >>>");
            password =  kb.nextLine();
            
            if (!checkLogin(username, password))
            {
                System.out.println
                (
                    "Invalid username or password, you have " + i + " attempts remaining"
                );
            }
            else
            {
                return true;
            }
        }
        
        System.out.println
        (
            "You have entered too many attempts, please contact the " +
            "administrator at ST10442420@vcconnect.edu.za to reset your " +
            "password"
        );
        
        return false;
    }
    
    public static boolean checkLogin(String username, String password)
    {
        if (username.equals("admin") && password.equals("admin"))
        {
            System.out.println("You have been logged in as an admin");
            return true;
        } 
        else if 
        (
            user != null &&
            username.equals(user.getUsername())&&
            password.equals(user.getPassword())
        )
        {
            System.out.println
            (
                    "You have been logged in, " +
                    user.getFirstname() +
                    " " + 
                    user.getSurname()
            );

            return true;
        }
        
        return false;
    }
}

/*
*** References ***
YouTube videos:
1. https://www.youtube.com/watch?v=2EIUHHOVfmU
2. https://www.youtube.com/playlist?list=PL480DYS-b_kfHSYf2yzLgto_mwDr_U-Q6

Textbooks:
1. Farrell, J. (2019) Java programming. 9th edn. Boston, MA: Cengage.

Student Information:
Student Number: ST10442420
Student Email: ST10442420@vcconnect.edu.za
*/