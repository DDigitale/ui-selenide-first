package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.page.InventoryPage;

public class CheckoutComplete {
    public SelenideElement container;

    public CheckoutComplete(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement completeText() {
        return container.$("[class='complete-header']");
    }

    public InventoryPage<CheckoutComplete> backHomeBtn() {
        container.$("#back-to-products").click();
        return new InventoryPage<>(this);
    }
}
