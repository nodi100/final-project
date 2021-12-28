package Utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ChromeRunner {
    @BeforeTest
    public static void baseURL () throws InterruptedException {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
        com.codeborne.selenide.Configuration.startMaximized = true;

        Selenide.open("https://demoqa.com/login");
        Thread.sleep(2000);
    }
}
