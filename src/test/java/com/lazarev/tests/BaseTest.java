package com.lazarev.tests;

import com.codeborne.selenide.Configuration;
import com.lazarev.config.AuthConfig;
import com.lazarev.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.System.getProperty;

public class BaseTest {

    public static AuthConfig authConfig = ConfigFactory.newInstance().create(AuthConfig.class);

    @BeforeAll
    static void setUp() {
        Configuration.browser = getProperty("browser");
        Configuration.browserSize = getProperty("browserSize");
        Configuration.startMaximized = Boolean.parseBoolean(getProperty("sizeWindow"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        String env = System.getProperty("host");

        Configuration.remote = (env.equals("local")) ? ("https://"
                + authConfig.getLogin()
                + ":"
                + authConfig.getPassword()
                + getProperty("URLRemoteBrowser"))
                : getProperty("URLRemoteBrowser");
    }

    @AfterAll
    static void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
