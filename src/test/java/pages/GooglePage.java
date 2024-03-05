package pages;


public class GooglePage extends BasePage {
  // Usamos el Contructor del padre
  public GooglePage(){
    super(driver);
  }
  // Vamos a relizar la Navegación
  public void navigateToGoogle(){
    navigateTo("https://www.google.com");
  }
  
}
