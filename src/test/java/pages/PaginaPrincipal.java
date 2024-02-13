package pages;

public class PaginaPrincipal extends BasePage{

    // Definimos searchButton como un xpath del botón "Ver curso" de "selenium-y-cucumber-java"
    private String searchButton = "//a[@href='/selenium-y-cucumber-java'][normalize-space()='Ver curso']";
    
    public PaginaPrincipal(){
        // Se llama el Constructor Padre
        super(driver);
    }

    // Método para navegar a `www.freerangetesters.com`
    public void navigateToFreeRangeTesters(){
        // Sitio o URL a nevegar
        navigateTo("https://www.freerangetesters.com");
        // Damos un click sobre el
        clickElement(searchButton);
    }
}
