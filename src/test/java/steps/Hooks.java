package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import pages.BasePage;

public class Hooks extends BasePage {
  // Ponemos el Constructor basado en el padre
  public Hooks() {
    super(driver);
  }

  // Colocamos un proceso para ejecutar el final es decir un @After
  @After
  // Como es @After se ejecuta siempre al final con el parámetro de tipo
  // `Scenario`
  public void tearDown(Scenario scenario) throws IOException {
    // Condicional si falla
    if (scenario.isFailed()) {
      // Añade el mensaje de error
      scenario.log("Scenario failed, please refer to the image attached to this report");
      // Alamacenamos el pantallazo en un archivo
      File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      // Ponemos el archivo en una variable 
      byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
      // La variable la voy a añadir al reporte
      scenario.attach(fileContent, "image/png", "Screenshot of the error");
    }
  }
}