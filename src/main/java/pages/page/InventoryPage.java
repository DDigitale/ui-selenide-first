package pages.page;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import pages.component.Header;
import pages.component.ProductItem;
import pages.component.SortSelect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage<P> extends BasePage<InventoryPage<P>> {
    private final P parent;

    public InventoryPage(P parent) {
        this.parent = parent;
    }

    private ProductItem getItemByHeader(String headerName) {
        return new ProductItem($x("//div[text()='" + headerName + "']//ancestor::div[@class='inventory_item']"));
    }

    private List<ProductItem> getAllTitles() {
        List<ProductItem> items = new ArrayList<>();
        $$x("//div[@class='inventory_item']").forEach(el -> items.add(new ProductItem(el)));

        return items;
    }

    public Header getHeader() {
        return new Header($x("//*[@id='header_container']"));
    }

    public SortSelect getSortSelect() {
        return new SortSelect($x("//select[@class='product_sort_container']"));
    }

    public InventoryPage addInventory(String headerName) {
        getItemByHeader(headerName).addToCartBtn().click();
        return this;
    }

    public InventoryPage checkThatItemAdded(String headerName) {
        getItemByHeader(headerName).addToCartBtn().shouldHave(Condition.text("Remove"));
        return this;
    }

    public InventoryPage checkInventoryItem(String title) {
        getItemByHeader(title).name().shouldHave(Condition.text(title));
        return this;
    }

    public void sortLOtoHI() {
        getSortSelect().sortLOtoHI();

        List<String> prices = new ArrayList<>();
        getAllTitles().forEach(item -> prices.add(item.price().getText()));

        Comparator<String> priceComparator = Comparator.comparing(i -> Double.parseDouble(i.replace("$", "")));

        List<String> sortedTitles = new ArrayList<>(prices);
        Collections.sort(prices, priceComparator);

        Assert.assertArrayEquals(sortedTitles.toArray(), prices.toArray());
    }

    public void sortHItoLO() {
        getSortSelect().sortHItoLO();

        List<String> prices = new ArrayList<>();
        getAllTitles().forEach(item -> prices.add(item.price().getText()));

        Comparator<String> priceComparator = Comparator.comparing(i -> Double.parseDouble(i.replace("$", "")));

        List<String> sortedTitles = new ArrayList<>(prices);
        Collections.sort(prices, priceComparator.reversed());

        Assert.assertArrayEquals(sortedTitles.toArray(), prices.toArray());
    }

    public void sortAtoZ() {
        getSortSelect().sortAtoZ();

        List<String> titles = new ArrayList<>();
        getAllTitles().forEach(item -> titles.add(item.name().getText()));

        List<String> sortedTitles = new ArrayList<>(titles);
        Collections.sort(sortedTitles);

        Assert.assertArrayEquals(sortedTitles.toArray(), titles.toArray());
    }

    public void sortZtoA() {
        getSortSelect().sortZtoA();

        List<ProductItem> items = getAllTitles();

        List<String> titles = new ArrayList<>();
        getAllTitles().forEach(item -> titles.add(item.name().getText()));

        List<String> sortedTitles = new ArrayList<>(titles);
        Collections.sort(sortedTitles, Comparator.reverseOrder());

        Assert.assertArrayEquals(sortedTitles.toArray(), titles.toArray());
    }

}
