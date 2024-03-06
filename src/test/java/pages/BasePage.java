package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  // Definicón de las variables a utilizar
  protected static WebDriver driver;
  private static WebDriverWait wait;

  // Instanciamos las variables
  static {
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // Definición del Constructor
  public BasePage(WebDriver driver){
    BasePage.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // La navegación Genérica a cualquier página
  public static void navigateTo(String url){
    driver.get(url);
  }

  // Creamos un método para devolver el `WebElement`
  private WebElement Find(String locator){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  // Usando el `Find` empezamos a aprovecharlo en un Click:
  public void clickElement(String locator){
    Find(locator);
  }
}
