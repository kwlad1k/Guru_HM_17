package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.MainPage;

public class DromRuPracticeTests extends TestBase {
    MainPage mainPage = new MainPage();

    TestData testData = new TestData();

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE")
    })
    @DisplayName("Проверка наличия заголовка на главой странице")
    void mainPageShouldContainHeaderTest() {
        mainPage.openPage()
                .checkHeader();
    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("NewCarsFromDealerWidget")
    })
    @DisplayName("Проверка наличия блока 'Новых автомобилей от дилеров'")
    void pageContainNewCarsWidgetTest() {
        mainPage.openPage()
                .checkHomeCarsBlock();
    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("ReviewsWidget")
    })
    @DisplayName("Проверка наличия блока 'Отзывов от автомобилях'")
    void pageContainReviewsWidgetTest() {
        mainPage.openPage()
                .checkReviewBlock();
    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("PremiumCarousel")
    })
    @DisplayName("Проверка наличия блока премиум карусели автомобилей")
    void pageContainPremiumCarouselTest() {
        mainPage.openPage()
                .checkPremiumCarousel();
    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("Region")
    })
    @DisplayName("Проверка смены региона")
    void changeRegionTest() {
        mainPage.openPage()
                .clickRegionButton()
                .checkHeaderRegion()
                .changeHomeRegion(testData.regionName)
                .checkRegion(testData.regionName);
    }

    @Test
    @Owner("Kwlad1ck")
    @Severity(SeverityLevel.BLOCKER)
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("Authorization")
    })
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
    @Tags({
            @Tag("NegativeAuth"),
            @Tag("SMOKE"),
            @Tag("Authorization")
    })
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
            @Tag("SMOKE"),
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
            @Tag("SMOKE"),
            @Tag("AutoHistory")
    })
    @DisplayName("Проверка при вводе неваллидных данных в поле поиска истории по авто")
    void negativeFillFormAutoHistoryTest() {
        mainPage.openPage()
                .setValueHistoryCarsInput(testData.randomCarModel)
                .clickSubmitBtnCarsHistory()
                .checkErrorMessageWidget();

    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("SearchCars")
    })
    @DisplayName("Проверка поиска обьвлений авто по списку")
    void searchResultIncludeCarModelsTest() {
        mainPage.openPage()
                .clickAllListCars()
                .clickCarsModelBtn(testData.randomCarModel)
                .checkHeaderSellCarModel(testData.randomCarModel);
    }

    @Test
    @Owner("Kwlad1ck")
    @Tags({
            @Tag("Positive"),
            @Tag("SMOKE"),
            @Tag("SearchCars")
    })
    @DisplayName("Проверка перехода по вкладке 'Автомобили'")
    void successfulNavigationTabTest() {
        mainPage.openPage()
                .clickNavigationCars()
                .checkPremiumCarousel();

    }

}
