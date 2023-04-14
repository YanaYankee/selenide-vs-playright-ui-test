package ua.com.touchstudio;

import static com.codeborne.selenide.Selenide.$;


public class HomePage {
    public HomePage getSearchForm() {
        $("#open-search-form").click();
        return new HomePage();
    }

    public HomePage searchFor(String searchQuery) {
        $("[name='search']").val(searchQuery).pressEnter();
        return new HomePage();
    }
}