package com.lazarev.tests;

import com.codeborne.selenide.Configuration;
import com.lazarev.helpers.Attach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.System.getProperty;

public class BaseTest {



    @BeforeAll
    static void setUp() {
        Configuration.browser = getProperty("browser");
        Configuration.browserSize = getProperty("browserSize");
        Configuration.startMaximized = Boolean.parseBoolean(getProperty("sizeWindow"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterAll
    static void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
