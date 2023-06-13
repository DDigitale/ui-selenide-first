package pages.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static junit.framework.TestCase.assertEquals;

public abstract class BasePage<P extends BasePage<P>> {
    protected void open(String url) {
        Selenide.open(url);
    }

    public String getURL() {
        return WebDriverRunner.url();
    }

    public P checkUrl(String url) {
        assertEquals(url, getURL());
        return (P) this;
    }
}

