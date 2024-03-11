package pages;

public class GooglePage extends BasePage {
  // el locator del botón de Search
  // private String searchButton = "//div[@class='FPdoLc
  // lJ9FBc']//input[@name='btnK']";
  // Corregimos el locator para el botón, dado q aparece otro al escribir el texto
  private String searchButton = "//div[@class='lJ9FBc']//input[@name='btnK']";
  // El locator para el texto
  private String searchTextField = "//textarea[@id='APjFqb']";
  // El locator para el primer resultado
  private String firstResult = "";

  // Usamos el Contructor del padre
  public GooglePage() {
    super(driver);
  }

  // Vamos a relizar la Navegación
  public void navigateToGoogle() {
    navigateTo("https://www.google.com");
  }

  // Hacemos un click en el botón de Search
  public void clickGoogleSearch() {
    clickElement(searchButton);
  }

  // Llenamos el criterio de búsqueda
  public void enterSeachCriteria(String criteria) {
    writeElement(searchTextField, criteria);
  }

  // Devolvemos el texto q vamos a comparar
  public String firstResult() {
    return textFromElement(firstResult);
  }

}
