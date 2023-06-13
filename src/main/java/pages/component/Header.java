package pages.component;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import pages.page.CartPage;

import static com.codeborne.selenide.Selenide.$x;

public class Header {
    public SelenideElement container;

    public Header(SelenideElement container) {
        this.container = container;
    }

    public Sidebar menuToggleButton() {
        container.$("#react-burger-menu-btn").click();
        return new Sidebar($x("//div[@class='bm-menu-wrap']"));
    }

    public CartPage<Header> cartButton() {
        container.$x(".//a[@class='shopping_cart_link']").click();
        return new CartPage<>(this);
    }

    public Header getBadgeValue(String value) {
        Assert.assertEquals(value, container.$x(".//span[contains(@class, 'shopping_cart_badge')]").getText());
        return this;
    }

}
