package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Page;

public class CheckOutPage extends BasePage {
    public CheckOutPage(Page page) {
        this.page = page;
    }

    public CheckOutPage fillOutCheckOutForm() {
        new CommonPage(page)
                .assertText("h1.page-header", "Оформление заказа")
                .fill("//*[@id='first_name']", "Name")
                .fill("//*[@id='last_name']", "Namename")
                .fill("//*[@id='email_address']", "name@gmail.com")
                .fill("//*[@id='phone']", "380995556677")
                .click("//*[@value='courier']")
                .fill("//*[@id='order-notes']", "Some order notes to fill out to test");
        //Wait to check with eyes :-)
        page.waitForTimeout(3000);
        return new CheckOutPage(page);
    }
}
