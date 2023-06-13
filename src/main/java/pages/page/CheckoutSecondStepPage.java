package pages.page;

import pages.component.CheckoutOverview;
import pages.component.ProductItem;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSecondStepPage<P> extends BasePage<CheckoutSecondStepPage<P>> {
    private final P parent;

    public CheckoutSecondStepPage(P parent) {
        this.parent = parent;
    }

    public CheckoutOverview getCheckoutOverviewForm() {
        return new CheckoutOverview($("[class='checkout_summary_container'"));
    }

    public ProductItem getCartListItemByHeader(String headerName) {
        return new ProductItem($x("//div[text()='" + headerName + "']//ancestor::div[@class='cart_item']"));
    }

    public CheckoutSecondStepPage<P> checkItemsInCart(String firstItem, String secondItem) {
        assertAll(
                () -> assertEquals(getCartListItemByHeader(firstItem).name().getText(), firstItem),
                () -> assertEquals(getCartListItemByHeader(secondItem).name().getText(), secondItem)
        );
        return this;
    }

    public CheckoutSecondStepPage checkItemInCart(String item) {
        assertEquals(getCartListItemByHeader(item).name().getText(), item);
        return this;
    }
}
