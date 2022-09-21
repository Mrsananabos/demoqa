package com.demoqa.tests;

import com.demoqa.base.TestBase;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class RegistrationBoxTests extends TestBase {

    private RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillRegistrationFormPositiveTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDay(date, month, year)
                .setSubject(subjects)
                .setHobbies(Set.of(hobbies))
                .uploadFile(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .isVisibleResultedTable()
                .checkResult(getExpectedValue());
    }

}
