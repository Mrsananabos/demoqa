package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegistrationBoxTests {
    private RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private Map<String, String> expectedValue = new HashMap<>();
    {
        expectedValue.put("Student Name", "Petr Smirnov");
        expectedValue.put("Student Email", "Smirnov@mail.ru");
        expectedValue.put("Gender", "Male");
        expectedValue.put("Mobile", "1112223330");
        expectedValue.put("Date of Birth", "09 January,1991");
        expectedValue.put("Subjects", "Computer Science");
        expectedValue.put("Hobbies", "Music");
        expectedValue.put("Picture", "avatar.jpg");
        expectedValue.put("Address", "Milan");
        expectedValue.put("State and City", "Haryana Karnal");
    }

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillRegistrationFormPositiveTest() {
        registrationFormPage
                .openPage()
                .setFirstName("Petr")
                .setLastName("Smirnov")
                .setEmail("Smirnov@mail.ru")
                .setGender("Male")
                .setNumber("1112223330")
                .setBirthDay("9", "January", "1991")
                .setSubject("Computer Science")
                .setHobbies(Set.of("Music"))
                .uploadFile("avatar.jpg")
                .setAddress("Milan")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm()
                .isVisibleResultedTable()
                .checkResult(expectedValue);
    }
}
