# Проект по автоматизации тестовых сценариев для сайта [Drom.ru](https://www.drom.ru/)
<p align="center">
<a href="https://www.drom.ru/"><img title="Логотип компании Drom" src="media/logos/dromLogo.png"></a>
</p>

## :pushpin: Содержание:

- [Используемый стек технологий](#computer-используемый-стек-технологий)
- [Реализованные проверки](#scroll-реализованные-проверки)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram-канал-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-пример-запуска-автотестов-в-selenoid)

## :computer: Используемый стек технологий

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logos/Java.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logos/GitHub.svg"></a> 
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logos/IntelijIDEA.svg"></a> 
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logos/Selenide.svg"></a> 
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logos/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logos/JUnit5.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logos/Jenkins.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logos/Selenoid.svg"></a> 
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logos/AllureReport.svg"></a>
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/logos/Telegram.svg"></a> 
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logos/AllureTestOps.svg"></a> 
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/logos/Jira.svg"></a>
</p>

Тесты в проекте написаны на языке <code>Java</code> с применением фреймворка для тестирования [Selenide](https://selenide.org/) и сборщика <code>Gradle</code>. <code>JUnit 5</code> используется в качестве фреймворка модульного тестирования.

Для удаленного запуска браузеров в процессе тестирования используется [Selenoid](https://aerokube.com/selenoid/).

Для организации удаленного выполнения тестов настроена задача в <code>Jenkins</code> с формированием отчетов Allure и отправкой результатов в <code>Telegram</code> через бота. Также реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге теста;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :scroll: Реализованные проверки:

- Проверка наличия заголовка на главой странице
- Проверка наличия блока 'Новых автомобилей от дилеров'
- Проверка наличия блока 'Отзывов от автомобилях'
- Проверка наличия блока премиум карусели автомобилей
- Проверка смены региона
- Проверка успешной авторизации пользователя
- Негативаня проверка авторизации с некорректными данными
- Проверка выдачи результатов поиска авто по Госномеру
- Проверка при вводе неваллидных данных в поле поиска истории по авто
- Проверка поиска обьвлений авто по списку
- Проверка перехода по вкладке 'Автомобили'

## :arrow_forward: Запуск автотестов

### Локальный запуск тестов из терминала (с параметрами по умолчанию)

```
gradle clean test
```

### Запуск тестов из Jenkins (с указанием параметров)
```
clean test -Denv=remote
-Dbrowser.name=${BROWSER}
-Dbrowser.version=${BROWSER_VERSION} 
-Dbrowser.size=${BROWSER_SIZE}
-Dremote.url=${REMOTE_URL}
-Duser.name=${SECRET_NAME}
-Duser.password=${SECRET_PASSWORD}
```

<p align="center">
<img title="Запуск с параметрами" src="media/screenshots/JenkinsStart-new.png">
</p>

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию – <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию – <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию – <code>1920x1080</code>.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты. По умолчанию – <code>https://user1:1234@selenoid.autotests.cloud/wd/hub</code>
* <code>SECRET_NAME</code> – Логин для входа в учетную запись Drom
* <code>SECRET_PASSWORD</code> – Пароль для входа в учетную запись Drom
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/Jenkins.svg"> [Сборка](https://jenkins.autotests.cloud/job/024_Kwlad1ck_DromRu/) в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build with parameters</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Сборка в Jenkins" src="media/screenshots/Jenkins.png">
</p>

После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки <code>Allure TestOps</code> и <code>Allure Report</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовыми артефактами.

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logos/AllureTestOps.svg"> [Интеграция](https://allure.autotests.cloud/project/4102/dashboards) с Allure TestOps

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них активных/находяться в ревью/черновик/устаревшие, а так же количество ручных и автоматизированных тестов. Результаты выполнения тестов приходят в автоматическом режиме по интеграции при каждом запуске сборки проекта.

<p align="center">
<img title="Dashboard Allure TestOps" src="media/screenshots/TestOpsDashboard.png">
</p>

### Результат выполнения сборки #10

<p align="center">
<img title="Сборка#10 в Allure TestOps" src="media/screenshots/TestOpsResult-10.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logos/AllureReport.svg"> [Пример](https://jenkins.autotests.cloud/job/024_Kwlad1ck_DromRu/10/allure/) Allure-отчета
### Основаня страница отчета

<p align="center">
<img title="Общий вид отчёта Allure" src="media/screenshots/AllureOverview.png">
</p>

### Результат выполнения автотестов

<p align="center">
<img title="Список тест-кейсов в отчёте Allure" src="media/screenshots/AllureSuites.png">
</p>

### Графики

<p align="center">
<img title="Графики прохождения сборки в отчёте Allure" src="media/screenshots/AllureCharts.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logos/Jira.svg"> [Интеграция](https://jira.autotests.cloud/browse/HOMEWORK-1149) с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в задаче отображаются прикрепленные тесты и результат прогона сборки #10.

<p align="center">
<img title="Тикет в Jira" src="media/screenshots/Jira.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в [Telegram канал](https://t.me/publicDromAlerts) с использованием бота 

После завершения сборки и прохождения всех тестовых сценариев в [Telegram канал](https://t.me/publicDromAlerts) приходит оповещение с отчетом о результатах прохождения автотестов.

<p align="center">
<img width="70%" title="Уведомление в Telegram" src="media/screenshots/TelegramAlerts.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logos/Selenoid.svg"> Видео пример запуска автотестов в Selenoid

В отчетах Allure для каждого теста прикреплён не только скриншот, но и видео прохождения теста, записанное Selenoid.
<p align="center">
  <img title="Видео записанное Selenoid" src="media/video/video.gif">
</p>