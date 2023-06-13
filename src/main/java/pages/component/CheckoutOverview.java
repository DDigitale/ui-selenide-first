package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.page.CheckoutCompletePage;

public class CheckoutOverview {
    public SelenideElement container;

    public CheckoutOverview(SelenideElement container) {
        this.container = container;
    }

    public CheckoutCompletePage<CheckoutOverview> finishCheckout() {
        container.$("#finish").click();
        return new CheckoutCompletePage<>(this);
    }

}
