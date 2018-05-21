package lab07.features.search;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
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
@UseTestDataFrom("src/test/resources/TestData1.csv")
public class TrelloParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "https://trello.com/login?returnUrl=%2F")
    public Pages pages;

    public String Username;
    public String Password;
    public int ShouldError;

    @Qualifier
    public String getQualifier() {
        return Username;
    }

    @Steps
    public TrelloSteps steps;

    @Issue("#Login")
    @Test
    public void loginTrello() {
        Boolean shouldError;
        if(ShouldError == 1)
            shouldError = true;
        else
            shouldError = false;
        steps.startHomePage();
        steps.completeLogin(shouldError,Username,Password);
    }
}
