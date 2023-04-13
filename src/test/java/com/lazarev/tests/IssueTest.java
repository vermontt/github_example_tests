package com.lazarev.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;
import static com.lazarev.steps.WebSteps.*;
import static io.qameta.allure.Allure.step;

/**
 * Различные варианты тестов с прописанными шагами Allure
 */
@Epic("Проверка Github элементов")
@Feature("Проверка navbar")
public class IssueTest extends BaseTest {

    @Test
    @Tag("anyTest")
    @Story("Проверка наличия элемента 'Issues' #1")
    @Owner("Евгений")
    public void issueGithubTest() {
        open("https://github.com/");
        $x("//input[@name='q']").setValue("selenide/selenide").pressEnter();
        $$x("//ul[@class=\"repo-list\"]//a").first().click();
        $$x("//ul[@class=\"UnderlineNav-body list-style-none\"]//span")
                .shouldHave(itemWithText("Issues"));
    }

    @Test
    @Tag("twoTest")
    @Story("Проверка наличия элемента 'Issues' #2")
    @Owner("Евгений")
    public void issueGithubTest2() {
        step("Открыть страницу Github",
                () -> {
                    open("https://github.com/");
                    takeScreenshot();
                }
        );

        step("В поле поиска ввести 'selenide/selenide'",
                () -> $x("//input[@name='q']").setValue("selenide/selenide").pressEnter());

        step("Выбрать первую ссылку на репозиторий",
                () -> $$x("//ul[@class=\"repo-list\"]//a").first().click());

        step("Проверить репозиторий на наличие элемента 'Issues'",
                () -> $$x("//ul[@class=\"UnderlineNav-body list-style-none\"]//span")
                        .shouldHave(itemWithText("Issues")));
    }

    @Test
    @Story("Проверка наличия элемента 'Issues' #3")
    @Owner("Евгений")
    public void issueGithubTest3() {
        openPage();
        unpitSearchText();
        clickFirstLink();
        assertElement();
    }
}