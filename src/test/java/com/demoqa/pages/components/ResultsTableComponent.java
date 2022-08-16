package com.demoqa.pages.components;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    private static final String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsTableComponent isVisible() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsTableComponent checkResult(Map<String, String> expectedValues) {
        expectedValues.forEach((key, value) -> $(".table-responsive table")
                .$(byText(key))
                .parent()
                .shouldHave(text(value)));
        return this;
    }
}
