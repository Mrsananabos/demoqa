package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com/";
        Selenide.clearBrowserCookies();
    }

    @Test
    void fillFormTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link button")
                .scrollIntoView(false)
                .click();
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $("[data-filterable-for=wiki-pages-filter]").find(byText("SoftAssertions")).click();
        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"));
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
