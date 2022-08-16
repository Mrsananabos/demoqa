package com.demoqa.pages;

import com.demoqa.pages.components.CalendarComponents;
import com.demoqa.pages.components.ResultsTableComponent;

import java.util.Map;
import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponents calendarComponents = new CalendarComponents();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setHobbies(Set<String> hobbies) {
        hobbies.forEach(hobby -> $("#hobbiesWrapper").$(byText(hobby)).click());
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String stateName) {
        return setLocation("state", stateName);
    }

    public RegistrationFormPage setCity(String cityName) {
        return setLocation("city", cityName);
    }

    public RegistrationFormPage submitForm() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult(Map<String, String> expectedValue) {
        resultsTableComponent.checkResult(expectedValue);
        return this;
    }

    public RegistrationFormPage isVisibleResultedTable() {
        resultsTableComponent.isVisible();
        return this;
    }

    public RegistrationFormPage checkButton(String value) {
        $(".modal-footer").shouldHave(text(value));
        return this;
    }

    private RegistrationFormPage setLocation(String locationName, String value) {
        $("#" + locationName).click();
        $(byText(value)).click();
        return this;
    }
}
