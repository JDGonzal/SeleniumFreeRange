package pages;

import java.util.List;

public class PaginaRegistro extends BasePage{

    // Variable para acceder el dropdown
    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    // Añadimos el Constructor basado en el padre
    public PaginaRegistro() {
        super(driver);
    }

    // Creamos una lista con el nombre `returnPlanDropdownValues`
    public List<String> returnPlanDropdownValues() {
        return getDropdownValues(planDropdown);
    }
    
}
