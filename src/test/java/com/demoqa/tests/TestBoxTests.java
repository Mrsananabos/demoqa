package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browser_size", "1920x1180");
        Configuration.remote = System.getProperty("https://user1:1234@selenoid.autotests.cloud/wd/hub");

    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Rita");
        $("#userEmail").setValue("Rita@mail.ru");
        $("#currentAddress").setValue("some address");

        $("#submit").click();

        $("#output #name").shouldHave(text("Rita"));
        $("#output #email").shouldHave(text("Rita@mail.ru"));
        $("#output #currentAddress").shouldHave(text("some address"));
    }
}
