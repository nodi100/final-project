package TestCases;
import StepObject.DeleteAccSteps;
import StepObject.LogInSteps;
import Utils.ChromeRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.hc.core5.http.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class TestCases extends ChromeRunner {
    private static String requestBody = "{\n" +
            "  \"userName\": \"NodarPruidze\",\n" +
            "  \"password\": \"Aa12345678!\" \n}";

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
    }

    @Test(priority = 1)
    public void RegistrationSuccessful() throws IOException, ParseException {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/Account/v1/User")
                .then()
                .extract().response();
        // Assert.assertEquals(201, response.statusCode());
        System.out.println(response.getBody().asString());
    }

    @Test(priority = 2)
    public void loginWithValidUser() {
        LogInSteps login = new LogInSteps();
        login.login();
    }

    @Test(priority = 3)
    public void deleteAccountSteps() throws InterruptedException {
        DeleteAccSteps deleteAcc = new DeleteAccSteps();
        deleteAcc.delete();
    }

    @Test(priority = 4)
    public void loginWithDeletedUser() {
        LogInSteps login = new LogInSteps();
        DeleteAccSteps deleteAcc = new DeleteAccSteps();
        login.login();
        deleteAcc.getErrorText();
    //    Assert.assertEquals(deleteAcc.getErrorText(), "Invalid username or password!");
    }

    @Test(priority = 5)
    public void RegistrationWithDeletedUser() throws IOException, ParseException {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/Account/v1/Authorized")
                .then()
                .extract().response();

        Assert.assertEquals("User not found!", response.jsonPath().getString("message"));
    }
}
