package com.lazarev.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }
}
