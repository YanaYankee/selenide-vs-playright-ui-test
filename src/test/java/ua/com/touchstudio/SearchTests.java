package ua.com.touchstudio;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith({SoftAssertsExtension.class, ReportPortalExtension.class})
public class SearchTests extends BaseTest {
    @BeforeEach
    void openHomePage() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void searchProductByTitle() {

        var productName = "Valve Steam Deck 64";
        var expectedSearchResultPageTitle = "Результат поиска";
        var expectedNotificationText = "Товар добавлен в корзину";
        var numberOfAddedProducts = "1";

        new HomePage()
                .getSearchForm()
                .searchFor(productName);

        new SearchResultPage()
                .getSearchResultTitle(expectedSearchResultPageTitle)
                .getProductNameOnSearchResultPage(productName)
                .addToCart()
                .getNotificationText(expectedNotificationText)
                .checkNumberOfProductsAddedToCart(numberOfAddedProducts);
        new SearchResultPage().goToCart();

        new CartPage().checkIfProductIsAddedToCart(productName);
    }
}
