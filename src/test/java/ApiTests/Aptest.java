package ApiTests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Aptest {

  @Test
  public void firstApiTest() {
    given()
            .when()
            .get("https://demoqa.com/")
            .then()
            .statusCode(200);

  }
}
