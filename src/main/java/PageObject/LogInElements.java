package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LogInElements {
    protected SelenideElement
        userNameInput = $("#userName"),
        passwordInput = $("#password"),
        logInButton = $("#login");
}
