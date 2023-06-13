package pages.component;

import com.codeborne.selenide.SelenideElement;

public class ProductItem {

    public SelenideElement container;

    public ProductItem(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement name() {
        return container.$("[class='inventory_item_name']");
    }

    public SelenideElement description() {
        return container.$("[class='inventory_item_desc']");
    }

    public SelenideElement price() {
        return container.$("[class='inventory_item_price']");
    }

    public SelenideElement addToCartBtn() {
        return container.$x(".//button");
    }

    public SelenideElement image() {
        return container.$("[class='inventory_item_img']");
    }
}
