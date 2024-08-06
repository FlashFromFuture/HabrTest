package org.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("SandBox")
    public void sandBox() {

        WebElement techSupportButton = driver.findElement(By.cssSelector("a[class='tm-footer__link']"));
        techSupportButton.click();

        WebElement helpRulses = driver.findElement(By.xpath("//*[contains(text(), 'справочном разделе')]"));
        helpRulses.click();

        WebElement sandBox = driver.findElement(By.xpath("//*[contains(text(), 'Песочница')]"));
        sandBox.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'полноправный аккаунт')]")).isDisplayed(), "О полноправном аккаунте");

    }

    @Test
    @DisplayName("Registraction")
    public void registractionButton() {

        WebElement enterButton = driver.findElement(By.cssSelector("button[type='button']"));
        enterButton.click();

        WebElement regButton = driver.findElement(By.xpath("//*[contains(text(), 'Зарегистрируйтесь')]"));
        regButton.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'shadow-box__title')]")).isDisplayed(), "Ругистрация");

    }

}
