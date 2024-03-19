package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  // glue = "src/test/java/steps"
  glue = "steps",
  monochrome = true,
  tags = "@List"
)

public class Runner {
  @AfterClass
  public static void cleanDriver(){
    BasePage.closeBrowser();
  }
}
