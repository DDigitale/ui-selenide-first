package pages.component;

import com.codeborne.selenide.SelenideElement;

public class SortSelect {
    public SelenideElement container;

    public SortSelect(SelenideElement container) {
        this.container = container;
    }

    public SortSelect sortAtoZ() {
        container.$x(".//option[@value='az']").click();
        return this;
    }

    public SortSelect sortZtoA() {
        container.$x(".//option[@value='za']").click();
        return this;
    }

    public SortSelect sortLOtoHI() {
        container.$x(".//option[@value='lohi']").click();
        return this;
    }

    public SortSelect sortHItoLO() {
        container.$x(".//option[@value='hilo']").click();
        return this;
    }
}