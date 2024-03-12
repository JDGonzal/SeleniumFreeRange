package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {

  private String searchField = "//input[@type='search']";// "//body/form[1]/input[1]";
  private String searchResults = "column-2";// "name";

  // Usamos el Contructor del padre
  public ListPage() {
    super(driver);
  }

  public void navigateToListPage() {
    // Este sitio ya no existe
    // navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    // Probamos en este otro
    navigateTo("https://digitalmarketingwebdesign.com/complete-list-us-cities-cities-united-states/");
  }

  // Escribir el elemento para luego extraer la lista
  public void enterSearchCriteria() throws InterruptedException {
    Thread.sleep(600);
    writeElement(searchField, "Washington");
  }

  public List<String> getAllSearchResults() {
    // Traigo WebElements de Selenium
    List<WebElement> list = bringMeAllElements(searchResults);
    // instancio una variable de tipo `List<String>`
    List<String> stringsFromList = new ArrayList<String>();
    // int i = 0;
    // Debo convertirlos cada uno a `String` en el for
    for (WebElement e : list) {
      // System.out.println(String.format("%02d", i) + " " + e.getText());
      stringsFromList.add(e.getText());
      // i++;
    }
    // Devuelvo la lista de `String`
    return stringsFromList;
  }

}
