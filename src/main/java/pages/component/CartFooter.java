package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.page.CheckoutFirstStepPage;
import pages.page.InventoryPage;

public class CartFooter {
    public SelenideElement container;

    public CartFooter(SelenideElement container) {
        this.container = container;
    }

    public CheckoutFirstStepPage<CartFooter> checkout() {
        container.$("#checkout").click();
        return new CheckoutFirstStepPage<>(this);
    }

    public InventoryPage<CartFooter> continueShopping() {
        container.$("#continue-shopping").click();
        return new InventoryPage<>(this);
    }
}
