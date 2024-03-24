package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
    glue = "steps", 
    plugin = {"pretty",
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
      "timeline:test-output-thread/" }, 
    monochrome = true, 
    tags = "@Amazon")

public class Runner {
  @AfterClass
  public static void cleanDriver() {
    BasePage.closeBrowser();
  }
}
