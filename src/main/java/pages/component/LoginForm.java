package pages.component;

import com.codeborne.selenide.SelenideElement;

public class LoginForm {

    public SelenideElement container;

    public LoginForm(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement usernameInput() {
        return container.$("#user-name");
    }

    public SelenideElement passwordInput() {
        return container.$("#password");
    }

    public SelenideElement loginButton() {
        return container.$("#login-button");
    }

    public SelenideElement errorMessage() {
        return container.$x(".//h3[@data-test='error']");
    }

}
