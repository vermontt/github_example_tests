package com.lazarev.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открыть страницу")
    public static void openPage() {
        open("https://github.com/");
    }

    @Step("Ввести в поле поиск 'selenide/selenide'")
    public static void unpitSearchText() {
        $x("//input[@name='q']").setValue("selenide/selenide").pressEnter();
        takeScreenshot();
    }

    @Step("Перейти по первой ссылке")
    public static void clickFirstLink() {
        $$x("//ul[@class=\"repo-list\"]//a").first().click();
    }

    @Step("Проверить наличие элемента 'Issues'")
    public static void assertElement() {
        $$x("//ul[@class=\"UnderlineNav-body list-style-none\"]//span")
                .shouldHave(itemWithText("Issues"));
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public static byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}