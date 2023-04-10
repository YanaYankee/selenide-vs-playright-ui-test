package ua.com.touchstudio;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public void checkIfProductIsAddedToCart(String productName){
        $("h1.page-header").shouldHave(text("Корзина"));
        $$(".table-cart tbody tr").shouldHave(CollectionCondition.size(1));
        $("h3.product-title").shouldHave(text(productName));
    }
}
