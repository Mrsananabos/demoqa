package com.demoqa.base;

import com.codeborne.selenide.Configuration;
import com.demoqa.testData.TestData;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

public class TestBase {
    private TestData testData = new TestData();
    protected String firstName,
            lastName,
            fullName,
            email,
            gender,
            mobile,
            dateOfBirth,
            subjects,
            date,
            month,
            year,
            hobbies,
            picture,
            state,
            city,
            stateAndCity,
            currentAddress;

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void prepareData() {
        firstName = testData.getFirstName();
        lastName = testData.getLastName();
        fullName = testData.getFullName();
        email = testData.getUserEmail();
        gender = testData.getGender();
        mobile = testData.getPhoneNumber();
        date = testData.getDay();
        month = testData.getMonth();
        year = testData.getYear();
        dateOfBirth = testData.getDateOfBirth();
        subjects = testData.getSubject();
        hobbies = testData.getHobbies();
        picture = testData.getPicture();
        state = testData.getState();
        city = testData.getCity();
        stateAndCity = testData.getStateAndCity();
        currentAddress = testData.getCurrentAddress();
    }

    protected Map<String, String> getExpectedValue() {
        return ImmutableMap.of(
                "Student Name", fullName,
                "Student Email", email,
                "Gender", gender,
                "Mobile", mobile,
                "Date of Birth", dateOfBirth,
                "Subjects", subjects,
                "Hobbies", hobbies,
                "Picture", picture,
                "Address", currentAddress,
                "State and City", stateAndCity);
    }
}
