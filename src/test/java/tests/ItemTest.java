package tests;

import org.junit.Test;
import pages.page.LoginPage;

public class ItemTest extends BaseTest {


    @Test
    public void sortAtoZ() {
        new LoginPage<>(this)
                .successfulLogin()
                .sortAtoZ();
    }

    @Test
    public void sortZtoA() {
        new LoginPage<>(this)
                .successfulLogin()
                .sortZtoA();
    }

    @Test
    public void sortLOtoHI() {
        new LoginPage<>(this)
                .successfulLogin()
                .sortLOtoHI();
    }

    @Test
    public void sortHItoLO() {
        new LoginPage<>(this)
                .successfulLogin()
                .sortHItoLO();
    }
}
