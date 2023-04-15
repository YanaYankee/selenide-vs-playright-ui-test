package ua.com.touchstudio.playWright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BasePage {

    /**
     * Page
     */

    public Page page;
    private Browser browser;

    @BeforeEach
    public void setUp() {

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        //A single browser tab
        page = browser.newPage();
        // page.setViewportSize(1536, 960);

        page.navigate("https://touchstudio.com.ua");
    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

}


