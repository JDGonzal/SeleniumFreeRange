package steps;
import org.junit.Assert;

import io.cucumber.java.en.*;
public class AmazonSearchSteps {

  @Given("^the user navigates to www.amazon.com$")
  public void navigateToAmazon(){

  }

  @And("^Searches for (.+)$")
  public void enterSearchCriteria(String criteria){

  }
  @And("^navigates to the second page$")
  public void navigateToSecondPage(){

  }

  @And("^selects the third item$")
  public void selectThirdItem(){

  }

  @Then("^the user be able to add it to the cart$")
  public void itemCanBeAddedToChart(){

  }
  
}
