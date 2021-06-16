
/**
 * Write a description of class Post here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Post
{
    private String bodyText;
    private User account;
    
    public Post(User a, String t)
    {
        account=a;
        bodyText=t;
    }
    
    public String getText()
    {
        return bodyText;
    }
    public User getAccount()
    {
        return account;
    }
}
