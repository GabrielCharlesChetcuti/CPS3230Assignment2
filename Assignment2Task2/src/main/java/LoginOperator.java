import javax.swing.text.View;
import java.util.IllegalFormatException;

public class LoginOperator
{
    boolean LoggedOut = false;
    boolean LoggedIn = false;
    boolean ViewingAlerts = false;

    boolean IncorrectLogin()
    {
        if((LoggedIn == false) && (ViewingAlerts == false))
        {
            LoggedOut = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean CorrectLogin()
    {
        if((LoggedOut == false))//(LoggedIn == true) &&
        {
            LoggedIn = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean ViewingAlerts()
    {
        if((LoggedIn == true) && (LoggedOut == false)) //&& (ViewingAlerts == true)
        {
            LoggedIn = true;
            ViewingAlerts = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean LogOut()
    {
        if((LoggedIn == true) || (ViewingAlerts == true))
        {
            LoggedOut = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean isLoggedOut() {return LoggedOut;}
    boolean isLoggedIn() {return LoggedIn;}
    boolean isViewingAlerts() {return ViewingAlerts;}

}
