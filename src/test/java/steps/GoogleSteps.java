package steps;

// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {

  GooglePage google = new GooglePage();

  @Given("^I am on the Google seach page$")
  public void navigateToGoogle(){
    google.navigateToGoogle();
  }

  @When("^I enter a search criteria$")
  public void enterSearchCriteria(){

  }

  @And("^click on the seach button$")
  public void clickSearchButton(){

  }

  @Then("^the results match the criteria$")
  public void validateResults(){

  }
  
}
