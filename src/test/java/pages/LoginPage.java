package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import utils.Urls;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement errorData = $x("//h3[@data-test='error']");


    public LoginPage openPage() {
        open(Urls.baseUrl);
        return this;
    }

    public LoginPage login() {
        usernameInput.setValue("standard_user");
        Selenide.sleep(500);
        passwordInput.setValue("secret_sauce");
        Selenide.sleep(500);
        passwordInput.sendKeys(Keys.ENTER);
        Selenide.sleep(500);
        return this;
    }

    public LoginPage loginWithoutUsernameAndPassword() {
        passwordInput.sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPage loginWithoutPassword() {
        usernameInput.setValue("standard_user");
        passwordInput.sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPage loginWithoutIncorrectCredentials() {
        usernameInput.setValue("foo");
        passwordInput.setValue("bar");
        passwordInput.sendKeys(Keys.ENTER);
        return this;
    }

    public String getErrorData() {
        Selenide.sleep(700);
        return errorData.getText();
    }

    public String getCurrentUrl() {
        return getURL();
    }

    public void successfulLogin() {
        new LoginPage().openPage().login();
    }


}
