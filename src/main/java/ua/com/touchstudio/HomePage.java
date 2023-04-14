package ua.com.touchstudio;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public void getSearchForm() {
        $("#open-search-form").click();
    }

    public void searchFor(String searchQuery) {
        $("[name='search']").val(searchQuery).pressEnter();
    }
}