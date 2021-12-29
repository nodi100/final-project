package Utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;

public class ChromeRunnerTwo {
    @BeforeTest
    public static void baseURL () throws InterruptedException {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
        Configuration.startMaximized = true;

        Selenide.open("https://demoqa.com/books");
        Thread.sleep(2000);
    }
}
