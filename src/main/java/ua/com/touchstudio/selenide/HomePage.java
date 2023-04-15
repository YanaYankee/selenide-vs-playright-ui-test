package ua.com.touchstudio.selenide;

import static com.codeborne.selenide.Selenide.$;


public class HomePage {
    public HomePage openSearchForm() {
        $("#open-search-form").click();
        return new HomePage();
    }

    public HomePage searchFor(String searchQuery) {
        $("[name='search']").val(searchQuery).pressEnter();
        return new HomePage();
    }
}