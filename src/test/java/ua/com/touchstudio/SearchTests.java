package ua.com.touchstudio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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

        searchResultPage.checkNumberOfProductsAddedToCart("1");

        searchResultPage.goToCart();

        cartPage.checkIfProductIsAddedToCart(productName);
    }
}
