package com.kochetkov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2100x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @DisplayName("Тест успешного заполнения формы")
    void formTest() {
        step("Open registration form", () -> open("/automation-practice-form"));
        step("Filling out the registration form", () -> {
            $("#firstName").setValue("Ilya");
            $("#lastName").setValue("Kochetkov");
            $("#userEmail").setValue("kochetkov@gmail.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("7939759565");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1997");
            $(".react-datepicker__day--031").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#currentAddress").setValue("Samara Novo-Sadovaya");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Noida")).click();
            $("#submit").click();
        });
        step("Check text in the pop-up window", () -> {
                    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                });
        step("Check parameters in table", () -> {
            $(".table-responsive").shouldHave(text("Ilya"),
                    text("Kochetkov"),
                    text("kochetkov@gmail.com"),
                    text("Male"),
                    text("7939759565"),
                    text("31 July,1997"),
                    text("English"),
                    text("Sports"),
                    text("Music"),
                    text("Samara Novo-Sadovaya"),
                    text("NCR"),
                    text("Noida"));
        });
    }
}