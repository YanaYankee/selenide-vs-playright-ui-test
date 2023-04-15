package ua.com.touchstudio;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ua.com.touchstudio.playWright.BasePage;

@ExtendWith({SoftAssertsExtension.class, ReportPortalExtension.class})
public class SearchPWTests extends BasePage {

    @Test
    void searchProductByTitle() {
        var productName = "Valve Steam Deck 64";
        var expectedSearchResultPageTitle = "Результат поиска";
        var expectedNotificationText = "Товар добавлен в корзину";
        var numberOfAddedProducts = "1";

        new ua.com.touchstudio.playWright.HomePage(page)
                .openSearchForm()
                .findProduct(productName);

        new ua.com.touchstudio.playWright.SearchResultPage(page)
                .checkSearchResultTitle(expectedSearchResultPageTitle)
                .checkProductNameOnSearchResultPage(productName)
                .addToCart()
                .checkNotificationText(expectedNotificationText)
                .checkNumberOfProductsAddedToCart(numberOfAddedProducts);
        new ua.com.touchstudio.playWright.SearchResultPage(page)
                .goToCart();

        new ua.com.touchstudio.playWright.CartPage(page)
                .checkIfProductIsAddedToCart(productName)
                .startCheckOut();
        new ua.com.touchstudio.playWright.CheckOutPage(page)
                .fillOutCheckOutForm();

    }
}
