package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DeleteAccElements {
    protected SelenideElement
        deleteAccButton = $(byXpath("//button[contains(text(), 'Delete Account')]")),
        yesButton = $(byXpath("//button[contains(text(), 'OK')]")),
        errorText = $(byXpath("//p[contains(text(), 'Invalid')]"));
}

