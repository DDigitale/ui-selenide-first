package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    private final SelenideElement cartButtonBadge = $(".shopping_cart_badge");
    private final SelenideElement continueShoppingButton = $("#continue-shopping");
    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement cartItem = $(".cart_item");

    public String getBadgeText() {
        if (cartButtonBadge.isDisplayed()) {
            return cartButtonBadge.getText();
        }
        return null;
    }

    public String getCartItem() {
        if (cartItem.isDisplayed()) {
            return cartItem.getText();
        }
        return null;
    }

    public String getCurrentUrl() {
        return getURL();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
        Selenide.sleep(700);
    }
}
