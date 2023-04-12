package ua.com.touchstudio;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;

public abstract class BaseTest {
    static {
    Configuration.baseUrl = "https://touchstudio.com.ua";
    Configuration.browser = "safari";
    Configuration.browserVersion = "15.4";
    Configuration.assertionMode = AssertionMode.STRICT;

    SelenideLogger.addListener("Report Portal logger", new ReportPortalSelenideEventListener());

    }
}
