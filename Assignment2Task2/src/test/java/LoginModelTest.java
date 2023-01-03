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

public class LoginModelTest implements FsmModel
{
    private LoginOperator systemUnderTest = new LoginOperator();

    private LoginEnum modelLogin = LoginEnum.InitiallyLoggedOut;
    private boolean LoggedIn = false;
    private boolean LoggedOut = false;
    private boolean ViewingAlerts = false;

    @Override
    public LoginEnum getState() {
        return modelLogin;
    }

    @Override
    public void reset(final boolean b)
    {
        if (b)
        {
            systemUnderTest = new LoginOperator();
        }
        modelLogin = LoginEnum.InitiallyLoggedOut;
        LoggedIn = false;
        LoggedOut = false;
        ViewingAlerts = false;
    }

    public boolean IncorrectLoginGuard() {return getState().equals(LoginEnum.InitiallyLoggedOut);}
    public @Action
    void IncorrectLogin() {
        systemUnderTest.IncorrectLogin();

        modelLogin = LoginEnum.BadLoginError401;
        LoggedOut = true;

        Assert.assertEquals("Is logged out", LoggedOut, systemUnderTest.isLoggedOut());
    }

    public boolean CorrectLoginGuard() {return getState().equals(LoginEnum.InitiallyLoggedOut);}
    public @Action
    void CorrectLogin() {
        systemUnderTest.CorrectLogin();

        modelLogin = LoginEnum.LoggedIn;
        LoggedIn = true;

        Assert.assertEquals("Is logged in", LoggedIn, systemUnderTest.isLoggedIn());
    }

    public boolean ViewingAlertsGuard() {return getState().equals(LoginEnum.LoggedIn);}
    public @Action
    void ViewingAlerts() {
        systemUnderTest.ViewingAlerts();

        modelLogin = LoginEnum.ViewingAlerts;
        ViewingAlerts = true;

        Assert.assertEquals("Is logged in", ViewingAlerts, systemUnderTest.isViewingAlerts());
    }

    public boolean LogOutGuard() {return getState().equals(LoginEnum.LoggedIn) || getState().equals(LoginEnum.ViewingAlerts);}
    public @Action
    void LogOut() {
        systemUnderTest.LogOut();

        modelLogin = LoginEnum.PurposelyLoggedOut;
        LoggedOut = true;

        Assert.assertEquals("Is logged out", LoggedOut, systemUnderTest.isLoggedOut());
    }


    @Test
    public void LoginModelTest() {
        final GreedyTester tester = new GreedyTester(new LoginModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
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
