package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    // Declaración de una variable estática 'driver' de tipo WebDriver
    // Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
    protected static WebDriver driver;
    
    // Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
    // Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
    // WebDriverWait se usa para poner esperas explícitas en los elementos web
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    // Configura el WebDriver para Chrome usando WebDriverManager.
    // WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    static {
        WebDriverManager.chromedriver().setup();
        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    // Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void  navigateTo( String url){
        // Navigate to a website
        driver.get(url);
        //Mazimize current window
        driver.manage().window().maximize();
    }

    // Método estático para cerrar el Browser
    public static void closeBrowser(){
        driver.quit();
    }

    // Creamos un elemento privado de Tipo WebElement llamado `Find`
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Con un método público podemos usar el `Find` privado
    public void clickElement(String locator){
        // Hacemos Click en el elemento `Find` 
        Find(locator).click(); 
    }

    // Método público para escribir usando el `Find`
    public void writeElement(String locator, String keysToSend){
        // Se limpia el contenido
        Find(locator).clear();
        // Luego se escribe el texto en el sitio
        Find(locator).sendKeys(keysToSend);
    }

    // Método para Elegir de un dropdown por Valor
    public void selectFromDropdownByValue(String locator, String value){
        // Nicitamos crear un objeto de la instancia Select
        Select dropdown = new Select(Find(locator));
        // Usamos la nueva variable con el valor requerido
        dropdown.selectByValue(value);
    }

    // Método para Elegir de un dropdown por Índice
    public void selectFromDropdownByIndex(String locator, Integer value){
        // Nicitamos crear un objeto de la instancia Select
        Select dropdown = new Select(Find(locator));
        // Usamos la nueva variable con el valor requerido
        dropdown.selectByIndex(value);
    }

    // Método para saber la cantidad de elementos q tiene un dropdown
    public int dropdownSize(String locator){
        // Nicitamos crear un objeto de la instancia Select
        Select dropdown = new Select(Find(locator));
        // Creamos una lista de `WebElements`
        List<WebElement> dropdownOptions = dropdown.getOptions();
        // Ahora si devolvemos el tamaño
        return dropdownOptions.size();
    }
    
}
