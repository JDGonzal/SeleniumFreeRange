package steps;

import org.junit.Assert;

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
    // Comparamos con un `Assert`
    Assert.assertEquals("r: 2, c: 1", value);
  }
}
