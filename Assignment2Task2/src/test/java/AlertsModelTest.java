import junit.framework.Assert;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

public class AlertsModelTest implements FsmModel
{

    private AlertsOperator systemUnderTest = new AlertsOperator();

    private AlertsEnum modelLogin = AlertsEnum.ViewingAlerts;
    private boolean Delete = false;
    private boolean AlertsListPopulated = false;
    private boolean CorrectData = false;
    private boolean ThreeAlerts = false;

    @Override
    public AlertsEnum getState() {
        return modelLogin;
    }

    @Override
    public void reset(boolean b) {
        if (b)
        {
            systemUnderTest = new AlertsOperator();
        }
        modelLogin = AlertsEnum.ViewingAlerts;
        Delete = false;
        AlertsListPopulated = false;
        CorrectData = false;
        ThreeAlerts = false;
    }

    public boolean NotDeleteOccuredGuard() {return getState().equals(AlertsEnum.ViewingAlerts);}
    public @Action
    void NotDeleteOccured() {
        systemUnderTest.NotDeleteOccured();

        modelLogin = AlertsEnum.UnintentionallyPopulatedAlertsList;
        Delete = false;

        Assert.assertEquals("Delete did not occur", Delete, systemUnderTest.isDelete());
    }

    public boolean DeleteOccuredGuard() {return getState().equals(AlertsEnum.ViewingAlerts);}
    public @Action
    void DeleteOccured() {
        systemUnderTest.DeleteOccured();

        modelLogin = AlertsEnum.EmptyAlertsList;
        Delete = true;

        Assert.assertEquals("Delete did occur", Delete, systemUnderTest.isDelete());
    }

    public boolean AlertsNotPopulatedGuard() {return getState().equals(AlertsEnum.EmptyAlertsList);}
    public @Action
    void AlertsNotPopulated() {
        systemUnderTest.AlertsNotPopulated();

        modelLogin = AlertsEnum.UnpopulatedAlertsList;
        AlertsListPopulated = false;

        Assert.assertEquals("Alerts Not Populated", AlertsListPopulated, systemUnderTest.isAlertsListPopulated());
    }

    public boolean AlertsPopulatedGuard() {return getState().equals(AlertsEnum.EmptyAlertsList);}
    public @Action
    void AlertsPopulated() {
        systemUnderTest.AlertsPopulated();

        modelLogin = AlertsEnum.PopulatedAlertsList;
        AlertsListPopulated = true;

        Assert.assertEquals("Alerts Populated", AlertsListPopulated, systemUnderTest.isAlertsListPopulated());
    }

    public boolean DataCheckGuard() {return getState().equals(AlertsEnum.PopulatedAlertsList);}
    public @Action
    void DataCheck() {
        systemUnderTest.DataCheck();

        modelLogin = AlertsEnum.CheckAlertsData;
        CorrectData = false;

        Assert.assertEquals("Checking Data", CorrectData, systemUnderTest.isCorrectData());
    }

    public boolean CorrectDataPostedGuard() {return getState().equals(AlertsEnum.CheckAlertsData);}
    public @Action
    void CorrectDataPosted() {
        systemUnderTest.CorrectDataPosted();

        modelLogin = AlertsEnum.ThreeAlertsCheck;
        CorrectData = true;

        Assert.assertEquals("Correct Data has been Posted", CorrectData, systemUnderTest.isCorrectData());
    }

    public boolean IncorrectDataPostedGuard() {return getState().equals(AlertsEnum.CheckAlertsData);}
    public @Action
    void IncorrectDataPosted() {
        systemUnderTest.IncorrectDataPosted();

        modelLogin = AlertsEnum.IncorrectPostData;
        CorrectData = false;

        Assert.assertEquals("Correct Data has not been Posted", CorrectData, systemUnderTest.isCorrectData());
    }

    public boolean CorrectNumberOfAlertsGuard() {return getState().equals(AlertsEnum.ThreeAlertsCheck);}
    public @Action
    void CorrectNumberOfAlerts() {
        systemUnderTest.CorrectNumberOfAlerts();

        modelLogin = AlertsEnum.PostedSuccesfully;
        ThreeAlerts = true;

        Assert.assertEquals("Correct Number Of Alerts have been posted", ThreeAlerts, systemUnderTest.isThreeAlerts());
    }

    public boolean IncorrectNumberOfAlertsGuard() {return getState().equals(AlertsEnum.ThreeAlertsCheck);}
    public @Action
    void IncorrectNumberOfAlerts() {
        systemUnderTest.IncorrectNumberOfAlerts();

        modelLogin = AlertsEnum.IncorrectAmountOfAlerts;
        ThreeAlerts = false;

        Assert.assertEquals("Incorrect Number Of Alerts have been posted", ThreeAlerts, systemUnderTest.isThreeAlerts());
    }

    @Test
    public void AlertsModelTest() {
        final GreedyTester tester = new GreedyTester(new AlertsModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}
