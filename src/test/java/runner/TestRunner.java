package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",  //Directorio de archivos .feature
    glue = "steps",  //Paquete de las Clases de los pasos del feature
    plugin = {"pretty", "html:target/cucumber-reports"}
)   

public class TestRunner {
@AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
    
}
