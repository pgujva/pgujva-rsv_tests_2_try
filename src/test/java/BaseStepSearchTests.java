
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class BaseStepSearchTests extends Testbase {
  private final static String PROJECT = "Проект";
  private final static String WEBINAR = "Вебинар";

  @Disabled
  @Test
  @DisplayName("Filter by project")
  public void projectPageSearchTest() {
    open("https://rsv-test.bizml.ru");
    $(".search-button").click();
    $(".searching-input").clear();
    $(".searching-input").val(PROJECT);
    $(".searching-switcher").click();
    $$(".categories-column").filterBy(text(PROJECT + "ы")).first().click();
    $$(".results.SRWrapper.results").first().shouldHave(text(PROJECT + "ы"));
    $(".results-item").shouldHave(text(PROJECT + "ы" + "\n" + "Перейти на страницу проектов"));

  }

  @Test
  @DisplayName("Filter by webinar")
  public void webinarPageSearchTest() {
    open("https://rsv-test.bizml.ru");
    $(".search-button").click();
    $(".searching-input").clear();
    $(".searching-input").val(WEBINAR+ "ы");
    $(".searching-switcher").click();
    $$(".categories-column").filterBy(text(WEBINAR + "ы")).first().click();
    $$(".results.SRWrapper.results").first().shouldHave(text(WEBINAR + "ы"));
    $(".results-item").shouldHave(text(WEBINAR + "ы" + "\n" + "Перейти на страницу вебинаров"));

  }
}
