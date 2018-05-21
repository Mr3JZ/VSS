package lab07.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://trello.com/login?returnUrl=%2F")
public class TrelloPage extends PageObject {

    @FindBy(name="user")
    private WebElementFacade usernameField;

    @FindBy(name="password")
    private WebElementFacade passwordField;

    @FindBy(id="login")
    private WebElementFacade loginButton;

    public void enterUsernameText(String text) {
        usernameField.type(text);
    }

    public void enterPassword(String text) {
        passwordField.type(text);
    }
    public void login() {
        loginButton.click();
    }

    public boolean checkError() {
        return find(By.id("error")).isVisible();
    }
}
