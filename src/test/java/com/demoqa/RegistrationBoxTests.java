package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1024x768";
    }

    @Test
    void fillRegistrationFormPositiveTest() {
        open("/automation-practice-form");
        $("#userForm #firstName").setValue("Petr");
        $("#userForm #lastName").setValue("Smirnov");
        $("#userForm #userEmail").setValue("Smirnov@mail.ru");
        $(byText("Male")).click();
        $("#userForm #userNumber").setValue("1112223330");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");
        $("#currentAddress").setValue("Milan");

        $(byText("Select State")).scrollTo().click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();

        $("#submit").scrollTo().click();

        System.out.println("dd");

        $(".modal-content").shouldHave(text("Petr"),
                text("Smirnov"),
                text("Smirnov@mail.ru"),
                text("Male"),
                text("1112223330"),
                text("05 January,1991"),
                text("Computer Science"),
                text("Music"),
                text("avatar.jpg"),
                text("Milan"),
                text("Haryana Karnal"));
    }
}
