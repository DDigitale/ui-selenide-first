package steps.pageStep;

import pages.page.BasePage;

import static com.codeborne.selenide.Selenide.page;

public abstract class BaseStep<P extends BaseStep<P>> {
    private final BasePage basePage;

    public BaseStep() {
        basePage = page(BasePage.class);
    }

    public abstract P checkThatPageLoaded();

    public LoginPageStep clickOnLoginButton() {
        basePage.getURL();
        return new LoginPageStep();
    }


}
