package ua.com.touchstudio;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTests extends BaseTest {
    @BeforeEach
    void openHomePage() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void searchProductByTitle() {

        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        CartPage cartPage = new CartPage();

        var productName = "Valve Steam Deck 64";
        var expectedSearchResultPageTitle = "Результат поиска";
        var expectedNotificationText = "Товар добавлен в корзину";
        var numberOfAddedProducts = "1";


        homePage.getSearchForm();
        homePage.searchFor(productName);

        searchResultPage.getSearchResultTitle(expectedSearchResultPageTitle);
        searchResultPage.getProductNameOnSearchResultPage(productName);
        searchResultPage.addToCart();

        searchResultPage.getNotificationText(expectedNotificationText);
        searchResultPage.checkNumberOfProductsAddedToCart(numberOfAddedProducts);

        searchResultPage.goToCart();
        cartPage.checkIfProductIsAddedToCart(productName);
    }
}
