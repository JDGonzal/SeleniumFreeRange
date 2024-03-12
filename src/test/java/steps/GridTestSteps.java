package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GridPage;

public class GridTestSteps {

  GridPage grid = new GridPage();

  @Given("^I navigate to the static table$")
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

  @Then("^I can validate the table is displayed$")
  public void theTableIsThere(){
    // El compartivo debe dar falso y poner un mensaje
    Assert.assertTrue("Explotó todo", grid.cellStatus());
  }
}
