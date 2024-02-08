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
```dos
BUILD SUCCESSFUL in 29s
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
```bash
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
## Paso 14
1. Instalamos otra Extensión 
