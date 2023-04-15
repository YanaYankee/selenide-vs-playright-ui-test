package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Page;

public class SearchResultPage extends BasePage {
    public SearchResultPage(Page page) {
        this.page = page;
    }

    public SearchResultPage checkSearchResultTitle(String title) {
        new CommonPage(page)
                .assertText("h1", title);
        return new SearchResultPage(page);
    }

    public SearchResultPage checkProductNameOnSearchResultPage(String productName) {
        new CommonPage(page)
                .assertText("h2.product-name", productName);
        return new SearchResultPage(page);
    }

    public SearchResultPage addToCart() {
        new CommonPage(page)
                .assertText("div.add-to-cart-buttom > button", "Додати у кошик")
                .click("div.add-to-cart-buttom > button");
        return new SearchResultPage(page);
    }

    public SearchResultPage checkNotificationText(String notification) {
        new CommonPage(page)
                .assertText("[data-notify='message']", notification);
        return new SearchResultPage(page);
    }

    public SearchResultPage checkNumberOfProductsAddedToCart(String expectedNumberOfProductsAdded) {
        new CommonPage(page)
                .visible("li.menubar-cart span.cart-number")
                .assertText("li.menubar-cart span.cart-number", expectedNumberOfProductsAdded);
        return new SearchResultPage(page);
    }

    public SearchResultPage goToCart() {
        new CommonPage(page)
                .click("li.menubar-cart i.icon-shopping-bag")
                .assertText("div#cart-mini div.cart-action > a", "Показать корзину")
                .click("div#cart-mini div.cart-action > a");
        return new SearchResultPage(page);
    }
}
