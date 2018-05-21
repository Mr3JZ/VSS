package lab07.features.search;

import lab07.steps.serenity.TrelloRegisterSteps;
import lab07.steps.serenity.TrelloSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TrelloTesting {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public TrelloSteps steps;

    @Steps
    public TrelloRegisterSteps registerSteps;

    @Issue("#ValidLogin")
    @Test
    public void validLoginTest() {
        steps.startHomePage();
        steps.completeValidLogin();
    }

    @Issue("#InvalidLogin")
    @Test
    public void invalidLoginTest() {
        steps.startHomePage();
        steps.completeInvalidLogin();
    }


    @Issue("#ValidSignup")
    @Test
    public void validSignupTest() {
        registerSteps.startHomePage();
        registerSteps.completeValidRegister();
    }

    @Issue("#InvalidLogin")
    @Test
    public void invalidSignupTest() {
        registerSteps.startHomePage();
        registerSteps.completeInvalidLogin();
    }
}