package pages.page;


import pages.component.CheckoutComplete;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage<P> extends BasePage<CheckoutCompletePage<P>> {
    private final P parent;

    public CheckoutCompletePage(P parent) {
        this.parent = parent;
    }

    public CheckoutComplete getComplete() {
        return new CheckoutComplete($("#checkout_complete_container"));
    }
}
