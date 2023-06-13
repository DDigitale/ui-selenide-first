package tests;

import org.junit.Test;
import pages.page.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void successfulLogin() {
        new LoginPage<>(this)
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLogin()
                .checkUrl("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void checkItemsOnInventoryPage() {
        new LoginPage<>(this)
                .successfulLogin()
                .checkInventoryItem("Sauce Labs Backpack")
                .checkInventoryItem("Sauce Labs Bike Light")
                .checkInventoryItem("Sauce Labs Bolt T-Shirt")
                .checkInventoryItem("Sauce Labs Fleece Jacket")
                .checkInventoryItem("Sauce Labs Onesie")
                .checkInventoryItem("Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void loginWithWrongPassword() {
        new LoginPage<>(this)
                .setUsername("standard_user")
                .setPassword("foobar")
                .clickLogin()
                .getErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithWrongUsername() {
        new LoginPage<>(this)
                .setUsername("foobar")
                .setPassword("secret_sauce")
                .clickLogin()
                .getErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void logout() {
        new LoginPage<>(this)
                .successfulLogin()
                .getHeader()
                .menuToggleButton()
                .logoutButton()
                .checkUrl("https://www.saucedemo.com/");
    }


}
