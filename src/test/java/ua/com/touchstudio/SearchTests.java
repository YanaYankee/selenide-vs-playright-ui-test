package ua.com.touchstudio;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTests {
    @BeforeEach
    void openHomePage() {
        open("https://touchstudio.com.ua/");
    }

    @Test
    void searchProductByTitle() {

        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        CartPage cartPage = new CartPage();

        String productName = "Valve Steam Deck 64";
        String expectedSearchResultPageTitle = "Результат поиска";

        homePage.getSearchForm();
        homePage.searchFor(productName);

        var actualSearchResultPageTitle = searchResultPage.getSearchResultTitle();
        assertEquals(expectedSearchResultPageTitle, actualSearchResultPageTitle);

        var actualProductNameOnSearchResultPage = searchResultPage.getProductNameOnSearchResultPage();
        assertEquals(productName, actualProductNameOnSearchResultPage);

        searchResultPage.addToCart();

        var expectedNotificationText = "Товар добавлен в корзину";
        var actualNotificationText = searchResultPage.getNotificationText();
        assertEquals(expectedNotificationText, actualNotificationText);

        var expectedNumberOfProductsAdded = "1";
        var actualNumberOfProductsAdded = searchResultPage.getNumberOfProductsAddedToCart();
        assertEquals(expectedNumberOfProductsAdded, actualNumberOfProductsAdded);

        searchResultPage.goToCart();

        cartPage.checkIfProductIsAddedToCart(productName);
    }
}
