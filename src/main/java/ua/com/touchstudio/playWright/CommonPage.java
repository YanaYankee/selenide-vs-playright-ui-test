package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonPage extends BasePage {
    public CommonPage(Page page) {
        this.page = page;
    }

    public CommonPage assertText(String selector, String expectedText) {
        assertThat(page.locator(selector)).containsText(new String[]{expectedText});
        return new CommonPage(page);
    }

    public int checkProductsNumberOnCartTable(String rowClass) {
        return page.locator(rowClass).count();
    }

    public CommonPage asertNumberOfProductsInCart(String rowClass, int expectedNum) {
        Assertions.assertEquals(checkProductsNumberOnCartTable(rowClass), expectedNum);
        return new CommonPage(page);
    }

    public CommonPage click(String locator) {
        page.click(locator);
        return new CommonPage(page);
    }

    public CommonPage visible(String locator) {
        assertThat(page.locator(locator)).isVisible();
        return new CommonPage(page);
    }

    public CommonPage fill(String locator, String searchQuery) {
        page.fill(locator, searchQuery);
        return new CommonPage(page);
    }

    public CommonPage pressEnter() {
        page.keyboard().press("Enter");
        return new CommonPage(page);
    }

    public CommonPage print(String locator) {
        System.out.println("Results for .count(): " + page.locator(locator).count());
        return new CommonPage(page);
    }

}
