package ua.com.touchstudio;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public void getSearchResultTitle(String title) {
        $("h1").shouldHave(text(title));
    }

    public void getProductNameOnSearchResultPage(String productName) {
        $("h2.product-name").shouldHave(text(productName));
    }

    public void addToCart() {
        $("div.add-to-cart-buttom > button").shouldHave(text("Додати у кошик")).click();
    }

    public void getNotificationText(String notification) {
        $("[data-notify='message']").shouldHave(text(notification));
    }

    public SelenideElement checkNumberOfProductsAddedToCart(String expectedNumberOfProductsAdded) {
        return $("li.menubar-cart span.cart-number")
                .shouldHave(text(expectedNumberOfProductsAdded));
    }

    public void goToCart() {
        $("li.menubar-cart i.icon-shopping-bag").click();
        $("div#cart-mini div.cart-action > a").shouldHave(text("Показать корзину")).click();
    }

}
