package steps.pageStep;

import pages.page.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageStep extends BaseStep<LoginPageStep> {

    private final LoginPage page;

    public LoginPageStep() {
        page = page(LoginPage.class);
        checkThatPageLoaded();
    }

    @Override
    public LoginPageStep checkThatPageLoaded() {
        //
        return this;
    }

}
