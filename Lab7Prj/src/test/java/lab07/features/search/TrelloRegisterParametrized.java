package lab07.features.search;

import lab07.steps.serenity.TrelloRegisterSteps;
import lab07.steps.serenity.TrelloSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/TestData2.csv")
public class TrelloRegisterParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "https://trello.com/signup?returnUrl=%2Fhome")
    public Pages pages;

    public String Name;
    public String Email;
    public String Password;
    public int ShouldError;

    @Qualifier
    public String getQualifier() {
        return Name;
    }

    @Steps
    public TrelloRegisterSteps steps;

    @Issue("#Register")
    @Test
    public void registerTrello() {
        Boolean shouldError;
        if(ShouldError == 1)
            shouldError = true;
        else
            shouldError = false;
        steps.startHomePage();
        steps.completeRegister(Name,Email,Password,shouldError);
    }
}
