package StepObject;

import PageObject.DeleteAccElements;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.Wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


public class DeleteAccSteps extends DeleteAccElements {

    public DeleteAccSteps clickDeleteButton() {
        deleteAccButton.click();
        return this;
    }

    public DeleteAccSteps clickYesButton() {
        yesButton.click();
        return this;
    }

    public DeleteAccSteps userDeletedMessage() throws InterruptedException {
        Alert alert = Wait().until(alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "User Deleted.");
        alert.accept();
        return this;
    }

    public DeleteAccSteps getErrorText() {
        errorText.getText();
        return this;
    }

    public void delete () throws InterruptedException {
        DeleteAccSteps deleteAcc = new DeleteAccSteps();
        deleteAcc.clickDeleteButton()
                 .clickYesButton()
                 .userDeletedMessage();
    }
}
