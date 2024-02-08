# Java-Cucumber-01
https://perficient.udemy.com/course/selenium-con-java-y-cucumber-el-curso-definitivo/learn/lecture/41595708#overview
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
