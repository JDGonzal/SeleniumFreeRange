package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  // Definicón de las variables a utilizar
  protected static WebDriver driver;
  private static WebDriverWait wait;
  private static Actions action;

  // Instanciamos las variables
  static {
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // Definición del Constructor
  public BasePage(WebDriver driver) {
    BasePage.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // La navegación Genérica a cualquier página
  public static void navigateTo(String url) {
    driver.get(url);
    driver.manage().window().maximize();
  }

  // Cerramos el Navegador
  public static void closeBrowser() {
    driver.quit();
  }

  // Creamos un método para devolver el `WebElement`
  private WebElement Find(String locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  // Usando el `Find` empezamos a aprovecharlo en un Click:
  public void clickElement(String locator) {
    // Se hace click en el elemento
    Find(locator).click();
  }

  // Usando el `Find` empezamos a aprovecharlo para un Write
  public void writeElement(String locator, String textToWrite) {
    // Limpia el texto
    Find(locator).clear();
    // Escribe el texto
    Find(locator).sendKeys(textToWrite);
  }

  // Usando el `Find` empezamos a aprovecharlo para un select Dropdown por valor
  public void selectDropDownByValue(String locator, String valueToSelect) {
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByValue(valueToSelect);
  }

  // Usando el `Find` empezamos a aprovecharlo para un select Dropdown por Indice
  public void selectDropDownByIndex(String locator, int index) {
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByIndex(index);
  }

  // Usando el `Find` empezamos a aprovecharlo para un select Dropdown por Texto
  public void selectDropDownByText(String locator, String valueToSelect) {
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByVisibleText(valueToSelect);
  }

  // Usando el `Find` empezamos a aprovecharlo para un Hover Over
  public void hoverOverElement(String locator) {
    // Agreamos un `action`
    action.moveToElement(Find(locator));
  }

  // Usando el `Find` empezamos a aprovecharlo para un doble click
  public void doubleClickElement(String locator) {
    // Agregamos el `action`
    action.doubleClick(Find(locator));
  }

  // Usando el `Find` empezamos a aprovecharlo para un click derecho
  public void rightClickElement(String locator) {
    // Agregamos el `action`
    action.contextClick(Find(locator));
  }

  // Usando el `Find` empezamos a aprovecharlo para obtener un dato de una tabla
  public String getValueFromTable(String locator, int row, int column) {
    // Encadenamos junto con el `locator` lo requerido para el dato en cuestión
    String cellINeed = locator + "/table/tbody/tr[" + row + "]/td [" + column + "]";
    // Devolvemos el texto interno
    return Find(cellINeed).getText();
  }

  // Usando el `Find` empezamos a aprovecharlo para llenar un dato de una tabla
  public void setValueOnTable(String locator, int row, int column, String text2Send) {
    // Encadenamos junto con el `locator` lo requerido para el dato en cuestión
    String cell2Fill = locator + "/table/tbody/tr[" + row + "]/td [" + column + "]";
    // Llenamos la celda
    Find(cell2Fill).sendKeys(text2Send);
  }

  // Esta vez vamos al `driver` para cambiar el iFrame
  public void swithcToiFrame(int iFrameIndex) {
    // Usando el `driver` hacemos el cambio
    driver.switchTo().frame(iFrameIndex);
  }

  // Esta vez vamos al `driver` para cambiar al iFrame padre.
  public void swithcToParentFrame() {
    // Usando el `driver` hacemos el cambio
    driver.switchTo().parentFrame();
  }

  // Esta vez vamos al `driver` para ignorar o cerrar alertas
  public void dismissAlert() {
    // Usando el `driver` desactivamos la alerta
    driver.switchTo().alert().dismiss();
  }

  // Usando el `Find` devolvemos el texto de un Elemento
  public String textFromElement(String locator) {
    return Find(locator).getText();
  }

  // Usando el `Find` verificamos si el elemento está disponible
  public boolean elementIsEnabled(String locator) {
    try {
      return Find(locator).isEnabled();
    } catch (Exception e) {
      return false;
    }

  }

  // Usando el `Find` verificamos si el elemento está en pantalla
  public boolean elementIsDisplayed(String locator) {
    try {
      return Find(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }

  }

  // Usando el `Find` verificamos si el elemento está seleccionado
  public boolean elementIsSelected(String locator) {
    try {
      return Find(locator).isSelected();
    } catch (Exception e) {
      return false;
    }

  }

  // Esta vez vamos al `driver` para obtener toda la lista
  public List<WebElement> bringMeAllElements(String locator) {
    return driver.findElements(By.className(locator));
  }

  // Usando el `Find` vamos al Link por el texto
  public List<WebElement> gotoLinkText(String locator) {
    return driver.findElements(By.linkText(locator));
  }
}
