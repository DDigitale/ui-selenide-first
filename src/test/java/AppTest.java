import com.codeborne.selenide.Selenide;
import org.junit.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.Urls;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class AppTest extends BaseTest {

    @Test
    public void loginWithInvalidCredentialsTest() {
        String usernameErrorMessage = new LoginPage()
                .openPage()
                .loginWithoutUsernameAndPassword()
                .getErrorData();

        assertEquals(usernameErrorMessage, "Epic sadface: Username is required");

        String passwordErrorMessage = new LoginPage()
                .openPage()
                .loginWithoutPassword()
                .getErrorData();

        assertEquals(passwordErrorMessage, "Epic sadface: Password is required");

        String incorrectCredentialsMessage = new LoginPage()
                .openPage()
                .loginWithoutIncorrectCredentials()
                .getErrorData();

        assertEquals(incorrectCredentialsMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithValidCredentialsTest() {
        String url = new LoginPage()
                .openPage()
                .login()
                .getCurrentUrl();

        assertEquals(url, Urls.baseUrl + Urls.inventoryUrl);
    }

    @Test
    public void emptyCartTest() {
        new LoginPage().successfulLogin();
        new InventoryPage().openCartPage();
        CartPage cartPage = new CartPage();
        String url = cartPage.getCurrentUrl();
        String badge = cartPage.getBadgeText();
        String cart = cartPage.getCartItem();
        assertEquals(url, Urls.baseUrl + Urls.cartUrl);
        assertNull(badge);
        assertNull(cart);
        cartPage.clickContinueShopping();
        url = cartPage.getCurrentUrl();
        assertEquals(url, Urls.baseUrl + Urls.inventoryUrl);
    }

    @Test
    public void addAndRemoveInventoriesInCart() {
        new LoginPage().successfulLogin();
        InventoryPage invPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        invPage.addInventory(1);
        assertEquals(cartPage.getBadgeText(), "1");
        invPage.removeInventory(1);
        assertNull(cartPage.getBadgeText());
        invPage.addInventory(3);
        assertEquals(cartPage.getBadgeText(), "3");
        invPage.removeInventory(3);
        assertNull(cartPage.getBadgeText());
    }

}
