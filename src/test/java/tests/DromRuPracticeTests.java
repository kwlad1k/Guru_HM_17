package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.MainPage;

public class DromRuPracticeTests extends TestBase {
    MainPage mainPage = new MainPage();

    TestData testData = new TestData();

    @Test
    @Owner("Kwlad1ck")
    @DisplayName("Проверка наличия заголовка на главой странице")
    void mainPageShouldContainHeaderTest() {
        mainPage.openPage()
                .checkHeader();
    }

    @Test
    @Owner("Kwlad1ck")
    @DisplayName("Проверка смены региона")
    void changeRegionTest() {
        mainPage.openPage()
                .clickRegionButton()
                .checkHeaderRegion()
                .changeHomeRegion(testData.regionName);
    }

    @Test
    @Owner("Kwlad1ck")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Authorization")
    @DisplayName("Проверка успешной авторизации пользователя")
    void successfulAuthTest() {
        mainPage.openPage()
                .clickAuthBtn()
                .setAuthData(testData.userName, testData.userPassword)
                .clickSignBtn()
                .checkAuthUserElement();
    }

    @Test
    @Owner("Kwlad1ck")
    @Tag("NegativeAuth")
    @DisplayName("Негативаня проверка авторизации с некорректными данными")
    void negativeAuthTest() {
        mainPage.openPage()
                .clickAuthBtn()
                .setAuthData(testData.randomEmail, testData.randomPassword)
                .clickSignBtn()
                .checkAuthErrors();

    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("AutoHistory")
    })
    @DisplayName("Проверка выдачи результатов поиска авто по Госномеру")
     void checkAutoHistoryTest() {
        mainPage.openPage()
                .setValueHistoryCarsInput(testData.registrationNumberAuto)
                .clickSubmitBtnCarsHistory()
                .checkSearchResultHistoryCars(testData.registrationNumberAuto);

    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Negative"),
            @Tag("AutoHistory")
    })
    @DisplayName("Проверка при вводе неваллидных данных в поле поиска истории по авто")
    void negativeFillFormAutoHistoryTest() {
        mainPage.openPage()
                .setValueHistoryCarsInput(testData.randomAutoModel)
                .clickSubmitBtnCarsHistory()
                .checkErrorMessageWidget();

    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SearchAuto")
    })
    @DisplayName("Проверка поиска обьвлений авто по списку")
    void searchResultIncludeVehicleMakeTest() {
        mainPage.openPage()
                .clickAllListCars()
                .clickCarsModelBtn();


    }
}
