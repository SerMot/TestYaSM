package ru.Ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CreateCloseDriver {
    public static WebDriver driver;
    public static ru.Ya.MainPage mainPage;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new ru.Ya.MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
        String title = driver.getTitle();
        assertTrue(title.equals("Яндекс"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}