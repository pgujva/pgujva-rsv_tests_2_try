package webTests;

import org.junit.jupiter.api.*;


public class MainPageSearchTests extends Testbase {
  private final static String PROJECT = "Проект";
  private final static String WEBINAR = "Вебинар";


  @Test
  @DisplayName("Filter by project")
  public void projectMainPageSearchTest() {
    openMainPage();
    openSearchWindow();
    initSearch(PROJECT);
    choseFilter(PROJECT);
    checkFilterSelected(PROJECT);
    checkFirstFilteredItem(PROJECT);
    checkLinkSection(PROJECT);
    goToSectionByFirstLink();
    checkPageTitle(PROJECT);
  }


  @Test
  @DisplayName("Filter by webinar")
  public void webinarMainPageSearchTest() {
    openMainPage();
    openSearchWindow();
    initSearch(WEBINAR);
    choseFilter(WEBINAR);
    checkFilterSelected(WEBINAR);
    checkFirstFilteredItem(WEBINAR);
    checkLinkSection(WEBINAR);
    goToSectionByFirstLink();
    checkPageTitle(WEBINAR);

  }
}
