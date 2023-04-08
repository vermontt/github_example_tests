package com.lazarev.tests;

import com.lazarev.helpers.Attach;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideTest extends BaseTest {

    @Test
    @Story("Test github")
    public void selenidePageTest() {
        open("https://github.com/selenide/selenide");
        $x("//li/a[@id=\"wiki-tab\"]").click();
        $x("//div/ul[@data-filterable-for=\"wiki-pages-filter\"]/li//button").click();
        $$x("//div/ul[@data-filterable-for=\"wiki-pages-filter\"]/li//a")
                .shouldHave(itemWithText("SoftAssertions"));
        $x("//div/ul[@data-filterable-for=\"wiki-pages-filter\"]" +
                "/li//a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $$x("//div[@class=\"markdown-body\"]/h4")
                .shouldHave(itemWithText("3. Using JUnit5 extend test class:"));
    }
}