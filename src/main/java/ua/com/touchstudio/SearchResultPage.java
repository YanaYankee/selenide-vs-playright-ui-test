package ua.com.touchstudio;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
        return $("[data-notify='message']").shouldBe(visible).getText();
    }
    public String getNumberOfProductsAddedToCart(){
        return $("li.menubar-cart span.cart-number").shouldBe(visible).getText();
    }
    public void goToCart(){
        $("li.menubar-cart i.icon-shopping-bag").click();
        $("div#cart-mini div.cart-action > a").shouldHave(text("Показать корзину")).click();
    }

}
