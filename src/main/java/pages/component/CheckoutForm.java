package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.page.CheckoutSecondStepPage;

public class CheckoutForm {
    public SelenideElement container;

    public CheckoutForm(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement firstNameInput() {
        return container.$("#first-name");
    }

    public SelenideElement lastNameInput() {
        return container.$("#last-name");
    }

    public SelenideElement postalCodeInput() {
        return container.$("#postal-code");
    }

    public SelenideElement errorMessage() {
        return container.$x(".//h3[@data-test='error']");
    }

    public CheckoutSecondStepPage<CheckoutForm> checkoutBtn() {
        container.$("#continue").click();
        return new CheckoutSecondStepPage<>(this);
    }
}
