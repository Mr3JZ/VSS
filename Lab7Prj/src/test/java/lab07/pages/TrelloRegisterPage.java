package lab07.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://trello.com/signup?returnUrl=%2Fhome")
public class TrelloRegisterPage extends PageObject {

    @FindBy(name="name")
    private WebElementFacade nameField;

    @FindBy(name="email")
    private WebElementFacade emailField;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(id="signup")
    private WebElementFacade signupButton;

    public void enterNameText(String text) {
        nameField.type(text);
    }

    public void enterEmailText(String text) {
        emailField.type(text);
    }

    public void enterPassword(String text) {
        passwordField.type(text);
    }
    public void signup() {
        signupButton.click();
    }

    public boolean checkError() {
        return find(By.id("error")).isVisible() || find(By.id("email-error")).isVisible();
    }
}
