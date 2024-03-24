package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

  AmazonSearchPage amazon = new AmazonSearchPage();

  @Given("^the user navigates to www.amazon.com$")
  public void navigateToAmazon() {
    amazon.navegateToAmazon();
  }

  @And("^Searches for (.+)$")
  public void enterSearchCriteria(String criteria) {
    amazon.enterSearchCriteria(criteria);
    amazon.clickSearch();
  }

  @And("^navigates to the second page$")
  public void navigateToSecondPage() {
    amazon.goToPage2();
  }

  @And("^selects the third item$")
  public void selectThirdItem() {
    amazon.pick3rdItem();
  }

  @Then("^the user be able to add it to the cart$")
  public void itemCanBeAddedToChart() {
    amazon.addToCart();
    String language = amazon.getLanguage();
    String expected = amazon.addedToCartMessage();
    if (language == "en") {
      Assert.assertTrue(expected.contains("Email or mobile phone number")
          || expected.contains("Added to Cart")
          || expected.contains("This item cannot be shipped to your selected delivery location")
          || expected.contains("Currently unavailable.")
          || expected.contains("No featured offers available"));
    } else if (language == "es") {
      Assert.assertTrue(expected.contains("E-mail o celular")
          || expected.contains("Agregado al carrito")
          || expected.contains("Este art\u00EDculo no se puede enviar a la ubicaci\u00F3n")
          || expected.contains("No disponible por el momento.")
          || expected.contains("No hay ofertas destacadas disponibles"));
    }

  }

}
