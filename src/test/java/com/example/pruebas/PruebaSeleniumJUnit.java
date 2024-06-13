package com.example.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PruebaSeleniumJUnit {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Establecer la propiedad del sistema para GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hugo\\Desktop\\SISTEMAS\\VISUAL\\pruebas-devops\\drivers\\geckodriver.exe");

        // Inicializar FirefoxDriver con las opciones necesarias
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

        // Cargar la página HTML
        driver.get("C:\\Users\\Hugo\\Desktop\\SISTEMAS\\VISUAL\\pruebas-devops\\src\\main\\java\\index.html");
    }

    @Test
    public void pruebaTituloPagina() {
        String titulo = driver.getTitle();
        assertEquals("Pruebas Automatizadas", titulo);
    }

    @Test
    public void pruebaFormularioBusqueda() {
        // Encontrar y usar el campo de búsqueda
        WebElement campoBusqueda = driver.findElement(By.id("query"));
        WebElement botonBuscar = driver.findElement(By.cssSelector("button[type='submit']"));

        // Enviar texto al campo de búsqueda y hacer clic en el botón
        campoBusqueda.sendKeys("Selenium");
        botonBuscar.click();

        // Manejar la alerta
        Alert alerta = driver.switchTo().alert();
        String alertaTexto = alerta.getText();
        alerta.accept();

        // Verificar el contenido de la alerta
        assertTrue(alertaTexto.contains("Búsqueda realizada para: Selenium"));
    }

    @After
    public void tearDown() {
        // Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
