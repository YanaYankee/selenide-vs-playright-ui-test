package ua.com.touchstudio;

import com.codeborne.selenide.Configuration;

public abstract class BaseTest {
    static {
    Configuration.baseUrl = "https://touchstudio.com.ua";
    Configuration.browser = "safari";
    }
}
