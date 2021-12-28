package TestCases;
import StepObject.DeleteAccSteps;
import StepObject.LogInSteps;
import Utils.ChromeRunner;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases extends ChromeRunner {

    @Test(priority = 1)
    public void loginWithValidUser() {
        LogInSteps login = new LogInSteps();
        login.login();
    }

    @Test(priority = 2)
    public void deleteAccountSteps() throws InterruptedException {
        DeleteAccSteps deleteAcc = new DeleteAccSteps();
        deleteAcc.delete();
    }

    @Test(priority = 3)
    public void loginWithDeletedUser() {
        LogInSteps login = new LogInSteps();
        DeleteAccSteps deleteAcc = new DeleteAccSteps();
        login.login();
        deleteAcc.getErrorText();
        //Assert

    }
}
