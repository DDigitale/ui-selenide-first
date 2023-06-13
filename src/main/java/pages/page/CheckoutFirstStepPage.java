package pages.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.component.CheckoutForm;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutFirstStepPage<P> extends BasePage<CheckoutFirstStepPage<P>> {
    private final P parent;

    public CheckoutFirstStepPage(P parent) {
        this.parent = parent;
    }

    public CheckoutForm getCheckoutForm() {
        return new CheckoutForm($("[class='checkout_info_wrapper'"));
    }

    public CheckoutFirstStepPage setFirstName(String value) {
        getCheckoutForm().firstNameInput().setValue(value);
        return this;
    }

    public CheckoutFirstStepPage setLastName(String value) {
        getCheckoutForm().lastNameInput().setValue(value);
        return this;
    }

    public CheckoutFirstStepPage setPostalCode(String value) {
        getCheckoutForm().postalCodeInput().setValue(value);
        return this;
    }

    public SelenideElement getErrorMessage(String errorMessage) {
        return getCheckoutForm().errorMessage().shouldHave(Condition.text(errorMessage));
    }

    public CheckoutFirstStepPage clickContinueForCheck() {
        getCheckoutForm().checkoutBtn();
        return this;
    }


}
