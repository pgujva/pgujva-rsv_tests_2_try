package webTests;

import com.codeborne.selenide.Configuration;
import helpers.AttachmentHelper;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class Testbase {
  private final static String BASE_URL = "https://rsv-demo.bizml.ru/";
  // private static String SelenideBrowser;
  private static String remoteWebDriver;

  @BeforeAll
  static void setUp() {
    addListener("AllureSelenide", new AllureSelenide());
    Configuration.startMaximized = true;
    //Запуск браузера локально  selenide
    //System.setProperty("selenide.browser", System.getProperty("browserName"));
    //SelenideBrowser = System.getProperty("selenide.browser");


    //Запуск браузера в контейнере selenoid + java
    DesiredCapabilities capabilities = new DesiredCapabilities();
    Configuration.remote = "http://127.0.0.1:4444/wd/hub";
    capabilities.setCapability("enableVNC", true);
    Configuration.browserCapabilities = capabilities;

   /* DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", System.getProperty("browserName"));
    capabilities.setCapability("browserVersion", System.getProperty("browserVersion"));
    capabilities.setCapability("enableVNC", true);
    Configuration.browserCapabilities = capabilities;
    System.setProperty("remote.web.driver", "http://127.0.0.1:4444/wd/hub");
    remoteWebDriver = System.getProperty("remote.web.driver");
    if (remoteWebDriver != null) {
      Configuration.remote = remoteWebDriver;*/

  }

@BeforeEach
  void mainPage() {
    openMainPage();
  }


  @AfterEach
  void afterEach() {
    AttachmentHelper.attachScreenshot("Last screenshot");
    AttachmentHelper.attachPageSource();
   /* if (System.getProperty("browserName").equals("chrome") || System.getProperty("selenide.browser").equals("chrome")) {
      helpers.AttachmentHelper.attachAsText("Browser console logs", helpers.AttachmentHelper.getConsoleLogs());
    }*/
    closeWebDriver();
  }

  @Step("Открываем главную странцу")
  public static void openMainPage() {
    open(BASE_URL);
  }

  @Step("открываем окно поиска")
  public void openSearchWindow() {
    $(".search-button").click();
  }

  @Step("ввод текста в поиск")
  public void initSearch(String searchText) {
    $(".searching-input").clear();
    $(".searching-input").val(searchText);
  }

  @Step("выбираем фильтр")
  public void choseFilter(String filterName) {
    $(".searching-switcher").click();
    $(".content").$(byText(filterName + "ы")).click();
  }

  @Step("Проверка что фильтр выбран")
  public void checkFilterSelected(String filterName) {
    $(".content").$(".checked.labeled").shouldHave(text(filterName + "ы"));
  }


  @Step("Проверка фильтрации по разделу")
  public void checkFirstFilteredItem(String firstItemName) {
    $$(".results.SRWrapper.results").first().shouldHave(text(firstItemName + "ы"));
  }

  @Step("Проверка,что есть ссылка на раздел ")
  public void checkLinkSection(String linkText) {
    $(".results-item").shouldHave(text(linkText + "ы" + "\n" + "Перейти на страницу " + linkText + "ов"));
  }

  @Step("Переход в раздел по первый ссылке")
  protected void goToSectionByFirstLink() {
    $$(".SRWrapper.results").first().click();
  }

  @Step("Проверка что открыта верная страница")
  public void checkPageTitle(String pageTitle) {
    $(".item.current").shouldHave(text(pageTitle + "ы"));
  }

  public void login() {
    $(".auth").click();
    $("#email").click();
    $("#email").clear();
    $("#email").val("");
    $("#password").click();
    $("#password").clear();
    $("#password").val("");
    $("#login-form-submit").click();
    $(".buttons").shouldHave(text("тест"));

  }
}



