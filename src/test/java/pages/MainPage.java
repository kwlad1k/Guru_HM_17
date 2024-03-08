package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class MainPage {

    private SelenideElement
            regionName = $("[data-ftid=component_header_region]"),
            homeAutoBlock = $("[data-ftid=home-auto-block]"),
            reviewsBlock = $("[data-ftid=index_reviews]"),
            premiumCarousel = $("[data-ftid=component_premium-carousel]"),
            regionList = $(".b-selectCars__section"),
            authBtn = $("[data-ga-stats-name=auth_block_login]"),
            usernameInput = $("#sign"),
            passwordInput = $("#password"),
            signBtn = $("#signbutton"),
            userHeaderInfo = $("[data-ftid=component_header_user-info-expand-controller]"),
            loginErrors = $("#sign_errors"),
            passwordErrors = $("#password_errors"),
            carsStoryInput = $("[data-ftid=autostory-widget_input]"),
            carsStorySubmitBtn = $("[data-ftid=autostory-widget_submit-button]"),
            formHistoryCarsData = $("[data-app-root=auto-story]"),
            errorMessageWidget = $("[data-ftid=error_message]"),
            allCasrBtn = $("[data-ftid=component_cars-list_expand-control]"),
            componentBrandModel = $("[data-ftid=component_brand-model]"),
            itemNavigationCars = $("[data-ftid=component_header_main-menu-item]", 0);

    private ElementsCollection
            carsModelBtn = $$("[data-ftid=component_cars-list-item_hidden-link]");


    @Step("Открытие главной страницы ")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Наличие заголовка на странице")
    public MainPage checkHeader() {
        $(withText("Продажа авто в России")).shouldBe(visible);

        return this;
    }

    @Step("Наличие блока отзывов владельцев авто")
    public MainPage checkHomeCarsBlock() {
        homeAutoBlock.shouldBe(visible);
        homeAutoBlock.shouldHave(text("Новые автомобили от дилеров"));

        return this;
    }

    @Step("Наличие блока отзывов владельцев")
    public MainPage checkReviewBlock() {
        reviewsBlock.shouldBe(visible);
        reviewsBlock.shouldHave(text("Отзывы владельцев авто"));

        return this;
    }

    @Step("Наличие блока примиум карусели")
    public MainPage checkPremiumCarousel() {
        premiumCarousel.shouldBe(visible);

        return this;
    }

    @Step("Нажатие на кнопку регоина")
    public MainPage clickRegionButton() {
        regionName.click();

        return this;
    }

    @Step("Открытие страницы 'Мой домашний регион'")
    public MainPage checkHeaderRegion() {
        $(withText("Мой домашний регион")).shouldBe(exist);

        return this;
    }

    @Step("Смена региона")
    public MainPage changeHomeRegion(String value) {
        regionList.$(withText(value)).click();

        return this;
    }

    @Step("Проверка региона")
    public MainPage checkRegion(String value) {
        regionName.$(withText(value)).shouldBe(visible);

        return this;
    }

    @Step("Нажатие на кнпоку авторизации/регистрации")
    public MainPage clickAuthBtn() {
        authBtn.click();

        return this;
    }

    @Step("Ввод имени {userName} и пароля {password} в форму авторизации")
    public MainPage setAuthData(String userName, String password) {
        usernameInput.setValue(userName);
        passwordInput.setValue(password);

        return this;
    }

    @Step("Нажатие кнопки подтверждения")
    public MainPage clickSignBtn() {
        signBtn.click();

        return this;
    }

    @Step("Наличие элемента авторизованного пользователя")
    public MainPage checkAuthUserElement() {
        userHeaderInfo.shouldBe(visible);

        return this;
    }

    @Step("Проверка ошибок при авторизации несуществующими аккаунтом")
    public MainPage checkAuthErrors() {
        loginErrors.shouldBe(visible);
        passwordErrors.shouldBe(visible);

        return this;
    }

    @Step("Ввод {value} в поле формы проверки истории авто")
    public MainPage setValueHistoryCarsInput(String value) {
        carsStoryInput.setValue(value);

        return this;
    }

    @Step("Нажатие кнопки отправки запроса проверки авто")
    public MainPage clickSubmitBtnCarsHistory() {
        carsStorySubmitBtn.click();

        return this;
    }

    @Step("Наличие данных в результате поиска")
    public MainPage checkSearchResultHistoryCars(String value) {
        formHistoryCarsData.shouldBe(visible);
        formHistoryCarsData.shouldBe(text(value));

        return this;
    }

    @Step("Проверка сообщения об ошибке некорректного ввода в поле проверки авто")
    public MainPage checkErrorMessageWidget() {
        errorMessageWidget.shouldBe(visible);
        errorMessageWidget.shouldBe(text("Введите корректный VIN / № кузова / госномер"));

        return this;
    }

    @Step("Раскрытие польного списка марки автомобилей")
    public MainPage clickAllListCars() {
        allCasrBtn.click();

        return this;
    }

    @Step("Нажатие на кнопку марки автомобиля: {value}")
    public MainPage clickCarsModelBtn(String value) {
        carsModelBtn.filterBy(text(value)).first().click();

        return this;
    }

    @Step("Наличие компонента на странице о бренде авто")
    public MainPage checkHeaderSellCarModel(String value) {
        componentBrandModel.shouldBe(visible);
        componentBrandModel.shouldBe(text(String.format("Всё о %s", value)));

        return this;
    }

    @Step("Переход по навигации 'Автомобили'")
    public MainPage clickNavigationCars() {
        itemNavigationCars.click();

        return this;
    }

}
