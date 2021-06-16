 
/**
 * Write a description of class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Profile
{
    private String biography;
    private String name;
    private String school;
    private String workplace;
    private String location;
    
    //Setters and Getters
    public Profile()
    {   
        biography="";
        name="";
        school="";
        workplace="";
        location="";
    }
    
    //Getters
    public String getBio()
    {
        return biography;
    }
    public String getName()
    {
        return name;
    }
    public String getSchool()
    {
        return school;
    }
    public String getWorkplace()
    {
        return workplace;
    }
    
    //Setters
    public void setBio(String b)
    {
        biography=b;
    }
    public void setName(String n)
    {
        name=n;
    }
    public void setSchool(String b)
    {
        biography=b;
    }
    public void setWorkplace(String w)
    {
        workplace=w;
    }
    public String toString(User u)
    {
        String returnString=("Username: "+u.getUsername());
        if(name.equals("")==false)
        {
           returnString+="\n\nName: "+name;
        }
        if(biography.equals("")==false)
        {
           returnString+="\n\nBiography: "+biography;
        }
        if(school.equals("")==false)
        {
            returnString+="\n\nLives in "+location;
        }
        if(location.equals("")==false)
        {
            returnString+="\n\nLives in "+location;
        }
        return returnString;
    }
}
