package webTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class JunitTests {

  @BeforeAll
  public static void setUp() {
    System.out.println("BeforeAll");
  }

  @BeforeEach
  public void setUp2() {
    System.out.println("BeforeEach");
  }

  @Test
  public void one () {
    String a = "test";
    System.out.println("one");
    assertThat("test",is("test2"));
  }

  @Test
  public void two () {
    System.out.println("two");
  }
}
