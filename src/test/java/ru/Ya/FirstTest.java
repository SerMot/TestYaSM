package ru.Ya;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/SMotrokhov/IdeaProjects/testya/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru/");
        String title = driver.getTitle();
        assertTrue(title.equals("Яндекс"));
    }

    @Test
    public void checkTest() {
        WebElement inputWeatherField = driver.findElement(By.cssSelector("input[id='text']"));
        inputWeatherField.clear();
        inputWeatherField.sendKeys("погода пенза");
        WebElement buttonFind = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonFind.click();
        WebElement pogodaAssert = driver.findElement(By.cssSelector("li[data-cid="0"] div[class='organic__url-text']"));
        String actualString = pogodaAssert.getText();
        assertTrue(actualString.contains("Погода"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
