package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public HomePage openSearchForm() {
        new CommonPage(page)
                .click("#open-search-form");
        return new HomePage(page);
    }

    public HomePage findProduct(String searchQuery) {
        new CommonPage(page)
                .fill("[name='search']", searchQuery)
                .pressEnter();
        return new HomePage(page);
    }
}
