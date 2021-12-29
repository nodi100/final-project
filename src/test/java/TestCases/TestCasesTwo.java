package TestCases;
import StepObject.SearchSteps;
import Utils.ChromeRunnerTwo;
import org.testng.annotations.Test;


public class TestCasesTwo extends ChromeRunnerTwo {

    @Test(priority = 1)
    public void typeSearchWord() {
        SearchSteps search = new SearchSteps();
        search.search();
    }

}
