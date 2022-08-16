package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {

    public CalendarComponents setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String dayFormat = Integer.parseInt(day) < 10 ? "00" + day : "0" + day;
        $(".react-datepicker__day--" + dayFormat + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

}
