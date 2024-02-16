package pages;

public class PaginaPrincipal extends BasePage{

    // Definimos sectionLink con el valor del path relativo de 'Recursos'
    private String sectionLink = "//a[normalize-space()='%s' and @href]";

    // Definimos searchButton como un xpath del botón "Ver curso" de "selenium-y-cucumber-java"
    // private String searchButton = "//a[@href='/selenium-y-cucumber-java'][normalize-space()='Ver curso']";

    // Definimos elegirUnPlanButton con el texto de 'Elegir Plan' y q sea un `href`
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";
    
    public PaginaPrincipal(){
        // Se llama el Constructor Padre
        super(driver);
    }

    // Método para navegar a `www.freerangetesters.com`
    public void navigateToFreeRangeTesters(){
        // Sitio o URL a nevegar
        navigateTo("https://www.freerangetesters.com");
        // Damos un click sobre el
        // clickElement(searchButton);
    }

    // Método para dar click a la barra de navegación
    public void clickOnSectionNavigationBar(String section){
        // Reemplaza el marcador de posición en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        // Click en el elemento de la barra del navegador
        clickElement(xpathSection);
    }

    // Método para dar clic en Plan Nuevo
    public void clickOnElegirPlanButton(){
        // Clic en el botón de Plan nuevo
        clickElement(elegirUnPlanButton);
    }
}
