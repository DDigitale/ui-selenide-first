package pages.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.component.LoginForm;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage<P> extends BasePage<LoginPage<P>> {
    private final P parent;

    public LoginPage(P parent) {
        this.parent = parent;
    }

    private LoginForm getLoginForm() {
        return new LoginForm($x("//div[@class='login_wrapper-inner']"));
    }

    public LoginPage setUsername(String value) {
        getLoginForm().usernameInput().setValue(value);
        return this;
    }

    public LoginPage clearUsername() {
        getLoginForm().usernameInput().clear();
        return this;
    }

    public LoginPage checkUsername(String value) {
        getLoginForm().usernameInput().shouldHave(Condition.text(value));
        return this;
    }

    public LoginPage setPassword(String value) {
        getLoginForm().passwordInput().setValue(value);
        return this;
    }

    public LoginPage clearPassword() {
        getLoginForm().passwordInput().clear();
        return this;
    }

    public LoginPage checkPassword(String value) {
        getLoginForm().passwordInput().shouldHave(Condition.text(value));
        return this;
    }

    public LoginPage clickLogin() {
        getLoginForm().loginButton().click();
        return this;
    }

    public SelenideElement getErrorMessage(String errorMessage) {
        return getLoginForm().errorMessage().shouldHave(Condition.text(errorMessage));
    }

    public String getCurrentUrl() {
        return getURL();
    }


    public InventoryPage<LoginPage> successfulLogin() {
        setUsername("standard_user");
        setPassword("secret_sauce");
        getLoginForm().loginButton().click();
        return new InventoryPage<>(this);
    }

}
