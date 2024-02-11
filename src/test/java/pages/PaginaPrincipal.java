package pages;

public class PaginaPrincipal extends BasePage{
    
    public PaginaPrincipal(){
        // Se llama el Constructor Padre
        super(driver);
    }

    // Método para navegar a `www.freerangetesters.com`
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }
}
