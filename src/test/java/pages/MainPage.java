package pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class MainPage {

    private SelenideElement
            regionName = $("[data-ga-stats-name=HomeRegionChange]"),
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
            modelItemList = $("[data-ftid=component_cars-list-item_hidden-link]");


    @Step("Открытие главной страницы ")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Проверка наличия заголовка на странице")
    public MainPage checkHeader() {
        $(withText("Продажа авто в России")).should(Condition.exist);

        return this;
    }

    @Step("Нажатие на кнопку регоина")
    public MainPage clickRegionButton() {
        regionName.click();

        return this;
    }

    @Step("Проверка открытия страницы 'Мой домашний регион'")
    public MainPage checkHeaderRegion() {
        $(withText("Мой домашний регион")).should(Condition.exist);

        return this;
    }

    @Step("Смена региона")
    public MainPage changeHomeRegion(String value) {
        regionList.$(withText(value)).click();

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

    @Step("Провекра наличия элемента авторизованного пользователя")
    public MainPage checkAuthUserElement() {
        userHeaderInfo.should(Condition.visible);

        return this;
    }

    @Step("Проверка ошибок при авторизации несуществующими аккаунтом")
    public MainPage checkAuthErrors() {
        loginErrors.should(Condition.exist);
        passwordErrors.should(Condition.exist);

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

    @Step("Проверка наличия данных в результате поиска")
    public MainPage checkSearchResultHistoryCars(String value) {
        formHistoryCarsData.should(Condition.visible);
        formHistoryCarsData.should(Condition.text(value));

        return this;
    }

    @Step("Проверка сообщения об ошибке некорректного ввода в поле проверки авто")
    public MainPage checkErrorMessageWidget() {
        errorMessageWidget.should(Condition.exist);
        errorMessageWidget.should(Condition.text("Введите корректный VIN / № кузова / госномер"));

        return this;
    }

    @Step("Раскрытие польного списка марки автомобилей")
    public MainPage clickAllListCars() {
        allCasrBtn.click();

        return this;
    }

    @Step("Нажатие на кнопку марки автомобиля:")
    public MainPage clickCarsModelBtn() {
        modelItemList.$(byText("Mercedes-Benz")).click();

        return this;
    }

}
