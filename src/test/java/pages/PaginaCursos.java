package pages;

public class PaginaCursos extends BasePage {

    // Variable para acceder al link
    private String fundamentosTestingLink = "//a[normalize-space()='Fundamentos del Testing' and @href]";

    // Añadimos el Constructor basado en el padre
    public PaginaCursos() {
        super(driver);
    }

    // Método para dar click en el link
    public void clickFundamentosTestingLink(){
        // Click en el link de fundamentos Testing
        clickElement(fundamentosTestingLink);
    }

}
