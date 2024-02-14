package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
// Importación sugerida para traer todo de `cucumber.java`
// import io.cucumber.java.en.*
import pages.PaginaPrincipal;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();

    @Given ("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT(){
        landingPage.navigateToFreeRangeTesters();
    }
    
    @When ("I go to {word} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }
}
