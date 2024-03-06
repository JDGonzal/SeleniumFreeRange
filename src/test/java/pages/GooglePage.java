package pages;


public class GooglePage extends BasePage {
  // el locator del botón de Search
  private String searchButton = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']";

  // Usamos el Contructor del padre
  public GooglePage(){
    super(driver);
  }

  // Vamos a relizar la Navegación
  public void navigateToGoogle(){
    navigateTo("https://www.google.com");
  }

  // Hacemos un click en el botón de Search
  public void clickGoogleSearch(){
    clickElement(searchButton);
  }
  
}
