package com.demoqa.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.allure.AllureAttach;
import com.demoqa.testData.TestData;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1180");

        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
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

    @AfterEach
    void addAttachments() {
        AllureAttach.screenshotAs("Last screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        if (System.getProperty("remote") != null) {
            AllureAttach.addVideo();
        }
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
