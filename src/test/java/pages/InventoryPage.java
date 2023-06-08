package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage extends BasePage {
    private final SelenideElement inventoryLink = $("//*[@id='item_4_title_link']");
    private final SelenideElement cartButton = $x("//a[@class='shopping_cart_link']");
    private final SelenideElement firstInventoryAdd = $x("//*[@id='add-to-cart-sauce-labs-backpack']");
    private final SelenideElement secondInventoryAdd = $x("//*[@id='add-to-cart-sauce-labs-bike-light']");
    private final SelenideElement thirdInventoryAdd = $x("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    private final SelenideElement firstInventoryRemove = $x("//*[@id='remove-sauce-labs-backpack']");
    private final SelenideElement secondInventoryRemove = $x("//*[@id='remove-sauce-labs-bike-light']");
    private final SelenideElement thirdInventoryRemove = $x("//*[@id='remove-sauce-labs-bolt-t-shirt']");
    private final ElementsCollection inventoryItemLink = $$(".inventory_list .inventory_item");


    public void openCartPage() {
        cartButton.click();
        Selenide.sleep(1000);
    }

    public void addInventory(Integer elemsQty) {
        if (elemsQty == 1) {
            firstInventoryAdd.click();
        } else if (elemsQty == 3) {
            firstInventoryAdd.click();
            secondInventoryAdd.click();
            thirdInventoryAdd.click();
        }

        Selenide.sleep(1000);
    }

    public void removeInventory(Integer elemsQty) {
        if (elemsQty == 1) {
            firstInventoryRemove.click();
        } else if (elemsQty == 3) {
            firstInventoryRemove.click();
            secondInventoryRemove.click();
            thirdInventoryRemove.click();
        }
    }


    public String getInventoryItems() {
        return inventoryItemLink.first().getText();
    }

}
