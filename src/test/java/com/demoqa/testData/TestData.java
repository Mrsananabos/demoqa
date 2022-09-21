package com.demoqa.testData;

import com.github.javafaker.Faker;

import static java.lang.String.format;

public class TestData {
    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String userEmail = faker.internet().emailAddress();
    private String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    private String gender = "Male";
    private String day = String.valueOf(faker.number().numberBetween(1, 30));
    private String month = "July";
    private String year = String.valueOf(faker.number().numberBetween(1980, 2000));
    private String subject = "History";
    private String hobbies = "Reading";
    private String picture = "avatar.jpg";
    private String currentAddress = faker.address().fullAddress();
    private String state = "NCR";
    private String city = "Noida";
    private String fullName = format("%s %s", firstName, lastName);
    private String dateOfBirth = format("%s %s,%s", day, month, year);
    private String stateAndCity = format("%s %s", state, city);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStateAndCity() {
        return stateAndCity;
    }

    public String getGender() {
        return gender;
    }
}
