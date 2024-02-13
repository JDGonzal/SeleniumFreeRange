# Java-Cucumber-01
https://perficient.udemy.com/course/selenium-con-java-y-cucumber-el-curso-definitivo/learn/lecture/41595708#overview
## Prerrequisitos
1. Tener "Visual Studio Code", como editor
2. Tener Instalado "JAVA", "GRADLE", "GROOVY" y "MAVEN".
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
* Snipets and Sintax High de Euclidity.
* Test Runner for Java de Microsoft.

## Paso 07
1. Crear un Proyecto con "Gradle: Create a Gradle Java Project".
2. Seleccionamos la carpeta en:
```dos
 E:\Development\tutorials\java\cucumber\Java-Cucumber-01\
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
> **Note**
> Las versiones de "Cucumber JVM: Java" y "Cucumber JVM: JUnit 4", **TIENEN** q ser iguales.
16. Borramos de "Depencies" el de "google.guava".
17. Ejecutamos un comando en la terminal llamado
```bash
gradle build
```
Y esto baja todas las dependencias, al final debe mostrar algo parecido a esto:
```diff
+ BUILD SUCCESSFUL in 29s
4 actionable tasks: 4 executed
```
## Paso 11
> **Note**
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

> Se sugiere utilizar la opción 2, por tanto la carpeta "Main" pued ser borrada.

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

7. Por confirmar este es el archivo **build.gradle**:
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
> **Note**  
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
7. Cuando se esté utilizando esta página heredada, se va a requerir el constructor y sea vista por otras clases:
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
2. Conectamos la **BasePage.jave** mediante un `extends`.
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
5. Ahora si creamos los *steps* conel archivo **FreeRangeSteps.java** dentro de "src/test/java/steps".
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
> **Note**  
> Descargamos para Chrome y/o FireFox una extensión llamado **selectorsHub**, 
> luego ubicándonos en el botón requerido, click derecho, SelctorsHub
> y `Copy Relative XPath`, el contenido lo usaremos en el paso siguiente.

## Paso 25
> **Note**  
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
Que nos abre la página y da click en el botón deseado , finalizando en la página esperada, y dándonos una respuesa exitosa:
```diff
+ BUILD SUCCESSFUL in 19s
3 actionable tasks: 3 executed
```
