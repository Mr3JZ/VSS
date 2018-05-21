package lab07.steps.serenity;

import lab07.pages.TrelloPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class TrelloSteps {

    TrelloPage trelloPage;

    @Step
    public void startHomePage() {
        trelloPage.open();
    }

    @Step
    public void completeLogin(Boolean shouldError, String username, String password) {
        completeUsername(username);
        completePassword(password);
        login();
        checkError(shouldError);
    }

    @Step
    public void completeValidLogin() {
        completeUsername("balastudor");
        completePassword("Lluudduuss11");
        login();
        checkError(false);
    }

    @Step
    public void completeInvalidLogin() {
        completeUsername("qwgeyjhdbasmnjhdfgy");
        completePassword("asdbnqwneb");
        login();
        checkError(true);
    }

    @Step
    private void completeUsername(String text) {
        trelloPage.enterUsernameText(text);
    }

    @Step
    private void completePassword(String text) {
        trelloPage.enterPassword(text);
    }

    @Step
    private void login() {
        trelloPage.login();
    }

    @Step
    public void checkError(boolean shouldError) {
        if(trelloPage.checkError()!=shouldError) {
            assert false;
        } else {
            assert true;
        }
    }
}
