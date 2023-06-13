package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.page.LoginPage;

public class Sidebar {

    public SelenideElement container;

    public Sidebar(SelenideElement container) {
        this.container = container;
    }

    public Sidebar menuToggleButton() {
        container.$("#react-burger-menu-btn").click();
        return this;
    }

    public LoginPage<Sidebar> logoutButton() {
        container.$("#logout_sidebar_link").click();
        return new LoginPage<>(this);
    }

}

