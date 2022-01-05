package TestCases;
import StepObject.SearchSteps;
import Utils.ChromeRunnerTwo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.hc.core5.http.ParseException;
import io.restassured.http.ContentType;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class TestCasesTwo extends ChromeRunnerTwo {

    @Test(priority = 1)
    public void typeSearchWord() {
        SearchSteps search = new SearchSteps();
        search.search();
    }

    @Test(priority = 2)
    public void RegistrationSuccessful() throws IOException, ParseException {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .extract().response();
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> mapped = mapper.readValue(response.getBody().asString(), Map.class);
    }

}
