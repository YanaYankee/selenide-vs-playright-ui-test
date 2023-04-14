package ua.com.touchstudio;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public SearchResultPage getSearchResultTitle(String title) {
        $("h1").shouldHave(text(title));
        return new SearchResultPage();
    }

    public SearchResultPage getProductNameOnSearchResultPage(String productName) {
        $("h2.product-name").shouldHave(text(productName));
        return new SearchResultPage();
    }

    public SearchResultPage addToCart() {
        $("div.add-to-cart-buttom > button").shouldHave(text("Додати у кошик")).click();
        return new SearchResultPage();
    }

    public SearchResultPage getNotificationText(String notification) {
        $("[data-notify='message']").shouldHave(text(notification));
        return new SearchResultPage();
    }

    public SelenideElement checkNumberOfProductsAddedToCart(String expectedNumberOfProductsAdded) {
        return $("li.menubar-cart span.cart-number")
                .shouldHave(text(expectedNumberOfProductsAdded));
    }

    public SearchResultPage goToCart() {
        $("li.menubar-cart i.icon-shopping-bag").click();
        $("div#cart-mini div.cart-action > a").shouldHave(text("Показать корзину")).click();
        return new SearchResultPage();
    }

}
