package lab07.steps.serenity;

import lab07.pages.TrelloPage;
import lab07.pages.TrelloRegisterPage;
import net.thucydides.core.annotations.Step;

public class TrelloRegisterSteps {

    TrelloRegisterPage trelloRegisterPage;

    @Step
    public void startHomePage() {
        trelloRegisterPage.open();
    }


    @Step
    public void completeRegister(String name, String email, String password, Boolean shouldError) {
        completeName(name);
        completeEmail(email);
        completePassword(password);
        signup();
        checkError(shouldError);
    }
    @Step
    public void completeValidRegister() {
        completeName("balastudor");
        completeEmail("sdcbnjkhafasggfhgjkgfghjhghjkghjksdastudordanmnmnmnmnnmnmn");
        completePassword("ThisIsTheBestPassword");
        signup();
        checkError(false);
    }

    @Step
    public void completeInvalidLogin() {
        completeName("balastudor");
        completeEmail("sdcbnjkhafasggfhgjkgfghjhghjkghjksdastudordanmnmnmnmnnmnmn");
        completePassword("ThisIsTheBestPassword");
        signup();
        checkError(true);
    }

    @Step
    private void signup() {
        trelloRegisterPage.signup();
    }

    @Step
    private void completeName(String text) {
        trelloRegisterPage.enterNameText(text);
    }
    @Step
    private void completeEmail(String text) {
        trelloRegisterPage.enterEmailText(text);
    }

    @Step
    private void completePassword(String text) {
        trelloRegisterPage.enterPassword(text);
    }

    @Step
    public void checkError(boolean shouldError) {
        if(trelloRegisterPage.checkError()!=shouldError) {
            assert false;
        } else {
            assert true;
        }
    }
}
