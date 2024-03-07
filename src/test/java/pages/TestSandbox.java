package pages;

public class TestSandbox extends BasePage {

    // El locator para el dropdown
    private String dropdown ="//select[@id='testingDropdown']";

  // Usamos el Contructor del padre
  public TestSandbox() {
    super(driver);
  }

  // Vamos a relizar la Navegación
  public void navigateToSandbox() {
    navigateTo("https://artoftesting.com/samplesiteforselenium");
  }

    // Cambiamos del dropdown
    public void selectCategory(String text){
      selectDropDownByValue(dropdown, text);
    }
}
