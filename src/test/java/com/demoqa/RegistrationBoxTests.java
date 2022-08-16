package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillRegistrationFormPositiveTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Smirnov");
        $("#userEmail").setValue("Smirnov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userForm #userNumber").setValue("1112223330");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");
        $("#currentAddress").setValue("Milan");
        $("#stateCity-wrapper").$(byText("Select State")).scrollTo().click();
        $(byText("Haryana")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Petr"),
                text("Smirnov"),
                text("Smirnov@mail.ru"),
                text("Male"),
                text("1112223330"),
                text("26 January,1991"),
                text("Computer Science"),
                text("Music"),
                text("avatar.jpg"),
                text("Milan"),
                text("Haryana Karnal"));
    }
}
