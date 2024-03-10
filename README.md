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
6. Cambiamos el `tags` de **TestRunner.java** a `= "@None"`.
7. De nuevo en la `TERMINAL` el comando va a cambier de la siguiente manera:
```bash
gradle test -Dcucumber.filter.tags="@Plans"
```

> [!WARNING]  
> Esto solo funciona en la `TERMINAL` llamada [`Git Bash`](https://git-scm.com/downloads), no funciona en `Powershell` y
> menos en `Command Prompt`, el tema de añadir el parametro `-D` y el resto q apunta a 
> cucumber (_Si alguien conoce la respuesta por favor comentarla_).

8. En el archivo **FreeRangeNavigation.feature** arriba de 
`Scenario: Users can select a plan when signing up` añadimos esto
```feature
    @Plans @Courses
    Scenario: Users can select a plan when signing up
```
9. En el archivo **FreeRangeNavigation.feature** arriba de
`Scenario: Courses are presented correctly to potential customers` añadimos esto
```feature
    @Courses
    Scenario: Courses are presented correctly to potential customers
```
10. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr los excenarios q **NO**
tengan `"@Plans"`. El `not` es totalmente en minúsculas.
```bash
gradle test -Dcucumber.filter.tags="not @Plans"
```
11. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr todos los scenarios que
 tengan ambos, `"@Plan"` y `"@Courses"` tags al mismo tiempo.
 ```bash
 gradle test -Dcucumber.filter.tags="@Plans and @Courses"
 ```
12. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr los scenarios que tengan los tags `"@Plans"` o `"@Courses"` (osea...todos los scenarios que tengan uno u otro).
```bash
gradle test -Dcucumber.filter.tags="@Plans or @Courses"
```
13. En la `TERMINAL` de `bash`, al ejecutar el comando, va a correr todos los scenarios que tengan el tag `"@Plans"` y no tengan `"@Courses"`.
```bash
gradle test -Dcucumber.filter.tags="@Plans and not @Courses"
```

> [!NOTE]  
> Lista de parámetros hallado en este sitio [Cucumber Reference](https://cucumber.io/docs/cucumber/api/?lang=java), como el ejemplo de 
> `gradle test -Dcucumber.filter.tags="@smoke"`
>|Propiedad|Ejemplo|
>|---|---|
>|cucumber.ansi-colors.disabled=  |# true or false. default: false|
>|cucumber.execution.dry-run=     |# true or false. default: false|
>|cucumber.execution.limit=       |# number of scenarios to execute (CLI only).|
>|cucumber.execution.order=       |# lexical, reverse, random or random:[seed]| (CLI only). default: lexical|
>|cucumber.execution.wip=         |# true or false. default: false.|
>|cucumber.features=              |# comma separated paths to feature files. |example: path/to/example.feature, path/to/other.feature
>|cucumber.filter.name=           |# regex. example: .*Hello.*|
>|cucumber.filter.tags=           |# tag expression. example: @smoke and not @slow|
>|cucumber.glue=                  |# comma separated package names. example: com.example.glue|
>|cucumber.plugin=                |# comma separated plugin strings. example: pretty, json:path/to/report.json|
>|cucumber.object-factory=        |# object factory class name. example: com.example.MyObjectFactory|
>|cucumber.snippet-type=          |# underscore or camelcase. default: underscore|

## Paso 47

>[!NOTE]  
> **Backgrounds**: Serían como prerrequisitos o pre-steps, o un conjunto de 
> steps, q son comunes a las pruebas realizadas.

1. En el archivo **FreRangeNavegation.feature**, agrego antes del primer 
`Scenario` el siguiente texto:
```feature
Background: I am on the Free Range Testers web without logging in.
    Given I navigate to www.freerangetesters.com
```
2. Puedo Comentar o eliminar lo otros `Given`, dado q el `Background`, lo maneja todos.
3. En el archivo **FreRangeNavegation.feature**, agrego como primera linea el
siguiente texto:`@Navigation`.
4. En el archivo **TestRunner.java** cambio el tag por `"@Navigation"`.
5. Lo podemos probar ejecutando desde **TestRunner.java** o el comando 
`gradle test` en cualquier `TERMINAL`.
```diff
+BUILD SUCCESSFUL in 34s
3 actionable tasks: 2 executed, 1 up-to-date
```
6. Recuerda revisar el archivo de tu proyecto en esta ruta
 "build/reports/tests/test", llamado **index.html**.
7. Ese **index.html** visto en un browser, le damos clic en el botón del medio
Llamado `Classes` y luego al link de abajo llamado `Navigation bar`:
 ![Class Navigation bar](images/section08-step_47-index_html.png)
 Pueden jugar con los botones de esta página.

>[!TIP]  
> Los `Background` no deben tener mas de dos steps, sino hay un problema de
> estructuración.

## Paso 49
>[!NOTE]  
>Mejorar los steps permitiendo usar uno u otro texto.

1. En el archivo **FreeRangeSteps.java**, cambiar esto:
`@And("I select Introduction to Testing")`, por esto:
`@And("(I|The user|The client) (select|selects) Introduction to Testing")`.
2. En el archivo **FreeRangeSteps.java**, cambiar esto:
`@Then("I can validate the options in the checkout page")` por esto:
`@Then("(I|The user|The client) can validate the options in the checkout page")`.
3. En el archivo **FreeRangeSteps.java**, cambiar esto:
`@When("I select Elegir Plan")` por esto:
`@When("(I|The user|The client) (select|selects) Elegir Plan")`.
4. Podemos jugar en el archivo **FreeRangeNavigation.feature** y cambiar
esto: `And I select Introduction to Testing`, por esto:
`And The user select Introduction to Testing`.
5. Tambien podemos cambiar en el archivo **FreeRangeNavigation.feature** esto:
 `Then The client can validate the options in the checkout page`, por esto:
`Then The client can validate the options in the checkout page`.
6. Cambie en **TestRunner.java** el `tag`por este:`tags = "@Courses"`, solo
requiero ejecutar los q he hecho cambios.
7. Lo podemos probar ejecutando desde **TestRunner.java** o el comando 
`gradle test` en cualquier `TERMINAL`.

>[!CAUTION]  
>Hasta acá tengo errores y no reconoce los cambios hechos. Páginas consultadas
>* [Gherkin: Grouping the steps using | (pipe symbol) ](https://self-learning-java-tutorial.blogspot.com/2018/05/gherkin-grouping-steps-using-pipe-symbol.html).
>* [Cucumber and Scenario](https://www.baeldung.com/cucumber-scenario-outline).

>[!TIP]  
> Hice cambios en el **settings.json**
>```json
>    "cucumberautocomplete.strictGherkinCompletion": true,
>    "cucumberautocomplete.strictGherkinValidation": false,
>    "cucumberautocomplete.gherkinDefinitionPart": "(Given|When|Then|And)\\(",
>    "cucumberautocomplete.smartSnippets": true,
>    "cucumberautocomplete.stepsInvariants": true,
>    "cucumberautocomplete.skipDocStringsFormat": true,
>    "cucumberautocomplete.formatConfOverride": {
>        "And": 3,
>        "But": "relative",
>    },
>    "cucumberautocomplete.onTypeFormat": true,
>    "cucumberautocomplete.customParameters": [
>        {
>            "parameter":"$",
>            "value":"\\$"
>        }
>    ],
>```
> Despues de estos cambios se debe cerrar y abrir el Visual Studio Code.

## Paso 51

>[!NOTE]  
> Resulta q hasta acá el no va a ejecutar de forma satisfactoria las pruebas
> con las nuevas expresiones regulares, entonces en este, vamos a buscar como
> poner a funcionar estas pruebas.

1. En el Archivo **FreeRangeSteps.java**, añadimos a la expresión regular
un signo de prgunta y dos puntos `?:`.
2. En el mismo **FreeRangeSteps.java**, cambiamos `(select|selects)` por
`selects?`.
3. Añadimos antes del `(?:)` un símbolo llamado *circunflejo* `^` y al final
 un signo *pesos* `$`, quedando así las líneas donde está la expresión regular:
 ```java
     @When("^(?:I|The user|The client) selects? Elegir Plan$")
    ...

    @And("^(?:I|The user|The client) selects? Introduction to Testing$")
    ...

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    ...
 ```
4. Lo podemos probar ejecutando desde **TestRunner.java** o el comando 
`gradle test` en cualquier `TERMINAL`.
```diff
+BUILD SUCCESSFUL in 20s
3 actionable tasks: 2 executed, 1 up-to-date
```

## Paso 53

>[!NOTE]  
> Es probable q el reporte a ver basado en una API, no esté disponible para
> ser utilizado por todas las empresas, y puede estar bloqueado.

1. Ingresa a este sitio [Cucumber Reports](https://reports.cucumber.io/).
2. Establecer un login con la cuenta de [GitHub](https://github.com/).

>[!TIP]  
> Si no tienes cuenta en GitHub, crear una nueva usando tu correo personal
> puede ser tu correo personal de *gmail*, ejemplos de ayuda:
>* [Como crear una cuenta de github 2023](https://www.youtube.com/watch?v=Y1zoHt1UMq0&t=20s).
>* [CÓMO CREAR una cuenta de GITHUB](https://www.youtube.com/watch?v=jwFSIEi_d7E&t=74s).

3. Proceder con la autorización a "SmartBear"  
![Authorize Cucumber Reports](images/section09-step_53-Authorize-Cucumber-Reports.png)

4. Debe llegar a esta página despues de un rato de espera  
![Request Collections](images/section09-step_53-Request-Collections.png)

5. Escribir en el cuadro de "Name" de las Collections el texto: 
"SeleniumFreeRange" y presionar el botón de **"Create new Collection"**.
6. El te lleva a una página donde te muestra un TOKEN, por favor almacenarlo aparte. Se sugiere crear un archivo llamado **.env** y almacenar dicha
 información ahí.

>[!CAUTION]  
> Se puede almacenar el TOKEN en el archivo llamado **.env** y tener
> la precaución de __NO SUBIR__ ⬆️ este  al repositorio.  
> Este TOKEN es secreto y no debe ser compartido por error.  
![Cucumber Token](images/section09-step_53-Cucumber-token.png) 

>[!TIP]  
> En el archivo **.gitignore**, le agregué esto para evitar se suba por 
>equivocación el archivo **.env** donde almacené el TOKEN:
>```dotenv
># dotenv environment variable files
>.env
>.env.development.local
>.env.test.local
>.env.production.local
>.env.local
>```

7. Como estamos utilizando Windows como sistema Operativo, añadimos a las variables de Ambiente una nueva llamada `CUCUMBER_PUBLISH_TOKEN` y le asignamos el valor del TOKEN obtenido en la página anterior.
8. Pasos luego de abrir las "Variables de Ambiente" o "Environment...":
    1. Dar el **New** en la parte de abajo (System variables).
    2. Escribir el nombre y el TOKEN.
    3. Dar **OK**.
    4. Dar el **OK** final de **`Environment Variables`**.
    5. Y Dar el último **OK** de la ventana de **`System Properties`**.  
![Environment Variables](images/section09-step_53-Environment-Variables.png)

9. Cerramos y reabrimos el "Visual Studio Code", y dependiendo de la terminal escribimos el comando:  
    >`Powershell`
    ```powhershell
    $env:CUCUMBER_PUBLISH_TOKEN
    ```
    >`Command Prompt`
    ```dos
    echo %CUCUMBER_PUBLISH_TOKEN%
    ```
    >`bash`
    ```bash
    echo $CUCUMBER_PUBLISH_TOKEN
    ```

10. Creamos un archivo llamado **cucumber.properties**, dentro de la carpeta 
"src/test/resources", con el texto:
```xml
cucumber.publish.enabled=true
```
11. Ejecuto la prueba desde cualquier `TERMINAL` con el comando de 
`gradle test` o desde el triángulo de **TestRunner.java** y luego voy a la
página [Cucumber Reports](https://reports.cucumber.io/) e ingresamos a la
colección q bautizamos como: "SeleniumFreeRange", nos aparece nuestro primer
reporte.  
Jugamos y le damos click en varias partes para conocer este nuevo reporte.

## Paso 55

1. Creamos un archivo llamado **Hooks.java** dentro de la carpeta 
"src/test/java/steps".
2. Extendemos de `BasePage`, por ende el importa `import pages.BasePage;`:
```java
public class Hooks extends BasePage {
  
}
```
3. Añadimos dentro de esta clase el constructor:
```java
  public Hooks(){
    super(driver);
  }
```
4. Invocamos un proceso para ser ejecutado al final es decir un `@After`, 
el va a importar `import io.cucumber.java.After;`, con una funcion llamada
`tearDown` y un parámetro de tipo `Scenario` e importar 
`import io.cucumber.java.Scenario;`:
```java
  @After
  public void tearDown(Scenario scenario){
  } 
```
5. Ponemos una condicional basado en el parámetro `scenario`:
```java
    if (scenario.isFailed()){
    }
```
6. Y dentro de la condicional, solo mostramos un log: `scenario.log("Scenario failing, please refer to the image attached to this report");`.
7. Finalizamod con una variable de tipo `byte[]` llamada `screenshot`, el
 debe de importar dos `import org.openqa.selenium.OutputType;`y 
`import org.openqa.selenium.TakesScreenshot;`:
```java
      final byte[] screenshot = ((TakesScreenshot) driver)
          .getScreenshotAs(OutputType.BYTES);
```
8. Añadir al `scenario` el valor de la imagen obtenida:
```java
     scenario.attach(screenshot, "image/png", "Screenshot of the error");
```
9. Hacemos un cambio en **FreeRangeSteps.java** en la linea 57, cambiando
 esto: `"Academia: $16.99 / mes \u2022 11 productos",`, por esto:
 `"Academia: $26.99 / mes \u2022 11 productos",`.

10. Ejecuto la prueba desde cualquier `TERMINAL` con el comando de 
`gradle test` o desde el triángulo de **TestRunner.java** y luego voy a la
página [Cucumber Reports](https://reports.cucumber.io/) e ingresamos a la
colección q bautizamos como: "SeleniumFreeRange", y revisamos el mas
reciente reporte.
```diff
-BUILD FAILED in 26s
3 actionable tasks: 3 executed
```

![ReportFail_Screenshot](images/section09-step_55-ReportFail_Screenshot.png)

## Paso 57 a Paso 67
>[!NOTE]  
> Esto es un breve repaso de todos los pasos q hicimos anteriormente
> Precondiciones:
> * Java 11 instalado
> * Gradle instalado
> * Visual Studio Code
>
> De otro lado el proceso totalmente manual de configuración de 
>**build.gradle**.
> Lo mismo q los *Troubleshootings* entre VSCode y JDK/Gradle.  
> Voy a crear de nuevo el proyecto

1. Borro todo el contenido de la carpeta "SeleniumFreeRange"
2. Creo un nuevo proyecto con [Ctrl][Shift][P].
3. Seleccionar `Java: Create Java Project`.
4. Seleccionamos "Gradle".
5. La carpeta es la misma de "SeleniumFreeRange".
6. Después "Groovy".
7. Y el nombre de "SeleniumFreeRange".
8. Corremos en la `TERMINAL` el `gradle clean` y luego el 
`gradle build`.
9. De nuevo [Ctrl][Shift][P], para ver `java: Configure Java Runtime`.

## Paso 68
1. Sacamos la carpeta "src" y el archivo **build.gradle** a la raiz del proyecto y borramos la carpeta sobrante "app".
2. Creamos el archivo **Google.feature** dentro de la carpeta 
"src/test/resources", con este texto:
```feature
Feature: Probar la busqueda en Google

  Scenario: Busco algo en Google
  Given navegar a google
  When busco algo
  Then obtengo resultados
```
3. Corregimos el **build.gradle** de la siguiente manera:
```gradle
plugins {
    id 'java'
}

group 'CursoUdemy'
version '1.0-SNAPSHOT'

sourceCompatibility = 11

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.18.1'
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.15.0'
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.15.0'

}
```
4. Dentro de "src\test\java" borramos la carpeta "seleniumfreerange".
5. Dentro de "src\main\java" borramos la carpeta "seleniumfreerange".
6. En la `TERMINAL` ejecutamos el `gradle clean` y luego el 
`gradle build`.
```diff
+BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```

## Paso 69
1. Ajusto el archivo **Google.feature**:
```feature
Feature: Test Google seach functionality

Scenario: As a user I enter a search criteria in Google
  Given I am on the Google seach page
  When I enter a search criteria
  And click on the seach button
  Then the results match the criteria
```
2. En la carpeta "src/test/java", crear dos carpetas "pages" y "steps".
3. Mover el archivo **Google.feature** a una nueva carpeta en 
"src/test/resources/features".
4. Crear el archivo **GoogleSteps.java** dentro de "src/test/java/steps", 
con este contenido inicial:
```java
package steps;

public class GoogleSteps {
  
}
```
5. Colocamos un `@Given` e importamos `import io.cucumber.java.en.Given;`,
dentro de **GoogleSteps.java**
6. Añadimos al **build.gradle** dos dependencias mas:
```gradle
    // https://mvnrepository.com/artifact/junit/junit
    testImplementation group: 'junit', name: 'junit', version: '4.13.2'
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation group: 'org.slf4j', name: 'slf4j-api', version: '2.0.12'
```
7. Completamos en **GoogleSteps.java** la sintaxis del `@Given`:
```java
  @Given("^I am on the Google seach page$")
  public void navigateToGoogle(){

  }
```
8. En **GoogleSteps.java** completemos los demás `@When`, `@And` y `@Then`:
```java
  @When("^I enter a search criteria$")
  public void enterSearchCriteria(){

  }

  @And("^click on the seach button$")
  public void clickSearchButton(){

  }

  @Then("^the results match the criteria$")
  public void validateResults(){

  }
```
9. Cambiamos la importación de cada uno de `import io.cucumber.java.en`,
por uno solo de todo `import io.cucumber.java.en.*;`.
10. Creamos una carpeta llamada "runner" dentre de "src\test\java".
11. Creamos el archivo **Runner.java** dentro de "src/test/java/runner".
12. Del archivo **Runner.java** añadimos antes de `class`:
```java
package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  glue = "src/test/java/steps"
)

public class Runner {
  
}
```
13. Al lado izquierdo en **Runner.java** nos aparece un triángulo verde, 
para que podamos hacer `run` o `debug`.

>[!WARNING]  
> Recuerden q como tenemos una variable de ambiente llamada 
> `CUCUMBER_PUBLISH_TOKEN`, el reporte pasa al sitio 
> [Cucumber Reports](https://reports.cucumber.io/), si lo quieren local
> simplemente borren esa variable de ambiente y reinicien el Visual Studio
> Code.

14. Debido a una advertencia q sale en el `DEBUG CONSOLE`, se cambia el 
`glue` a este mas sencillo, dado q lo busca basado en el `package`:
```java
@CucumberOptions(
  features = "src/test/resources/features",
  // glue = "src/test/java/steps"
  glue = "steps"
)
```

## Paso 70
>[!NOTE]  
> Explicación del P.O.M. Page Object Model, como patrón de diseño.

## Paso 71
>[!NOTE]  
Configuración de ChromeDriver en Windows y MacOS.
Previo a la creación la clase principal en la próxima clase, sobre la que las demás clases de nuestro Page Object Model van a descansar y heredar, tienen que prestar atención a esta clase sobre cómo configurar ChromeDriver tanto en Windows como Mac! 
>
>Una nota rápida para los usuarios de Windows y Mac sobre cómo especificar la ruta al ChromeDriver.
>
>**En Windows:**
>Dentro del bloque estático que creamos en BasePage.java, añadan la siguiente línea: 
>```java
>System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
>```
>Solo tienen que cambiar la ruta a donde tienen descargado el chromedriver!
>
>**En MacOS:**
>1. Abran la Terminal.
>2. Ejecuten "sudo nano /etc/paths".
>3. Les va a pedir la contraseña, pónganla.
>4. Vayan al final del archivo y agreguen el path de, en este caso, WebDriver.
>5. En mi caso es "/users/MiNombre/Documents/WebDriver"
>6. Hagan Control + x para salir.
>7. Presionen `Y`  para salvar.
>8. Presionen Enter para confirmar.
>
>Para chequear que quedó bien, cierren y vuelvan a abrir la terminal y ejecuten "echo $PATH". Deberían poder el nuevo path que agregaron junto a los otros.

## Paso 72
1. Crear el archivo **BasePage.java** dentro de "src/test/java".
2. Creamos la variable `driver` de tipo `WebDriver`, e importa 
`import org.openqa.selenium.WebDriver;`.
3. Creamos la variable `wait` de tipo `WebDriverWait`, e importa
`import org.openqa.selenium.support.ui.WebDriverWait;`.
4. Creamos un elemento estático llamado `chromeOptions` e importa
`import org.openqa.selenium.chrome.ChromeOptions;`.
5. Al `driver` le asignamos el `ChromeDriver` y al `wait` se le
asigna el `WebDriverWait`.
6. Creamos el `Constructor`, asi sería el resultaodo hasta el momento de
**BasePage.java**:
```java
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  // Definicón de las variables a utilizar
  protected static WebDriver driver;
  private static WebDriverWait wait;

  // Instanciamos las variables
  static {
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // Definición del Constructor
  public BasePage(WebDriver driver){
    BasePage.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public static void navigateTo(String url){
    driver.get(url);
  }
}
```
7. Creamos el archivo **GooglePage.java** en "src/test/java/pages", y 
extendemos la herencia de `BasePage.`.
8. Ponemos el contructor basado en `BasePage`:
```java
  public GooglePage(){
    super(driver);
  }
```
9. Relizamos la Navegación
```java
  public void navigateToGoogle(){
    navigateTo("https://www.google.com");
  }
```
10. En **GoogleSteps.java** instanciamos el `GooglePage` e importar 
`import pages.GooglePage;`.
11. Añadimos `google.navigateToGoogle();` al `@Given` del archivo
**GoogleSteps.java**.
11. Ejecutamos la prueba desde **Runner.java**, debe abrir el browser a
google y ya.

## Paso 73
>[!TIP]  
> Como puede solucionar JVM (Java) desde la pagina de [Visual Studio Code](https://code.visualstudio.com/docs/java/java-tutorial).
> Luego dentro de Visual Studio Code instalamos las extensiones faltantes:
> * **Extension Pack for Java** de Microsoft.
> * **Gradle Extension Pack** de Richard Wills.
>
> Instalar el Gradle de esta página [Gradle](https://gradle.org/install/).
>
> Si el problema es q no aparece en **runner.java** la flecha verde o el 
> cículo para ejecutar, persionar las teclas [Ctrl][Shift][P], y seleccionar
> `Java: Clean Java Language Server Workspace`.

## Paso 74
>[!NOTE]  
> Explicación de que es un WebElement, y para mas información aquí:
>[Elements](https://www.selenium.dev/documentation/webdriver/elements/).

## Paso 75
>[!NOTE]  
> Explicación de Locators, y el recurso en español no está disponible, pero
> se puede acceder a este otro: [Locators](https://www.selenium.dev/documentation/webdriver/elements/locators/).

## Paso 76 a  80 
>[!NOTE]  
> Jugando con los WebElements de cualquier página HTML.
> * Locators por ID.
> * Locators por NAME.
> * Locators por CSS.
> * Locators por XPATH.

## Paso 81
> [!NOTE]  
> Extensión de Chrome se llama [ChroPath](https://addons.mozilla.org/es/firefox/addon/chropath-for-firefox/) , pero ya hemos usado antes una 
> extensión llamada [SelectorsHub](https://selectorshub.com/selectorshub/), que es mucho mejor. 

## Paso 82
1. En el archivo **BasePage.java**, creamos un método llamado `Find` 
que devolverá un `WebElement` y que sea `private`:
```java
  private WebElement Find(String locator){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }
```
2. Usando el `Find` empezamos a aprovecharlo en un Click:
```java
  public void clickElement(String locator){
    Find(locator).click();
  }
```
3. Creamos en **GooglePage.java** una variable `private` y de tipo `String`
llamada `searchButton` y le asignamos el valor `xPath` de ese botón.
4. En el Archivo **GooglePage.java**, aprovechamos el nuevo método del Click:
```java
  public void clickGoogleSearch(){
    clickElement(searchButton);
  }
```
5. Añadimos en **GoogleSteps.java**, el llamado al método de
 `clickGoogleSearch`.
6. Ejecutamos la prueba desde **Runner.java**, debe abrir el browser a
google, hacer el click (no se ve nada nuevo, pues no hemos escrito que buscar) y
 deja abierto el browser.

## Paso 83
1. Creamos en **BasePage.java** un método `public` llamado `writeElement`:
```java
  public void writeElement(String locator, String textToWrite){
    Find(locator).clear();
    Find(locator).sendKeys(textToWrite);
  }
```
2. Creamos en **GooglePage.java** una variable `private` y de tipo `String`
llamada `searchTextField` y le asignamos el valor `xPath` del criterio de
 búsqueda.
3. Añadimos un método en **GooglePaga.java**, de llamado `enterSeachCriteria`,
con un argumento para el texto a buscar:
```java
  public void enterSeachCriteria(String criteria){
    writeElement(searchTextField, criteria);
  }
```
4. Corregimos el `xPath` de `searchButton` en **GooglePage.java**.
5. En el archivo **GoogleSteps.java** añadimos el llamado al método de
`enterSeachCriteria` con el argumento `"Google"`, así quedan el `@Given`,
`@When` y `@And`:
```java
  @Given("^I am on the Google seach page$")
  public void navigateToGoogle(){
    google.navigateToGoogle();
  }

  @When("^I enter a search criteria$")
  public void enterSearchCriteria(){
    google.enterSeachCriteria("Google");
  }

  @And("^click on the seach button$")
  public void clickSearchButton(){
    google.clickGoogleSearch();
  }
```
6. Ejecutamos la prueba desde **Runner.java**, debe abrir el browser a
google, escribir el texto, hacer el click y dejar abierto el browser.

## Paso 84
1. En el archivo **BasePage.java** creamos un método para el manejo de 
dropdows, llamado `selectDropDownByValue`.
2. En el nuevo método, seleccionamos el elemento en la variable
`dropdown` y se importa `import org.openqa.selenium.support.ui.Select;`.
3. Usamos el `dropdown` para seleccionar por valor:
```java
  public void selectDropDownByValue(String locator, String valueToSelect){
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByValue(valueToSelect);
  }
```
4. En el archivo **BasePage.java** creamos un método para el manejo de 
dropdows, llamado `selectDropDownByIndex`.
5. Instanciamos la variable `dropdown` basada en el tipo `Select`.ñ
6. Usamos el `dropdown` para seleccionar por Índice:
```java
  public void selectDropDownByIndex(String locator, int index) {
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByIndex(index);
  }
```
7. Repetimos un nuevo método pero esta vez por texto:
```java
  public void selectDropDownByText(String locator, String valueToSelect) {
    // Instanciamos el elemento del dropdown
    Select dropdown = new Select(Find(locator));
    // Usamos el dropdown
    dropdown.selectByVisibleText(valueToSelect);
  }
```

>[!TIP]  
> Dado q en esta lección vamos a crear varios archivos para interactuar con una
>página de ejemplos de uso de automatización, el sitio que muestra el 
> instructor [Test and Quiz](https://testandquiz.com/selenium/testing.html)
>ya no existe, se sugiere esta otra página [Sample webpage](https://artoftesting.com/samplesiteforselenium).

8. Creamos el archivo **Sandbox.feature** en "src/test/resources/features":
```feature
@Test
Feature: Test different actions on a sandbox page.

Scenario: As a Test Engineer, I try out different actions on a sandbox page.
  Given I navigate to the sandbox page
  And select a value from the dropwdown
```
9. Creamos el archivo **TestSandBox.java** en "src/test/java/pages":
```java
package pages;

public class TestSandBox extends BasePage {

    // El locator para el dropdown
    private String dropdown ="//select[@id='testingDropdown']";

  // Usamos el Contructor del padre
  public TestSandBox() {
    super(driver);
  }

  // Vamos a relizar la Navegación
  public void navigateToSandbox() {
    navigateTo("https://artoftesting.com/samplesiteforselenium");
  }

    // Cambiamos del dropdown
    public void selectCategory(String text){
      selectDropDownByValue(dropdown, text);
    }
}
```
10. Creamos el archivo **TestSandboxSteps.java** en "src/test/java/steps":
```java
package steps;

import io.cucumber.java.en.*;
import pages.TestSandBox;

public class TestSandboxSteps {
  TestSandBox sandboxPage = new TestSandBox();

  @Given("^I navigate to the sandbox page$")
  public void navigateToTheSandboxSite() {
    sandboxPage.navigateToSandbox();
  }

  @And("select a value from the dropwdown$")
  public void selectState() {
    sandboxPage.selectCategory("Manual");
  }
}
```
11. En el archivo **Runner.java**, en las `@CucumberOptions`, añadimos un `tags`
```java
@CucumberOptions(
  features = "src/test/resources/features",
  // glue = "src/test/java/steps"
  glue = "steps",
  tags = "@Test"
)
```
12. Ejecutamos la prueba desde **Runner.java**, debe abrir el browser al 
sitio de pruebas y cambiar el dropdown y ya.

## Paso 85
1. En el archivo **BasePage.java**, creamos una variable llamada `action` del
tipo `Actions` y se importa `import org.openqa.selenium.interactions.Actions`.
2. Añadimos un método en **BasePage.java**, llamado `hoverOverElement`.
3. Dentro de `hoverOverElement`, añadimos un `action`:
```java
  public void hoverOverElement(String locator) {
    //Agreamos un `action`
    action.moveToElement(Find(locator));
  }
```
4. Añadimos un método en **BasePage.java**, llamado `doubleClickElement`.
5. dentro de `doubleClickElement`, añadimos un `action`:
```java
  public void doubleClickElement(String locator){
    // Agregamos el `action`
    action.doubleClick(Find(locator));
  }
``` 
6. Añadimos un método en **BasePage.java**, llamado `rightClickElement`.
7. dentro de `rightClickElement`, añadimos un `action`:
```java
  public void rightClickElement(String locator){
    // Agregamos el `action`
    action.contextClick(Find(locator));
  }
```
## Paso 86
1. Quitamos de **Sandbox.feature**, el primer `@Test` (línea 1).
2. Adiciono un nuevo Escenario en **Sandbox.feature**:
```feture
@Test
Scenario: As a Test Engineer, I want to retrieve the value of an static table.
  Given I navigate to the static table Then I can return the value I wanted
  Then I can return the value I wanted
```
3. Adicionar un método en **BasePage.java**, llamado `getValueFromTable`:
```java
  public String getValueFromTable(String locator, int row, int column) {
    // Encadenamos junto con el `locator` lo requerido para el dato en cuestión
    String cellINeed = locator + "/table/tbody/tr[" + row + "]/td [" + column + "]";
    // Devolvemos el texto interno
    return Find(cellINeed).getText();
  }
```
4. Crear un archivo **GridPage.java** en "src/test/java/pages":
```java
package pages;

public class GridPage extends BasePage {

  String grid = "//*[@id='root']/div/";

  // Usamos el Contructor del padre
  public GridPage(){
      super(driver);
    }

  public void navigateToGrid() {
    // Esta URL existe y es del sitio https://codesandbox.io/
    navigateTo("https://1v2njkypo4.csb.app/");
  }

  public String getValueFromGrid(int row, int col) {
    return getValueFromTable(grid, row, col);
  }
}
```

>[!TIP]  
> El sitio [simple-html-table-example(https://1v2njkypo4.csb.app/)](https://1v2njkypo4.csb.app/), se origina en [Sandbox](https://codesandbox.io/).

5. Crear un archivo **GridTestSteps.java** en "src/test/java/steps":
```java
package steps;

import cucumber.api.java.en.*;
import pages.GridPage;

public class GridTestSteps {

  GridPage grid = new GridPage();

  @Given("^I navigate to the static table Then I can return the value I wanted$")
  public void navigateToGridPage() {
    grid.navigateToGrid();
  }

  @Then("^I can return the value I wanted$")
  public void returnValue() {
    String value = grid.getValueFromGrid(3, 2);
    System.out.println(value);
  }
}
```
6. Ejecutamos la prueba desde **Runner.java**, debe abrir el browser al
sitio de https://codesandbox.io/, luego el dato obtenido lo debes buscar abajo
en `DEBUG CONSOLE`:  
![Debug-Console](images/section12-step_86-ResultPrint.png)

7. Adicionamos un método en **BasePage.java**, llamado `setValueOnTable`:
```java
  public void setValueOnTable(String locator, int row, int column, String text2Send){
     // Encadenamos junto con el `locator` lo requerido para el dato en cuestión
     String cell2Fill = locator + "/table/tbody/tr[" + row + "]/td [" + column + "]";
     // Llenamos la celda
     Find(cell2Fill).sendKeys(text2Send);
  } 
```
