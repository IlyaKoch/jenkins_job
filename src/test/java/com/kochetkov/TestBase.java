package com.kochetkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2100x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Настройки для selenoid
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }
}