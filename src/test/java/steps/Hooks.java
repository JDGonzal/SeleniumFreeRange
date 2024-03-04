package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Hooks extends BasePage {
  // Ponemos el Constructor basado en el padre
  public Hooks() {
    super(driver);
  }

  // Colocamos un proceso para ejecutar el final es decir un @After
  @After
  // Como es @After se ejecuta siempre al final con el parámetro de tipo `Scenario`
  public void tearDown(Scenario scenario) {
    // Condicional si falla
    if (scenario.isFailed()) {
      // Un mensaje para q sepan q irá ina imagen adjunta
      scenario.log("Scenario failing, please refer to the image attached to this report");
      // Obtenemos la imagen
      final byte[] screenshot = ((TakesScreenshot) driver)
          .getScreenshotAs(OutputType.BYTES);
      // Pegamos la imagen
      scenario.attach(screenshot, "image/png", "Screenshot of the error");
    }
  }

}
