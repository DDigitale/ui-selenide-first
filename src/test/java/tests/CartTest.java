package tests;

import org.junit.Test;
import pages.page.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addInventoryToCart() {
        new LoginPage<>(this)
                .successfulLogin()
                .checkInventoryItem("Sauce Labs Backpack")
                .addInventory("Sauce Labs Backpack")
                .checkThatItemAdded("Sauce Labs Backpack")
                .getHeader()
                .getBadgeValue("1")
                .cartButton();
    }

    @Test
    public void deleteInventoryFromCart() {
        new LoginPage<>(this)
                .successfulLogin()
                .checkInventoryItem("Sauce Labs Backpack")
                .addInventory("Sauce Labs Backpack")
                .checkThatItemAdded("Sauce Labs Backpack")
                .getHeader()
                .getBadgeValue("1")
                .cartButton()
                .deleteInventory("Sauce Labs Backpack")
                .checkCartItemIsDeleted("Sauce Labs Backpack");
    }

    @Test
    public void checkInventoriesOrderInCart() {
        new LoginPage<>(this)
                .successfulLogin()
                .addInventory("Sauce Labs Backpack")
                .addInventory("Sauce Labs Bolt T-Shirt")
                .addInventory("Sauce Labs Bike Light")
                .getHeader()
                .getBadgeValue("3")
                .cartButton()
                .checkOrderInCart("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light");
    }

    @Test
    public void openCartPageAndReturnToInventoryPage() {
        new LoginPage<>(this)
                .successfulLogin()
                .getHeader()
                .cartButton()
                .checkUrl("https://www.saucedemo.com/cart.html")
                .getCartFooter()
                .continueShopping()
                .checkUrl("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void checkoutWithoutFirstName() {
        new LoginPage<>(this)
                .successfulLogin()
                .getHeader()
                .cartButton()
                .getCartFooter()
                .checkout()
                .checkUrl("https://www.saucedemo.com/checkout-step-one.html")
                .setFirstName("")
                .setLastName("lastname")
                .setPostalCode("123")
                .clickContinueForCheck()
                .getErrorMessage("Error: First Name is required");
    }

    @Test
    public void checkoutWithoutLastName() {
        new LoginPage<>(this)
                .successfulLogin()
                .getHeader()
                .cartButton()
                .getCartFooter()
                .checkout()
                .checkUrl("https://www.saucedemo.com/checkout-step-one.html")
                .setFirstName("firstname")
                .setLastName("")
                .setPostalCode("123")
                .clickContinueForCheck()
                .getErrorMessage("Error: Last Name is required");
    }

    @Test
    public void checkoutWithoutPostalCode() {
        new LoginPage<>(this)
                .successfulLogin()
                .getHeader()
                .cartButton()
                .getCartFooter()
                .checkout()
                .checkUrl("https://www.saucedemo.com/checkout-step-one.html")
                .setFirstName("firstname")
                .setLastName("lastname")
                .setPostalCode("")
                .clickContinueForCheck()
                .getErrorMessage("Error: Postal Code is required");
    }

    @Test
    public void checkoutOneItem() {
        new LoginPage<>(this)
                .successfulLogin()
                .addInventory("Sauce Labs Backpack")
                .getHeader()
                .cartButton()
                .getCartFooter()
                .checkout()
                .checkUrl("https://www.saucedemo.com/checkout-step-one.html")
                .setFirstName("firstname")
                .setLastName("lastname")
                .setPostalCode("12345")
                .getCheckoutForm()
                .checkoutBtn()
                .checkUrl("https://www.saucedemo.com/checkout-step-two.html")
                .checkItemInCart("Sauce Labs Backpack")
                .getCheckoutOverviewForm()
                .finishCheckout()
                .checkUrl("https://www.saucedemo.com/checkout-complete.html")
                .getComplete()
                .backHomeBtn()
                .checkUrl("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void checkoutTwoItems() {
        new LoginPage<>(this)
                .successfulLogin()
                .addInventory("Sauce Labs Backpack")
                .addInventory("Sauce Labs Fleece Jacket")
                .getHeader()
                .cartButton()
                .getCartFooter()
                .checkout()
                .checkUrl("https://www.saucedemo.com/checkout-step-one.html")
                .setFirstName("firstname")
                .setLastName("lastname")
                .setPostalCode("12345")
                .getCheckoutForm()
                .checkoutBtn()
                .checkUrl("https://www.saucedemo.com/checkout-step-two.html")
                .checkItemsInCart("Sauce Labs Backpack", "Sauce Labs Fleece Jacket")
                .getCheckoutOverviewForm()
                .finishCheckout()
                .checkUrl("https://www.saucedemo.com/checkout-complete.html")
                .getComplete()
                .backHomeBtn()
                .checkUrl("https://www.saucedemo.com/inventory.html");
    }


}
