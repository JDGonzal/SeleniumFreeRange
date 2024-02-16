package pages;

public class PaginaFundamentosTesting extends BasePage {

    // Variable para acceder al link
    private String introduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software']";
    // La siguiente es una versión pero las palabras con acento o tildes no las maneja correctamente
    // private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    // Añadimos el Constructor basado en el padre
    public PaginaFundamentosTesting() {
        super(driver);
    }

    // Método para dar click en el link
    public void clickIntroduccionTestingLink() {
        // Click en el link Introduccion al Testing
        clickElement(introduccionTestingLink);
    }

}
