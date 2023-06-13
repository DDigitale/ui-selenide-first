package pages.page;

import com.codeborne.selenide.Condition;
import pages.component.CartFooter;
import pages.component.ProductItem;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage<P> extends BasePage<CartPage<P>> {
    private final P parent;

    public CartPage(P parent) {
        this.parent = parent;
    }

    public CartFooter getCartFooter() {
        return new CartFooter($x("//div[@class='cart_footer']"));
    }

    public ProductItem getCartListItemByHeader(String headerName) {
        return new ProductItem($x("//div[text()='" + headerName + "']//ancestor::div[@class='cart_item']"));
    }

    public CartPage<P> deleteInventory(String headerName) {
        getCartListItemByHeader(headerName).addToCartBtn().click();
        return this;
    }

    public CartPage checkThatItemAdded(String headerName) {
        getCartListItemByHeader(headerName).addToCartBtn().shouldHave(Condition.text("Remove"));
        return this;
    }

    public void checkCartItemIsDeleted(String title) {
        getCartListItemByHeader(title).name().shouldNotBe(Condition.visible);
    }

    public void checkOrderInCart(String firstItem, String secondItem, String thirdItem) {
        assertAll(
                () -> assertEquals(getCartListItemByHeader(firstItem).name().getText(), firstItem),
                () -> assertEquals(getCartListItemByHeader(secondItem).name().getText(), secondItem),
                () -> assertEquals(getCartListItemByHeader(thirdItem).name().getText(), thirdItem)
        );
    }
}
