package tests;

import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    public void setup() {
        Config.getInstance();
    }

    @Before
    public void initDriver() {
        Selenide.open("https://www.saucedemo.com/");
        setup();
    }

    @After
    public void closeDriver() {
//        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
