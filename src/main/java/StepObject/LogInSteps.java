package StepObject;
import PageObject.LogInElements;
import static DataObject.LogInData.*;


public class LogInSteps extends LogInElements {

    public LogInSteps enterUserName (String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    public LogInSteps enterPassword (String password)  {
        passwordInput.sendKeys(password);
        return this;
    }

    public LogInSteps clickLogInButton () {
        logInButton.click();
        return this;
    }

    public void login () {
        LogInSteps steps = new LogInSteps();
        steps.enterUserName(userName)
             .enterPassword(password)
             .clickLogInButton();
    }

}
