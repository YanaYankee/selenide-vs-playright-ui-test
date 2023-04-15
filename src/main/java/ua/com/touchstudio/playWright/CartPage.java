package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    public CartPage(Page page) {
        this.page = page;
    }

    public CartPage checkIfProductIsAddedToCart(String productName) {
        new CommonPage(page)
                .assertText("h1.page-header", "Корзина")
                .visible("h3.product-title")
                .print("h3.product-title")
                .asertNumberOfProductsInCart("h3.product-title", 1)
                .assertText("h3.product-title", productName);
        return new CartPage(page);
    }

    public CartPage startCheckOut() {
        new CommonPage(page)
                .assertText(".custom-buy-buttom span", "Оформить заказ")
                .click(".custom-buy-buttom span");
        return new CartPage(page);
    }
}
