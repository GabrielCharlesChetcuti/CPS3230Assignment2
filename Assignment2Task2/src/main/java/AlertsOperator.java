public class AlertsOperator
{
    boolean Delete = false;
    boolean AlertsListPopulated = false;
    boolean CorrectData = false;
    boolean ThreeAlerts = false;

    boolean NotDeleteOccured()
    {
        if((Delete == false))
        {
            AlertsListPopulated = false;
            CorrectData = false;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean DeleteOccured()
    {
        if((AlertsListPopulated == false) && (CorrectData == false) && (ThreeAlerts == false))
        {
            Delete = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean AlertsNotPopulated()
    {
        if((Delete == true) && (CorrectData == false) && (ThreeAlerts == false))
        {
            AlertsListPopulated = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean AlertsPopulated()
    {
        if((Delete == true) && (AlertsListPopulated = true))
        {
            AlertsListPopulated = true;
            CorrectData = false;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean DataCheck()
    {
        if((Delete == true) && (AlertsListPopulated = true) && (CorrectData == false))
        {
            AlertsListPopulated = true;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean CorrectDataPosted()
    {
        if((Delete == true) && (AlertsListPopulated = true))
        {
            CorrectData = true;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean IncorrectDataPosted()
    {
        if((Delete == true) && (AlertsListPopulated = true) && (CorrectData == false))
        {
            AlertsListPopulated = true;
            CorrectData = false;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean CorrectNumberOfAlerts()
    {
        if((Delete == true) && (AlertsListPopulated = true) && (CorrectData == true))
        {
            ThreeAlerts = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean IncorrectNumberOfAlerts()
    {
        if((Delete == true) && (AlertsListPopulated = true) && (CorrectData == true) && (ThreeAlerts == false))
        {
            AlertsListPopulated = true;
            CorrectData = true;
            ThreeAlerts = false;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }


    public boolean isAlertsListPopulated() {
        return AlertsListPopulated;
    }

    public boolean isCorrectData() {
        return CorrectData;
    }

    public boolean isDelete() {
        return Delete;
    }

    public boolean isThreeAlerts() {
        return ThreeAlerts;
    }
}
