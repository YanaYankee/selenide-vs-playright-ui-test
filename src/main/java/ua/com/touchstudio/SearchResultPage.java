package ua.com.touchstudio;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    public String getSearchResultTitle(){
        return $("h1").getText();
    }
    public String getProductNameOnSearchResultPage(){
        return $("h2.product-name").getText();
    }
    public void addToCart(){
        $("div.add-to-cart-buttom > button").shouldHave(text("Додати у кошик")).click();
    }
    public String getNotificationText(){
        return $("[data-notify='message']").getText();
    }
    public SelenideElement checkNumberOfProductsAddedToCart(String expectedNumberOfProductsAdded){
        return $("li.menubar-cart span.cart-number")
                .shouldHave(text(expectedNumberOfProductsAdded));
    }
    public void goToCart(){
        $("li.menubar-cart i.icon-shopping-bag").click();
        $("div#cart-mini div.cart-action > a").shouldHave(text("Показать корзину")).click();
    }

}
