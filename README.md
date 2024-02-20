# Java-Cucumber-01
https://perficient.udemy.com/course/selenium-con-java-y-cucumber-el-curso-definitivo/learn/lecture/41595708#overview
## Prerrequisitos
1. Tener "[Visual Studio Code](https://code.visualstudio.com/download)", como editor
2. Tener Instalado "[JAVA Version 11.0.2](https://jdk.java.net/archive/)", "[GRADLE](https://gradle.org/install/)", "[GROOVY](https://groovy.apache.org/download.html)" y "[MAVEN](https://maven.apache.org/download.cgi)".
3. Instalar Estas Extensiones en el "Visual Studio Code":
* code-groovy  de Marlon Franca.
* Cucumber de Cucumber.
* Cucumber (Gherking) Full de Alex Krechik.
* Debugger for Java de Microsoft.
* Extension Pack for Java de Microsoft.
* Gradle for Java de Microsoft.
* Gradle Language Support de Narco Siren.
* Groovy Lint, Fromat and de Nicolas Vuillamy.
* Language Support for Java de Red Hot.
* Maven for Java de Microsoft.
* Project Manager for Java de Microsoft.
* Snippets and Sintax High de Euclidity.
* Test Runner for Java de Microsoft.

## Paso 07
1. Crear un Proyecto con "Gradle: Create a Gradle Java Project".
2. Seleccionamos la carpeta en:
```dos
 E:\Development\tutorials\java\cucumber\SeleniumFreeRange
 ```
3. Seleccionamos "Groovy".
4. Dejamos el nombre por defecto.
5. Movemos la carpeta "src" y el "build.gradle" a la raíz del proyecto.
6. Borramos la carpeta "app" y lo q tiene por dentro.
7. Borramos el archivo "App.java" dentro de "/src/main/java/java/cucumber".
8. Borramos el archivo "AppTest.java" dentro de "src/test/java/java/cucumber".

## Paso 09
1. Del archivo **build.gradle** borramos la sección "application".
2. Del sitio [Maven Repository](https://mvnrepository.com/) buscamos "Selenium Java".
3. Seleccionamos la última (para este ejercicio fue 4.17).
4. Seleccionamos el "Gradle (Short)", con el click, esto queda en la memoria para darle "pegar" en cualquier parte.
5. Lo pegamos en la sección "dependencies" de **build.gradle**.
6. En el mismo sitio donde tomamos las dependencias, buscamos "TestNG", va en la version 7.9, mismo copiar para "dependencies" de **build.gradle**.
7. En el mismo sitio donde tomamos las dependencias, buscamos "Cucumber JVM: Java", va en la version 7.15, mismo copiar para "dependencies" de **build.gradle**.
8. En el mismo sitio donde tomamos las dependencias, buscamos "Cucumber JVM: JUnit 4", va en la version 7.15, mismo copiar para "dependencies" de **build.gradle**. 
> [!IMPORTANT]  
> Las versiones de "Cucumber JVM: Java" y "Cucumber JVM: JUnit 4", **TIENEN** q ser iguales.
16. Borramos de "Depencies" el de "google.guava".
17. Ejecutamos un comando en la `TERMINAL` llamado
```bash
gradle build
```
Y esto baja todas las dependencias, al final debe mostrar algo parecido a esto:
```diff
+ BUILD SUCCESSFUL in 29s
4 actionable tasks: 4 executed
```
## Paso 11
> [!NOTE]  
>Tenemos 2 arquitecturas  
> Opción 1  

|Main|Test|
|---|---|
| * Pages  | * Step Definitions |
| * Runner | * Feature |
|||

> Opción 2

|Main|Test|
|---|---|
|| * Step Definitions|
|| * Feature |
|| * Pages |
|| * Runner |

> Se sugiere utilizar la opción 2, por tanto la carpeta "Main" puede ser borrada.

1. Borrar la carpeta "Main" dentro de "src".
2. Adicionar la carpeta "features" dentro de "/src/test/resources".
3. Adicionar la carpeta "pages" dentro de "/src/test/java".
4. Adicionar la carpeta "steps" dentro de "/src/test/java".
5. Adicionar la carpeta "runner" dentro de "/src/test/java".

## Paso 13
1.  Del sitio [Maven Repository](https://mvnrepository.com/) buscamos "bonigarcia" y de alli seleccionamos el "WebDriverManager"
2. Seleccionamos la última (para este ejercicio fue 5.6.3).
3. Seleccionamos el "Gradle (Short)", con el click, esto queda en la memoria para darle "pegar" en cualquier parte.
4. Lo pegamos en la sección "dependencies" de **build.gradle**.
5. Creamos el archivo **FreeRangeTest.java** y en la carpeta "pages" con la siguiente información:
```java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTest {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        // Inicializa el WebDriver para Chrome 
        WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
    }
    @Test
    public void navegamosAFreeRangeTesters() { 
        // Navega a la página web
        driver.get("https://www.freerangetesters.com");
    }
    @AfterMethod
    public void tearDown() {
        // Cierra el navegador después de la prueba
        if (driver != null) {
            driver.quit();
        }
    }
}
```
6. Presionamos el triángulo verde dentro del archivo **FreeRangeTest.java**, corre y prueba q abre el navegador y luego lo cierra.  
En el `DEBUG CONSOLE`, debe aparecer una respuesta similar a este:
```dos
===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
```

7. Para confirmar este debe ser el archivo **build.gradle**:
```gradle
plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    id 'application'
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'

    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation 'org.seleniumhq.selenium:selenium-java:4.17.0'

    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation 'org.testng:testng:7.9.0'

    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    implementation 'io.cucumber:cucumber-java:7.15.0'

    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
    testImplementation 'io.cucumber:cucumber-junit:7.15.0'

    // https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation 'io.github.bonigarcia:webdrivermanager:5.6.3'
}

tasks.named('test') {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
```

## Paso 18
> [!NOTE]  
> Veamos que es el Page Object Model (POM)  
> Pasando de esto:

|Page Object Class|Tests|
|---|---|
|Elemento Boton| Click Botón|
||Validar botón habilitado|
|Elemento Campo Texto||
|Click Botón||


> A esto

|Page Object Class|Steps Def|Feature|
|---|---|---|
|Elemento Boton| Click Botón||
||Validar botón habilitado||
|Elemento Campo Texto|||
|Click Botón|||
|||Dado que hago algo|
|||Cuando miro|
|||Paso lo q esperaba|

1. Completamos en **FreeRangeTest.java** un método llamado `test1`, con lo siguiente:
```java
    @Test
    public void test1() { 
        // Navega a la página web
        driver.get("https://www.freerangetesters.com");
        // Encuentra un elemento utilizando si ID
        WebElement elementoPorId = driver.findElement(By.id("idDelElemento"));
        elementoPorId.click();
    }
```
2. Creamos en "src/test/resources/" un archivo llamado **FreeRangeNavegation.feature**.
3. Creamos en "src/test/runner/" un archivo llamado **TestRunner.java**.
4. Colocamos `fea`dentro del archivo **FreeRangeNavegation.feature**, y el snippet completa el resto, similar a esto:
```feature
Feature: Feature name
    In order to value
    As a role
    I want reature 
```
5. Colocamos `sce`dentro del archivo **FreeRangeNavegation.feature**, y el snippet completa el resto, similar a esto:
```feature
Scenario: title
    Given context
    When event
    Then outcome
```
6. Coloco datos para corre dentro de **TestTunner.java**:
```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",  //Directorio de archivos .feature
    glue = "src/test/java/steps",  //Paquete de las Clases de los pasos del feature
    plugin = {"pretty", "html:target/cucumber-reports"}
)  
```
7. En la `TERMINAL`, simplemente ejecuto el comando:
```bash
gradle test
```
y mi respuesta es similar a esto:
```diff
+ BUILD SUCCESSFUL in 8s
3 actionable tasks: 3 executed
```
8. Del archivo **build.gradle**, cambiamos la última linea de `tasks.named('test') {`, por esta:
```gradle
tasks.named('test') {
    systemProperty "cucumber.options", System.getProperty("cucumber.options")
}
```
9. En la `TERMINAL`, simplemente ejecuto el comando:
```bash
gradle test
```
y mi respuesta es similar a esto, debe salir una falla:
```diff
- BUILD FAILED in 2s
 3 actionable tasks: 1 executed, 2 up-to-date
```
10. Borramos del archivo **settings.gradle** la última linea
```gradle
include('app')
```

## Paso 20
1. Borramos las dos últimas líneas del archivo **FreeRangeNavegation.feature**, dejando solo esto:
```feature
Feature: Navigation bar
    To see the subpages
    Without logging in
    I can click the navigation bar links
 
Scenario: I can access the subpages through the navigation bar 
    Given I navigate to www.freerangetesters.com 
```
2. Creamos un archivo en "src/test/java/pages" llamado **BasePage.java**, 
allí se crea la instancia de la *webPage*, que será exclusiva de este archivo 
y los demás podrán utilizar el `WebDriver`.
3. Creamos una variable estática llamada `driver` de tipo `WebDriver`. El solito debe importar el faltante `import org.openqa.selenium.WebDriver;`.
4. Añadimos un `WebDriverWait` en una variable `wait`, iniciando la instancia. El importará `import org.openqa.selenium.support.ui.WebDriverWait;`.
5. Esta misma fórmula requiere un `Duration.ofSeconds(5)`, por ende esta la importará así `import java.time.Duration;`.
6. Creamos un bloque estático, sin nombre como este:
```java
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
```
El debió de importar lo siguiente: `import io.github.bonigarcia.wdm.WebDriverManager;` y `import org.openqa.selenium.chrome.ChromeDriver;`.
7. Cuando se esté utilizando esta página heredada, se va a requerir el constructor y q sea vista por otras clases:
```java
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }
```
8. Creamos una función dentro del mismo archivo **BasePage.java**, para poder acceder al respectivo sitio o URL, requerido:
```java
    public static void  navigateTo( String url){
        driver.get(url);
    }
```

## Paso 22
1. Creamos archivo **PaginaPrincipal.java**, dentro de "src/test/java/pages".
2. Conectamos la **BasePage.java** mediante un `extends`.
3. Creamos un constructor:
```java
    public PaginaPrincipal(){
        // Se llama el Constructor Padre
        super(driver);
    }
```
4. Creamos un método para navegar a `www.freerangetesters.com`:
```java
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }
```
5. Ahora si creamos los *steps* con el archivo **FreeRangeSteps.java** dentro de "src/test/java/steps".
6. Basado en el arcivo **FreeRangeNavegation.feature** Escribimos el paso tal cual, letra por letra : 
`@Given ("I navigate to www.freerangetesters.com")`, 
el luego importará `import io.cucumber.java.en.Given;`.
7. Creamos un método, para luego ser utilizado:
`public void iNavigateToFRT(){}`.
8. Importamos del archivo **PaginaPrincipal.java** , el valor en una instancia llamada `landingPage`.
```java
PaginaPrincipal landingPage = new PaginaPrincipal();
```
9. Usando `landingPage`, llamamos métodos como el de `navigateToFreeRangeTesters()`.
10. Del archivo **TestRunner.java** , cambiamos el glue a solo `steps`.
11. ejecutamos en la `TERMINAL`, el comando siguiente:
```bash
gradle test
```
Y el resultado obtenido debe ser, una ejecución exitosa:
```diff
+ BUILD SUCCESSFUL in 11s
 3 actionable tasks: 3 executed
```

## Paso 24
> [!TIP]  
> Descargamos para Chrome y/o FireFox una extensión llamado **selectorsHub**, 
> luego ubicándonos en el botón requerido, click derecho, SelctorsHub
> y `Copy Relative XPath`, el contenido lo usaremos en el paso siguiente.

## Paso 25
> [!NOTE]  
> Vamos a enfocarnos en el archivo **BasePage.java**, dado q no pertenece a ninguna página en particular, 
> utilizándose como un genérico para el Page Object Class (POC),
> como vamos a interactuar con elementos Web, habrá q poner esperas. 
> 

1. En el archivo **BasePage.java** creamos un elemento del tipo `WebElement` con el nombre `Find` y un argumento de tipo `String`, luego se importó esto: `import org.openqa.selenium.WebElement;`.
2. Retornamos con la espera `wait` un `ExpectedConditions`, finalmente con un `by.xpath`, se importaran estos: `import org.openqa.selenium.support.ui.ExpectedConditions;` y `import org.openqa.selenium.By;`, y este sería el elemento:
```java
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
```
3. Con un método público podemos usar el `Find` privado:
```java
    public void clickElement(String locator){
        // Hacemos Click en el elemento `Find`
        Find(locator).click();
    }
```
4. En el archivo **PaginPrincipal.java** añadimos una variable `searchButton`,
con el valor del xpath del botón "Ver curso" de "selenium-y-cucumber-java".
5. Usamos ese botón justo después de haber abierto la pagina WEB:
`clickElement(searchButton);`.
6. Probamos corriendo en la `TERMINAL`, el comando:
```bash
gradle test
```
Que nos abre la página y da click en el botón deseado , finalizando en la página esperada, y dándonos una respuesta exitosa:
```diff
+ BUILD SUCCESSFUL in 19s
3 actionable tasks: 3 executed
```

## Paso 27
1. En el archivo **BasePage.java**, vamos a implementar el cierre del browser:
```java
    public static void closeBrowser(){
        driver.quit();
    }
```
2. En el archivo **TestRunner.java** implementarmos un `@AfterClass`, 
 usamos el de junit `import org.junit.AfterClass;`:
```java
public class TestRunner {
@AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
    
}
```
3. Lo podemos probar corriendo en el triángulo verde dentro de **TestRunner.java**
o ejecutando el comando en la `TERMINAL` de `gradle test`.
 
## Paso 29
1. Creamos un método en **BasePage.java**, llamado `writeElement` para escribir en un elemento, con `sendKeys`:
```java
    public void writeElement(String locator, String keysToSend){
        // Se limpia el contenido
        Find(locator).clear();
        // Luego se escribe el texto en el sitio
        Find(locator).sendKeys(keysToSend);
    }
``` 
> [!NOTE] 
> Definimos el `writeElement`, pero no lo usamos aún.

## Paso 31
> [!NOTE]  
> Elegimos de un *Dropdown* o por el valor del elemento o por su índice. 

1. Creamos un método en **BasePage.java** para elegir de un dropdown
por valor, llamado `selectFromDropdownByValue`.
2. Instanciamos un objeto llamada `dropdown` como `Select dropdown = new Select(Find(locator));`,
el debe de importar esto `import org.openqa.selenium.support.ui.Select;`.
3. Usamos la nueva variable con el valor requerido: `dropdown.selectByValue(value);`.
4. Creamos otro método en **BasePage.java** para elegir de un dropdown
por índice, llamado `selectFromDropdownByIndex`.
5. Instanciamos un objeto llamada `dropdown` como `Select dropdown = new Select(Find(locator));`.
6. Usamos la nueva variable con el valor requerido: `dropdown.selectByIndex(value);`.
7. Creamos otro método en **BasePage.java** para validar la cantidad 
de elementos que tiene un drowdown, llamado `dropdownSize`. 
8. Instanciamos un objeto llamada `dropdown` como `Select dropdown = new Select(Find(locator));`.
9. Creamos una lista de `WebElement` como: 
`List<WebElement> dropdownOptions = dropdown.getOptions();`. 
Se debe importar lo siguiente `import java.util.List;`.
10. Ahora si devolvemos el tamaño `return dropdownOptions.size();`.

> [!NOTE]  
> Definimos estos tres nuevos métodos, pero no lo usamos aún.

## Paso 33
1. Añadimos a **FreeRangeNavigation.feature** lo siguiente:
```feature
        When I go to a section using the navigation bar
```
2. Añadimos en **FreeRangeSteps.java**  un `@When` e importamos 
`import io.cucumber.java.en.When;`:
```java
@When ("When I go to a section using the navigation bar")
    public void navigationBarUse(){
        
    }
```
3. Otra importación q se sugiere es todo de `cucumber.java`, como lo siguiente
`import io.cucumber.java.en.*`.
4. En el archivo **PaginaPrincipal.java**, creamos una función o método 
llamado `clickOnSectionNavigationBar()`.
5. Del sitio [freerangetesters.com](https://www.freerangetesters.com/), en la 
parte superior, la barra de navegación, damos click derecho sobre `Recursos` y seleccionamos 
'SelectorsHub' y `Copy Relative XPath`.
6. Creamos una variable en **PaginaPrincipal.java**, llamada `sectionLink`, 
de valor le asignamos lo cargado en memoria del xPath Relativo.
7. De este valor inicial `//a[@class='sc-iqHXzD bOSpzC sc-crrtmM sc-dFJsne jBPSqi cBBApE'][normalize-space()='Recursos']`, se sugiere cambiar a :
`//a[normalize-space()='Recursos' and @href]`.

> [!NOTE]  
> Hay elementos que se vuelven comentarios pues no los vamos a usar en el ejercicio, como `private String searchButton` y `clickElement(searchButton)`.

8. En el archivo **FreeRangeSteps.java** agregamos el `landingPage`,
con el nuevo método llamado `clickOnSectionNavigationBar()`, del punto 4.
9. Lo podemos ejecutar desde **TestRunner.java** o el comando `gradle test`.

> [!IMPORTANT]  
> Maximizar la Página para un resultado Correcto.

10. Adicioné al momento de alcanzar la página, un Maximizar de la Ventana
en el archivo **BasePage.java** en el método `navigateTo`, porque sino
obtengo un menú tipo Hamburguesa y para la prueba requiero el menú o barra
de navegación completo.

> [!NOTE]  
> Dado que queremos usar todas las opciones de la Barra de navegación, 
> Vamos a parametrizarlas cada elemento.

11. Cambiamos en **FreeRangeNavigation.feature** , el uso de el simple `Scenario`, 
por uno llamado `Scenario Outline`.
12. La palabra `section` dentro del `When`, la encerramos entre símbolos 
mayor que y menor que, así `<section>`. Tambien quitamos la partícula `a`.
13. Escribimos `exam` y dejamos q complete el snippet para `Examples`, en
plural.
14. Cambiamos el primer valor por `|section|` y debajo todos las opciones
que queremos q seleccione: 
`| Cursos | | Recursos | | Udemy | | Mentorías | | Newsletter |`.
15. Corregimos la definicon del paso en **FreeRangeSteps.java**, asi:
`@When ("I go to {word} using the navigation bar")`.

> [!TIP]  
> Ojo que son Corchetes `{}`.

16. Para el método `navigationBarUse` le añadimos el parámetro de la `section`.
17. Lo añadimos como parámetro a `clickOnSectionNavigationBar` en **FreeRangeSteps.java**.
18. En **PaginaPrincipal.java** añadimos el argumento o parámetro faltante.
19. Cambiamos de `sectionLink` el valor de `'Recursos'` por `'%s'`.
20. Reemplaza el marcador de posición en sectionLink con el nombre
 `String xpathSection = String.format(sectionLink, section);` y el clic con el 
 nuevo elemento `clickElement(xpathSection);`.
21. Lo podemos ejecutar desde **TestRunner.java** o el comando `gradle test`.

> [!TIP]  
> Si agrego en **FreeRangeNavegation.feature** en el `Scenario Outline`, la 
> palabra `<section>`, esta también aparecerá el momento de ejectutar por
> el triángulo verde (run) de **TestRunner.java**.
```feature
Scenario Outline: I can access the subpages through the navigation bar: <section>
```

## Paso 35
1. Comentamos del **FreeRangeNavigation.feature** todo el `Scenario`:
```feature
# Scenario Outline: I can access the subpages through the navigation bar: <section>
#     Given I navigate to www.freerangetesters.com 
#     When I go to <section> using the navigation bar
#     Examples:
#         | section    |
#             | Cursos     |
#             | Recursos   |
#             | Udemy      |
#             | Mentorías  |
#             | Newsletter |
```
2. Creamos en **FreeRangeNavigation.feature** un `Scenario` como este:
```feature
Scenario: Courses are presented correctly to potential customers
    Given I navigate to www.freerangetesters.com 
    When I go to Cursos using the navigation bar
    And select Introduction to Testing
```

> [!TIP]  
> Prefiero dejar todo en Inglés, también se evitan los acentos o tildes.

3. Agregamos en **FreeRangeSteps.java** un `@And`:
```java
    @And("select Introduction to Testing")
    public void navigateToIntro(){
        
    }
```
4. Creamos un archivo **PaginaCursos.java** en 'src/test/java/pages':
5. Del archivo **PaginaCursos.java** extendemos de `BasePage`.
6. Añadimos el Constructor basado en el padre.
7. Creamos una variable llamada `fundamentosTestingLink`, basado en
**PaginaPrincipal.java**, sería así la definición de la variable:
`private String fundamentosTestingLink = "//a[normalize-space()='Fundamentos del Testing' and @href]";`.
8. Creamos un método para hacer el click en el link, llamada `clickFundamentosTestingLink`:
```java
    public void clickFundamentosTestingLink(){
        // Click en el link de fundamentos Testing
        clickElement(fundamentosTestingLink);
    }
```
9. Instanciamos en **FreeRangeSteps.java** la nueva página de Cursos, e importamos 
`import pages.PaginaCursos;` y este sería el proceso:
```java
    PaginaCursos cursosPage = new PaginaCursos();
```
10. Lo podemos añadir en el método `navigateToIntro` de **FreeRangeSteps.java**, el
`cursosPage.clickFundamentosTestingLink();`.
11. Como ese click en este link, nos va a llevar a otra página, debemos crear un archivo 
**PaginaFundamentosTesting.java** en 'src/test/java/pages'.
12. En el archivo **PaginaFundamentosTesting.java** extendemos de `BasePage`.
13. Añadimos el Constructor basado en el padre.
14. Creamos una variable llamada `introduccionTestingLink`, basado en
**PaginaCursos.java.java**, sería así la definición de la variable:
`private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";`.

> [!CAUTION]  
> Hay problemas con utilizar acentos o tildes entonces se cambia el xPath por otro sin acentos.

15. Corrección de la variable `introduccionTestingLink` en **PaginaFundamentosTesting.java**
```java
    // Variable para acceder al link
    private String introduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software']";
```
16. Creamos un método para hacer el click en el link, llamada `clickIntroduccionTestingLink`:
```java
    public void clickIntroduccionTestingLink(){
        // Click en el link Introduccion al Testing
        clickElement(introduccionTestingLink);
    }
```
17. Instanciamos en **FreeRangeSteps.java** la nueva página de Fundamentos, e importamos 
`import pages.PaginaFuncamentosTesting;` y este sería el proceso:
```java
    PaginaCursos cursosPage = new PaginaCursos();
```
18. Lo podemos añadir en el método `navigateToIntro` de **FreeRangeSteps.java**, el
`fundamentosPage.clickIntroduccionTestingLink();`.
18. Podemos correr la prueba ejecutando en la `TERMINAL` el `gradle test` o el triángulo
verde del archivo **TestRunner.java**.

## Paso 37
1. Volvemos a comentar en el archivo **FreeRangeNavigation.feature** todo el `Scenario`:
```feature
# Scenario: Courses are presented correctly to potential customers
#     Given I navigate to www.freerangetesters.com
#     When I go to Cursos using the navigation bar
#     And select Introduction to Testing
```
2. Ponemos otro `Scenario`:
```feature
Scenario: Users can select a plan when signing up
    Given I navigate to www.freerangetesters.com
    When I select Elegir Plan

```
3. Creamos una variable `elegirPlanButton` en **PaginaPrincipal.java**: 
`private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";`.
4. Generamos el método q use esta nueva variable en `clickOnElegirPlanButton`.
5. En el archivo **FreeRangeSteps.java** definimos el nuevo `@When`:
```java
    @When("I select Elegir Plan")
    public void selectElegirPlan() {
        landingPage.clickOnElegirPlanButton();
    }
```
6. Podemos correr la prueba ejecutando en la `TERMINAL` el `gradle test` o el triángulo
verde del archivo **TestRunner.java**.

## Paso 39

> [!NOTE]  
> Empezaremos a utilizar lo relacionado con dropdowns del archivo **BasePage.java**.

1. Creamos en **BasePage.java** un método`getDropdownValues` q devuelva una lista pública:
```java
    public List<String> getDropdownValues( String locator){

    }
```
2. Nicitamos crear un objeto de la instancia Select `Select dropdown = new Select(Find(locator));`.
3. Cargamos una varialbe de tipo List de las opciones del dropdown
`List<WebElement> dropdownOptions = dropdown.getOptions();`.
4. Creamos una List instanciandola de un arreglo `List<String> values = new  ArrayList<>();`, 
el debe importar `import java.util.ArrayList;`.
5. Vamos a iterar dentro de `for` los elementos del dropdownOptions
```java
        for(WebElement option: dropdownOptions){
            // Adicionamos a `values` lo de dropdownOptions(option)
            values.add(option.getText());
        }
```
6. Por último retornamos el valor de `values`: `return values;`.
7. En el **FreeRangeNavegation.feature** definimos un nuevo paso:
```feature
        Then I can validate the options in the checkout page
```
8. En el archivo **FreeRangeSteps.java** definimos el `@Then`
```java
    @Then ("I can validate the options in the checkout page")
    public void validateCheckoutPlans(){
        
    }
```
9. En el archivo **FreeRangeSteps.java** ya tenemos muchas importaciones de la misma librería, 
entonces lo convertimos en un asterisco `*`, y comentamos el resto:
```java
import io.cucumber.java.en.*;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
```
10. Creamos una pagina llamada **PaginaRegistro.java**, con el `extends` de `BasePage` y
el constructor basado en el padre.
```java
package pages;

public class PaginaRegistro extends BasePage{

        // Añadimos el Constructor basado en el padre
        public PaginaRegistro() {
            super(driver);
        }
    
}
```
11. Creamos una variable llamada `planDropdown` y le cargamos el `Relative XPath`:
`private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";`.
12. Creamos una lista con el nombre `returnPlanDropdownValues`, esto importará
`import java.util.List;`, en el archivo **PaginaRegistro.java**:
```java
    public List<String> returnPlanDropdownValues() {
        return getDropdownValues(planDropdown);
    }
```
13. En el archivo **FreeRangeStesp.java**, instanciamos la `PaginaRegistro` y la importamos.
14. Dentro del método `validateCheckoutPlans` definimos una variable llamada `lista` con los valores
de `returnPlanDropdownValues`, tambien importamos `import java.util.List;`.
```java
    List<String> lista = registro.returnPlanDropdownValues();
```
15. En el archivo **FreeRangeSteps.java**, creamos otra lista llamada `listaEsperada`, e
importamos `import java.util.Arrays;`:
```java
        List<String> listaEsperada = Arrays.asList(
            "Academia: $16.99 / mes • 11 productos",
            "Academia: $176 / año • 11 productos",
            "Free: Gratis • 1 producto");
```

> [!NOTE]  
> A veces el editor te va a mostrar un dato como `...a:`, pero es solo visual, no afecta el proceso.

16. Creamos un `Assert` y lo importamos de `import org.testng.Assert;`:
```java
        Assert.assertEquals(lista, listaEsperada);
```
17. Lo podemos ejecutar desde **TestRunner.java** o el comando `gradle test`.

> [!CAUTION]  
> El sistema ha arrojado errores debido a los caracteres en castellano y el caracter 
> separador, haciendo lo siguiente:
> * He buscado el "encoding" para tranformar el UTF-8 en ISO-8859 como ejemplo esta
> página [Encode a String to UTF-8 in Java](https://www.baeldung.com/java-string-encode-utf-8).
> * Consulté alterar el archivo **settings.json** tanto el de Visual Studio Code como el
> del proyecto.
>
> Luego de varias opciones la solución fue simple en esta página [UTF-8 Encoding Debugging Chart](https://www.i18nqa.com/debug/utf8-debug.html), en el paso siguiente la solución.

18. En el archivo **FreeRangeSteps.java**, modificamos`listaEsperada`: así:
```java
        List<String> listaEsperada = Arrays.asList(
                "Academia: $16.99 / mes \u2022 11 productos",
                "Academia: $176 / a\u00F1o \u2022 11 productos",
                "Free: Gratis \u2022 1 producto");
```

> [!TIP]  
> El símbolo "backslash" seguido de la letra "u" es para mostrar un caracter unicode, 
> con base en esta tabla: [Table of UTF-8](https://www.i18nqa.com/debug/utf8-debug.html).

19. Lo podemos ejecutar desde **TestRunner.java** o el comando `gradle test` y ahora si el 
`Assert` si tendrá una respuesta positiva, siendo iguales la `lista` (14) y la 
`listaEsperada` (18).
```diff
+ BUILD SUCCESSFUL in 19s
3 actionable tasks: 3 executed
```

## Paso 41

> [!NOTE]  
> Vamos a ahondar en el tema de las `Assert` que nos proporciona el `TestNG`.
>
> ### Tipos de Assertions con TestNG: Recurso
>Las verificaciones son una parte fundamental a la hora de automatizar. Vamos a necesitar verificar que el estado de un sistema y sus elementos es el esperado y para eso vamos a usar la librería Assert de TestNG. 
>
>Acá les dejo los tipos más usados de Assertions y las que vimos en el video: 
>
>TestNG proporciona una serie de métodos de aserción a través de la clase Assert para verificar que las condiciones de las pruebas sean cumplidas. Estas aserciones son esenciales para validar el comportamiento esperado de la aplicación bajo prueba. A continuación, te detallo algunas de las aserciones más comunes y te proporciono ejemplos utilizando Selenium y Java:
>
>#### 1. assertEquals
>
>Verifica que dos valores sean iguales.
```java
  Assert.assertEquals(actualTitle, expectedTitle, "El título de la página no es el esperado.");
```
>#### 2. assertNotEquals
>
>Verifica que dos valores no sean iguales.
```java
   Assert.assertNotEquals(actualTitle, incorrectTitle, "El título de la página no debería ser este.");
```
>#### 3. assertTrue
>
>Verifica que una condición sea verdadera.
```java
  Assert.assertTrue(isElementPresent, "El elemento debería estar presente.");
```
>#### 4. assertFalse
>
>Verifica que una condición sea falsa.
```java
   Assert.assertFalse(isElementPresent, "El elemento no debería estar presente.");
```
>
>Estos son solo ejemplos básicos pero de los más usados. Tengan en cuenta lo que ya vimos en las clases, especialmente lo relacionado a cómo Selenium interactúa con elementos web y cómo nos "traemos" información de ellos para poder validar.

## Paso 43 

> [!NOTE]  
> Los `SoftAssert` de `TestNG`.
> ### Las Soft Assertions: Una parte muy conveniente de la librería TestNG: Recurso
>Van a haber momentos en los que van a tener que validar muchas pequeñas cosas que no son como para hacer un scenario por cada una. Digamos, por ejemplo, un formulario con muchos campos. 
>
>Queremos tener un test que valide que los campos están presentes y en el estado que los requerimientos dicen, pero no vamos a hacer 25 tests distintos para cada campo. Ahí es donde entran las Soft Assertions. A continuación, dejo cómo implementarlas y un ejemplo: 
>
>Primero el import:
```java
import org.testng.asserts.SoftAssert;
```
>Segundo crear la instancia del objeto SoftAssert
```java
SoftAssert soft = new SoftAssert();
Y así se ven (exactamente como las assertions comunes, pero con el potente assertAll(); al final!
public void Ejemplulis() {
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";
 
        // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar
        // muchas cosas pequeñas a la vez.
        soft.assertEquals(palabraEsperada, palabraEncontrada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        soft.assertNotEquals(palabraEncontrada,palabraEsperada);
 
        soft.assertAll();
 
    }
```

## Paso 45
1. del archivo **FreeRangeNavegation.feature** quitamos los comentarios.
2. Justo arriga de `Scenario: Users can select a plan when signing up`, agregamos un espacio
y el *tag* llamado `@Plans`.
3. En el archivo **TestRunner.java** al final de 
`plugin = {"pretty", "html:target/cucumber-reports}"`agregamos una coma, el [Enter] y el
texto `tags=` para completar con `"@Plans"`:
```java
@CucumberOptions(
    features = "src/test/resources",  //Directorio de archivos .feature
    glue = "steps",  //Paquete de las Clases de los pasos del feature
    plugin = {"pretty", "html:target/cucumber-reports"},
    tags = "@Plans"
) 
```
4. Ejecutamos en la `TERMINAL`  el comando `gradle test` y el va a correr solo el que
tiene el *tag*, llamado `@Plans`.
5. Añadimos al final de **build.gradle** lo siguiente:
```gradle
tasks.named('test') {
    systemProperty "cucumber.options", System.getProperty("cucumber.options")
    systemProperties System.getProperties();
}
```
6. De mnuevo en la `TERMINAL` el comando va a cambier de la siguiente manera:
```bash
gradle test -Dcucumber.filter.tags="@Plans"
```

> [!WARNING]  
> Esto solo funciona en la `TERMINAL` llamada `Git Bash`, no funciona en `Powershell` y
> menos en `Command Prompt`, el tema de añadir el parametro `-D` y el resto q apunta a 
> cucumber (_Si alguien conoce la respuesta por favor comentarla_).

7. En el archivo **FreeRangeNavigation.deature** arriba de 
`Scenario: Users can select a plan when signing up` añaddimos esto
```feature
    @Plans @Courses
    Scenario: Users can select a plan when signing up
```
8. En el archivo **FreeRangeNavigation.deature** arriba de
`Scenario: Courses are presented correctly to potential customers` añadimos esto
```feature
    @Courses
    Scenario: Courses are presented correctly to potential customers
```
9. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr los excenarios q **NO**
tengan `"@Plans"`. El `not` es totalmente en minúsculas.
```bash
gradle test -Dcucumber.filter.tags="not @Plans"
```
10. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr todos los scenarios que
 tengan ambos, `"@Plan"` y `"@Courses"` tags al mismo tiempo.
 ```bash
 gradle test -Dcucumber.filter.tags="@Plans and @Courses"
 ```
11. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr los scenarios que tengan los tags `"@Plans"` o `"@Courses"` (osea...todos los scenarios que tengan uno u otro).
```bash
gradle test -Dcucumber.filter.tags="@Plans or @Courses"
```
12. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr todos los scenarios que tengan el tag `"@Plans"` y no tengan `"@Courses"`.
```bash
gradle test -Dcucumber.filter.tags="@Plans and not @Courses"
```
