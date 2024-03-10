package steps;

import io.cucumber.java.en.*;
import pages.GridPage;

public class GridTestSteps {

  GridPage grid = new GridPage();

  @Given("^I navigate to the static table Then I can return the value I wanted$")
  public void navigateToGridPage() {
    // Navegamos al sitio
    grid.navigateToGrid();
  }

  @Then("^I can return the value I wanted$")
  public void returnValue() {
    // Obtenemos la Celda
    String value = grid.getValueFromGrid(3, 2);
    // Imprimimos el valor obtenido
    System.out.println(value);
  }
}
