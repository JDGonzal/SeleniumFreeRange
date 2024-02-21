package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
// import org.testng.asserts.SoftAssert;

// Importación sugerida para traer todo de `cucumber.java`
import io.cucumber.java.en.*;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;

import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    // SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("(I|The user|The client) (select|selects) Elegir Plan")
    public void selectElegirPlan() throws Exception{
        landingPage.clickOnElegirPlanButton();
    }

    @And("(I|The user|The client) (select|selects) Introduction to Testing")
    public void navigateToIntro() throws Exception{
        cursosPage.clickFundamentosTestingLink();
        fundamentosPage.clickIntroduccionTestingLink();
    }

    @Then("(I|The user|The client) can validate the options in the checkout page")
    public void validateCheckoutPlans() throws Exception{
        List<String> lista = registro.returnPlanDropdownValues();
        System.out.println("lista Esperada •\u2022");
        List<String> listaEsperada = Arrays.asList(
                "Academia: $16.99 / mes \u2022 11 productos",
                "Academia: $176 / a\u00F1o \u2022 11 productos",
                "Free: Gratis \u2022 1 producto");
        Assert.assertEquals(lista, listaEsperada);
    }
}
