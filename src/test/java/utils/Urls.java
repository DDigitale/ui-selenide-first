package utils;

public enum Urls {
    BASE_URL("https://www.saucedemo.com/"),
    INVENTORY_URL("inventory.html"),
    CART_URL("cart.html");

    public static final String baseUrl = BASE_URL.getUrl();
    public static final String inventoryUrl = INVENTORY_URL.getUrl();
    public static final String cartUrl = CART_URL.getUrl();
    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

