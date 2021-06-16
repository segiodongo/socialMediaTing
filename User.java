import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;





/**
 * Things to add
 * 
 * make program continuous
 * Posting feature
 * profile page
 * following feature
 */
 
/**
 * Write a description of class User here.
 *
 * @Segi (your name)
 * @1.0
 * 
 * First draft of User class, no online funcitonality
 * creates groups of users on individual computers
 */
public class User
{
    // instance variables
    private String username;
    private String email;
    private String password;
    private int internalID;
    private boolean loggedIn;
    
    
    //List for all users
    private static ArrayList<User> listOfAllUsers=new ArrayList<User>();
    private static ArrayList<Post> allPosts=new ArrayList<Post>();
    
    //File and FileWriter
    private static File listOfUsers=new File("ListOfUsers.txt.");
    private static FileWriter writer;
    //Additional Profile Identifiers
    private Profile p;
    
    /**
     * Constructor for objects of class User
     */
    public User(String u, String p,String e)
    {
        username=u;
        password=p;
        email=e;
        loggedIn=false;
        
        //Adds created User to a list of all users
        //May run into problem with parameter passing
        //Uses 2x the amount of data by creating new user
        
    }
    
    //Constructor for adding to listOfAllUsers
    //I dont really think this is the most efficient way\
    /**
    private User(String u, String p, String e, int iD)
    {
        username=u;
        password=p;
        internalID=iD;
    }
    **/
    
    //getter for username variable
    //used for viewing feed
    public String getUsername()
    {
        return username;
    }
    
    public static void createFileWriter(){
        try {
            writer = new FileWriter("ListOfUsers.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //Method to login to an account
    public static void login(String username, String password)
    {
        //Checks for existance through every user created
        String us, p;
        Scanner s1=new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        User copy=new User("","","");
        for(User u: listOfAllUsers)
        {
            if(u.username.equals(username) && u.password.equals(password))
            {
                System.out.println("\nLogin Successful");
                u.loggedIn=true;
                copy=u;
                copy.loggedIn=true;
                break;
            }
        }
        if(copy.loggedIn=false)
        {
            System.out.println("\nInvalid Credentials");
            System.out.println("\nUsername:");
            us=s2.nextLine();
            System.out.println("\nPassword:");
            p=s2.nextLine();
            login(username,password);
        }
        
    }
    
    //method for loggin out of an account
    public void logout()
    {
        loggedIn=false;
        System.out.println("Logout Successful");
    }
    
    //Resets the List for testing
    //Will be deleted later
    public void resetNetwork()
    {
        for(User u: listOfAllUsers)
        {
            listOfAllUsers.remove(u);
        }
    }
    
    //Method to reset password
    public static void resetPassword(User accountToReset,String password)
    {
        accountToReset.password=password;
    }
    
    //Method for profile setup
    public void setUpProfile()
    {
        String n,b,s,w;
        String action;
        Scanner scanner1=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        Profile p=new Profile();
        
        System.out.println("Add a name to your account?(y/n)");
        action=scanner1.nextLine();
        if(action.equals("y")||action.equals("Y")){
            System.out.println("Enter a name: ");
            n=scanner2.nextLine();
            p.setName(n);
        }
        else{
            System.out.println("No worries:). you can edit or set it at anytime");
        }
        
        System.out.println("Edit bio?(y/n)");
        action=scanner1.nextLine();
        if(action.equals("y")||action.equals("Y")){
            System.out.println("Enter your bio(you can change it later)");
            b=scanner2.nextLine();
            p.setBio(b);
        }
        else{
            System.out.println("No worries:). you can edit or set it at anytime");
        }
        System.out.println(p.toString());
        
    }
    
    //User interactive method
    public static void run()
    {
        Scanner s1=new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        String action,email,username,password,confirmPassword;
        createFileWriter();
        
        System.out.println("\nWould you like to login(A), create an account(B), or quit program(C)?");
        action=s1.nextLine();
        if(action.equals("A")||action.equals("a")){
            System.out.println("\nUsername: ");
            username=s2.nextLine();
            System.out.println("\nPassword: ");
            password=s1.nextLine();
            login(username, password);
        }
        else if(action.equals("B")|| action.equals("b")){
            createUser();
        }
        else if(action.equals("C")|| action.equals("c")){
            System.out.println("\nGoodbye:)");
        }
        else{
            System.out.println("\nInvalid input");
            run();
        }
    }
    
    //Creating user method
    public static void createUser()
    {
        String password,confirmPassword,email,username;
        Scanner s1=new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        boolean userAlreadyExists;
        User u2;
        
        System.out.println("\nEnter email: ");
        email=s2.nextLine();
        System.out.println("\nWhat would you like to set as a username: ");
        username=s1.nextLine();
        System.out.println("\nSet password: ");
        password=s2.nextLine();
        System.out.println("\nConfirm password: ");
        confirmPassword=s1.nextLine();
        
        while(!password.equals(confirmPassword))
        {
            System.out.println("\nPasswords do not match");
            System.out.println("\nSet password: ");
            password=s2.nextLine();
            System.out.println("\nConfirm password");
            confirmPassword=s1.nextLine();
        }
        System.out.println("\nPassword Confirmed");
        System.out.println("\nAccount Created :)");
        u2=new User(username, password, email);
        listOfAllUsers.add(u2);
        try {
            writer.write(username+password+"\n");
            writer.close();
            System.out.println("User successfully created");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("\n\nLogin\n\nUsername: ");
        username=s2.nextLine();
        System.out.println("\nPassword: ");
        password=s1.nextLine();
        login(username,password);
        u2.userActions();
    }
    
    //Method for user actions after logged in
    public void userActions()
    {
        Scanner s1=new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        String action,post;
        
        while(true)
        {
            System.out.println("\n\nWhat would you like to do?\nView feed(A)\nView/Edit Profile(B)\nPost(C)\nLogout(D)");
            action=s1.nextLine();
            if(action.equals("A")||action.equals("a"))
            {
                System.out.println("Most recent posts");
                if(allPosts.size()>0)
                {
                    for(Post p: allPosts)
                    {
                        System.out.println("\n"+p.getAccount().getUsername()+":  "+p.getText());
                    }
                }
                else{
                    System.out.println("\nNo posts have been made");
                }
            }
            if(action.equals("B")||action.equals("b"))
            {
                
            }
            if(action.equals("C")||action.equals("c"))
            {
                System.out.println("\n\nWhat would you like to post?");
                post=s2.nextLine();
                allPosts.add(new Post(this,post));
            }
            if(action.equals("D")||action.equals("d"))
            {
                logout();
                run();
            }
        }
    }
}
